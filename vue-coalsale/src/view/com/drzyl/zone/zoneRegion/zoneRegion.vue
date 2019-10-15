<style lang="less" scoped>
  @import './zoneRegion.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="zoneRegionKeySearchSubmitting" @on-search="keySearchZoneRegion($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="zoneRegionQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="zoneRegionQueryForm" :model="zoneRegionQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="父ID：" prop="parentId">
                      <Input v-model="zoneRegionQuery.parentId" placeholder="输入父ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="名称：" prop="regionName">
                      <Input v-model="zoneRegionQuery.regionName" placeholder="输入名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="类型：" prop="regionType">
                      <Input v-model="zoneRegionQuery.regionType" placeholder="输入类型"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="代理：" prop="agencyId">
                      <Input v-model="zoneRegionQuery.agencyId" placeholder="输入代理"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="状态：" prop="status">
                      <Input v-model="zoneRegionQuery.status" placeholder="输入状态"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryZoneRegion()" :loading="zoneRegionQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetZoneRegionQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addZoneRegion()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upZoneRegion()" v-if="zoneRegionSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delZoneRegion()" v-if="zoneRegionSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailZoneRegion()" v-if="zoneRegionSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="zoneRegionColumnsChecked" @on-change="changeZoneRegionColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="parentId">父ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="regionName">名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="regionType">类型</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="agencyId">代理</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="status">状态</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanZoneRegionColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetZoneRegionColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="zoneRegionColumns" :data="zoneRegionSet" @on-selection-change="setZoneRegionSelectRow($event)" @on-row-dblclick="dblclickDetailZoneRegion($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="zoneRegionCount" :current="zoneRegionPage" :page-size-opts="[10, 30, 50]" @on-change="zoneRegionPageIndexChange($event)" @on-page-size-change="zoneRegionPageSizeChange($event)" v-if="zoneRegionPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="zoneRegionRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="zoneRegionSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="zoneRegionEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑省市区
        </p>
        <Form class="pro-margin-top-20" ref="zoneRegionForm" :model="zoneRegion" :rules="zoneRegionFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="父ID：" prop="parentId">
                <Input v-model="zoneRegion.parentId" placeholder="输入父ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="名称：" prop="regionName">
                <Input v-model="zoneRegion.regionName" placeholder="输入名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="类型：" prop="regionType">
                <Input v-model="zoneRegion.regionType" placeholder="输入类型"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="代理：" prop="agencyId">
                <Input v-model="zoneRegion.agencyId" placeholder="输入代理"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="状态：" prop="status">
                <Input v-model="zoneRegion.status" placeholder="输入状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toZoneRegionList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetZoneRegionForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="zoneRegionSubmitting" @click="saveZoneRegionForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="zoneRegionSubmitting" @click="saveAddZoneRegionForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="zoneRegionDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          省市区详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ zoneRegion.regionId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>父ID：{{ zoneRegion.parentId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>名称：{{ zoneRegion.regionName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>类型：{{ zoneRegion.regionType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>代理：{{ zoneRegion.agencyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>状态：{{ zoneRegion.status }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import ZoneRegion from '@/view/com/drzyl/zone/zoneRegion/ZoneRegion'
import ZoneRegionQuery from '@/view/com/drzyl/zone/zoneRegion/ZoneRegionQuery'

export default {
  data () {
    return {
      zoneRegionColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '父ID', key: 'parentId', minWidth: 200, sortable: true },
        { title: '名称', key: 'regionName', minWidth: 200, sortable: true },
        { title: '类型', key: 'regionType', minWidth: 200, sortable: true },
        { title: '代理', key: 'agencyId', minWidth: 200, sortable: true },
        { title: '状态', key: 'status', minWidth: 200, sortable: true }
      ],
      zoneRegionFormValidate: 
      },
      zoneRegionColumnsChecked: [
        'regionId',
        'parentId',
        'regionName',
        'regionType',
        'agencyId',
        'status'
      ],
      zoneRegionColumnsNexus: {
        regionId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        parentId: { title: '父ID', key: 'parentId', minWidth: 200, sortable: true },
        regionName: { title: '名称', key: 'regionName', minWidth: 200, sortable: true },
        regionType: { title: '类型', key: 'regionType', minWidth: 200, sortable: true },
        agencyId: { title: '代理', key: 'agencyId', minWidth: 200, sortable: true },
        status: { title: '状态', key: 'status', minWidth: 200, sortable: true }
      },
      zoneRegionSet: [],
      zoneRegionCount: 0,
      zoneRegionRows: 10,
      zoneRegionPage: 1,
      zoneRegionSelectRow: [],
      zoneRegionSelectRowLength: 0,
      zoneRegion: new ZoneRegion(),
      zoneRegionQuery: new ZoneRegionQuery(),
      zoneRegionSpinShow: false,
      zoneRegionPageShow: true,
      zoneRegionEditModalShow: false,
      zoneRegionSubmitting: false,
      zoneRegionContinue: false,
      zoneRegionDetailDrawerShow: false,
      zoneRegionQueryPoptipShow: false,
      zoneRegionQuerySubmitting: false,
      zoneRegionKeySearchSubmitting: false,
      zoneRegionKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('zoneRegionStore', [
    ]),
    ...mapGetters('zoneRegionStore', [
    ])
  },
  methods: {
    ...mapMutations('zoneRegionStore', [
    ]),
    ...mapActions('zoneRegionStore', [
      'saveZoneRegion',
      'updateZoneRegion',
      'batchRemoveZoneRegion',
      'getZoneRegionByPk',
      'queryZoneRegion',
      'pagingQueryZoneRegion'
    ]),
    addZoneRegion () {
      this.zoneRegionEditModalShow = true
      this.zoneRegion = new ZoneRegion()
    },
    upZoneRegion () {
      this.zoneRegionEditModalShow = true
      let zoneRegionEdit = new ZoneRegion()
      zoneRegionEdit.regionId = this.zoneRegionSelectRow[0].regionId
      this.getZoneRegionByPk(zoneRegionEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneRegion, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toZoneRegionList () {
      this.zoneRegionEditModalShow = false
      this.resetZoneRegionForm()
      this.getZoneRegionSet()
    },
    resetZoneRegionForm () {
      this.$refs.zoneRegionForm.resetFields()
    },
    saveZoneRegionForm () {
      this.zoneRegionContinue = false
      this.submitZoneRegionForm()
    },
    saveAddZoneRegionForm () {
      this.zoneRegionContinue = true
      this.submitZoneRegionForm()
    },
    submitZoneRegionForm () {
      this.zoneRegionSubmitting = true
      this.$refs.zoneRegionForm.validate((valid) => {
        if (valid) {
          if (this.zoneRegion.regionId) {
            this.updateZoneRegion(this.zoneRegion).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '省市区信息修改成功.', duration: 3 })
                this.resetZoneRegionForm()
                this.zoneRegion = new ZoneRegion()
                this.zoneRegionSubmitting = false
                if (!this.zoneRegionContinue) {
                  this.toZoneRegionList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.zoneRegionSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.zoneRegionSubmitting = false }, 3000)
            })
          } else {
            this.saveZoneRegion(this.zoneRegion).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '省市区信息保存成功.', duration: 3 })
                this.resetZoneRegionForm()
                this.zoneRegion = new ZoneRegion()
                this.zoneRegionSubmitting = false
                if (!this.zoneRegionContinue) {
                  this.toZoneRegionList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.zoneRegionSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.zoneRegionSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.zoneRegionSubmitting = false }, 3000)
        }
      })
    },
    delZoneRegion () {
      this.zoneRegionSpinShow = true
      this.batchRemoveZoneRegion(this.zoneRegionSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '省市区信息删除成功.', duration: 3 })
          this.setZoneRegionSelectRow([])
          this.getZoneRegionSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
      })
    },
    detailZoneRegion () {
      this.zoneRegionDetailDrawerShow = true
      let zoneRegionDetail = new ZoneRegion()
      zoneRegionDetail.regionId = this.zoneRegionSelectRow[0].regionId
      this.getZoneRegionByPk(zoneRegionDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneRegion, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailZoneRegion (rowData) {
      this.zoneRegionDetailDrawerShow = true
      let zoneRegionDetail = new ZoneRegion()
      zoneRegionDetail.regionId = rowData.regionId
      this.getZoneRegionByPk(zoneRegionDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneRegion, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getZoneRegionSet () {
      this.zoneRegionSpinShow = true
      this.zoneRegionPageShow = true
      this.pagingQueryZoneRegion({ zoneRegionQuery: {}, rows: this.zoneRegionRows, page: this.zoneRegionPage }).then(res => {
        if (res.data.success) {
          this.zoneRegionSet = res.data.data
          this.zoneRegionCount = res.data.count
          this.setZoneRegionSelectRow([])
          setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
      })
    },
    keySearchZoneRegion (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.zoneRegionKeySearchSubmitting = true
        this.zoneRegionPageShow = false
        this.zoneRegionSpinShow = true
        let zoneRegionQueryKeySearch = new ZoneRegionQuery()
        zoneRegionQueryKeySearch.parentIdAndKeyLike = '%' + keyLikeValue + '%'
        zoneRegionQueryKeySearch.regionNameOrKeyLike = '%' + keyLikeValue + '%'
        zoneRegionQueryKeySearch.regionTypeOrKeyLike = '%' + keyLikeValue + '%'
        zoneRegionQueryKeySearch.agencyIdOrKeyLike = '%' + keyLikeValue + '%'
        zoneRegionQueryKeySearch.statusOrKeyLike = '%' + keyLikeValue + '%'
        this.queryZoneRegion(zoneRegionQueryKeySearch).then(res => {
          if (res.data.success) {
            this.zoneRegionSet = res.data.data
            this.zoneRegionCount = res.data.count
            this.setZoneRegionSelectRow([])
            setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
            setTimeout(() => { this.zoneRegionKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
            setTimeout(() => { this.zoneRegionKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
          setTimeout(() => { this.zoneRegionKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.zoneRegionKeySearchClickRate++
        if (this.zoneRegionKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.zoneRegionKeySearchClickRate = 0
        }
      }
    },
    vagueQueryZoneRegion () {
      this.zoneRegionQuerySubmitting = true
      this.zoneRegionPageShow = false
      this.zoneRegionSpinShow = true
      this.zoneRegionQueryPoptipShow = false
      this.queryZoneRegion(this.zoneRegionQuery).then(res => {
        if (res.data.success) {
          this.zoneRegionSet = res.data.data
          this.zoneRegionCount = res.data.count
          this.setZoneRegionSelectRow([])
          setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
          setTimeout(() => { this.zoneRegionQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
          setTimeout(() => { this.zoneRegionQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneRegionSpinShow = false }, 700)
        setTimeout(() => { this.zoneRegionQuerySubmitting = false }, 5000)
      })
    },
    resetZoneRegionQueryForm () {
      this.$refs.zoneRegionQueryForm.resetFields()
    },
    setZoneRegionSelectRow (list) {
      this.zoneRegionSelectRow = list
      this.zoneRegionSelectRowLength = list.length
    },
    zoneRegionPageIndexChange (pageIndex) {
      this.zoneRegionPage = pageIndex
      this.getZoneRegionSet()
    },
    zoneRegionPageSizeChange (pageSize) {
      this.zoneRegionRows = pageSize
      this.zoneRegionPage = 1
      this.getZoneRegionSet()
    },
    zoneRegionRefresh () {
      this.zoneRegionPage = 1
      this.getZoneRegionSet()
    },
    changeZoneRegionColumns () {
      this.zoneRegionColumns = []
      this.zoneRegionColumnsChecked.forEach(col => this.zoneRegionColumns.push(this.zoneRegionColumnsNexus[col]))
    },
    cleanZoneRegionColumns () {
      this.zoneRegionColumnsChecked = [
        'regionId'
      ]
      this.zoneRegionColumns = []
      this.zoneRegionColumnsChecked.forEach(col => this.zoneRegionColumns.push(this.zoneRegionColumnsNexus[col]))
    },
    resetZoneRegionColumns () {
      this.zoneRegionColumnsChecked = [
        'regionId',
        'parentId',
        'regionName',
        'regionType',
        'agencyId',
        'status'
      ]
      this.zoneRegionColumns = []
      this.zoneRegionColumnsChecked.forEach(col => this.zoneRegionColumns.push(this.zoneRegionColumnsNexus[col]))
    }
  },
  mounted () {
    this.getZoneRegionSet()
  }
}
</script>

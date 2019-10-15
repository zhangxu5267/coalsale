<style lang="less" scoped>
  @import './zoneAreaRegionTepe.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="zoneAreaRegionTepeKeySearchSubmitting" @on-search="keySearchZoneAreaRegionTepe($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="zoneAreaRegionTepeQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="zoneAreaRegionTepeQueryForm" :model="zoneAreaRegionTepeQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="所属机构：" prop="orgId">
                      <Input v-model="zoneAreaRegionTepeQuery.orgId" placeholder="输入所属机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="省市区ID：" prop="crmRegionId">
                      <Input v-model="zoneAreaRegionTepeQuery.crmRegionId" placeholder="输入省市区ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="区域ID：" prop="crmAreaId">
                      <Input v-model="zoneAreaRegionTepeQuery.crmAreaId" placeholder="输入区域ID"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryZoneAreaRegionTepe()" :loading="zoneAreaRegionTepeQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetZoneAreaRegionTepeQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addZoneAreaRegionTepe()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upZoneAreaRegionTepe()" v-if="zoneAreaRegionTepeSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delZoneAreaRegionTepe()" v-if="zoneAreaRegionTepeSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailZoneAreaRegionTepe()" v-if="zoneAreaRegionTepeSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="zoneAreaRegionTepeColumnsChecked" @on-change="changeZoneAreaRegionTepeColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="orgId">所属机构</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="crmRegionId">省市区ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="crmAreaId">区域ID</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanZoneAreaRegionTepeColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetZoneAreaRegionTepeColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="zoneAreaRegionTepeColumns" :data="zoneAreaRegionTepeSet" @on-selection-change="setZoneAreaRegionTepeSelectRow($event)" @on-row-dblclick="dblclickDetailZoneAreaRegionTepe($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="zoneAreaRegionTepeCount" :current="zoneAreaRegionTepePage" :page-size-opts="[10, 30, 50]" @on-change="zoneAreaRegionTepePageIndexChange($event)" @on-page-size-change="zoneAreaRegionTepePageSizeChange($event)" v-if="zoneAreaRegionTepePageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="zoneAreaRegionTepeRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="zoneAreaRegionTepeSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="zoneAreaRegionTepeEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑区域-省市区中间表
        </p>
        <Form class="pro-margin-top-20" ref="zoneAreaRegionTepeForm" :model="zoneAreaRegionTepe" :rules="zoneAreaRegionTepeFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="所属机构：" prop="orgId">
                <Input v-model="zoneAreaRegionTepe.orgId" placeholder="输入所属机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="省市区ID：" prop="crmRegionId">
                <Input v-model="zoneAreaRegionTepe.crmRegionId" placeholder="输入省市区ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="区域ID：" prop="crmAreaId">
                <Input v-model="zoneAreaRegionTepe.crmAreaId" placeholder="输入区域ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toZoneAreaRegionTepeList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetZoneAreaRegionTepeForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="zoneAreaRegionTepeSubmitting" @click="saveZoneAreaRegionTepeForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="zoneAreaRegionTepeSubmitting" @click="saveAddZoneAreaRegionTepeForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="zoneAreaRegionTepeDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          区域-省市区中间表详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ zoneAreaRegionTepe.id }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>所属机构：{{ zoneAreaRegionTepe.orgId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>省市区ID：{{ zoneAreaRegionTepe.crmRegionId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>区域ID：{{ zoneAreaRegionTepe.crmAreaId }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import ZoneAreaRegionTepe from '@/view/com/drzyl/zone/zoneAreaRegionTepe/ZoneAreaRegionTepe'
import ZoneAreaRegionTepeQuery from '@/view/com/drzyl/zone/zoneAreaRegionTepe/ZoneAreaRegionTepeQuery'

export default {
  data () {
    return {
      zoneAreaRegionTepeColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '所属机构', key: 'orgId', minWidth: 200, sortable: true },
        { title: '省市区ID', key: 'crmRegionId', minWidth: 200, sortable: true },
        { title: '区域ID', key: 'crmAreaId', minWidth: 200, sortable: true }
      ],
      zoneAreaRegionTepeFormValidate: 
      },
      zoneAreaRegionTepeColumnsChecked: [
        'id',
        'orgId',
        'crmRegionId',
        'crmAreaId'
      ],
      zoneAreaRegionTepeColumnsNexus: {
        id: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        orgId: { title: '所属机构', key: 'orgId', minWidth: 200, sortable: true },
        crmRegionId: { title: '省市区ID', key: 'crmRegionId', minWidth: 200, sortable: true },
        crmAreaId: { title: '区域ID', key: 'crmAreaId', minWidth: 200, sortable: true }
      },
      zoneAreaRegionTepeSet: [],
      zoneAreaRegionTepeCount: 0,
      zoneAreaRegionTepeRows: 10,
      zoneAreaRegionTepePage: 1,
      zoneAreaRegionTepeSelectRow: [],
      zoneAreaRegionTepeSelectRowLength: 0,
      zoneAreaRegionTepe: new ZoneAreaRegionTepe(),
      zoneAreaRegionTepeQuery: new ZoneAreaRegionTepeQuery(),
      zoneAreaRegionTepeSpinShow: false,
      zoneAreaRegionTepePageShow: true,
      zoneAreaRegionTepeEditModalShow: false,
      zoneAreaRegionTepeSubmitting: false,
      zoneAreaRegionTepeContinue: false,
      zoneAreaRegionTepeDetailDrawerShow: false,
      zoneAreaRegionTepeQueryPoptipShow: false,
      zoneAreaRegionTepeQuerySubmitting: false,
      zoneAreaRegionTepeKeySearchSubmitting: false,
      zoneAreaRegionTepeKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('zoneAreaRegionTepeStore', [
    ]),
    ...mapGetters('zoneAreaRegionTepeStore', [
    ])
  },
  methods: {
    ...mapMutations('zoneAreaRegionTepeStore', [
    ]),
    ...mapActions('zoneAreaRegionTepeStore', [
      'saveZoneAreaRegionTepe',
      'updateZoneAreaRegionTepe',
      'batchRemoveZoneAreaRegionTepe',
      'getZoneAreaRegionTepeByPk',
      'queryZoneAreaRegionTepe',
      'pagingQueryZoneAreaRegionTepe'
    ]),
    addZoneAreaRegionTepe () {
      this.zoneAreaRegionTepeEditModalShow = true
      this.zoneAreaRegionTepe = new ZoneAreaRegionTepe()
    },
    upZoneAreaRegionTepe () {
      this.zoneAreaRegionTepeEditModalShow = true
      let zoneAreaRegionTepeEdit = new ZoneAreaRegionTepe()
      zoneAreaRegionTepeEdit.id = this.zoneAreaRegionTepeSelectRow[0].id
      this.getZoneAreaRegionTepeByPk(zoneAreaRegionTepeEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneAreaRegionTepe, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toZoneAreaRegionTepeList () {
      this.zoneAreaRegionTepeEditModalShow = false
      this.resetZoneAreaRegionTepeForm()
      this.getZoneAreaRegionTepeSet()
    },
    resetZoneAreaRegionTepeForm () {
      this.$refs.zoneAreaRegionTepeForm.resetFields()
    },
    saveZoneAreaRegionTepeForm () {
      this.zoneAreaRegionTepeContinue = false
      this.submitZoneAreaRegionTepeForm()
    },
    saveAddZoneAreaRegionTepeForm () {
      this.zoneAreaRegionTepeContinue = true
      this.submitZoneAreaRegionTepeForm()
    },
    submitZoneAreaRegionTepeForm () {
      this.zoneAreaRegionTepeSubmitting = true
      this.$refs.zoneAreaRegionTepeForm.validate((valid) => {
        if (valid) {
          if (this.zoneAreaRegionTepe.id) {
            this.updateZoneAreaRegionTepe(this.zoneAreaRegionTepe).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '区域-省市区中间表信息修改成功.', duration: 3 })
                this.resetZoneAreaRegionTepeForm()
                this.zoneAreaRegionTepe = new ZoneAreaRegionTepe()
                this.zoneAreaRegionTepeSubmitting = false
                if (!this.zoneAreaRegionTepeContinue) {
                  this.toZoneAreaRegionTepeList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.zoneAreaRegionTepeSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.zoneAreaRegionTepeSubmitting = false }, 3000)
            })
          } else {
            this.saveZoneAreaRegionTepe(this.zoneAreaRegionTepe).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '区域-省市区中间表信息保存成功.', duration: 3 })
                this.resetZoneAreaRegionTepeForm()
                this.zoneAreaRegionTepe = new ZoneAreaRegionTepe()
                this.zoneAreaRegionTepeSubmitting = false
                if (!this.zoneAreaRegionTepeContinue) {
                  this.toZoneAreaRegionTepeList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.zoneAreaRegionTepeSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.zoneAreaRegionTepeSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.zoneAreaRegionTepeSubmitting = false }, 3000)
        }
      })
    },
    delZoneAreaRegionTepe () {
      this.zoneAreaRegionTepeSpinShow = true
      this.batchRemoveZoneAreaRegionTepe(this.zoneAreaRegionTepeSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '区域-省市区中间表信息删除成功.', duration: 3 })
          this.setZoneAreaRegionTepeSelectRow([])
          this.getZoneAreaRegionTepeSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
      })
    },
    detailZoneAreaRegionTepe () {
      this.zoneAreaRegionTepeDetailDrawerShow = true
      let zoneAreaRegionTepeDetail = new ZoneAreaRegionTepe()
      zoneAreaRegionTepeDetail.id = this.zoneAreaRegionTepeSelectRow[0].id
      this.getZoneAreaRegionTepeByPk(zoneAreaRegionTepeDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneAreaRegionTepe, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailZoneAreaRegionTepe (rowData) {
      this.zoneAreaRegionTepeDetailDrawerShow = true
      let zoneAreaRegionTepeDetail = new ZoneAreaRegionTepe()
      zoneAreaRegionTepeDetail.id = rowData.id
      this.getZoneAreaRegionTepeByPk(zoneAreaRegionTepeDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneAreaRegionTepe, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getZoneAreaRegionTepeSet () {
      this.zoneAreaRegionTepeSpinShow = true
      this.zoneAreaRegionTepePageShow = true
      this.pagingQueryZoneAreaRegionTepe({ zoneAreaRegionTepeQuery: {}, rows: this.zoneAreaRegionTepeRows, page: this.zoneAreaRegionTepePage }).then(res => {
        if (res.data.success) {
          this.zoneAreaRegionTepeSet = res.data.data
          this.zoneAreaRegionTepeCount = res.data.count
          this.setZoneAreaRegionTepeSelectRow([])
          setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
      })
    },
    keySearchZoneAreaRegionTepe (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.zoneAreaRegionTepeKeySearchSubmitting = true
        this.zoneAreaRegionTepePageShow = false
        this.zoneAreaRegionTepeSpinShow = true
        let zoneAreaRegionTepeQueryKeySearch = new ZoneAreaRegionTepeQuery()
        zoneAreaRegionTepeQueryKeySearch.orgIdAndKeyLike = '%' + keyLikeValue + '%'
        zoneAreaRegionTepeQueryKeySearch.crmRegionIdOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaRegionTepeQueryKeySearch.crmAreaIdOrKeyLike = '%' + keyLikeValue + '%'
        this.queryZoneAreaRegionTepe(zoneAreaRegionTepeQueryKeySearch).then(res => {
          if (res.data.success) {
            this.zoneAreaRegionTepeSet = res.data.data
            this.zoneAreaRegionTepeCount = res.data.count
            this.setZoneAreaRegionTepeSelectRow([])
            setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
            setTimeout(() => { this.zoneAreaRegionTepeKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
            setTimeout(() => { this.zoneAreaRegionTepeKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
          setTimeout(() => { this.zoneAreaRegionTepeKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.zoneAreaRegionTepeKeySearchClickRate++
        if (this.zoneAreaRegionTepeKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.zoneAreaRegionTepeKeySearchClickRate = 0
        }
      }
    },
    vagueQueryZoneAreaRegionTepe () {
      this.zoneAreaRegionTepeQuerySubmitting = true
      this.zoneAreaRegionTepePageShow = false
      this.zoneAreaRegionTepeSpinShow = true
      this.zoneAreaRegionTepeQueryPoptipShow = false
      this.queryZoneAreaRegionTepe(this.zoneAreaRegionTepeQuery).then(res => {
        if (res.data.success) {
          this.zoneAreaRegionTepeSet = res.data.data
          this.zoneAreaRegionTepeCount = res.data.count
          this.setZoneAreaRegionTepeSelectRow([])
          setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
          setTimeout(() => { this.zoneAreaRegionTepeQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
          setTimeout(() => { this.zoneAreaRegionTepeQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneAreaRegionTepeSpinShow = false }, 700)
        setTimeout(() => { this.zoneAreaRegionTepeQuerySubmitting = false }, 5000)
      })
    },
    resetZoneAreaRegionTepeQueryForm () {
      this.$refs.zoneAreaRegionTepeQueryForm.resetFields()
    },
    setZoneAreaRegionTepeSelectRow (list) {
      this.zoneAreaRegionTepeSelectRow = list
      this.zoneAreaRegionTepeSelectRowLength = list.length
    },
    zoneAreaRegionTepePageIndexChange (pageIndex) {
      this.zoneAreaRegionTepePage = pageIndex
      this.getZoneAreaRegionTepeSet()
    },
    zoneAreaRegionTepePageSizeChange (pageSize) {
      this.zoneAreaRegionTepeRows = pageSize
      this.zoneAreaRegionTepePage = 1
      this.getZoneAreaRegionTepeSet()
    },
    zoneAreaRegionTepeRefresh () {
      this.zoneAreaRegionTepePage = 1
      this.getZoneAreaRegionTepeSet()
    },
    changeZoneAreaRegionTepeColumns () {
      this.zoneAreaRegionTepeColumns = []
      this.zoneAreaRegionTepeColumnsChecked.forEach(col => this.zoneAreaRegionTepeColumns.push(this.zoneAreaRegionTepeColumnsNexus[col]))
    },
    cleanZoneAreaRegionTepeColumns () {
      this.zoneAreaRegionTepeColumnsChecked = [
        'id'
      ]
      this.zoneAreaRegionTepeColumns = []
      this.zoneAreaRegionTepeColumnsChecked.forEach(col => this.zoneAreaRegionTepeColumns.push(this.zoneAreaRegionTepeColumnsNexus[col]))
    },
    resetZoneAreaRegionTepeColumns () {
      this.zoneAreaRegionTepeColumnsChecked = [
        'id',
        'orgId',
        'crmRegionId',
        'crmAreaId'
      ]
      this.zoneAreaRegionTepeColumns = []
      this.zoneAreaRegionTepeColumnsChecked.forEach(col => this.zoneAreaRegionTepeColumns.push(this.zoneAreaRegionTepeColumnsNexus[col]))
    }
  },
  mounted () {
    this.getZoneAreaRegionTepeSet()
  }
}
</script>

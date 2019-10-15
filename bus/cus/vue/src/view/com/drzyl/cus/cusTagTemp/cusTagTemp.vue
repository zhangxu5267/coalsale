<style lang="less" scoped>
  @import './cusTagTemp.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="cusTagTempKeySearchSubmitting" @on-search="keySearchCusTagTemp($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="cusTagTempQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="cusTagTempQueryForm" :model="cusTagTempQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="客户ID：" prop="cusTagId">
                      <Input v-model="cusTagTempQuery.cusTagId" placeholder="输入客户ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="标签ID：" prop="cusBaseId">
                      <Input v-model="cusTagTempQuery.cusBaseId" placeholder="输入标签ID"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryCusTagTemp()" :loading="cusTagTempQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetCusTagTempQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusTagTemp()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusTagTemp()" v-if="cusTagTempSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusTagTemp()" v-if="cusTagTempSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusTagTemp()" v-if="cusTagTempSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="cusTagTempColumnsChecked" @on-change="changeCusTagTempColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusTagId">客户ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusBaseId">标签ID</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusTagTempColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusTagTempColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="cusTagTempColumns" :data="cusTagTempSet" @on-selection-change="setCusTagTempSelectRow($event)" @on-row-dblclick="dblclickDetailCusTagTemp($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusTagTempCount" :current="cusTagTempPage" :page-size-opts="[10, 30, 50]" @on-change="cusTagTempPageIndexChange($event)" @on-page-size-change="cusTagTempPageSizeChange($event)" v-if="cusTagTempPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="cusTagTempRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="cusTagTempSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="cusTagTempEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑客户标签中间表
        </p>
        <Form class="pro-margin-top-20" ref="cusTagTempForm" :model="cusTagTemp" :rules="cusTagTempFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户ID：" prop="cusTagId">
                <Input v-model="cusTagTemp.cusTagId" placeholder="输入客户ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="标签ID：" prop="cusBaseId">
                <Input v-model="cusTagTemp.cusBaseId" placeholder="输入标签ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toCusTagTempList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetCusTagTempForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusTagTempSubmitting" @click="saveCusTagTempForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusTagTempSubmitting" @click="saveAddCusTagTempForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="cusTagTempDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户标签中间表详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ cusTagTemp.cusTagTempId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户ID：{{ cusTagTemp.cusTagId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>标签ID：{{ cusTagTemp.cusBaseId }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusTagTemp from '@/view/com/drzyl/cus/cusTagTemp/CusTagTemp'
import CusTagTempQuery from '@/view/com/drzyl/cus/cusTagTemp/CusTagTempQuery'

export default {
  data () {
    return {
      cusTagTempColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '客户ID', key: 'cusTagId', minWidth: 200, sortable: true },
        { title: '标签ID', key: 'cusBaseId', minWidth: 200, sortable: true }
      ],
      cusTagTempFormValidate: 
      },
      cusTagTempColumnsChecked: [
        'cusTagTempId',
        'cusTagId',
        'cusBaseId'
      ],
      cusTagTempColumnsNexus: {
        cusTagTempId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        cusTagId: { title: '客户ID', key: 'cusTagId', minWidth: 200, sortable: true },
        cusBaseId: { title: '标签ID', key: 'cusBaseId', minWidth: 200, sortable: true }
      },
      cusTagTempSet: [],
      cusTagTempCount: 0,
      cusTagTempRows: 10,
      cusTagTempPage: 1,
      cusTagTempSelectRow: [],
      cusTagTempSelectRowLength: 0,
      cusTagTemp: new CusTagTemp(),
      cusTagTempQuery: new CusTagTempQuery(),
      cusTagTempSpinShow: false,
      cusTagTempPageShow: true,
      cusTagTempEditModalShow: false,
      cusTagTempSubmitting: false,
      cusTagTempContinue: false,
      cusTagTempDetailDrawerShow: false,
      cusTagTempQueryPoptipShow: false,
      cusTagTempQuerySubmitting: false,
      cusTagTempKeySearchSubmitting: false,
      cusTagTempKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('cusTagTempStore', [
    ]),
    ...mapGetters('cusTagTempStore', [
    ])
  },
  methods: {
    ...mapMutations('cusTagTempStore', [
    ]),
    ...mapActions('cusTagTempStore', [
      'saveCusTagTemp',
      'updateCusTagTemp',
      'batchRemoveCusTagTemp',
      'getCusTagTempByPk',
      'queryCusTagTemp',
      'pagingQueryCusTagTemp'
    ]),
    addCusTagTemp () {
      this.cusTagTempEditModalShow = true
      this.cusTagTemp = new CusTagTemp()
    },
    upCusTagTemp () {
      this.cusTagTempEditModalShow = true
      let cusTagTempEdit = new CusTagTemp()
      cusTagTempEdit.cusTagTempId = this.cusTagTempSelectRow[0].cusTagTempId
      this.getCusTagTempByPk(cusTagTempEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.cusTagTemp, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toCusTagTempList () {
      this.cusTagTempEditModalShow = false
      this.resetCusTagTempForm()
      this.getCusTagTempSet()
    },
    resetCusTagTempForm () {
      this.$refs.cusTagTempForm.resetFields()
    },
    saveCusTagTempForm () {
      this.cusTagTempContinue = false
      this.submitCusTagTempForm()
    },
    saveAddCusTagTempForm () {
      this.cusTagTempContinue = true
      this.submitCusTagTempForm()
    },
    submitCusTagTempForm () {
      this.cusTagTempSubmitting = true
      this.$refs.cusTagTempForm.validate((valid) => {
        if (valid) {
          if (this.cusTagTemp.cusTagTempId) {
            this.updateCusTagTemp(this.cusTagTemp).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户标签中间表信息修改成功.', duration: 3 })
                this.resetCusTagTempForm()
                this.cusTagTemp = new CusTagTemp()
                this.cusTagTempSubmitting = false
                if (!this.cusTagTempContinue) {
                  this.toCusTagTempList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusTagTempSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusTagTempSubmitting = false }, 3000)
            })
          } else {
            this.saveCusTagTemp(this.cusTagTemp).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户标签中间表信息保存成功.', duration: 3 })
                this.resetCusTagTempForm()
                this.cusTagTemp = new CusTagTemp()
                this.cusTagTempSubmitting = false
                if (!this.cusTagTempContinue) {
                  this.toCusTagTempList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusTagTempSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusTagTempSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.cusTagTempSubmitting = false }, 3000)
        }
      })
    },
    delCusTagTemp () {
      this.cusTagTempSpinShow = true
      this.batchRemoveCusTagTemp(this.cusTagTempSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '客户标签中间表信息删除成功.', duration: 3 })
          this.setCusTagTempSelectRow([])
          this.getCusTagTempSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
      })
    },
    detailCusTagTemp () {
      this.cusTagTempDetailDrawerShow = true
      let cusTagTempDetail = new CusTagTemp()
      cusTagTempDetail.cusTagTempId = this.cusTagTempSelectRow[0].cusTagTempId
      this.getCusTagTempByPk(cusTagTempDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusTagTemp, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailCusTagTemp (rowData) {
      this.cusTagTempDetailDrawerShow = true
      let cusTagTempDetail = new CusTagTemp()
      cusTagTempDetail.cusTagTempId = rowData.cusTagTempId
      this.getCusTagTempByPk(cusTagTempDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusTagTemp, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getCusTagTempSet () {
      this.cusTagTempSpinShow = true
      this.cusTagTempPageShow = true
      this.pagingQueryCusTagTemp({ cusTagTempQuery: {}, rows: this.cusTagTempRows, page: this.cusTagTempPage }).then(res => {
        if (res.data.success) {
          this.cusTagTempSet = res.data.data
          this.cusTagTempCount = res.data.count
          this.setCusTagTempSelectRow([])
          setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
      })
    },
    keySearchCusTagTemp (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.cusTagTempKeySearchSubmitting = true
        this.cusTagTempPageShow = false
        this.cusTagTempSpinShow = true
        let cusTagTempQueryKeySearch = new CusTagTempQuery()
        cusTagTempQueryKeySearch.cusTagIdAndKeyLike = '%' + keyLikeValue + '%'
        cusTagTempQueryKeySearch.cusBaseIdOrKeyLike = '%' + keyLikeValue + '%'
        this.queryCusTagTemp(cusTagTempQueryKeySearch).then(res => {
          if (res.data.success) {
            this.cusTagTempSet = res.data.data
            this.cusTagTempCount = res.data.count
            this.setCusTagTempSelectRow([])
            setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
            setTimeout(() => { this.cusTagTempKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
            setTimeout(() => { this.cusTagTempKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
          setTimeout(() => { this.cusTagTempKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.cusTagTempKeySearchClickRate++
        if (this.cusTagTempKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.cusTagTempKeySearchClickRate = 0
        }
      }
    },
    vagueQueryCusTagTemp () {
      this.cusTagTempQuerySubmitting = true
      this.cusTagTempPageShow = false
      this.cusTagTempSpinShow = true
      this.cusTagTempQueryPoptipShow = false
      this.queryCusTagTemp(this.cusTagTempQuery).then(res => {
        if (res.data.success) {
          this.cusTagTempSet = res.data.data
          this.cusTagTempCount = res.data.count
          this.setCusTagTempSelectRow([])
          setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
          setTimeout(() => { this.cusTagTempQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
          setTimeout(() => { this.cusTagTempQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusTagTempSpinShow = false }, 700)
        setTimeout(() => { this.cusTagTempQuerySubmitting = false }, 5000)
      })
    },
    resetCusTagTempQueryForm () {
      this.$refs.cusTagTempQueryForm.resetFields()
    },
    setCusTagTempSelectRow (list) {
      this.cusTagTempSelectRow = list
      this.cusTagTempSelectRowLength = list.length
    },
    cusTagTempPageIndexChange (pageIndex) {
      this.cusTagTempPage = pageIndex
      this.getCusTagTempSet()
    },
    cusTagTempPageSizeChange (pageSize) {
      this.cusTagTempRows = pageSize
      this.cusTagTempPage = 1
      this.getCusTagTempSet()
    },
    cusTagTempRefresh () {
      this.cusTagTempPage = 1
      this.getCusTagTempSet()
    },
    changeCusTagTempColumns () {
      this.cusTagTempColumns = []
      this.cusTagTempColumnsChecked.forEach(col => this.cusTagTempColumns.push(this.cusTagTempColumnsNexus[col]))
    },
    cleanCusTagTempColumns () {
      this.cusTagTempColumnsChecked = [
        'cusTagTempId'
      ]
      this.cusTagTempColumns = []
      this.cusTagTempColumnsChecked.forEach(col => this.cusTagTempColumns.push(this.cusTagTempColumnsNexus[col]))
    },
    resetCusTagTempColumns () {
      this.cusTagTempColumnsChecked = [
        'cusTagTempId',
        'cusTagId',
        'cusBaseId'
      ]
      this.cusTagTempColumns = []
      this.cusTagTempColumnsChecked.forEach(col => this.cusTagTempColumns.push(this.cusTagTempColumnsNexus[col]))
    }
  },
  mounted () {
    this.getCusTagTempSet()
  }
}
</script>

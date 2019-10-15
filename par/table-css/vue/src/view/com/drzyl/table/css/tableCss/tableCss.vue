<style lang="less" scoped>
  @import './tableCss.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="tableCssKeySearchSubmitting" @on-search="keySearchTableCss($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="tableCssQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="tableCssQueryForm" :model="tableCssQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="创建账号：" prop="createId">
                      <Input v-model="tableCssQuery.createId" placeholder="输入创建账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="表格标识：" prop="tableKey">
                      <Input v-model="tableCssQuery.tableKey" placeholder="输入表格标识"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="json样式：" prop="context">
                      <Input v-model="tableCssQuery.context" placeholder="输入json样式"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryTableCss()" :loading="tableCssQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetTableCssQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addTableCss()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upTableCss()" v-if="tableCssSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delTableCss()" v-if="tableCssSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailTableCss()" v-if="tableCssSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="tableCssColumnsChecked" @on-change="changeTableCssColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="createId">创建账号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="tableKey">表格标识</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="context">json样式</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanTableCssColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetTableCssColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="tableCssColumns" :data="tableCssSet" @on-selection-change="setTableCssSelectRow($event)" @on-row-dblclick="dblclickDetailTableCss($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="tableCssCount" :current="tableCssPage" :page-size-opts="[10, 30, 50]" @on-change="tableCssPageIndexChange($event)" @on-page-size-change="tableCssPageSizeChange($event)" v-if="tableCssPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="tableCssRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="tableCssSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="tableCssEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑页面表格样式
        </p>
        <Form class="pro-margin-top-20" ref="tableCssForm" :model="tableCss" :rules="tableCssFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建账号：" prop="createId">
                <Input v-model="tableCss.createId" placeholder="输入创建账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="表格标识：" prop="tableKey">
                <Input v-model="tableCss.tableKey" placeholder="输入表格标识"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="json样式：" prop="context">
                <Input v-model="tableCss.context" placeholder="输入json样式"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toTableCssList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetTableCssForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="tableCssSubmitting" @click="saveTableCssForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="tableCssSubmitting" @click="saveAddTableCssForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="tableCssDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          页面表格样式详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ tableCss.id }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建账号：{{ tableCss.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>表格标识：{{ tableCss.tableKey }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>json样式：{{ tableCss.context }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import TableCss from '@/view/com/drzyl/table/css/tableCss/TableCss'
import TableCssQuery from '@/view/com/drzyl/table/css/tableCss/TableCssQuery'

export default {
  data () {
    return {
      tableCssColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '创建账号', key: 'createId', minWidth: 200, sortable: true },
        { title: '表格标识', key: 'tableKey', minWidth: 200, sortable: true },
        { title: 'json样式', key: 'context', minWidth: 200, sortable: true }
      ],
      tableCssFormValidate: {
        createId: [
          { required: true, message: '创建账号不能为空', trigger: 'blur' }
        ],
        tableKey: [
          { required: true, message: '表格标识不能为空', trigger: 'blur' }
        ],
        context: [
          { required: true, message: 'json样式不能为空', trigger: 'blur' }
        ]
      },
      tableCssColumnsChecked: [
        'id',
        'createId',
        'tableKey',
        'context'
      ],
      tableCssColumnsNexus: {
        id: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        createId: { title: '创建账号', key: 'createId', minWidth: 200, sortable: true },
        tableKey: { title: '表格标识', key: 'tableKey', minWidth: 200, sortable: true },
        context: { title: 'json样式', key: 'context', minWidth: 200, sortable: true }
      },
      tableCssSet: [],
      tableCssCount: 0,
      tableCssRows: 10,
      tableCssPage: 1,
      tableCssSelectRow: [],
      tableCssSelectRowLength: 0,
      tableCss: new TableCss(),
      tableCssQuery: new TableCssQuery(),
      tableCssSpinShow: false,
      tableCssPageShow: true,
      tableCssEditModalShow: false,
      tableCssSubmitting: false,
      tableCssContinue: false,
      tableCssDetailDrawerShow: false,
      tableCssQueryPoptipShow: false,
      tableCssQuerySubmitting: false,
      tableCssKeySearchSubmitting: false,
      tableCssKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('tableCssStore', [
    ]),
    ...mapGetters('tableCssStore', [
    ])
  },
  methods: {
    ...mapMutations('tableCssStore', [
    ]),
    ...mapActions('tableCssStore', [
      'saveTableCss',
      'updateTableCss',
      'batchRemoveTableCss',
      'getTableCssByPk',
      'queryTableCss',
      'pagingQueryTableCss'
    ]),
    addTableCss () {
      this.tableCssEditModalShow = true
      this.tableCss = new TableCss()
    },
    upTableCss () {
      this.tableCssEditModalShow = true
      let tableCssEdit = new TableCss()
      tableCssEdit.id = this.tableCssSelectRow[0].id
      this.getTableCssByPk(tableCssEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.tableCss, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toTableCssList () {
      this.tableCssEditModalShow = false
      this.resetTableCssForm()
      this.getTableCssSet()
    },
    resetTableCssForm () {
      this.$refs.tableCssForm.resetFields()
    },
    saveTableCssForm () {
      this.tableCssContinue = false
      this.submitTableCssForm()
    },
    saveAddTableCssForm () {
      this.tableCssContinue = true
      this.submitTableCssForm()
    },
    submitTableCssForm () {
      this.tableCssSubmitting = true
      this.$refs.tableCssForm.validate((valid) => {
        if (valid) {
          if (this.tableCss.id) {
            this.updateTableCss(this.tableCss).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '页面表格样式信息修改成功.', duration: 3 })
                this.resetTableCssForm()
                this.tableCss = new TableCss()
                this.tableCssSubmitting = false
                if (!this.tableCssContinue) {
                  this.toTableCssList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.tableCssSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.tableCssSubmitting = false }, 3000)
            })
          } else {
            this.saveTableCss(this.tableCss).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '页面表格样式信息保存成功.', duration: 3 })
                this.resetTableCssForm()
                this.tableCss = new TableCss()
                this.tableCssSubmitting = false
                if (!this.tableCssContinue) {
                  this.toTableCssList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.tableCssSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.tableCssSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.tableCssSubmitting = false }, 3000)
        }
      })
    },
    delTableCss () {
      this.tableCssSpinShow = true
      this.batchRemoveTableCss(this.tableCssSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '页面表格样式信息删除成功.', duration: 3 })
          this.setTableCssSelectRow([])
          this.getTableCssSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.tableCssSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.tableCssSpinShow = false }, 700)
      })
    },
    detailTableCss () {
      this.tableCssDetailDrawerShow = true
      let tableCssDetail = new TableCss()
      tableCssDetail.id = this.tableCssSelectRow[0].id
      this.getTableCssByPk(tableCssDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.tableCss, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailTableCss (rowData) {
      this.tableCssDetailDrawerShow = true
      let tableCssDetail = new TableCss()
      tableCssDetail.id = rowData.id
      this.getTableCssByPk(tableCssDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.tableCss, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getTableCssSet () {
      this.tableCssSpinShow = true
      this.tableCssPageShow = true
      this.pagingQueryTableCss({ tableCssQuery: {}, rows: this.tableCssRows, page: this.tableCssPage }).then(res => {
        if (res.data.success) {
          this.tableCssSet = res.data.data
          this.tableCssCount = res.data.count
          this.setTableCssSelectRow([])
          setTimeout(() => { this.tableCssSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.tableCssSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.tableCssSpinShow = false }, 700)
      })
    },
    keySearchTableCss (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.tableCssKeySearchSubmitting = true
        this.tableCssPageShow = false
        this.tableCssSpinShow = true
        let tableCssQueryKeySearch = new TableCssQuery()
        tableCssQueryKeySearch.createIdAndKeyLike = '%' + keyLikeValue + '%'
        tableCssQueryKeySearch.tableKeyOrKeyLike = '%' + keyLikeValue + '%'
        tableCssQueryKeySearch.contextOrKeyLike = '%' + keyLikeValue + '%'
        this.queryTableCss(tableCssQueryKeySearch).then(res => {
          if (res.data.success) {
            this.tableCssSet = res.data.data
            this.tableCssCount = res.data.count
            this.setTableCssSelectRow([])
            setTimeout(() => { this.tableCssSpinShow = false }, 700)
            setTimeout(() => { this.tableCssKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.tableCssSpinShow = false }, 700)
            setTimeout(() => { this.tableCssKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.tableCssSpinShow = false }, 700)
          setTimeout(() => { this.tableCssKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.tableCssKeySearchClickRate++
        if (this.tableCssKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.tableCssKeySearchClickRate = 0
        }
      }
    },
    vagueQueryTableCss () {
      this.tableCssQuerySubmitting = true
      this.tableCssPageShow = false
      this.tableCssSpinShow = true
      this.tableCssQueryPoptipShow = false
      this.queryTableCss(this.tableCssQuery).then(res => {
        if (res.data.success) {
          this.tableCssSet = res.data.data
          this.tableCssCount = res.data.count
          this.setTableCssSelectRow([])
          setTimeout(() => { this.tableCssSpinShow = false }, 700)
          setTimeout(() => { this.tableCssQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.tableCssSpinShow = false }, 700)
          setTimeout(() => { this.tableCssQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.tableCssSpinShow = false }, 700)
        setTimeout(() => { this.tableCssQuerySubmitting = false }, 5000)
      })
    },
    resetTableCssQueryForm () {
      this.$refs.tableCssQueryForm.resetFields()
    },
    setTableCssSelectRow (list) {
      this.tableCssSelectRow = list
      this.tableCssSelectRowLength = list.length
    },
    tableCssPageIndexChange (pageIndex) {
      this.tableCssPage = pageIndex
      this.getTableCssSet()
    },
    tableCssPageSizeChange (pageSize) {
      this.tableCssRows = pageSize
      this.tableCssPage = 1
      this.getTableCssSet()
    },
    tableCssRefresh () {
      this.tableCssPage = 1
      this.getTableCssSet()
    },
    changeTableCssColumns () {
      this.tableCssColumns = []
      this.tableCssColumnsChecked.forEach(col => this.tableCssColumns.push(this.tableCssColumnsNexus[col]))
    },
    cleanTableCssColumns () {
      this.tableCssColumnsChecked = [
        'id'
      ]
      this.tableCssColumns = []
      this.tableCssColumnsChecked.forEach(col => this.tableCssColumns.push(this.tableCssColumnsNexus[col]))
    },
    resetTableCssColumns () {
      this.tableCssColumnsChecked = [
        'id',
        'createId',
        'tableKey',
        'context'
      ]
      this.tableCssColumns = []
      this.tableCssColumnsChecked.forEach(col => this.tableCssColumns.push(this.tableCssColumnsNexus[col]))
    }
  },
  mounted () {
    this.getTableCssSet()
  }
}
</script>

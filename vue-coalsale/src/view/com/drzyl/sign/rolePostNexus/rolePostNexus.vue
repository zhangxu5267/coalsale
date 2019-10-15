<style lang="less" scoped>
  @import './rolePostNexus.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="rolePostNexusKeySearchSubmitting" @on-search="keySearchRolePostNexus($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="rolePostNexusQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="rolePostNexusQueryForm" :model="rolePostNexusQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="角色编号：" prop="roleId">
                      <Input v-model="rolePostNexusQuery.roleId" placeholder="输入角色编号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="岗位编号：" prop="postId">
                      <Input v-model="rolePostNexusQuery.postId" placeholder="输入岗位编号"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryRolePostNexus()" :loading="rolePostNexusQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetRolePostNexusQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addRolePostNexus()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upRolePostNexus()" v-if="rolePostNexusSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delRolePostNexus()" v-if="rolePostNexusSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailRolePostNexus()" v-if="rolePostNexusSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="rolePostNexusColumnsChecked" @on-change="changeRolePostNexusColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="roleId">角色编号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="postId">岗位编号</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanRolePostNexusColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetRolePostNexusColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="rolePostNexusColumns" :data="rolePostNexusSet" @on-selection-change="setRolePostNexusSelectRow($event)" @on-row-dblclick="dblclickDetailRolePostNexus($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="rolePostNexusCount" :current="rolePostNexusPage" :page-size-opts="[10, 30, 50]" @on-change="rolePostNexusPageIndexChange($event)" @on-page-size-change="rolePostNexusPageSizeChange($event)" v-if="rolePostNexusPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="rolePostNexusRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="rolePostNexusSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="rolePostNexusEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑角色岗位
        </p>
        <Form class="pro-margin-top-20" ref="rolePostNexusForm" :model="rolePostNexus" :rules="rolePostNexusFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="角色编号：" prop="roleId">
                <Input v-model="rolePostNexus.roleId" placeholder="输入角色编号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="岗位编号：" prop="postId">
                <Input v-model="rolePostNexus.postId" placeholder="输入岗位编号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toRolePostNexusList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetRolePostNexusForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="rolePostNexusSubmitting" @click="saveRolePostNexusForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="rolePostNexusSubmitting" @click="saveAddRolePostNexusForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="rolePostNexusDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          角色岗位详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>关系编号：{{ rolePostNexus.nexusId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>角色编号：{{ rolePostNexus.roleId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>岗位编号：{{ rolePostNexus.postId }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import RolePostNexus from '@/view/com/drzyl/sign/rolePostNexus/RolePostNexus'
import RolePostNexusQuery from '@/view/com/drzyl/sign/rolePostNexus/RolePostNexusQuery'

export default {
  data () {
    return {
      rolePostNexusColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '角色编号', key: 'roleId', minWidth: 200, sortable: true },
        { title: '岗位编号', key: 'postId', minWidth: 200, sortable: true }
      ],
      rolePostNexusFormValidate: {
        roleId: [
          { required: true, message: '角色编号不能为空', trigger: 'blur' }
        ],
        postId: [
          { required: true, message: '岗位编号不能为空', trigger: 'blur' }
        ]
      },
      rolePostNexusColumnsChecked: [
        'nexusId',
        'roleId',
        'postId'
      ],
      rolePostNexusColumnsNexus: {
        nexusId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        roleId: { title: '角色编号', key: 'roleId', minWidth: 200, sortable: true },
        postId: { title: '岗位编号', key: 'postId', minWidth: 200, sortable: true }
      },
      rolePostNexusSet: [],
      rolePostNexusCount: 0,
      rolePostNexusRows: 10,
      rolePostNexusPage: 1,
      rolePostNexusSelectRow: [],
      rolePostNexusSelectRowLength: 0,
      rolePostNexus: new RolePostNexus(),
      rolePostNexusQuery: new RolePostNexusQuery(),
      rolePostNexusSpinShow: false,
      rolePostNexusPageShow: true,
      rolePostNexusEditModalShow: false,
      rolePostNexusSubmitting: false,
      rolePostNexusContinue: false,
      rolePostNexusDetailDrawerShow: false,
      rolePostNexusQueryPoptipShow: false,
      rolePostNexusQuerySubmitting: false,
      rolePostNexusKeySearchSubmitting: false,
      rolePostNexusKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('rolePostNexusStore', [
    ]),
    ...mapGetters('rolePostNexusStore', [
    ])
  },
  methods: {
    ...mapMutations('rolePostNexusStore', [
    ]),
    ...mapActions('rolePostNexusStore', [
      'saveRolePostNexus',
      'updateRolePostNexus',
      'batchRemoveRolePostNexus',
      'getRolePostNexusByPk',
      'queryRolePostNexus',
      'pagingQueryRolePostNexus'
    ]),
    addRolePostNexus () {
      this.rolePostNexusEditModalShow = true
      this.rolePostNexus = new RolePostNexus()
    },
    upRolePostNexus () {
      this.rolePostNexusEditModalShow = true
      let rolePostNexusEdit = new RolePostNexus()
      rolePostNexusEdit.nexusId = this.rolePostNexusSelectRow[0].nexusId
      this.getRolePostNexusByPk(rolePostNexusEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.rolePostNexus, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toRolePostNexusList () {
      this.rolePostNexusEditModalShow = false
      this.resetRolePostNexusForm()
      this.getRolePostNexusSet()
    },
    resetRolePostNexusForm () {
      this.$refs.rolePostNexusForm.resetFields()
    },
    saveRolePostNexusForm () {
      this.rolePostNexusContinue = false
      this.submitRolePostNexusForm()
    },
    saveAddRolePostNexusForm () {
      this.rolePostNexusContinue = true
      this.submitRolePostNexusForm()
    },
    submitRolePostNexusForm () {
      this.rolePostNexusSubmitting = true
      this.$refs.rolePostNexusForm.validate((valid) => {
        if (valid) {
          if (this.rolePostNexus.nexusId) {
            this.updateRolePostNexus(this.rolePostNexus).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '角色岗位信息修改成功.', duration: 3 })
                this.resetRolePostNexusForm()
                this.rolePostNexus = new RolePostNexus()
                this.rolePostNexusSubmitting = false
                if (!this.rolePostNexusContinue) {
                  this.toRolePostNexusList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.rolePostNexusSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.rolePostNexusSubmitting = false }, 3000)
            })
          } else {
            this.saveRolePostNexus(this.rolePostNexus).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '角色岗位信息保存成功.', duration: 3 })
                this.resetRolePostNexusForm()
                this.rolePostNexus = new RolePostNexus()
                this.rolePostNexusSubmitting = false
                if (!this.rolePostNexusContinue) {
                  this.toRolePostNexusList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.rolePostNexusSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.rolePostNexusSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.rolePostNexusSubmitting = false }, 3000)
        }
      })
    },
    delRolePostNexus () {
      this.rolePostNexusSpinShow = true
      this.batchRemoveRolePostNexus(this.rolePostNexusSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '角色岗位信息删除成功.', duration: 3 })
          this.setRolePostNexusSelectRow([])
          this.getRolePostNexusSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
      })
    },
    detailRolePostNexus () {
      this.rolePostNexusDetailDrawerShow = true
      let rolePostNexusDetail = new RolePostNexus()
      rolePostNexusDetail.nexusId = this.rolePostNexusSelectRow[0].nexusId
      this.getRolePostNexusByPk(rolePostNexusDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.rolePostNexus, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailRolePostNexus (rowData) {
      this.rolePostNexusDetailDrawerShow = true
      let rolePostNexusDetail = new RolePostNexus()
      rolePostNexusDetail.nexusId = rowData.nexusId
      this.getRolePostNexusByPk(rolePostNexusDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.rolePostNexus, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getRolePostNexusSet () {
      this.rolePostNexusSpinShow = true
      this.rolePostNexusPageShow = true
      this.pagingQueryRolePostNexus({ rolePostNexusQuery: {}, rows: this.rolePostNexusRows, page: this.rolePostNexusPage }).then(res => {
        if (res.data.success) {
          this.rolePostNexusSet = res.data.data
          this.rolePostNexusCount = res.data.count
          this.setRolePostNexusSelectRow([])
          setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
      })
    },
    keySearchRolePostNexus (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.rolePostNexusKeySearchSubmitting = true
        this.rolePostNexusPageShow = false
        this.rolePostNexusSpinShow = true
        let rolePostNexusQueryKeySearch = new RolePostNexusQuery()
        rolePostNexusQueryKeySearch.roleIdAndKeyLike = '%' + keyLikeValue + '%'
        rolePostNexusQueryKeySearch.postIdOrKeyLike = '%' + keyLikeValue + '%'
        this.queryRolePostNexus(rolePostNexusQueryKeySearch).then(res => {
          if (res.data.success) {
            this.rolePostNexusSet = res.data.data
            this.rolePostNexusCount = res.data.count
            this.setRolePostNexusSelectRow([])
            setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
            setTimeout(() => { this.rolePostNexusKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
            setTimeout(() => { this.rolePostNexusKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
          setTimeout(() => { this.rolePostNexusKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.rolePostNexusKeySearchClickRate++
        if (this.rolePostNexusKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.rolePostNexusKeySearchClickRate = 0
        }
      }
    },
    vagueQueryRolePostNexus () {
      this.rolePostNexusQuerySubmitting = true
      this.rolePostNexusPageShow = false
      this.rolePostNexusSpinShow = true
      this.rolePostNexusQueryPoptipShow = false
      this.queryRolePostNexus(this.rolePostNexusQuery).then(res => {
        if (res.data.success) {
          this.rolePostNexusSet = res.data.data
          this.rolePostNexusCount = res.data.count
          this.setRolePostNexusSelectRow([])
          setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
          setTimeout(() => { this.rolePostNexusQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
          setTimeout(() => { this.rolePostNexusQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.rolePostNexusSpinShow = false }, 700)
        setTimeout(() => { this.rolePostNexusQuerySubmitting = false }, 5000)
      })
    },
    resetRolePostNexusQueryForm () {
      this.$refs.rolePostNexusQueryForm.resetFields()
    },
    setRolePostNexusSelectRow (list) {
      this.rolePostNexusSelectRow = list
      this.rolePostNexusSelectRowLength = list.length
    },
    rolePostNexusPageIndexChange (pageIndex) {
      this.rolePostNexusPage = pageIndex
      this.getRolePostNexusSet()
    },
    rolePostNexusPageSizeChange (pageSize) {
      this.rolePostNexusRows = pageSize
      this.rolePostNexusPage = 1
      this.getRolePostNexusSet()
    },
    rolePostNexusRefresh () {
      this.rolePostNexusPage = 1
      this.getRolePostNexusSet()
    },
    changeRolePostNexusColumns () {
      this.rolePostNexusColumns = []
      this.rolePostNexusColumnsChecked.forEach(col => this.rolePostNexusColumns.push(this.rolePostNexusColumnsNexus[col]))
    },
    cleanRolePostNexusColumns () {
      this.rolePostNexusColumnsChecked = [
        'nexusId'
      ]
      this.rolePostNexusColumns = []
      this.rolePostNexusColumnsChecked.forEach(col => this.rolePostNexusColumns.push(this.rolePostNexusColumnsNexus[col]))
    },
    resetRolePostNexusColumns () {
      this.rolePostNexusColumnsChecked = [
        'nexusId',
        'roleId',
        'postId'
      ]
      this.rolePostNexusColumns = []
      this.rolePostNexusColumnsChecked.forEach(col => this.rolePostNexusColumns.push(this.rolePostNexusColumnsNexus[col]))
    }
  },
  mounted () {
    this.getRolePostNexusSet()
  }
}
</script>

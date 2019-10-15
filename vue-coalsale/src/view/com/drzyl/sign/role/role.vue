<style lang="less" scoped>
  @import './role.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="roleKeySearchSubmitting" @on-search="keySearchRole($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="roleQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="roleQueryForm" :model="roleQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="角色名称：" prop="roleName">
                      <Input v-model="roleQuery.roleName" placeholder="输入角色名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="角色类型：" prop="roleType">
                      <Input v-model="roleQuery.roleType" placeholder="输入角色类型"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="排序权重：" prop="weightOrder">
                      <InputNumber v-model="roleQuery.weightOrder"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="24">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="roleQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="roleQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="roleQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="roleQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="roleQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="roleQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="roleQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryRole()" :loading="roleQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetRoleQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addRole()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upRole()" v-if="roleSelectRowLength === 1">编辑</Button>
      <Button class="pro-list-button" type="info" icon="ios-construct-outline" ghost @click="assignPermissions()" v-if="roleSelectRowLength === 1">分配权限</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delRole()" v-if="roleSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailRole()" v-if="roleSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="roleColumnsChecked" @on-change="changeRoleColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="roleName">角色名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="roleType">角色类型</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="weightOrder">排序权重</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanRoleColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetRoleColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="roleColumns" :data="roleSet" @on-selection-change="setRoleSelectRow($event)" @on-row-dblclick="dblclickDetailRole($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="roleCount" :current="rolePage" :page-size-opts="[10, 30, 50]" @on-change="rolePageIndexChange($event)" @on-page-size-change="rolePageSizeChange($event)" v-if="rolePageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="roleRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="roleSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="roleEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑角色
        </p>
        <Form class="pro-margin-top-20" ref="roleForm" :model="role" :rules="roleFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="角色名称：" prop="roleName">
                <Input v-model="role.roleName" placeholder="输入角色名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <!-- <FormItem label="角色类型：" prop="roleType">
                <Input v-model="role.roleType" placeholder="输入角色类型"></Input>
              </FormItem> -->
              <Dict v-model="role.roleType" dictKey="SYS_ROLE_ROLE_TYPE" formItemProp="roleType" />
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="排序权重：" prop="weightOrder">
                <InputNumber v-model="role.weightOrder"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toRoleList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetRoleForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="roleSubmitting" @click="saveRoleForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="roleSubmitting" @click="saveAddRoleForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="roleDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          角色详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>角色编号：{{ role.roleId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>角色名称：{{ role.roleName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>角色类型：{{ role.roleType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>权限列表：{{ role.accessList }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>排序权重：{{ role.weightOrder }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ role.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ role.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ role.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ role.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ role.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ role.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ role.modifyTimes }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
    <Modal width="60" v-model="roleAccessListModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-construct-outline"></Icon>
          分配权限
        </p>
        <Form class="pro-margin-top-20" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="角色名称：">
                {{ role.roleName }}
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="权限列表：">
                <CheckboxGroup v-model="roleAccessListChecked">
                  <Row type="flex" justify="center">
                    <Col span="24">
                      <Checkbox label="homepage">主页</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="console">主控台</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="branchConsole">分公司</Checkbox>
                    </Col>
                    <!-- <Col span="24">
                      <Checkbox label="log">前端日志</Checkbox>
                    </Col> -->
                    <Col span="24">
                      <Checkbox label="code">代码生成</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="datatable">数据库表</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="coding">生成代码</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox label="sysmanage">系统管理</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="dict">数据字典</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="account">账号管理</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="session">会话管理</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="loginLog">登录日志</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="org">组织机构</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="post">岗位</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="staff">员工</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="role">角色权限</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="orgTree">组织结构</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox label="customer">客户管理</Checkbox>
                    </Col>
                    <Col span="24">
                      <Checkbox class="pro-margin-left-16" label="cusBase">客户列表</Checkbox>
                    </Col>
                  </Row>
                </CheckboxGroup>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="roleAccessListModalToRoleList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetRoleAccessListForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="roleAccessListSubmitting" @click="saveRoleAccessListForm()">保存</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Role from '@/view/com/drzyl/sign/role/Role'
import RoleQuery from '@/view/com/drzyl/sign/role/RoleQuery'
import RoleAccessParam from '@/view/com/drzyl/sign/business/roleAccess/RoleAccessParam'

export default {
  data () {
    return {
      roleColumns: [
        { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        { title: '角色名称', key: 'roleName', minWidth: 200, sortable: true },
        { title: '角色类型', key: 'roleType', minWidth: 200, sortable: true },
        { title: '排序权重', key: 'weightOrder', width: 120, sortable: true }
      ],
      roleFormValidate: {
        roleName: [
          { required: true, message: '角色名称不能为空', trigger: 'blur' }
        ]
      },
      roleColumnsChecked: [
        'roleId',
        'roleName',
        'roleType',
        'weightOrder'
      ],
      roleColumnsNexus: {
        roleId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        roleName: { title: '角色名称', key: 'roleName', minWidth: 200, sortable: true },
        roleType: { title: '角色类型', key: 'roleType', minWidth: 200, sortable: true },
        weightOrder: { title: '排序权重', key: 'weightOrder', width: 120, sortable: true }
      },
      roleSet: [],
      roleCount: 0,
      roleRows: 10,
      rolePage: 1,
      roleSelectRow: [],
      roleSelectRowLength: 0,
      role: new Role(),
      roleQuery: new RoleQuery(),
      roleSpinShow: false,
      rolePageShow: true,
      roleEditModalShow: false,
      roleSubmitting: false,
      roleContinue: false,
      roleDetailDrawerShow: false,
      roleQueryPoptipShow: false,
      roleQuerySubmitting: false,
      roleKeySearchSubmitting: false,
      roleKeySearchClickRate: 0,
      roleAccessListModalShow: false,
      roleAccessListChecked: [],
      roleAccessListSubmitting: false
    }
  },
  computed: {
    ...mapState('roleStore', [
    ]),
    ...mapGetters('roleStore', [
    ])
  },
  methods: {
    ...mapMutations('roleStore', [
    ]),
    ...mapActions('roleStore', [
      'saveRole',
      'updateRole',
      'batchRemoveRole',
      'getRoleByPk',
      'queryRole',
      'pagingQueryRole'
    ]),
    ...mapActions('roleAccessStore', [
      'saveRoleAccess',
      'getRoleAccess'
    ]),
    addRole () {
      this.roleEditModalShow = true
      this.role = new Role()
    },
    upRole () {
      this.roleEditModalShow = true
      let roleEdit = new Role()
      roleEdit.roleId = this.roleSelectRow[0].roleId
      this.getRoleByPk(roleEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.role, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toRoleList () {
      this.roleEditModalShow = false
      this.resetRoleForm()
      this.getRoleSet()
    },
    resetRoleForm () {
      this.$refs.roleForm.resetFields()
    },
    saveRoleForm () {
      this.roleContinue = false
      this.submitRoleForm()
    },
    saveAddRoleForm () {
      this.roleContinue = true
      this.submitRoleForm()
    },
    submitRoleForm () {
      this.roleSubmitting = true
      this.$refs.roleForm.validate((valid) => {
        if (valid) {
          if (this.role.roleId) {
            this.updateRole(this.role).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '角色信息修改成功.', duration: 3 })
                this.resetRoleForm()
                this.role = new Role()
                this.roleSubmitting = false
                if (!this.roleContinue) {
                  this.toRoleList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.roleSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.roleSubmitting = false }, 3000)
            })
          } else {
            this.saveRole(this.role).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '角色信息保存成功.', duration: 3 })
                this.resetRoleForm()
                this.role = new Role()
                this.roleSubmitting = false
                if (!this.roleContinue) {
                  this.toRoleList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.roleSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.roleSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.roleSubmitting = false }, 3000)
        }
      })
    },
    delRole () {
      this.roleSpinShow = true
      this.batchRemoveRole(this.roleSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '角色信息删除成功.', duration: 3 })
          this.setRoleSelectRow([])
          this.getRoleSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.roleSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.roleSpinShow = false }, 700)
      })
    },
    detailRole () {
      this.roleDetailDrawerShow = true
      let roleDetail = new Role()
      roleDetail.roleId = this.roleSelectRow[0].roleId
      this.getRoleByPk(roleDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.role, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailRole (rowData) {
      this.roleDetailDrawerShow = true
      let roleDetail = new Role()
      roleDetail.roleId = rowData.roleId
      this.getRoleByPk(roleDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.role, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getRoleSet () {
      this.roleSpinShow = true
      this.rolePageShow = true
      this.pagingQueryRole({ roleQuery: {}, rows: this.roleRows, page: this.rolePage }).then(res => {
        if (res.data.success) {
          this.roleSet = res.data.data
          this.roleCount = res.data.count
          this.setRoleSelectRow([])
          setTimeout(() => { this.roleSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.roleSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.roleSpinShow = false }, 700)
      })
    },
    keySearchRole (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.roleKeySearchSubmitting = true
        this.rolePageShow = false
        this.roleSpinShow = true
        let roleQueryKeySearch = new RoleQuery()
        roleQueryKeySearch.roleNameAndKeyLike = '%' + keyLikeValue + '%'
        roleQueryKeySearch.roleTypeOrKeyLike = '%' + keyLikeValue + '%'
        this.queryRole(roleQueryKeySearch).then(res => {
          if (res.data.success) {
            this.roleSet = res.data.data
            this.roleCount = res.data.count
            this.setRoleSelectRow([])
            setTimeout(() => { this.roleSpinShow = false }, 700)
            setTimeout(() => { this.roleKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.roleSpinShow = false }, 700)
            setTimeout(() => { this.roleKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.roleSpinShow = false }, 700)
          setTimeout(() => { this.roleKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.roleKeySearchClickRate++
        if (this.roleKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.roleKeySearchClickRate = 0
        }
      }
    },
    vagueQueryRole () {
      this.roleQuerySubmitting = true
      this.rolePageShow = false
      this.roleSpinShow = true
      this.roleQueryPoptipShow = false
      this.queryRole(this.roleQuery).then(res => {
        if (res.data.success) {
          this.roleSet = res.data.data
          this.roleCount = res.data.count
          this.setRoleSelectRow([])
          setTimeout(() => { this.roleSpinShow = false }, 700)
          setTimeout(() => { this.roleQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.roleSpinShow = false }, 700)
          setTimeout(() => { this.roleQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.roleSpinShow = false }, 700)
        setTimeout(() => { this.roleQuerySubmitting = false }, 5000)
      })
    },
    resetRoleQueryForm () {
      this.$refs.roleQueryForm.resetFields()
    },
    setRoleSelectRow (list) {
      this.roleSelectRow = list
      this.roleSelectRowLength = list.length
    },
    rolePageIndexChange (pageIndex) {
      this.rolePage = pageIndex
      this.getRoleSet()
    },
    rolePageSizeChange (pageSize) {
      this.roleRows = pageSize
      this.rolePage = 1
      this.getRoleSet()
    },
    roleRefresh () {
      this.rolePage = 1
      this.getRoleSet()
    },
    changeRoleColumns () {
      this.roleColumns = []
      this.roleColumnsChecked.forEach(col => this.roleColumns.push(this.roleColumnsNexus[col]))
    },
    cleanRoleColumns () {
      this.roleColumnsChecked = [
        'roleId'
      ]
      this.roleColumns = []
      this.roleColumnsChecked.forEach(col => this.roleColumns.push(this.roleColumnsNexus[col]))
    },
    resetRoleColumns () {
      this.roleColumnsChecked = [
        'roleId',
        'roleName',
        'roleType',
        'weightOrder'
      ]
      this.roleColumns = []
      this.roleColumnsChecked.forEach(col => this.roleColumns.push(this.roleColumnsNexus[col]))
    },
    assignPermissions () {
      this.roleAccessListModalShow = true
      let roleEdit = new Role()
      roleEdit.roleId = this.roleSelectRow[0].roleId
      this.getRoleByPk(roleEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.role, res.data.data[0])
          let roleAccessParam = new RoleAccessParam()
          roleAccessParam.roleId = this.role.roleId
          this.getRoleAccess(roleAccessParam).then(res => {
            if (res.data.success) {
              this.roleAccessListChecked = res.data.data[0].accessList
            } else {
              this.$Message.error({ content: res.data.msg, duration: 6 })
            }
          }).catch(result => {
            this.$Message.error({ content: result.response.statusText, duration: 6 })
          })
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    roleAccessListModalToRoleList () {
      this.roleAccessListModalShow = false
      this.getRoleSet()
    },
    resetRoleAccessListForm () {
      this.roleAccessListChecked = []
    },
    saveRoleAccessListForm () {
      this.roleAccessListSubmitting = true
      let roleAccessParam = new RoleAccessParam()
      roleAccessParam.roleId = this.role.roleId
      roleAccessParam.accessList = this.roleAccessListChecked
      this.saveRoleAccess(roleAccessParam).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '角色权限信息保存成功.', duration: 3 })
          this.resetRoleAccessListForm()
          this.role = new Role()
          this.roleAccessListSubmitting = false
          this.roleAccessListModalToRoleList()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.roleAccessListSubmitting = false }, 3000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.roleAccessListSubmitting = false }, 3000)
      })
    }
  },
  mounted () {
    this.getRoleSet()
  }
}
</script>

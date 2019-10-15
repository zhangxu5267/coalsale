<style lang="less" scoped>
  @import './account.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="accountKeySearchSubmitting" @on-search="keySearchAccount($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="accountQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="accountQueryForm" :model="accountQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="账号：" prop="account">
                      <Input v-model="accountQuery.account" placeholder="输入账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="密码：" prop="password">
                      <Input v-model="accountQuery.password" placeholder="输入密码"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="手机号：" prop="mobilePhoneNumber">
                      <Input v-model="accountQuery.mobilePhoneNumber" placeholder="输入手机号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="12">
                    <FormItem label="浏览器会话过期时间：" prop="cookiesExpireTimesBrowser" :label-width="200">
                      <InputNumber v-model="accountQuery.cookiesExpireTimesBrowser"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="12">
                    <FormItem label="安卓APP会话过期时间：" prop="cookiesExpireTimesAndroid" :label-width="200">
                      <InputNumber v-model="accountQuery.cookiesExpireTimesAndroid"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="12">
                    <FormItem label="苹果APP会话过期时间：" prop="cookiesExpireTimesIos" :label-width="200">
                      <InputNumber v-model="accountQuery.cookiesExpireTimesIos"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="12">
                    <FormItem label="微信小程序会话过期时间：" prop="cookiesExpireTimesWechatapp" :label-width="200">
                      <InputNumber v-model="accountQuery.cookiesExpireTimesWechatapp"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="关联类型：" prop="nexusType">
                      <Input v-model="accountQuery.nexusType" placeholder="输入关联类型"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="对象编号：" prop="nexusObjectId">
                      <Input v-model="accountQuery.nexusObjectId" placeholder="输入对象编号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="accountQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="accountQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="accountQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="accountQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="accountQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="accountQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="accountQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryAccount()" :loading="accountQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetAccountQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addAccount()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upAccount()" v-if="accountSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delAccount()" v-if="accountSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailAccount()" v-if="accountSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="208">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="accountColumnsChecked" @on-change="changeAccountColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="account">账号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="password">密码</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="mobilePhoneNumber">手机号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cookiesExpireTimesBrowser">浏览器会话过期时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cookiesExpireTimesAndroid">安卓APP会话过期时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cookiesExpireTimesIos">苹果APP会话过期时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cookiesExpireTimesWechatapp">微信小程序会话过期时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="nexusType">关联类型</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="nexusObjectId">对象编号</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanAccountColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetAccountColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="accountColumns" border :data="accountSet" @on-selection-change="setAccountSelectRow($event)" @on-row-dblclick="dblclickDetailAccount($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="accountCount" :current="accountPage" :page-size-opts="[10, 30, 50]" @on-change="accountPageIndexChange($event)" @on-page-size-change="accountPageSizeChange($event)" v-if="accountPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="accountRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="accountSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="accountEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑账号
        </p>
        <Form class="pro-margin-top-20" ref="accountForm" :model="account" :rules="accountFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="18">
              <FormItem label="账号：" prop="account">
                <Input v-model="account.account" placeholder="输入账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="18">
              <FormItem label="密码：" prop="password">
                <Input v-model="account.password" placeholder="输入密码"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="18">
              <FormItem label="手机号：" prop="mobilePhoneNumber">
                <Input v-model="account.mobilePhoneNumber" placeholder="输入手机号"></Input>
              </FormItem>
            </Col>
            <Divider size="small" dashed>关联人员设置</Divider>
            <Col class="pro-margin-top-20" :xs="24" :sm="20" :md="18" :lg="18">
              <!-- <FormItem label="关联类型：" prop="nexusType">
                <Input v-model="account.nexusType" placeholder="输入关联类型"></Input>
              </FormItem> -->
              <Dict v-model="account.nexusType" dictKey="SYS_ACCOUNT_NEXUS_TYPE" formItemProp="nexusType" @on-change="changeDictValueNexusType($event)" />
            </Col>
            <!-- <Col :xs="24" :sm="20" :md="18" :lg="18">
              <FormItem label="对象编号：" prop="nexusObjectId">
                <Input v-model="account.nexusObjectId" placeholder="输入对象编号"></Input>
              </FormItem>
            </Col> -->
            <Col v-if="nexusObjectCodeShow" :xs="24" :sm="20" :md="18" :lg="18">
              <FormItem label="角色名称：" prop="nexusObjectId">
                <Select v-model="account.nexusObjectId" clearable filterable>
                  <Option v-for="item in nexusObjectSetCode" :value="item.roleId" :key="item.roleId">{{ item.roleName }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col v-if="nexusObjectStaffShow" :xs="24" :sm="20" :md="18" :lg="18">
              <FormItem label="员工姓名：" prop="nexusObjectId">
                <Select v-model="account.nexusObjectId" clearable filterable>
                  <Option v-for="item in nexusObjectSetStaff" :value="item.staffId" :key="item.staffId">{{ item.staffName + ' [ ' + item.staffNo + ' ] [ ' + item.mobilePhoneNumber + ' ]' }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Divider size="small" dashed>会话过期时间设置</Divider>
            <Col class="pro-margin-top-20" :xs="24" :sm="20" :md="18" :lg="12">
              <FormItem label="浏览器会话过期时间：" prop="cookiesExpireTimesBrowser" :label-width="270">
                <InputNumber v-model="account.cookiesExpireTimesBrowser"></InputNumber>
              </FormItem>
            </Col>
            <Col class="pro-margin-top-20" :xs="24" :sm="20" :md="18" :lg="12">
              <FormItem label="安卓APP会话过期时间：" prop="cookiesExpireTimesAndroid" :label-width="270">
                <InputNumber v-model="account.cookiesExpireTimesAndroid"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="12">
              <FormItem label="苹果APP会话过期时间：" prop="cookiesExpireTimesIos" :label-width="270">
                <InputNumber v-model="account.cookiesExpireTimesIos"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="12">
              <FormItem label="微信小程序会话过期时间：" prop="cookiesExpireTimesWechatapp" :label-width="270">
                <InputNumber v-model="account.cookiesExpireTimesWechatapp"></InputNumber>
              </FormItem>
            </Col>
            <Divider dashed />
            <Col :xs="24" :sm="20" :md="18" :lg="13">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toAccountList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetAccountForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="accountSubmitting" @click="saveAccountForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="accountSubmitting" @click="saveAddAccountForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="accountDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          账号详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>账号编号：{{ account.accountId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>账号：{{ account.account }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>密码：{{ account.password }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>手机号：{{ account.mobilePhoneNumber }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>浏览器会话过期时间：{{ account.cookiesExpireTimesBrowser }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>安卓APP会话过期时间：{{ account.cookiesExpireTimesAndroid }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>苹果APP会话过期时间：{{ account.cookiesExpireTimesIos }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>微信小程序会话过期时间：{{ account.cookiesExpireTimesWechatapp }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>关联类型：{{ account.nexusType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>对象编号：{{ account.nexusObjectId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ account.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ account.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ account.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ account.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ account.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ account.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ account.modifyTimes }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Account from '@/view/com/drzyl/sign/account/Account'
import AccountQuery from '@/view/com/drzyl/sign/account/AccountQuery'
import RoleQuery from '@/view/com/drzyl/sign/role/RoleQuery'

export default {
  data () {
    let validatePhone =  (rule, value, callback) => {
        if (!value) {
            return callback(new Error('手机号不能为空'));
        } else if (!/^1[34578]\d{9}$/.test(value)) {
            callback('手机号格式不正确');
        } else {
            callback();
        }   
    };
    return {
      accountColumns: [
        { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        { title: '账号', key: 'account', minWidth: 200, sortable: true },
        { title: '密码', key: 'password', minWidth: 200, sortable: true },
        { title: '手机号', key: 'mobilePhoneNumber', minWidth: 200, sortable: true }
      ],
      
      accountFormValidate: {
        account: [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ],
        // mobilePhoneNumber: [
        //   { required: true, validator:validatePhone, trigger: 'blur' }
        // ]
      },
      accountColumnsChecked: [
        'accountId',
        'account',
        'password',
        'mobilePhoneNumber'
      ],
      accountColumnsNexus: {
        accountId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        account: { title: '账号', key: 'account', minWidth: 200, sortable: true },
        password: { title: '密码', key: 'password', minWidth: 200, sortable: true },
        mobilePhoneNumber: { title: '手机号', key: 'mobilePhoneNumber', minWidth: 200, sortable: true },
        cookiesExpireTimesBrowser: { title: '浏览器会话过期时间', key: 'cookiesExpireTimesBrowser', minWidth: 200, sortable: true },
        cookiesExpireTimesAndroid: { title: '安卓APP会话过期时间', key: 'cookiesExpireTimesAndroid', minWidth: 200, sortable: true },
        cookiesExpireTimesIos: { title: '苹果APP会话过期时间', key: 'cookiesExpireTimesIos', minWidth: 200, sortable: true },
        cookiesExpireTimesWechatapp: { title: '微信小程序会话过期时间', key: 'cookiesExpireTimesWechatapp', minWidth: 200, sortable: true },
        nexusType: { title: '关联类型', key: 'nexusType', minWidth: 200, sortable: true },
        nexusObjectId: { title: '对象编号', key: 'nexusObjectId', minWidth: 200, sortable: true }
      },
      accountSet: [],
      accountCount: 0,
      accountRows: 10,
      accountPage: 1,
      accountSelectRow: [],
      accountSelectRowLength: 0,
      account: new Account(),
      accountQuery: new AccountQuery(),
      accountSpinShow: false,
      accountPageShow: true,
      accountEditModalShow: false,
      accountSubmitting: false,
      accountContinue: false,
      accountDetailDrawerShow: false,
      accountQueryPoptipShow: false,
      accountQuerySubmitting: false,
      accountKeySearchSubmitting: false,
      accountKeySearchClickRate: 0,
      nexusObjectSetCode: [],
      nexusObjectCodeShow: false,
      nexusObjectStaffShow: false,
      nexusObjectSetStaff: []
    }
  },
  computed: {
    ...mapState('accountStore', [
    ]),
    ...mapGetters('accountStore', [
    ])
  },
  methods: {
    ...mapMutations('accountStore', [
    ]),
    ...mapActions('accountStore', [
      'saveAccount',
      'updateAccount',
      'batchRemoveAccount',
      'getAccountByPk',
      'queryAccount',
      'pagingQueryAccount'
    ]),
    ...mapActions('roleStore', [
      'queryRole'
    ]),
    ...mapActions('staffStore', [
      'getAllStaff'
    ]),
    addAccount () {
      this.nexusObjectCodeShow = false
      this.nexusObjectStaffShow = false
      this.accountEditModalShow = true
      this.account = new Account()
    },
    upAccount () {
      this.nexusObjectCodeShow = false
      this.nexusObjectStaffShow = false
      this.accountEditModalShow = true
      let accountEdit = new Account()
      accountEdit.accountId = this.accountSelectRow[0].accountId
      this.getAccountByPk(accountEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.account, res.data.data[0])
          if (this.account.nexusType === 'staff') {
            this.getAllStaff().then(res => {
              if (res.data.success) {
                this.nexusObjectSetStaff = res.data.data
                this.nexusObjectStaffShow = true
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
            })
          } else if (this.account.nexusType === 'sys_admin') {
          } else if (this.account.nexusType === 'branch_office_sys_admin') {
          } else if (this.account.nexusType === 'group_company_sys_admin') {
          } else if (this.account.nexusType === 'code') {
            let roleQuery = new RoleQuery()
            roleQuery.roleType = 'code'
            this.queryRole(roleQuery).then(res => {
              if (res.data.success) {
                this.nexusObjectSetCode = res.data.data
                this.nexusObjectCodeShow = true
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
            })
          }
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toAccountList () {
      this.accountEditModalShow = false
      this.resetAccountForm()
      this.getAccountSet()
    },
    resetAccountForm () {
      this.$refs.accountForm.resetFields()
    },
    saveAccountForm () {
      this.accountContinue = false
      this.submitAccountForm()
    },
    saveAddAccountForm () {
      this.accountContinue = true
      this.submitAccountForm()
    },
    submitAccountForm () {
      this.accountSubmitting = true
      this.$refs.accountForm.validate((valid) => {
        if (valid) {
          if (this.account.accountId) {
            this.updateAccount(this.account).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '账号信息修改成功.', duration: 3 })
                this.resetAccountForm()
                this.account = new Account()
                this.accountSubmitting = false
                if (!this.accountContinue) {
                  this.toAccountList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.accountSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.accountSubmitting = false }, 3000)
            })
          } else {
            this.saveAccount(this.account).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '账号信息保存成功.', duration: 3 })
                this.resetAccountForm()
                this.account = new Account()
                this.accountSubmitting = false
                if (!this.accountContinue) {
                  this.toAccountList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.accountSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.accountSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.accountSubmitting = false }, 3000)
        }
      })
    },
    delAccount () {
      this.accountSpinShow = true
      this.batchRemoveAccount(this.accountSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '账号信息删除成功.', duration: 3 })
          this.setAccountSelectRow([])
          this.getAccountSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.accountSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.accountSpinShow = false }, 700)
      })
    },
    detailAccount () {
      this.accountDetailDrawerShow = true
      let accountDetail = new Account()
      accountDetail.accountId = this.accountSelectRow[0].accountId
      this.getAccountByPk(accountDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.account, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailAccount (rowData) {
      this.accountDetailDrawerShow = true
      let accountDetail = new Account()
      accountDetail.accountId = rowData.accountId
      this.getAccountByPk(accountDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.account, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getAccountSet () {
      this.accountSpinShow = true
      this.accountPageShow = true
      this.pagingQueryAccount({ accountQuery: {}, rows: this.accountRows, page: this.accountPage }).then(res => {
        if (res.data.success) {
          this.accountSet = res.data.data
          this.accountCount = res.data.count
          this.setAccountSelectRow([])
          setTimeout(() => { this.accountSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.accountSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.accountSpinShow = false }, 700)
      })
    },
    keySearchAccount (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.accountKeySearchSubmitting = true
        this.accountPageShow = false
        this.accountSpinShow = true
        let accountQueryKeySearch = new AccountQuery()
        accountQueryKeySearch.accountAndKeyLike = '%' + keyLikeValue + '%'
        accountQueryKeySearch.passwordOrKeyLike = '%' + keyLikeValue + '%'
        accountQueryKeySearch.mobilePhoneNumberOrKeyLike = '%' + keyLikeValue + '%'
        accountQueryKeySearch.nexusTypeOrKeyLike = '%' + keyLikeValue + '%'
        accountQueryKeySearch.nexusObjectIdOrKeyLike = '%' + keyLikeValue + '%'
        this.queryAccount(accountQueryKeySearch).then(res => {
          if (res.data.success) {
            this.accountSet = res.data.data
            this.accountCount = res.data.count
            this.setAccountSelectRow([])
            setTimeout(() => { this.accountSpinShow = false }, 700)
            setTimeout(() => { this.accountKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.accountSpinShow = false }, 700)
            setTimeout(() => { this.accountKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.accountSpinShow = false }, 700)
          setTimeout(() => { this.accountKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.accountKeySearchClickRate++
        if (this.accountKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.accountKeySearchClickRate = 0
        }
      }
    },
    vagueQueryAccount () {
      this.accountQuerySubmitting = true
      this.accountPageShow = false
      this.accountSpinShow = true
      this.accountQueryPoptipShow = false
      this.queryAccount(this.accountQuery).then(res => {
        if (res.data.success) {
          this.accountSet = res.data.data
          this.accountCount = res.data.count
          this.setAccountSelectRow([])
          setTimeout(() => { this.accountSpinShow = false }, 700)
          setTimeout(() => { this.accountQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.accountSpinShow = false }, 700)
          setTimeout(() => { this.accountQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.accountSpinShow = false }, 700)
        setTimeout(() => { this.accountQuerySubmitting = false }, 5000)
      })
    },
    resetAccountQueryForm () {
      this.$refs.accountQueryForm.resetFields()
    },
    setAccountSelectRow (list) {
      this.accountSelectRow = list
      this.accountSelectRowLength = list.length
    },
    accountPageIndexChange (pageIndex) {
      this.accountPage = pageIndex
      this.getAccountSet()
    },
    accountPageSizeChange (pageSize) {
      this.accountRows = pageSize
      this.accountPage = 1
      this.getAccountSet()
    },
    accountRefresh () {
      this.accountPage = 1
      this.getAccountSet()
    },
    changeAccountColumns () {
      this.accountColumns = []
      this.accountColumnsChecked.forEach(col => this.accountColumns.push(this.accountColumnsNexus[col]))
    },
    cleanAccountColumns () {
      this.accountColumnsChecked = [
        'accountId'
      ]
      this.accountColumns = []
      this.accountColumnsChecked.forEach(col => this.accountColumns.push(this.accountColumnsNexus[col]))
    },
    resetAccountColumns () {
      this.accountColumnsChecked = [
        'accountId',
        'account',
        'password',
        'mobilePhoneNumber'
      ]
      this.accountColumns = []
      this.accountColumnsChecked.forEach(col => this.accountColumns.push(this.accountColumnsNexus[col]))
    },
    changeDictValueNexusType (value) {
      if (value) {
        this.nexusObjectCodeShow = false
        this.nexusObjectStaffShow = false
        this.account.nexusObjectId = null
        if (value === 'staff') {
          this.getAllStaff().then(res => {
            if (res.data.success) {
              this.nexusObjectSetStaff = res.data.data
              this.nexusObjectStaffShow = true
            } else {
              this.$Message.error({ content: res.data.msg, duration: 6 })
            }
          }).catch(result => {
            this.$Message.error({ content: result.response.statusText, duration: 6 })
          })
        } else if (value === 'sys_admin') {
        } else if (value === 'branch_office_sys_admin') {
        } else if (value === 'group_company_sys_admin') {
        } else if (value === 'code') {
          let roleQuery = new RoleQuery()
          roleQuery.roleType = 'code'
          this.queryRole(roleQuery).then(res => {
            if (res.data.success) {
              this.nexusObjectSetCode = res.data.data
              this.nexusObjectCodeShow = true
            } else {
              this.$Message.error({ content: res.data.msg, duration: 6 })
            }
          }).catch(result => {
            this.$Message.error({ content: result.response.statusText, duration: 6 })
          })
        }
      }
    }
  },
  mounted () {
    this.getAccountSet()
  }
}
</script>

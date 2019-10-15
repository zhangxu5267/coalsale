<style lang="less" scoped>
  @import './staff.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="staffKeySearchSubmitting" @on-search="keySearchStaff($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="staffQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="staffQueryForm" :model="staffQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="员工工号：" prop="staffNo">
                      <Input v-model="staffQuery.staffNo" placeholder="输入员工工号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="员工姓名：" prop="staffName">
                      <Input v-model="staffQuery.staffName" placeholder="输入员工姓名"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="手机号：" prop="mobilePhoneNumber">
                      <Input v-model="staffQuery.mobilePhoneNumber" placeholder="输入手机号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="性别：" prop="gender">
                      <Input v-model="staffQuery.gender" placeholder="输入性别"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="紧急联系人姓名：" prop="emergencyContactName">
                      <Input v-model="staffQuery.emergencyContactName" placeholder="输入紧急联系人姓名"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="紧急联系人手机号：" prop="emergContMobilePhoneNumber">
                      <Input v-model="staffQuery.emergContMobilePhoneNumber" placeholder="输入紧急联系人手机号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="排序权重：" prop="weightOrder">
                      <InputNumber v-model="staffQuery.weightOrder"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="描述：" prop="description">
                      <Input v-model="staffQuery.description" placeholder="输入描述"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="staffQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="staffQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="staffQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="staffQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="staffQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="staffQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="staffQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryStaff()" :loading="staffQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetStaffQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addStaff()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upStaff()" v-if="staffSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delStaff()" v-if="staffSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailStaff()" v-if="staffSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="staffColumnsChecked" @on-change="changeStaffColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="staffNo">员工工号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="staffName">员工姓名</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="mobilePhoneNumber">手机号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="gender">性别</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="emergencyContactName">紧急联系人姓名</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="emergContMobilePhoneNumber">紧急联系人手机号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="weightOrder">排序权重</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="description">描述</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="versions">版本号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="createId">创建人账号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="createName">创建人名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="createTimes">创建时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="modifyId">修改人账号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="modifyName">修改人名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="modifyTimes">修改时间</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanStaffColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetStaffColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="staffColumns" :data="staffSet" @on-selection-change="setStaffSelectRow($event)" @on-row-dblclick="dblclickDetailStaff($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="staffCount" :current="staffPage" :page-size-opts="[10, 30, 50]" @on-change="staffPageIndexChange($event)" @on-page-size-change="staffPageSizeChange($event)" v-if="staffPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="staffRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="staffSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="staffEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑员工
        </p>
        <Form class="pro-margin-top-20" ref="staffForm" :model="staff" :rules="staffFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="员工工号：" prop="staffNo">
                <Input v-model="staff.staffNo" placeholder="输入员工工号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="员工姓名：" prop="staffName">
                <Input v-model="staff.staffName" placeholder="输入员工姓名"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="手机号：" prop="mobilePhoneNumber">
                <Input v-model="staff.mobilePhoneNumber" placeholder="输入手机号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="性别：" prop="gender">
                <Input v-model="staff.gender" placeholder="输入性别"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="紧急联系人姓名：" prop="emergencyContactName">
                <Input v-model="staff.emergencyContactName" placeholder="输入紧急联系人姓名"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="紧急联系人手机号：" prop="emergContMobilePhoneNumber">
                <Input v-model="staff.emergContMobilePhoneNumber" placeholder="输入紧急联系人手机号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="排序权重：" prop="weightOrder">
                <InputNumber v-model="staff.weightOrder"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="描述：" prop="description">
                <Input v-model="staff.description" placeholder="输入描述"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="staff.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="staff.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="staff.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="staff.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="staff.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="staff.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="staff.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toStaffList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetStaffForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="staffSubmitting" @click="saveStaffForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="staffSubmitting" @click="saveAddStaffForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="staffDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          员工详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>员工编号：{{ staff.staffId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>员工工号：{{ staff.staffNo }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>员工姓名：{{ staff.staffName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>手机号：{{ staff.mobilePhoneNumber }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>性别：{{ staff.gender }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>紧急联系人姓名：{{ staff.emergencyContactName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>紧急联系人手机号：{{ staff.emergContMobilePhoneNumber }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>排序权重：{{ staff.weightOrder }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>描述：{{ staff.description }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ staff.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ staff.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ staff.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ staff.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ staff.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ staff.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ staff.modifyTimes }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Staff from '@/view/com/drzyl/sign/staff/Staff'
import StaffQuery from '@/view/com/drzyl/sign/staff/StaffQuery'

export default {
  data () {
    return {
      staffColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '员工工号', key: 'staffNo', minWidth: 200, sortable: true },
        { title: '员工姓名', key: 'staffName', minWidth: 200, sortable: true },
        { title: '手机号', key: 'mobilePhoneNumber', minWidth: 200, sortable: true },
        { title: '性别', key: 'gender', minWidth: 200, sortable: true },
        { title: '紧急联系人姓名', key: 'emergencyContactName', minWidth: 200, sortable: true },
        { title: '紧急联系人手机号', key: 'emergContMobilePhoneNumber', minWidth: 200, sortable: true },
        { title: '排序权重', key: 'weightOrder', minWidth: 200, sortable: true },
        { title: '描述', key: 'description', minWidth: 200, sortable: true },
        { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        { title: '修改人账号', key: 'modifyId', minWidth: 200, sortable: true },
        { title: '修改人名称', key: 'modifyName', minWidth: 200, sortable: true },
        { title: '修改时间', key: 'modifyTimes', minWidth: 200, sortable: true }
      ],
      staffFormValidate: {
        staffNo: [
          { required: true, message: '员工工号不能为空', trigger: 'blur' }
        ],
        staffName: [
          { required: true, message: '员工姓名不能为空', trigger: 'blur' }
        ],
        versions: [
          { type: 'number', required: true, message: '版本号不能为空', trigger: 'change' }
        ],
        createId: [
          { required: true, message: '创建人账号不能为空', trigger: 'blur' }
        ],
        createName: [
          { required: true, message: '创建人名称不能为空', trigger: 'blur' }
        ],
        createTimes: [
          { type: 'number', required: true, message: '创建时间不能为空', trigger: 'change' }
        ]
      },
      staffColumnsChecked: [
        'staffId',
        'staffNo',
        'staffName',
        'mobilePhoneNumber',
        'gender',
        'emergencyContactName',
        'emergContMobilePhoneNumber',
        'weightOrder',
        'description',
        'versions',
        'createId',
        'createName',
        'createTimes',
        'modifyId',
        'modifyName',
        'modifyTimes'
      ],
      staffColumnsNexus: {
        staffId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        staffNo: { title: '员工工号', key: 'staffNo', minWidth: 200, sortable: true },
        staffName: { title: '员工姓名', key: 'staffName', minWidth: 200, sortable: true },
        mobilePhoneNumber: { title: '手机号', key: 'mobilePhoneNumber', minWidth: 200, sortable: true },
        gender: { title: '性别', key: 'gender', minWidth: 200, sortable: true },
        emergencyContactName: { title: '紧急联系人姓名', key: 'emergencyContactName', minWidth: 200, sortable: true },
        emergContMobilePhoneNumber: { title: '紧急联系人手机号', key: 'emergContMobilePhoneNumber', minWidth: 200, sortable: true },
        weightOrder: { title: '排序权重', key: 'weightOrder', minWidth: 200, sortable: true },
        description: { title: '描述', key: 'description', minWidth: 200, sortable: true },
        versions: { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        createId: { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        createName: { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        createTimes: { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        modifyId: { title: '修改人账号', key: 'modifyId', minWidth: 200, sortable: true },
        modifyName: { title: '修改人名称', key: 'modifyName', minWidth: 200, sortable: true },
        modifyTimes: { title: '修改时间', key: 'modifyTimes', minWidth: 200, sortable: true }
      },
      staffSet: [],
      staffCount: 0,
      staffRows: 10,
      staffPage: 1,
      staffSelectRow: [],
      staffSelectRowLength: 0,
      staff: new Staff(),
      staffQuery: new StaffQuery(),
      staffSpinShow: false,
      staffPageShow: true,
      staffEditModalShow: false,
      staffSubmitting: false,
      staffContinue: false,
      staffDetailDrawerShow: false,
      staffQueryPoptipShow: false,
      staffQuerySubmitting: false,
      staffKeySearchSubmitting: false,
      staffKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('staffStore', [
    ]),
    ...mapGetters('staffStore', [
    ])
  },
  methods: {
    ...mapMutations('staffStore', [
    ]),
    ...mapActions('staffStore', [
      'saveStaff',
      'updateStaff',
      'batchRemoveStaff',
      'getStaffByPk',
      'queryStaff',
      'pagingQueryStaff'
    ]),
    addStaff () {
      this.staffEditModalShow = true
      this.staff = new Staff()
    },
    upStaff () {
      this.staffEditModalShow = true
      let staffEdit = new Staff()
      staffEdit.staffId = this.staffSelectRow[0].staffId
      this.getStaffByPk(staffEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.staff, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toStaffList () {
      this.staffEditModalShow = false
      this.resetStaffForm()
      this.getStaffSet()
    },
    resetStaffForm () {
      this.$refs.staffForm.resetFields()
    },
    saveStaffForm () {
      this.staffContinue = false
      this.submitStaffForm()
    },
    saveAddStaffForm () {
      this.staffContinue = true
      this.submitStaffForm()
    },
    submitStaffForm () {
      this.staffSubmitting = true
      this.$refs.staffForm.validate((valid) => {
        if (valid) {
          if (this.staff.staffId) {
            this.updateStaff(this.staff).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '员工信息修改成功.', duration: 3 })
                this.resetStaffForm()
                this.staff = new Staff()
                this.staffSubmitting = false
                if (!this.staffContinue) {
                  this.toStaffList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.staffSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.staffSubmitting = false }, 3000)
            })
          } else {
            this.saveStaff(this.staff).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '员工信息保存成功.', duration: 3 })
                this.resetStaffForm()
                this.staff = new Staff()
                this.staffSubmitting = false
                if (!this.staffContinue) {
                  this.toStaffList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.staffSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.staffSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.staffSubmitting = false }, 3000)
        }
      })
    },
    delStaff () {
      this.staffSpinShow = true
      this.batchRemoveStaff(this.staffSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '员工信息删除成功.', duration: 3 })
          this.setStaffSelectRow([])
          this.getStaffSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.staffSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.staffSpinShow = false }, 700)
      })
    },
    detailStaff () {
      this.staffDetailDrawerShow = true
      let staffDetail = new Staff()
      staffDetail.staffId = this.staffSelectRow[0].staffId
      this.getStaffByPk(staffDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.staff, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailStaff (rowData) {
      this.staffDetailDrawerShow = true
      let staffDetail = new Staff()
      staffDetail.staffId = rowData.staffId
      this.getStaffByPk(staffDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.staff, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getStaffSet () {
      this.staffSpinShow = true
      this.staffPageShow = true
      this.pagingQueryStaff({ staffQuery: {}, rows: this.staffRows, page: this.staffPage }).then(res => {
        if (res.data.success) {
          this.staffSet = res.data.data
          this.staffCount = res.data.count
          this.setStaffSelectRow([])
          setTimeout(() => { this.staffSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.staffSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.staffSpinShow = false }, 700)
      })
    },
    keySearchStaff (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.staffKeySearchSubmitting = true
        this.staffPageShow = false
        this.staffSpinShow = true
        let staffQueryKeySearch = new StaffQuery()
        staffQueryKeySearch.staffNoAndKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.staffNameOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.mobilePhoneNumberOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.genderOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.emergencyContactNameOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.emergContMobilePhoneNumberOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.descriptionOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        staffQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        this.queryStaff(staffQueryKeySearch).then(res => {
          if (res.data.success) {
            this.staffSet = res.data.data
            this.staffCount = res.data.count
            this.setStaffSelectRow([])
            setTimeout(() => { this.staffSpinShow = false }, 700)
            setTimeout(() => { this.staffKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.staffSpinShow = false }, 700)
            setTimeout(() => { this.staffKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.staffSpinShow = false }, 700)
          setTimeout(() => { this.staffKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.staffKeySearchClickRate++
        if (this.staffKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.staffKeySearchClickRate = 0
        }
      }
    },
    vagueQueryStaff () {
      this.staffQuerySubmitting = true
      this.staffPageShow = false
      this.staffSpinShow = true
      this.staffQueryPoptipShow = false
      this.queryStaff(this.staffQuery).then(res => {
        if (res.data.success) {
          this.staffSet = res.data.data
          this.staffCount = res.data.count
          this.setStaffSelectRow([])
          setTimeout(() => { this.staffSpinShow = false }, 700)
          setTimeout(() => { this.staffQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.staffSpinShow = false }, 700)
          setTimeout(() => { this.staffQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.staffSpinShow = false }, 700)
        setTimeout(() => { this.staffQuerySubmitting = false }, 5000)
      })
    },
    resetStaffQueryForm () {
      this.$refs.staffQueryForm.resetFields()
    },
    setStaffSelectRow (list) {
      this.staffSelectRow = list
      this.staffSelectRowLength = list.length
    },
    staffPageIndexChange (pageIndex) {
      this.staffPage = pageIndex
      this.getStaffSet()
    },
    staffPageSizeChange (pageSize) {
      this.staffRows = pageSize
      this.staffPage = 1
      this.getStaffSet()
    },
    staffRefresh () {
      this.staffPage = 1
      this.getStaffSet()
    },
    changeStaffColumns () {
      this.staffColumns = []
      this.staffColumnsChecked.forEach(col => this.staffColumns.push(this.staffColumnsNexus[col]))
    },
    cleanStaffColumns () {
      this.staffColumnsChecked = [
        'staffId'
      ]
      this.staffColumns = []
      this.staffColumnsChecked.forEach(col => this.staffColumns.push(this.staffColumnsNexus[col]))
    },
    resetStaffColumns () {
      this.staffColumnsChecked = [
        'staffId',
        'staffNo',
        'staffName',
        'mobilePhoneNumber',
        'gender',
        'emergencyContactName',
        'emergContMobilePhoneNumber',
        'weightOrder',
        'description',
        'versions',
        'createId',
        'createName',
        'createTimes',
        'modifyId',
        'modifyName',
        'modifyTimes'
      ]
      this.staffColumns = []
      this.staffColumnsChecked.forEach(col => this.staffColumns.push(this.staffColumnsNexus[col]))
    }
  },
  mounted () {
    this.getStaffSet()
  }
}
</script>

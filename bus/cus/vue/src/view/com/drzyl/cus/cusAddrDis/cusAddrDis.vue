<style lang="less" scoped>
  @import './cusAddrDis.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="cusAddrDisKeySearchSubmitting" @on-search="keySearchCusAddrDis($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="cusAddrDisQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="cusAddrDisQueryForm" :model="cusAddrDisQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="客户ID：" prop="cusBaseId">
                      <Input v-model="cusAddrDisQuery.cusBaseId" placeholder="输入客户ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="所属机构：" prop="recAddress">
                      <Input v-model="cusAddrDisQuery.recAddress" placeholder="输入所属机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="cusAddrDisQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="附件IDs：" prop="uploadIds">
                      <Input v-model="cusAddrDisQuery.uploadIds" placeholder="输入附件IDs"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                      <Input v-model="cusAddrDisQuery.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程状态：" prop="actProcessStatus">
                      <Input v-model="cusAddrDisQuery.actProcessStatus" placeholder="输入流程状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="cusAddrDisQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="cusAddrDisQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="cusAddrDisQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="cusAddrDisQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="cusAddrDisQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="cusAddrDisQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="cusAddrDisQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改机构：" prop="modifyOrg">
                      <Input v-model="cusAddrDisQuery.modifyOrg" placeholder="输入修改机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="cusAddrDisQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="cusAddrDisQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryCusAddrDis()" :loading="cusAddrDisQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetCusAddrDisQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusAddrDis()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusAddrDis()" v-if="cusAddrDisSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusAddrDis()" v-if="cusAddrDisSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusAddrDis()" v-if="cusAddrDisSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="cusAddrDisColumnsChecked" @on-change="changeCusAddrDisColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusBaseId">客户ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="recAddress">所属机构</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="remark">备注</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="uploadIds">附件IDs</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="actProcessInstanceId">流程实例ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="actProcessStatus">流程状态</Checkbox>
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
                <Checkbox class="pro-margin-left-2" label="createOrg">创建机构</Checkbox>
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
                <Checkbox class="pro-margin-left-2" label="modifyOrg">修改机构</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="modifyTimes">修改时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="delFlag">逻辑删除0=删除,1=显示</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusAddrDisColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusAddrDisColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="cusAddrDisColumns" :data="cusAddrDisSet" @on-selection-change="setCusAddrDisSelectRow($event)" @on-row-dblclick="dblclickDetailCusAddrDis($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusAddrDisCount" :current="cusAddrDisPage" :page-size-opts="[10, 30, 50]" @on-change="cusAddrDisPageIndexChange($event)" @on-page-size-change="cusAddrDisPageSizeChange($event)" v-if="cusAddrDisPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="cusAddrDisRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="cusAddrDisSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="cusAddrDisEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑客户收货地址表
        </p>
        <Form class="pro-margin-top-20" ref="cusAddrDisForm" :model="cusAddrDis" :rules="cusAddrDisFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户ID：" prop="cusBaseId">
                <Input v-model="cusAddrDis.cusBaseId" placeholder="输入客户ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="所属机构：" prop="recAddress">
                <Input v-model="cusAddrDis.recAddress" placeholder="输入所属机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="cusAddrDis.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="附件IDs：" prop="uploadIds">
                <Input v-model="cusAddrDis.uploadIds" placeholder="输入附件IDs"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                <Input v-model="cusAddrDis.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程状态：" prop="actProcessStatus">
                <Input v-model="cusAddrDis.actProcessStatus" placeholder="输入流程状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="cusAddrDis.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="cusAddrDis.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="cusAddrDis.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="cusAddrDis.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="cusAddrDis.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="cusAddrDis.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="cusAddrDis.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改机构：" prop="modifyOrg">
                <Input v-model="cusAddrDis.modifyOrg" placeholder="输入修改机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="cusAddrDis.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="cusAddrDis.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toCusAddrDisList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetCusAddrDisForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusAddrDisSubmitting" @click="saveCusAddrDisForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusAddrDisSubmitting" @click="saveAddCusAddrDisForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="cusAddrDisDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户收货地址表详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ cusAddrDis.cusAddrDisId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户ID：{{ cusAddrDis.cusBaseId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>所属机构：{{ cusAddrDis.recAddress }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ cusAddrDis.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>附件IDs：{{ cusAddrDis.uploadIds }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程实例ID：{{ cusAddrDis.actProcessInstanceId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程状态：{{ cusAddrDis.actProcessStatus }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ cusAddrDis.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ cusAddrDis.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ cusAddrDis.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ cusAddrDis.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ cusAddrDis.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ cusAddrDis.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ cusAddrDis.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改机构：{{ cusAddrDis.modifyOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ cusAddrDis.modifyTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ cusAddrDis.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusAddrDis from '@/view/com/drzyl/cus/cusAddrDis/CusAddrDis'
import CusAddrDisQuery from '@/view/com/drzyl/cus/cusAddrDis/CusAddrDisQuery'

export default {
  data () {
    return {
      cusAddrDisColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        { title: '所属机构', key: 'recAddress', minWidth: 200, sortable: true },
        { title: '备注', key: 'remark', minWidth: 200, sortable: true },
        { title: '附件IDs', key: 'uploadIds', minWidth: 200, sortable: true },
        { title: '流程实例ID', key: 'actProcessInstanceId', minWidth: 200, sortable: true },
        { title: '流程状态', key: 'actProcessStatus', minWidth: 200, sortable: true },
        { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        { title: '创建机构', key: 'createOrg', minWidth: 200, sortable: true },
        { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        { title: '修改人账号', key: 'modifyId', minWidth: 200, sortable: true },
        { title: '修改人名称', key: 'modifyName', minWidth: 200, sortable: true },
        { title: '修改机构', key: 'modifyOrg', minWidth: 200, sortable: true },
        { title: '修改时间', key: 'modifyTimes', minWidth: 200, sortable: true },
        { title: '逻辑删除0=删除,1=显示', key: 'delFlag', minWidth: 200, sortable: true }
      ],
      cusAddrDisFormValidate: {
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
      cusAddrDisColumnsChecked: [
        'cusAddrDisId',
        'cusBaseId',
        'recAddress',
        'remark',
        'uploadIds',
        'actProcessInstanceId',
        'actProcessStatus',
        'versions',
        'createId',
        'createName',
        'createOrg',
        'createTimes',
        'modifyId',
        'modifyName',
        'modifyOrg',
        'modifyTimes',
        'delFlag'
      ],
      cusAddrDisColumnsNexus: {
        cusAddrDisId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        cusBaseId: { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        recAddress: { title: '所属机构', key: 'recAddress', minWidth: 200, sortable: true },
        remark: { title: '备注', key: 'remark', minWidth: 200, sortable: true },
        uploadIds: { title: '附件IDs', key: 'uploadIds', minWidth: 200, sortable: true },
        actProcessInstanceId: { title: '流程实例ID', key: 'actProcessInstanceId', minWidth: 200, sortable: true },
        actProcessStatus: { title: '流程状态', key: 'actProcessStatus', minWidth: 200, sortable: true },
        versions: { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        createId: { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        createName: { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        createOrg: { title: '创建机构', key: 'createOrg', minWidth: 200, sortable: true },
        createTimes: { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        modifyId: { title: '修改人账号', key: 'modifyId', minWidth: 200, sortable: true },
        modifyName: { title: '修改人名称', key: 'modifyName', minWidth: 200, sortable: true },
        modifyOrg: { title: '修改机构', key: 'modifyOrg', minWidth: 200, sortable: true },
        modifyTimes: { title: '修改时间', key: 'modifyTimes', minWidth: 200, sortable: true },
        delFlag: { title: '逻辑删除0=删除,1=显示', key: 'delFlag', minWidth: 200, sortable: true }
      },
      cusAddrDisSet: [],
      cusAddrDisCount: 0,
      cusAddrDisRows: 10,
      cusAddrDisPage: 1,
      cusAddrDisSelectRow: [],
      cusAddrDisSelectRowLength: 0,
      cusAddrDis: new CusAddrDis(),
      cusAddrDisQuery: new CusAddrDisQuery(),
      cusAddrDisSpinShow: false,
      cusAddrDisPageShow: true,
      cusAddrDisEditModalShow: false,
      cusAddrDisSubmitting: false,
      cusAddrDisContinue: false,
      cusAddrDisDetailDrawerShow: false,
      cusAddrDisQueryPoptipShow: false,
      cusAddrDisQuerySubmitting: false,
      cusAddrDisKeySearchSubmitting: false,
      cusAddrDisKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('cusAddrDisStore', [
    ]),
    ...mapGetters('cusAddrDisStore', [
    ])
  },
  methods: {
    ...mapMutations('cusAddrDisStore', [
    ]),
    ...mapActions('cusAddrDisStore', [
      'saveCusAddrDis',
      'updateCusAddrDis',
      'batchRemoveCusAddrDis',
      'getCusAddrDisByPk',
      'queryCusAddrDis',
      'pagingQueryCusAddrDis'
    ]),
    addCusAddrDis () {
      this.cusAddrDisEditModalShow = true
      this.cusAddrDis = new CusAddrDis()
    },
    upCusAddrDis () {
      this.cusAddrDisEditModalShow = true
      let cusAddrDisEdit = new CusAddrDis()
      cusAddrDisEdit.cusAddrDisId = this.cusAddrDisSelectRow[0].cusAddrDisId
      this.getCusAddrDisByPk(cusAddrDisEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAddrDis, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toCusAddrDisList () {
      this.cusAddrDisEditModalShow = false
      this.resetCusAddrDisForm()
      this.getCusAddrDisSet()
    },
    resetCusAddrDisForm () {
      this.$refs.cusAddrDisForm.resetFields()
    },
    saveCusAddrDisForm () {
      this.cusAddrDisContinue = false
      this.submitCusAddrDisForm()
    },
    saveAddCusAddrDisForm () {
      this.cusAddrDisContinue = true
      this.submitCusAddrDisForm()
    },
    submitCusAddrDisForm () {
      this.cusAddrDisSubmitting = true
      this.$refs.cusAddrDisForm.validate((valid) => {
        if (valid) {
          if (this.cusAddrDis.cusAddrDisId) {
            this.updateCusAddrDis(this.cusAddrDis).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户收货地址表信息修改成功.', duration: 3 })
                this.resetCusAddrDisForm()
                this.cusAddrDis = new CusAddrDis()
                this.cusAddrDisSubmitting = false
                if (!this.cusAddrDisContinue) {
                  this.toCusAddrDisList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusAddrDisSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusAddrDisSubmitting = false }, 3000)
            })
          } else {
            this.saveCusAddrDis(this.cusAddrDis).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户收货地址表信息保存成功.', duration: 3 })
                this.resetCusAddrDisForm()
                this.cusAddrDis = new CusAddrDis()
                this.cusAddrDisSubmitting = false
                if (!this.cusAddrDisContinue) {
                  this.toCusAddrDisList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusAddrDisSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusAddrDisSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.cusAddrDisSubmitting = false }, 3000)
        }
      })
    },
    delCusAddrDis () {
      this.cusAddrDisSpinShow = true
      this.batchRemoveCusAddrDis(this.cusAddrDisSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '客户收货地址表信息删除成功.', duration: 3 })
          this.setCusAddrDisSelectRow([])
          this.getCusAddrDisSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
      })
    },
    detailCusAddrDis () {
      this.cusAddrDisDetailDrawerShow = true
      let cusAddrDisDetail = new CusAddrDis()
      cusAddrDisDetail.cusAddrDisId = this.cusAddrDisSelectRow[0].cusAddrDisId
      this.getCusAddrDisByPk(cusAddrDisDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAddrDis, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailCusAddrDis (rowData) {
      this.cusAddrDisDetailDrawerShow = true
      let cusAddrDisDetail = new CusAddrDis()
      cusAddrDisDetail.cusAddrDisId = rowData.cusAddrDisId
      this.getCusAddrDisByPk(cusAddrDisDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAddrDis, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getCusAddrDisSet () {
      this.cusAddrDisSpinShow = true
      this.cusAddrDisPageShow = true
      this.pagingQueryCusAddrDis({ cusAddrDisQuery: {}, rows: this.cusAddrDisRows, page: this.cusAddrDisPage }).then(res => {
        if (res.data.success) {
          this.cusAddrDisSet = res.data.data
          this.cusAddrDisCount = res.data.count
          this.setCusAddrDisSelectRow([])
          setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
      })
    },
    keySearchCusAddrDis (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.cusAddrDisKeySearchSubmitting = true
        this.cusAddrDisPageShow = false
        this.cusAddrDisSpinShow = true
        let cusAddrDisQueryKeySearch = new CusAddrDisQuery()
        cusAddrDisQueryKeySearch.cusBaseIdAndKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.recAddressOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.uploadIdsOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.actProcessInstanceIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.actProcessStatusOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusAddrDisQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryCusAddrDis(cusAddrDisQueryKeySearch).then(res => {
          if (res.data.success) {
            this.cusAddrDisSet = res.data.data
            this.cusAddrDisCount = res.data.count
            this.setCusAddrDisSelectRow([])
            setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
            setTimeout(() => { this.cusAddrDisKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
            setTimeout(() => { this.cusAddrDisKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
          setTimeout(() => { this.cusAddrDisKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.cusAddrDisKeySearchClickRate++
        if (this.cusAddrDisKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.cusAddrDisKeySearchClickRate = 0
        }
      }
    },
    vagueQueryCusAddrDis () {
      this.cusAddrDisQuerySubmitting = true
      this.cusAddrDisPageShow = false
      this.cusAddrDisSpinShow = true
      this.cusAddrDisQueryPoptipShow = false
      this.queryCusAddrDis(this.cusAddrDisQuery).then(res => {
        if (res.data.success) {
          this.cusAddrDisSet = res.data.data
          this.cusAddrDisCount = res.data.count
          this.setCusAddrDisSelectRow([])
          setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
          setTimeout(() => { this.cusAddrDisQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
          setTimeout(() => { this.cusAddrDisQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAddrDisSpinShow = false }, 700)
        setTimeout(() => { this.cusAddrDisQuerySubmitting = false }, 5000)
      })
    },
    resetCusAddrDisQueryForm () {
      this.$refs.cusAddrDisQueryForm.resetFields()
    },
    setCusAddrDisSelectRow (list) {
      this.cusAddrDisSelectRow = list
      this.cusAddrDisSelectRowLength = list.length
    },
    cusAddrDisPageIndexChange (pageIndex) {
      this.cusAddrDisPage = pageIndex
      this.getCusAddrDisSet()
    },
    cusAddrDisPageSizeChange (pageSize) {
      this.cusAddrDisRows = pageSize
      this.cusAddrDisPage = 1
      this.getCusAddrDisSet()
    },
    cusAddrDisRefresh () {
      this.cusAddrDisPage = 1
      this.getCusAddrDisSet()
    },
    changeCusAddrDisColumns () {
      this.cusAddrDisColumns = []
      this.cusAddrDisColumnsChecked.forEach(col => this.cusAddrDisColumns.push(this.cusAddrDisColumnsNexus[col]))
    },
    cleanCusAddrDisColumns () {
      this.cusAddrDisColumnsChecked = [
        'cusAddrDisId'
      ]
      this.cusAddrDisColumns = []
      this.cusAddrDisColumnsChecked.forEach(col => this.cusAddrDisColumns.push(this.cusAddrDisColumnsNexus[col]))
    },
    resetCusAddrDisColumns () {
      this.cusAddrDisColumnsChecked = [
        'cusAddrDisId',
        'cusBaseId',
        'recAddress',
        'remark',
        'uploadIds',
        'actProcessInstanceId',
        'actProcessStatus',
        'versions',
        'createId',
        'createName',
        'createOrg',
        'createTimes',
        'modifyId',
        'modifyName',
        'modifyOrg',
        'modifyTimes',
        'delFlag'
      ]
      this.cusAddrDisColumns = []
      this.cusAddrDisColumnsChecked.forEach(col => this.cusAddrDisColumns.push(this.cusAddrDisColumnsNexus[col]))
    }
  },
  mounted () {
    this.getCusAddrDisSet()
  }
}
</script>

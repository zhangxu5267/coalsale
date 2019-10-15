<style lang="less" scoped>
  @import './cusTag.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="cusTagKeySearchSubmitting" @on-search="keySearchCusTag($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="cusTagQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="cusTagQueryForm" :model="cusTagQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="标签编号：" prop="tagNo">
                      <Input v-model="cusTagQuery.tagNo" placeholder="输入标签编号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="标签名称：" prop="tagName">
                      <Input v-model="cusTagQuery.tagName" placeholder="输入标签名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="标签状态：" prop="tagState">
                      <Input v-model="cusTagQuery.tagState" placeholder="输入标签状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="cusTagQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="附件IDs：" prop="uploadIds">
                      <Input v-model="cusTagQuery.uploadIds" placeholder="输入附件IDs"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                      <Input v-model="cusTagQuery.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程状态：" prop="actProcessStatus">
                      <Input v-model="cusTagQuery.actProcessStatus" placeholder="输入流程状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="cusTagQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="cusTagQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="cusTagQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="cusTagQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="cusTagQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="cusTagQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="cusTagQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改机构：" prop="modifyOrg">
                      <Input v-model="cusTagQuery.modifyOrg" placeholder="输入修改机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="cusTagQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="cusTagQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryCusTag()" :loading="cusTagQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetCusTagQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusTag()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusTag()" v-if="cusTagSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusTag()" v-if="cusTagSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusTag()" v-if="cusTagSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="cusTagColumnsChecked" @on-change="changeCusTagColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="tagNo">标签编号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="tagName">标签名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="tagState">标签状态</Checkbox>
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
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusTagColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusTagColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="cusTagColumns" :data="cusTagSet" @on-selection-change="setCusTagSelectRow($event)" @on-row-dblclick="dblclickDetailCusTag($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusTagCount" :current="cusTagPage" :page-size-opts="[10, 30, 50]" @on-change="cusTagPageIndexChange($event)" @on-page-size-change="cusTagPageSizeChange($event)" v-if="cusTagPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="cusTagRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="cusTagSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="cusTagEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑客户标签表
        </p>
        <Form class="pro-margin-top-20" ref="cusTagForm" :model="cusTag" :rules="cusTagFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="标签编号：" prop="tagNo">
                <Input v-model="cusTag.tagNo" placeholder="输入标签编号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="标签名称：" prop="tagName">
                <Input v-model="cusTag.tagName" placeholder="输入标签名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="标签状态：" prop="tagState">
                <Input v-model="cusTag.tagState" placeholder="输入标签状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="cusTag.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="附件IDs：" prop="uploadIds">
                <Input v-model="cusTag.uploadIds" placeholder="输入附件IDs"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                <Input v-model="cusTag.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程状态：" prop="actProcessStatus">
                <Input v-model="cusTag.actProcessStatus" placeholder="输入流程状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="cusTag.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="cusTag.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="cusTag.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="cusTag.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="cusTag.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="cusTag.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="cusTag.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改机构：" prop="modifyOrg">
                <Input v-model="cusTag.modifyOrg" placeholder="输入修改机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="cusTag.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="cusTag.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toCusTagList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetCusTagForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusTagSubmitting" @click="saveCusTagForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusTagSubmitting" @click="saveAddCusTagForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="cusTagDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户标签表详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ cusTag.cusTagId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>标签编号：{{ cusTag.tagNo }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>标签名称：{{ cusTag.tagName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>标签状态：{{ cusTag.tagState }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ cusTag.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>附件IDs：{{ cusTag.uploadIds }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程实例ID：{{ cusTag.actProcessInstanceId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程状态：{{ cusTag.actProcessStatus }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ cusTag.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ cusTag.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ cusTag.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ cusTag.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ cusTag.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ cusTag.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ cusTag.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改机构：{{ cusTag.modifyOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ cusTag.modifyTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ cusTag.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusTag from '@/view/com/drzyl/cus/cusTag/CusTag'
import CusTagQuery from '@/view/com/drzyl/cus/cusTag/CusTagQuery'

export default {
  data () {
    return {
      cusTagColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '标签编号', key: 'tagNo', minWidth: 200, sortable: true },
        { title: '标签名称', key: 'tagName', minWidth: 200, sortable: true },
        { title: '标签状态', key: 'tagState', minWidth: 200, sortable: true },
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
      cusTagFormValidate: {
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
      cusTagColumnsChecked: [
        'cusTagId',
        'tagNo',
        'tagName',
        'tagState',
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
      cusTagColumnsNexus: {
        cusTagId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        tagNo: { title: '标签编号', key: 'tagNo', minWidth: 200, sortable: true },
        tagName: { title: '标签名称', key: 'tagName', minWidth: 200, sortable: true },
        tagState: { title: '标签状态', key: 'tagState', minWidth: 200, sortable: true },
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
      cusTagSet: [],
      cusTagCount: 0,
      cusTagRows: 10,
      cusTagPage: 1,
      cusTagSelectRow: [],
      cusTagSelectRowLength: 0,
      cusTag: new CusTag(),
      cusTagQuery: new CusTagQuery(),
      cusTagSpinShow: false,
      cusTagPageShow: true,
      cusTagEditModalShow: false,
      cusTagSubmitting: false,
      cusTagContinue: false,
      cusTagDetailDrawerShow: false,
      cusTagQueryPoptipShow: false,
      cusTagQuerySubmitting: false,
      cusTagKeySearchSubmitting: false,
      cusTagKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('cusTagStore', [
    ]),
    ...mapGetters('cusTagStore', [
    ])
  },
  methods: {
    ...mapMutations('cusTagStore', [
    ]),
    ...mapActions('cusTagStore', [
      'saveCusTag',
      'updateCusTag',
      'batchRemoveCusTag',
      'getCusTagByPk',
      'queryCusTag',
      'pagingQueryCusTag'
    ]),
    addCusTag () {
      this.cusTagEditModalShow = true
      this.cusTag = new CusTag()
    },
    upCusTag () {
      this.cusTagEditModalShow = true
      let cusTagEdit = new CusTag()
      cusTagEdit.cusTagId = this.cusTagSelectRow[0].cusTagId
      this.getCusTagByPk(cusTagEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.cusTag, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toCusTagList () {
      this.cusTagEditModalShow = false
      this.resetCusTagForm()
      this.getCusTagSet()
    },
    resetCusTagForm () {
      this.$refs.cusTagForm.resetFields()
    },
    saveCusTagForm () {
      this.cusTagContinue = false
      this.submitCusTagForm()
    },
    saveAddCusTagForm () {
      this.cusTagContinue = true
      this.submitCusTagForm()
    },
    submitCusTagForm () {
      this.cusTagSubmitting = true
      this.$refs.cusTagForm.validate((valid) => {
        if (valid) {
          if (this.cusTag.cusTagId) {
            this.updateCusTag(this.cusTag).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户标签表信息修改成功.', duration: 3 })
                this.resetCusTagForm()
                this.cusTag = new CusTag()
                this.cusTagSubmitting = false
                if (!this.cusTagContinue) {
                  this.toCusTagList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusTagSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusTagSubmitting = false }, 3000)
            })
          } else {
            this.saveCusTag(this.cusTag).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户标签表信息保存成功.', duration: 3 })
                this.resetCusTagForm()
                this.cusTag = new CusTag()
                this.cusTagSubmitting = false
                if (!this.cusTagContinue) {
                  this.toCusTagList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusTagSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusTagSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.cusTagSubmitting = false }, 3000)
        }
      })
    },
    delCusTag () {
      this.cusTagSpinShow = true
      this.batchRemoveCusTag(this.cusTagSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '客户标签表信息删除成功.', duration: 3 })
          this.setCusTagSelectRow([])
          this.getCusTagSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusTagSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusTagSpinShow = false }, 700)
      })
    },
    detailCusTag () {
      this.cusTagDetailDrawerShow = true
      let cusTagDetail = new CusTag()
      cusTagDetail.cusTagId = this.cusTagSelectRow[0].cusTagId
      this.getCusTagByPk(cusTagDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusTag, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailCusTag (rowData) {
      this.cusTagDetailDrawerShow = true
      let cusTagDetail = new CusTag()
      cusTagDetail.cusTagId = rowData.cusTagId
      this.getCusTagByPk(cusTagDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusTag, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getCusTagSet () {
      this.cusTagSpinShow = true
      this.cusTagPageShow = true
      this.pagingQueryCusTag({ cusTagQuery: {}, rows: this.cusTagRows, page: this.cusTagPage }).then(res => {
        if (res.data.success) {
          this.cusTagSet = res.data.data
          this.cusTagCount = res.data.count
          this.setCusTagSelectRow([])
          setTimeout(() => { this.cusTagSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusTagSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusTagSpinShow = false }, 700)
      })
    },
    keySearchCusTag (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.cusTagKeySearchSubmitting = true
        this.cusTagPageShow = false
        this.cusTagSpinShow = true
        let cusTagQueryKeySearch = new CusTagQuery()
        cusTagQueryKeySearch.tagNoAndKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.tagNameOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.tagStateOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.uploadIdsOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.actProcessInstanceIdOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.actProcessStatusOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusTagQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryCusTag(cusTagQueryKeySearch).then(res => {
          if (res.data.success) {
            this.cusTagSet = res.data.data
            this.cusTagCount = res.data.count
            this.setCusTagSelectRow([])
            setTimeout(() => { this.cusTagSpinShow = false }, 700)
            setTimeout(() => { this.cusTagKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.cusTagSpinShow = false }, 700)
            setTimeout(() => { this.cusTagKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.cusTagSpinShow = false }, 700)
          setTimeout(() => { this.cusTagKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.cusTagKeySearchClickRate++
        if (this.cusTagKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.cusTagKeySearchClickRate = 0
        }
      }
    },
    vagueQueryCusTag () {
      this.cusTagQuerySubmitting = true
      this.cusTagPageShow = false
      this.cusTagSpinShow = true
      this.cusTagQueryPoptipShow = false
      this.queryCusTag(this.cusTagQuery).then(res => {
        if (res.data.success) {
          this.cusTagSet = res.data.data
          this.cusTagCount = res.data.count
          this.setCusTagSelectRow([])
          setTimeout(() => { this.cusTagSpinShow = false }, 700)
          setTimeout(() => { this.cusTagQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusTagSpinShow = false }, 700)
          setTimeout(() => { this.cusTagQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusTagSpinShow = false }, 700)
        setTimeout(() => { this.cusTagQuerySubmitting = false }, 5000)
      })
    },
    resetCusTagQueryForm () {
      this.$refs.cusTagQueryForm.resetFields()
    },
    setCusTagSelectRow (list) {
      this.cusTagSelectRow = list
      this.cusTagSelectRowLength = list.length
    },
    cusTagPageIndexChange (pageIndex) {
      this.cusTagPage = pageIndex
      this.getCusTagSet()
    },
    cusTagPageSizeChange (pageSize) {
      this.cusTagRows = pageSize
      this.cusTagPage = 1
      this.getCusTagSet()
    },
    cusTagRefresh () {
      this.cusTagPage = 1
      this.getCusTagSet()
    },
    changeCusTagColumns () {
      this.cusTagColumns = []
      this.cusTagColumnsChecked.forEach(col => this.cusTagColumns.push(this.cusTagColumnsNexus[col]))
    },
    cleanCusTagColumns () {
      this.cusTagColumnsChecked = [
        'cusTagId'
      ]
      this.cusTagColumns = []
      this.cusTagColumnsChecked.forEach(col => this.cusTagColumns.push(this.cusTagColumnsNexus[col]))
    },
    resetCusTagColumns () {
      this.cusTagColumnsChecked = [
        'cusTagId',
        'tagNo',
        'tagName',
        'tagState',
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
      this.cusTagColumns = []
      this.cusTagColumnsChecked.forEach(col => this.cusTagColumns.push(this.cusTagColumnsNexus[col]))
    }
  },
  mounted () {
    this.getCusTagSet()
  }
}
</script>

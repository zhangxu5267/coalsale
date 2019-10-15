<style lang="less" scoped>
  @import './uploadFile.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="uploadFileKeySearchSubmitting" @on-search="keySearchUploadFile($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="uploadFileQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="uploadFileQueryForm" :model="uploadFileQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="文件名称：" prop="fileName">
                      <Input v-model="uploadFileQuery.fileName" placeholder="输入文件名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="文件路径：" prop="fileUrl">
                      <Input v-model="uploadFileQuery.fileUrl" placeholder="输入文件路径"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="文件类型：" prop="fileType">
                      <Input v-model="uploadFileQuery.fileType" placeholder="输入文件类型"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="文件大小(单位B)：" prop="fileSize">
                      <Input v-model="uploadFileQuery.fileSize" placeholder="输入文件大小(单位B)"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="文件后缀：" prop="fileSuffix">
                      <Input v-model="uploadFileQuery.fileSuffix" placeholder="输入文件后缀"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="文件来源模块：" prop="module">
                      <Input v-model="uploadFileQuery.module" placeholder="输入文件来源模块"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="来源HASH：" prop="moduleHash">
                      <Input v-model="uploadFileQuery.moduleHash" placeholder="输入来源HASH"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="uploadFileQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="uploadFileQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="uploadFileQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="uploadFileQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="uploadFileQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="uploadFileQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="uploadFileQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryUploadFile()" :loading="uploadFileQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetUploadFileQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addUploadFile()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upUploadFile()" v-if="uploadFileSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delUploadFile()" v-if="uploadFileSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailUploadFile()" v-if="uploadFileSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="uploadFileColumnsChecked" @on-change="changeUploadFileColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="fileName">文件名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="fileUrl">文件路径</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="fileType">文件类型</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="fileSize">文件大小(单位B)</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="fileSuffix">文件后缀</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="module">文件来源模块</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="moduleHash">来源HASH</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="remark">备注</Checkbox>
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
                <Checkbox class="pro-margin-left-2" label="delFlag">逻辑删除0=删除,1=显示</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanUploadFileColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetUploadFileColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="uploadFileColumns" :data="uploadFileSet" @on-selection-change="setUploadFileSelectRow($event)" @on-row-dblclick="dblclickDetailUploadFile($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="uploadFileCount" :current="uploadFilePage" :page-size-opts="[10, 30, 50]" @on-change="uploadFilePageIndexChange($event)" @on-page-size-change="uploadFilePageSizeChange($event)" v-if="uploadFilePageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="uploadFileRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="uploadFileSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="uploadFileEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑上传文件
        </p>
        <Form class="pro-margin-top-20" ref="uploadFileForm" :model="uploadFile" :rules="uploadFileFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="文件名称：" prop="fileName">
                <Input v-model="uploadFile.fileName" placeholder="输入文件名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="文件路径：" prop="fileUrl">
                <Input v-model="uploadFile.fileUrl" placeholder="输入文件路径"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="文件类型：" prop="fileType">
                <Input v-model="uploadFile.fileType" placeholder="输入文件类型"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="文件大小(单位B)：" prop="fileSize">
                <Input v-model="uploadFile.fileSize" placeholder="输入文件大小(单位B)"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="文件后缀：" prop="fileSuffix">
                <Input v-model="uploadFile.fileSuffix" placeholder="输入文件后缀"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="文件来源模块：" prop="module">
                <Input v-model="uploadFile.module" placeholder="输入文件来源模块"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="来源HASH：" prop="moduleHash">
                <Input v-model="uploadFile.moduleHash" placeholder="输入来源HASH"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="uploadFile.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="uploadFile.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="uploadFile.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="uploadFile.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="uploadFile.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="uploadFile.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="uploadFile.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toUploadFileList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetUploadFileForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="uploadFileSubmitting" @click="saveUploadFileForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="uploadFileSubmitting" @click="saveAddUploadFileForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="uploadFileDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          上传文件详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ uploadFile.fileId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>文件名称：{{ uploadFile.fileName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>文件路径：{{ uploadFile.fileUrl }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>文件类型：{{ uploadFile.fileType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>文件大小(单位B)：{{ uploadFile.fileSize }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>文件后缀：{{ uploadFile.fileSuffix }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>文件来源模块：{{ uploadFile.module }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>来源HASH：{{ uploadFile.moduleHash }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ uploadFile.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ uploadFile.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ uploadFile.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ uploadFile.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ uploadFile.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ uploadFile.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ uploadFile.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import UploadFile from '@/view/com/drzyl/upload/file/uploadFile/UploadFile'
import UploadFileQuery from '@/view/com/drzyl/upload/file/uploadFile/UploadFileQuery'

export default {
  data () {
    return {
      uploadFileColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '文件名称', key: 'fileName', minWidth: 200, sortable: true },
        { title: '文件路径', key: 'fileUrl', minWidth: 200, sortable: true },
        { title: '文件类型', key: 'fileType', minWidth: 200, sortable: true },
        { title: '文件大小(单位B)', key: 'fileSize', minWidth: 200, sortable: true },
        { title: '文件后缀', key: 'fileSuffix', minWidth: 200, sortable: true },
        { title: '文件来源模块', key: 'module', minWidth: 200, sortable: true },
        { title: '来源HASH', key: 'moduleHash', minWidth: 200, sortable: true },
        { title: '备注', key: 'remark', minWidth: 200, sortable: true },
        { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        { title: '创建机构', key: 'createOrg', minWidth: 200, sortable: true },
        { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        { title: '逻辑删除0=删除,1=显示', key: 'delFlag', minWidth: 200, sortable: true }
      ],
      uploadFileFormValidate: {
        fileName: [
          { required: true, message: '文件名称不能为空', trigger: 'blur' }
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
      uploadFileColumnsChecked: [
        'fileId',
        'fileName',
        'fileUrl',
        'fileType',
        'fileSize',
        'fileSuffix',
        'module',
        'moduleHash',
        'remark',
        'versions',
        'createId',
        'createName',
        'createOrg',
        'createTimes',
        'delFlag'
      ],
      uploadFileColumnsNexus: {
        fileId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        fileName: { title: '文件名称', key: 'fileName', minWidth: 200, sortable: true },
        fileUrl: { title: '文件路径', key: 'fileUrl', minWidth: 200, sortable: true },
        fileType: { title: '文件类型', key: 'fileType', minWidth: 200, sortable: true },
        fileSize: { title: '文件大小(单位B)', key: 'fileSize', minWidth: 200, sortable: true },
        fileSuffix: { title: '文件后缀', key: 'fileSuffix', minWidth: 200, sortable: true },
        module: { title: '文件来源模块', key: 'module', minWidth: 200, sortable: true },
        moduleHash: { title: '来源HASH', key: 'moduleHash', minWidth: 200, sortable: true },
        remark: { title: '备注', key: 'remark', minWidth: 200, sortable: true },
        versions: { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        createId: { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        createName: { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        createOrg: { title: '创建机构', key: 'createOrg', minWidth: 200, sortable: true },
        createTimes: { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        delFlag: { title: '逻辑删除0=删除,1=显示', key: 'delFlag', minWidth: 200, sortable: true }
      },
      uploadFileSet: [],
      uploadFileCount: 0,
      uploadFileRows: 10,
      uploadFilePage: 1,
      uploadFileSelectRow: [],
      uploadFileSelectRowLength: 0,
      uploadFile: new UploadFile(),
      uploadFileQuery: new UploadFileQuery(),
      uploadFileSpinShow: false,
      uploadFilePageShow: true,
      uploadFileEditModalShow: false,
      uploadFileSubmitting: false,
      uploadFileContinue: false,
      uploadFileDetailDrawerShow: false,
      uploadFileQueryPoptipShow: false,
      uploadFileQuerySubmitting: false,
      uploadFileKeySearchSubmitting: false,
      uploadFileKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('uploadFileStore', [
    ]),
    ...mapGetters('uploadFileStore', [
    ])
  },
  methods: {
    ...mapMutations('uploadFileStore', [
    ]),
    ...mapActions('uploadFileStore', [
      'saveUploadFile',
      'updateUploadFile',
      'batchRemoveUploadFile',
      'getUploadFileByPk',
      'queryUploadFile',
      'pagingQueryUploadFile'
    ]),
    addUploadFile () {
      this.uploadFileEditModalShow = true
      this.uploadFile = new UploadFile()
    },
    upUploadFile () {
      this.uploadFileEditModalShow = true
      let uploadFileEdit = new UploadFile()
      uploadFileEdit.fileId = this.uploadFileSelectRow[0].fileId
      this.getUploadFileByPk(uploadFileEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.uploadFile, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toUploadFileList () {
      this.uploadFileEditModalShow = false
      this.resetUploadFileForm()
      this.getUploadFileSet()
    },
    resetUploadFileForm () {
      this.$refs.uploadFileForm.resetFields()
    },
    saveUploadFileForm () {
      this.uploadFileContinue = false
      this.submitUploadFileForm()
    },
    saveAddUploadFileForm () {
      this.uploadFileContinue = true
      this.submitUploadFileForm()
    },
    submitUploadFileForm () {
      this.uploadFileSubmitting = true
      this.$refs.uploadFileForm.validate((valid) => {
        if (valid) {
          if (this.uploadFile.fileId) {
            this.updateUploadFile(this.uploadFile).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '上传文件信息修改成功.', duration: 3 })
                this.resetUploadFileForm()
                this.uploadFile = new UploadFile()
                this.uploadFileSubmitting = false
                if (!this.uploadFileContinue) {
                  this.toUploadFileList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.uploadFileSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.uploadFileSubmitting = false }, 3000)
            })
          } else {
            this.saveUploadFile(this.uploadFile).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '上传文件信息保存成功.', duration: 3 })
                this.resetUploadFileForm()
                this.uploadFile = new UploadFile()
                this.uploadFileSubmitting = false
                if (!this.uploadFileContinue) {
                  this.toUploadFileList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.uploadFileSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.uploadFileSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.uploadFileSubmitting = false }, 3000)
        }
      })
    },
    delUploadFile () {
      this.uploadFileSpinShow = true
      this.batchRemoveUploadFile(this.uploadFileSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '上传文件信息删除成功.', duration: 3 })
          this.setUploadFileSelectRow([])
          this.getUploadFileSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.uploadFileSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.uploadFileSpinShow = false }, 700)
      })
    },
    detailUploadFile () {
      this.uploadFileDetailDrawerShow = true
      let uploadFileDetail = new UploadFile()
      uploadFileDetail.fileId = this.uploadFileSelectRow[0].fileId
      this.getUploadFileByPk(uploadFileDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.uploadFile, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailUploadFile (rowData) {
      this.uploadFileDetailDrawerShow = true
      let uploadFileDetail = new UploadFile()
      uploadFileDetail.fileId = rowData.fileId
      this.getUploadFileByPk(uploadFileDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.uploadFile, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getUploadFileSet () {
      this.uploadFileSpinShow = true
      this.uploadFilePageShow = true
      this.pagingQueryUploadFile({ uploadFileQuery: {}, rows: this.uploadFileRows, page: this.uploadFilePage }).then(res => {
        if (res.data.success) {
          this.uploadFileSet = res.data.data
          this.uploadFileCount = res.data.count
          this.setUploadFileSelectRow([])
          setTimeout(() => { this.uploadFileSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.uploadFileSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.uploadFileSpinShow = false }, 700)
      })
    },
    keySearchUploadFile (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.uploadFileKeySearchSubmitting = true
        this.uploadFilePageShow = false
        this.uploadFileSpinShow = true
        let uploadFileQueryKeySearch = new UploadFileQuery()
        uploadFileQueryKeySearch.fileNameAndKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.fileUrlOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.fileTypeOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.fileSizeOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.fileSuffixOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.moduleOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.moduleHashOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        uploadFileQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryUploadFile(uploadFileQueryKeySearch).then(res => {
          if (res.data.success) {
            this.uploadFileSet = res.data.data
            this.uploadFileCount = res.data.count
            this.setUploadFileSelectRow([])
            setTimeout(() => { this.uploadFileSpinShow = false }, 700)
            setTimeout(() => { this.uploadFileKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.uploadFileSpinShow = false }, 700)
            setTimeout(() => { this.uploadFileKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.uploadFileSpinShow = false }, 700)
          setTimeout(() => { this.uploadFileKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.uploadFileKeySearchClickRate++
        if (this.uploadFileKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.uploadFileKeySearchClickRate = 0
        }
      }
    },
    vagueQueryUploadFile () {
      this.uploadFileQuerySubmitting = true
      this.uploadFilePageShow = false
      this.uploadFileSpinShow = true
      this.uploadFileQueryPoptipShow = false
      this.queryUploadFile(this.uploadFileQuery).then(res => {
        if (res.data.success) {
          this.uploadFileSet = res.data.data
          this.uploadFileCount = res.data.count
          this.setUploadFileSelectRow([])
          setTimeout(() => { this.uploadFileSpinShow = false }, 700)
          setTimeout(() => { this.uploadFileQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.uploadFileSpinShow = false }, 700)
          setTimeout(() => { this.uploadFileQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.uploadFileSpinShow = false }, 700)
        setTimeout(() => { this.uploadFileQuerySubmitting = false }, 5000)
      })
    },
    resetUploadFileQueryForm () {
      this.$refs.uploadFileQueryForm.resetFields()
    },
    setUploadFileSelectRow (list) {
      this.uploadFileSelectRow = list
      this.uploadFileSelectRowLength = list.length
    },
    uploadFilePageIndexChange (pageIndex) {
      this.uploadFilePage = pageIndex
      this.getUploadFileSet()
    },
    uploadFilePageSizeChange (pageSize) {
      this.uploadFileRows = pageSize
      this.uploadFilePage = 1
      this.getUploadFileSet()
    },
    uploadFileRefresh () {
      this.uploadFilePage = 1
      this.getUploadFileSet()
    },
    changeUploadFileColumns () {
      this.uploadFileColumns = []
      this.uploadFileColumnsChecked.forEach(col => this.uploadFileColumns.push(this.uploadFileColumnsNexus[col]))
    },
    cleanUploadFileColumns () {
      this.uploadFileColumnsChecked = [
        'fileId'
      ]
      this.uploadFileColumns = []
      this.uploadFileColumnsChecked.forEach(col => this.uploadFileColumns.push(this.uploadFileColumnsNexus[col]))
    },
    resetUploadFileColumns () {
      this.uploadFileColumnsChecked = [
        'fileId',
        'fileName',
        'fileUrl',
        'fileType',
        'fileSize',
        'fileSuffix',
        'module',
        'moduleHash',
        'remark',
        'versions',
        'createId',
        'createName',
        'createOrg',
        'createTimes',
        'delFlag'
      ]
      this.uploadFileColumns = []
      this.uploadFileColumnsChecked.forEach(col => this.uploadFileColumns.push(this.uploadFileColumnsNexus[col]))
    }
  },
  mounted () {
    this.getUploadFileSet()
  }
}
</script>

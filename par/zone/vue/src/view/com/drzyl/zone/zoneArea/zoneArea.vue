<style lang="less" scoped>
  @import './zoneArea.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="zoneAreaKeySearchSubmitting" @on-search="keySearchZoneArea($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="zoneAreaQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="zoneAreaQueryForm" :model="zoneAreaQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="父ID：" prop="areaName">
                      <Input v-model="zoneAreaQuery.areaName" placeholder="输入父ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="名称：" prop="areaType">
                      <Input v-model="zoneAreaQuery.areaType" placeholder="输入名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="状态：" prop="status">
                      <Input v-model="zoneAreaQuery.status" placeholder="输入状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="zoneAreaQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="zoneAreaQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="zoneAreaQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="zoneAreaQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="zoneAreaQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="zoneAreaQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="zoneAreaQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="zoneAreaQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改机构：" prop="modifyOrg">
                      <Input v-model="zoneAreaQuery.modifyOrg" placeholder="输入修改机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="zoneAreaQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="zoneAreaQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryZoneArea()" :loading="zoneAreaQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetZoneAreaQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addZoneArea()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upZoneArea()" v-if="zoneAreaSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delZoneArea()" v-if="zoneAreaSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailZoneArea()" v-if="zoneAreaSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="zoneAreaColumnsChecked" @on-change="changeZoneAreaColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="areaName">父ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="areaType">名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="status">状态</Checkbox>
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
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanZoneAreaColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetZoneAreaColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="zoneAreaColumns" :data="zoneAreaSet" @on-selection-change="setZoneAreaSelectRow($event)" @on-row-dblclick="dblclickDetailZoneArea($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="zoneAreaCount" :current="zoneAreaPage" :page-size-opts="[10, 30, 50]" @on-change="zoneAreaPageIndexChange($event)" @on-page-size-change="zoneAreaPageSizeChange($event)" v-if="zoneAreaPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="zoneAreaRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="zoneAreaSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="zoneAreaEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑区域
        </p>
        <Form class="pro-margin-top-20" ref="zoneAreaForm" :model="zoneArea" :rules="zoneAreaFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="父ID：" prop="areaName">
                <Input v-model="zoneArea.areaName" placeholder="输入父ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="名称：" prop="areaType">
                <Input v-model="zoneArea.areaType" placeholder="输入名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="状态：" prop="status">
                <Input v-model="zoneArea.status" placeholder="输入状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="zoneArea.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="zoneArea.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="zoneArea.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="zoneArea.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="zoneArea.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="zoneArea.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="zoneArea.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="zoneArea.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改机构：" prop="modifyOrg">
                <Input v-model="zoneArea.modifyOrg" placeholder="输入修改机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="zoneArea.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="zoneArea.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toZoneAreaList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetZoneAreaForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="zoneAreaSubmitting" @click="saveZoneAreaForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="zoneAreaSubmitting" @click="saveAddZoneAreaForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="zoneAreaDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          区域详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>区域ID：{{ zoneArea.areaId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>父ID：{{ zoneArea.areaName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>名称：{{ zoneArea.areaType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>状态：{{ zoneArea.status }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ zoneArea.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ zoneArea.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ zoneArea.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ zoneArea.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ zoneArea.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ zoneArea.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ zoneArea.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ zoneArea.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改机构：{{ zoneArea.modifyOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ zoneArea.modifyTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ zoneArea.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import ZoneArea from '@/view/com/drzyl/zone/zoneArea/ZoneArea'
import ZoneAreaQuery from '@/view/com/drzyl/zone/zoneArea/ZoneAreaQuery'

export default {
  data () {
    return {
      zoneAreaColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '父ID', key: 'areaName', minWidth: 200, sortable: true },
        { title: '名称', key: 'areaType', minWidth: 200, sortable: true },
        { title: '状态', key: 'status', minWidth: 200, sortable: true },
        { title: '备注', key: 'remark', minWidth: 200, sortable: true },
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
      zoneAreaFormValidate: {
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
      zoneAreaColumnsChecked: [
        'areaId',
        'areaName',
        'areaType',
        'status',
        'remark',
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
      zoneAreaColumnsNexus: {
        areaId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        areaName: { title: '父ID', key: 'areaName', minWidth: 200, sortable: true },
        areaType: { title: '名称', key: 'areaType', minWidth: 200, sortable: true },
        status: { title: '状态', key: 'status', minWidth: 200, sortable: true },
        remark: { title: '备注', key: 'remark', minWidth: 200, sortable: true },
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
      zoneAreaSet: [],
      zoneAreaCount: 0,
      zoneAreaRows: 10,
      zoneAreaPage: 1,
      zoneAreaSelectRow: [],
      zoneAreaSelectRowLength: 0,
      zoneArea: new ZoneArea(),
      zoneAreaQuery: new ZoneAreaQuery(),
      zoneAreaSpinShow: false,
      zoneAreaPageShow: true,
      zoneAreaEditModalShow: false,
      zoneAreaSubmitting: false,
      zoneAreaContinue: false,
      zoneAreaDetailDrawerShow: false,
      zoneAreaQueryPoptipShow: false,
      zoneAreaQuerySubmitting: false,
      zoneAreaKeySearchSubmitting: false,
      zoneAreaKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('zoneAreaStore', [
    ]),
    ...mapGetters('zoneAreaStore', [
    ])
  },
  methods: {
    ...mapMutations('zoneAreaStore', [
    ]),
    ...mapActions('zoneAreaStore', [
      'saveZoneArea',
      'updateZoneArea',
      'batchRemoveZoneArea',
      'getZoneAreaByPk',
      'queryZoneArea',
      'pagingQueryZoneArea'
    ]),
    addZoneArea () {
      this.zoneAreaEditModalShow = true
      this.zoneArea = new ZoneArea()
    },
    upZoneArea () {
      this.zoneAreaEditModalShow = true
      let zoneAreaEdit = new ZoneArea()
      zoneAreaEdit.areaId = this.zoneAreaSelectRow[0].areaId
      this.getZoneAreaByPk(zoneAreaEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneArea, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toZoneAreaList () {
      this.zoneAreaEditModalShow = false
      this.resetZoneAreaForm()
      this.getZoneAreaSet()
    },
    resetZoneAreaForm () {
      this.$refs.zoneAreaForm.resetFields()
    },
    saveZoneAreaForm () {
      this.zoneAreaContinue = false
      this.submitZoneAreaForm()
    },
    saveAddZoneAreaForm () {
      this.zoneAreaContinue = true
      this.submitZoneAreaForm()
    },
    submitZoneAreaForm () {
      this.zoneAreaSubmitting = true
      this.$refs.zoneAreaForm.validate((valid) => {
        if (valid) {
          if (this.zoneArea.areaId) {
            this.updateZoneArea(this.zoneArea).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '区域信息修改成功.', duration: 3 })
                this.resetZoneAreaForm()
                this.zoneArea = new ZoneArea()
                this.zoneAreaSubmitting = false
                if (!this.zoneAreaContinue) {
                  this.toZoneAreaList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.zoneAreaSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.zoneAreaSubmitting = false }, 3000)
            })
          } else {
            this.saveZoneArea(this.zoneArea).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '区域信息保存成功.', duration: 3 })
                this.resetZoneAreaForm()
                this.zoneArea = new ZoneArea()
                this.zoneAreaSubmitting = false
                if (!this.zoneAreaContinue) {
                  this.toZoneAreaList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.zoneAreaSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.zoneAreaSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.zoneAreaSubmitting = false }, 3000)
        }
      })
    },
    delZoneArea () {
      this.zoneAreaSpinShow = true
      this.batchRemoveZoneArea(this.zoneAreaSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '区域信息删除成功.', duration: 3 })
          this.setZoneAreaSelectRow([])
          this.getZoneAreaSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
      })
    },
    detailZoneArea () {
      this.zoneAreaDetailDrawerShow = true
      let zoneAreaDetail = new ZoneArea()
      zoneAreaDetail.areaId = this.zoneAreaSelectRow[0].areaId
      this.getZoneAreaByPk(zoneAreaDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneArea, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailZoneArea (rowData) {
      this.zoneAreaDetailDrawerShow = true
      let zoneAreaDetail = new ZoneArea()
      zoneAreaDetail.areaId = rowData.areaId
      this.getZoneAreaByPk(zoneAreaDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.zoneArea, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getZoneAreaSet () {
      this.zoneAreaSpinShow = true
      this.zoneAreaPageShow = true
      this.pagingQueryZoneArea({ zoneAreaQuery: {}, rows: this.zoneAreaRows, page: this.zoneAreaPage }).then(res => {
        if (res.data.success) {
          this.zoneAreaSet = res.data.data
          this.zoneAreaCount = res.data.count
          this.setZoneAreaSelectRow([])
          setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
      })
    },
    keySearchZoneArea (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.zoneAreaKeySearchSubmitting = true
        this.zoneAreaPageShow = false
        this.zoneAreaSpinShow = true
        let zoneAreaQueryKeySearch = new ZoneAreaQuery()
        zoneAreaQueryKeySearch.areaNameAndKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.areaTypeOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.statusOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        zoneAreaQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryZoneArea(zoneAreaQueryKeySearch).then(res => {
          if (res.data.success) {
            this.zoneAreaSet = res.data.data
            this.zoneAreaCount = res.data.count
            this.setZoneAreaSelectRow([])
            setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
            setTimeout(() => { this.zoneAreaKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
            setTimeout(() => { this.zoneAreaKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
          setTimeout(() => { this.zoneAreaKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.zoneAreaKeySearchClickRate++
        if (this.zoneAreaKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.zoneAreaKeySearchClickRate = 0
        }
      }
    },
    vagueQueryZoneArea () {
      this.zoneAreaQuerySubmitting = true
      this.zoneAreaPageShow = false
      this.zoneAreaSpinShow = true
      this.zoneAreaQueryPoptipShow = false
      this.queryZoneArea(this.zoneAreaQuery).then(res => {
        if (res.data.success) {
          this.zoneAreaSet = res.data.data
          this.zoneAreaCount = res.data.count
          this.setZoneAreaSelectRow([])
          setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
          setTimeout(() => { this.zoneAreaQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
          setTimeout(() => { this.zoneAreaQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.zoneAreaSpinShow = false }, 700)
        setTimeout(() => { this.zoneAreaQuerySubmitting = false }, 5000)
      })
    },
    resetZoneAreaQueryForm () {
      this.$refs.zoneAreaQueryForm.resetFields()
    },
    setZoneAreaSelectRow (list) {
      this.zoneAreaSelectRow = list
      this.zoneAreaSelectRowLength = list.length
    },
    zoneAreaPageIndexChange (pageIndex) {
      this.zoneAreaPage = pageIndex
      this.getZoneAreaSet()
    },
    zoneAreaPageSizeChange (pageSize) {
      this.zoneAreaRows = pageSize
      this.zoneAreaPage = 1
      this.getZoneAreaSet()
    },
    zoneAreaRefresh () {
      this.zoneAreaPage = 1
      this.getZoneAreaSet()
    },
    changeZoneAreaColumns () {
      this.zoneAreaColumns = []
      this.zoneAreaColumnsChecked.forEach(col => this.zoneAreaColumns.push(this.zoneAreaColumnsNexus[col]))
    },
    cleanZoneAreaColumns () {
      this.zoneAreaColumnsChecked = [
        'areaId'
      ]
      this.zoneAreaColumns = []
      this.zoneAreaColumnsChecked.forEach(col => this.zoneAreaColumns.push(this.zoneAreaColumnsNexus[col]))
    },
    resetZoneAreaColumns () {
      this.zoneAreaColumnsChecked = [
        'areaId',
        'areaName',
        'areaType',
        'status',
        'remark',
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
      this.zoneAreaColumns = []
      this.zoneAreaColumnsChecked.forEach(col => this.zoneAreaColumns.push(this.zoneAreaColumnsNexus[col]))
    }
  },
  mounted () {
    this.getZoneAreaSet()
  }
}
</script>

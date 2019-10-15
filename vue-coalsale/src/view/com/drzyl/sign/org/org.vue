<style lang="less" scoped>
  @import './org.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="orgKeySearchSubmitting" @on-search="keySearchOrg($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="orgQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="orgQueryForm" :model="orgQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="组织机构名称：" prop="orgName">
                      <Input v-model="orgQuery.orgName" placeholder="输入组织机构名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="组织机构类型：" prop="orgType">
                      <Input v-model="orgQuery.orgType" placeholder="输入组织机构类型"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="编号路径：" prop="idPath">
                      <Input v-model="orgQuery.idPath" placeholder="输入编号路径"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="名称路径：" prop="namePath">
                      <Input v-model="orgQuery.namePath" placeholder="输入名称路径"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="排序权重：" prop="weightOrder">
                      <InputNumber v-model="orgQuery.weightOrder"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="上级组织机构编号：" prop="orgPid">
                      <Input v-model="orgQuery.orgPid" placeholder="输入上级组织机构编号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="orgQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="orgQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="orgQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="orgQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="orgQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="orgQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="orgQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryOrg()" :loading="orgQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetOrgQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addOrg()">新建</Button>
      <!-- <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upOrg()" v-if="orgSelectRowLength === 1">编辑</Button> -->
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delOrg()" v-if="orgSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailOrg()" v-if="orgSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="orgColumnsChecked" @on-change="changeOrgColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="orgName">组织机构名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="namePath">组织机构全称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="orgType">组织机构类型</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="weightOrder">排序权重</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanOrgColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetOrgColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="orgColumns" :data="orgSet" @on-selection-change="setOrgSelectRow($event)" @on-row-dblclick="dblclickDetailOrg($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="orgCount" :current="orgPage" :page-size-opts="[10, 30, 50]" @on-change="orgPageIndexChange($event)" @on-page-size-change="orgPageSizeChange($event)" v-if="orgPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="orgRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="orgSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="orgEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑组织机构
        </p>
        <Form class="pro-margin-top-20" ref="orgForm" :model="org" :rules="orgFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <!-- <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="上级组织机构编号：" prop="orgPid">
                <Input v-model="org.orgPid" placeholder="输入上级组织机构编号"></Input>
              </FormItem>
            </Col> -->
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="上级组织机构：" prop="orgPid">
                <Select v-model="org.orgPid" clearable filterable>
                  <Option v-for="item in superOrgListOfOrgEdit" :value="item.orgId" :key="item.orgId">{{ item.orgName + ' [ ' + item.namePath + ' ]' }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="组织机构名称：" prop="orgName">
                <Input v-model="org.orgName" placeholder="输入组织机构名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <!-- <FormItem label="组织机构类型：" prop="orgType">
                <Input v-model="org.orgType" placeholder="输入组织机构类型"></Input>
              </FormItem> -->
              <Dict v-model="org.orgType" dictKey="SYS_ORG_ORG_TYPE" formItemProp="orgType" />
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="排序权重：" prop="weightOrder">
                <InputNumber v-model="org.weightOrder"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toOrgList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetOrgForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="orgSubmitting" @click="saveOrgForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="orgSubmitting" @click="saveAddOrgForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="orgDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          组织机构详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>组织机构编号：{{ org.orgId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>组织机构名称：{{ org.orgName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>组织机构类型：{{ org.orgType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>编号路径：{{ org.idPath }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>名称路径：{{ org.namePath }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>排序权重：{{ org.weightOrder }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>上级组织机构编号：{{ org.orgPid }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ org.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ org.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ org.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ org.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ org.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ org.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ org.modifyTimes }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Org from '@/view/com/drzyl/sign/org/Org'
import OrgQuery from '@/view/com/drzyl/sign/org/OrgQuery'

export default {
  data () {
    return {
      orgColumns: [
        { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        { title: '组织机构名称', key: 'orgName', minWidth: 200, sortable: true },
        { title: '组织机构全称', key: 'namePath', minWidth: 300, sortable: true },
        { title: '组织机构类型', key: 'orgType', width: 150, sortable: true },
        { title: '排序权重', key: 'weightOrder', width: 120, sortable: true }
      ],
      orgFormValidate: {
        orgName: [
          { required: true, message: '组织机构名称不能为空', trigger: 'blur' }
        ]
      },
      orgColumnsChecked: [
        'orgId',
        'orgName',
        'namePath',
        'orgType',
        'weightOrder'
      ],
      orgColumnsNexus: {
        orgId: { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        orgName: { title: '组织机构名称', key: 'orgName', minWidth: 200, sortable: true },
        namePath: { title: '组织机构全称', key: 'namePath', minWidth: 300, sortable: true },
        orgType: { title: '组织机构类型', key: 'orgType', width: 150, sortable: true },
        weightOrder: { title: '排序权重', key: 'weightOrder', width: 120, sortable: true }
      },
      orgSet: [],
      orgCount: 0,
      orgRows: 10,
      orgPage: 1,
      orgSelectRow: [],
      orgSelectRowLength: 0,
      org: new Org(),
      orgQuery: new OrgQuery(),
      orgSpinShow: false,
      orgPageShow: true,
      orgEditModalShow: false,
      orgSubmitting: false,
      orgContinue: false,
      orgDetailDrawerShow: false,
      orgQueryPoptipShow: false,
      orgQuerySubmitting: false,
      orgKeySearchSubmitting: false,
      orgKeySearchClickRate: 0,
      superOrgListOfOrgEdit: []
    }
  },
  computed: {
    ...mapState('orgStore', [
    ]),
    ...mapGetters('orgStore', [
    ])
  },
  methods: {
    ...mapMutations('orgStore', [
    ]),
    ...mapActions('orgStore', [
      'saveOrg',
      'updateOrg',
      'batchRemoveOrg',
      'getOrgByPk',
      'queryOrg',
      'pagingQueryOrg',
      'getAllOrg'
    ]),
    addOrg () {
      this.orgEditModalShow = true
      this.org = new Org()
      this.getAllOrg().then(res => {
        if (res.data.success) {
          this.superOrgListOfOrgEdit = res.data.data
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    upOrg () {
      this.orgEditModalShow = true
      let orgEdit = new Org()
      orgEdit.orgId = this.orgSelectRow[0].orgId
      this.getOrgByPk(orgEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.org, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toOrgList () {
      this.orgEditModalShow = false
      this.resetOrgForm()
      this.getOrgSet()
    },
    resetOrgForm () {
      this.$refs.orgForm.resetFields()
    },
    saveOrgForm () {
      this.orgContinue = false
      this.submitOrgForm()
    },
    saveAddOrgForm () {
      this.orgContinue = true
      this.submitOrgForm()
    },
    submitOrgForm () {
      this.orgSubmitting = true
      this.$refs.orgForm.validate((valid) => {
        if (valid) {
          if (this.org.orgId) {
            this.updateOrg(this.org).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '组织机构信息修改成功.', duration: 3 })
                this.resetOrgForm()
                this.org = new Org()
                this.orgSubmitting = false
                if (!this.orgContinue) {
                  this.toOrgList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.orgSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.orgSubmitting = false }, 3000)
            })
          } else {
            this.saveOrg(this.org).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '组织机构信息保存成功.', duration: 3 })
                this.resetOrgForm()
                this.org = new Org()
                this.orgSubmitting = false
                if (!this.orgContinue) {
                  this.toOrgList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.orgSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.orgSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.orgSubmitting = false }, 3000)
        }
      })
    },
    delOrg () {
      this.orgSpinShow = true
      this.batchRemoveOrg(this.orgSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '组织机构信息删除成功.', duration: 3 })
          this.setOrgSelectRow([])
          this.getOrgSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.orgSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.orgSpinShow = false }, 700)
      })
    },
    detailOrg () {
      this.orgDetailDrawerShow = true
      let orgDetail = new Org()
      orgDetail.orgId = this.orgSelectRow[0].orgId
      this.getOrgByPk(orgDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.org, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailOrg (rowData) {
      this.orgDetailDrawerShow = true
      let orgDetail = new Org()
      orgDetail.orgId = rowData.orgId
      this.getOrgByPk(orgDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.org, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getOrgSet () {
      this.orgSpinShow = true
      this.orgPageShow = true
      this.pagingQueryOrg({ orgQuery: {}, rows: this.orgRows, page: this.orgPage }).then(res => {
        if (res.data.success) {
          this.orgSet = res.data.data
          this.orgCount = res.data.count
          this.setOrgSelectRow([])
          setTimeout(() => { this.orgSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.orgSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.orgSpinShow = false }, 700)
      })
    },
    keySearchOrg (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.orgKeySearchSubmitting = true
        this.orgPageShow = false
        this.orgSpinShow = true
        let orgQueryKeySearch = new OrgQuery()
        orgQueryKeySearch.orgNameAndKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.orgTypeOrKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.idPathOrKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.namePathOrKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.orgPidOrKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        orgQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        this.queryOrg(orgQueryKeySearch).then(res => {
          if (res.data.success) {
            this.orgSet = res.data.data
            this.orgCount = res.data.count
            this.setOrgSelectRow([])
            setTimeout(() => { this.orgSpinShow = false }, 700)
            setTimeout(() => { this.orgKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.orgSpinShow = false }, 700)
            setTimeout(() => { this.orgKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.orgSpinShow = false }, 700)
          setTimeout(() => { this.orgKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.orgKeySearchClickRate++
        if (this.orgKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.orgKeySearchClickRate = 0
        }
      }
    },
    vagueQueryOrg () {
      this.orgQuerySubmitting = true
      this.orgPageShow = false
      this.orgSpinShow = true
      this.orgQueryPoptipShow = false
      this.queryOrg(this.orgQuery).then(res => {
        if (res.data.success) {
          this.orgSet = res.data.data
          this.orgCount = res.data.count
          this.setOrgSelectRow([])
          setTimeout(() => { this.orgSpinShow = false }, 700)
          setTimeout(() => { this.orgQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.orgSpinShow = false }, 700)
          setTimeout(() => { this.orgQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.orgSpinShow = false }, 700)
        setTimeout(() => { this.orgQuerySubmitting = false }, 5000)
      })
    },
    resetOrgQueryForm () {
      this.$refs.orgQueryForm.resetFields()
    },
    setOrgSelectRow (list) {
      this.orgSelectRow = list
      this.orgSelectRowLength = list.length
    },
    orgPageIndexChange (pageIndex) {
      this.orgPage = pageIndex
      this.getOrgSet()
    },
    orgPageSizeChange (pageSize) {
      this.orgRows = pageSize
      this.orgPage = 1
      this.getOrgSet()
    },
    orgRefresh () {
      this.orgPage = 1
      this.getOrgSet()
    },
    changeOrgColumns () {
      this.orgColumns = []
      this.orgColumnsChecked.forEach(col => this.orgColumns.push(this.orgColumnsNexus[col]))
    },
    cleanOrgColumns () {
      this.orgColumnsChecked = [
        'orgId'
      ]
      this.orgColumns = []
      this.orgColumnsChecked.forEach(col => this.orgColumns.push(this.orgColumnsNexus[col]))
    },
    resetOrgColumns () {
      this.orgColumnsChecked = [
        'orgId',
        'orgName',
        'namePath',
        'orgType',
        'weightOrder'
      ]
      this.orgColumns = []
      this.orgColumnsChecked.forEach(col => this.orgColumns.push(this.orgColumnsNexus[col]))
    }
  },
  mounted () {
    this.getOrgSet()
  }
}
</script>

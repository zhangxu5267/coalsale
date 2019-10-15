<style lang="less" scoped>
  @import './postStaffNexus.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="postStaffNexusKeySearchSubmitting" @on-search="keySearchPostStaffNexus($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="postStaffNexusQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="postStaffNexusQueryForm" :model="postStaffNexusQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="岗位编号：" prop="postId">
                      <Input v-model="postStaffNexusQuery.postId" placeholder="输入岗位编号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="员工编号：" prop="staffId">
                      <Input v-model="postStaffNexusQuery.staffId" placeholder="输入员工编号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="默认岗位：" prop="defaultPost">
                      <Input v-model="postStaffNexusQuery.defaultPost" placeholder="输入默认岗位"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryPostStaffNexus()" :loading="postStaffNexusQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetPostStaffNexusQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addPostStaffNexus()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upPostStaffNexus()" v-if="postStaffNexusSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delPostStaffNexus()" v-if="postStaffNexusSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailPostStaffNexus()" v-if="postStaffNexusSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="postStaffNexusColumnsChecked" @on-change="changePostStaffNexusColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="postId">岗位编号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="staffId">员工编号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="defaultPost">默认岗位</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanPostStaffNexusColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetPostStaffNexusColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="postStaffNexusColumns" :data="postStaffNexusSet" @on-selection-change="setPostStaffNexusSelectRow($event)" @on-row-dblclick="dblclickDetailPostStaffNexus($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="postStaffNexusCount" :current="postStaffNexusPage" :page-size-opts="[10, 30, 50]" @on-change="postStaffNexusPageIndexChange($event)" @on-page-size-change="postStaffNexusPageSizeChange($event)" v-if="postStaffNexusPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="postStaffNexusRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="postStaffNexusSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="postStaffNexusEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑岗位员工
        </p>
        <Form class="pro-margin-top-20" ref="postStaffNexusForm" :model="postStaffNexus" :rules="postStaffNexusFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="岗位编号：" prop="postId">
                <Input v-model="postStaffNexus.postId" placeholder="输入岗位编号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="员工编号：" prop="staffId">
                <Input v-model="postStaffNexus.staffId" placeholder="输入员工编号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="默认岗位：" prop="defaultPost">
                <Input v-model="postStaffNexus.defaultPost" placeholder="输入默认岗位"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toPostStaffNexusList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetPostStaffNexusForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="postStaffNexusSubmitting" @click="savePostStaffNexusForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="postStaffNexusSubmitting" @click="saveAddPostStaffNexusForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="postStaffNexusDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          岗位员工详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>关系编号：{{ postStaffNexus.nexusId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>岗位编号：{{ postStaffNexus.postId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>员工编号：{{ postStaffNexus.staffId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>默认岗位：{{ postStaffNexus.defaultPost }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import PostStaffNexus from '@/view/com/drzyl/sign/postStaffNexus/PostStaffNexus'
import PostStaffNexusQuery from '@/view/com/drzyl/sign/postStaffNexus/PostStaffNexusQuery'

export default {
  data () {
    return {
      postStaffNexusColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '岗位编号', key: 'postId', minWidth: 200, sortable: true },
        { title: '员工编号', key: 'staffId', minWidth: 200, sortable: true },
        { title: '默认岗位', key: 'defaultPost', minWidth: 200, sortable: true }
      ],
      postStaffNexusFormValidate: {
        postId: [
          { required: true, message: '岗位编号不能为空', trigger: 'blur' }
        ],
        staffId: [
          { required: true, message: '员工编号不能为空', trigger: 'blur' }
        ]
      },
      postStaffNexusColumnsChecked: [
        'nexusId',
        'postId',
        'staffId',
        'defaultPost'
      ],
      postStaffNexusColumnsNexus: {
        nexusId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        postId: { title: '岗位编号', key: 'postId', minWidth: 200, sortable: true },
        staffId: { title: '员工编号', key: 'staffId', minWidth: 200, sortable: true },
        defaultPost: { title: '默认岗位', key: 'defaultPost', minWidth: 200, sortable: true }
      },
      postStaffNexusSet: [],
      postStaffNexusCount: 0,
      postStaffNexusRows: 10,
      postStaffNexusPage: 1,
      postStaffNexusSelectRow: [],
      postStaffNexusSelectRowLength: 0,
      postStaffNexus: new PostStaffNexus(),
      postStaffNexusQuery: new PostStaffNexusQuery(),
      postStaffNexusSpinShow: false,
      postStaffNexusPageShow: true,
      postStaffNexusEditModalShow: false,
      postStaffNexusSubmitting: false,
      postStaffNexusContinue: false,
      postStaffNexusDetailDrawerShow: false,
      postStaffNexusQueryPoptipShow: false,
      postStaffNexusQuerySubmitting: false,
      postStaffNexusKeySearchSubmitting: false,
      postStaffNexusKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('postStaffNexusStore', [
    ]),
    ...mapGetters('postStaffNexusStore', [
    ])
  },
  methods: {
    ...mapMutations('postStaffNexusStore', [
    ]),
    ...mapActions('postStaffNexusStore', [
      'savePostStaffNexus',
      'updatePostStaffNexus',
      'batchRemovePostStaffNexus',
      'getPostStaffNexusByPk',
      'queryPostStaffNexus',
      'pagingQueryPostStaffNexus'
    ]),
    addPostStaffNexus () {
      this.postStaffNexusEditModalShow = true
      this.postStaffNexus = new PostStaffNexus()
    },
    upPostStaffNexus () {
      this.postStaffNexusEditModalShow = true
      let postStaffNexusEdit = new PostStaffNexus()
      postStaffNexusEdit.nexusId = this.postStaffNexusSelectRow[0].nexusId
      this.getPostStaffNexusByPk(postStaffNexusEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.postStaffNexus, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toPostStaffNexusList () {
      this.postStaffNexusEditModalShow = false
      this.resetPostStaffNexusForm()
      this.getPostStaffNexusSet()
    },
    resetPostStaffNexusForm () {
      this.$refs.postStaffNexusForm.resetFields()
    },
    savePostStaffNexusForm () {
      this.postStaffNexusContinue = false
      this.submitPostStaffNexusForm()
    },
    saveAddPostStaffNexusForm () {
      this.postStaffNexusContinue = true
      this.submitPostStaffNexusForm()
    },
    submitPostStaffNexusForm () {
      this.postStaffNexusSubmitting = true
      this.$refs.postStaffNexusForm.validate((valid) => {
        if (valid) {
          if (this.postStaffNexus.nexusId) {
            this.updatePostStaffNexus(this.postStaffNexus).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '岗位员工信息修改成功.', duration: 3 })
                this.resetPostStaffNexusForm()
                this.postStaffNexus = new PostStaffNexus()
                this.postStaffNexusSubmitting = false
                if (!this.postStaffNexusContinue) {
                  this.toPostStaffNexusList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.postStaffNexusSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.postStaffNexusSubmitting = false }, 3000)
            })
          } else {
            this.savePostStaffNexus(this.postStaffNexus).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '岗位员工信息保存成功.', duration: 3 })
                this.resetPostStaffNexusForm()
                this.postStaffNexus = new PostStaffNexus()
                this.postStaffNexusSubmitting = false
                if (!this.postStaffNexusContinue) {
                  this.toPostStaffNexusList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.postStaffNexusSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.postStaffNexusSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.postStaffNexusSubmitting = false }, 3000)
        }
      })
    },
    delPostStaffNexus () {
      this.postStaffNexusSpinShow = true
      this.batchRemovePostStaffNexus(this.postStaffNexusSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '岗位员工信息删除成功.', duration: 3 })
          this.setPostStaffNexusSelectRow([])
          this.getPostStaffNexusSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
      })
    },
    detailPostStaffNexus () {
      this.postStaffNexusDetailDrawerShow = true
      let postStaffNexusDetail = new PostStaffNexus()
      postStaffNexusDetail.nexusId = this.postStaffNexusSelectRow[0].nexusId
      this.getPostStaffNexusByPk(postStaffNexusDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.postStaffNexus, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailPostStaffNexus (rowData) {
      this.postStaffNexusDetailDrawerShow = true
      let postStaffNexusDetail = new PostStaffNexus()
      postStaffNexusDetail.nexusId = rowData.nexusId
      this.getPostStaffNexusByPk(postStaffNexusDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.postStaffNexus, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getPostStaffNexusSet () {
      this.postStaffNexusSpinShow = true
      this.postStaffNexusPageShow = true
      this.pagingQueryPostStaffNexus({ postStaffNexusQuery: {}, rows: this.postStaffNexusRows, page: this.postStaffNexusPage }).then(res => {
        if (res.data.success) {
          this.postStaffNexusSet = res.data.data
          this.postStaffNexusCount = res.data.count
          this.setPostStaffNexusSelectRow([])
          setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
      })
    },
    keySearchPostStaffNexus (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.postStaffNexusKeySearchSubmitting = true
        this.postStaffNexusPageShow = false
        this.postStaffNexusSpinShow = true
        let postStaffNexusQueryKeySearch = new PostStaffNexusQuery()
        postStaffNexusQueryKeySearch.postIdAndKeyLike = '%' + keyLikeValue + '%'
        postStaffNexusQueryKeySearch.staffIdOrKeyLike = '%' + keyLikeValue + '%'
        postStaffNexusQueryKeySearch.defaultPostOrKeyLike = '%' + keyLikeValue + '%'
        this.queryPostStaffNexus(postStaffNexusQueryKeySearch).then(res => {
          if (res.data.success) {
            this.postStaffNexusSet = res.data.data
            this.postStaffNexusCount = res.data.count
            this.setPostStaffNexusSelectRow([])
            setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
            setTimeout(() => { this.postStaffNexusKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
            setTimeout(() => { this.postStaffNexusKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
          setTimeout(() => { this.postStaffNexusKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.postStaffNexusKeySearchClickRate++
        if (this.postStaffNexusKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.postStaffNexusKeySearchClickRate = 0
        }
      }
    },
    vagueQueryPostStaffNexus () {
      this.postStaffNexusQuerySubmitting = true
      this.postStaffNexusPageShow = false
      this.postStaffNexusSpinShow = true
      this.postStaffNexusQueryPoptipShow = false
      this.queryPostStaffNexus(this.postStaffNexusQuery).then(res => {
        if (res.data.success) {
          this.postStaffNexusSet = res.data.data
          this.postStaffNexusCount = res.data.count
          this.setPostStaffNexusSelectRow([])
          setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
          setTimeout(() => { this.postStaffNexusQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
          setTimeout(() => { this.postStaffNexusQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.postStaffNexusSpinShow = false }, 700)
        setTimeout(() => { this.postStaffNexusQuerySubmitting = false }, 5000)
      })
    },
    resetPostStaffNexusQueryForm () {
      this.$refs.postStaffNexusQueryForm.resetFields()
    },
    setPostStaffNexusSelectRow (list) {
      this.postStaffNexusSelectRow = list
      this.postStaffNexusSelectRowLength = list.length
    },
    postStaffNexusPageIndexChange (pageIndex) {
      this.postStaffNexusPage = pageIndex
      this.getPostStaffNexusSet()
    },
    postStaffNexusPageSizeChange (pageSize) {
      this.postStaffNexusRows = pageSize
      this.postStaffNexusPage = 1
      this.getPostStaffNexusSet()
    },
    postStaffNexusRefresh () {
      this.postStaffNexusPage = 1
      this.getPostStaffNexusSet()
    },
    changePostStaffNexusColumns () {
      this.postStaffNexusColumns = []
      this.postStaffNexusColumnsChecked.forEach(col => this.postStaffNexusColumns.push(this.postStaffNexusColumnsNexus[col]))
    },
    cleanPostStaffNexusColumns () {
      this.postStaffNexusColumnsChecked = [
        'nexusId'
      ]
      this.postStaffNexusColumns = []
      this.postStaffNexusColumnsChecked.forEach(col => this.postStaffNexusColumns.push(this.postStaffNexusColumnsNexus[col]))
    },
    resetPostStaffNexusColumns () {
      this.postStaffNexusColumnsChecked = [
        'nexusId',
        'postId',
        'staffId',
        'defaultPost'
      ]
      this.postStaffNexusColumns = []
      this.postStaffNexusColumnsChecked.forEach(col => this.postStaffNexusColumns.push(this.postStaffNexusColumnsNexus[col]))
    }
  },
  mounted () {
    this.getPostStaffNexusSet()
  }
}
</script>

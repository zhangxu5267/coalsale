<style lang="less" scoped>
  @import './post.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="postKeySearchSubmitting" @on-search="keySearchPost($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="postQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="postQueryForm" :model="postQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="岗位名称：" prop="postName">
                      <Input v-model="postQuery.postName" placeholder="输入岗位名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="排序权重：" prop="weightOrder">
                      <InputNumber v-model="postQuery.weightOrder"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="组织机构编号：" prop="orgId">
                      <Input v-model="postQuery.orgId" placeholder="输入组织机构编号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="postQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="postQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="postQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="postQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="postQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="postQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="postQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryPost()" :loading="postQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetPostQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addPost()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upPost()" v-if="postSelectRowLength === 1">编辑</Button>
      <Button class="pro-list-button" type="info" icon="ios-link-outline" ghost @click="createPostRoleNexus()" v-if="postSelectRowLength === 1">关联角色</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delPost()" v-if="postSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailPost()" v-if="postSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="postColumnsChecked" @on-change="changePostColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="postName">岗位名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="weightOrder">排序权重</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="orgId">组织机构编号</Checkbox>
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
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanPostColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetPostColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="postColumns" :data="postSet" @on-selection-change="setPostSelectRow($event)" @on-row-dblclick="dblclickDetailPost($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="postCount" :current="postPage" :page-size-opts="[10, 30, 50]" @on-change="postPageIndexChange($event)" @on-page-size-change="postPageSizeChange($event)" v-if="postPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="postRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="postSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="postEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑岗位
        </p>
        <Form class="pro-margin-top-20" ref="postForm" :model="post" :rules="postFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <!-- <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="组织机构编号：" prop="orgId">
                <Input v-model="post.orgId" placeholder="输入组织机构编号"></Input>
              </FormItem>
            </Col> -->
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="所属组织机构：" prop="orgId">
                <Select v-model="post.orgId" clearable filterable>
                  <Option v-for="item in orgListOfPostEdit" :value="item.orgId" :key="item.orgId">{{ item.orgName + ' [ ' + item.namePath + ' ]' }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="岗位名称：" prop="postName">
                <Input v-model="post.postName" placeholder="输入岗位名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="排序权重：" prop="weightOrder">
                <InputNumber v-model="post.weightOrder"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toPostList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetPostForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="postSubmitting" @click="savePostForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="postSubmitting" @click="saveAddPostForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="postDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          岗位详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>岗位编号：{{ post.postId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>岗位名称：{{ post.postName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>排序权重：{{ post.weightOrder }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>组织机构编号：{{ post.orgId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ post.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ post.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ post.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ post.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ post.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ post.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ post.modifyTimes }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
    <Modal width="60" v-model="postRoleNexusEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-link-outline"></Icon>
          关联角色
        </p>
        <Form class="pro-margin-top-20" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="岗位名称：">
                {{ post.postName }}
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="角色名称：">
                <Select v-model="roleNameList" clearable filterable multiple>
                  <Option v-for="item in roleSetOfPostRoleNexusEdit" :value="item.roleId" :key="item.roleId">{{ item.roleName }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="postRoleNexusEditToPostList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetPostRoleNexusForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="postRoleNexusSubmitting" @click="savePostRoleNexusForm()">保存</Button>
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
import Post from '@/view/com/drzyl/sign/post/Post'
import PostQuery from '@/view/com/drzyl/sign/post/PostQuery'
import RolePostNexus from '@/view/com/drzyl/sign/rolePostNexus/RolePostNexus'
import RolePostNexusQuery from '@/view/com/drzyl/sign/rolePostNexus/RolePostNexusQuery'

export default {
  data () {
    return {
      postColumns: [
        { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        { title: '组织机构全称', key: 'namePath', minWidth: 400, sortable: true },
        { title: '岗位名称', key: 'postName', minWidth: 200, sortable: true },
        { title: '排序权重', key: 'weightOrder', width: 120, sortable: true },
        { title: '组织机构编号', key: 'orgId', minWidth: 200, sortable: true },
        { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        { title: '修改人账号', key: 'modifyId', minWidth: 200, sortable: true },
        { title: '修改人名称', key: 'modifyName', minWidth: 200, sortable: true },
        { title: '修改时间', key: 'modifyTimes', minWidth: 200, sortable: true }
      ],
      postFormValidate: {
        postName: [
          { required: true, message: '岗位名称不能为空', trigger: 'blur' }
        ],
        orgId: [
          { required: true, message: '组织机构编号不能为空', trigger: 'blur' }
        ]
      },
      postColumnsChecked: [
        'postId',
        'postName',
        'weightOrder',
        'orgId',
        'versions',
        'createId',
        'createName',
        'createTimes',
        'modifyId',
        'modifyName',
        'modifyTimes'
      ],
      postColumnsNexus: {
        postId: { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        postName: { title: '岗位名称', key: 'postName', minWidth: 200, sortable: true },
        weightOrder: { title: '排序权重', key: 'weightOrder', minWidth: 200, sortable: true },
        orgId: { title: '组织机构编号', key: 'orgId', minWidth: 200, sortable: true },
        versions: { title: '版本号', key: 'versions', minWidth: 200, sortable: true },
        createId: { title: '创建人账号', key: 'createId', minWidth: 200, sortable: true },
        createName: { title: '创建人名称', key: 'createName', minWidth: 200, sortable: true },
        createTimes: { title: '创建时间', key: 'createTimes', minWidth: 200, sortable: true },
        modifyId: { title: '修改人账号', key: 'modifyId', minWidth: 200, sortable: true },
        modifyName: { title: '修改人名称', key: 'modifyName', minWidth: 200, sortable: true },
        modifyTimes: { title: '修改时间', key: 'modifyTimes', minWidth: 200, sortable: true }
      },
      postSet: [],
      postCount: 0,
      postRows: 10,
      postPage: 1,
      postSelectRow: [],
      postSelectRowLength: 0,
      post: new Post(),
      postQuery: new PostQuery(),
      postSpinShow: false,
      postPageShow: true,
      postEditModalShow: false,
      postSubmitting: false,
      postContinue: false,
      postDetailDrawerShow: false,
      postQueryPoptipShow: false,
      postQuerySubmitting: false,
      postKeySearchSubmitting: false,
      postKeySearchClickRate: 0,
      orgListOfPostEdit: [],
      postRoleNexusEditModalShow: false,
      roleNameList: [],
      roleSetOfPostRoleNexusEdit: [],
      postRoleNexusSubmitting: false
    }
  },
  computed: {
    ...mapState('postStore', [
    ]),
    ...mapGetters('postStore', [
    ])
  },
  methods: {
    ...mapMutations('postStore', [
    ]),
    ...mapActions('postStore', [
      'savePost',
      'updatePost',
      'batchRemovePost',
      'getPostByPk',
      'queryPost',
      'pagingQueryPostVO'
    ]),
    ...mapActions('orgStore', [
      'getAllOrg'
    ]),
    ...mapActions('roleStore', [
      'getAllRole'
    ]),
    ...mapActions('rolePostNexusStore', [
      'batchSaveRolePostNexus',
      'removeRolePostNexus',
      'queryRolePostNexus',
      'batchRemoveRolePostNexus'
    ]),
    addPost () {
      this.postEditModalShow = true
      this.post = new Post()
      this.getAllOrg().then(res => {
        if (res.data.success) {
          this.orgListOfPostEdit = res.data.data
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    upPost () {
      this.postEditModalShow = true
      let postEdit = new Post()
      postEdit.postId = this.postSelectRow[0].postId
      this.getPostByPk(postEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.post, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
      this.getAllOrg().then(res => {
        if (res.data.success) {
          this.orgListOfPostEdit = res.data.data
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toPostList () {
      this.postEditModalShow = false
      this.resetPostForm()
      this.getPostSet()
    },
    resetPostForm () {
      this.$refs.postForm.resetFields()
    },
    savePostForm () {
      this.postContinue = false
      this.submitPostForm()
    },
    saveAddPostForm () {
      this.postContinue = true
      this.submitPostForm()
    },
    submitPostForm () {
      this.postSubmitting = true
      this.$refs.postForm.validate((valid) => {
        if (valid) {
          if (this.post.postId) {
            this.updatePost(this.post).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '岗位信息修改成功.', duration: 3 })
                this.resetPostForm()
                this.post = new Post()
                this.postSubmitting = false
                if (!this.postContinue) {
                  this.toPostList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.postSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.postSubmitting = false }, 3000)
            })
          } else {
            this.savePost(this.post).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '岗位信息保存成功.', duration: 3 })
                this.resetPostForm()
                this.post = new Post()
                this.postSubmitting = false
                if (!this.postContinue) {
                  this.toPostList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.postSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.postSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.postSubmitting = false }, 3000)
        }
      })
    },
    delPost () {
      this.postSpinShow = true
      let delPostList = []
      this.postSelectRow.forEach(post => {
        let postDetail = new Post()
        postDetail.postId = post.postId
        delPostList.push(postDetail)
      })
      this.batchRemoveRolePostNexus(delPostList).then(res => {
        if (res.data.success) {
          this.batchRemovePost(this.postSelectRow).then(res => {
            if (res.data.success) {
              this.$Message.success({ content: '岗位信息删除成功.', duration: 3 })
              this.setPostSelectRow([])
              this.getPostSet()
            } else {
              this.$Message.error({ content: res.data.msg, duration: 6 })
              setTimeout(() => { this.postSpinShow = false }, 700)
            }
          }).catch(result => {
            this.$Message.error({ content: result.response.statusText, duration: 6 })
            setTimeout(() => { this.postSpinShow = false }, 700)
          })
        } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.postSpinShow = false }, 700)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.postSpinShow = false }, 700)
        })
    },
    detailPost () {
      this.postDetailDrawerShow = true
      let postDetail = new Post()
      postDetail.postId = this.postSelectRow[0].postId
      this.getPostByPk(postDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.post, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailPost (rowData) {
      this.postDetailDrawerShow = true
      let postDetail = new Post()
      postDetail.postId = rowData.postId
      this.getPostByPk(postDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.post, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getPostSet () {
      this.postSpinShow = true
      this.postPageShow = true
      this.pagingQueryPostVO({ postQuery: {}, rows: this.postRows, page: this.postPage }).then(res => {
        if (res.data.success) {
          this.postSet = res.data.data
          this.postCount = res.data.count
          this.setPostSelectRow([])
          setTimeout(() => { this.postSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.postSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.postSpinShow = false }, 700)
      })
    },
    keySearchPost (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.postKeySearchSubmitting = true
        this.postPageShow = false
        this.postSpinShow = true
        let postQueryKeySearch = new PostQuery()
        postQueryKeySearch.postNameAndKeyLike = '%' + keyLikeValue + '%'
        postQueryKeySearch.orgIdOrKeyLike = '%' + keyLikeValue + '%'
        postQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        postQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        postQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        postQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        this.queryPost(postQueryKeySearch).then(res => {
          if (res.data.success) {
            this.postSet = res.data.data
            this.postCount = res.data.count
            this.setPostSelectRow([])
            setTimeout(() => { this.postSpinShow = false }, 700)
            setTimeout(() => { this.postKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.postSpinShow = false }, 700)
            setTimeout(() => { this.postKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.postSpinShow = false }, 700)
          setTimeout(() => { this.postKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.postKeySearchClickRate++
        if (this.postKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.postKeySearchClickRate = 0
        }
      }
    },
    vagueQueryPost () {
      this.postQuerySubmitting = true
      this.postPageShow = false
      this.postSpinShow = true
      this.postQueryPoptipShow = false
      this.queryPost(this.postQuery).then(res => {
        if (res.data.success) {
          this.postSet = res.data.data
          this.postCount = res.data.count
          this.setPostSelectRow([])
          setTimeout(() => { this.postSpinShow = false }, 700)
          setTimeout(() => { this.postQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.postSpinShow = false }, 700)
          setTimeout(() => { this.postQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.postSpinShow = false }, 700)
        setTimeout(() => { this.postQuerySubmitting = false }, 5000)
      })
    },
    resetPostQueryForm () {
      this.$refs.postQueryForm.resetFields()
    },
    setPostSelectRow (list) {
      this.postSelectRow = list
      this.postSelectRowLength = list.length
    },
    postPageIndexChange (pageIndex) {
      this.postPage = pageIndex
      this.getPostSet()
    },
    postPageSizeChange (pageSize) {
      this.postRows = pageSize
      this.postPage = 1
      this.getPostSet()
    },
    postRefresh () {
      this.postPage = 1
      this.getPostSet()
    },
    changePostColumns () {
      this.postColumns = []
      this.postColumnsChecked.forEach(col => this.postColumns.push(this.postColumnsNexus[col]))
    },
    cleanPostColumns () {
      this.postColumnsChecked = [
        'postId'
      ]
      this.postColumns = []
      this.postColumnsChecked.forEach(col => this.postColumns.push(this.postColumnsNexus[col]))
    },
    resetPostColumns () {
      this.postColumnsChecked = [
        'postId',
        'postName',
        'weightOrder',
        'orgId',
        'versions',
        'createId',
        'createName',
        'createTimes',
        'modifyId',
        'modifyName',
        'modifyTimes'
      ]
      this.postColumns = []
      this.postColumnsChecked.forEach(col => this.postColumns.push(this.postColumnsNexus[col]))
    },
    createPostRoleNexus () {
      this.postRoleNexusEditModalShow = true
      this.getAllRole().then(res => {
        if (res.data.success) {
          this.roleSetOfPostRoleNexusEdit = res.data.data
          let rolePostNexusQuery = new RolePostNexusQuery()
          rolePostNexusQuery.postId = this.postSelectRow[0].postId
          this.queryRolePostNexus(rolePostNexusQuery).then(res => {
            if (res.data.success) {
              this.resetPostRoleNexusForm()
              res.data.data.forEach(rolePostNexus => {
                this.roleNameList.push(rolePostNexus.roleId)
              })
              let postEdit = new Post()
              postEdit.postId = this.postSelectRow[0].postId
              this.getPostByPk(postEdit).then(res => {
                if (res.data.success) {
                  Object.assign(this.post, res.data.data[0])
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
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    resetPostRoleNexusForm () {
      this.roleNameList = []
    },
    postRoleNexusEditToPostList () {
      this.postRoleNexusEditModalShow = false
      this.getPostSet()
    },
    savePostRoleNexusForm () {
      this.postRoleNexusSubmitting = true
      let rolePostNexusList = []
      this.roleNameList.forEach(roleName => {
        let rolePostNexus = new RolePostNexus()
        rolePostNexus.postId = this.post.postId
        rolePostNexus.roleId = roleName
        rolePostNexusList.push(rolePostNexus)
      })
      if (rolePostNexusList.length > 0) {
        let delRolePostNexus = new RolePostNexus()
        delRolePostNexus.postId = this.post.postId
        this.removeRolePostNexus(delRolePostNexus).then(res => {
          if (res.data.success) {
            this.batchSaveRolePostNexus(rolePostNexusList).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '角色岗位信息保存成功.', duration: 3 })
                this.resetPostRoleNexusForm()
                this.post = new Post()
                this.postRoleNexusSubmitting = false
                this.postRoleNexusEditToPostList()
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.postRoleNexusSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.postRoleNexusSubmitting = false }, 3000)
            })
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.postRoleNexusSubmitting = false }, 3000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.postRoleNexusSubmitting = false }, 3000)
        })
      } else {
        setTimeout(() => { this.postRoleNexusSubmitting = false }, 3000)
      }
    }
  },
  mounted () {
    this.getPostSet()
  }
}
</script>

<style lang="less" scoped>
  @import './cusAgent.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="cusAgentKeySearchSubmitting" @on-search="keySearchCusAgent($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="cusAgentQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="cusAgentQueryForm" :model="cusAgentQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="客户ID：" prop="cusBaseId">
                      <Input v-model="cusAgentQuery.cusBaseId" placeholder="输入客户ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="委托代理人：" prop="aePer">
                      <Input v-model="cusAgentQuery.aePer" placeholder="输入委托代理人"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="委托代理人电话：" prop="aePhone">
                      <Input v-model="cusAgentQuery.aePhone" placeholder="输入委托代理人电话"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="委托代理人传真：" prop="aeFax">
                      <Input v-model="cusAgentQuery.aeFax" placeholder="输入委托代理人传真"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="委托事项：" prop="aeMatter">
                      <Input v-model="cusAgentQuery.aeMatter" placeholder="输入委托事项"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="委托时间：" prop="aeDate">
                      <Input v-model="cusAgentQuery.aeDate" placeholder="输入委托时间"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="机构ID：" prop="orgId">
                      <Input v-model="cusAgentQuery.orgId" placeholder="输入机构ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="委托结束时间：" prop="aeEdate">
                      <Input v-model="cusAgentQuery.aeEdate" placeholder="输入委托结束时间"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="附件IDs：" prop="uploadIds">
                      <Input v-model="cusAgentQuery.uploadIds" placeholder="输入附件IDs"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="cusAgentQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                      <Input v-model="cusAgentQuery.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程状态：" prop="actProcessStatus">
                      <Input v-model="cusAgentQuery.actProcessStatus" placeholder="输入流程状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="cusAgentQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="cusAgentQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="cusAgentQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="cusAgentQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="cusAgentQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="cusAgentQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="cusAgentQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改机构：" prop="modifyOrg">
                      <Input v-model="cusAgentQuery.modifyOrg" placeholder="输入修改机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="cusAgentQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="cusAgentQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryCusAgent()" :loading="cusAgentQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetCusAgentQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusAgent()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusAgent()" v-if="cusAgentSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusAgent()" v-if="cusAgentSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusAgent()" v-if="cusAgentSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="cusAgentColumnsChecked" @on-change="changeCusAgentColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusBaseId">客户ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="aePer">委托代理人</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="aePhone">委托代理人电话</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="aeFax">委托代理人传真</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="aeMatter">委托事项</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="aeDate">委托时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="orgId">机构ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="aeEdate">委托结束时间</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="uploadIds">附件IDs</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="remark">备注</Checkbox>
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
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusAgentColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusAgentColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="cusAgentColumns" :data="cusAgentSet" @on-selection-change="setCusAgentSelectRow($event)" @on-row-dblclick="dblclickDetailCusAgent($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusAgentCount" :current="cusAgentPage" :page-size-opts="[10, 30, 50]" @on-change="cusAgentPageIndexChange($event)" @on-page-size-change="cusAgentPageSizeChange($event)" v-if="cusAgentPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="cusAgentRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="cusAgentSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="cusAgentEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑客户委托信息
        </p>
        <Form class="pro-margin-top-20" ref="cusAgentForm" :model="cusAgent" :rules="cusAgentFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户ID：" prop="cusBaseId">
                <Input v-model="cusAgent.cusBaseId" placeholder="输入客户ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="委托代理人：" prop="aePer">
                <Input v-model="cusAgent.aePer" placeholder="输入委托代理人"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="委托代理人电话：" prop="aePhone">
                <Input v-model="cusAgent.aePhone" placeholder="输入委托代理人电话"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="委托代理人传真：" prop="aeFax">
                <Input v-model="cusAgent.aeFax" placeholder="输入委托代理人传真"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="委托事项：" prop="aeMatter">
                <Input v-model="cusAgent.aeMatter" placeholder="输入委托事项"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="委托时间：" prop="aeDate">
                <Input v-model="cusAgent.aeDate" placeholder="输入委托时间"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="机构ID：" prop="orgId">
                <Input v-model="cusAgent.orgId" placeholder="输入机构ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="委托结束时间：" prop="aeEdate">
                <Input v-model="cusAgent.aeEdate" placeholder="输入委托结束时间"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="附件IDs：" prop="uploadIds">
                <Input v-model="cusAgent.uploadIds" placeholder="输入附件IDs"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="cusAgent.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                <Input v-model="cusAgent.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程状态：" prop="actProcessStatus">
                <Input v-model="cusAgent.actProcessStatus" placeholder="输入流程状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="cusAgent.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="cusAgent.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="cusAgent.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="cusAgent.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="cusAgent.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="cusAgent.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="cusAgent.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改机构：" prop="modifyOrg">
                <Input v-model="cusAgent.modifyOrg" placeholder="输入修改机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="cusAgent.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="cusAgent.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toCusAgentList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetCusAgentForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusAgentSubmitting" @click="saveCusAgentForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusAgentSubmitting" @click="saveAddCusAgentForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="cusAgentDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户委托信息详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ cusAgent.cusAgentId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户ID：{{ cusAgent.cusBaseId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>委托代理人：{{ cusAgent.aePer }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>委托代理人电话：{{ cusAgent.aePhone }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>委托代理人传真：{{ cusAgent.aeFax }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>委托事项：{{ cusAgent.aeMatter }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>委托时间：{{ cusAgent.aeDate }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>机构ID：{{ cusAgent.orgId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>委托结束时间：{{ cusAgent.aeEdate }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>附件IDs：{{ cusAgent.uploadIds }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ cusAgent.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程实例ID：{{ cusAgent.actProcessInstanceId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程状态：{{ cusAgent.actProcessStatus }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ cusAgent.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ cusAgent.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ cusAgent.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ cusAgent.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ cusAgent.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ cusAgent.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ cusAgent.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改机构：{{ cusAgent.modifyOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ cusAgent.modifyTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ cusAgent.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusAgent from '@/view/com/drzyl/cus/cusAgent/CusAgent'
import CusAgentQuery from '@/view/com/drzyl/cus/cusAgent/CusAgentQuery'

export default {
  data () {
    return {
      cusAgentColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        { title: '委托代理人', key: 'aePer', minWidth: 200, sortable: true },
        { title: '委托代理人电话', key: 'aePhone', minWidth: 200, sortable: true },
        { title: '委托代理人传真', key: 'aeFax', minWidth: 200, sortable: true },
        { title: '委托事项', key: 'aeMatter', minWidth: 200, sortable: true },
        { title: '委托时间', key: 'aeDate', minWidth: 200, sortable: true },
        { title: '机构ID', key: 'orgId', minWidth: 200, sortable: true },
        { title: '委托结束时间', key: 'aeEdate', minWidth: 200, sortable: true },
        { title: '附件IDs', key: 'uploadIds', minWidth: 200, sortable: true },
        { title: '备注', key: 'remark', minWidth: 200, sortable: true },
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
      cusAgentFormValidate: {
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
      cusAgentColumnsChecked: [
        'cusAgentId',
        'cusBaseId',
        'aePer',
        'aePhone',
        'aeFax',
        'aeMatter',
        'aeDate',
        'orgId',
        'aeEdate',
        'uploadIds',
        'remark',
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
      cusAgentColumnsNexus: {
        cusAgentId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        cusBaseId: { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        aePer: { title: '委托代理人', key: 'aePer', minWidth: 200, sortable: true },
        aePhone: { title: '委托代理人电话', key: 'aePhone', minWidth: 200, sortable: true },
        aeFax: { title: '委托代理人传真', key: 'aeFax', minWidth: 200, sortable: true },
        aeMatter: { title: '委托事项', key: 'aeMatter', minWidth: 200, sortable: true },
        aeDate: { title: '委托时间', key: 'aeDate', minWidth: 200, sortable: true },
        orgId: { title: '机构ID', key: 'orgId', minWidth: 200, sortable: true },
        aeEdate: { title: '委托结束时间', key: 'aeEdate', minWidth: 200, sortable: true },
        uploadIds: { title: '附件IDs', key: 'uploadIds', minWidth: 200, sortable: true },
        remark: { title: '备注', key: 'remark', minWidth: 200, sortable: true },
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
      cusAgentSet: [],
      cusAgentCount: 0,
      cusAgentRows: 10,
      cusAgentPage: 1,
      cusAgentSelectRow: [],
      cusAgentSelectRowLength: 0,
      cusAgent: new CusAgent(),
      cusAgentQuery: new CusAgentQuery(),
      cusAgentSpinShow: false,
      cusAgentPageShow: true,
      cusAgentEditModalShow: false,
      cusAgentSubmitting: false,
      cusAgentContinue: false,
      cusAgentDetailDrawerShow: false,
      cusAgentQueryPoptipShow: false,
      cusAgentQuerySubmitting: false,
      cusAgentKeySearchSubmitting: false,
      cusAgentKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('cusAgentStore', [
    ]),
    ...mapGetters('cusAgentStore', [
    ])
  },
  methods: {
    ...mapMutations('cusAgentStore', [
    ]),
    ...mapActions('cusAgentStore', [
      'saveCusAgent',
      'updateCusAgent',
      'batchRemoveCusAgent',
      'getCusAgentByPk',
      'queryCusAgent',
      'pagingQueryCusAgent'
    ]),
    addCusAgent () {
      this.cusAgentEditModalShow = true
      this.cusAgent = new CusAgent()
    },
    upCusAgent () {
      this.cusAgentEditModalShow = true
      let cusAgentEdit = new CusAgent()
      cusAgentEdit.cusAgentId = this.cusAgentSelectRow[0].cusAgentId
      this.getCusAgentByPk(cusAgentEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAgent, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toCusAgentList () {
      this.cusAgentEditModalShow = false
      this.resetCusAgentForm()
      this.getCusAgentSet()
    },
    resetCusAgentForm () {
      this.$refs.cusAgentForm.resetFields()
    },
    saveCusAgentForm () {
      this.cusAgentContinue = false
      this.submitCusAgentForm()
    },
    saveAddCusAgentForm () {
      this.cusAgentContinue = true
      this.submitCusAgentForm()
    },
    submitCusAgentForm () {
      this.cusAgentSubmitting = true
      this.$refs.cusAgentForm.validate((valid) => {
        if (valid) {
          if (this.cusAgent.cusAgentId) {
            this.updateCusAgent(this.cusAgent).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户委托信息信息修改成功.', duration: 3 })
                this.resetCusAgentForm()
                this.cusAgent = new CusAgent()
                this.cusAgentSubmitting = false
                if (!this.cusAgentContinue) {
                  this.toCusAgentList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusAgentSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusAgentSubmitting = false }, 3000)
            })
          } else {
            this.saveCusAgent(this.cusAgent).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户委托信息信息保存成功.', duration: 3 })
                this.resetCusAgentForm()
                this.cusAgent = new CusAgent()
                this.cusAgentSubmitting = false
                if (!this.cusAgentContinue) {
                  this.toCusAgentList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusAgentSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusAgentSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.cusAgentSubmitting = false }, 3000)
        }
      })
    },
    delCusAgent () {
      this.cusAgentSpinShow = true
      this.batchRemoveCusAgent(this.cusAgentSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '客户委托信息信息删除成功.', duration: 3 })
          this.setCusAgentSelectRow([])
          this.getCusAgentSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAgentSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAgentSpinShow = false }, 700)
      })
    },
    detailCusAgent () {
      this.cusAgentDetailDrawerShow = true
      let cusAgentDetail = new CusAgent()
      cusAgentDetail.cusAgentId = this.cusAgentSelectRow[0].cusAgentId
      this.getCusAgentByPk(cusAgentDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAgent, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailCusAgent (rowData) {
      this.cusAgentDetailDrawerShow = true
      let cusAgentDetail = new CusAgent()
      cusAgentDetail.cusAgentId = rowData.cusAgentId
      this.getCusAgentByPk(cusAgentDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAgent, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getCusAgentSet () {
      this.cusAgentSpinShow = true
      this.cusAgentPageShow = true
      this.pagingQueryCusAgent({ cusAgentQuery: {}, rows: this.cusAgentRows, page: this.cusAgentPage }).then(res => {
        if (res.data.success) {
          this.cusAgentSet = res.data.data
          this.cusAgentCount = res.data.count
          this.setCusAgentSelectRow([])
          setTimeout(() => { this.cusAgentSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAgentSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAgentSpinShow = false }, 700)
      })
    },
    keySearchCusAgent (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.cusAgentKeySearchSubmitting = true
        this.cusAgentPageShow = false
        this.cusAgentSpinShow = true
        let cusAgentQueryKeySearch = new CusAgentQuery()
        cusAgentQueryKeySearch.cusBaseIdAndKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.aePerOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.aePhoneOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.aeFaxOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.aeMatterOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.aeDateOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.orgIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.aeEdateOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.uploadIdsOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.actProcessInstanceIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.actProcessStatusOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusAgentQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryCusAgent(cusAgentQueryKeySearch).then(res => {
          if (res.data.success) {
            this.cusAgentSet = res.data.data
            this.cusAgentCount = res.data.count
            this.setCusAgentSelectRow([])
            setTimeout(() => { this.cusAgentSpinShow = false }, 700)
            setTimeout(() => { this.cusAgentKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.cusAgentSpinShow = false }, 700)
            setTimeout(() => { this.cusAgentKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.cusAgentSpinShow = false }, 700)
          setTimeout(() => { this.cusAgentKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.cusAgentKeySearchClickRate++
        if (this.cusAgentKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.cusAgentKeySearchClickRate = 0
        }
      }
    },
    vagueQueryCusAgent () {
      this.cusAgentQuerySubmitting = true
      this.cusAgentPageShow = false
      this.cusAgentSpinShow = true
      this.cusAgentQueryPoptipShow = false
      this.queryCusAgent(this.cusAgentQuery).then(res => {
        if (res.data.success) {
          this.cusAgentSet = res.data.data
          this.cusAgentCount = res.data.count
          this.setCusAgentSelectRow([])
          setTimeout(() => { this.cusAgentSpinShow = false }, 700)
          setTimeout(() => { this.cusAgentQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAgentSpinShow = false }, 700)
          setTimeout(() => { this.cusAgentQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAgentSpinShow = false }, 700)
        setTimeout(() => { this.cusAgentQuerySubmitting = false }, 5000)
      })
    },
    resetCusAgentQueryForm () {
      this.$refs.cusAgentQueryForm.resetFields()
    },
    setCusAgentSelectRow (list) {
      this.cusAgentSelectRow = list
      this.cusAgentSelectRowLength = list.length
    },
    cusAgentPageIndexChange (pageIndex) {
      this.cusAgentPage = pageIndex
      this.getCusAgentSet()
    },
    cusAgentPageSizeChange (pageSize) {
      this.cusAgentRows = pageSize
      this.cusAgentPage = 1
      this.getCusAgentSet()
    },
    cusAgentRefresh () {
      this.cusAgentPage = 1
      this.getCusAgentSet()
    },
    changeCusAgentColumns () {
      this.cusAgentColumns = []
      this.cusAgentColumnsChecked.forEach(col => this.cusAgentColumns.push(this.cusAgentColumnsNexus[col]))
    },
    cleanCusAgentColumns () {
      this.cusAgentColumnsChecked = [
        'cusAgentId'
      ]
      this.cusAgentColumns = []
      this.cusAgentColumnsChecked.forEach(col => this.cusAgentColumns.push(this.cusAgentColumnsNexus[col]))
    },
    resetCusAgentColumns () {
      this.cusAgentColumnsChecked = [
        'cusAgentId',
        'cusBaseId',
        'aePer',
        'aePhone',
        'aeFax',
        'aeMatter',
        'aeDate',
        'orgId',
        'aeEdate',
        'uploadIds',
        'remark',
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
      this.cusAgentColumns = []
      this.cusAgentColumnsChecked.forEach(col => this.cusAgentColumns.push(this.cusAgentColumnsNexus[col]))
    }
  },
  mounted () {
    this.getCusAgentSet()
  }
}
</script>

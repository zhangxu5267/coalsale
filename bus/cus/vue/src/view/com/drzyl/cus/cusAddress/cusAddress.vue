<style lang="less" scoped>
  @import './cusAddress.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="cusAddressKeySearchSubmitting" @on-search="keySearchCusAddress($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="cusAddressQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="cusAddressQueryForm" :model="cusAddressQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="客户ID：" prop="cusBaseId">
                      <Input v-model="cusAddressQuery.cusBaseId" placeholder="输入客户ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户编码：" prop="cusNo">
                      <Input v-model="cusAddressQuery.cusNo" placeholder="输入客户编码"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="收货地址：" prop="recAddress">
                      <Input v-model="cusAddressQuery.recAddress" placeholder="输入收货地址"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="专线：" prop="deline">
                      <Input v-model="cusAddressQuery.deline" placeholder="输入专线"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="到站名称：" prop="arriveStationName">
                      <Input v-model="cusAddressQuery.arriveStationName" placeholder="输入到站名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="到站编码：" prop="arriveStationNo">
                      <Input v-model="cusAddressQuery.arriveStationNo" placeholder="输入到站编码"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="cusAddressQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="附件IDs：" prop="uploadIds">
                      <Input v-model="cusAddressQuery.uploadIds" placeholder="输入附件IDs"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                      <Input v-model="cusAddressQuery.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程状态：" prop="actProcessStatus">
                      <Input v-model="cusAddressQuery.actProcessStatus" placeholder="输入流程状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="cusAddressQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="cusAddressQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="cusAddressQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="cusAddressQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="cusAddressQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="cusAddressQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="cusAddressQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改机构：" prop="modifyOrg">
                      <Input v-model="cusAddressQuery.modifyOrg" placeholder="输入修改机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="cusAddressQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="cusAddressQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryCusAddress()" :loading="cusAddressQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetCusAddressQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusAddress()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusAddress()" v-if="cusAddressSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusAddress()" v-if="cusAddressSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusAddress()" v-if="cusAddressSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="cusAddressColumnsChecked" @on-change="changeCusAddressColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusBaseId">客户ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusNo">客户编码</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="recAddress">收货地址</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="deline">专线</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="arriveStationName">到站名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="arriveStationNo">到站编码</Checkbox>
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
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusAddressColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusAddressColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="cusAddressColumns" :data="cusAddressSet" @on-selection-change="setCusAddressSelectRow($event)" @on-row-dblclick="dblclickDetailCusAddress($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusAddressCount" :current="cusAddressPage" :page-size-opts="[10, 30, 50]" @on-change="cusAddressPageIndexChange($event)" @on-page-size-change="cusAddressPageSizeChange($event)" v-if="cusAddressPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="cusAddressRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="cusAddressSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="cusAddressEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑客户收货单位
        </p>
        <Form class="pro-margin-top-20" ref="cusAddressForm" :model="cusAddress" :rules="cusAddressFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户ID：" prop="cusBaseId">
                <Input v-model="cusAddress.cusBaseId" placeholder="输入客户ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户编码：" prop="cusNo">
                <Input v-model="cusAddress.cusNo" placeholder="输入客户编码"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="收货地址：" prop="recAddress">
                <Input v-model="cusAddress.recAddress" placeholder="输入收货地址"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="专线：" prop="deline">
                <Input v-model="cusAddress.deline" placeholder="输入专线"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="到站名称：" prop="arriveStationName">
                <Input v-model="cusAddress.arriveStationName" placeholder="输入到站名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="到站编码：" prop="arriveStationNo">
                <Input v-model="cusAddress.arriveStationNo" placeholder="输入到站编码"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="cusAddress.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="附件IDs：" prop="uploadIds">
                <Input v-model="cusAddress.uploadIds" placeholder="输入附件IDs"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                <Input v-model="cusAddress.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程状态：" prop="actProcessStatus">
                <Input v-model="cusAddress.actProcessStatus" placeholder="输入流程状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="cusAddress.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="cusAddress.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="cusAddress.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="cusAddress.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="cusAddress.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="cusAddress.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="cusAddress.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改机构：" prop="modifyOrg">
                <Input v-model="cusAddress.modifyOrg" placeholder="输入修改机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="cusAddress.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="cusAddress.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toCusAddressList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetCusAddressForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusAddressSubmitting" @click="saveCusAddressForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusAddressSubmitting" @click="saveAddCusAddressForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="cusAddressDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户收货单位详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ cusAddress.cusAddressId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户ID：{{ cusAddress.cusBaseId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户编码：{{ cusAddress.cusNo }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>收货地址：{{ cusAddress.recAddress }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>专线：{{ cusAddress.deline }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>到站名称：{{ cusAddress.arriveStationName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>到站编码：{{ cusAddress.arriveStationNo }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ cusAddress.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>附件IDs：{{ cusAddress.uploadIds }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程实例ID：{{ cusAddress.actProcessInstanceId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程状态：{{ cusAddress.actProcessStatus }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ cusAddress.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ cusAddress.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ cusAddress.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ cusAddress.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ cusAddress.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ cusAddress.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ cusAddress.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改机构：{{ cusAddress.modifyOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ cusAddress.modifyTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ cusAddress.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusAddress from '@/view/com/drzyl/cus/cusAddress/CusAddress'
import CusAddressQuery from '@/view/com/drzyl/cus/cusAddress/CusAddressQuery'

export default {
  data () {
    return {
      cusAddressColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        { title: '客户编码', key: 'cusNo', minWidth: 200, sortable: true },
        { title: '收货地址', key: 'recAddress', minWidth: 200, sortable: true },
        { title: '专线', key: 'deline', minWidth: 200, sortable: true },
        { title: '到站名称', key: 'arriveStationName', minWidth: 200, sortable: true },
        { title: '到站编码', key: 'arriveStationNo', minWidth: 200, sortable: true },
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
      cusAddressFormValidate: {
        cusBaseId: [
          { required: true, message: '客户ID不能为空', trigger: 'blur' }
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
      cusAddressColumnsChecked: [
        'cusAddressId',
        'cusBaseId',
        'cusNo',
        'recAddress',
        'deline',
        'arriveStationName',
        'arriveStationNo',
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
      cusAddressColumnsNexus: {
        cusAddressId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        cusBaseId: { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        cusNo: { title: '客户编码', key: 'cusNo', minWidth: 200, sortable: true },
        recAddress: { title: '收货地址', key: 'recAddress', minWidth: 200, sortable: true },
        deline: { title: '专线', key: 'deline', minWidth: 200, sortable: true },
        arriveStationName: { title: '到站名称', key: 'arriveStationName', minWidth: 200, sortable: true },
        arriveStationNo: { title: '到站编码', key: 'arriveStationNo', minWidth: 200, sortable: true },
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
      cusAddressSet: [],
      cusAddressCount: 0,
      cusAddressRows: 10,
      cusAddressPage: 1,
      cusAddressSelectRow: [],
      cusAddressSelectRowLength: 0,
      cusAddress: new CusAddress(),
      cusAddressQuery: new CusAddressQuery(),
      cusAddressSpinShow: false,
      cusAddressPageShow: true,
      cusAddressEditModalShow: false,
      cusAddressSubmitting: false,
      cusAddressContinue: false,
      cusAddressDetailDrawerShow: false,
      cusAddressQueryPoptipShow: false,
      cusAddressQuerySubmitting: false,
      cusAddressKeySearchSubmitting: false,
      cusAddressKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('cusAddressStore', [
    ]),
    ...mapGetters('cusAddressStore', [
    ])
  },
  methods: {
    ...mapMutations('cusAddressStore', [
    ]),
    ...mapActions('cusAddressStore', [
      'saveCusAddress',
      'updateCusAddress',
      'batchRemoveCusAddress',
      'getCusAddressByPk',
      'queryCusAddress',
      'pagingQueryCusAddress'
    ]),
    addCusAddress () {
      this.cusAddressEditModalShow = true
      this.cusAddress = new CusAddress()
    },
    upCusAddress () {
      this.cusAddressEditModalShow = true
      let cusAddressEdit = new CusAddress()
      cusAddressEdit.cusAddressId = this.cusAddressSelectRow[0].cusAddressId
      this.getCusAddressByPk(cusAddressEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAddress, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toCusAddressList () {
      this.cusAddressEditModalShow = false
      this.resetCusAddressForm()
      this.getCusAddressSet()
    },
    resetCusAddressForm () {
      this.$refs.cusAddressForm.resetFields()
    },
    saveCusAddressForm () {
      this.cusAddressContinue = false
      this.submitCusAddressForm()
    },
    saveAddCusAddressForm () {
      this.cusAddressContinue = true
      this.submitCusAddressForm()
    },
    submitCusAddressForm () {
      this.cusAddressSubmitting = true
      this.$refs.cusAddressForm.validate((valid) => {
        if (valid) {
          if (this.cusAddress.cusAddressId) {
            this.updateCusAddress(this.cusAddress).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户收货单位信息修改成功.', duration: 3 })
                this.resetCusAddressForm()
                this.cusAddress = new CusAddress()
                this.cusAddressSubmitting = false
                if (!this.cusAddressContinue) {
                  this.toCusAddressList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusAddressSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusAddressSubmitting = false }, 3000)
            })
          } else {
            this.saveCusAddress(this.cusAddress).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户收货单位信息保存成功.', duration: 3 })
                this.resetCusAddressForm()
                this.cusAddress = new CusAddress()
                this.cusAddressSubmitting = false
                if (!this.cusAddressContinue) {
                  this.toCusAddressList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusAddressSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusAddressSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.cusAddressSubmitting = false }, 3000)
        }
      })
    },
    delCusAddress () {
      this.cusAddressSpinShow = true
      this.batchRemoveCusAddress(this.cusAddressSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '客户收货单位信息删除成功.', duration: 3 })
          this.setCusAddressSelectRow([])
          this.getCusAddressSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAddressSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAddressSpinShow = false }, 700)
      })
    },
    detailCusAddress () {
      this.cusAddressDetailDrawerShow = true
      let cusAddressDetail = new CusAddress()
      cusAddressDetail.cusAddressId = this.cusAddressSelectRow[0].cusAddressId
      this.getCusAddressByPk(cusAddressDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAddress, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailCusAddress (rowData) {
      this.cusAddressDetailDrawerShow = true
      let cusAddressDetail = new CusAddress()
      cusAddressDetail.cusAddressId = rowData.cusAddressId
      this.getCusAddressByPk(cusAddressDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusAddress, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getCusAddressSet () {
      this.cusAddressSpinShow = true
      this.cusAddressPageShow = true
      this.pagingQueryCusAddress({ cusAddressQuery: {}, rows: this.cusAddressRows, page: this.cusAddressPage }).then(res => {
        if (res.data.success) {
          this.cusAddressSet = res.data.data
          this.cusAddressCount = res.data.count
          this.setCusAddressSelectRow([])
          setTimeout(() => { this.cusAddressSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAddressSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAddressSpinShow = false }, 700)
      })
    },
    keySearchCusAddress (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.cusAddressKeySearchSubmitting = true
        this.cusAddressPageShow = false
        this.cusAddressSpinShow = true
        let cusAddressQueryKeySearch = new CusAddressQuery()
        cusAddressQueryKeySearch.cusBaseIdAndKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.cusNoOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.recAddressOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.delineOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.arriveStationNameOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.arriveStationNoOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.uploadIdsOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.actProcessInstanceIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.actProcessStatusOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusAddressQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryCusAddress(cusAddressQueryKeySearch).then(res => {
          if (res.data.success) {
            this.cusAddressSet = res.data.data
            this.cusAddressCount = res.data.count
            this.setCusAddressSelectRow([])
            setTimeout(() => { this.cusAddressSpinShow = false }, 700)
            setTimeout(() => { this.cusAddressKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.cusAddressSpinShow = false }, 700)
            setTimeout(() => { this.cusAddressKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.cusAddressSpinShow = false }, 700)
          setTimeout(() => { this.cusAddressKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.cusAddressKeySearchClickRate++
        if (this.cusAddressKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.cusAddressKeySearchClickRate = 0
        }
      }
    },
    vagueQueryCusAddress () {
      this.cusAddressQuerySubmitting = true
      this.cusAddressPageShow = false
      this.cusAddressSpinShow = true
      this.cusAddressQueryPoptipShow = false
      this.queryCusAddress(this.cusAddressQuery).then(res => {
        if (res.data.success) {
          this.cusAddressSet = res.data.data
          this.cusAddressCount = res.data.count
          this.setCusAddressSelectRow([])
          setTimeout(() => { this.cusAddressSpinShow = false }, 700)
          setTimeout(() => { this.cusAddressQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusAddressSpinShow = false }, 700)
          setTimeout(() => { this.cusAddressQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusAddressSpinShow = false }, 700)
        setTimeout(() => { this.cusAddressQuerySubmitting = false }, 5000)
      })
    },
    resetCusAddressQueryForm () {
      this.$refs.cusAddressQueryForm.resetFields()
    },
    setCusAddressSelectRow (list) {
      this.cusAddressSelectRow = list
      this.cusAddressSelectRowLength = list.length
    },
    cusAddressPageIndexChange (pageIndex) {
      this.cusAddressPage = pageIndex
      this.getCusAddressSet()
    },
    cusAddressPageSizeChange (pageSize) {
      this.cusAddressRows = pageSize
      this.cusAddressPage = 1
      this.getCusAddressSet()
    },
    cusAddressRefresh () {
      this.cusAddressPage = 1
      this.getCusAddressSet()
    },
    changeCusAddressColumns () {
      this.cusAddressColumns = []
      this.cusAddressColumnsChecked.forEach(col => this.cusAddressColumns.push(this.cusAddressColumnsNexus[col]))
    },
    cleanCusAddressColumns () {
      this.cusAddressColumnsChecked = [
        'cusAddressId'
      ]
      this.cusAddressColumns = []
      this.cusAddressColumnsChecked.forEach(col => this.cusAddressColumns.push(this.cusAddressColumnsNexus[col]))
    },
    resetCusAddressColumns () {
      this.cusAddressColumnsChecked = [
        'cusAddressId',
        'cusBaseId',
        'cusNo',
        'recAddress',
        'deline',
        'arriveStationName',
        'arriveStationNo',
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
      this.cusAddressColumns = []
      this.cusAddressColumnsChecked.forEach(col => this.cusAddressColumns.push(this.cusAddressColumnsNexus[col]))
    }
  },
  mounted () {
    this.getCusAddressSet()
  }
}
</script>

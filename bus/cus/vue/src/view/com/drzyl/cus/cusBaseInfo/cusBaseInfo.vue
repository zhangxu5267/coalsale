<style lang="less" scoped>
  @import './cusBaseInfo.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="cusBaseInfoKeySearchSubmitting" @on-search="keySearchCusBaseInfo($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="cusBaseInfoQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="cusBaseInfoQueryForm" :model="cusBaseInfoQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="客户ID：" prop="cusBaseId">
                      <Input v-model="cusBaseInfoQuery.cusBaseId" placeholder="输入客户ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户编码：" prop="cusNo">
                      <Input v-model="cusBaseInfoQuery.cusNo" placeholder="输入客户编码"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="所属机构：" prop="orgId">
                      <Input v-model="cusBaseInfoQuery.orgId" placeholder="输入所属机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="所属机构：" prop="isKey">
                      <Input v-model="cusBaseInfoQuery.isKey" placeholder="输入所属机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户所属区域：" prop="cusRegion">
                      <Input v-model="cusBaseInfoQuery.cusRegion" placeholder="输入客户所属区域"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户省份：" prop="cusProvince">
                      <Input v-model="cusBaseInfoQuery.cusProvince" placeholder="输入客户省份"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户所属行业：" prop="cusIndustry">
                      <Input v-model="cusBaseInfoQuery.cusIndustry" placeholder="输入客户所属行业"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户企业性质：" prop="cusComnature">
                      <Input v-model="cusBaseInfoQuery.cusComnature" placeholder="输入客户企业性质"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户分类：" prop="cusType">
                      <Input v-model="cusBaseInfoQuery.cusType" placeholder="输入客户分类"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="交易类型：" prop="tranType">
                      <Input v-model="cusBaseInfoQuery.tranType" placeholder="输入交易类型"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="上级客户：" prop="cusParent">
                      <Input v-model="cusBaseInfoQuery.cusParent" placeholder="输入上级客户"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="下级客户：" prop="cusSub">
                      <Input v-model="cusBaseInfoQuery.cusSub" placeholder="输入下级客户"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="公司传真：" prop="fax">
                      <Input v-model="cusBaseInfoQuery.fax" placeholder="输入公司传真"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="cusBaseInfoQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="附件IDs：" prop="uploadIds">
                      <Input v-model="cusBaseInfoQuery.uploadIds" placeholder="输入附件IDs"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                      <Input v-model="cusBaseInfoQuery.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程状态：" prop="actProcessStatus">
                      <Input v-model="cusBaseInfoQuery.actProcessStatus" placeholder="输入流程状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="cusBaseInfoQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="cusBaseInfoQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="cusBaseInfoQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="cusBaseInfoQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="cusBaseInfoQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="cusBaseInfoQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="cusBaseInfoQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改机构：" prop="modifyOrg">
                      <Input v-model="cusBaseInfoQuery.modifyOrg" placeholder="输入修改机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="cusBaseInfoQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="cusBaseInfoQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryCusBaseInfo()" :loading="cusBaseInfoQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetCusBaseInfoQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusBaseInfo()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusBaseInfo()" v-if="cusBaseInfoSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusBaseInfo()" v-if="cusBaseInfoSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusBaseInfo()" v-if="cusBaseInfoSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="cusBaseInfoColumnsChecked" @on-change="changeCusBaseInfoColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusBaseId">客户ID</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusNo">客户编码</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="orgId">所属机构</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="isKey">所属机构</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusRegion">客户所属区域</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusProvince">客户省份</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusIndustry">客户所属行业</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusComnature">客户企业性质</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusType">客户分类</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="tranType">交易类型</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusParent">上级客户</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusSub">下级客户</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="fax">公司传真</Checkbox>
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
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusBaseInfoColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusBaseInfoColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="cusBaseInfoColumns" :data="cusBaseInfoSet" @on-selection-change="setCusBaseInfoSelectRow($event)" @on-row-dblclick="dblclickDetailCusBaseInfo($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusBaseInfoCount" :current="cusBaseInfoPage" :page-size-opts="[10, 30, 50]" @on-change="cusBaseInfoPageIndexChange($event)" @on-page-size-change="cusBaseInfoPageSizeChange($event)" v-if="cusBaseInfoPageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="cusBaseInfoRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="cusBaseInfoSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="cusBaseInfoEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑客户详细信息
        </p>
        <Form class="pro-margin-top-20" ref="cusBaseInfoForm" :model="cusBaseInfo" :rules="cusBaseInfoFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户ID：" prop="cusBaseId">
                <Input v-model="cusBaseInfo.cusBaseId" placeholder="输入客户ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户编码：" prop="cusNo">
                <Input v-model="cusBaseInfo.cusNo" placeholder="输入客户编码"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="所属机构：" prop="orgId">
                <Input v-model="cusBaseInfo.orgId" placeholder="输入所属机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="所属机构：" prop="isKey">
                <Input v-model="cusBaseInfo.isKey" placeholder="输入所属机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户所属区域：" prop="cusRegion">
                <Input v-model="cusBaseInfo.cusRegion" placeholder="输入客户所属区域"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户省份：" prop="cusProvince">
                <Input v-model="cusBaseInfo.cusProvince" placeholder="输入客户省份"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户所属行业：" prop="cusIndustry">
                <Input v-model="cusBaseInfo.cusIndustry" placeholder="输入客户所属行业"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户企业性质：" prop="cusComnature">
                <Input v-model="cusBaseInfo.cusComnature" placeholder="输入客户企业性质"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户分类：" prop="cusType">
                <Input v-model="cusBaseInfo.cusType" placeholder="输入客户分类"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="交易类型：" prop="tranType">
                <Input v-model="cusBaseInfo.tranType" placeholder="输入交易类型"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="上级客户：" prop="cusParent">
                <Input v-model="cusBaseInfo.cusParent" placeholder="输入上级客户"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="下级客户：" prop="cusSub">
                <Input v-model="cusBaseInfo.cusSub" placeholder="输入下级客户"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="公司传真：" prop="fax">
                <Input v-model="cusBaseInfo.fax" placeholder="输入公司传真"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="cusBaseInfo.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="附件IDs：" prop="uploadIds">
                <Input v-model="cusBaseInfo.uploadIds" placeholder="输入附件IDs"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                <Input v-model="cusBaseInfo.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程状态：" prop="actProcessStatus">
                <Input v-model="cusBaseInfo.actProcessStatus" placeholder="输入流程状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="cusBaseInfo.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="cusBaseInfo.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="cusBaseInfo.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="cusBaseInfo.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="cusBaseInfo.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="cusBaseInfo.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="cusBaseInfo.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改机构：" prop="modifyOrg">
                <Input v-model="cusBaseInfo.modifyOrg" placeholder="输入修改机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="cusBaseInfo.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="cusBaseInfo.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toCusBaseInfoList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetCusBaseInfoForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusBaseInfoSubmitting" @click="saveCusBaseInfoForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusBaseInfoSubmitting" @click="saveAddCusBaseInfoForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="cusBaseInfoDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户详细信息详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ cusBaseInfo.cusBaseInfoId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户ID：{{ cusBaseInfo.cusBaseId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户编码：{{ cusBaseInfo.cusNo }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>所属机构：{{ cusBaseInfo.orgId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>所属机构：{{ cusBaseInfo.isKey }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户所属区域：{{ cusBaseInfo.cusRegion }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户省份：{{ cusBaseInfo.cusProvince }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户所属行业：{{ cusBaseInfo.cusIndustry }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户企业性质：{{ cusBaseInfo.cusComnature }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户分类：{{ cusBaseInfo.cusType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>交易类型：{{ cusBaseInfo.tranType }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>上级客户：{{ cusBaseInfo.cusParent }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>下级客户：{{ cusBaseInfo.cusSub }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>公司传真：{{ cusBaseInfo.fax }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ cusBaseInfo.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>附件IDs：{{ cusBaseInfo.uploadIds }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程实例ID：{{ cusBaseInfo.actProcessInstanceId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程状态：{{ cusBaseInfo.actProcessStatus }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ cusBaseInfo.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ cusBaseInfo.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ cusBaseInfo.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ cusBaseInfo.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ cusBaseInfo.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ cusBaseInfo.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ cusBaseInfo.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改机构：{{ cusBaseInfo.modifyOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ cusBaseInfo.modifyTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ cusBaseInfo.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusBaseInfo from '@/view/com/drzyl/cus/cusBaseInfo/CusBaseInfo'
import CusBaseInfoQuery from '@/view/com/drzyl/cus/cusBaseInfo/CusBaseInfoQuery'

export default {
  data () {
    return {
      cusBaseInfoColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        { title: '客户编码', key: 'cusNo', minWidth: 200, sortable: true },
        { title: '所属机构', key: 'orgId', minWidth: 200, sortable: true },
        { title: '所属机构', key: 'isKey', minWidth: 200, sortable: true },
        { title: '客户所属区域', key: 'cusRegion', minWidth: 200, sortable: true },
        { title: '客户省份', key: 'cusProvince', minWidth: 200, sortable: true },
        { title: '客户所属行业', key: 'cusIndustry', minWidth: 200, sortable: true },
        { title: '客户企业性质', key: 'cusComnature', minWidth: 200, sortable: true },
        { title: '客户分类', key: 'cusType', minWidth: 200, sortable: true },
        { title: '交易类型', key: 'tranType', minWidth: 200, sortable: true },
        { title: '上级客户', key: 'cusParent', minWidth: 200, sortable: true },
        { title: '下级客户', key: 'cusSub', minWidth: 200, sortable: true },
        { title: '公司传真', key: 'fax', minWidth: 200, sortable: true },
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
      cusBaseInfoFormValidate: {
        cusBaseId: [
          { required: true, message: '客户ID不能为空', trigger: 'blur' }
        ],
        cusNo: [
          { required: true, message: '客户编码不能为空', trigger: 'blur' }
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
      cusBaseInfoColumnsChecked: [
        'cusBaseInfoId',
        'cusBaseId',
        'cusNo',
        'orgId',
        'isKey',
        'cusRegion',
        'cusProvince',
        'cusIndustry',
        'cusComnature',
        'cusType',
        'tranType',
        'cusParent',
        'cusSub',
        'fax',
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
      cusBaseInfoColumnsNexus: {
        cusBaseInfoId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        cusBaseId: { title: '客户ID', key: 'cusBaseId', minWidth: 200, sortable: true },
        cusNo: { title: '客户编码', key: 'cusNo', minWidth: 200, sortable: true },
        orgId: { title: '所属机构', key: 'orgId', minWidth: 200, sortable: true },
        isKey: { title: '所属机构', key: 'isKey', minWidth: 200, sortable: true },
        cusRegion: { title: '客户所属区域', key: 'cusRegion', minWidth: 200, sortable: true },
        cusProvince: { title: '客户省份', key: 'cusProvince', minWidth: 200, sortable: true },
        cusIndustry: { title: '客户所属行业', key: 'cusIndustry', minWidth: 200, sortable: true },
        cusComnature: { title: '客户企业性质', key: 'cusComnature', minWidth: 200, sortable: true },
        cusType: { title: '客户分类', key: 'cusType', minWidth: 200, sortable: true },
        tranType: { title: '交易类型', key: 'tranType', minWidth: 200, sortable: true },
        cusParent: { title: '上级客户', key: 'cusParent', minWidth: 200, sortable: true },
        cusSub: { title: '下级客户', key: 'cusSub', minWidth: 200, sortable: true },
        fax: { title: '公司传真', key: 'fax', minWidth: 200, sortable: true },
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
      cusBaseInfoSet: [],
      cusBaseInfoCount: 0,
      cusBaseInfoRows: 10,
      cusBaseInfoPage: 1,
      cusBaseInfoSelectRow: [],
      cusBaseInfoSelectRowLength: 0,
      cusBaseInfo: new CusBaseInfo(),
      cusBaseInfoQuery: new CusBaseInfoQuery(),
      cusBaseInfoSpinShow: false,
      cusBaseInfoPageShow: true,
      cusBaseInfoEditModalShow: false,
      cusBaseInfoSubmitting: false,
      cusBaseInfoContinue: false,
      cusBaseInfoDetailDrawerShow: false,
      cusBaseInfoQueryPoptipShow: false,
      cusBaseInfoQuerySubmitting: false,
      cusBaseInfoKeySearchSubmitting: false,
      cusBaseInfoKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('cusBaseInfoStore', [
    ]),
    ...mapGetters('cusBaseInfoStore', [
    ])
  },
  methods: {
    ...mapMutations('cusBaseInfoStore', [
    ]),
    ...mapActions('cusBaseInfoStore', [
      'saveCusBaseInfo',
      'updateCusBaseInfo',
      'batchRemoveCusBaseInfo',
      'getCusBaseInfoByPk',
      'queryCusBaseInfo',
      'pagingQueryCusBaseInfo'
    ]),
    addCusBaseInfo () {
      this.cusBaseInfoEditModalShow = true
      this.cusBaseInfo = new CusBaseInfo()
    },
    upCusBaseInfo () {
      this.cusBaseInfoEditModalShow = true
      let cusBaseInfoEdit = new CusBaseInfo()
      cusBaseInfoEdit.cusBaseInfoId = this.cusBaseInfoSelectRow[0].cusBaseInfoId
      this.getCusBaseInfoByPk(cusBaseInfoEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.cusBaseInfo, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toCusBaseInfoList () {
      this.cusBaseInfoEditModalShow = false
      this.resetCusBaseInfoForm()
      this.getCusBaseInfoSet()
    },
    resetCusBaseInfoForm () {
      this.$refs.cusBaseInfoForm.resetFields()
    },
    saveCusBaseInfoForm () {
      this.cusBaseInfoContinue = false
      this.submitCusBaseInfoForm()
    },
    saveAddCusBaseInfoForm () {
      this.cusBaseInfoContinue = true
      this.submitCusBaseInfoForm()
    },
    submitCusBaseInfoForm () {
      this.cusBaseInfoSubmitting = true
      this.$refs.cusBaseInfoForm.validate((valid) => {
        if (valid) {
          if (this.cusBaseInfo.cusBaseInfoId) {
            this.updateCusBaseInfo(this.cusBaseInfo).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户详细信息信息修改成功.', duration: 3 })
                this.resetCusBaseInfoForm()
                this.cusBaseInfo = new CusBaseInfo()
                this.cusBaseInfoSubmitting = false
                if (!this.cusBaseInfoContinue) {
                  this.toCusBaseInfoList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusBaseInfoSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusBaseInfoSubmitting = false }, 3000)
            })
          } else {
            this.saveCusBaseInfo(this.cusBaseInfo).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户详细信息信息保存成功.', duration: 3 })
                this.resetCusBaseInfoForm()
                this.cusBaseInfo = new CusBaseInfo()
                this.cusBaseInfoSubmitting = false
                if (!this.cusBaseInfoContinue) {
                  this.toCusBaseInfoList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusBaseInfoSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusBaseInfoSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.cusBaseInfoSubmitting = false }, 3000)
        }
      })
    },
    delCusBaseInfo () {
      this.cusBaseInfoSpinShow = true
      this.batchRemoveCusBaseInfo(this.cusBaseInfoSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '客户详细信息信息删除成功.', duration: 3 })
          this.setCusBaseInfoSelectRow([])
          this.getCusBaseInfoSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
      })
    },
    detailCusBaseInfo () {
      this.cusBaseInfoDetailDrawerShow = true
      let cusBaseInfoDetail = new CusBaseInfo()
      cusBaseInfoDetail.cusBaseInfoId = this.cusBaseInfoSelectRow[0].cusBaseInfoId
      this.getCusBaseInfoByPk(cusBaseInfoDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusBaseInfo, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailCusBaseInfo (rowData) {
      this.cusBaseInfoDetailDrawerShow = true
      let cusBaseInfoDetail = new CusBaseInfo()
      cusBaseInfoDetail.cusBaseInfoId = rowData.cusBaseInfoId
      this.getCusBaseInfoByPk(cusBaseInfoDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusBaseInfo, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getCusBaseInfoSet () {
      this.cusBaseInfoSpinShow = true
      this.cusBaseInfoPageShow = true
      this.pagingQueryCusBaseInfo({ cusBaseInfoQuery: {}, rows: this.cusBaseInfoRows, page: this.cusBaseInfoPage }).then(res => {
        if (res.data.success) {
          this.cusBaseInfoSet = res.data.data
          this.cusBaseInfoCount = res.data.count
          this.setCusBaseInfoSelectRow([])
          setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
      })
    },
    keySearchCusBaseInfo (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.cusBaseInfoKeySearchSubmitting = true
        this.cusBaseInfoPageShow = false
        this.cusBaseInfoSpinShow = true
        let cusBaseInfoQueryKeySearch = new CusBaseInfoQuery()
        cusBaseInfoQueryKeySearch.cusBaseIdAndKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusNoOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.orgIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.isKeyOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusRegionOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusProvinceOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusIndustryOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusComnatureOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusTypeOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.tranTypeOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusParentOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.cusSubOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.faxOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.uploadIdsOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.actProcessInstanceIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.actProcessStatusOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseInfoQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryCusBaseInfo(cusBaseInfoQueryKeySearch).then(res => {
          if (res.data.success) {
            this.cusBaseInfoSet = res.data.data
            this.cusBaseInfoCount = res.data.count
            this.setCusBaseInfoSelectRow([])
            setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
            setTimeout(() => { this.cusBaseInfoKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
            setTimeout(() => { this.cusBaseInfoKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
          setTimeout(() => { this.cusBaseInfoKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.cusBaseInfoKeySearchClickRate++
        if (this.cusBaseInfoKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.cusBaseInfoKeySearchClickRate = 0
        }
      }
    },
    vagueQueryCusBaseInfo () {
      this.cusBaseInfoQuerySubmitting = true
      this.cusBaseInfoPageShow = false
      this.cusBaseInfoSpinShow = true
      this.cusBaseInfoQueryPoptipShow = false
      this.queryCusBaseInfo(this.cusBaseInfoQuery).then(res => {
        if (res.data.success) {
          this.cusBaseInfoSet = res.data.data
          this.cusBaseInfoCount = res.data.count
          this.setCusBaseInfoSelectRow([])
          setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
          setTimeout(() => { this.cusBaseInfoQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
          setTimeout(() => { this.cusBaseInfoQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusBaseInfoSpinShow = false }, 700)
        setTimeout(() => { this.cusBaseInfoQuerySubmitting = false }, 5000)
      })
    },
    resetCusBaseInfoQueryForm () {
      this.$refs.cusBaseInfoQueryForm.resetFields()
    },
    setCusBaseInfoSelectRow (list) {
      this.cusBaseInfoSelectRow = list
      this.cusBaseInfoSelectRowLength = list.length
    },
    cusBaseInfoPageIndexChange (pageIndex) {
      this.cusBaseInfoPage = pageIndex
      this.getCusBaseInfoSet()
    },
    cusBaseInfoPageSizeChange (pageSize) {
      this.cusBaseInfoRows = pageSize
      this.cusBaseInfoPage = 1
      this.getCusBaseInfoSet()
    },
    cusBaseInfoRefresh () {
      this.cusBaseInfoPage = 1
      this.getCusBaseInfoSet()
    },
    changeCusBaseInfoColumns () {
      this.cusBaseInfoColumns = []
      this.cusBaseInfoColumnsChecked.forEach(col => this.cusBaseInfoColumns.push(this.cusBaseInfoColumnsNexus[col]))
    },
    cleanCusBaseInfoColumns () {
      this.cusBaseInfoColumnsChecked = [
        'cusBaseInfoId'
      ]
      this.cusBaseInfoColumns = []
      this.cusBaseInfoColumnsChecked.forEach(col => this.cusBaseInfoColumns.push(this.cusBaseInfoColumnsNexus[col]))
    },
    resetCusBaseInfoColumns () {
      this.cusBaseInfoColumnsChecked = [
        'cusBaseInfoId',
        'cusBaseId',
        'cusNo',
        'orgId',
        'isKey',
        'cusRegion',
        'cusProvince',
        'cusIndustry',
        'cusComnature',
        'cusType',
        'tranType',
        'cusParent',
        'cusSub',
        'fax',
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
      this.cusBaseInfoColumns = []
      this.cusBaseInfoColumnsChecked.forEach(col => this.cusBaseInfoColumns.push(this.cusBaseInfoColumnsNexus[col]))
    }
  },
  mounted () {
    this.getCusBaseInfoSet()
  }
}
</script>

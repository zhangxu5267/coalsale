<style lang="less" scoped>
  @import './cusBase.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="16" :sm="14" :md="10" :lg="6">
          <Input placeholder="关键字搜索" search enter-button :disabled="cusBaseKeySearchSubmitting" @on-search="keySearchCusBase($event)" />
        </Col>
        <Col :xs="8" :sm="10" :md="14" :lg="18">
          <Poptip class="pro-float-right" title="精准查询" placement="left-start" width="900" v-model="cusBaseQueryPoptipShow">
            <Button icon="ios-locate-outline">精准查询</Button>
            <div slot="content">
              <Form class="pro-margin-top-10" ref="cusBaseQueryForm" :model="cusBaseQuery" :label-width="120">
                <Row>
                  <Col span="8">
                    <FormItem label="客户编码：" prop="customNo">
                      <Input v-model="cusBaseQuery.customNo" placeholder="输入客户编码"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="单位名称：" prop="companyName">
                      <Input v-model="cusBaseQuery.companyName" placeholder="输入单位名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="社会统一信用代码：" prop="creditCode">
                      <Input v-model="cusBaseQuery.creditCode" placeholder="输入社会统一信用代码"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="地址：" prop="address">
                      <Input v-model="cusBaseQuery.address" placeholder="输入地址"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="法定代表人：" prop="legalRep">
                      <Input v-model="cusBaseQuery.legalRep" placeholder="输入法定代表人"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="法定代表人电话：" prop="legalPhone">
                      <Input v-model="cusBaseQuery.legalPhone" placeholder="输入法定代表人电话"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="法定代表人传真：" prop="legalFax">
                      <Input v-model="cusBaseQuery.legalFax" placeholder="输入法定代表人传真"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="开户银行：" prop="openingBank">
                      <Input v-model="cusBaseQuery.openingBank" placeholder="输入开户银行"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="银行账号：" prop="bankAccount">
                      <Input v-model="cusBaseQuery.bankAccount" placeholder="输入银行账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="纳税登记号：" prop="regNumber">
                      <Input v-model="cusBaseQuery.regNumber" placeholder="输入纳税登记号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="联系电话：" prop="conPhone">
                      <Input v-model="cusBaseQuery.conPhone" placeholder="输入联系电话"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="邮政编码：" prop="zipcode">
                      <Input v-model="cusBaseQuery.zipcode" placeholder="输入邮政编码"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="备注：" prop="remark">
                      <Input v-model="cusBaseQuery.remark" placeholder="输入备注"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="附件IDs：" prop="uploadIds">
                      <Input v-model="cusBaseQuery.uploadIds" placeholder="输入附件IDs"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                      <Input v-model="cusBaseQuery.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="流程状态：" prop="actProcessStatus">
                      <Input v-model="cusBaseQuery.actProcessStatus" placeholder="输入流程状态"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="版本号：" prop="versions">
                      <InputNumber v-model="cusBaseQuery.versions"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人账号：" prop="createId">
                      <Input v-model="cusBaseQuery.createId" placeholder="输入创建人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建人名称：" prop="createName">
                      <Input v-model="cusBaseQuery.createName" placeholder="输入创建人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建机构：" prop="createOrg">
                      <Input v-model="cusBaseQuery.createOrg" placeholder="输入创建机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="创建时间：" prop="createTimes">
                      <InputNumber v-model="cusBaseQuery.createTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人账号：" prop="modifyId">
                      <Input v-model="cusBaseQuery.modifyId" placeholder="输入修改人账号"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改人名称：" prop="modifyName">
                      <Input v-model="cusBaseQuery.modifyName" placeholder="输入修改人名称"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改机构：" prop="modifyOrg">
                      <Input v-model="cusBaseQuery.modifyOrg" placeholder="输入修改机构"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="修改时间：" prop="modifyTimes">
                      <InputNumber v-model="cusBaseQuery.modifyTimes"></InputNumber>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                      <Input v-model="cusBaseQuery.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
                    </FormItem>
                  </Col>
                </Row>
                <Divider />
                <Row>
                  <Col span="24">
                    <FormItem class="pro-float-right">
                      <Button type="primary" @click="vagueQueryCusBase()" :loading="cusBaseQuerySubmitting">精准查询</Button>
                      <Button class="pro-margin-left-8" @click="resetCusBaseQueryForm()">重置</Button>
                    </FormItem>
                  </Col>
                </Row>
              </Form>
            </div>
          </Poptip>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusBase()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusBase()" v-if="cusBaseSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusBase()" v-if="cusBaseSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusBase()" v-if="cusBaseSelectRowLength === 1">详情</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" placement="left-start" width="173">
        <Button type="text" size="large" icon="ios-keypad-outline"></Button>
        <div slot="content">
          <CheckboxGroup class="pro-margin-top-12" v-model="cusBaseColumnsChecked" @on-change="changeCusBaseColumns">
            <Row type="flex" justify="center">
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="customNo">客户编码</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="companyName">单位名称</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="creditCode">社会统一信用代码</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="address">地址</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="legalRep">法定代表人</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="legalPhone">法定代表人电话</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="legalFax">法定代表人传真</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="openingBank">开户银行</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="bankAccount">银行账号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="regNumber">纳税登记号</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="conPhone">联系电话</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="zipcode">邮政编码</Checkbox>
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
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusBaseColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusBaseColumns()">重置</Button>
        </div>
      </Poptip>
      <Table :columns="cusBaseColumns" :data="cusBaseSet" @on-selection-change="setCusBaseSelectRow($event)" @on-row-dblclick="dblclickDetailCusBase($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusBaseCount" :current="cusBasePage" :page-size-opts="[10, 30, 50]" @on-change="cusBasePageIndexChange($event)" @on-page-size-change="cusBasePageSizeChange($event)" v-if="cusBasePageShow" />
        <Button type="text" shape="circle" icon="md-refresh" @click="cusBaseRefresh()"></Button>
      </Row>
      <Spin size="large" fix v-if="cusBaseSpinShow"></Spin>
    </Card>
    <Modal width="60" v-model="cusBaseEditModalShow" :closable="false" :mask-closable="false" :footer-hide="true">
      <Card>
        <p slot="title">
          <Icon type="ios-brush-outline"></Icon>
          编辑客户基础信息
        </p>
        <Form class="pro-margin-top-20" ref="cusBaseForm" :model="cusBase" :rules="cusBaseFormValidate" :label-width="120">
          <Row type="flex" justify="center">
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="客户编码：" prop="customNo">
                <Input v-model="cusBase.customNo" placeholder="输入客户编码"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="单位名称：" prop="companyName">
                <Input v-model="cusBase.companyName" placeholder="输入单位名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="社会统一信用代码：" prop="creditCode">
                <Input v-model="cusBase.creditCode" placeholder="输入社会统一信用代码"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="地址：" prop="address">
                <Input v-model="cusBase.address" placeholder="输入地址"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="法定代表人：" prop="legalRep">
                <Input v-model="cusBase.legalRep" placeholder="输入法定代表人"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="法定代表人电话：" prop="legalPhone">
                <Input v-model="cusBase.legalPhone" placeholder="输入法定代表人电话"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="法定代表人传真：" prop="legalFax">
                <Input v-model="cusBase.legalFax" placeholder="输入法定代表人传真"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="开户银行：" prop="openingBank">
                <Input v-model="cusBase.openingBank" placeholder="输入开户银行"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="银行账号：" prop="bankAccount">
                <Input v-model="cusBase.bankAccount" placeholder="输入银行账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="纳税登记号：" prop="regNumber">
                <Input v-model="cusBase.regNumber" placeholder="输入纳税登记号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="联系电话：" prop="conPhone">
                <Input v-model="cusBase.conPhone" placeholder="输入联系电话"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="邮政编码：" prop="zipcode">
                <Input v-model="cusBase.zipcode" placeholder="输入邮政编码"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="备注：" prop="remark">
                <Input v-model="cusBase.remark" placeholder="输入备注"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="附件IDs：" prop="uploadIds">
                <Input v-model="cusBase.uploadIds" placeholder="输入附件IDs"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程实例ID：" prop="actProcessInstanceId">
                <Input v-model="cusBase.actProcessInstanceId" placeholder="输入流程实例ID"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="流程状态：" prop="actProcessStatus">
                <Input v-model="cusBase.actProcessStatus" placeholder="输入流程状态"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="版本号：" prop="versions">
                <InputNumber v-model="cusBase.versions"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人账号：" prop="createId">
                <Input v-model="cusBase.createId" placeholder="输入创建人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建人名称：" prop="createName">
                <Input v-model="cusBase.createName" placeholder="输入创建人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建机构：" prop="createOrg">
                <Input v-model="cusBase.createOrg" placeholder="输入创建机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="创建时间：" prop="createTimes">
                <InputNumber v-model="cusBase.createTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人账号：" prop="modifyId">
                <Input v-model="cusBase.modifyId" placeholder="输入修改人账号"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改人名称：" prop="modifyName">
                <Input v-model="cusBase.modifyName" placeholder="输入修改人名称"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改机构：" prop="modifyOrg">
                <Input v-model="cusBase.modifyOrg" placeholder="输入修改机构"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="修改时间：" prop="modifyTimes">
                <InputNumber v-model="cusBase.modifyTimes"></InputNumber>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem label="逻辑删除0=删除,1=显示：" prop="delFlag">
                <Input v-model="cusBase.delFlag" placeholder="输入逻辑删除0=删除,1=显示"></Input>
              </FormItem>
            </Col>
            <Col :xs="24" :sm="20" :md="18" :lg="14">
              <FormItem>
                <Button class="pro-margin-right-8" @click="toCusBaseList()">取消</Button>
                <Button class="pro-margin-right-8" @click="resetCusBaseForm()">重置</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusBaseSubmitting" @click="saveCusBaseForm()">保存</Button>
                <Button class="pro-margin-right-8" type="primary" :loading="cusBaseSubmitting" @click="saveAddCusBaseForm()">继续录入</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Card>
    </Modal>
    <Drawer width="45" v-model="cusBaseDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户基础信息详情
        </p>
        <Row>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>ID：{{ cusBase.cusBaseId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>客户编码：{{ cusBase.customNo }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>单位名称：{{ cusBase.companyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>社会统一信用代码：{{ cusBase.creditCode }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>地址：{{ cusBase.address }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>法定代表人：{{ cusBase.legalRep }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>法定代表人电话：{{ cusBase.legalPhone }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>法定代表人传真：{{ cusBase.legalFax }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>开户银行：{{ cusBase.openingBank }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>银行账号：{{ cusBase.bankAccount }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>纳税登记号：{{ cusBase.regNumber }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>联系电话：{{ cusBase.conPhone }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>邮政编码：{{ cusBase.zipcode }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>备注：{{ cusBase.remark }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>附件IDs：{{ cusBase.uploadIds }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程实例ID：{{ cusBase.actProcessInstanceId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>流程状态：{{ cusBase.actProcessStatus }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>版本号：{{ cusBase.versions }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人账号：{{ cusBase.createId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建人名称：{{ cusBase.createName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建机构：{{ cusBase.createOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>创建时间：{{ cusBase.createTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人账号：{{ cusBase.modifyId }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改人名称：{{ cusBase.modifyName }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改机构：{{ cusBase.modifyOrg }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>修改时间：{{ cusBase.modifyTimes }}</p>
            <Divider dashed />
          </Col>
          <Col :xs="24" :sm="24" :md="24" :lg="24">
            <p>逻辑删除0=删除,1=显示：{{ cusBase.delFlag }}</p>
            <Divider dashed />
          </Col>
        </Row>
      </Card>
    </Drawer>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusBase from '@/view/com/drzyl/cus/cusBase/CusBase'
import CusBaseQuery from '@/view/com/drzyl/cus/cusBase/CusBaseQuery'

export default {
  data () {
    return {
      cusBaseColumns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '客户编码', key: 'customNo', minWidth: 200, sortable: true },
        { title: '单位名称', key: 'companyName', minWidth: 200, sortable: true },
        { title: '社会统一信用代码', key: 'creditCode', minWidth: 200, sortable: true },
        { title: '地址', key: 'address', minWidth: 200, sortable: true },
        { title: '法定代表人', key: 'legalRep', minWidth: 200, sortable: true },
        { title: '法定代表人电话', key: 'legalPhone', minWidth: 200, sortable: true },
        { title: '法定代表人传真', key: 'legalFax', minWidth: 200, sortable: true },
        { title: '开户银行', key: 'openingBank', minWidth: 200, sortable: true },
        { title: '银行账号', key: 'bankAccount', minWidth: 200, sortable: true },
        { title: '纳税登记号', key: 'regNumber', minWidth: 200, sortable: true },
        { title: '联系电话', key: 'conPhone', minWidth: 200, sortable: true },
        { title: '邮政编码', key: 'zipcode', minWidth: 200, sortable: true },
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
      cusBaseFormValidate: {
        customNo: [
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
      cusBaseColumnsChecked: [
        'cusBaseId',
        'customNo',
        'companyName',
        'creditCode',
        'address',
        'legalRep',
        'legalPhone',
        'legalFax',
        'openingBank',
        'bankAccount',
        'regNumber',
        'conPhone',
        'zipcode',
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
      cusBaseColumnsNexus: {
        cusBaseId: { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        customNo: { title: '客户编码', key: 'customNo', minWidth: 200, sortable: true },
        companyName: { title: '单位名称', key: 'companyName', minWidth: 200, sortable: true },
        creditCode: { title: '社会统一信用代码', key: 'creditCode', minWidth: 200, sortable: true },
        address: { title: '地址', key: 'address', minWidth: 200, sortable: true },
        legalRep: { title: '法定代表人', key: 'legalRep', minWidth: 200, sortable: true },
        legalPhone: { title: '法定代表人电话', key: 'legalPhone', minWidth: 200, sortable: true },
        legalFax: { title: '法定代表人传真', key: 'legalFax', minWidth: 200, sortable: true },
        openingBank: { title: '开户银行', key: 'openingBank', minWidth: 200, sortable: true },
        bankAccount: { title: '银行账号', key: 'bankAccount', minWidth: 200, sortable: true },
        regNumber: { title: '纳税登记号', key: 'regNumber', minWidth: 200, sortable: true },
        conPhone: { title: '联系电话', key: 'conPhone', minWidth: 200, sortable: true },
        zipcode: { title: '邮政编码', key: 'zipcode', minWidth: 200, sortable: true },
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
      cusBaseSet: [],
      cusBaseCount: 0,
      cusBaseRows: 10,
      cusBasePage: 1,
      cusBaseSelectRow: [],
      cusBaseSelectRowLength: 0,
      cusBase: new CusBase(),
      cusBaseQuery: new CusBaseQuery(),
      cusBaseSpinShow: false,
      cusBasePageShow: true,
      cusBaseEditModalShow: false,
      cusBaseSubmitting: false,
      cusBaseContinue: false,
      cusBaseDetailDrawerShow: false,
      cusBaseQueryPoptipShow: false,
      cusBaseQuerySubmitting: false,
      cusBaseKeySearchSubmitting: false,
      cusBaseKeySearchClickRate: 0
    }
  },
  computed: {
    ...mapState('cusBaseStore', [
    ]),
    ...mapGetters('cusBaseStore', [
    ])
  },
  methods: {
    ...mapMutations('cusBaseStore', [
    ]),
    ...mapActions('cusBaseStore', [
      'saveCusBase',
      'updateCusBase',
      'batchRemoveCusBase',
      'getCusBaseByPk',
      'queryCusBase',
      'pagingQueryCusBase'
    ]),
    addCusBase () {
      this.cusBaseEditModalShow = true
      this.cusBase = new CusBase()
    },
    upCusBase () {
      this.cusBaseEditModalShow = true
      let cusBaseEdit = new CusBase()
      cusBaseEdit.cusBaseId = this.cusBaseSelectRow[0].cusBaseId
      this.getCusBaseByPk(cusBaseEdit).then(res => {
        if (res.data.success) {
          Object.assign(this.cusBase, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    toCusBaseList () {
      this.cusBaseEditModalShow = false
      this.resetCusBaseForm()
      this.getCusBaseSet()
    },
    resetCusBaseForm () {
      this.$refs.cusBaseForm.resetFields()
    },
    saveCusBaseForm () {
      this.cusBaseContinue = false
      this.submitCusBaseForm()
    },
    saveAddCusBaseForm () {
      this.cusBaseContinue = true
      this.submitCusBaseForm()
    },
    submitCusBaseForm () {
      this.cusBaseSubmitting = true
      this.$refs.cusBaseForm.validate((valid) => {
        if (valid) {
          if (this.cusBase.cusBaseId) {
            this.updateCusBase(this.cusBase).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户基础信息信息修改成功.', duration: 3 })
                this.resetCusBaseForm()
                this.cusBase = new CusBase()
                this.cusBaseSubmitting = false
                if (!this.cusBaseContinue) {
                  this.toCusBaseList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusBaseSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusBaseSubmitting = false }, 3000)
            })
          } else {
            this.saveCusBase(this.cusBase).then(res => {
              if (res.data.success) {
                this.$Message.success({ content: '客户基础信息信息保存成功.', duration: 3 })
                this.resetCusBaseForm()
                this.cusBase = new CusBase()
                this.cusBaseSubmitting = false
                if (!this.cusBaseContinue) {
                  this.toCusBaseList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                setTimeout(() => { this.cusBaseSubmitting = false }, 3000)
              }
            }).catch(result => {
              this.$Message.error({ content: result.response.statusText, duration: 6 })
              setTimeout(() => { this.cusBaseSubmitting = false }, 3000)
            })
          }
        } else {
          setTimeout(() => { this.cusBaseSubmitting = false }, 3000)
        }
      })
    },
    delCusBase () {
      this.cusBaseSpinShow = true
      this.batchRemoveCusBase(this.cusBaseSelectRow).then(res => {
        if (res.data.success) {
          this.$Message.success({ content: '客户基础信息信息删除成功.', duration: 3 })
          this.setCusBaseSelectRow([])
          this.getCusBaseSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusBaseSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusBaseSpinShow = false }, 700)
      })
    },
    detailCusBase () {
      this.cusBaseDetailDrawerShow = true
      let cusBaseDetail = new CusBase()
      cusBaseDetail.cusBaseId = this.cusBaseSelectRow[0].cusBaseId
      this.getCusBaseByPk(cusBaseDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusBase, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    dblclickDetailCusBase (rowData) {
      this.cusBaseDetailDrawerShow = true
      let cusBaseDetail = new CusBase()
      cusBaseDetail.cusBaseId = rowData.cusBaseId
      this.getCusBaseByPk(cusBaseDetail).then(res => {
        if (res.data.success) {
          Object.assign(this.cusBase, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    getCusBaseSet () {
      this.cusBaseSpinShow = true
      this.cusBasePageShow = true
      this.pagingQueryCusBase({ cusBaseQuery: {}, rows: this.cusBaseRows, page: this.cusBasePage }).then(res => {
        if (res.data.success) {
          this.cusBaseSet = res.data.data
          this.cusBaseCount = res.data.count
          this.setCusBaseSelectRow([])
          setTimeout(() => { this.cusBaseSpinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusBaseSpinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusBaseSpinShow = false }, 700)
      })
    },
    keySearchCusBase (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.cusBaseKeySearchSubmitting = true
        this.cusBasePageShow = false
        this.cusBaseSpinShow = true
        let cusBaseQueryKeySearch = new CusBaseQuery()
        cusBaseQueryKeySearch.customNoAndKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.companyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.creditCodeOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.addressOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.legalRepOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.legalPhoneOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.legalFaxOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.openingBankOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.bankAccountOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.regNumberOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.conPhoneOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.zipcodeOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.uploadIdsOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.actProcessInstanceIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.actProcessStatusOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.delFlagOrKeyLike = '%' + keyLikeValue + '%'
        this.queryCusBase(cusBaseQueryKeySearch).then(res => {
          if (res.data.success) {
            this.cusBaseSet = res.data.data
            this.cusBaseCount = res.data.count
            this.setCusBaseSelectRow([])
            setTimeout(() => { this.cusBaseSpinShow = false }, 700)
            setTimeout(() => { this.cusBaseKeySearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.cusBaseSpinShow = false }, 700)
            setTimeout(() => { this.cusBaseKeySearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
          setTimeout(() => { this.cusBaseSpinShow = false }, 700)
          setTimeout(() => { this.cusBaseKeySearchSubmitting = false }, 5000)
        })
      } else {
        this.cusBaseKeySearchClickRate++
        if (this.cusBaseKeySearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.cusBaseKeySearchClickRate = 0
        }
      }
    },
    vagueQueryCusBase () {
      this.cusBaseQuerySubmitting = true
      this.cusBasePageShow = false
      this.cusBaseSpinShow = true
      this.cusBaseQueryPoptipShow = false
      this.queryCusBase(this.cusBaseQuery).then(res => {
        if (res.data.success) {
          this.cusBaseSet = res.data.data
          this.cusBaseCount = res.data.count
          this.setCusBaseSelectRow([])
          setTimeout(() => { this.cusBaseSpinShow = false }, 700)
          setTimeout(() => { this.cusBaseQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.cusBaseSpinShow = false }, 700)
          setTimeout(() => { this.cusBaseQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
        setTimeout(() => { this.cusBaseSpinShow = false }, 700)
        setTimeout(() => { this.cusBaseQuerySubmitting = false }, 5000)
      })
    },
    resetCusBaseQueryForm () {
      this.$refs.cusBaseQueryForm.resetFields()
    },
    setCusBaseSelectRow (list) {
      this.cusBaseSelectRow = list
      this.cusBaseSelectRowLength = list.length
    },
    cusBasePageIndexChange (pageIndex) {
      this.cusBasePage = pageIndex
      this.getCusBaseSet()
    },
    cusBasePageSizeChange (pageSize) {
      this.cusBaseRows = pageSize
      this.cusBasePage = 1
      this.getCusBaseSet()
    },
    cusBaseRefresh () {
      this.cusBasePage = 1
      this.getCusBaseSet()
    },
    changeCusBaseColumns () {
      this.cusBaseColumns = []
      this.cusBaseColumnsChecked.forEach(col => this.cusBaseColumns.push(this.cusBaseColumnsNexus[col]))
    },
    cleanCusBaseColumns () {
      this.cusBaseColumnsChecked = [
        'cusBaseId'
      ]
      this.cusBaseColumns = []
      this.cusBaseColumnsChecked.forEach(col => this.cusBaseColumns.push(this.cusBaseColumnsNexus[col]))
    },
    resetCusBaseColumns () {
      this.cusBaseColumnsChecked = [
        'cusBaseId',
        'customNo',
        'companyName',
        'creditCode',
        'address',
        'legalRep',
        'legalPhone',
        'legalFax',
        'openingBank',
        'bankAccount',
        'regNumber',
        'conPhone',
        'zipcode',
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
      this.cusBaseColumns = []
      this.cusBaseColumnsChecked.forEach(col => this.cusBaseColumns.push(this.cusBaseColumnsNexus[col]))
    }
  },
  mounted () {
    this.getCusBaseSet()
  }
}
</script>

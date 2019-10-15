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
                    <FormItem label="传真：" prop="fax">
                      <Input v-model="cusBaseQuery.fax" placeholder="输入传真"></Input>
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
                    <FormItem label="客户所属区域：" prop="cusRegion">
                      <Input v-model="CusBaseInfo.cusRegion" placeholder="输入客户所属区域"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="客户省份：" prop="cusProvince">
                      <Input v-model="CusBaseInfo.cusProvince" placeholder="输入客户省份"></Input>
                    </FormItem>
                  </Col>
                  <Col span="8">
                    <FormItem label="描述：" prop="remark">
                      <Input v-model="cusBaseQuery.remark" placeholder="输入描述"></Input>
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
          <Button class="pro-float-right pro-margin-right-8" icon="md-refresh" @click="cusBaseRefresh()">刷新</Button>
        </Col>
      </Row>
      <Button class="pro-list-button" type="primary" icon="ios-add-circle-outline" ghost @click="addCusBase()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="upCusBase()" v-if="cusBaseSelectRowLength === 1">编辑</Button>
      <Poptip class="pro-list-button" title="确认删除？" placement="bottom" confirm @on-ok="delCusBase()" v-if="cusBaseSelectRowLength > 0">
        <Button type="error" icon="ios-backspace-outline" ghost>删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detailCusBase()" v-if="cusBaseSelectRowLength === 1">详情</Button>
      <Button class="pro-list-button" icon="ios-cloud-upload-outline" @click="uploaExcel()">导入</Button>
      <Button class="pro-list-button" icon="ios-cloud-download-outline" @click="exportExcel()">导出</Button>
      <Poptip class="pro-margin-top-12 pro-float-right" v-model="cusBaseColumnsAccord" placement="left-start" width="280">
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
                <Checkbox class="pro-margin-left-2" label="fax">传真</Checkbox>
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
                <Checkbox class="pro-margin-left-2" label="cusRegion">客户所属区域</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="cusProvince">客户省份</Checkbox>
              </Col>
              <Col span="24">
                <Checkbox class="pro-margin-left-2" label="remark">描述</Checkbox>
              </Col>
            </Row>
          </CheckboxGroup>
          <Divider />
          <Button class="pro-margin-left-2 pro-margin-bottom-12" @click="cleanCusBaseColumns()">清空</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="resetCusBaseColumns()">重置</Button>
          <Button class="pro-margin-left-8 pro-margin-bottom-12" @click="saveCusBaseColumns()">保存样式</Button>
        </div>
      </Poptip>
      <Table :columns="cusBaseColumns" border :data="cusBaseSet" @on-selection-change="setCusBaseSelectRow($event)" @on-row-dblclick="dblclickDetailCusBase($event)"></Table>
      <Row class="pro-margin-top-10" type="flex" justify="center">
        <Page size="small" placement="top" show-total show-sizer show-elevator :total="cusBaseCount" :current="cusBasePage" :page-size="50" :page-size-opts="[50, 100, 500, 1000, 5000]" @on-change="cusBasePageIndexChange($event)" @on-page-size-change="cusBasePageSizeChange($event)" v-if="cusBasePageShow" />
        <Button class="pro-float-right pro-margin-left-8" icon="md-refresh" @click="cusBaseRefresh()">刷新</Button>
      </Row>
      <Spin size="large" fix v-if="cusBaseSpinShow"></Spin>
    </Card>
    <Modal fullscreen v-model="customerUploadDile" @on-ok="submitUpload" @on-cancel="cancelUpload" title="上传文件">
      <Upload action="" :before-upload="handleBeforeUpload" accept=".xls, .xlsx">
        <Button icon="ios-cloud-upload-outline" @click="handleSelectFile">选择文件</Button>
      </Upload>
      <tables ref="tables" border editable v-model="uploadTableData" :columns="uploadTableTitle" @on-delete="handleDelete"/>
    </Modal>
    <Modal fullscreen v-model="cusBaseEditModalShow" :mask-closable="false" :footer-hide="true">
        <Card style="background: #f3f3f3;">
          <p slot="title">
            <Icon type="ios-brush-outline"></Icon>
            编辑客户基础信息
          </p>
          <Form class="pro-margin-top-20" ref="cusBaseForm" :model="cusBase" :rules="cusBaseFormValidate" :label-width="120">
            <Row type="flex" justify="center">
              <Card style="width: 95%;">
                <p slot="title">开票信息</p>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="单位名称：" prop="companyName">
                    <Input v-model="cusBase.companyName" placeholder="输入单位名称"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="社会统一信用代码：" prop="creditCode">
                    <Input v-model="cusBase.creditCode" placeholder="输入社会统一信用代码"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="地址：" prop="address">
                    <Input v-model="cusBase.address" placeholder="输入地址"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="开户银行：" prop="openingBank">
                    <Input v-model="cusBase.openingBank" placeholder="输入开户银行"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="银行账号：" prop="bankAccount">
                    <Input v-model="cusBase.bankAccount" placeholder="输入银行账号"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="联系电话：" prop="conPhone">
                    <Input v-model="cusBase.conPhone" placeholder="输入联系电话"></Input>
                  </FormItem>
                </Col>
              </Card>
              <Card style="margin-top: 20px;width: 95%;">
                <p slot="title">基本信息</p>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="客户编码：" prop="customNo">
                    <Input v-model="cusBase.customNo" placeholder="自动生成" disabled></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="重点客户：" prop="isKey">
                    <RadioGroup v-model="CusBaseInfo.isKey" size="large" style="margin-top: -2px;">
                      <Radio label="1">
                          <span>是</span>
                      </Radio>
                      <Radio label="0">
                          <span>否</span>
                      </Radio>
                  </RadioGroup>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="所属行业：" prop="cusIndustry">
                    <Select v-model="CusBaseInfo.cusIndustry" :on-open-change="getIndustry()">
                      <Option v-for="item in CusBaseInfo.cusIndustry" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="企业性质：" prop="cusComnature">
                    <Select v-model="CusBaseInfo.cusComnature">
                      <Option v-for="item in CusBaseInfo.cusComnature" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="客户所属区域：" prop="cusRegion">
                    <Select v-model="CusBaseInfo.cusRegion">
                      <Option v-for="item in CusBaseInfo.cusRegion" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="客户省份：" prop="cusProvince">
                    <Select v-model="CusBaseInfo.cusProvince">
                      <Option v-for="item in CusBaseInfo.cusProvince" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="客户分类：" prop="cusType">
                    <Select v-model="CusBaseInfo.cusType">
                      <Option v-for="item in CusBaseInfo.cusType" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="法定代表人：" prop="legalRep">
                    <Input v-model="cusBase.legalRep" placeholder="输入法定代表人"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="法定代表人电话：" prop="legalPhone">
                    <Input v-model="cusBase.legalPhone" placeholder="输入法定代表人电话"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="法定代表人传真：" prop="legalFax">
                    <Input v-model="cusBase.legalFax" placeholder="输入法定代表人传真"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="公司传真：" prop="fax">
                    <Input v-model="cusBase.fax" placeholder="输入公司传真"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="邮政编码：" prop="zipcode">
                    <Input v-model="cusBase.zipcode" placeholder="输入邮政编码"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="交易类型：" prop="tranType">
                    <Select v-model="CusBaseInfo.tranType">
                      <Option v-for="item in CusBaseInfo.tranType" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="8">
                  <FormItem label="上级客户：" prop="cusParent">
                    <Input v-model="cusBase.cusParent" placeholder="输入上级客户"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="12" :lg="24">
                  <FormItem label="客户标签：" prop="cusTagId">
                    <Select v-model="CusTag.cusTagId" multiple >
                        <Option v-for="item in CusTag.cusTagId" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="24" :lg="24">
                  <FormItem label="备注：" prop="remark">
                    <Input v-model="cusBase.remark" type="textarea" placeholder="输入备注"></Input>
                  </FormItem>
                </Col>
                <Col :xs="24" :sm="20" :md="18" :lg="24">
                  <FormItem label="附件" prop="remark">
                    <Upload multiple :before-upload="beforeUpload" action="//jsonplaceholder.typicode.com/posts/">
                        <Button icon="ios-cloud-upload-outline">上传附件</Button>
                    </Upload>
                    <Table></Table>
                  </FormItem>
                </Col>
              </Card>
              <Card style="margin-top: 20px;width: 95%;">
                <p slot="title">委托信息</p>
                <Table :data="entrustInfoData" :columns="entrustInfoColumns">
                    <template slot-scope="{ row, index }" slot="aePer">
                        <Input type="text" v-model="aePer" v-if="editIndex === index" />
                        <span v-else>{{ row.aePer }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeFax">
                        <Input type="text" v-model="aeFax" v-if="editIndex === index" />
                        <span v-else>{{ row.aeFax }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aePhone">
                        <Input type="text" v-model="aePhone" v-if="editIndex === index" />
                        <span v-else>{{ row.aePhone }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeMatter">
                        <Input type="text" v-model="aeMatter" v-if="editIndex === index" />
                        <span v-else>{{ row.aeMatter }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeDate">
                        <DatePicker transfer v-model="aeDate" type="date" style="width: 200px" v-if="editIndex === index"></DatePicker>
                        <span v-else>{{ row.aeDate }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeEdate">
                        <DatePicker transfer v-model="aeEdate" type="date" style="width: 200px" v-if="editIndex === index"></DatePicker>
                        <span v-else>{{ row.aeEdate }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="oprate">
                        <div v-if="editIndex === index">
                            <Button @click="handleSave(index)" type="success" ghost size="small">
                                <template v-if="!addNew">保存</template>
                                <template v-else>添加</template>
                            </Button>
                            <Button @click="handleCancel" v-if="!addNew" :disabled="addNew" type="primary" ghost size="small" class="ivu-ml">取消</Button>
                            <Button @click="handleDelete(index)" v-else type="error" ghost size="small" class="ivu-ml">删除</Button>
                        </div>
                        <div v-else>
                            <Button @click="handleEdit(row, index)" :disabled="addNew" type="primary" ghost size="small">编辑</Button>
                            <Poptip
                                confirm
                                transfer
                                title="是否要删除此行？"
                                @on-ok="handleDelete(index)">
                                <Button :disabled="addNew" type="error" ghost size="small" class="ivu-ml">删除</Button>
                            </Poptip>
                        </div>
                    </template>
                </Table>
                <Button :disabled="addNew" type="dashed" long icon="md-add" class="ivu-mt" @click="addEntrust">新增</Button>
                <div>
                  <Button @click="exportEntrustInfo()" type="dashed" class="ivu-ml" size="small" icon='ios-cloud-download-outline'></Button>
                  <Page :total="entrustInfoData.length" size="small" show-elevator show-sizer style="float: left;" />
                </div>
              </Card>
              <Card style="margin-top: 20px; width: 95%;">
                <p slot="title">收货地址</p>
                <Table :data="addressData" :columns="addressDataColumns">
                    <template slot-scope="{ row, index }" slot="addressDataRow">
                        <Input type="text" v-model="addressDataRow" v-if="editIndex === index" />
                        <span v-else>{{ row.addressDataRow }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="oprate">
                        <div v-if="editIndex === index">
                            <Button @click="addressSave(index)" type="success" ghost size="small">
                                <template v-if="!addNew">保存</template>
                                <template v-else>添加</template>
                            </Button>
                            <Button @click="handleCancel" v-if="!addNew" :disabled="addNew" type="primary" ghost size="small" class="ivu-ml">取消</Button>
                            <Button @click="addressDelete(index)" v-else type="error" ghost size="small" class="ivu-ml">删除</Button>
                        </div>
                        <div v-else>
                            <Button @click="addressEdit(row, index)" :disabled="addNew" type="primary" ghost size="small">编辑</Button>
                            <Poptip
                                confirm
                                transfer
                                title="是否要删除此行？"
                                @on-ok="addresseDelete(index)">
                                <Button :disabled="addNew" type="error" ghost size="small" class="ivu-ml">删除</Button>
                            </Poptip>
                        </div>
                    </template>
                </Table>
                <Button :disabled="addNew" type="dashed" long icon="md-add" class="ivu-mt" @click="addAddress">新增</Button>
                <div>
                  <Button @click="exportAddress()" type="dashed" class="ivu-ml" size="small" icon='ios-cloud-download-outline'></Button>
                  <Page :total="addressData.length" size="small" show-elevator show-sizer style="float: left;" />
                </div>
              </Card>
              <Card style="margin-top: 20px;width: 95%;">
                <p slot="title">到站专线</p>
                <Table :data="stationLineData" :columns="stationLineColumns">
                    <template slot-scope="{ row, index }" slot="arriveStation">
                        <Input type="text" v-model="arriveStation" v-if="editIndex === index" />
                        <span v-else>{{ row.arriveStation }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="specialLine">
                        <Input type="text" v-model="specialLine" v-if="editIndex === index" />
                        <span v-else>{{ row.specialLine }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="oprate">
                        <div v-if="editIndex === index">
                            <Button @click="arriveLineSave(index)" type="success" ghost size="small">
                                <template v-if="!addNew">保存</template>
                                <template v-else>添加</template>
                            </Button>
                            <Button @click="arriveLineCancel" v-if="!addNew" :disabled="addNew" type="primary" ghost size="small" class="ivu-ml">取消</Button>
                            <Button @click="arriveLineDelete(index)" v-else type="error" ghost size="small" class="ivu-ml">删除</Button>
                        </div>
                        <div v-else>
                            <Button @click="arriveLineEdit(row, index)" :disabled="addNew" type="primary" ghost size="small">编辑</Button>
                            <Poptip
                                confirm
                                transfer
                                title="是否要删除此行？"
                                @on-ok="arriveLineDelete(index)">
                                <Button :disabled="addNew" type="error" ghost size="small" class="ivu-ml">删除</Button>
                            </Poptip>
                        </div>
                    </template>
                </Table>
                <Button :disabled="addNew" type="dashed" long icon="md-add" class="ivu-mt" @click="addLine">新增</Button>
                <div>
                  <Button @click="exportStationLine()" type="dashed" class="ivu-ml" size="small" icon='ios-cloud-download-outline'></Button>
                  <Page :total="stationLineData.length" size="small" show-elevator show-sizer style="float: left;" />
                </div>
              </Card>
              <Col :xs="24" :sm="20" :md="18" :lg="24">
                  <FormItem style="float: right; margin-top: 20px;">
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
    <Modal fullscreen v-model="cusBaseDetailDrawerShow" :closable="false">
      <Card>
        <p slot="title">
          <Icon type="md-bulb"></Icon>
          客户基础信息详情
        </p>
        <Row type="flex" justify="center">
          <Card style="width: 95%;">
            <p slot="title">开票信息</p>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>单位名称：{{ cusBase.companyName }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>社会统一信用代码：{{ cusBase.creditCode }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>地址：{{ cusBase.address }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>联系电话：{{ cusBase.conPhone }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>开户银行：{{ cusBase.openingBank }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>银行账号：{{ cusBase.bankAccount }}</p>
              <Divider dashed />
            </Col>
          </Card>
          <Card style="width: 95%; margin-top: 20px;">
            <p slot="title">基本信息</p>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>客户编码：{{ cusBase.customNo }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>重点客户：{{ cusBase.isKey }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>所属行业：{{ CusBaseInfo.cusIndustry }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>企业性质：{{ CusBaseInfo.cusComnature }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>所属区域：{{ CusBaseInfo.cusRegion }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>客户省份：{{ CusBaseInfo.cusProvince }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>客户分类：{{ CusBaseInfo.cusType }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>法定代表人：{{ cusBase.legalRep }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>法定代表人电话：{{ cusBase.legalPhone }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>法定代表人传真：{{ cusBase.legalFax }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="20" :md="12" :lg="8">
              <p>传真：{{ cusBase.fax }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>邮政编码：{{ cusBase.zipcode }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>交易类型：{{ CusBaseInfo.tranType }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>上级客户：{{ cusBase.cusParent }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>客户标签：{{ CusTag.tagName }}</p>
              <Divider dashed />
            </Col>
            <Col :xs="24" :sm="24" :md="24" :lg="8">
              <p>备注：{{ cusBase.remark }}</p>
              <Divider dashed />
            </Col>
          </Card>
          <Card style="width: 95%; margin-top: 20px;">
            <p slot="title">委托信息</p>
            <Table :data="entrustInfoData" :columns="entrustInfoColumns">
                    <template slot-scope="{ row, index }" slot="aePer">
                        <Input type="text" v-model="aePer" v-if="editIndex === index" />
                        <span v-else>{{ row.aePer }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeFax">
                        <Input type="text" v-model="aeFax" v-if="editIndex === index" />
                        <span v-else>{{ row.aeFax }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aePhone">
                        <Input type="text" v-model="aePhone" v-if="editIndex === index" />
                        <span v-else>{{ row.aePhone }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeMatter">
                        <Input type="text" v-model="aeMatter" v-if="editIndex === index" />
                        <span v-else>{{ row.aeMatter }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeDate">
                        <DatePicker transfer v-model="aeDate" type="date" style="width: 200px" v-if="editIndex === index"></DatePicker>
                        <span v-else>{{ row.aeDate }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="aeEdate">
                        <DatePicker transfer v-model="aeEdate" type="date" style="width: 200px" v-if="editIndex === index"></DatePicker>
                        <span v-else>{{ row.aeEdate }}</span>
                    </template>
                    <template slot-scope="{ row, index }" slot="oprate">
                        <div v-if="editIndex === index">
                            <Button @click="handleSave(index)" type="success" ghost size="small">
                                <template v-if="!addNew">保存</template>
                                <template v-else>添加</template>
                            </Button>
                            <Button @click="handleCancel" v-if="!addNew" :disabled="addNew" type="primary" ghost size="small" class="ivu-ml">取消</Button>
                            <Button @click="handleDelete(index)" v-else type="error" ghost size="small" class="ivu-ml">删除</Button>
                        </div>
                        <div v-else>
                            <Button @click="handleEdit(row, index)" :disabled="addNew" type="primary" ghost size="small">编辑</Button>
                            <Poptip
                                confirm
                                transfer
                                title="是否要删除此行？"
                                @on-ok="handleDelete(index)">
                                <Button :disabled="addNew" type="error" ghost size="small" class="ivu-ml">删除</Button>
                            </Poptip>
                        </div>
                    </template>
                </Table>
                <Button :disabled="addNew" type="dashed" long icon="md-add" class="ivu-mt" @click="addEntrust">新增</Button>
                <div>
                  <Button @click="exportEntrustInfo()" type="dashed" class="ivu-ml" size="small" icon='ios-cloud-download-outline'></Button>
                  <Page :total="entrustInfoData.length" size="small" show-elevator show-sizer style="float: left;" />
                </div>
          </Card>
          <Card style="margin-top: 20px; width: 95%;">
            <p slot="title">收货地址</p>
            <Table :data="addressData" :columns="addressDataColumns">
                <template slot-scope="{ row, index }" slot="addressDataRow">
                    <Input type="text" v-model="addressDataRow" v-if="editIndex === index" />
                    <span v-else>{{ row.addressDataRow }}</span>
                </template>
                <template slot-scope="{ row, index }" slot="oprate">
                    <div v-if="editIndex === index">
                        <Button @click="addressSave(index)" type="success" ghost size="small">
                            <template v-if="!addNew">保存</template>
                            <template v-else>添加</template>
                        </Button>
                        <Button @click="handleCancel" v-if="!addNew" :disabled="addNew" type="primary" ghost size="small" class="ivu-ml">取消</Button>
                        <Button @click="addressDelete(index)" v-else type="error" ghost size="small" class="ivu-ml">删除</Button>
                    </div>
                    <div v-else>
                        <Button @click="addressEdit(row, index)" :disabled="addNew" type="primary" ghost size="small">编辑</Button>
                        <Poptip
                            confirm
                            transfer
                            title="是否要删除此行？"
                            @on-ok="addresseDelete(index)">
                            <Button :disabled="addNew" type="error" ghost size="small" class="ivu-ml">删除</Button>
                        </Poptip>
                    </div>
                </template>
            </Table>
            <Button :disabled="addNew" type="dashed" long icon="md-add" class="ivu-mt" @click="addAddress">新增</Button>
            <div>
              <Button @click="exportAddress()" type="dashed" class="ivu-ml" size="small" icon='ios-cloud-download-outline'></Button>
              <Page :total="addressData.length" size="small" show-elevator show-sizer style="float: left;" />
            </div>
          </Card>
          <Card style="margin-top: 20px;width: 95%;">
            <p slot="title">到站专线</p>
            <Table :data="stationLineData" :columns="stationLineColumns">
                <template slot-scope="{ row, index }" slot="arriveStation">
                    <Input type="text" v-model="arriveStation" v-if="editIndex === index" />
                    <span v-else>{{ row.arriveStation }}</span>
                </template>
                <template slot-scope="{ row, index }" slot="specialLine">
                    <Input type="text" v-model="specialLine" v-if="editIndex === index" />
                    <span v-else>{{ row.specialLine }}</span>
                </template>
                <template slot-scope="{ row, index }" slot="oprate">
                    <div v-if="editIndex === index">
                        <Button @click="arriveLineSave(index)" type="success" ghost size="small">
                            <template v-if="!addNew">保存</template>
                            <template v-else>添加</template>
                        </Button>
                        <Button @click="arriveLineCancel" v-if="!addNew" :disabled="addNew" type="primary" ghost size="small" class="ivu-ml">取消</Button>
                        <Button @click="arriveLineDelete(index)" v-else type="error" ghost size="small" class="ivu-ml">删除</Button>
                    </div>
                    <div v-else>
                        <Button @click="arriveLineEdit(row, index)" :disabled="addNew" type="primary" ghost size="small">编辑</Button>
                        <Poptip
                            confirm
                            transfer
                            title="是否要删除此行？"
                            @on-ok="arriveLineDelete(index)">
                            <Button :disabled="addNew" type="error" ghost size="small" class="ivu-ml">删除</Button>
                        </Poptip>
                    </div>
                </template>
            </Table>
            <Button :disabled="addNew" type="dashed" long icon="md-add" class="ivu-mt" @click="addLine">新增</Button>
            <div>
              <Button @click="exportStationLine()" type="dashed" class="ivu-ml" size="small" icon='ios-cloud-download-outline'></Button>
              <Page :total="stationLineData.length" size="small" show-elevator show-sizer style="float: left;" />
            </div>
          </Card>
        </Row>
      </Card>
    </Modal>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import CusBase from '@/view/com/drzyl/cus/cusBase/CusBase'
import CusBaseInfo from '@/view/com/drzyl/cus/cusBaseInfo/CusBaseInfo'
import CusBaseQuery from '@/view/com/drzyl/cus/cusBase/CusBaseQuery'
import DictQuery from '@/view/com/drzyl/dict/dict/DictQuery'
import CusBaseInfoQuery from '@/view/com/drzyl/cus/cusBaseInfo/CusBaseInfoQuery'
import CusTag from '@/view/com/drzyl/cus/cusTag/CusTag'
import CusAgent from '@/view/com/drzyl/cus/cusAgent/CusAgent'
import Tables from '@/components/tables/tables'
import excel from '@/libs/excel'
// import TableCss from '@view/com/drzyl/table/css/tableCss/TableCss'
import util from '@/libs/util';

export default {
  components: {
    Tables
  },
  data () {
    return {
      cusBaseColumns: [
        { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        { title: '客户编码', key: 'customNo',resizable: true, width: 200, sortable: true },
        { title: '单位名称', key: 'companyName',resizable: true, width: 200, sortable: true },
        { title: '社会统一信用代码', key: 'creditCode',resizable: true, width: 200, sortable: true },
        { title: '地址', key: 'address', width: 200,resizable: true, sortable: true },
        { title: '传真', key: 'fax', width: 200,resizable: true, sortable: true },
        { title: '法定代表人', key: 'legalRep', width: 200,resizable: true, sortable: true },
        { title: '法定代表人电话', key: 'legalPhone', width: 200,resizable: true, sortable: true },
        { title: '法定代表人传真', key: 'legalFax', width: 200,resizable: true, sortable: true },
        { title: '开户银行', key: 'openingBank', width: 200,resizable: true, sortable: true },
        { title: '银行账号', key: 'bankAccount', width: 200,resizable: true, sortable: true },
        { title: '纳税登记号', key: 'regNumber', width: 200,resizable: true, sortable: true },
        { title: '联系电话', key: 'conPhone', width: 200,resizable: true, sortable: true },
        { title: '邮政编码', key: 'zipcode', width: 200,resizable: true, sortable: true },
        { title: '客户所属区域', key: 'cusRegion', width: 200,resizable: true, sortable: true },
        { title: '客户省份', key: 'cusProvince', width: 200,resizable: true, sortable: true },
        { title: '描述', key: 'remark', width: 200,resizable: true, sortable: true }
      ],
      cusBaseFormValidate: {
        createId: [
          { required: true, message: '创建人账号不能为空', trigger: 'blur' }
        ]
      },
      cusBaseColumnsAccord: false,
      cusBaseColumnsChecked: [
        'cusBaseId',
        'customNo',
        'companyName',
        'creditCode',
        'address',
        'fax',
        'legalRep',
        'legalPhone',
        'legalFax',
        'openingBank',
        'bankAccount',
        'regNumber',
        'conPhone',
        'zipcode',
        'cusRegion',
        'cusProvince',
        'remark'
      ],
      cusBaseColumnsNexus: {
        cusBaseId: { type: 'selection', width: 55, align: 'center', fixed: 'left' },
        customNo: { title: '客户编码', key: 'customNo',resizable: true, width: 200, sortable: true },
        companyName: { title: '单位名称', key: 'companyName',resizable: true, width: 200, sortable: true },
        creditCode: { title: '社会统一信用代码', key: 'creditCode',resizable: true, width: 200, sortable: true },
        address: { title: '地址', key: 'address',resizable: true, width: 200, sortable: true },
        fax: { title: '传真', key: 'fax',resizable: true, width: 200, sortable: true },
        legalRep: { title: '法定代表人', key: 'legalRep',resizable: true, width: 200, sortable: true },
        legalPhone: { title: '法定代表人电话', key: 'legalPhone',resizable: true, width: 200, sortable: true },
        legalFax: { title: '法定代表人传真', key: 'legalFax',resizable: true, width: 200, sortable: true },
        openingBank: { title: '开户银行', key: 'openingBank',resizable: true, width: 200, sortable: true },
        bankAccount: { title: '银行账号', key: 'bankAccount',resizable: true, width: 200, sortable: true },
        regNumber: { title: '纳税登记号', key: 'regNumber',resizable: true, width: 200, sortable: true },
        conPhone: { title: '联系电话', key: 'conPhone',resizable: true, width: 200, sortable: true },
        zipcode: { title: '邮政编码', key: 'zipcode',resizable: true, width: 200, sortable: true },
        cusRegion: { title: '客户所属区域', key: 'cusRegion',resizable: true, width: 200, sortable: true },
        cusProvince: { title: '客户省份', key: 'cusProvince',resizable: true, width: 200, sortable: true },
        remark: { title: '描述', key: 'remark',resizable: true, width: 200, sortable: true }
      },
      // uploadTableTitle: [
      //   { title: '客户编码', slot: 'customNo', minWidth: 200 },
      //   { title: '单位名称', slot: 'companyName', minWidth: 200 },
      //   { title: '社会统一信用代码', slot: 'creditCode', minWidth: 200 },
      //   { title: '地址', slot: 'address', minWidth: 200 },
      //   { title: '传真', slot: 'fax', minWidth: 200 },
      //   { title: '法定代表人', slot: 'legalRep', minWidth: 200 },
      //   { title: '法定代表人电话', slot: 'legalPhone', minWidth: 200 },
      //   { title: '法定代表人传真', slot: 'legalFax', minWidth: 200 },
      //   { title: '开户银行', slot: 'openingBank', minWidth: 200 },
      //   { title: '银行账号', slot: 'bankAccount', minWidth: 200 },
      //   { title: '纳税登记号', slot: 'regNumber', minWidth: 200 },
      //   { title: '联系电话', slot: 'conPhone', minWidth: 200 },
      //   { title: '邮政编码', slot: 'zipcode', minWidth: 200 },
      //   { title: '客户所属区域', slot: 'cusRegion', minWidth: 200 },
      //   { title: '客户省份', slot: 'cusProvince', minWidth: 200 },
      //   { title: '描述', slot: 'remark', minWidth: 200 }
      // ],
      entrustInfoColumns: [
        { title: '委托代理人', slot: 'aePer', minWidth: 200 },
        { title: '委托代理人传真', slot: 'aeFax', minWidth: 200 },
        { title: '委托代理人电话', slot: 'aePhone', minWidth: 200 },
        { title: '委托事项', slot: 'aeMatter', minWidth: 200 },
        { title: '委托开始时间', slot: 'aeDate', minWidth: 200 },
        { title: '委托结束时间', slot: 'aeEdate', minWidth: 200 },
        { title: '操作', slot: 'oprate', minWidth: 200 }
      ],
      addressDataColumns: [
        { title: '收货地址', slot: 'addressDataRow', minWidth: 200, align: 'center' },
        { title: '操作', slot: 'oprate', maxWidth: 200, align: 'center' }
      ],
      stationLineColumns: [
        { title: '到站', slot: 'arriveStation', minWidth: 200, align: 'center' },
        { title: '专线', slot: 'specialLine', minWidth: 200, align: 'center' },
        { title: '操作', slot: 'oprate', maxWidth: 200, align: 'center' }
      ],
      details: {},
      cusBaseSet: [],
      exportTitle: [],
      exportKey: [],
      entrustInfoData: [],
      addressData: [],
      stationLineData: [],
      uploadTableData: [],
      uploadTableTitle: [],
      cusBaseCount: 0,
      cusBaseRows: 50,
      cusBasePage: 1,
      cusBaseSelectRow: [],
      cusBaseSelectRowLength: 0,
      cusBase: new CusBase(),
      CusBaseInfo: new CusBaseInfo(),
      cusBaseQuery: new CusBaseQuery(),
      CusBaseInfoQuery: new CusBaseInfoQuery(),
      CusTag: new CusTag(),
      CusAgent: new CusAgent(),
      DictQuery: new DictQuery(),
      // TableCss: new TableCss(),
      addNew: false,
      editIndex: -1,// 当前聚焦的输入框的行数
      editValue: '',// 当然聚焦的输入框的输入内容，与 data 分离避免重构的闪烁
      cusBaseSpinShow: false,
      cusBasePageShow: true,
      customerUploadDile: false,
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
      'pagingQueryCusBase',
      'uploadAttach'
    ]),
    ...mapActions('dictStore', [
      'queryDict'
    ]),
    ...mapActions('dictValueStore', [
      'queryDictValue'
    ]),
    ...mapActions('tableCssStore', [
      'saveTableCss',
      'removeTableCss',
      'queryTableCss'
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
          Object.assign(this.cusBase, res.data.data[0].cusBase)
          Object.assign(this.cusBaseInfo, res.data.data[0].cusBaseInfo)
          Object.assign(this.cusAddrDis, res.data.data[0].cusAddrDis)
          Object.assign(this.cusAddress, res.data.data[0].cusAddress)
          Object.assign(this.cusAgents, res.data.data[0].cusAgents)
          Object.assign(this.cusTag, res.data.data[0].cusTags)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: result.response.statusText, duration: 6 })
      })
    },
    // 获取行业
    getIndustry () {
      // this.cusBaseSpinShow = true
      // this.cusBasePageShow = true
      let cusIndustrys = {}
      let cusIndustry = new DictQuery()
      cusIndustry.dictKey = 'CUS_INDUSTRY'
      this.queryDict(cusIndustry).then(res => {
        if (res.data.success) {
          this.queryDictValue({ dictId: res.data.data[0].dictId }).then(res => {
            if (res.data.success) {
              for (var i = 0;i <= res.data.data.length;i++) {
                if(res.data.data[i].code && res.data.data[i].displayName) {
                  cusIndustrys.value = res.data.data[i].code
                  cusIndustrys.label = res.data.data[i].displayName
                }
                console.log('cusIndustrys')
                console.log(cusIndustrys)
                // this.CusBaseInfo.cusIndustry = cusIndustrys
              }
              // console.log('this.CusBaseInfo.cusIndustry')
              // console.log(this.CusBaseInfo.cusIndustry)
            }
          })
        }
      //   if (res.data.success) {
      //     this.cusBaseSet = res.data.data
      //     this.cusBaseCount = res.data.count
      //     this.setCusBaseSelectRow([])
      //     setTimeout(() => { this.cusBaseSpinShow = false }, 700)
      //   } else {
      //     this.$Message.error({ content: res.data.msg, duration: 6 })
      //     setTimeout(() => { this.cusBaseSpinShow = false }, 700)
      //   }
      // }).catch(result => {
      //   this.$Message.error({ content: result.response.statusText, duration: 6 })
      //   setTimeout(() => { this.cusBaseSpinShow = false }, 700)
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
      let params = {
        'cusBase': this.cusBase,
        'CusBaseInfo': this.CusBaseInfo,
        'CusAgents': this.CusAgent,
        'cusAddrDis': this.cusAddrDis,
        'cusAddress': this.cusAddress
      }
      this.cusBaseSubmitting = true
      this.$refs.cusBaseForm.validate((valid) => {
        if (valid) {
          if (this.cusBase.cusBaseId) {
            this.updateCusBase(params).then(res => {
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
            this.saveCusBase(params).then(res => {
              // console.log('res')
              // console.log(res)
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
          Object.assign(this.cusBase, res.data.data[0].cusBase)
          Object.assign(this.cusBaseInfo, res.data.data[0].cusBaseInfo)
          Object.assign(this.cusAddrDis, res.data.data[0].cusAddrDis)
          Object.assign(this.cusAddress, res.data.data[0].cusAddress)
          Object.assign(this.cusAgents, res.data.data[0].cusAgents)
          Object.assign(this.cusTag, res.data.data[0].cusTags)
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
        cusBaseQueryKeySearch.faxOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.legalRepOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.legalPhoneOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.legalFaxOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.openingBankOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.bankAccountOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.regNumberOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.conPhoneOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.zipcodeOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.cusRegionOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.cusProvinceOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.actProcessInstanceIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.actProcessStatusOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.remarkOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.createIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.createNameOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.createOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.modifyIdOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.modifyNameOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.modifyOrgOrKeyLike = '%' + keyLikeValue + '%'
        cusBaseQueryKeySearch.delFiagOrKeyLike = '%' + keyLikeValue + '%'
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
        'fax',
        'legalRep',
        'legalPhone',
        'legalFax',
        'openingBank',
        'bankAccount',
        'regNumber',
        'conPhone',
        'zipcode',
        'cusRegion',
        'cusProvince',
        'remark'
      ]
      this.cusBaseColumns = []
      this.cusBaseColumnsChecked.forEach(col => this.cusBaseColumns.push(this.cusBaseColumnsNexus[col]))
    },
    // 保存样式
    saveCusBaseColumns () {
      let delparams = {}
      delparams.createId = util.cookies.get('uuid')
      delparams.tableKey = 'cusBaseColumns'
      this.removeTableCss(delparams).then(res => {
        if (res.data.success) {
          let params = {}
          params.createId = util.cookies.get('uuid')
          params.tableKey = 'cusBaseColumns'
          params.context = JSON.stringify(this.cusBaseColumns)
          this.saveTableCss(params).then(res => {
            if (res.data.success) {
              this.cusBaseColumnsAccord = false
              this.$Message.success({ content: '页面表格样式信息保存成功.', duration: 3 })
            } else {
              this.$Message.error({ content: res.data.msg, duration: 6 })
            }
          })
        }
      })
    },
    // 委托信息
    handleSave (index) {
      if (!this.aePer || !this.aeFax || !this.aePhone || !this.aeMatter || !this.aeDate || !this.aeEdate) {
          this.$Message.error('请填写完整的信息！');
          return;
      }
      this.entrustInfoData[index].aePer = this.aePer
      this.entrustInfoData[index].aeFax = this.aeFax
      this.entrustInfoData[index].aePhone = this.aePhone
      this.entrustInfoData[index].aeMatter = this.aeMatter
      this.entrustInfoData[index].aeDate = this.aeDate
      this.entrustInfoData[index].aeEdate = this.aeEdate
      this.editIndex = -1;
      this.addNew = false;
      this.CusAgent = this.entrustInfoData
    },
    handleCancel () {
        this.editIndex = -1;
        this.addNew = false;
    },
    handleDelete (index) {
        this.entrustInfoData.splice(index, 1);
        this.addNew = false;
    },
    addEntrust () {
        this.addNew = true;
        const row = {
            aePer: '',
            aeFax: '',
            aePhone: '',
            aeMatter: '',
            aeDate: '',
            aeEdate: ''
        };
        this.entrustInfoData.push(row);
        this.handleEdit(row, this.entrustInfoData.length - 1);
    },
    handleEdit (row, index) {
      this.aePer = row.aePer;
      this.aeFax = row.aeFax;
      this.aePhone = row.aePhone;
      this.aeMatter = row.aeMatter;
      this.aeDate = row.aeDate;
      this.aeEdate = row.aeEdate;
      this.editIndex = index;
    },
    // 收货地址
    addAddress () {
      this.addNew = true;
      const row = {
          addressDataRow: ''
      };
      this.addressData.push(row);
      this.addressEdit(row, this.addressData.length - 1);
    },
    addressEdit (row, index) {
      this.addressDataRow = row.addressDataRow;
      this.editIndex = index;
    },
    addressSave (index) {
      if (!this.addressDataRow) {
          this.$Message.error('请填写完整的信息！');
          return;
      }
      this.addressData[index].addressDataRow = this.addressDataRow
      this.editIndex = -1;
      this.addNew = false;
      this.cusAddrDis = this.addressData
    },
    addressCancel () {
        this.editIndex = -1;
        this.addNew = false;
    },
    addressDelete (index) {
        this.addressData.splice(index, 1);
        this.addNew = false;
    },
    // 到站专线
    addLine () {
      this.addNew = true;
      const row = {
          arriveStation: '',
          specialLine: ''
      };
      this.stationLineData.push(row);
      this.addressEdit(row, this.stationLineData.length - 1);
    },
    arriveLineEdit (row, index) {
      this.arriveStation = row.arriveStation;
      this.specialLine = row.specialLine;
      this.editIndex = index;
    },
    arriveLineSave (index) {
      if (!this.arriveStation || !this.specialLine) {
          this.$Message.error('请填写完整的信息！');
          return;
      }
      this.stationLineData[index].arriveStation = this.arriveStation
      this.stationLineData[index].specialLine = this.specialLine
      this.editIndex = -1;
      this.addNew = false;
      this.cusAddress = this.stationLineData
    },
    arriveLineCancel () {
        this.editIndex = -1;
        this.addNew = false;
    },
    arriveLineDelete (index) {
        this.stationLineData.splice(index, 1);
        this.addNew = false;
    },
    // 导出列表
    exportExcel () {
      for (var i = 0; i < this.cusBaseColumns.length; i++) {
        if (this.cusBaseColumns[i].title) {
          this.exportTitle.push(this.cusBaseColumns[i].title)
          this.exportKey.push(this.cusBaseColumns[i].key)
        }
      }
      if (this.cusBaseSet.length) {
        this.exportLoading = true
        const params = {
          title: this.exportTitle,
          key: this.exportKey,
          data: this.cusBaseSet,
          autoWidth: true,
          filename: '客户列表'
        }
        excel.export_array_to_excel(params)
        this.exportLoading = false
      } else {
        this.$Message.info('表格数据不能为空！')
      }
    },
    exportEntrustInfo () {
      if (this.entrustInfoData.length) {
        this.exportLoading = true
        const params = {
          title: ['委托代理人', '委托代理人传真', '委托代理人电话', '委托事项', '委托开始时间', '委托结束时间'],
          key: ['aePer', 'aeFax', 'aePhone', 'aeMatter', 'aeDate', 'aeEdate'],
          data: this.entrustInfoData,
          autoWidth: true,
          filename: '委托信息'
        }
        excel.export_array_to_excel(params)
        this.exportLoading = false
      } else {
        this.$Message.info('表格数据不能为空！')
      }
    },
    exportAddress () {
      if (this.addressData.length) {
        this.exportLoading = true
        const params = {
          title: ['收货地址'],
          key: ['addressDataRow'],
          data: this.addressData,
          autoWidth: true,
          filename: '收货地址'
        }
        excel.export_array_to_excel(params)
        this.exportLoading = false
      } else {
        this.$Message.info('表格数据不能为空！')
      }
    },
    exportStationLine () {
      if (this.stationLineData.length) {
        this.exportLoading = true
        const params = {
          title: ['到站', '专线'],
          key: ['arriveStation', 'specialLine'],
          data: this.stationLineData,
          autoWidth: true,
          filename: '到站专线'
        }
        excel.export_array_to_excel(params)
        this.exportLoading = false
      } else {
        this.$Message.info('表格数据不能为空！')
      }
    },
    // 导入列表
    uploaExcel () {
      this.customerUploadDile = true
    },
    handleSelectFile () {
      this.initUpload()
    },
    initUpload () {
      this.file = null
      this.showProgress = false
      this.loadingProgress = 0
      this.uploadTableData = []
    },
    handleBeforeUpload (file) {
      const fileExt = file.name.split('.').pop().toLocaleLowerCase()
      if (fileExt === 'xlsx' || fileExt === 'xls' || fileExt === 'csv') {
        this.readFile(file)
        this.file = file
      } else {
        this.$Notice.warning({
          title: '文件类型错误',
          desc: '文件：' + file.name + '不是EXCEL文件，请选择后缀为.xlsx或者.xls的EXCEL文件。'
        })
      }
      return false
    },
    // 读取文件
    readFile (file) {
      const reader = new FileReader()
      reader.readAsArrayBuffer(file)
      reader.onloadstart = e => {
        this.showProgress = true
      }
      reader.onprogress = e => {
        this.progressPercent = Math.round(e.loaded / e.total * 100)
      }
      reader.onerror = e => {
        this.$Message.error('文件读取出错')
      }
      reader.onload = e => {
        this.$Message.info('文件读取成功')
        const data = e.target.result
        const { header, results } = excel.read(data, 'array')
        const uploadTable = header.map(item => {
          return {
            key: item,
            title: item,
            editable: true,
            width: 300,
            render: (h, params) => {
                return h('div', [
                    h('Icon', {
                        props: {
                            type: 'person'
                        }
                    }),
                    h('strong', params.row.name)
                ]);
            }
            // render: (h, { row, index }) => {
            //   let edit;
            //   let control;
            //     // 当前行为聚焦行时
            //     if (this.editIndex === index) {
            //         edit = [h('Input', {
            //             props: {
            //                 value: row.name
            //             },
            //             on: {
            //                 input: (val) => {
            //                     this.editValue = val;
            //                 }
            //             }
            //         })];
            //         control = [
            //             h('Icon', {
            //                 style: {
            //                     cursor: 'pointer',
            //                     margin: '8px'
            //                 },
            //                 props: {
            //                     type: 'md-checkmark',
            //                     color: '#19be6b',
            //                     size: 16
            //                 },
            //                 on: {
            //                     click: () => {
            //                         // 修改 data
            //                         this.data[index].name = this.editValue;
            //                         this.editIndex = -1;
            //                     }
            //                 }
            //             }),
            //             h('Icon', {
            //                 style: {
            //                     cursor: 'pointer',
            //                     margin: '8px'
            //                 },
            //                 props: {
            //                     type: 'md-close',
            //                     color: '#ed4014',
            //                     size: 16
            //                 },
            //                 on: {
            //                     click: () => {
            //                         this.editIndex = -1;
            //                     }
            //                 }
            //             })
            //         ];
            //   } else {
            //     edit = row.name;
            //     control = [h('Icon', {
            //       style: {
            //         cursor: 'pointer'
            //       },
            //       props: {
            //         type: 'ios-create-outline',
            //         size: 16
            //       },
            //       on: {
            //         click: () => {
            //           this.editValue = row.name;
            //           this.editIndex = index;
            //         }
            //       }
            //     })];
            //   }

            //   return h('Row', [
            //       h('Col', {
            //           props: {
            //               span: 18
            //           }
            //       }, edit),
            //       h('Col', {
            //           props: {
            //               span: 6
            //           }
            //       }, control)
            //   ])
            // },
          }
        })
        uploadTable.unshift({ type: 'selection', width: 60, align: 'center', fixed: 'left' })
        console.log(results)
        console.log(uploadTable)
        this.uploadTableData = results
        this.uploadTableTitle = uploadTable
        // const arr1 = []
        // const arr2 = []
        // for (var i = 0; i < this.uploadTableData.length; i++) {
        //   arr1.push(this.uploadTableData[i])
        // }
        // for (var j = 0; j < this.uploadTableTitle.length; j++) {
        //   arr2.push(this.uploadTableTitle[j])
        // }
        // console.log('this.uploadTableTitle')
        // console.log(arr1)
        // console.log(arr2)
        // console.log(Array.from(new Set(arr1)))
        // arr1.forEach(function (item, index) {
        //   if (result.indexOf(item) === -1) {
        //     result.push(item)
        //   }
        //   return result
        // })
      }
    },
    submitUpload () {
      alert('导入成功')
      this.uploadTableData = []
      this.uploadTableTitle = []
    },
    cancelUpload () {
      this.uploadTableData = []
      this.uploadTableTitle = []
    },
    beforeUpload () {
      // this.cusBaseSpinShow = true
      // this.cusBasePageShow = true
      this.uploadAttach({ cusBaseQuery: {}, action: 'upload', muduleName: '客户列表.xlsx' }).then(res => {
        // console.log('res')
        // console.log(res)
      //   if (res.data.success) {
      //     this.cusBaseSet = res.data.data
      //     this.cusBaseCount = res.data.count
      //     this.setCusBaseSelectRow([])
      //     setTimeout(() => { this.cusBaseSpinShow = false }, 700)
      //   } else {
      //     this.$Message.error({ content: res.data.msg, duration: 6 })
      //     setTimeout(() => { this.cusBaseSpinShow = false }, 700)
      //   }
      // }).catch(result => {
      //   this.$Message.error({ content: result.response.statusText, duration: 6 })
      //   setTimeout(() => { this.cusBaseSpinShow = false }, 700)
      })
    }
  },
  mounted () {
    this.queryTableCss()
    let params = {}
    params.createId = util.cookies.get('uuid')
    params.tableKey = 'cusBaseColumns'
    this.queryTableCss(params).then(res => {
      if (res.data.success) {
        if (res.data.data.length > 0) {
          this.cusBaseColumns = JSON.parse(res.data.data[0].context)
          this.getCusBaseSet()
        } else {
          this.getCusBaseSet()
        }
      } else {
        this.getCusBaseSet()
      }
    })
  }
}
</script>

<style>
  /* .ivu-table-header thead tr th {
    position: relative;
    padding: 8px 0;
    height: 100%;
  } */
</style>
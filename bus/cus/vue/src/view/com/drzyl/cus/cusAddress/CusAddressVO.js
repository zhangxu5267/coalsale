export default class CusAddressVO {
  constructor () {
    this.cusAddressId = null // ID
    this.cusBaseId = null // 客户ID
    this.cusNo = null // 客户编码
    this.recAddress = null // 收货地址
    this.deline = null // 专线
    this.arriveStationName = null // 到站名称
    this.arriveStationNo = null // 到站编码
    this.remark = null // 备注
    this.uploadIds = null // 附件IDs
    this.actProcessInstanceId = null // 流程实例ID
    this.actProcessStatus = null // 流程状态
    this.versions = null // 版本号
    this.createId = null // 创建人账号
    this.createName = null // 创建人名称
    this.createOrg = null // 创建机构
    this.createTimes = null // 创建时间
    this.modifyId = null // 修改人账号
    this.modifyName = null // 修改人名称
    this.modifyOrg = null // 修改机构
    this.modifyTimes = null // 修改时间
    this.delFlag = null // 逻辑删除0=删除,1=显示
  }
}

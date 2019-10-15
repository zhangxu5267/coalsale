export default class CusAddressQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
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
    this.cusAddressIdAndin = null // IDAndin查询
    this.cusBaseIdAndKeyLike = null // 客户IDAndKeyLike查询
    this.cusNoOrKeyLike = null // 客户编码OrKeyLike查询
    this.recAddressOrKeyLike = null // 收货地址OrKeyLike查询
    this.delineOrKeyLike = null // 专线OrKeyLike查询
    this.arriveStationNameOrKeyLike = null // 到站名称OrKeyLike查询
    this.arriveStationNoOrKeyLike = null // 到站编码OrKeyLike查询
    this.remarkOrKeyLike = null // 备注OrKeyLike查询
    this.uploadIdsOrKeyLike = null // 附件IDsOrKeyLike查询
    this.actProcessInstanceIdOrKeyLike = null // 流程实例IDOrKeyLike查询
    this.actProcessStatusOrKeyLike = null // 流程状态OrKeyLike查询
    this.createIdOrKeyLike = null // 创建人账号OrKeyLike查询
    this.createNameOrKeyLike = null // 创建人名称OrKeyLike查询
    this.createOrgOrKeyLike = null // 创建机构OrKeyLike查询
    this.modifyIdOrKeyLike = null // 修改人账号OrKeyLike查询
    this.modifyNameOrKeyLike = null // 修改人名称OrKeyLike查询
    this.modifyOrgOrKeyLike = null // 修改机构OrKeyLike查询
    this.delFlagOrKeyLike = null // 逻辑删除0=删除,1=显示OrKeyLike查询
  }
}

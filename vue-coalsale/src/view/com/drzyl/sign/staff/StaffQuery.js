export default class StaffQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.staffId = null // 员工编号
    this.staffNo = null // 员工工号
    this.staffName = null // 员工姓名
    this.mobilePhoneNumber = null // 手机号
    this.gender = null // 性别
    this.emergencyContactName = null // 紧急联系人姓名
    this.emergContMobilePhoneNumber = null // 紧急联系人手机号
    this.weightOrder = null // 排序权重
    this.description = null // 描述
    this.versions = null // 版本号
    this.createId = null // 创建人账号
    this.createName = null // 创建人名称
    this.createTimes = null // 创建时间
    this.modifyId = null // 修改人账号
    this.modifyName = null // 修改人名称
    this.modifyTimes = null // 修改时间
    this.staffIdAndin = null // 员工编号Andin查询
    this.staffNoAndeq = null // 员工工号Andeq查询
    this.staffNoAndKeyLike = null // 员工工号AndKeyLike查询
    this.staffNameOrKeyLike = null // 员工姓名OrKeyLike查询
    this.mobilePhoneNumberOrKeyLike = null // 手机号OrKeyLike查询
    this.genderOrKeyLike = null // 性别OrKeyLike查询
    this.emergencyContactNameOrKeyLike = null // 紧急联系人姓名OrKeyLike查询
    this.emergContMobilePhoneNumberOrKeyLike = null // 紧急联系人手机号OrKeyLike查询
    this.descriptionOrKeyLike = null // 描述OrKeyLike查询
    this.createIdOrKeyLike = null // 创建人账号OrKeyLike查询
    this.createNameOrKeyLike = null // 创建人名称OrKeyLike查询
    this.modifyIdOrKeyLike = null // 修改人账号OrKeyLike查询
    this.modifyNameOrKeyLike = null // 修改人名称OrKeyLike查询
  }
}

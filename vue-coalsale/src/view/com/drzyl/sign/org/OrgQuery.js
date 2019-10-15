export default class OrgQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.orgId = null // 组织机构编号
    this.orgName = null // 组织机构名称
    this.orgType = null // 组织机构类型
    this.idPath = null // 编号路径
    this.namePath = null // 名称路径
    this.weightOrder = null // 排序权重
    this.orgPid = null // 上级组织机构编号
    this.versions = null // 版本号
    this.createId = null // 创建人账号
    this.createName = null // 创建人名称
    this.createTimes = null // 创建时间
    this.modifyId = null // 修改人账号
    this.modifyName = null // 修改人名称
    this.modifyTimes = null // 修改时间
    this.orgIdAndin = null // 组织机构编号Andin查询
    this.orgNameAndKeyLike = null // 组织机构名称AndKeyLike查询
    this.orgTypeOrKeyLike = null // 组织机构类型OrKeyLike查询
    this.idPathOrKeyLike = null // 编号路径OrKeyLike查询
    this.namePathOrKeyLike = null // 名称路径OrKeyLike查询
    this.orgPidOrKeyLike = null // 上级组织机构编号OrKeyLike查询
    this.createIdOrKeyLike = null // 创建人账号OrKeyLike查询
    this.createNameOrKeyLike = null // 创建人名称OrKeyLike查询
    this.modifyIdOrKeyLike = null // 修改人账号OrKeyLike查询
    this.modifyNameOrKeyLike = null // 修改人名称OrKeyLike查询
  }
}

export default class ZoneAreaQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.areaId = null // 区域ID
    this.areaName = null // 父ID
    this.areaType = null // 名称
    this.status = null // 状态
    this.remark = null // 备注
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
    this.areaIdAndin = null // 区域IDAndin查询
    this.areaNameAndKeyLike = null // 父IDAndKeyLike查询
    this.areaTypeOrKeyLike = null // 名称OrKeyLike查询
    this.statusOrKeyLike = null // 状态OrKeyLike查询
    this.remarkOrKeyLike = null // 备注OrKeyLike查询
    this.createIdOrKeyLike = null // 创建人账号OrKeyLike查询
    this.createNameOrKeyLike = null // 创建人名称OrKeyLike查询
    this.createOrgOrKeyLike = null // 创建机构OrKeyLike查询
    this.modifyIdOrKeyLike = null // 修改人账号OrKeyLike查询
    this.modifyNameOrKeyLike = null // 修改人名称OrKeyLike查询
    this.modifyOrgOrKeyLike = null // 修改机构OrKeyLike查询
    this.delFlagOrKeyLike = null // 逻辑删除0=删除,1=显示OrKeyLike查询
  }
}

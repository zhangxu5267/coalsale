export default class ZoneRegionQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.regionId = null // ID
    this.parentId = null // 父ID
    this.regionName = null // 名称
    this.regionType = null // 类型
    this.agencyId = null // 代理
    this.status = null // 状态
    this.regionIdAndin = null // IDAndin查询
    this.parentIdAndKeyLike = null // 父IDAndKeyLike查询
    this.regionNameOrKeyLike = null // 名称OrKeyLike查询
    this.regionTypeOrKeyLike = null // 类型OrKeyLike查询
    this.agencyIdOrKeyLike = null // 代理OrKeyLike查询
    this.statusOrKeyLike = null // 状态OrKeyLike查询
  }
}

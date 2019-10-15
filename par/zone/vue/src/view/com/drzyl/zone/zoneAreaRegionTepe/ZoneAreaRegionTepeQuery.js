export default class ZoneAreaRegionTepeQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.id = null // ID
    this.orgId = null // 所属机构
    this.crmRegionId = null // 省市区ID
    this.crmAreaId = null // 区域ID
    this.idAndin = null // IDAndin查询
    this.orgIdAndKeyLike = null // 所属机构AndKeyLike查询
    this.crmRegionIdOrKeyLike = null // 省市区IDOrKeyLike查询
    this.crmAreaIdOrKeyLike = null // 区域IDOrKeyLike查询
  }
}

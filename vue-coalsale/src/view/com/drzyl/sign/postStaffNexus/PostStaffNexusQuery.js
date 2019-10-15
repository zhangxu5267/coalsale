export default class PostStaffNexusQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.nexusId = null // 关系编号
    this.postId = null // 岗位编号
    this.staffId = null // 员工编号
    this.defaultPost = null // 默认岗位
    this.nexusIdAndin = null // 关系编号Andin查询
    this.postIdAndeq = null // 岗位编号Andeq查询
    this.staffIdAndeq = null // 员工编号Andeq查询
    this.postIdAndKeyLike = null // 岗位编号AndKeyLike查询
    this.staffIdOrKeyLike = null // 员工编号OrKeyLike查询
    this.defaultPostOrKeyLike = null // 默认岗位OrKeyLike查询
  }
}

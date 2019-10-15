export default class RolePostNexusQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.nexusId = null // 关系编号
    this.roleId = null // 角色编号
    this.postId = null // 岗位编号
    this.nexusIdAndin = null // 关系编号Andin查询
    this.roleIdAndeq = null // 角色编号Andeq查询
    this.postIdAndeq = null // 岗位编号Andeq查询
    this.roleIdAndKeyLike = null // 角色编号AndKeyLike查询
    this.postIdOrKeyLike = null // 岗位编号OrKeyLike查询
  }
}

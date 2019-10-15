export default class PostQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.postId = null // 岗位编号
    this.postName = null // 岗位名称
    this.weightOrder = null // 排序权重
    this.orgId = null // 组织机构编号
    this.versions = null // 版本号
    this.createId = null // 创建人账号
    this.createName = null // 创建人名称
    this.createTimes = null // 创建时间
    this.modifyId = null // 修改人账号
    this.modifyName = null // 修改人名称
    this.modifyTimes = null // 修改时间
    this.postIdAndin = null // 岗位编号Andin查询
    this.postNameAndeq = null // 岗位名称Andeq查询
    this.orgIdAndeq = null // 组织机构编号Andeq查询
    this.postNameAndKeyLike = null // 岗位名称AndKeyLike查询
    this.orgIdOrKeyLike = null // 组织机构编号OrKeyLike查询
    this.createIdOrKeyLike = null // 创建人账号OrKeyLike查询
    this.createNameOrKeyLike = null // 创建人名称OrKeyLike查询
    this.modifyIdOrKeyLike = null // 修改人账号OrKeyLike查询
    this.modifyNameOrKeyLike = null // 修改人名称OrKeyLike查询
  }
}

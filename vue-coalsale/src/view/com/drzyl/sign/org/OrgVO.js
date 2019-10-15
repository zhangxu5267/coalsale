export default class OrgVO {
  constructor () {
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
  }
}

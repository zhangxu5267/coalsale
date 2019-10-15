export default class RoleVO {
  constructor () {
    this.roleId = null // 角色编号
    this.roleName = null // 角色名称
    this.roleType = null // 角色类型
    this.accessList = null // 权限列表
    this.weightOrder = null // 排序权重
    this.versions = null // 版本号
    this.createId = null // 创建人账号
    this.createName = null // 创建人名称
    this.createTimes = null // 创建时间
    this.modifyId = null // 修改人账号
    this.modifyName = null // 修改人名称
    this.modifyTimes = null // 修改时间
  }
}

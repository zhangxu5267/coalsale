export default class ZoneArea {
  constructor () {
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
  }
}

export default class CusAgent {
  constructor () {
    this.cusAgentId = null // ID
    this.cusBaseId = null // 客户ID
    this.aePer = null // 委托代理人
    this.aePhone = null // 委托代理人电话
    this.aeFax = null // 委托代理人传真
    this.aeMatter = null // 委托事项
    this.aeDate = null // 委托时间
    this.orgId = null // 机构ID
    this.aeEdate = null // 委托结束时间
    this.uploadIds = null // 附件IDs
    this.remark = null // 备注
    this.actProcessInstanceId = null // 流程实例ID
    this.actProcessStatus = null // 流程状态
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

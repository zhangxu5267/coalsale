export default class CusBaseInfo {
  constructor () {
    this.cusBaseInfoId = null // ID
    this.cusBaseId = null // 客户ID
    this.cusNo = null // 客户编码
    this.orgId = null // 所属机构
    this.isKey = null // 所属机构
    this.cusRegion = null // 客户所属区域
    this.cusProvince = null // 客户省份
    this.cusIndustry = null // 客户所属行业
    this.cusComnature = null // 客户企业性质
    this.cusType = null // 客户分类
    this.tranType = null // 交易类型
    this.cusParent = null // 上级客户
    this.cusSub = null // 下级客户
    this.fax = null // 公司传真
    this.remark = null // 备注
    this.uploadIds = null // 附件IDs
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

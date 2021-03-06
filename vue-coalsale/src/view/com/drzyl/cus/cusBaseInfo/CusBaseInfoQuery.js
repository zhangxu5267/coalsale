export default class CusBaseInfoQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
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
    this.cusBaseInfoIdAndin = null // IDAndin查询
    this.cusBaseIdAndKeyLike = null // 客户IDAndKeyLike查询
    this.cusNoOrKeyLike = null // 客户编码OrKeyLike查询
    this.orgIdOrKeyLike = null // 所属机构OrKeyLike查询
    this.isKeyOrKeyLike = null // 所属机构OrKeyLike查询
    this.cusRegionOrKeyLike = null // 客户所属区域OrKeyLike查询
    this.cusProvinceOrKeyLike = null // 客户省份OrKeyLike查询
    this.cusIndustryOrKeyLike = null // 客户所属行业OrKeyLike查询
    this.cusComnatureOrKeyLike = null // 客户企业性质OrKeyLike查询
    this.cusTypeOrKeyLike = null // 客户分类OrKeyLike查询
    this.tranTypeOrKeyLike = null // 交易类型OrKeyLike查询
    this.cusParentOrKeyLike = null // 上级客户OrKeyLike查询
    this.cusSubOrKeyLike = null // 下级客户OrKeyLike查询
    this.faxOrKeyLike = null // 公司传真OrKeyLike查询
    this.remarkOrKeyLike = null // 备注OrKeyLike查询
    this.uploadIdsOrKeyLike = null // 附件IDsOrKeyLike查询
    this.actProcessInstanceIdOrKeyLike = null // 流程实例IDOrKeyLike查询
    this.actProcessStatusOrKeyLike = null // 流程状态OrKeyLike查询
    this.createIdOrKeyLike = null // 创建人账号OrKeyLike查询
    this.createNameOrKeyLike = null // 创建人名称OrKeyLike查询
    this.createOrgOrKeyLike = null // 创建机构OrKeyLike查询
    this.modifyIdOrKeyLike = null // 修改人账号OrKeyLike查询
    this.modifyNameOrKeyLike = null // 修改人名称OrKeyLike查询
    this.modifyOrgOrKeyLike = null // 修改机构OrKeyLike查询
    this.delFlagOrKeyLike = null // 逻辑删除0=删除,1=显示OrKeyLike查询
  }
}

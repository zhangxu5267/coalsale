package com.drzyl.cus.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 客户详细信息 BUS_CUS_BASE_INFO 查询类
 */
@Data
public class CusBaseInfoQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String cusBaseInfoId; // ID

  protected String cusBaseId; // 客户ID

  protected String cusNo; // 客户编码

  protected String orgId; // 所属机构

  protected String isKey; // 所属机构

  protected String cusRegion; // 客户所属区域

  protected String cusProvince; // 客户省份

  protected String cusIndustry; // 客户所属行业

  protected String cusComnature; // 客户企业性质

  protected String cusType; // 客户分类

  protected String tranType; // 交易类型

  protected String cusParent; // 上级客户

  protected String cusSub; // 下级客户

  protected String fax; // 公司传真

  protected String remark; // 备注

  protected String uploadIds; // 附件IDs

  protected String actProcessInstanceId; // 流程实例ID

  protected String actProcessStatus; // 流程状态

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected String createOrg; // 创建机构

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected String modifyOrg; // 修改机构

  protected Long modifyTimes; // 修改时间

  protected String delFlag; // 逻辑删除0=删除,1=显示

  protected List<String> cusBaseInfoIdAndin; // IDAndin查询

  protected String cusBaseIdAndKeyLike; // 客户IDAndKeyLike查询

  protected String cusNoOrKeyLike; // 客户编码OrKeyLike查询

  protected String orgIdOrKeyLike; // 所属机构OrKeyLike查询

  protected String isKeyOrKeyLike; // 所属机构OrKeyLike查询

  protected String cusRegionOrKeyLike; // 客户所属区域OrKeyLike查询

  protected String cusProvinceOrKeyLike; // 客户省份OrKeyLike查询

  protected String cusIndustryOrKeyLike; // 客户所属行业OrKeyLike查询

  protected String cusComnatureOrKeyLike; // 客户企业性质OrKeyLike查询

  protected String cusTypeOrKeyLike; // 客户分类OrKeyLike查询

  protected String tranTypeOrKeyLike; // 交易类型OrKeyLike查询

  protected String cusParentOrKeyLike; // 上级客户OrKeyLike查询

  protected String cusSubOrKeyLike; // 下级客户OrKeyLike查询

  protected String faxOrKeyLike; // 公司传真OrKeyLike查询

  protected String remarkOrKeyLike; // 备注OrKeyLike查询

  protected String uploadIdsOrKeyLike; // 附件IDsOrKeyLike查询

  protected String actProcessInstanceIdOrKeyLike; // 流程实例IDOrKeyLike查询

  protected String actProcessStatusOrKeyLike; // 流程状态OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String createOrgOrKeyLike; // 创建机构OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

  protected String modifyOrgOrKeyLike; // 修改机构OrKeyLike查询

  protected String delFlagOrKeyLike; // 逻辑删除0=删除,1=显示OrKeyLike查询

}

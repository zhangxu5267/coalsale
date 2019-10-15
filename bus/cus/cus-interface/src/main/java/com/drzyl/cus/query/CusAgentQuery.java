package com.drzyl.cus.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 客户委托信息 BUS_CUS_AGENT 查询类
 */
@Data
public class CusAgentQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String cusAgentId; // ID

  protected String cusBaseId; // 客户ID

  protected String aePer; // 委托代理人

  protected String aePhone; // 委托代理人电话

  protected String aeFax; // 委托代理人传真

  protected String aeMatter; // 委托事项

  protected String aeDate; // 委托时间

  protected String orgId; // 机构ID

  protected String aeEdate; // 委托结束时间

  protected String uploadIds; // 附件IDs

  protected String remark; // 备注

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

  protected List<String> cusAgentIdAndin; // IDAndin查询

  protected String cusBaseIdAndKeyLike; // 客户IDAndKeyLike查询

  protected String aePerOrKeyLike; // 委托代理人OrKeyLike查询

  protected String aePhoneOrKeyLike; // 委托代理人电话OrKeyLike查询

  protected String aeFaxOrKeyLike; // 委托代理人传真OrKeyLike查询

  protected String aeMatterOrKeyLike; // 委托事项OrKeyLike查询

  protected String aeDateOrKeyLike; // 委托时间OrKeyLike查询

  protected String orgIdOrKeyLike; // 机构IDOrKeyLike查询

  protected String aeEdateOrKeyLike; // 委托结束时间OrKeyLike查询

  protected String uploadIdsOrKeyLike; // 附件IDsOrKeyLike查询

  protected String remarkOrKeyLike; // 备注OrKeyLike查询

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

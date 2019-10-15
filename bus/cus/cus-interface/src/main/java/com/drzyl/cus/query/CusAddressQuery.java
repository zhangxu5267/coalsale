package com.drzyl.cus.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 客户收货单位 BUS_CUS_ADDRESS 查询类
 */
@Data
public class CusAddressQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String cusAddressId; // ID

  protected String cusBaseId; // 客户ID

  protected String cusNo; // 客户编码

  protected String recAddress; // 收货地址

  protected String deline; // 专线

  protected String arriveStationName; // 到站名称

  protected String arriveStationNo; // 到站编码

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

  protected List<String> cusAddressIdAndin; // IDAndin查询

  protected String cusBaseIdAndKeyLike; // 客户IDAndKeyLike查询

  protected String cusNoOrKeyLike; // 客户编码OrKeyLike查询

  protected String recAddressOrKeyLike; // 收货地址OrKeyLike查询

  protected String delineOrKeyLike; // 专线OrKeyLike查询

  protected String arriveStationNameOrKeyLike; // 到站名称OrKeyLike查询

  protected String arriveStationNoOrKeyLike; // 到站编码OrKeyLike查询

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

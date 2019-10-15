package com.drzyl.zone.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 省市区 PAR_ZONE_REGION 查询类
 */
@Data
public class ZoneRegionQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String regionId; // ID

  protected String parentId; // 父ID

  protected String regionName; // 名称

  protected String regionType; // 类型

  protected String agencyId; // 代理

  protected String status; // 状态

  protected List<String> regionIdAndin; // IDAndin查询

  protected String parentIdAndKeyLike; // 父IDAndKeyLike查询

  protected String regionNameOrKeyLike; // 名称OrKeyLike查询

  protected String regionTypeOrKeyLike; // 类型OrKeyLike查询

  protected String agencyIdOrKeyLike; // 代理OrKeyLike查询

  protected String statusOrKeyLike; // 状态OrKeyLike查询

}

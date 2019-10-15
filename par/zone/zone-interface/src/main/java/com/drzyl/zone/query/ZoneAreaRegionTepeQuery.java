package com.drzyl.zone.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 区域-省市区中间表 PAR_ZONE_AREA_REGION_TEPE 查询类
 */
@Data
public class ZoneAreaRegionTepeQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String id; // ID

  protected String orgId; // 所属机构

  protected String crmRegionId; // 省市区ID

  protected String crmAreaId; // 区域ID

  protected List<String> idAndin; // IDAndin查询

  protected String orgIdAndKeyLike; // 所属机构AndKeyLike查询

  protected String crmRegionIdOrKeyLike; // 省市区IDOrKeyLike查询

  protected String crmAreaIdOrKeyLike; // 区域IDOrKeyLike查询

}

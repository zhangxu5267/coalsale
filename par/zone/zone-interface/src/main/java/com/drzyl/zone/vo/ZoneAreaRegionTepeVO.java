package com.drzyl.zone.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 区域-省市区中间表 PAR_ZONE_AREA_REGION_TEPE 展示类
 */
@Data
public class ZoneAreaRegionTepeVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id; // ID

  protected String orgId; // 所属机构

  protected String crmRegionId; // 省市区ID

  protected String crmAreaId; // 区域ID

}

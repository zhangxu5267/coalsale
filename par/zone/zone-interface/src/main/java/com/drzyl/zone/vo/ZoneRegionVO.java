package com.drzyl.zone.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 省市区 PAR_ZONE_REGION 展示类
 */
@Data
public class ZoneRegionVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String regionId; // ID

  protected String parentId; // 父ID

  protected String regionName; // 名称

  protected String regionType; // 类型

  protected String agencyId; // 代理

  protected String status; // 状态

}

package com.drzyl.zone.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 区域-省市区中间表 PAR_ZONE_AREA_REGION_TEPE 实体类
 */
@Data
@TableName(value = "PAR_ZONE_AREA_REGION_TEPE")
public class ZoneAreaRegionTepe implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String id; // ID

  protected String orgId; // 所属机构

  protected String crmRegionId; // 省市区ID

  protected String crmAreaId; // 区域ID

  public ZoneAreaRegionTepe() {
  }

  public ZoneAreaRegionTepe(String orgId, String crmRegionId, String crmAreaId) {
    this.orgId = orgId;
    this.crmRegionId = crmRegionId;
    this.crmAreaId = crmAreaId;
  }
}

package com.drzyl.zone.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 省市区 PAR_ZONE_REGION 实体类
 */
@Data
@TableName(value = "PAR_ZONE_REGION")
public class ZoneRegion implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String regionId; // ID

  protected String parentId; // 父ID

  protected String regionName; // 名称

  protected String regionType; // 类型

  protected String agencyId; // 代理

  protected String status; // 状态

}

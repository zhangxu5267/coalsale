package com.drzyl.zone.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 区域 PAR_ZONE_AREA 展示类
 */
@Data
public class ZoneAreaVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String areaId; // 区域ID

  protected String areaName; // 父ID

  protected String areaType; // 名称

  protected String status; // 状态

  protected String remark; // 备注

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

}

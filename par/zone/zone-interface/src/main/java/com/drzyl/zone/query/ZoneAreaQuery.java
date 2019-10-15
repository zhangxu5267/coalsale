package com.drzyl.zone.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 区域 PAR_ZONE_AREA 查询类
 */
@Data
public class ZoneAreaQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

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

  protected List<String> areaIdAndin; // 区域IDAndin查询

  protected String areaNameAndKeyLike; // 父IDAndKeyLike查询

  protected String areaTypeOrKeyLike; // 名称OrKeyLike查询

  protected String statusOrKeyLike; // 状态OrKeyLike查询

  protected String remarkOrKeyLike; // 备注OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String createOrgOrKeyLike; // 创建机构OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

  protected String modifyOrgOrKeyLike; // 修改机构OrKeyLike查询

  protected String delFlagOrKeyLike; // 逻辑删除0=删除,1=显示OrKeyLike查询

}

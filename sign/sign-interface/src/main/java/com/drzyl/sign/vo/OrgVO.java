package com.drzyl.sign.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 组织机构 SYS_ORG 展示类
 */
@Data
public class OrgVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String orgId; // 组织机构编号

  protected String orgName; // 组织机构名称

  protected String orgType; // 组织机构类型

  protected String idPath; // 编号路径

  protected String namePath; // 名称路径

  protected Integer weightOrder; // 排序权重

  protected String orgPid; // 上级组织机构编号

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected Long modifyTimes; // 修改时间

}

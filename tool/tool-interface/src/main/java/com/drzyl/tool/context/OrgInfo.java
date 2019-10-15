package com.drzyl.tool.context;

import lombok.Data;

import java.io.Serializable;

/**
 * 组织机构信息
 */
@Data
public class OrgInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String orgId; // 组织机构编号

  protected String orgName; // 组织机构名称

}

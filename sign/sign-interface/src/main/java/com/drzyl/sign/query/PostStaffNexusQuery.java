package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 岗位员工 SYS_POST_STAFF_NEXUS 查询类
 */
@Data
public class PostStaffNexusQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String nexusId; // 关系编号

  protected String postId; // 岗位编号

  protected String staffId; // 员工编号

  protected String defaultPost; // 默认岗位

  protected List<String> nexusIdAndin; // 关系编号Andin查询

  protected String postIdAndeq; // 岗位编号Andeq查询

  protected String staffIdAndeq; // 员工编号Andeq查询

  protected String postIdAndKeyLike; // 岗位编号AndKeyLike查询

  protected String staffIdOrKeyLike; // 员工编号OrKeyLike查询

  protected String defaultPostOrKeyLike; // 默认岗位OrKeyLike查询

}

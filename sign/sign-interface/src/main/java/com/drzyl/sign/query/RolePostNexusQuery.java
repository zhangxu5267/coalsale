package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 角色岗位 SYS_ROLE_POST_NEXUS 查询类
 */
@Data
public class RolePostNexusQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String nexusId; // 关系编号

  protected String roleId; // 角色编号

  protected String postId; // 岗位编号

  protected List<String> nexusIdAndin; // 关系编号Andin查询

  protected String roleIdAndeq; // 角色编号Andeq查询

  protected String postIdAndeq; // 岗位编号Andeq查询

  protected String roleIdAndKeyLike; // 角色编号AndKeyLike查询

  protected String postIdOrKeyLike; // 岗位编号OrKeyLike查询

}

package com.drzyl.sign.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 角色岗位 SYS_ROLE_POST_NEXUS 展示类
 */
@Data
public class RolePostNexusVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String nexusId; // 关系编号

  protected String roleId; // 角色编号

  protected String postId; // 岗位编号

}

package com.drzyl.sign.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 角色岗位 SYS_ROLE_POST_NEXUS 实体类
 */
@Data
@TableName(value = "SYS_ROLE_POST_NEXUS")
public class RolePostNexus implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String nexusId; // 关系编号

  protected String roleId; // 角色编号

  protected String postId; // 岗位编号

}

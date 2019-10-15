package com.drzyl.sign.business.param;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;

/**
 * 角色权限 参数类
 */
@Data
public class RoleAccessParam implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String roleId; // 角色编号

  protected LinkedHashSet<String> accessList; // 权限列表

}

package com.drzyl.sign.business.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;

/**
 * 角色权限 展示类
 */
@Data
public class RoleAccessVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String roleId; // 角色编号

  protected LinkedHashSet<String> accessList; // 权限列表

}

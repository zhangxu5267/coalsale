package com.drzyl.sign.business.service;

import com.drzyl.sign.business.param.RoleAccessParam;
import com.drzyl.sign.business.vo.RoleAccessVO;

/**
 * 角色权限 服务接口
 */
public interface IRoleAccessService {

  /**
   * 保存角色权限
   */
  public RoleAccessVO saveRoleAccess(RoleAccessParam roleAccessParam) throws Exception;

  /**
   * 获取角色权限
   */
  public RoleAccessVO getRoleAccess(RoleAccessParam roleAccessParam) throws Exception;

}

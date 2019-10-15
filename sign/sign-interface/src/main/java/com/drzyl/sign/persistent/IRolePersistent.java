package com.drzyl.sign.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.sign.entity.Role;
import com.drzyl.sign.query.RoleQuery;
import com.drzyl.sign.vo.RoleVO;

/**
 * 角色 持久化接口
 */
public interface IRolePersistent {

  public static final String TABLE_NAME = "SYS_ROLE";

  /**
   * 保存 角色 信息
   */
  public Role saveRole(Role role) throws Exception;

  /**
   * 批量保存 角色 信息
   */
  public Collection<Role> batchSaveRole(Collection<Role> roles) throws Exception;

  /**
   * 修改 角色 信息
   */
  public Role updateRole(Role role) throws Exception;

  /**
   * 批量修改 角色 信息
   */
  public Collection<Role> batchUpdateRole(Collection<Role> roles) throws Exception;

  /**
   * 删除 角色 信息
   */
  public void removeRole(Role role) throws Exception;

  /**
   * 批量删除 角色 信息
   */
  public void batchRemoveRole(Collection<Role> roles) throws Exception;

  /**
   * 获取 角色 数据量
   */
  public Long getCountRole(RoleQuery roleQuery) throws Exception;

  /**
   * 通过主键获取 角色 数据
   */
  public Role getRoleByPk(String roleId) throws Exception;

  /**
   * 获取 角色 所有数据
   */
  public Collection<Role> getAllRole() throws Exception;

  /**
   * 查询 角色 数据
   */
  public Collection<Role> queryRole(RoleQuery roleQuery) throws Exception;

  /**
   * 分页查询 角色 数据
   */
  public Paging<Role> pagingQueryRole(Param param, RoleQuery roleQuery) throws Exception;

  /**
   * 通过主键获取 角色 展示数据
   */
  public RoleVO getRoleVOByPk(String roleId) throws Exception;

  /**
   * 获取 角色 所有展示数据
   */
  public Collection<RoleVO> getAllRoleVO() throws Exception;

  /**
   * 查询 角色 展示数据
   */
  public Collection<RoleVO> queryRoleVO(RoleQuery roleQuery) throws Exception;

  /**
   * 分页查询 角色 展示数据
   */
  public Paging<RoleVO> pagingQueryRoleVO(Param param, RoleQuery roleQuery) throws Exception;

}

package com.drzyl.sign.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.sign.entity.RolePostNexus;
import com.drzyl.sign.query.RolePostNexusQuery;
import com.drzyl.sign.vo.RolePostNexusVO;

/**
 * 角色岗位 持久化接口
 */
public interface IRolePostNexusPersistent {

  public static final String TABLE_NAME = "SYS_ROLE_POST_NEXUS";

  /**
   * 保存 角色岗位 信息
   */
  public RolePostNexus saveRolePostNexus(RolePostNexus rolePostNexus) throws Exception;

  /**
   * 批量保存 角色岗位 信息
   */
  public Collection<RolePostNexus> batchSaveRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception;

  /**
   * 修改 角色岗位 信息
   */
  public RolePostNexus updateRolePostNexus(RolePostNexus rolePostNexus) throws Exception;

  /**
   * 批量修改 角色岗位 信息
   */
  public Collection<RolePostNexus> batchUpdateRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception;

  /**
   * 删除 角色岗位 信息
   */
  public void removeRolePostNexus(RolePostNexus rolePostNexus) throws Exception;

  /**
   * 批量删除 角色岗位 信息
   */
  public void batchRemoveRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception;

  /**
   * 获取 角色岗位 数据量
   */
  public Long getCountRolePostNexus(RolePostNexusQuery rolePostNexusQuery) throws Exception;

  /**
   * 通过主键获取 角色岗位 数据
   */
  public RolePostNexus getRolePostNexusByPk(String nexusId) throws Exception;

  /**
   * 获取 角色岗位 所有数据
   */
  public Collection<RolePostNexus> getAllRolePostNexus() throws Exception;

  /**
   * 查询 角色岗位 数据
   */
  public Collection<RolePostNexus> queryRolePostNexus(RolePostNexusQuery rolePostNexusQuery) throws Exception;

  /**
   * 分页查询 角色岗位 数据
   */
  public Paging<RolePostNexus> pagingQueryRolePostNexus(Param param, RolePostNexusQuery rolePostNexusQuery) throws Exception;

  /**
   * 通过主键获取 角色岗位 展示数据
   */
  public RolePostNexusVO getRolePostNexusVOByPk(String nexusId) throws Exception;

  /**
   * 获取 角色岗位 所有展示数据
   */
  public Collection<RolePostNexusVO> getAllRolePostNexusVO() throws Exception;

  /**
   * 查询 角色岗位 展示数据
   */
  public Collection<RolePostNexusVO> queryRolePostNexusVO(RolePostNexusQuery rolePostNexusQuery) throws Exception;

  /**
   * 分页查询 角色岗位 展示数据
   */
  public Paging<RolePostNexusVO> pagingQueryRolePostNexusVO(Param param, RolePostNexusQuery rolePostNexusQuery) throws Exception;

}

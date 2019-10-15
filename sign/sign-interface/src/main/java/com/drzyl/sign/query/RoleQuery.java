package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 角色 SYS_ROLE 查询类
 */
@Data
public class RoleQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String roleId; // 角色编号

  protected String roleName; // 角色名称

  protected String roleType; // 角色类型

  protected String accessList; // 权限列表

  protected Integer weightOrder; // 排序权重

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected Long modifyTimes; // 修改时间

  protected List<String> roleIdAndin; // 角色编号Andin查询

  protected String roleNameAndeq; // 角色名称Andeq查询

  protected String roleNameAndKeyLike; // 角色名称AndKeyLike查询

  protected String roleTypeOrKeyLike; // 角色类型OrKeyLike查询

  protected String accessListOrKeyLike; // 权限列表OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

}

package com.drzyl.sign.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 角色 SYS_ROLE 实体类
 */
@Data
@TableName(value = "SYS_ROLE")
public class Role implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
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

}

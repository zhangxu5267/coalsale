package com.drzyl.sign.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 岗位员工 SYS_POST_STAFF_NEXUS 实体类
 */
@Data
@TableName(value = "SYS_POST_STAFF_NEXUS")
public class PostStaffNexus implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String nexusId; // 关系编号

  protected String postId; // 岗位编号

  protected String staffId; // 员工编号

  protected String defaultPost; // 默认岗位

}

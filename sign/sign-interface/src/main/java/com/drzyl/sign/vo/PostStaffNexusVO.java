package com.drzyl.sign.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 岗位员工 SYS_POST_STAFF_NEXUS 展示类
 */
@Data
public class PostStaffNexusVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String nexusId; // 关系编号

  protected String postId; // 岗位编号

  protected String staffId; // 员工编号

  protected String defaultPost; // 默认岗位

}

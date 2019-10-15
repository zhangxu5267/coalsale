package com.drzyl.sign.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 员工 SYS_STAFF 展示类
 */
@Data
public class StaffVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String staffId; // 员工编号

  protected String staffNo; // 员工工号

  protected String staffName; // 员工姓名

  protected String mobilePhoneNumber; // 手机号

  protected String gender; // 性别

  protected String emergencyContactName; // 紧急联系人姓名

  protected String emergContMobilePhoneNumber; // 紧急联系人手机号

  protected Integer weightOrder; // 排序权重

  protected String description; // 描述

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected Long modifyTimes; // 修改时间

}

package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 员工 SYS_STAFF 查询类
 */
@Data
public class StaffQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

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

  protected List<String> staffIdAndin; // 员工编号Andin查询

  protected String staffNoAndeq; // 员工工号Andeq查询

  protected String staffNoAndKeyLike; // 员工工号AndKeyLike查询

  protected String staffNameOrKeyLike; // 员工姓名OrKeyLike查询

  protected String mobilePhoneNumberOrKeyLike; // 手机号OrKeyLike查询

  protected String genderOrKeyLike; // 性别OrKeyLike查询

  protected String emergencyContactNameOrKeyLike; // 紧急联系人姓名OrKeyLike查询

  protected String emergContMobilePhoneNumberOrKeyLike; // 紧急联系人手机号OrKeyLike查询

  protected String descriptionOrKeyLike; // 描述OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

}

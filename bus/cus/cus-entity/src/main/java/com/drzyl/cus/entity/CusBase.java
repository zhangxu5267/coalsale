package com.drzyl.cus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 客户基础信息 BUS_CUS_BASE 实体类
 */
@Data
@TableName(value = "BUS_CUS_BASE")
public class CusBase implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String cusBaseId; // ID

  protected String customNo; // 客户编码
  @NotNull(message = "单位名称不能为空")
  @Size(max = 80,min = 10,message = "不能大于80个字符,不能小于10个字符")
  protected String companyName; // 单位名称
  @NotNull(message = "社会统一信用代码不能为空")
  @Pattern(regexp = "^([159Y]{1})([1239]{1})([0-9ABCDEFGHJKLMNPQRTUWXY]{6})([0-9ABCDEFGHJKLMNPQRTUWXY]{9})([0-90-9ABCDEFGHJKLMNPQRTUWXY])$" ,message = "社会统一信用代码输入不正确")
  protected String creditCode; // 社会统一信用代码

  protected String address; // 地址

  protected String legalRep; // 法定代表人

  protected String legalPhone; // 法定代表人电话

  protected String legalFax; // 法定代表人传真

  protected String openingBank; // 开户银行

  protected String bankAccount; // 银行账号

  protected String regNumber; // 纳税登记号

  protected String conPhone; // 联系电话

  protected String zipcode; // 邮政编码

  protected String remark; // 备注

  protected String uploadIds; // 附件IDs

  protected String actProcessInstanceId; // 流程实例ID

  protected String actProcessStatus; // 流程状态

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected String createOrg; // 创建机构

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected String modifyOrg; // 修改机构

  protected Long modifyTimes; // 修改时间

  protected String delFlag; // 逻辑删除0=删除,1=显示

}

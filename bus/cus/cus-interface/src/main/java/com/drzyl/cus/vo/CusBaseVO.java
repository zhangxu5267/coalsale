package com.drzyl.cus.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 客户基础信息 BUS_CUS_BASE 展示类
 */
@Data
public class CusBaseVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String cusBaseId; // ID

  protected String customNo; // 客户编码

  protected String companyName; // 单位名称

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

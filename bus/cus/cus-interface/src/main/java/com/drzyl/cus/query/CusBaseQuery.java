package com.drzyl.cus.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 客户基础信息 BUS_CUS_BASE 查询类
 */
@Data
public class CusBaseQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

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

  protected List<String> cusBaseIdAndin; // IDAndin查询

  protected String customNoAndeq; // 客户编码Andeq查询

  protected String customOrKeyLike; // 客户编码OrKeyLike查询

  protected String customNoAndKeyLike; // 客户编码AndKeyLike查询

  protected String companyNameOrKeyLike; // 单位名称OrKeyLike查询

  protected String creditCodeOrKeyLike; // 社会统一信用代码OrKeyLike查询

  protected String addressOrKeyLike; // 地址OrKeyLike查询

  protected String legalRepOrKeyLike; // 法定代表人OrKeyLike查询

  protected String legalPhoneOrKeyLike; // 法定代表人电话OrKeyLike查询

  protected String legalFaxOrKeyLike; // 法定代表人传真OrKeyLike查询

  protected String openingBankOrKeyLike; // 开户银行OrKeyLike查询

  protected String bankAccountOrKeyLike; // 银行账号OrKeyLike查询

  protected String regNumberOrKeyLike; // 纳税登记号OrKeyLike查询

  protected String conPhoneOrKeyLike; // 联系电话OrKeyLike查询

  protected String zipcodeOrKeyLike; // 邮政编码OrKeyLike查询

  protected String remarkOrKeyLike; // 备注OrKeyLike查询

  protected String uploadIdsOrKeyLike; // 附件IDsOrKeyLike查询

  protected String actProcessInstanceIdOrKeyLike; // 流程实例IDOrKeyLike查询

  protected String actProcessStatusOrKeyLike; // 流程状态OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String createOrgOrKeyLike; // 创建机构OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

  protected String modifyOrgOrKeyLike; // 修改机构OrKeyLike查询

  protected String delFlagOrKeyLike; // 逻辑删除0=删除,1=显示OrKeyLike查询

  protected String delFlagAndne; // 逻辑删除不等于

  /*********************************************************/

  protected String companyNameAndlike; // 单位名称 AndKeyLike查询 新增单个模糊查询

  protected String creditCodeAndlike; // 社会统一信用代码 AndKeyLike查询 新增单个模糊查询

  protected String addressAndlike; // 地址 AndKeyLike查询 新增单个模糊查询

  protected String legalRepAndlike; // 法定代表人 AndKeyLike查询 新增单个模糊查询

  protected String legalPhoneAndlike; // 法定代表人电话 AndKeyLike查询 新增单个模糊查询

  protected String legalFaxAndlike; // 法定代表人传真 AndKeyLike查询 新增单个模糊查询

  protected String openingBankAndlike; // 开户银行 AndKeyLike查询 新增单个模糊查询

  protected String bankAccountAndlike; // 银行账号 AndKeyLike查询 新增单个模糊查询

  protected String regNumberAndlike; // 纳税登记号 AndKeyLike查询 新增单个模糊查询

  protected String conPhoneAndlike; // 联系电话 AndKeyLike查询 新增单个模糊查询

  protected String zipcodeAndlike; // 邮政编码 AndKeyLike查询 新增单个模糊查询
}

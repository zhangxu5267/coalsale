package com.drzyl.cus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 客户详细信息 BUS_CUS_BASE_INFO 实体类
 */
@Data
@TableName(value = "BUS_CUS_BASE_INFO")
public class CusBaseInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String cusBaseInfoId; // ID

  protected String cusBaseId; // 客户ID

  protected String cusNo; // 客户编码

  protected String orgId; // 所属机构

  protected String isKey; // 所属机构

  protected String cusRegion; // 客户所属区域

  protected String cusProvince; // 客户省份

  protected String cusIndustry; // 客户所属行业

  protected String cusComnature; // 客户企业性质

  protected String cusType; // 客户分类

  protected String tranType; // 交易类型

  protected String cusParent; // 上级客户

  protected String cusSub; // 下级客户

  protected String fax; // 公司传真

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

package com.drzyl.cus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 客户收货单位 BUS_CUS_ADDRESS 实体类
 */
@Data
@TableName(value = "BUS_CUS_ADDRESS")
public class CusAddress implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String cusAddressId; // ID

  protected String cusBaseId; // 客户ID

  protected String cusNo; // 客户编码

  protected String recAddress; // 收货地址

  protected String deline; // 专线

  protected String arriveStationName; // 到站名称

  protected String arriveStationNo; // 到站编码

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

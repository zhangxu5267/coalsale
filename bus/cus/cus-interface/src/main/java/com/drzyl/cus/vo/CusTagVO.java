package com.drzyl.cus.vo;

import java.io.Serializable;
import java.util.LinkedList;

import com.drzyl.cus.entity.CusBase;
import com.drzyl.cus.entity.CusTag;
import lombok.Data;

/**
 * 客户标签表 BUS_CUS_TAG 展示类
 */
@Data
public class CusTagVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String cusTagId; // ID

  protected String tagNo; // 标签编号

  protected String tagName; // 标签名称

  protected String tagState; // 标签状态

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

  protected LinkedList<CusBaseVO> cusBaseVOs;// 相关的客户

}

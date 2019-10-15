package com.drzyl.cus.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 客户标签中间表 BUS_CUS_TAG_TEMP 展示类
 */
@Data
public class CusTagTempVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String cusTagTempId; // ID

  protected String cusTagId; // 客户ID

  protected String cusBaseId; // 标签ID

}

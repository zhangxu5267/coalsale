package com.drzyl.cus.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 客户标签中间表 BUS_CUS_TAG_TEMP 查询类
 */
@Data
public class CusTagTempQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String cusTagTempId; // ID

  protected String cusTagId; // 客户ID

  protected String cusBaseId; // 标签ID

  protected List<String> cusTagTempIdAndin; // IDAndin查询

  protected String cusTagIdAndKeyLike; // 客户IDAndKeyLike查询

  protected String cusBaseIdOrKeyLike; // 标签IDOrKeyLike查询

}

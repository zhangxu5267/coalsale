package com.drzyl.table.css.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 页面表格样式 PAR_TABLE_CSS 查询类
 */
@Data
public class TableCssQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String id; // ID

  protected String createId; // 创建账号

  protected String tableKey; // 表格标识

  protected String context; // json样式

  protected List<String> idAndin; // IDAndin查询

  protected String createIdAndKeyLike; // 创建账号AndKeyLike查询

  protected String tableKeyOrKeyLike; // 表格标识OrKeyLike查询

  protected String contextOrKeyLike; // json样式OrKeyLike查询

}

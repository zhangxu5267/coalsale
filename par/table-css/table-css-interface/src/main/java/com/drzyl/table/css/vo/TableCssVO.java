package com.drzyl.table.css.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 页面表格样式 PAR_TABLE_CSS 展示类
 */
@Data
public class TableCssVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id; // ID

  protected String createId; // 创建账号

  protected String tableKey; // 表格标识

  protected String context; // json样式

}

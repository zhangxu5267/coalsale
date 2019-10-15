package com.drzyl.table.css.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 页面表格样式 PAR_TABLE_CSS 实体类
 */
@Data
@TableName(value = "PAR_TABLE_CSS")
public class TableCss implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String id; // ID

  protected String createId; // 创建账号

  protected String tableKey; // 表格标识

  protected String context; // json样式

}

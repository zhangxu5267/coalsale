package com.drzyl.code.business.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 列数据
 */
@Data
public class ColumnData implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String columnName;

  protected String dataType;

  protected Integer dataLength;

  protected Integer dataPrecision;

  protected String nullable;

  protected Integer columnId;

  protected String comments;

}

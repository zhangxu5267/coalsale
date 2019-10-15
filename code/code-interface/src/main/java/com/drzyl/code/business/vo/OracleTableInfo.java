package com.drzyl.code.business.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Oracle数据库表信息
 */
@Data
public class OracleTableInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String tableName;

  protected java.lang.String comments;

}
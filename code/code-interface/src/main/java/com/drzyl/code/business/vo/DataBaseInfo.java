package com.drzyl.code.business.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据库信息
 */
@Data
public class DataBaseInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String dataBaseType;

}
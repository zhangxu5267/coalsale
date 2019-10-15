package com.drzyl.cus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 客户标签中间表 BUS_CUS_TAG_TEMP 实体类
 */
@Data
@TableName(value = "BUS_CUS_TAG_TEMP")
public class CusTagTemp implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String cusTagTempId; // ID

  protected String cusTagId; // 客户ID

  protected String cusBaseId; // 标签ID

}

package com.drzyl.tool.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 短信验证码 SYS_SMS_SECURITY_CODE 实体类
 */
@Data
@TableName(value = "SYS_SMS_SECURITY_CODE")
public class SecurityCode implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String id; // ID

  protected String securityCode; // 验证码

  protected String phoneNumber; // 手机号

  protected String action; // 行为

  protected Long createTimes; // 创建时间

}

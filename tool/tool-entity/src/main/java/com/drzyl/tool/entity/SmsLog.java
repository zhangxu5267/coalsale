package com.drzyl.tool.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 发送信息记录 SYS_SEND_SMS_LOG 实体类
 */
@Data
@TableName(value = "SYS_SEND_SMS_LOG")
public class SmsLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  protected String id; // ID

  protected String phone; // 接受手机号

  protected String templatecode; // 短信模板

  protected String context; // 发送内容

  protected String message; // 返回消息

  protected String code; // 返回代码:ok表示成功

  protected String requestid; // 查询请求ID

  protected String bizid; // 查询回执ID

  protected String createId; // 创建ID

  protected String createName; // 创建人姓名

  protected String createOrg; // 创建机构

  protected Long createTimes; // 创建时间

}

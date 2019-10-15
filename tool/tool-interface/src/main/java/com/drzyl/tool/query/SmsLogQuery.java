package com.drzyl.tool.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 发送信息记录 SYS_SEND_SMS_LOG 查询类
 */
@Data
public class SmsLogQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

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

  protected List<String> idAndin; // IDAndin查询

  protected String phoneAndKeyLike; // 接受手机号AndKeyLike查询

  protected String templatecodeOrKeyLike; // 短信模板OrKeyLike查询

  protected String contextOrKeyLike; // 发送内容OrKeyLike查询

  protected String messageOrKeyLike; // 返回消息OrKeyLike查询

  protected String codeOrKeyLike; // 返回代码:ok表示成功OrKeyLike查询

  protected String requestidOrKeyLike; // 查询请求IDOrKeyLike查询

  protected String bizidOrKeyLike; // 查询回执IDOrKeyLike查询

  protected String createIdOrKeyLike; // 创建IDOrKeyLike查询

  protected String createNameOrKeyLike; // 创建人姓名OrKeyLike查询

  protected String createOrgOrKeyLike; // 创建机构OrKeyLike查询

}

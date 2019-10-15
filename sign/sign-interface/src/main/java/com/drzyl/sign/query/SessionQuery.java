package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 会话 SYS_SESSION 查询类
 */
@Data
public class SessionQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String sessionId; // 会话编号

  protected String accountId; // 账号编号

  protected String loginKey; // 登录标识

  protected Long currentTimes; // 当前时间

  protected String aesKey; // AES密钥

  protected Long cookiesExpireTimesBrowser; // 浏览器会话过期时间

  protected Long cookiesExpireTimesAndroid; // 安卓APP会话过期时间

  protected Long cookiesExpireTimesIos; // 苹果APP会话过期时间

  protected Long cookiesExpireTimesWechatapp; // 微信小程序会话过期时间

  protected List<String> sessionIdAndin; // 会话编号Andin查询

  protected String accountIdAndeq; // 账号编号Andeq查询

  protected String loginKeyAndeq; // 登录标识Andeq查询

  protected String accountIdAndKeyLike; // 账号编号AndKeyLike查询

  protected String loginKeyOrKeyLike; // 登录标识OrKeyLike查询

  protected String aesKeyOrKeyLike; // AES密钥OrKeyLike查询

}

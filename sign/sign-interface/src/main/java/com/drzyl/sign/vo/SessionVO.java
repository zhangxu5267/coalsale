package com.drzyl.sign.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 会话 SYS_SESSION 展示类
 */
@Data
public class SessionVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String sessionId; // 会话编号

  protected String accountId; // 账号编号

  protected String loginKey; // 登录标识

  protected Long currentTimes; // 当前时间

  protected String aesKey; // AES密钥

  protected Long cookiesExpireTimesBrowser; // 浏览器会话过期时间

  protected Long cookiesExpireTimesAndroid; // 安卓APP会话过期时间

  protected Long cookiesExpireTimesIos; // 苹果APP会话过期时间

  protected Long cookiesExpireTimesWechatapp; // 微信小程序会话过期时间

}

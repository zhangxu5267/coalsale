package com.drzyl.sign.business.vo;

import java.io.Serializable;
import java.util.LinkedHashSet;

import lombok.Data;

/**
 * 登录信息 展示类
 */
@Data
public class LoginInfoVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String msg; // 消息

  protected String accountId; // 账号编号

  protected String name; // 名字

  protected String avatar; // 头像url

  protected String token; // 令牌

  protected Long cookiesExpireTimes; // 会话过期时间

  protected String aesKey; // AES密钥

  protected LinkedHashSet<String> accessList; // 权限列表

}

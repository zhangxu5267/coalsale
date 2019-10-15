package com.drzyl.sign.business.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 登录信息 参数类
 */
@Data
public class LoginInfoParam implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String loginKey; // 登录标识

  protected String account; // 账号

  protected String password; // 密码

  protected String mobilePhoneNumber; // 手机号

  protected String verificationCode; // 验证码

}

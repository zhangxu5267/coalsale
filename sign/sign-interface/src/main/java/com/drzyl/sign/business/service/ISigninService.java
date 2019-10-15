package com.drzyl.sign.business.service;

import com.drzyl.sign.business.param.LoginInfoParam;
import com.drzyl.sign.business.vo.LoginInfoVO;

/**
 * 权限登录 服务接口
 */
public interface ISigninService {

  /**
   * 账号密码登录
   */
  public LoginInfoVO accountLogin(LoginInfoParam loginInfoParam) throws Exception;

  /**
   * 修改密码
   * @param loginInfoParam
   */
  public void modifyPassword(LoginInfoParam loginInfoParam);
}

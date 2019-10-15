package com.drzyl.sign.business.rest;

import com.drzyl.sign.business.param.LoginInfoParam;
import com.drzyl.sign.business.service.ISigninService;
import com.drzyl.sign.business.vo.LoginInfoVO;
import com.drzyl.sign.entity.Account;
import com.drzyl.sign.persistent.IAccountPersistent;
import com.drzyl.sign.query.AccountQuery;
import com.drzyl.tool.entity.SecurityCode;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.query.SecurityCodeQuery;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.service.ISecurityCodeService;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 权限登录 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "login" })
public class SigninController extends ToolController {

  public static final String LOG = "SigninController";

  @Resource(name = "com.drzyl.sign.SigninService")
  private ISigninService signinService;

  @Resource(name = "com.drzyl.sms.SecurityCodeService")
  private ISecurityCodeService securityCodeService;
  @Resource(name = "com.drzyl.sign.AccountPersistent")
  private IAccountPersistent accountPersistent;

  /**
   * 账号密码登录
   */
  @PostMapping(params = { ToolUtil.ACTION + "account_login" })
  public Responses<LoginInfoVO> accountLogin(Param param, @RequestBody LoginInfoParam loginInfoParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + loginInfoParam);
    }
    Responses<LoginInfoVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(loginInfoParam)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(signinService.accountLogin(loginInfoParam));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过短信验证码修改密码
   */
  @PostMapping(params = {ToolUtil.ACTION + "modify_password"})
  public Responses<LoginInfoVO> modifyPassword(Param param, @RequestBody LoginInfoParam loginInfoParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + loginInfoParam);
    }
    Responses<LoginInfoVO> responses = new Responses<>();
    try {
      // 验证修改密码的验证码
      SecurityCodeQuery securityCodeQuery = new SecurityCodeQuery();
      securityCodeQuery.setAction("ChangePassword");
      securityCodeQuery.setPhoneNumber(loginInfoParam.getMobilePhoneNumber());
      securityCodeQuery.setSecurityCode(loginInfoParam.getVerificationCode());
      int i = securityCodeService.verifySecurityCode(securityCodeQuery);
      if (i == 1) {
        log.info("验证成功");
        // 修改密码
        signinService.modifyPassword(loginInfoParam);
        responses.setMsg("密码修改成功!");
      } else if (i == -1) {
        log.info("验证码不正确");
        responses.isDefeated("验证码不正确!");
      } else {
        log.info("验证码过期");
        responses.isDefeated("验证码过期!");
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }


  /**
   * 获取短信登录 的验证码
   */
  @PostMapping(params = {ToolUtil.ACTION + "login_sms_code"})
  public Responses<LoginInfoVO> loginSms(Param param, @RequestBody LoginInfoParam loginInfoParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + loginInfoParam);
    }
    Responses<LoginInfoVO> responses = new Responses<>();
    try {
      // 验证是否有该用户
      AccountQuery accountQuery = new AccountQuery();
      accountQuery.setMobilePhoneNumber(loginInfoParam.getMobilePhoneNumber());
      Collection<Account> accounts = accountPersistent.queryAccount(accountQuery);
      if (accounts != null && accounts.size() == 1) {
        securityCodeService.sendSmsSecurityCode(loginInfoParam.getMobilePhoneNumber(), "LoginSecurityCode");
        responses.isSuccess("验证码发送成功!");
      } else {
        responses.isDefeated("该手机号未被注册");
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取修改密码的短信验证码
   */
  @PostMapping(params = {ToolUtil.ACTION + "password_sms_code"})
  public Responses<LoginInfoVO> modifyPasswordSms(Param param, @RequestBody LoginInfoParam loginInfoParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + loginInfoParam);
    }
    Responses<LoginInfoVO> responses = new Responses<>();
    try {
      // 验证是否有该用户
      AccountQuery accountQuery = new AccountQuery();
      accountQuery.setMobilePhoneNumber(loginInfoParam.getMobilePhoneNumber());
      Collection<Account> accounts = accountPersistent.queryAccount(accountQuery);
      if (accounts != null && accounts.size() == 1) {
        securityCodeService.sendSmsSecurityCode(loginInfoParam.getMobilePhoneNumber(), "ChangePassword");
        responses.isSuccess("验证码发送成功!");
      } else {
        responses.isDefeated("该手机号未被注册");
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

}

package com.drzyl.sign.business.service.impl;

import com.drzyl.sign.business.param.LoginInfoParam;
import com.drzyl.sign.business.service.ISigninService;
import com.drzyl.sign.business.vo.LoginInfoVO;
import com.drzyl.sign.entity.Account;
import com.drzyl.sign.entity.LoginLog;
import com.drzyl.sign.entity.PostStaffNexus;
import com.drzyl.sign.entity.Role;
import com.drzyl.sign.entity.RolePostNexus;
import com.drzyl.sign.entity.Session;
import com.drzyl.sign.entity.Staff;
import com.drzyl.sign.mapper.AccessMapper;
import com.drzyl.sign.persistent.IAccountPersistent;
import com.drzyl.sign.persistent.ILoginLogPersistent;
import com.drzyl.sign.persistent.IPostStaffNexusPersistent;
import com.drzyl.sign.persistent.IRolePersistent;
import com.drzyl.sign.persistent.IRolePostNexusPersistent;
import com.drzyl.sign.persistent.ISessionPersistent;
import com.drzyl.sign.persistent.IStaffPersistent;
import com.drzyl.sign.query.AccountQuery;
import com.drzyl.sign.query.PostStaffNexusQuery;
import com.drzyl.sign.query.RolePostNexusQuery;
import com.drzyl.sign.query.SessionQuery;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.query.SecurityCodeQuery;
import com.drzyl.tool.service.ISecurityCodeService;
import com.drzyl.tool.util.ToolUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 权限登录 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.SigninService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class SigninServiceImpl implements ISigninService {

  public static final String LOG = "SigninService";

  @Value("${proconfig.cookies-times-effect-browser}")
  private Long cookiesTimesEffectBrowser;

  @Resource(name = "com.drzyl.sign.AccountPersistent")
  private IAccountPersistent accountPersistent;

  @Resource(name = "com.drzyl.sign.SessionPersistent")
  private ISessionPersistent sessionPersistent;

  @Resource(name = "com.drzyl.sign.LoginLogPersistent")
  private ILoginLogPersistent loginLogPersistent;

  @Resource(name = "com.drzyl.sign.RolePersistent")
  private IRolePersistent rolePersistent;

  @Resource(name = "com.drzyl.sign.StaffPersistent")
  private IStaffPersistent staffPersistent;

  @Resource(name = "com.drzyl.sign.PostStaffNexusPersistent")
  private IPostStaffNexusPersistent postStaffNexusPersistent;
  @Resource(name = "com.drzyl.sign.RolePostNexusPersistent")
  private IRolePostNexusPersistent rolePostNexusPersistent;

  @Resource(name = "com.drzyl.sms.SecurityCodeService")
  private ISecurityCodeService securityCodeService;

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  AccessMapper accessMapper;
  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public LoginInfoVO accountLogin(LoginInfoParam loginInfoParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + loginInfoParam);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(loginInfoParam)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      LoginInfoVO loginInfoVO = new LoginInfoVO();

      if ("Browser".equals(loginInfoParam.getLoginKey())) {
        // 浏览器端登录
        loginInfoVO = loginBrowser(loginInfoParam, loginInfoVO);
      } else if ("Android".equals(loginInfoParam.getLoginKey())) {
        // 安卓app登录
        loginInfoVO = loginAndroid(loginInfoParam, loginInfoVO);
      } else if ("ios".equals(loginInfoParam.getLoginKey())) {
        // 苹果app登录
        loginInfoVO = loginIos(loginInfoParam, loginInfoVO);
      } else if ("Wechatapp".equals(loginInfoParam.getLoginKey())) {
        // 微信小程序登录
        loginInfoVO = loginWechatapp(loginInfoParam, loginInfoVO);
      } else if ("sms".equals(loginInfoParam.getLoginKey())) {
        // 短信登录
        loginInfoVO = loginSms(loginInfoParam, loginInfoVO);
      } else {
//        throw new ToolException("登录失败.");
        loginInfoVO.setMsg("登录失败.");
      }
      return loginInfoVO;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  /**
   * 修改密码
   *
   * @param loginInfoParam
   */
  @Override
  public void modifyPassword(LoginInfoParam loginInfoParam) {
    accessMapper.modifyPassword(loginInfoParam);
  }

  /**
   * 短信登录
   *
   * @param loginInfoParam
   * @param loginInfoVO
   * @throws Exception
   */
  private LoginInfoVO loginSms(LoginInfoParam loginInfoParam, LoginInfoVO loginInfoVO) throws Exception {
    if (ToolUtil.isNotNullStr(loginInfoParam.getMobilePhoneNumber()) && ToolUtil.isNotNullStr(loginInfoParam.getVerificationCode())) {
      // 根据电话查找
      Collection<Account> rPhones = getPhones(loginInfoParam);
      if (ToolUtil.isNotEmpty(rPhones)) {
        // 账号存在
        Account rAccount = rPhones.iterator().next();
        SecurityCodeQuery securityCodeQuery = new SecurityCodeQuery();
        securityCodeQuery.setAction("LoginSecurityCode");
        securityCodeQuery.setPhoneNumber(loginInfoParam.getMobilePhoneNumber());
        securityCodeQuery.setSecurityCode(loginInfoParam.getVerificationCode());
        int i = securityCodeService.verifySecurityCode(securityCodeQuery);
        if (i == 1) {
          loginSuccessGetInfo(loginInfoParam, loginInfoVO, rAccount);
        } else if (i == -1) {
          log.info("验证码不正确");
          throw new ToolException("验证码不正确.");
        } else {
          log.info("验证码过期");
          throw new ToolException("验证码过期.");
        }
      } else {
        log.info("账号不存在.");
        throw new ToolException("账号不存在.");
      }
    } else {
      log.info("手机号和验证码不能为空.");
      throw new ToolException("手机号和验证码不能为空.");
    }
    return loginInfoVO;
  }

  /**
   * 安卓登录
   *
   * @param loginInfoParam
   * @param loginInfoVO
   */
  private LoginInfoVO loginAndroid(LoginInfoParam loginInfoParam, LoginInfoVO loginInfoVO) {
    return loginInfoVO;
  }

  /**
   * IOS 苹果登录
   *
   * @param loginInfoParam
   * @param loginInfoVO
   */
  private LoginInfoVO loginIos(LoginInfoParam loginInfoParam, LoginInfoVO loginInfoVO) {
    return loginInfoVO;
  }

  /**
   * 微信登录
   *
   * @param loginInfoParam
   * @param loginInfoVO
   */
  private LoginInfoVO loginWechatapp(LoginInfoParam loginInfoParam, LoginInfoVO loginInfoVO) {
    return loginInfoVO;
  }

  /**
   * 浏览器登录
   *
   * @param loginInfoParam
   * @param loginInfoVO
   * @throws Exception
   */
  private LoginInfoVO loginBrowser(LoginInfoParam loginInfoParam, LoginInfoVO loginInfoVO) throws Exception {
    if (ToolUtil.isNotNullStr(loginInfoParam.getAccount()) && ToolUtil.isNotNullStr(loginInfoParam.getPassword())) {
      // 根据账号查找
      Collection<Account> rAccountSet = getAccounts(loginInfoParam);
      if (ToolUtil.isNotEmpty(rAccountSet)) {
        // 账号存在
        Account rAccount = rAccountSet.iterator().next();
        if (rAccount.getPassword().equals(loginInfoParam.getPassword())) {
          // 密码正确
          loginSuccessGetInfo(loginInfoParam, loginInfoVO, rAccount);
        } else {
          log.info("密码错误.");
          throw new ToolException("密码错误.");
        }
      } else {
        log.info("账号不存在.");
        throw new ToolException("账号不存在.");
      }
    } else {
      log.info("账号或密码不能为空.");
      throw new ToolException("账号或密码不能为空.");
    }
    return loginInfoVO;
  }

  /**
   * 验证成功 , 获取信息
   *
   * @param loginInfoParam
   * @param loginInfoVO
   * @param rAccount
   * @throws Exception
   */
  private LoginInfoVO loginSuccessGetInfo(LoginInfoParam loginInfoParam, LoginInfoVO loginInfoVO, Account rAccount) throws Exception {
    String token = ToolUtil.getUUID();
    Long times = System.currentTimeMillis();
    SessionQuery sessionQuery = new SessionQuery();
    sessionQuery.setLoginKey(loginInfoParam.getLoginKey());
    sessionQuery.setAccountId(rAccount.getAccountId());
    Collection<Session> rSessionSet = sessionPersistent.querySession(sessionQuery);
    if (ToolUtil.isNotEmpty(rSessionSet)) {
      // 已登录
      // 要动主键 只能先删除再保存
      sessionPersistent.removeSession(rSessionSet.iterator().next());
      // 保存会话信息
      Session saveSession = saveSession(loginInfoParam, token, times, rAccount);
      sessionTimeOut(rAccount, saveSession);
      sessionPersistent.saveSession(saveSession);
      // 保存登录日志
      saveLoginLog(loginInfoParam, times, rAccount);
      //账号权限
      authority(loginInfoVO, rAccount);
      // 设置登录返回信息
      loginInfoVO.setMsg("登录成功.");
      loginInfoVO.setAccountId(rAccount.getAccountId());
      loginInfoVO.setToken(token);
      loginInfoVO.setCookiesExpireTimes(times + saveSession.getCookiesExpireTimesBrowser());
      loginInfoVO.setAesKey(ToolUtil.encodeRSAByPublicKey(saveSession.getAesKey(), ToolUtil.PUBLIC_KEY));
    } else {
      // 未登录
      // 保存会话信息
      Session saveSession = saveSession(loginInfoParam, token, times, rAccount);
      // 设置会话过期
      sessionTimeOut(rAccount, saveSession);
      sessionPersistent.saveSession(saveSession);
      // 保存登录日志
      saveLoginLog(loginInfoParam, times, rAccount);
      // 关联权限
      authority(loginInfoVO, rAccount);
      // 设置登录返回信息
      loginInfoVO.setMsg("登录成功.");
      loginInfoVO.setAccountId(rAccount.getAccountId());
      loginInfoVO.setToken(token);
      loginInfoVO.setCookiesExpireTimes(times + saveSession.getCookiesExpireTimesBrowser());
      loginInfoVO.setAesKey(ToolUtil.encodeRSAByPublicKey(saveSession.getAesKey(), ToolUtil.PUBLIC_KEY));
    }
    return loginInfoVO;
  }

  /**
   * 账号权限
   *
   * @param loginInfoVO
   * @param rAccount
   * @throws Exception
   */
  private void authority(LoginInfoVO loginInfoVO, Account rAccount) throws Exception {
    if (ToolUtil.isNotNullStr(rAccount.getNexusType())) {
      // 账号已关联人员或权限
      if ("staff".equals(rAccount.getNexusType())) {
        // 员工
        Staff staff = staffPersistent.getStaffByPk(rAccount.getNexusObjectId());
        loginInfoVO.setName(staff.getStaffName());
        loginInfoVO.setAvatar("");
        PostStaffNexusQuery postStaffNexusQuery = new PostStaffNexusQuery();
        postStaffNexusQuery.setStaffId(staff.getStaffId());
        postStaffNexusQuery.setDefaultPost("y");
        Collection<PostStaffNexus> rPostStaffNexus = postStaffNexusPersistent.queryPostStaffNexus(postStaffNexusQuery);
        if (ToolUtil.isNotEmpty(rPostStaffNexus)) {
          PostStaffNexus postStaffNexus = rPostStaffNexus.iterator().next();
          RolePostNexusQuery rolePostNexusQuery = new RolePostNexusQuery();
          rolePostNexusQuery.setPostId(postStaffNexus.getPostId());
          Collection<RolePostNexus> rRolePostNexus = rolePostNexusPersistent.queryRolePostNexus(rolePostNexusQuery);
          if (ToolUtil.isNotEmpty(rRolePostNexus)) {
            RolePostNexus rolePostNexus = rRolePostNexus.iterator().next();
            Role role = rolePersistent.getRoleByPk(rolePostNexus.getRoleId());
            if (ToolUtil.isNotNullStr(role.getAccessList())) {
              loginInfoVO.setAccessList(new LinkedHashSet<String>(new Gson().fromJson(role.getAccessList(), new TypeToken<Collection<String>>() {
              }.getType())));
            } else {
              loginInfoVO.setAccessList(new LinkedHashSet<String>());
            }
          } else {
            loginInfoVO.setAccessList(new LinkedHashSet<String>());
          }
        } else {
          loginInfoVO.setAccessList(new LinkedHashSet<String>());
        }
      } else if ("sys_admin".equals(rAccount.getNexusType())) {
        // 系统管理员
      } else if ("branch_office_sys_admin".equals(rAccount.getNexusType())) {
        // 分公司或办事处系统管理员
      } else if ("group_company_sys_admin".equals(rAccount.getNexusType())) {
        // 集团系统管理员
      } else if ("code".equals(rAccount.getNexusType())) {
        // 代码生成
        loginInfoVO.setName(rAccount.getAccount());
        loginInfoVO.setAvatar("");
        if (ToolUtil.isNotNullStr(rAccount.getNexusObjectId())) {
          Role role = rolePersistent.getRoleByPk(rAccount.getNexusObjectId());
          if (ToolUtil.isNotNullStr(role.getAccessList())) {
            loginInfoVO.setAccessList(new LinkedHashSet<String>(new Gson().fromJson(role.getAccessList(), new TypeToken<Collection<String>>() {
            }.getType())));
          } else {
            loginInfoVO.setAccessList(new LinkedHashSet<String>());
          }
        } else {
          loginInfoVO.setAccessList(new LinkedHashSet<String>());
        }
      } else {
        loginInfoVO.setName(rAccount.getAccount());
        loginInfoVO.setAvatar("");
        loginInfoVO.setAccessList(new LinkedHashSet<String>());
      }
    } else {
      // 账号未关联人员或权限
      loginInfoVO.setName(rAccount.getAccount());
      loginInfoVO.setAvatar("");
      loginInfoVO.setAccessList(new LinkedHashSet<String>());
    }
  }

  private void saveLoginLog(LoginInfoParam loginInfoParam, Long times, Account rAccount) throws Exception {
    LoginLog saveLoginLog = new LoginLog();
    saveLoginLog.setLogId(ToolUtil.getUUID());
    saveLoginLog.setLoginKey(loginInfoParam.getLoginKey());
    saveLoginLog.setAccountId(rAccount.getAccountId());
    saveLoginLog.setAccount(rAccount.getAccount());
    saveLoginLog.setMobilePhoneNumber(rAccount.getMobilePhoneNumber());
    saveLoginLog.setLoginTimes(times);
    loginLogPersistent.saveLoginLog(saveLoginLog);
  }

  private void sessionTimeOut(Account rAccount, Session saveSession) {
    if (rAccount.getCookiesExpireTimesBrowser() != null) {
      // 账号内设置了会话过期时间
      if (rAccount.getCookiesExpireTimesBrowser() == 0l) {
        // 会话永不过期 默认设置为365天
        saveSession.setCookiesExpireTimesBrowser(31536000000l);
      } else {
        saveSession.setCookiesExpireTimesBrowser(rAccount.getCookiesExpireTimesBrowser());
      }
    } else {
      // 账号没有设置会话过期时间
      // 使用默认会话过期时间
      if (cookiesTimesEffectBrowser == 0l) {
        // 会话永不过期 默认设置为365天
        saveSession.setCookiesExpireTimesBrowser(31536000000l);
      } else {
        saveSession.setCookiesExpireTimesBrowser(cookiesTimesEffectBrowser);
      }
    }
  }

  private Session saveSession(LoginInfoParam loginInfoParam, String token, Long times, Account rAccount) {
    Session saveSession = new Session();
    saveSession.setSessionId(token);
    saveSession.setAccountId(rAccount.getAccountId());
    saveSession.setLoginKey(loginInfoParam.getLoginKey());
    saveSession.setCurrentTimes(times);
    saveSession.setAesKey(ToolUtil.getAESKey(token));
    return saveSession;
  }

  private Collection<Account> getAccounts(LoginInfoParam loginInfoParam) throws Exception {
    AccountQuery accountQuery = new AccountQuery();
    accountQuery.setAccount(loginInfoParam.getAccount());
    return accountPersistent.queryAccount(accountQuery);
  }

  /**
   * 根据电话号码查找
   *
   * @param loginInfoParam
   * @return
   */
  private Collection<Account> getPhones(LoginInfoParam loginInfoParam) throws Exception {
    String phoneNumber = loginInfoParam.getMobilePhoneNumber();
    AccountQuery accountQuery = new AccountQuery();
    accountQuery.setMobilePhoneNumber(phoneNumber);
    Collection<Account> accounts = accountPersistent.queryAccount(accountQuery);
    return accounts;
  }
}

package com.drzyl.sign.interceptors;

import com.drzyl.sign.entity.Account;
import com.drzyl.sign.entity.Org;
import com.drzyl.sign.entity.Post;
import com.drzyl.sign.entity.PostStaffNexus;
import com.drzyl.sign.entity.Session;
import com.drzyl.sign.entity.Staff;
import com.drzyl.sign.mapper.OrgInfoMapper;
import com.drzyl.sign.query.PostStaffNexusQuery;
import com.drzyl.sign.service.IAccountService;
import com.drzyl.sign.service.IOrgService;
import com.drzyl.sign.service.IPostService;
import com.drzyl.sign.service.IPostStaffNexusService;
import com.drzyl.sign.service.ISessionService;
import com.drzyl.sign.service.IStaffService;
import com.drzyl.tool.context.CurrentLoginAccountInfo;
import com.drzyl.tool.context.OrgInfo;
import com.drzyl.tool.context.TokenTimesEffect;
import com.drzyl.tool.context.ToolContextData;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 请求拦截器
 */
@Log4j2
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

  public static final String LOG = "AuthorizationInterceptor";

  @Resource(name = "com.drzyl.sign.SessionService")
  private ISessionService sessionService;

  @Resource(name = "com.drzyl.sign.AccountService")
  private IAccountService accountService;

  @Resource(name = "com.drzyl.sign.StaffService")
  private IStaffService staffService;

  @Resource(name = "com.drzyl.sign.PostStaffNexusService")
  private IPostStaffNexusService postStaffNexusService;

  @Resource(name = "com.drzyl.sign.PostService")
  private IPostService postService;

  @Resource(name = "com.drzyl.sign.OrgService")
  private IOrgService orgService;

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private OrgInfoMapper orgInfoMapper;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (log.isInfoEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      Map<String, String[]> parameterMap = request.getParameterMap();
      if (parameterMap.containsKey("token")) {
        Long times = System.currentTimeMillis();
        String token = parameterMap.get("token")[0];
        Session session = sessionService.getSessionByPk(token);
        if (!ToolUtil.isNullEntityAllFieldValue(session)) {
          if ("Browser".equals(session.getLoginKey()) || "sms".equals(session.getLoginKey())) {
            // 浏览器端登录
            session.setCurrentTimes(times);
            sessionService.updateSession(session);
            ToolContextData.removeTokenTimesEffect();
            TokenTimesEffect tokenTimesEffect = new TokenTimesEffect();
            tokenTimesEffect.setToken(token);
            tokenTimesEffect.setCookiesExpireTimes(times + session.getCookiesExpireTimesBrowser());
            ToolContextData.setTokenTimesEffect(tokenTimesEffect);
            ToolContextData.removeCurrentLoginAccountInfo();
            CurrentLoginAccountInfo currentLoginAccountInfo = new CurrentLoginAccountInfo();
            currentLoginAccountInfo.setAccountId(session.getAccountId());
            ToolContextData.removeOrgInfo();
            OrgInfo orgInfo = new OrgInfo();
            Account account = accountService.getAccountByPk(session.getAccountId());
            if (!ToolUtil.isNullEntityAllFieldValue(account)) {
              if (ToolUtil.isNotNullStr(account.getNexusType())) {
                if ("staff".equals(account.getNexusType())) {
                  // 员工
                  Staff staff = staffService.getStaffByPk(account.getNexusObjectId());
                  currentLoginAccountInfo.setName(staff.getStaffName());
                  PostStaffNexusQuery postStaffNexusQuery = new PostStaffNexusQuery();
                  postStaffNexusQuery.setStaffId(staff.getStaffId());
                  postStaffNexusQuery.setDefaultPost("y");
                  Collection<PostStaffNexus> rPostStaffNexus = postStaffNexusService.queryPostStaffNexus(postStaffNexusQuery);
                  if (ToolUtil.isNotEmpty(rPostStaffNexus)) {
                    PostStaffNexus postStaffNexus = rPostStaffNexus.iterator().next();
                    Post post = postService.getPostByPk(postStaffNexus.getPostId());
                    Org org = orgService.getOrgByPk(post.getOrgId());
                    ArrayList<String> ids = new ArrayList<String>();
                    for (String s : org.getIdPath().split("/")) {
                      ids.add(s);
                    }
                    Collection<Org> rOrgSet = orgInfoMapper.getOrgInfo(ids);
                    if (ToolUtil.isNotEmpty(rOrgSet)) {
                      Org rOrg = rOrgSet.iterator().next();
                      orgInfo.setOrgId(rOrg.getOrgId());
                      orgInfo.setOrgName(rOrg.getOrgName());
                    }
                  }
                } else if ("sys_admin".equals(account.getNexusType())) {
                  // 系统管理员
                } else if ("branch_office_sys_admin".equals(account.getNexusType())) {
                  // 分公司或办事处系统管理员
                } else if ("group_company_sys_admin".equals(account.getNexusType())) {
                  // 集团系统管理员
                } else if ("code".equals(account.getNexusType())) {
                  // 代码生成
                  currentLoginAccountInfo.setName(account.getAccount());
                } else {
                }
              }
            }
            ToolContextData.setCurrentLoginAccountInfo(currentLoginAccountInfo);
            ToolContextData.setOrgInfo(orgInfo);
          } else if ("Android".equals(session.getLoginKey())) {
            // 安卓app登录
          } else if ("ios".equals(session.getLoginKey())) {
            // 苹果app登录
          } else if ("Wechatapp".equals(session.getLoginKey())) {
            // 微信小程序登录
          } else {
            response.sendError(401, "token 无效");
            return false;
          }
        } else {
          response.sendError(401, "token 无效");
          return false;
        }
      } else {
        response.sendError(401, "token 无效");
        return false;
      }
      return true;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    if (log.isInfoEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    if (log.isInfoEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
  }

}

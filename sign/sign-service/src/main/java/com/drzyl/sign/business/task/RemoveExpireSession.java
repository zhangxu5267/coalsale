package com.drzyl.sign.business.task;

import com.drzyl.sign.entity.Session;
import com.drzyl.sign.service.ISessionService;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedHashSet;

@Log4j2
@Component
public class RemoveExpireSession {

  public static final String LOG = "StaffController";

  @Resource(name = "com.drzyl.sign.SessionService")
  private ISessionService sessionService;

  @Scheduled(cron = "0 */1 * * * ?")
  public void RemoveExpireSessionRecord() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      Long times = System.currentTimeMillis();
      Collection<Session> rSession = sessionService.getAllSession();
      LinkedHashSet<Session> delSessionSet = new LinkedHashSet<>();
      if (ToolUtil.isNotEmpty(rSession)) {
        for (Session session : rSession) {
          if ("Browser".equals(session.getLoginKey())) {
            if (session.getCurrentTimes() + session.getCookiesExpireTimesBrowser() <= times) {
              delSessionSet.add(session);
            }
          } else if ("Android".equals(session.getLoginKey())) {
            // 安卓app登录
          } else if ("ios".equals(session.getLoginKey())) {
            // 苹果app登录
          } else if ("Wechatapp".equals(session.getLoginKey())) {
            // 微信小程序登录
          }
        }
      }
      if (ToolUtil.isNotEmpty(delSessionSet)) {
        sessionService.batchRemoveSession(delSessionSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

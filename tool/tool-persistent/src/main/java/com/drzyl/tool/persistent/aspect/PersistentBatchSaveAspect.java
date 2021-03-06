package com.drzyl.tool.persistent.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.drzyl.tool.context.ToolContextData;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;

/**
 * 持久化批量保存方法 AOP 拦截器</br>
 * 添加数据版本号和数据创建者信息
 */
@Log4j2
@Aspect
@Component
public class PersistentBatchSaveAspect {

  @Pointcut("execution(public * com.drzyl..persistent..*.batchSave*(..))")
  public void BatchSaveAddVersionsAccount() {
  }

  @SuppressWarnings("Duplicates")
  @Before("BatchSaveAddVersionsAccount()")
  public void doBefore(JoinPoint joinPoint) throws Exception {
    if (log.isInfoEnabled()) {
      log.debug(ToolUtil.getLog("PersistentBatchSaveAspect"));
    }
    try {
      for (Object o : joinPoint.getArgs()) {
        if (o != null) {
          if (o instanceof Collection) {
            for (Object eo : (Collection<?>) o) {
              LinkedHashSet<Method> eoSetMethods = new LinkedHashSet<Method>();
              Class<?> eoclass = eo.getClass();
              while (eoclass != null) {
                eoSetMethods.addAll(Arrays.asList(eoclass.getMethods()));
                eoclass = eoclass.getSuperclass();
              }
              for (Method sM : eoSetMethods) {
                if ("setVersions".equals(sM.getName())) {
                  sM.invoke(eo, 1);
                  continue;
                } else if ("setCreateId".equals(sM.getName())) {
                  sM.invoke(eo, ToolContextData.getCurrentLoginAccountInfo() != null && ToolContextData.getCurrentLoginAccountInfo().getAccountId() != null ? ToolContextData.getCurrentLoginAccountInfo().getAccountId() : "NGAccountId");
                  continue;
                } else if ("setCreateName".equals(sM.getName())) {
                  sM.invoke(eo, ToolContextData.getCurrentLoginAccountInfo() != null && ToolContextData.getCurrentLoginAccountInfo().getName() != null ? ToolContextData.getCurrentLoginAccountInfo().getName() : "NGName");
                  continue;
                } else if ("setCreateTimes".equals(sM.getName())) {
                  sM.invoke(eo, System.currentTimeMillis());
                  continue;
                }else if ("setModifyId".equals(sM.getName())) {
                  sM.invoke(eo, ToolContextData.getCurrentLoginAccountInfo() != null && ToolContextData.getCurrentLoginAccountInfo().getAccountId() != null ? ToolContextData.getCurrentLoginAccountInfo().getAccountId() : "NGAccountId");
                  continue;
                } else if ("setModifyName".equals(sM.getName())) {
                  sM.invoke(eo, ToolContextData.getCurrentLoginAccountInfo() != null && ToolContextData.getCurrentLoginAccountInfo().getName() != null ? ToolContextData.getCurrentLoginAccountInfo().getName() : "NGName");
                  continue;
                } else if ("setModifyTimes".equals(sM.getName())) {
                  sM.invoke(eo, System.currentTimeMillis());
                  continue;
                }else if ("setDelFLag".equals(sM.getName())) {
                  sM.invoke(eo, "1");
                  continue;
                }
              }
            }
          }
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

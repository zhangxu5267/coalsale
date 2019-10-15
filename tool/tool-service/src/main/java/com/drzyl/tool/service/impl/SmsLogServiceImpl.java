package com.drzyl.tool.service.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.tool.entity.SmsLog;
import com.drzyl.tool.persistent.ISmsLogPersistent;
import com.drzyl.tool.query.SmsLogQuery;
import com.drzyl.tool.service.ISmsLogService;
import com.drzyl.tool.vo.SmsLogVO;
import lombok.extern.log4j.Log4j2;

/**
 * 发送信息记录 服务实现
 */
@Log4j2
@Service("com.drzyl.tool.SmsLogService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class SmsLogServiceImpl implements ISmsLogService {

  public static final String LOG = "SmsLogService";

  @Resource(name = "com.drzyl.tool.SmsLogPersistent")
  private ISmsLogPersistent smsLogPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public SmsLog saveSmsLog(SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLog);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      smsLog.setId(ToolUtil.getUUID());
      return smsLogPersistent.saveSmsLog(smsLog);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<SmsLog> batchSaveSmsLog(Collection<SmsLog> smsLogs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLogs);
    }
    try {
      if (ToolUtil.isEmpty(smsLogs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (SmsLog smsLog : smsLogs) {
        if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        smsLog.setId(ToolUtil.getUUID());
      }
      return smsLogPersistent.batchSaveSmsLog(smsLogs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public SmsLog updateSmsLog(SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLog);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(smsLog.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      SmsLog oldSmsLog = smsLogPersistent.getSmsLogByPk(smsLog.getId());
      if (ToolUtil.isNullEntityAllFieldValue(oldSmsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return smsLogPersistent.updateSmsLog(smsLog);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<SmsLog> batchUpdateSmsLog(Collection<SmsLog> smsLogs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLogs);
    }
    try {
      if (ToolUtil.isEmpty(smsLogs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (SmsLog smsLog : smsLogs) {
        if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(smsLog.getId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        SmsLog oldSmsLog = smsLogPersistent.getSmsLogByPk(smsLog.getId());
        if (ToolUtil.isNullEntityAllFieldValue(oldSmsLog)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return smsLogPersistent.batchUpdateSmsLog(smsLogs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeSmsLog(SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLog);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<SmsLog> smsLogSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(smsLog.getId())) {
        SmsLogQuery smsLogQuery = new SmsLogQuery();
        BeanUtils.copyProperties(smsLog, smsLogQuery);
        smsLogSet.addAll(smsLogPersistent.querySmsLog(smsLogQuery));
      } else {
        SmsLog oldSmsLog = smsLogPersistent.getSmsLogByPk(smsLog.getId());
        if (ToolUtil.isNullEntityAllFieldValue(oldSmsLog)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        smsLogSet.add(oldSmsLog);
      }
      if (ToolUtil.isNotEmpty(smsLogSet)) {
        smsLogPersistent.batchRemoveSmsLog(smsLogSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void batchRemoveSmsLog(Collection<SmsLog> smsLogs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLogs);
    }
    try {
      if (ToolUtil.isEmpty(smsLogs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<SmsLog> smsLogSet = new LinkedHashSet<>();
      for (SmsLog smsLog : smsLogs) {
        if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(smsLog.getId())) {
          SmsLogQuery smsLogQuery = new SmsLogQuery();
          BeanUtils.copyProperties(smsLog, smsLogQuery);
          smsLogSet.addAll(smsLogPersistent.querySmsLog(smsLogQuery));
        } else {
          SmsLog oldSmsLog = smsLogPersistent.getSmsLogByPk(smsLog.getId());
          if (ToolUtil.isNullEntityAllFieldValue(oldSmsLog)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          smsLogSet.add(oldSmsLog);
        }
      }
      if (ToolUtil.isNotEmpty(smsLogSet)) {
        smsLogPersistent.batchRemoveSmsLog(smsLogSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountSmsLog(SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    try {
      return smsLogPersistent.getCountSmsLog(smsLogQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public SmsLog getSmsLogByPk(String id) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + id);
    }
    try {
      if (ToolUtil.isNullStr(id)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return smsLogPersistent.getSmsLogByPk(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SmsLog> getAllSmsLog() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return smsLogPersistent.getAllSmsLog();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SmsLog> querySmsLog(SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    try {
      return smsLogPersistent.querySmsLog(smsLogQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<SmsLog> pagingQuerySmsLog(Param param, SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return smsLogPersistent.pagingQuerySmsLog(param, smsLogQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public SmsLogVO getSmsLogVOByPk(String id) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + id);
    }
    try {
      if (ToolUtil.isNullStr(id)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return smsLogPersistent.getSmsLogVOByPk(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SmsLogVO> getAllSmsLogVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return smsLogPersistent.getAllSmsLogVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SmsLogVO> querySmsLogVO(SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    try {
      return smsLogPersistent.querySmsLogVO(smsLogQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<SmsLogVO> pagingQuerySmsLogVO(Param param, SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return smsLogPersistent.pagingQuerySmsLogVO(param, smsLogQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

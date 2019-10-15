package com.drzyl.tool.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.tool.entity.SmsLog;
import com.drzyl.tool.query.SmsLogQuery;
import com.drzyl.tool.service.ISmsLogService;
import com.drzyl.tool.vo.SmsLogVO;
import lombok.extern.log4j.Log4j2;

/**
 * 发送信息记录 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "tool/smsLog" })
public class SmsLogController extends ToolController {

  public static final String LOG = "SmsLogController";

  @Resource(name = "com.drzyl.tool.SmsLogService")
  private ISmsLogService smsLogService;

  /**
   * 保存 发送信息记录 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<SmsLog> save(Param param, @RequestBody SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLog);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(smsLogService.saveSmsLog(smsLog));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 发送信息记录 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<SmsLog> batchSave(Param param, @RequestBody List<SmsLog> smsLogs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogs);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(smsLogs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(smsLogService.batchSaveSmsLog(smsLogs));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 发送信息记录 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<SmsLog> update(Param param, @RequestBody SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLog);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(smsLogService.updateSmsLog(smsLog));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 发送信息记录 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<SmsLog> batchUpdate(Param param, @RequestBody List<SmsLog> smsLogs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogs);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(smsLogs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(smsLogService.batchUpdateSmsLog(smsLogs));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 发送信息记录 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<SmsLog> remove(Param param, @RequestBody SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLog);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      smsLogService.removeSmsLog(smsLog);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 发送信息记录 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<SmsLog> batchRemove(Param param, @RequestBody List<SmsLog> smsLogs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogs);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(smsLogs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      smsLogService.batchRemoveSmsLog(smsLogs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 发送信息记录 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<SmsLog> getByPk(Param param, @RequestBody SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLog);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(smsLog.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(smsLogService.getSmsLogByPk(smsLog.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 发送信息记录 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<SmsLog> getAll(Param param, @RequestBody SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLogQuery)) {
        responses.setData(smsLogService.getAllSmsLog());
      } else {
        responses.setData(smsLogService.querySmsLog(smsLogQuery));
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
   * 分页获取 发送信息记录 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<SmsLog> paging(Param param, @RequestBody SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    Responses<SmsLog> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLogQuery)) {
        responses.setData(smsLogService.pagingQuerySmsLog(param, null));
      } else {
        responses.setData(smsLogService.pagingQuerySmsLog(param, smsLogQuery));
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
   * 通过主键获取 发送信息记录 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<SmsLogVO> getVOByPk(Param param, @RequestBody SmsLog smsLog) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLog);
    }
    Responses<SmsLogVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLog)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(smsLog.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(smsLogService.getSmsLogVOByPk(smsLog.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 发送信息记录 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<SmsLogVO> getAllVO(Param param, @RequestBody SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    Responses<SmsLogVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLogQuery)) {
        responses.setData(smsLogService.getAllSmsLogVO());
      } else {
        responses.setData(smsLogService.querySmsLogVO(smsLogQuery));
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
   * 分页获取 发送信息记录 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<SmsLogVO> pagingVO(Param param, @RequestBody SmsLogQuery smsLogQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + smsLogQuery);
    }
    Responses<SmsLogVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(smsLogQuery)) {
        responses.setData(smsLogService.pagingQuerySmsLogVO(param, null));
      } else {
        responses.setData(smsLogService.pagingQuerySmsLogVO(param, smsLogQuery));
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

package com.drzyl.tool.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.entity.SmsLog;
import com.drzyl.tool.query.SmsLogQuery;
import com.drzyl.tool.vo.SmsLogVO;

/**
 * 发送信息记录 服务接口
 */
public interface ISmsLogService {

  /**
   * 保存 发送信息记录 信息
   */
  public SmsLog saveSmsLog(SmsLog smsLog) throws Exception;

  /**
   * 批量保存 发送信息记录 信息
   */
  public Collection<SmsLog> batchSaveSmsLog(Collection<SmsLog> smsLogs) throws Exception;

  /**
   * 修改 发送信息记录 信息
   */
  public SmsLog updateSmsLog(SmsLog smsLog) throws Exception;

  /**
   * 批量修改 发送信息记录 信息
   */
  public Collection<SmsLog> batchUpdateSmsLog(Collection<SmsLog> smsLogs) throws Exception;

  /**
   * 删除 发送信息记录 信息
   */
  public void removeSmsLog(SmsLog smsLog) throws Exception;

  /**
   * 批量删除 发送信息记录 信息
   */
  public void batchRemoveSmsLog(Collection<SmsLog> smsLogs) throws Exception;

  /**
   * 获取 发送信息记录 数据量
   */
  public Long getCountSmsLog(SmsLogQuery smsLogQuery) throws Exception;

  /**
   * 通过主键获取 发送信息记录 数据
   */
  public SmsLog getSmsLogByPk(String id) throws Exception;

  /**
   * 获取 发送信息记录 所有数据
   */
  public Collection<SmsLog> getAllSmsLog() throws Exception;

  /**
   * 查询 发送信息记录 数据
   */
  public Collection<SmsLog> querySmsLog(SmsLogQuery smsLogQuery) throws Exception;

  /**
   * 分页查询 发送信息记录 数据
   */
  public Paging<SmsLog> pagingQuerySmsLog(Param param, SmsLogQuery smsLogQuery) throws Exception;

  /**
   * 通过主键获取 发送信息记录 展示数据
   */
  public SmsLogVO getSmsLogVOByPk(String id) throws Exception;

  /**
   * 获取 发送信息记录 所有展示数据
   */
  public Collection<SmsLogVO> getAllSmsLogVO() throws Exception;

  /**
   * 查询 发送信息记录 展示数据
   */
  public Collection<SmsLogVO> querySmsLogVO(SmsLogQuery smsLogQuery) throws Exception;

  /**
   * 分页查询 发送信息记录 展示数据
   */
  public Paging<SmsLogVO> pagingQuerySmsLogVO(Param param, SmsLogQuery smsLogQuery) throws Exception;

}

package com.drzyl.sign.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.sign.entity.LoginLog;
import com.drzyl.sign.query.LoginLogQuery;
import com.drzyl.sign.vo.LoginLogVO;

/**
 * 登录日志 持久化接口
 */
public interface ILoginLogPersistent {

  public static final String TABLE_NAME = "SYS_LOGIN_LOG";

  /**
   * 保存 登录日志 信息
   */
  public LoginLog saveLoginLog(LoginLog loginLog) throws Exception;

  /**
   * 批量保存 登录日志 信息
   */
  public Collection<LoginLog> batchSaveLoginLog(Collection<LoginLog> loginLogs) throws Exception;

  /**
   * 修改 登录日志 信息
   */
  public LoginLog updateLoginLog(LoginLog loginLog) throws Exception;

  /**
   * 批量修改 登录日志 信息
   */
  public Collection<LoginLog> batchUpdateLoginLog(Collection<LoginLog> loginLogs) throws Exception;

  /**
   * 删除 登录日志 信息
   */
  public void removeLoginLog(LoginLog loginLog) throws Exception;

  /**
   * 批量删除 登录日志 信息
   */
  public void batchRemoveLoginLog(Collection<LoginLog> loginLogs) throws Exception;

  /**
   * 获取 登录日志 数据量
   */
  public Long getCountLoginLog(LoginLogQuery loginLogQuery) throws Exception;

  /**
   * 通过主键获取 登录日志 数据
   */
  public LoginLog getLoginLogByPk(String logId) throws Exception;

  /**
   * 获取 登录日志 所有数据
   */
  public Collection<LoginLog> getAllLoginLog() throws Exception;

  /**
   * 查询 登录日志 数据
   */
  public Collection<LoginLog> queryLoginLog(LoginLogQuery loginLogQuery) throws Exception;

  /**
   * 分页查询 登录日志 数据
   */
  public Paging<LoginLog> pagingQueryLoginLog(Param param, LoginLogQuery loginLogQuery) throws Exception;

  /**
   * 通过主键获取 登录日志 展示数据
   */
  public LoginLogVO getLoginLogVOByPk(String logId) throws Exception;

  /**
   * 获取 登录日志 所有展示数据
   */
  public Collection<LoginLogVO> getAllLoginLogVO() throws Exception;

  /**
   * 查询 登录日志 展示数据
   */
  public Collection<LoginLogVO> queryLoginLogVO(LoginLogQuery loginLogQuery) throws Exception;

  /**
   * 分页查询 登录日志 展示数据
   */
  public Paging<LoginLogVO> pagingQueryLoginLogVO(Param param, LoginLogQuery loginLogQuery) throws Exception;

}

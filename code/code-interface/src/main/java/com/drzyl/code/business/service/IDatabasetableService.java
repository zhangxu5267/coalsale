package com.drzyl.code.business.service;

import com.drzyl.code.business.vo.DataBaseInfo;
import com.drzyl.code.business.vo.OracleTableInfo;

import java.util.Collection;

/**
 * 数据库表信息 服务接口
 */
public interface IDatabasetableService {

  /**
   * 获取Oracle数据库表信息
   */
  public Collection<OracleTableInfo> getAllTable() throws Exception;

  /**
   * 获取当前连接数据库类型
   */
  public DataBaseInfo getDataBaseType() throws Exception;

}

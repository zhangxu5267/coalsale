package com.drzyl.code.business.persistent;

import java.util.Collection;

/**
 * 数据库 持久化接口
 */
public interface IDatabasePersistent {

  /**
   * 获取当前连接数据库类型
   */
  public String getDataBaseType() throws Exception;

}

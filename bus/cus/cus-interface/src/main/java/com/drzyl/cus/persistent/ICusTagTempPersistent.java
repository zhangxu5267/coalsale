package com.drzyl.cus.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.cus.entity.CusTagTemp;
import com.drzyl.cus.query.CusTagTempQuery;
import com.drzyl.cus.vo.CusTagTempVO;

/**
 * 客户标签中间表 持久化接口
 */
public interface ICusTagTempPersistent {

  public static final String TABLE_NAME = "BUS_CUS_TAG_TEMP";

  /**
   * 保存 客户标签中间表 信息
   */
  public CusTagTemp saveCusTagTemp(CusTagTemp cusTagTemp) throws Exception;

  /**
   * 批量保存 客户标签中间表 信息
   */
  public Collection<CusTagTemp> batchSaveCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception;

  /**
   * 修改 客户标签中间表 信息
   */
  public CusTagTemp updateCusTagTemp(CusTagTemp cusTagTemp) throws Exception;

  /**
   * 批量修改 客户标签中间表 信息
   */
  public Collection<CusTagTemp> batchUpdateCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception;

  /**
   * 删除 客户标签中间表 信息
   */
  public void removeCusTagTemp(CusTagTemp cusTagTemp) throws Exception;

  /**
   * 批量删除 客户标签中间表 信息
   */
  public void batchRemoveCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception;

  /**
   * 获取 客户标签中间表 数据量
   */
  public Long getCountCusTagTemp(CusTagTempQuery cusTagTempQuery) throws Exception;

  /**
   * 通过主键获取 客户标签中间表 数据
   */
  public CusTagTemp getCusTagTempByPk(String cusTagTempId) throws Exception;

  /**
   * 获取 客户标签中间表 所有数据
   */
  public Collection<CusTagTemp> getAllCusTagTemp() throws Exception;

  /**
   * 查询 客户标签中间表 数据
   */
  public Collection<CusTagTemp> queryCusTagTemp(CusTagTempQuery cusTagTempQuery) throws Exception;

  /**
   * 分页查询 客户标签中间表 数据
   */
  public Paging<CusTagTemp> pagingQueryCusTagTemp(Param param, CusTagTempQuery cusTagTempQuery) throws Exception;

  /**
   * 通过主键获取 客户标签中间表 展示数据
   */
  public CusTagTempVO getCusTagTempVOByPk(String cusTagTempId) throws Exception;

  /**
   * 获取 客户标签中间表 所有展示数据
   */
  public Collection<CusTagTempVO> getAllCusTagTempVO() throws Exception;

  /**
   * 查询 客户标签中间表 展示数据
   */
  public Collection<CusTagTempVO> queryCusTagTempVO(CusTagTempQuery cusTagTempQuery) throws Exception;

  /**
   * 分页查询 客户标签中间表 展示数据
   */
  public Paging<CusTagTempVO> pagingQueryCusTagTempVO(Param param, CusTagTempQuery cusTagTempQuery) throws Exception;

}

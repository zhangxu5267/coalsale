package com.drzyl.cus.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.cus.entity.CusBase;
import com.drzyl.cus.query.CusBaseQuery;
import com.drzyl.cus.vo.CusBaseVO;

/**
 * 客户基础信息 持久化接口
 */
public interface ICusBasePersistent {

  public static final String TABLE_NAME = "BUS_CUS_BASE";

  /**
   * 保存 客户基础信息 信息
   */
  public CusBase saveCusBase(CusBase cusBase) throws Exception;

  /**
   * 批量保存 客户基础信息 信息
   */
  public Collection<CusBase> batchSaveCusBase(Collection<CusBase> cusBases) throws Exception;

  /**
   * 修改 客户基础信息 信息
   */
  public CusBase updateCusBase(CusBase cusBase) throws Exception;

  /**
   * 批量修改 客户基础信息 信息
   */
  public Collection<CusBase> batchUpdateCusBase(Collection<CusBase> cusBases) throws Exception;

  /**
   * 删除 客户基础信息 信息
   */
  public void removeCusBase(CusBase cusBase) throws Exception;

  /**
   * 批量删除 客户基础信息 信息
   */
  public void batchRemoveCusBase(Collection<CusBase> cusBases) throws Exception;

  /**
   * 获取 客户基础信息 数据量
   */
  public Long getCountCusBase(CusBaseQuery cusBaseQuery) throws Exception;

  /**
   * 通过主键获取 客户基础信息 数据
   */
  public CusBase getCusBaseByPk(String cusBaseId) throws Exception;

  /**
   * 获取 客户基础信息 所有数据
   */
  public Collection<CusBase> getAllCusBase() throws Exception;

  /**
   * 查询 客户基础信息 数据
   */
  public Collection<CusBase> queryCusBase(CusBaseQuery cusBaseQuery) throws Exception;

  /**
   * 分页查询 客户基础信息 数据
   */
  public Paging<CusBase> pagingQueryCusBase(Param param, CusBaseQuery cusBaseQuery) throws Exception;

  /**
   * 通过主键获取 客户基础信息 展示数据
   */
  public CusBaseVO getCusBaseVOByPk(String cusBaseId) throws Exception;

  /**
   * 获取 客户基础信息 所有展示数据
   */
  public Collection<CusBaseVO> getAllCusBaseVO() throws Exception;

  /**
   * 查询 客户基础信息 展示数据
   */
  public Collection<CusBaseVO> queryCusBaseVO(CusBaseQuery cusBaseQuery) throws Exception;

  /**
   * 分页查询 客户基础信息 展示数据
   */
  public Paging<CusBaseVO> pagingQueryCusBaseVO(Param param, CusBaseQuery cusBaseQuery) throws Exception;

}

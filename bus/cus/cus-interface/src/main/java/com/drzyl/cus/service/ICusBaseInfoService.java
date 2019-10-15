package com.drzyl.cus.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.cus.entity.CusBaseInfo;
import com.drzyl.cus.query.CusBaseInfoQuery;
import com.drzyl.cus.vo.CusBaseInfoVO;

/**
 * 客户详细信息 服务接口
 */
public interface ICusBaseInfoService {

  /**
   * 保存 客户详细信息 信息
   */
  public CusBaseInfo saveCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception;

  /**
   * 批量保存 客户详细信息 信息
   */
  public Collection<CusBaseInfo> batchSaveCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception;

  /**
   * 修改 客户详细信息 信息
   */
  public CusBaseInfo updateCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception;

  /**
   * 批量修改 客户详细信息 信息
   */
  public Collection<CusBaseInfo> batchUpdateCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception;

  /**
   * 删除 客户详细信息 信息
   */
  public void removeCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception;

  /**
   * 批量删除 客户详细信息 信息
   */
  public void batchRemoveCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception;

  /**
   * 获取 客户详细信息 数据量
   */
  public Long getCountCusBaseInfo(CusBaseInfoQuery cusBaseInfoQuery) throws Exception;

  /**
   * 通过主键获取 客户详细信息 数据
   */
  public CusBaseInfo getCusBaseInfoByPk(String cusBaseInfoId) throws Exception;

  /**
   * 获取 客户详细信息 所有数据
   */
  public Collection<CusBaseInfo> getAllCusBaseInfo() throws Exception;

  /**
   * 查询 客户详细信息 数据
   */
  public Collection<CusBaseInfo> queryCusBaseInfo(CusBaseInfoQuery cusBaseInfoQuery) throws Exception;

  /**
   * 分页查询 客户详细信息 数据
   */
  public Paging<CusBaseInfo> pagingQueryCusBaseInfo(Param param, CusBaseInfoQuery cusBaseInfoQuery) throws Exception;

  /**
   * 通过主键获取 客户详细信息 展示数据
   */
  public CusBaseInfoVO getCusBaseInfoVOByPk(String cusBaseInfoId) throws Exception;

  /**
   * 获取 客户详细信息 所有展示数据
   */
  public Collection<CusBaseInfoVO> getAllCusBaseInfoVO() throws Exception;

  /**
   * 查询 客户详细信息 展示数据
   */
  public Collection<CusBaseInfoVO> queryCusBaseInfoVO(CusBaseInfoQuery cusBaseInfoQuery) throws Exception;

  /**
   * 分页查询 客户详细信息 展示数据
   */
  public Paging<CusBaseInfoVO> pagingQueryCusBaseInfoVO(Param param, CusBaseInfoQuery cusBaseInfoQuery) throws Exception;

}

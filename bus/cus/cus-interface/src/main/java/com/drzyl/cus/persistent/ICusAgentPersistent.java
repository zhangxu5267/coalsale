package com.drzyl.cus.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.cus.entity.CusAgent;
import com.drzyl.cus.query.CusAgentQuery;
import com.drzyl.cus.vo.CusAgentVO;

/**
 * 客户委托信息 持久化接口
 */
public interface ICusAgentPersistent {

  public static final String TABLE_NAME = "BUS_CUS_AGENT";

  /**
   * 保存 客户委托信息 信息
   */
  public CusAgent saveCusAgent(CusAgent cusAgent) throws Exception;

  /**
   * 批量保存 客户委托信息 信息
   */
  public Collection<CusAgent> batchSaveCusAgent(Collection<CusAgent> cusAgents) throws Exception;

  /**
   * 修改 客户委托信息 信息
   */
  public CusAgent updateCusAgent(CusAgent cusAgent) throws Exception;

  /**
   * 批量修改 客户委托信息 信息
   */
  public Collection<CusAgent> batchUpdateCusAgent(Collection<CusAgent> cusAgents) throws Exception;

  /**
   * 删除 客户委托信息 信息
   */
  public void removeCusAgent(CusAgent cusAgent) throws Exception;

  /**
   * 批量删除 客户委托信息 信息
   */
  public void batchRemoveCusAgent(Collection<CusAgent> cusAgents) throws Exception;

  /**
   * 获取 客户委托信息 数据量
   */
  public Long getCountCusAgent(CusAgentQuery cusAgentQuery) throws Exception;

  /**
   * 通过主键获取 客户委托信息 数据
   */
  public CusAgent getCusAgentByPk(String cusAgentId) throws Exception;

  /**
   * 获取 客户委托信息 所有数据
   */
  public Collection<CusAgent> getAllCusAgent() throws Exception;

  /**
   * 查询 客户委托信息 数据
   */
  public Collection<CusAgent> queryCusAgent(CusAgentQuery cusAgentQuery) throws Exception;

  /**
   * 分页查询 客户委托信息 数据
   */
  public Paging<CusAgent> pagingQueryCusAgent(Param param, CusAgentQuery cusAgentQuery) throws Exception;

  /**
   * 通过主键获取 客户委托信息 展示数据
   */
  public CusAgentVO getCusAgentVOByPk(String cusAgentId) throws Exception;

  /**
   * 获取 客户委托信息 所有展示数据
   */
  public Collection<CusAgentVO> getAllCusAgentVO() throws Exception;

  /**
   * 查询 客户委托信息 展示数据
   */
  public Collection<CusAgentVO> queryCusAgentVO(CusAgentQuery cusAgentQuery) throws Exception;

  /**
   * 分页查询 客户委托信息 展示数据
   */
  public Paging<CusAgentVO> pagingQueryCusAgentVO(Param param, CusAgentQuery cusAgentQuery) throws Exception;

}

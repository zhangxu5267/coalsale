package com.drzyl.code.persistent;

import java.util.Collection;

import com.drzyl.code.entity.Pk;
import com.drzyl.code.query.PkQuery;
import com.drzyl.code.vo.PkVO;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;

/**
 * 主键 持久化接口
 */
public interface IPkPersistent {

  public static final String TABLE_NAME = "PRO_PK";

  /**
   * 保存 主键 信息
   */
  public Pk savePk(Pk pk) throws Exception;

  /**
   * 批量保存 主键 信息
   */
  public Collection<Pk> batchSavePk(Collection<Pk> pks) throws Exception;

  /**
   * 修改 主键 信息
   */
  public Pk updatePk(Pk pk) throws Exception;

  /**
   * 批量修改 主键 信息
   */
  public Collection<Pk> batchUpdatePk(Collection<Pk> pks) throws Exception;

  /**
   * 删除 主键 信息
   */
  public void removePk(Pk pk) throws Exception;

  /**
   * 批量删除 主键 信息
   */
  public void batchRemovePk(Collection<Pk> pks) throws Exception;

  /**
   * 获取 主键 数据量
   */
  public Long getCountPk(PkQuery pkQuery) throws Exception;

  /**
   * 通过主键获取 主键 数据
   */
  public Pk getPkByPk(String pkId) throws Exception;

  /**
   * 获取 主键 所有数据
   */
  public Collection<Pk> getAllPk() throws Exception;

  /**
   * 查询 主键 数据
   */
  public Collection<Pk> queryPk(PkQuery pkQuery) throws Exception;

  /**
   * 分页查询 主键 数据
   */
  public Paging<Pk> pagingQueryPk(Param param, PkQuery pkQuery) throws Exception;

  /**
   * 通过主键获取 主键 展示数据
   */
  public PkVO getPkVOByPk(String pkId) throws Exception;

  /**
   * 获取 主键 所有展示数据
   */
  public Collection<PkVO> getAllPkVO() throws Exception;

  /**
   * 查询 主键 展示数据
   */
  public Collection<PkVO> queryPkVO(PkQuery pkQuery) throws Exception;

  /**
   * 分页查询 主键 展示数据
   */
  public Paging<PkVO> pagingQueryPkVO(Param param, PkQuery pkQuery) throws Exception;

}

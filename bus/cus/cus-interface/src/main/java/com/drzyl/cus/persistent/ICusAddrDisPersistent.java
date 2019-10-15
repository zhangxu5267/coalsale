package com.drzyl.cus.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.cus.entity.CusAddrDis;
import com.drzyl.cus.query.CusAddrDisQuery;
import com.drzyl.cus.vo.CusAddrDisVO;

/**
 * 客户收货地址表 持久化接口
 */
public interface ICusAddrDisPersistent {

  public static final String TABLE_NAME = "BUS_CUS_ADDR_DIS";

  /**
   * 保存 客户收货地址表 信息
   */
  public CusAddrDis saveCusAddrDis(CusAddrDis cusAddrDis) throws Exception;

  /**
   * 批量保存 客户收货地址表 信息
   */
  public Collection<CusAddrDis> batchSaveCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception;

  /**
   * 修改 客户收货地址表 信息
   */
  public CusAddrDis updateCusAddrDis(CusAddrDis cusAddrDis) throws Exception;

  /**
   * 批量修改 客户收货地址表 信息
   */
  public Collection<CusAddrDis> batchUpdateCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception;

  /**
   * 删除 客户收货地址表 信息
   */
  public void removeCusAddrDis(CusAddrDis cusAddrDis) throws Exception;

  /**
   * 批量删除 客户收货地址表 信息
   */
  public void batchRemoveCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception;

  /**
   * 获取 客户收货地址表 数据量
   */
  public Long getCountCusAddrDis(CusAddrDisQuery cusAddrDisQuery) throws Exception;

  /**
   * 通过主键获取 客户收货地址表 数据
   */
  public CusAddrDis getCusAddrDisByPk(String cusAddrDisId) throws Exception;

  /**
   * 获取 客户收货地址表 所有数据
   */
  public Collection<CusAddrDis> getAllCusAddrDis() throws Exception;

  /**
   * 查询 客户收货地址表 数据
   */
  public Collection<CusAddrDis> queryCusAddrDis(CusAddrDisQuery cusAddrDisQuery) throws Exception;

  /**
   * 分页查询 客户收货地址表 数据
   */
  public Paging<CusAddrDis> pagingQueryCusAddrDis(Param param, CusAddrDisQuery cusAddrDisQuery) throws Exception;

  /**
   * 通过主键获取 客户收货地址表 展示数据
   */
  public CusAddrDisVO getCusAddrDisVOByPk(String cusAddrDisId) throws Exception;

  /**
   * 获取 客户收货地址表 所有展示数据
   */
  public Collection<CusAddrDisVO> getAllCusAddrDisVO() throws Exception;

  /**
   * 查询 客户收货地址表 展示数据
   */
  public Collection<CusAddrDisVO> queryCusAddrDisVO(CusAddrDisQuery cusAddrDisQuery) throws Exception;

  /**
   * 分页查询 客户收货地址表 展示数据
   */
  public Paging<CusAddrDisVO> pagingQueryCusAddrDisVO(Param param, CusAddrDisQuery cusAddrDisQuery) throws Exception;

}

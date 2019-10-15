package com.drzyl.cus.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.cus.entity.CusAddress;
import com.drzyl.cus.query.CusAddressQuery;
import com.drzyl.cus.vo.CusAddressVO;

/**
 * 客户收货单位 服务接口
 */
public interface ICusAddressService {

  /**
   * 保存 客户收货单位 信息
   */
  public CusAddress saveCusAddress(CusAddress cusAddress) throws Exception;

  /**
   * 批量保存 客户收货单位 信息
   */
  public Collection<CusAddress> batchSaveCusAddress(Collection<CusAddress> cusAddresss) throws Exception;

  /**
   * 修改 客户收货单位 信息
   */
  public CusAddress updateCusAddress(CusAddress cusAddress) throws Exception;

  /**
   * 批量修改 客户收货单位 信息
   */
  public Collection<CusAddress> batchUpdateCusAddress(Collection<CusAddress> cusAddresss) throws Exception;

  /**
   * 删除 客户收货单位 信息
   */
  public void removeCusAddress(CusAddress cusAddress) throws Exception;

  /**
   * 批量删除 客户收货单位 信息
   */
  public void batchRemoveCusAddress(Collection<CusAddress> cusAddresss) throws Exception;

  /**
   * 获取 客户收货单位 数据量
   */
  public Long getCountCusAddress(CusAddressQuery cusAddressQuery) throws Exception;

  /**
   * 通过主键获取 客户收货单位 数据
   */
  public CusAddress getCusAddressByPk(String cusAddressId) throws Exception;

  /**
   * 获取 客户收货单位 所有数据
   */
  public Collection<CusAddress> getAllCusAddress() throws Exception;

  /**
   * 查询 客户收货单位 数据
   */
  public Collection<CusAddress> queryCusAddress(CusAddressQuery cusAddressQuery) throws Exception;

  /**
   * 分页查询 客户收货单位 数据
   */
  public Paging<CusAddress> pagingQueryCusAddress(Param param, CusAddressQuery cusAddressQuery) throws Exception;

  /**
   * 通过主键获取 客户收货单位 展示数据
   */
  public CusAddressVO getCusAddressVOByPk(String cusAddressId) throws Exception;

  /**
   * 获取 客户收货单位 所有展示数据
   */
  public Collection<CusAddressVO> getAllCusAddressVO() throws Exception;

  /**
   * 查询 客户收货单位 展示数据
   */
  public Collection<CusAddressVO> queryCusAddressVO(CusAddressQuery cusAddressQuery) throws Exception;

  /**
   * 分页查询 客户收货单位 展示数据
   */
  public Paging<CusAddressVO> pagingQueryCusAddressVO(Param param, CusAddressQuery cusAddressQuery) throws Exception;

}

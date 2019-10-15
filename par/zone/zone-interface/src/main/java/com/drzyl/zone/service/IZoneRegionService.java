package com.drzyl.zone.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.zone.entity.ZoneRegion;
import com.drzyl.zone.query.ZoneRegionQuery;
import com.drzyl.zone.vo.ZoneRegionVO;

/**
 * 省市区 服务接口
 */
public interface IZoneRegionService {

  /**
   * 保存 省市区 信息
   */
  public ZoneRegion saveZoneRegion(ZoneRegion zoneRegion) throws Exception;

  /**
   * 批量保存 省市区 信息
   */
  public Collection<ZoneRegion> batchSaveZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception;

  /**
   * 修改 省市区 信息
   */
  public ZoneRegion updateZoneRegion(ZoneRegion zoneRegion) throws Exception;

  /**
   * 批量修改 省市区 信息
   */
  public Collection<ZoneRegion> batchUpdateZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception;

  /**
   * 删除 省市区 信息
   */
  public void removeZoneRegion(ZoneRegion zoneRegion) throws Exception;

  /**
   * 批量删除 省市区 信息
   */
  public void batchRemoveZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception;

  /**
   * 获取 省市区 数据量
   */
  public Long getCountZoneRegion(ZoneRegionQuery zoneRegionQuery) throws Exception;

  /**
   * 通过主键获取 省市区 数据
   */
  public ZoneRegion getZoneRegionByPk(String regionId) throws Exception;

  /**
   * 获取 省市区 所有数据
   */
  public Collection<ZoneRegion> getAllZoneRegion() throws Exception;

  /**
   * 查询 省市区 数据
   */
  public Collection<ZoneRegion> queryZoneRegion(ZoneRegionQuery zoneRegionQuery) throws Exception;

  /**
   * 分页查询 省市区 数据
   */
  public Paging<ZoneRegion> pagingQueryZoneRegion(Param param, ZoneRegionQuery zoneRegionQuery) throws Exception;

  /**
   * 通过主键获取 省市区 展示数据
   */
  public ZoneRegionVO getZoneRegionVOByPk(String regionId) throws Exception;

  /**
   * 获取 省市区 所有展示数据
   */
  public Collection<ZoneRegionVO> getAllZoneRegionVO() throws Exception;

  /**
   * 查询 省市区 展示数据
   */
  public Collection<ZoneRegionVO> queryZoneRegionVO(ZoneRegionQuery zoneRegionQuery) throws Exception;

  /**
   * 分页查询 省市区 展示数据
   */
  public Paging<ZoneRegionVO> pagingQueryZoneRegionVO(Param param, ZoneRegionQuery zoneRegionQuery) throws Exception;

}

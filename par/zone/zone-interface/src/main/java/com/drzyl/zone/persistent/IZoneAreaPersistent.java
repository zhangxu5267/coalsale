package com.drzyl.zone.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.query.ZoneAreaQuery;
import com.drzyl.zone.vo.ZoneAreaVO;

/**
 * 区域 持久化接口
 */
public interface IZoneAreaPersistent {

  public static final String TABLE_NAME = "PAR_ZONE_AREA";

  /**
   * 保存 区域 信息
   */
  public ZoneArea saveZoneArea(ZoneArea zoneArea) throws Exception;

  /**
   * 批量保存 区域 信息
   */
  public Collection<ZoneArea> batchSaveZoneArea(Collection<ZoneArea> zoneAreas) throws Exception;

  /**
   * 修改 区域 信息
   */
  public ZoneArea updateZoneArea(ZoneArea zoneArea) throws Exception;

  /**
   * 批量修改 区域 信息
   */
  public Collection<ZoneArea> batchUpdateZoneArea(Collection<ZoneArea> zoneAreas) throws Exception;

  /**
   * 删除 区域 信息
   */
  public void removeZoneArea(ZoneArea zoneArea) throws Exception;

  /**
   * 批量删除 区域 信息
   */
  public void batchRemoveZoneArea(Collection<ZoneArea> zoneAreas) throws Exception;

  /**
   * 获取 区域 数据量
   */
  public Long getCountZoneArea(ZoneAreaQuery zoneAreaQuery) throws Exception;

  /**
   * 通过主键获取 区域 数据
   */
  public ZoneArea getZoneAreaByPk(String areaId) throws Exception;

  /**
   * 获取 区域 所有数据
   */
  public Collection<ZoneArea> getAllZoneArea() throws Exception;

  /**
   * 查询 区域 数据
   */
  public Collection<ZoneArea> queryZoneArea(ZoneAreaQuery zoneAreaQuery) throws Exception;

  /**
   * 分页查询 区域 数据
   */
  public Paging<ZoneArea> pagingQueryZoneArea(Param param, ZoneAreaQuery zoneAreaQuery) throws Exception;

  /**
   * 通过主键获取 区域 展示数据
   */
  public ZoneAreaVO getZoneAreaVOByPk(String areaId) throws Exception;

  /**
   * 获取 区域 所有展示数据
   */
  public Collection<ZoneAreaVO> getAllZoneAreaVO() throws Exception;

  /**
   * 查询 区域 展示数据
   */
  public Collection<ZoneAreaVO> queryZoneAreaVO(ZoneAreaQuery zoneAreaQuery) throws Exception;

  /**
   * 分页查询 区域 展示数据
   */
  public Paging<ZoneAreaVO> pagingQueryZoneAreaVO(Param param, ZoneAreaQuery zoneAreaQuery) throws Exception;

}

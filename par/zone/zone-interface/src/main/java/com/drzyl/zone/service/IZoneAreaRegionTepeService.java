package com.drzyl.zone.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.zone.entity.ZoneAreaRegionTepe;
import com.drzyl.zone.query.ZoneAreaRegionTepeQuery;
import com.drzyl.zone.vo.ZoneAreaRegionTepeVO;

/**
 * 区域-省市区中间表 服务接口
 */
public interface IZoneAreaRegionTepeService {

  /**
   * 保存 区域-省市区中间表 信息
   */
  public ZoneAreaRegionTepe saveZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception;

  /**
   * 批量保存 区域-省市区中间表 信息
   */
  public Collection<ZoneAreaRegionTepe> batchSaveZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception;

  /**
   * 修改 区域-省市区中间表 信息
   */
  public ZoneAreaRegionTepe updateZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception;

  /**
   * 批量修改 区域-省市区中间表 信息
   */
  public Collection<ZoneAreaRegionTepe> batchUpdateZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception;

  /**
   * 删除 区域-省市区中间表 信息
   */
  public void removeZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception;

  /**
   * 批量删除 区域-省市区中间表 信息
   */
  public void batchRemoveZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception;

  /**
   * 获取 区域-省市区中间表 数据量
   */
  public Long getCountZoneAreaRegionTepe(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception;

  /**
   * 通过主键获取 区域-省市区中间表 数据
   */
  public ZoneAreaRegionTepe getZoneAreaRegionTepeByPk(String id) throws Exception;

  /**
   * 获取 区域-省市区中间表 所有数据
   */
  public Collection<ZoneAreaRegionTepe> getAllZoneAreaRegionTepe() throws Exception;

  /**
   * 查询 区域-省市区中间表 数据
   */
  public Collection<ZoneAreaRegionTepe> queryZoneAreaRegionTepe(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception;

  /**
   * 分页查询 区域-省市区中间表 数据
   */
  public Paging<ZoneAreaRegionTepe> pagingQueryZoneAreaRegionTepe(Param param, ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception;

  /**
   * 通过主键获取 区域-省市区中间表 展示数据
   */
  public ZoneAreaRegionTepeVO getZoneAreaRegionTepeVOByPk(String id) throws Exception;

  /**
   * 获取 区域-省市区中间表 所有展示数据
   */
  public Collection<ZoneAreaRegionTepeVO> getAllZoneAreaRegionTepeVO() throws Exception;

  /**
   * 查询 区域-省市区中间表 展示数据
   */
  public Collection<ZoneAreaRegionTepeVO> queryZoneAreaRegionTepeVO(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception;

  /**
   * 分页查询 区域-省市区中间表 展示数据
   */
  public Paging<ZoneAreaRegionTepeVO> pagingQueryZoneAreaRegionTepeVO(Param param, ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception;

}

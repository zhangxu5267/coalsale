package com.drzyl.zone.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.zone.entity.ZoneRegion;
import com.drzyl.zone.query.ZoneRegionQuery;
import com.drzyl.zone.service.IZoneRegionService;
import com.drzyl.zone.vo.ZoneRegionVO;
import lombok.extern.log4j.Log4j2;

/**
 * 省市区 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "zone/zoneRegion" })
public class ZoneRegionController extends ToolController {

  public static final String LOG = "ZoneRegionController";

  @Resource(name = "com.drzyl.zone.ZoneRegionService")
  private IZoneRegionService zoneRegionService;

  /**
   * 保存 省市区 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<ZoneRegion> save(Param param, @RequestBody ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneRegionService.saveZoneRegion(zoneRegion));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 省市区 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<ZoneRegion> batchSave(Param param, @RequestBody List<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneRegionService.batchSaveZoneRegion(zoneRegions));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 省市区 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<ZoneRegion> update(Param param, @RequestBody ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneRegionService.updateZoneRegion(zoneRegion));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 省市区 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<ZoneRegion> batchUpdate(Param param, @RequestBody List<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneRegionService.batchUpdateZoneRegion(zoneRegions));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 省市区 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<ZoneRegion> remove(Param param, @RequestBody ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      zoneRegionService.removeZoneRegion(zoneRegion);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 省市区 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<ZoneRegion> batchRemove(Param param, @RequestBody List<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      zoneRegionService.batchRemoveZoneRegion(zoneRegions);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 省市区 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<ZoneRegion> getByPk(Param param, @RequestBody ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneRegionService.getZoneRegionByPk(zoneRegion.getRegionId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 省市区 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<ZoneRegion> getAll(Param param, @RequestBody ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        responses.setData(zoneRegionService.getAllZoneRegion());
      } else {
        responses.setData(zoneRegionService.queryZoneRegion(zoneRegionQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 分页获取 省市区 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<ZoneRegion> paging(Param param, @RequestBody ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    Responses<ZoneRegion> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        responses.setData(zoneRegionService.pagingQueryZoneRegion(param, null));
      } else {
        responses.setData(zoneRegionService.pagingQueryZoneRegion(param, zoneRegionQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 省市区 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<ZoneRegionVO> getVOByPk(Param param, @RequestBody ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    Responses<ZoneRegionVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneRegionService.getZoneRegionVOByPk(zoneRegion.getRegionId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 省市区 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<ZoneRegionVO> getAllVO(Param param, @RequestBody ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    Responses<ZoneRegionVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        responses.setData(zoneRegionService.getAllZoneRegionVO());
      } else {
        responses.setData(zoneRegionService.queryZoneRegionVO(zoneRegionQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 分页获取 省市区 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<ZoneRegionVO> pagingVO(Param param, @RequestBody ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    Responses<ZoneRegionVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        responses.setData(zoneRegionService.pagingQueryZoneRegionVO(param, null));
      } else {
        responses.setData(zoneRegionService.pagingQueryZoneRegionVO(param, zoneRegionQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

}

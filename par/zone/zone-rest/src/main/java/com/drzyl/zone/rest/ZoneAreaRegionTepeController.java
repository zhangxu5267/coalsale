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
import com.drzyl.zone.entity.ZoneAreaRegionTepe;
import com.drzyl.zone.query.ZoneAreaRegionTepeQuery;
import com.drzyl.zone.service.IZoneAreaRegionTepeService;
import com.drzyl.zone.vo.ZoneAreaRegionTepeVO;
import lombok.extern.log4j.Log4j2;

/**
 * 区域-省市区中间表 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "zone/zoneAreaRegionTepe" })
public class ZoneAreaRegionTepeController extends ToolController {

  public static final String LOG = "ZoneAreaRegionTepeController";

  @Resource(name = "com.drzyl.zone.ZoneAreaRegionTepeService")
  private IZoneAreaRegionTepeService zoneAreaRegionTepeService;

  /**
   * 保存 区域-省市区中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<ZoneAreaRegionTepe> save(Param param, @RequestBody ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneAreaRegionTepeService.saveZoneAreaRegionTepe(zoneAreaRegionTepe));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 区域-省市区中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<ZoneAreaRegionTepe> batchSave(Param param, @RequestBody List<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneAreaRegionTepeService.batchSaveZoneAreaRegionTepe(zoneAreaRegionTepes));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 区域-省市区中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<ZoneAreaRegionTepe> update(Param param, @RequestBody ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneAreaRegionTepeService.updateZoneAreaRegionTepe(zoneAreaRegionTepe));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 区域-省市区中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<ZoneAreaRegionTepe> batchUpdate(Param param, @RequestBody List<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneAreaRegionTepeService.batchUpdateZoneAreaRegionTepe(zoneAreaRegionTepes));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 区域-省市区中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<ZoneAreaRegionTepe> remove(Param param, @RequestBody ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      zoneAreaRegionTepeService.removeZoneAreaRegionTepe(zoneAreaRegionTepe);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 区域-省市区中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<ZoneAreaRegionTepe> batchRemove(Param param, @RequestBody List<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      zoneAreaRegionTepeService.batchRemoveZoneAreaRegionTepe(zoneAreaRegionTepes);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 区域-省市区中间表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<ZoneAreaRegionTepe> getByPk(Param param, @RequestBody ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneAreaRegionTepeService.getZoneAreaRegionTepeByPk(zoneAreaRegionTepe.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 区域-省市区中间表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<ZoneAreaRegionTepe> getAll(Param param, @RequestBody ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        responses.setData(zoneAreaRegionTepeService.getAllZoneAreaRegionTepe());
      } else {
        responses.setData(zoneAreaRegionTepeService.queryZoneAreaRegionTepe(zoneAreaRegionTepeQuery));
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
   * 分页获取 区域-省市区中间表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<ZoneAreaRegionTepe> paging(Param param, @RequestBody ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    Responses<ZoneAreaRegionTepe> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        responses.setData(zoneAreaRegionTepeService.pagingQueryZoneAreaRegionTepe(param, null));
      } else {
        responses.setData(zoneAreaRegionTepeService.pagingQueryZoneAreaRegionTepe(param, zoneAreaRegionTepeQuery));
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
   * 通过主键获取 区域-省市区中间表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<ZoneAreaRegionTepeVO> getVOByPk(Param param, @RequestBody ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    Responses<ZoneAreaRegionTepeVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(zoneAreaRegionTepeService.getZoneAreaRegionTepeVOByPk(zoneAreaRegionTepe.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 区域-省市区中间表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<ZoneAreaRegionTepeVO> getAllVO(Param param, @RequestBody ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    Responses<ZoneAreaRegionTepeVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        responses.setData(zoneAreaRegionTepeService.getAllZoneAreaRegionTepeVO());
      } else {
        responses.setData(zoneAreaRegionTepeService.queryZoneAreaRegionTepeVO(zoneAreaRegionTepeQuery));
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
   * 分页获取 区域-省市区中间表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<ZoneAreaRegionTepeVO> pagingVO(Param param, @RequestBody ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    Responses<ZoneAreaRegionTepeVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        responses.setData(zoneAreaRegionTepeService.pagingQueryZoneAreaRegionTepeVO(param, null));
      } else {
        responses.setData(zoneAreaRegionTepeService.pagingQueryZoneAreaRegionTepeVO(param, zoneAreaRegionTepeQuery));
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

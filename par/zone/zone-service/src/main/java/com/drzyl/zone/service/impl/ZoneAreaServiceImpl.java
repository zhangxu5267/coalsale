package com.drzyl.zone.service.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.persistent.IZoneAreaPersistent;
import com.drzyl.zone.query.ZoneAreaQuery;
import com.drzyl.zone.service.IZoneAreaService;
import com.drzyl.zone.vo.ZoneAreaVO;
import lombok.extern.log4j.Log4j2;

/**
 * 区域 服务实现
 */
@Log4j2
@Service("com.drzyl.zone.ZoneAreaService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class ZoneAreaServiceImpl implements IZoneAreaService {

  public static final String LOG = "ZoneAreaService";

  @Resource(name = "com.drzyl.zone.ZoneAreaPersistent")
  private IZoneAreaPersistent zoneAreaPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public ZoneArea saveZoneArea(ZoneArea zoneArea) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneArea);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      zoneArea.setAreaId(ToolUtil.getUUID());
      return zoneAreaPersistent.saveZoneArea(zoneArea);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<ZoneArea> batchSaveZoneArea(Collection<ZoneArea> zoneAreas) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreas);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreas)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (ZoneArea zoneArea : zoneAreas) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        zoneArea.setAreaId(ToolUtil.getUUID());
      }
      return zoneAreaPersistent.batchSaveZoneArea(zoneAreas);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public ZoneArea updateZoneArea(ZoneArea zoneArea) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneArea);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      ZoneArea oldZoneArea = zoneAreaPersistent.getZoneAreaByPk(zoneArea.getAreaId());
      if (ToolUtil.isNullEntityAllFieldValue(oldZoneArea)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaPersistent.updateZoneArea(zoneArea);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<ZoneArea> batchUpdateZoneArea(Collection<ZoneArea> zoneAreas) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreas);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreas)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (ZoneArea zoneArea : zoneAreas) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        ZoneArea oldZoneArea = zoneAreaPersistent.getZoneAreaByPk(zoneArea.getAreaId());
        if (ToolUtil.isNullEntityAllFieldValue(oldZoneArea)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return zoneAreaPersistent.batchUpdateZoneArea(zoneAreas);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeZoneArea(ZoneArea zoneArea) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneArea);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<ZoneArea> zoneAreaSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
        ZoneAreaQuery zoneAreaQuery = new ZoneAreaQuery();
        BeanUtils.copyProperties(zoneArea, zoneAreaQuery);
        zoneAreaSet.addAll(zoneAreaPersistent.queryZoneArea(zoneAreaQuery));
      } else {
        ZoneArea oldZoneArea = zoneAreaPersistent.getZoneAreaByPk(zoneArea.getAreaId());
        if (ToolUtil.isNullEntityAllFieldValue(oldZoneArea)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        zoneAreaSet.add(oldZoneArea);
      }
      if (ToolUtil.isNotEmpty(zoneAreaSet)) {
        zoneAreaPersistent.batchRemoveZoneArea(zoneAreaSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void batchRemoveZoneArea(Collection<ZoneArea> zoneAreas) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreas);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreas)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<ZoneArea> zoneAreaSet = new LinkedHashSet<>();
      for (ZoneArea zoneArea : zoneAreas) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
          ZoneAreaQuery zoneAreaQuery = new ZoneAreaQuery();
          BeanUtils.copyProperties(zoneArea, zoneAreaQuery);
          zoneAreaSet.addAll(zoneAreaPersistent.queryZoneArea(zoneAreaQuery));
        } else {
          ZoneArea oldZoneArea = zoneAreaPersistent.getZoneAreaByPk(zoneArea.getAreaId());
          if (ToolUtil.isNullEntityAllFieldValue(oldZoneArea)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          zoneAreaSet.add(oldZoneArea);
        }
      }
      if (ToolUtil.isNotEmpty(zoneAreaSet)) {
        zoneAreaPersistent.batchRemoveZoneArea(zoneAreaSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountZoneArea(ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      return zoneAreaPersistent.getCountZoneArea(zoneAreaQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneArea getZoneAreaByPk(String areaId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + areaId);
    }
    try {
      if (ToolUtil.isNullStr(areaId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaPersistent.getZoneAreaByPk(areaId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneArea> getAllZoneArea() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return zoneAreaPersistent.getAllZoneArea();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneArea> queryZoneArea(ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      return zoneAreaPersistent.queryZoneArea(zoneAreaQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneArea> pagingQueryZoneArea(Param param, ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaPersistent.pagingQueryZoneArea(param, zoneAreaQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneAreaVO getZoneAreaVOByPk(String areaId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + areaId);
    }
    try {
      if (ToolUtil.isNullStr(areaId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaPersistent.getZoneAreaVOByPk(areaId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaVO> getAllZoneAreaVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return zoneAreaPersistent.getAllZoneAreaVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaVO> queryZoneAreaVO(ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      return zoneAreaPersistent.queryZoneAreaVO(zoneAreaQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneAreaVO> pagingQueryZoneAreaVO(Param param, ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaPersistent.pagingQueryZoneAreaVO(param, zoneAreaQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

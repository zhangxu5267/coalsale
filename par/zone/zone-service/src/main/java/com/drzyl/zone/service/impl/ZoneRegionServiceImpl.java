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
import com.drzyl.zone.entity.ZoneRegion;
import com.drzyl.zone.persistent.IZoneRegionPersistent;
import com.drzyl.zone.query.ZoneRegionQuery;
import com.drzyl.zone.service.IZoneRegionService;
import com.drzyl.zone.vo.ZoneRegionVO;
import lombok.extern.log4j.Log4j2;

/**
 * 省市区 服务实现
 */
@Log4j2
@Service("com.drzyl.zone.ZoneRegionService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class ZoneRegionServiceImpl implements IZoneRegionService {

  public static final String LOG = "ZoneRegionService";

  @Resource(name = "com.drzyl.zone.ZoneRegionPersistent")
  private IZoneRegionPersistent zoneRegionPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public ZoneRegion saveZoneRegion(ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      zoneRegion.setRegionId(ToolUtil.getUUID());
      return zoneRegionPersistent.saveZoneRegion(zoneRegion);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<ZoneRegion> batchSaveZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (ZoneRegion zoneRegion : zoneRegions) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        zoneRegion.setRegionId(ToolUtil.getUUID());
      }
      return zoneRegionPersistent.batchSaveZoneRegion(zoneRegions);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public ZoneRegion updateZoneRegion(ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      ZoneRegion oldZoneRegion = zoneRegionPersistent.getZoneRegionByPk(zoneRegion.getRegionId());
      if (ToolUtil.isNullEntityAllFieldValue(oldZoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneRegionPersistent.updateZoneRegion(zoneRegion);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<ZoneRegion> batchUpdateZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (ZoneRegion zoneRegion : zoneRegions) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        ZoneRegion oldZoneRegion = zoneRegionPersistent.getZoneRegionByPk(zoneRegion.getRegionId());
        if (ToolUtil.isNullEntityAllFieldValue(oldZoneRegion)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return zoneRegionPersistent.batchUpdateZoneRegion(zoneRegions);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeZoneRegion(ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<ZoneRegion> zoneRegionSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
        ZoneRegionQuery zoneRegionQuery = new ZoneRegionQuery();
        BeanUtils.copyProperties(zoneRegion, zoneRegionQuery);
        zoneRegionSet.addAll(zoneRegionPersistent.queryZoneRegion(zoneRegionQuery));
      } else {
        ZoneRegion oldZoneRegion = zoneRegionPersistent.getZoneRegionByPk(zoneRegion.getRegionId());
        if (ToolUtil.isNullEntityAllFieldValue(oldZoneRegion)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        zoneRegionSet.add(oldZoneRegion);
      }
      if (ToolUtil.isNotEmpty(zoneRegionSet)) {
        zoneRegionPersistent.batchRemoveZoneRegion(zoneRegionSet);
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
  public void batchRemoveZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<ZoneRegion> zoneRegionSet = new LinkedHashSet<>();
      for (ZoneRegion zoneRegion : zoneRegions) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
          ZoneRegionQuery zoneRegionQuery = new ZoneRegionQuery();
          BeanUtils.copyProperties(zoneRegion, zoneRegionQuery);
          zoneRegionSet.addAll(zoneRegionPersistent.queryZoneRegion(zoneRegionQuery));
        } else {
          ZoneRegion oldZoneRegion = zoneRegionPersistent.getZoneRegionByPk(zoneRegion.getRegionId());
          if (ToolUtil.isNullEntityAllFieldValue(oldZoneRegion)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          zoneRegionSet.add(oldZoneRegion);
        }
      }
      if (ToolUtil.isNotEmpty(zoneRegionSet)) {
        zoneRegionPersistent.batchRemoveZoneRegion(zoneRegionSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountZoneRegion(ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      return zoneRegionPersistent.getCountZoneRegion(zoneRegionQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneRegion getZoneRegionByPk(String regionId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + regionId);
    }
    try {
      if (ToolUtil.isNullStr(regionId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneRegionPersistent.getZoneRegionByPk(regionId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegion> getAllZoneRegion() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return zoneRegionPersistent.getAllZoneRegion();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegion> queryZoneRegion(ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      return zoneRegionPersistent.queryZoneRegion(zoneRegionQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneRegion> pagingQueryZoneRegion(Param param, ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneRegionPersistent.pagingQueryZoneRegion(param, zoneRegionQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneRegionVO getZoneRegionVOByPk(String regionId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + regionId);
    }
    try {
      if (ToolUtil.isNullStr(regionId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneRegionPersistent.getZoneRegionVOByPk(regionId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegionVO> getAllZoneRegionVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return zoneRegionPersistent.getAllZoneRegionVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegionVO> queryZoneRegionVO(ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      return zoneRegionPersistent.queryZoneRegionVO(zoneRegionQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneRegionVO> pagingQueryZoneRegionVO(Param param, ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneRegionPersistent.pagingQueryZoneRegionVO(param, zoneRegionQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

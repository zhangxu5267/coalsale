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
import com.drzyl.zone.entity.ZoneAreaRegionTepe;
import com.drzyl.zone.persistent.IZoneAreaRegionTepePersistent;
import com.drzyl.zone.query.ZoneAreaRegionTepeQuery;
import com.drzyl.zone.service.IZoneAreaRegionTepeService;
import com.drzyl.zone.vo.ZoneAreaRegionTepeVO;
import lombok.extern.log4j.Log4j2;

/**
 * 区域-省市区中间表 服务实现
 */
@Log4j2
@Service("com.drzyl.zone.ZoneAreaRegionTepeService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class ZoneAreaRegionTepeServiceImpl implements IZoneAreaRegionTepeService {

  public static final String LOG = "ZoneAreaRegionTepeService";

  @Resource(name = "com.drzyl.zone.ZoneAreaRegionTepePersistent")
  private IZoneAreaRegionTepePersistent zoneAreaRegionTepePersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public ZoneAreaRegionTepe saveZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      zoneAreaRegionTepe.setId(ToolUtil.getUUID());
      return zoneAreaRegionTepePersistent.saveZoneAreaRegionTepe(zoneAreaRegionTepe);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<ZoneAreaRegionTepe> batchSaveZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (ZoneAreaRegionTepe zoneAreaRegionTepe : zoneAreaRegionTepes) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        zoneAreaRegionTepe.setId(ToolUtil.getUUID());
      }
      return zoneAreaRegionTepePersistent.batchSaveZoneAreaRegionTepe(zoneAreaRegionTepes);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public ZoneAreaRegionTepe updateZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      ZoneAreaRegionTepe oldZoneAreaRegionTepe = zoneAreaRegionTepePersistent.getZoneAreaRegionTepeByPk(zoneAreaRegionTepe.getId());
      if (ToolUtil.isNullEntityAllFieldValue(oldZoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaRegionTepePersistent.updateZoneAreaRegionTepe(zoneAreaRegionTepe);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<ZoneAreaRegionTepe> batchUpdateZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (ZoneAreaRegionTepe zoneAreaRegionTepe : zoneAreaRegionTepes) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        ZoneAreaRegionTepe oldZoneAreaRegionTepe = zoneAreaRegionTepePersistent.getZoneAreaRegionTepeByPk(zoneAreaRegionTepe.getId());
        if (ToolUtil.isNullEntityAllFieldValue(oldZoneAreaRegionTepe)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return zoneAreaRegionTepePersistent.batchUpdateZoneAreaRegionTepe(zoneAreaRegionTepes);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<ZoneAreaRegionTepe> zoneAreaRegionTepeSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
        ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery = new ZoneAreaRegionTepeQuery();
        BeanUtils.copyProperties(zoneAreaRegionTepe, zoneAreaRegionTepeQuery);
        zoneAreaRegionTepeSet.addAll(zoneAreaRegionTepePersistent.queryZoneAreaRegionTepe(zoneAreaRegionTepeQuery));
      } else {
        ZoneAreaRegionTepe oldZoneAreaRegionTepe = zoneAreaRegionTepePersistent.getZoneAreaRegionTepeByPk(zoneAreaRegionTepe.getId());
        if (ToolUtil.isNullEntityAllFieldValue(oldZoneAreaRegionTepe)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        zoneAreaRegionTepeSet.add(oldZoneAreaRegionTepe);
      }
      if (ToolUtil.isNotEmpty(zoneAreaRegionTepeSet)) {
        zoneAreaRegionTepePersistent.batchRemoveZoneAreaRegionTepe(zoneAreaRegionTepeSet);
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
  public void batchRemoveZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<ZoneAreaRegionTepe> zoneAreaRegionTepeSet = new LinkedHashSet<>();
      for (ZoneAreaRegionTepe zoneAreaRegionTepe : zoneAreaRegionTepes) {
        if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
          ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery = new ZoneAreaRegionTepeQuery();
          BeanUtils.copyProperties(zoneAreaRegionTepe, zoneAreaRegionTepeQuery);
          zoneAreaRegionTepeSet.addAll(zoneAreaRegionTepePersistent.queryZoneAreaRegionTepe(zoneAreaRegionTepeQuery));
        } else {
          ZoneAreaRegionTepe oldZoneAreaRegionTepe = zoneAreaRegionTepePersistent.getZoneAreaRegionTepeByPk(zoneAreaRegionTepe.getId());
          if (ToolUtil.isNullEntityAllFieldValue(oldZoneAreaRegionTepe)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          zoneAreaRegionTepeSet.add(oldZoneAreaRegionTepe);
        }
      }
      if (ToolUtil.isNotEmpty(zoneAreaRegionTepeSet)) {
        zoneAreaRegionTepePersistent.batchRemoveZoneAreaRegionTepe(zoneAreaRegionTepeSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountZoneAreaRegionTepe(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      return zoneAreaRegionTepePersistent.getCountZoneAreaRegionTepe(zoneAreaRegionTepeQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneAreaRegionTepe getZoneAreaRegionTepeByPk(String id) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + id);
    }
    try {
      if (ToolUtil.isNullStr(id)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaRegionTepePersistent.getZoneAreaRegionTepeByPk(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepe> getAllZoneAreaRegionTepe() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return zoneAreaRegionTepePersistent.getAllZoneAreaRegionTepe();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepe> queryZoneAreaRegionTepe(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      return zoneAreaRegionTepePersistent.queryZoneAreaRegionTepe(zoneAreaRegionTepeQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneAreaRegionTepe> pagingQueryZoneAreaRegionTepe(Param param, ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaRegionTepePersistent.pagingQueryZoneAreaRegionTepe(param, zoneAreaRegionTepeQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneAreaRegionTepeVO getZoneAreaRegionTepeVOByPk(String id) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + id);
    }
    try {
      if (ToolUtil.isNullStr(id)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaRegionTepePersistent.getZoneAreaRegionTepeVOByPk(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepeVO> getAllZoneAreaRegionTepeVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return zoneAreaRegionTepePersistent.getAllZoneAreaRegionTepeVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepeVO> queryZoneAreaRegionTepeVO(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      return zoneAreaRegionTepePersistent.queryZoneAreaRegionTepeVO(zoneAreaRegionTepeQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneAreaRegionTepeVO> pagingQueryZoneAreaRegionTepeVO(Param param, ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return zoneAreaRegionTepePersistent.pagingQueryZoneAreaRegionTepeVO(param, zoneAreaRegionTepeQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

package com.drzyl.cus.service.impl;

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
import com.drzyl.cus.entity.CusAddrDis;
import com.drzyl.cus.persistent.ICusAddrDisPersistent;
import com.drzyl.cus.query.CusAddrDisQuery;
import com.drzyl.cus.service.ICusAddrDisService;
import com.drzyl.cus.vo.CusAddrDisVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户收货地址表 服务实现
 */
@Log4j2
@Service("com.drzyl.cus.CusAddrDisService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusAddrDisServiceImpl implements ICusAddrDisService {

  public static final String LOG = "CusAddrDisService";

  @Resource(name = "com.drzyl.cus.CusAddrDisPersistent")
  private ICusAddrDisPersistent cusAddrDisPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusAddrDis saveCusAddrDis(CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAddrDis.setCusAddrDisId(ToolUtil.getUUID());
      return cusAddrDisPersistent.saveCusAddrDis(cusAddrDis);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusAddrDis> batchSaveCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusAddrDis cusAddrDis : cusAddrDiss) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusAddrDis.setCusAddrDisId(ToolUtil.getUUID());
      }
      return cusAddrDisPersistent.batchSaveCusAddrDis(cusAddrDiss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusAddrDis updateCusAddrDis(CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      CusAddrDis oldCusAddrDis = cusAddrDisPersistent.getCusAddrDisByPk(cusAddrDis.getCusAddrDisId());
      if (ToolUtil.isNullEntityAllFieldValue(oldCusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddrDisPersistent.updateCusAddrDis(cusAddrDis);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusAddrDis> batchUpdateCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusAddrDis cusAddrDis : cusAddrDiss) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        CusAddrDis oldCusAddrDis = cusAddrDisPersistent.getCusAddrDisByPk(cusAddrDis.getCusAddrDisId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusAddrDis)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return cusAddrDisPersistent.batchUpdateCusAddrDis(cusAddrDiss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeCusAddrDis(CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusAddrDis> cusAddrDisSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
        CusAddrDisQuery cusAddrDisQuery = new CusAddrDisQuery();
        BeanUtils.copyProperties(cusAddrDis, cusAddrDisQuery);
        cusAddrDisSet.addAll(cusAddrDisPersistent.queryCusAddrDis(cusAddrDisQuery));
      } else {
        CusAddrDis oldCusAddrDis = cusAddrDisPersistent.getCusAddrDisByPk(cusAddrDis.getCusAddrDisId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusAddrDis)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusAddrDisSet.add(oldCusAddrDis);
      }
      if (ToolUtil.isNotEmpty(cusAddrDisSet)) {
        cusAddrDisPersistent.batchRemoveCusAddrDis(cusAddrDisSet);
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
  public void batchRemoveCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusAddrDis> cusAddrDisSet = new LinkedHashSet<>();
      for (CusAddrDis cusAddrDis : cusAddrDiss) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
          CusAddrDisQuery cusAddrDisQuery = new CusAddrDisQuery();
          BeanUtils.copyProperties(cusAddrDis, cusAddrDisQuery);
          cusAddrDisSet.addAll(cusAddrDisPersistent.queryCusAddrDis(cusAddrDisQuery));
        } else {
          CusAddrDis oldCusAddrDis = cusAddrDisPersistent.getCusAddrDisByPk(cusAddrDis.getCusAddrDisId());
          if (ToolUtil.isNullEntityAllFieldValue(oldCusAddrDis)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          cusAddrDisSet.add(oldCusAddrDis);
        }
      }
      if (ToolUtil.isNotEmpty(cusAddrDisSet)) {
        cusAddrDisPersistent.batchRemoveCusAddrDis(cusAddrDisSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusAddrDis(CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      return cusAddrDisPersistent.getCountCusAddrDis(cusAddrDisQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAddrDis getCusAddrDisByPk(String cusAddrDisId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisId);
    }
    try {
      if (ToolUtil.isNullStr(cusAddrDisId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddrDisPersistent.getCusAddrDisByPk(cusAddrDisId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDis> getAllCusAddrDis() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusAddrDisPersistent.getAllCusAddrDis();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDis> queryCusAddrDis(CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      return cusAddrDisPersistent.queryCusAddrDis(cusAddrDisQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAddrDis> pagingQueryCusAddrDis(Param param, CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddrDisPersistent.pagingQueryCusAddrDis(param, cusAddrDisQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAddrDisVO getCusAddrDisVOByPk(String cusAddrDisId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisId);
    }
    try {
      if (ToolUtil.isNullStr(cusAddrDisId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddrDisPersistent.getCusAddrDisVOByPk(cusAddrDisId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDisVO> getAllCusAddrDisVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusAddrDisPersistent.getAllCusAddrDisVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDisVO> queryCusAddrDisVO(CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      return cusAddrDisPersistent.queryCusAddrDisVO(cusAddrDisQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAddrDisVO> pagingQueryCusAddrDisVO(Param param, CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddrDisPersistent.pagingQueryCusAddrDisVO(param, cusAddrDisQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

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
import com.drzyl.cus.entity.CusBase;
import com.drzyl.cus.persistent.ICusBasePersistent;
import com.drzyl.cus.query.CusBaseQuery;
import com.drzyl.cus.service.ICusBaseService;
import com.drzyl.cus.vo.CusBaseVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户基础信息 服务实现
 */
@Log4j2
@Service("com.drzyl.cus.CusBaseService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusBaseServiceImpl implements ICusBaseService {

  public static final String LOG = "CusBaseService";

  @Resource(name = "com.drzyl.cus.CusBasePersistent")
  private ICusBasePersistent cusBasePersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusBase saveCusBase(CusBase cusBase) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBase);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusBase.setCusBaseId(ToolUtil.getUUID());
      return cusBasePersistent.saveCusBase(cusBase);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusBase> batchSaveCusBase(Collection<CusBase> cusBases) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBases);
    }
    try {
      if (ToolUtil.isEmpty(cusBases)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusBase cusBase : cusBases) {
        if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusBase.setCusBaseId(ToolUtil.getUUID());
      }
      return cusBasePersistent.batchSaveCusBase(cusBases);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusBase updateCusBase(CusBase cusBase) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBase);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusBase.getCusBaseId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      CusBase oldCusBase = cusBasePersistent.getCusBaseByPk(cusBase.getCusBaseId());
      if (ToolUtil.isNullEntityAllFieldValue(oldCusBase)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBasePersistent.updateCusBase(cusBase);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusBase> batchUpdateCusBase(Collection<CusBase> cusBases) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBases);
    }
    try {
      if (ToolUtil.isEmpty(cusBases)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusBase cusBase : cusBases) {
        if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusBase.getCusBaseId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        CusBase oldCusBase = cusBasePersistent.getCusBaseByPk(cusBase.getCusBaseId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusBase)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return cusBasePersistent.batchUpdateCusBase(cusBases);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeCusBase(CusBase cusBase) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBase);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusBase> cusBaseSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(cusBase.getCusBaseId())) {
        CusBaseQuery cusBaseQuery = new CusBaseQuery();
        BeanUtils.copyProperties(cusBase, cusBaseQuery);
        cusBaseSet.addAll(cusBasePersistent.queryCusBase(cusBaseQuery));
      } else {
        CusBase oldCusBase = cusBasePersistent.getCusBaseByPk(cusBase.getCusBaseId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusBase)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusBaseSet.add(oldCusBase);
      }
      if (ToolUtil.isNotEmpty(cusBaseSet)) {
        cusBasePersistent.batchRemoveCusBase(cusBaseSet);
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
  public void batchRemoveCusBase(Collection<CusBase> cusBases) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBases);
    }
    try {
      if (ToolUtil.isEmpty(cusBases)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusBase> cusBaseSet = new LinkedHashSet<>();
      for (CusBase cusBase : cusBases) {
        if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusBase.getCusBaseId())) {
          CusBaseQuery cusBaseQuery = new CusBaseQuery();
          BeanUtils.copyProperties(cusBase, cusBaseQuery);
          cusBaseSet.addAll(cusBasePersistent.queryCusBase(cusBaseQuery));
        } else {
          CusBase oldCusBase = cusBasePersistent.getCusBaseByPk(cusBase.getCusBaseId());
          if (ToolUtil.isNullEntityAllFieldValue(oldCusBase)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          cusBaseSet.add(oldCusBase);
        }
      }
      if (ToolUtil.isNotEmpty(cusBaseSet)) {
        cusBasePersistent.batchRemoveCusBase(cusBaseSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusBase(CusBaseQuery cusBaseQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseQuery);
    }
    try {
      return cusBasePersistent.getCountCusBase(cusBaseQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusBase getCusBaseByPk(String cusBaseId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseId);
    }
    try {
      if (ToolUtil.isNullStr(cusBaseId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBasePersistent.getCusBaseByPk(cusBaseId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBase> getAllCusBase() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusBasePersistent.getAllCusBase();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBase> queryCusBase(CusBaseQuery cusBaseQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseQuery);
    }
    try {
      return cusBasePersistent.queryCusBase(cusBaseQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusBase> pagingQueryCusBase(Param param, CusBaseQuery cusBaseQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBasePersistent.pagingQueryCusBase(param, cusBaseQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusBaseVO getCusBaseVOByPk(String cusBaseId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseId);
    }
    try {
      if (ToolUtil.isNullStr(cusBaseId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBasePersistent.getCusBaseVOByPk(cusBaseId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseVO> getAllCusBaseVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusBasePersistent.getAllCusBaseVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseVO> queryCusBaseVO(CusBaseQuery cusBaseQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseQuery);
    }
    try {
      return cusBasePersistent.queryCusBaseVO(cusBaseQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusBaseVO> pagingQueryCusBaseVO(Param param, CusBaseQuery cusBaseQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBasePersistent.pagingQueryCusBaseVO(param, cusBaseQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

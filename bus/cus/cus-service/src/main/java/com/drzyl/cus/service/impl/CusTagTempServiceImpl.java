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
import com.drzyl.cus.entity.CusTagTemp;
import com.drzyl.cus.persistent.ICusTagTempPersistent;
import com.drzyl.cus.query.CusTagTempQuery;
import com.drzyl.cus.service.ICusTagTempService;
import com.drzyl.cus.vo.CusTagTempVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户标签中间表 服务实现
 */
@Log4j2
@Service("com.drzyl.cus.CusTagTempService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusTagTempServiceImpl implements ICusTagTempService {

  public static final String LOG = "CusTagTempService";

  @Resource(name = "com.drzyl.cus.CusTagTempPersistent")
  private ICusTagTempPersistent cusTagTempPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusTagTemp saveCusTagTemp(CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusTagTemp.setCusTagTempId(ToolUtil.getUUID());
      return cusTagTempPersistent.saveCusTagTemp(cusTagTemp);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusTagTemp> batchSaveCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusTagTemp cusTagTemp : cusTagTemps) {
        if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusTagTemp.setCusTagTempId(ToolUtil.getUUID());
      }
      return cusTagTempPersistent.batchSaveCusTagTemp(cusTagTemps);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusTagTemp updateCusTagTemp(CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      CusTagTemp oldCusTagTemp = cusTagTempPersistent.getCusTagTempByPk(cusTagTemp.getCusTagTempId());
      if (ToolUtil.isNullEntityAllFieldValue(oldCusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagTempPersistent.updateCusTagTemp(cusTagTemp);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusTagTemp> batchUpdateCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusTagTemp cusTagTemp : cusTagTemps) {
        if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        CusTagTemp oldCusTagTemp = cusTagTempPersistent.getCusTagTempByPk(cusTagTemp.getCusTagTempId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusTagTemp)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return cusTagTempPersistent.batchUpdateCusTagTemp(cusTagTemps);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeCusTagTemp(CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusTagTemp> cusTagTempSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
        CusTagTempQuery cusTagTempQuery = new CusTagTempQuery();
        BeanUtils.copyProperties(cusTagTemp, cusTagTempQuery);
        cusTagTempSet.addAll(cusTagTempPersistent.queryCusTagTemp(cusTagTempQuery));
      } else {
        CusTagTemp oldCusTagTemp = cusTagTempPersistent.getCusTagTempByPk(cusTagTemp.getCusTagTempId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusTagTemp)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusTagTempSet.add(oldCusTagTemp);
      }
      if (ToolUtil.isNotEmpty(cusTagTempSet)) {
        cusTagTempPersistent.batchRemoveCusTagTemp(cusTagTempSet);
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
  public void batchRemoveCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusTagTemp> cusTagTempSet = new LinkedHashSet<>();
      for (CusTagTemp cusTagTemp : cusTagTemps) {
        if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
          CusTagTempQuery cusTagTempQuery = new CusTagTempQuery();
          BeanUtils.copyProperties(cusTagTemp, cusTagTempQuery);
          cusTagTempSet.addAll(cusTagTempPersistent.queryCusTagTemp(cusTagTempQuery));
        } else {
          CusTagTemp oldCusTagTemp = cusTagTempPersistent.getCusTagTempByPk(cusTagTemp.getCusTagTempId());
          if (ToolUtil.isNullEntityAllFieldValue(oldCusTagTemp)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          cusTagTempSet.add(oldCusTagTemp);
        }
      }
      if (ToolUtil.isNotEmpty(cusTagTempSet)) {
        cusTagTempPersistent.batchRemoveCusTagTemp(cusTagTempSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusTagTemp(CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      return cusTagTempPersistent.getCountCusTagTemp(cusTagTempQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusTagTemp getCusTagTempByPk(String cusTagTempId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempId);
    }
    try {
      if (ToolUtil.isNullStr(cusTagTempId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagTempPersistent.getCusTagTempByPk(cusTagTempId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTemp> getAllCusTagTemp() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusTagTempPersistent.getAllCusTagTemp();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTemp> queryCusTagTemp(CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      return cusTagTempPersistent.queryCusTagTemp(cusTagTempQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusTagTemp> pagingQueryCusTagTemp(Param param, CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagTempPersistent.pagingQueryCusTagTemp(param, cusTagTempQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusTagTempVO getCusTagTempVOByPk(String cusTagTempId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempId);
    }
    try {
      if (ToolUtil.isNullStr(cusTagTempId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagTempPersistent.getCusTagTempVOByPk(cusTagTempId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTempVO> getAllCusTagTempVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusTagTempPersistent.getAllCusTagTempVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTempVO> queryCusTagTempVO(CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      return cusTagTempPersistent.queryCusTagTempVO(cusTagTempQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusTagTempVO> pagingQueryCusTagTempVO(Param param, CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagTempPersistent.pagingQueryCusTagTempVO(param, cusTagTempQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

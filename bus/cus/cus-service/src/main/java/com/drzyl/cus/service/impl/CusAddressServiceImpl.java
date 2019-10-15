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
import com.drzyl.cus.entity.CusAddress;
import com.drzyl.cus.persistent.ICusAddressPersistent;
import com.drzyl.cus.query.CusAddressQuery;
import com.drzyl.cus.service.ICusAddressService;
import com.drzyl.cus.vo.CusAddressVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户收货单位 服务实现
 */
@Log4j2
@Service("com.drzyl.cus.CusAddressService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusAddressServiceImpl implements ICusAddressService {

  public static final String LOG = "CusAddressService";

  @Resource(name = "com.drzyl.cus.CusAddressPersistent")
  private ICusAddressPersistent cusAddressPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusAddress saveCusAddress(CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddress);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAddress.setCusAddressId(ToolUtil.getUUID());
      return cusAddressPersistent.saveCusAddress(cusAddress);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusAddress> batchSaveCusAddress(Collection<CusAddress> cusAddresss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddresss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddresss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusAddress cusAddress : cusAddresss) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusAddress.setCusAddressId(ToolUtil.getUUID());
      }
      return cusAddressPersistent.batchSaveCusAddress(cusAddresss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusAddress updateCusAddress(CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddress);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddress.getCusAddressId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      CusAddress oldCusAddress = cusAddressPersistent.getCusAddressByPk(cusAddress.getCusAddressId());
      if (ToolUtil.isNullEntityAllFieldValue(oldCusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddressPersistent.updateCusAddress(cusAddress);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusAddress> batchUpdateCusAddress(Collection<CusAddress> cusAddresss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddresss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddresss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusAddress cusAddress : cusAddresss) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusAddress.getCusAddressId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        CusAddress oldCusAddress = cusAddressPersistent.getCusAddressByPk(cusAddress.getCusAddressId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusAddress)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return cusAddressPersistent.batchUpdateCusAddress(cusAddresss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeCusAddress(CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddress);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusAddress> cusAddressSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(cusAddress.getCusAddressId())) {
        CusAddressQuery cusAddressQuery = new CusAddressQuery();
        BeanUtils.copyProperties(cusAddress, cusAddressQuery);
        cusAddressSet.addAll(cusAddressPersistent.queryCusAddress(cusAddressQuery));
      } else {
        CusAddress oldCusAddress = cusAddressPersistent.getCusAddressByPk(cusAddress.getCusAddressId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusAddress)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusAddressSet.add(oldCusAddress);
      }
      if (ToolUtil.isNotEmpty(cusAddressSet)) {
        cusAddressPersistent.batchRemoveCusAddress(cusAddressSet);
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
  public void batchRemoveCusAddress(Collection<CusAddress> cusAddresss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddresss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddresss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusAddress> cusAddressSet = new LinkedHashSet<>();
      for (CusAddress cusAddress : cusAddresss) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusAddress.getCusAddressId())) {
          CusAddressQuery cusAddressQuery = new CusAddressQuery();
          BeanUtils.copyProperties(cusAddress, cusAddressQuery);
          cusAddressSet.addAll(cusAddressPersistent.queryCusAddress(cusAddressQuery));
        } else {
          CusAddress oldCusAddress = cusAddressPersistent.getCusAddressByPk(cusAddress.getCusAddressId());
          if (ToolUtil.isNullEntityAllFieldValue(oldCusAddress)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          cusAddressSet.add(oldCusAddress);
        }
      }
      if (ToolUtil.isNotEmpty(cusAddressSet)) {
        cusAddressPersistent.batchRemoveCusAddress(cusAddressSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusAddress(CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    try {
      return cusAddressPersistent.getCountCusAddress(cusAddressQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAddress getCusAddressByPk(String cusAddressId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddressId);
    }
    try {
      if (ToolUtil.isNullStr(cusAddressId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddressPersistent.getCusAddressByPk(cusAddressId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddress> getAllCusAddress() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusAddressPersistent.getAllCusAddress();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddress> queryCusAddress(CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    try {
      return cusAddressPersistent.queryCusAddress(cusAddressQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAddress> pagingQueryCusAddress(Param param, CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddressPersistent.pagingQueryCusAddress(param, cusAddressQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAddressVO getCusAddressVOByPk(String cusAddressId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddressId);
    }
    try {
      if (ToolUtil.isNullStr(cusAddressId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddressPersistent.getCusAddressVOByPk(cusAddressId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddressVO> getAllCusAddressVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusAddressPersistent.getAllCusAddressVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddressVO> queryCusAddressVO(CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    try {
      return cusAddressPersistent.queryCusAddressVO(cusAddressQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAddressVO> pagingQueryCusAddressVO(Param param, CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAddressPersistent.pagingQueryCusAddressVO(param, cusAddressQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

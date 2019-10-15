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
import com.drzyl.cus.entity.CusBaseInfo;
import com.drzyl.cus.persistent.ICusBaseInfoPersistent;
import com.drzyl.cus.query.CusBaseInfoQuery;
import com.drzyl.cus.service.ICusBaseInfoService;
import com.drzyl.cus.vo.CusBaseInfoVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户详细信息 服务实现
 */
@Log4j2
@Service("com.drzyl.cus.CusBaseInfoService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusBaseInfoServiceImpl implements ICusBaseInfoService {

  public static final String LOG = "CusBaseInfoService";

  @Resource(name = "com.drzyl.cus.CusBaseInfoPersistent")
  private ICusBaseInfoPersistent cusBaseInfoPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusBaseInfo saveCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusBaseInfo.setCusBaseInfoId(ToolUtil.getUUID());
      return cusBaseInfoPersistent.saveCusBaseInfo(cusBaseInfo);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusBaseInfo> batchSaveCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusBaseInfo cusBaseInfo : cusBaseInfos) {
        if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusBaseInfo.setCusBaseInfoId(ToolUtil.getUUID());
      }
      return cusBaseInfoPersistent.batchSaveCusBaseInfo(cusBaseInfos);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusBaseInfo updateCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      CusBaseInfo oldCusBaseInfo = cusBaseInfoPersistent.getCusBaseInfoByPk(cusBaseInfo.getCusBaseInfoId());
      if (ToolUtil.isNullEntityAllFieldValue(oldCusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBaseInfoPersistent.updateCusBaseInfo(cusBaseInfo);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusBaseInfo> batchUpdateCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusBaseInfo cusBaseInfo : cusBaseInfos) {
        if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        CusBaseInfo oldCusBaseInfo = cusBaseInfoPersistent.getCusBaseInfoByPk(cusBaseInfo.getCusBaseInfoId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusBaseInfo)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return cusBaseInfoPersistent.batchUpdateCusBaseInfo(cusBaseInfos);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusBaseInfo> cusBaseInfoSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
        CusBaseInfoQuery cusBaseInfoQuery = new CusBaseInfoQuery();
        BeanUtils.copyProperties(cusBaseInfo, cusBaseInfoQuery);
        cusBaseInfoSet.addAll(cusBaseInfoPersistent.queryCusBaseInfo(cusBaseInfoQuery));
      } else {
        CusBaseInfo oldCusBaseInfo = cusBaseInfoPersistent.getCusBaseInfoByPk(cusBaseInfo.getCusBaseInfoId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusBaseInfo)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusBaseInfoSet.add(oldCusBaseInfo);
      }
      if (ToolUtil.isNotEmpty(cusBaseInfoSet)) {
        cusBaseInfoPersistent.batchRemoveCusBaseInfo(cusBaseInfoSet);
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
  public void batchRemoveCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusBaseInfo> cusBaseInfoSet = new LinkedHashSet<>();
      for (CusBaseInfo cusBaseInfo : cusBaseInfos) {
        if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
          CusBaseInfoQuery cusBaseInfoQuery = new CusBaseInfoQuery();
          BeanUtils.copyProperties(cusBaseInfo, cusBaseInfoQuery);
          cusBaseInfoSet.addAll(cusBaseInfoPersistent.queryCusBaseInfo(cusBaseInfoQuery));
        } else {
          CusBaseInfo oldCusBaseInfo = cusBaseInfoPersistent.getCusBaseInfoByPk(cusBaseInfo.getCusBaseInfoId());
          if (ToolUtil.isNullEntityAllFieldValue(oldCusBaseInfo)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          cusBaseInfoSet.add(oldCusBaseInfo);
        }
      }
      if (ToolUtil.isNotEmpty(cusBaseInfoSet)) {
        cusBaseInfoPersistent.batchRemoveCusBaseInfo(cusBaseInfoSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusBaseInfo(CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      return cusBaseInfoPersistent.getCountCusBaseInfo(cusBaseInfoQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusBaseInfo getCusBaseInfoByPk(String cusBaseInfoId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoId);
    }
    try {
      if (ToolUtil.isNullStr(cusBaseInfoId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBaseInfoPersistent.getCusBaseInfoByPk(cusBaseInfoId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfo> getAllCusBaseInfo() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusBaseInfoPersistent.getAllCusBaseInfo();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfo> queryCusBaseInfo(CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      return cusBaseInfoPersistent.queryCusBaseInfo(cusBaseInfoQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusBaseInfo> pagingQueryCusBaseInfo(Param param, CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBaseInfoPersistent.pagingQueryCusBaseInfo(param, cusBaseInfoQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusBaseInfoVO getCusBaseInfoVOByPk(String cusBaseInfoId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoId);
    }
    try {
      if (ToolUtil.isNullStr(cusBaseInfoId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBaseInfoPersistent.getCusBaseInfoVOByPk(cusBaseInfoId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfoVO> getAllCusBaseInfoVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusBaseInfoPersistent.getAllCusBaseInfoVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfoVO> queryCusBaseInfoVO(CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      return cusBaseInfoPersistent.queryCusBaseInfoVO(cusBaseInfoQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusBaseInfoVO> pagingQueryCusBaseInfoVO(Param param, CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusBaseInfoPersistent.pagingQueryCusBaseInfoVO(param, cusBaseInfoQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

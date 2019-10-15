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
import com.drzyl.cus.entity.CusAgent;
import com.drzyl.cus.persistent.ICusAgentPersistent;
import com.drzyl.cus.query.CusAgentQuery;
import com.drzyl.cus.service.ICusAgentService;
import com.drzyl.cus.vo.CusAgentVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户委托信息 服务实现
 */
@Log4j2
@Service("com.drzyl.cus.CusAgentService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusAgentServiceImpl implements ICusAgentService {

  public static final String LOG = "CusAgentService";

  @Resource(name = "com.drzyl.cus.CusAgentPersistent")
  private ICusAgentPersistent cusAgentPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusAgent saveCusAgent(CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgent);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAgent.setCusAgentId(ToolUtil.getUUID());
      return cusAgentPersistent.saveCusAgent(cusAgent);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusAgent> batchSaveCusAgent(Collection<CusAgent> cusAgents) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgents);
    }
    try {
      if (ToolUtil.isEmpty(cusAgents)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusAgent cusAgent : cusAgents) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusAgent.setCusAgentId(ToolUtil.getUUID());
      }
      return cusAgentPersistent.batchSaveCusAgent(cusAgents);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusAgent updateCusAgent(CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgent);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAgent.getCusAgentId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      CusAgent oldCusAgent = cusAgentPersistent.getCusAgentByPk(cusAgent.getCusAgentId());
      if (ToolUtil.isNullEntityAllFieldValue(oldCusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAgentPersistent.updateCusAgent(cusAgent);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusAgent> batchUpdateCusAgent(Collection<CusAgent> cusAgents) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgents);
    }
    try {
      if (ToolUtil.isEmpty(cusAgents)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusAgent cusAgent : cusAgents) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusAgent.getCusAgentId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        CusAgent oldCusAgent = cusAgentPersistent.getCusAgentByPk(cusAgent.getCusAgentId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusAgent)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return cusAgentPersistent.batchUpdateCusAgent(cusAgents);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeCusAgent(CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgent);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusAgent> cusAgentSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(cusAgent.getCusAgentId())) {
        CusAgentQuery cusAgentQuery = new CusAgentQuery();
        BeanUtils.copyProperties(cusAgent, cusAgentQuery);
        cusAgentSet.addAll(cusAgentPersistent.queryCusAgent(cusAgentQuery));
      } else {
        CusAgent oldCusAgent = cusAgentPersistent.getCusAgentByPk(cusAgent.getCusAgentId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusAgent)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusAgentSet.add(oldCusAgent);
      }
      if (ToolUtil.isNotEmpty(cusAgentSet)) {
        cusAgentPersistent.batchRemoveCusAgent(cusAgentSet);
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
  public void batchRemoveCusAgent(Collection<CusAgent> cusAgents) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgents);
    }
    try {
      if (ToolUtil.isEmpty(cusAgents)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusAgent> cusAgentSet = new LinkedHashSet<>();
      for (CusAgent cusAgent : cusAgents) {
        if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusAgent.getCusAgentId())) {
          CusAgentQuery cusAgentQuery = new CusAgentQuery();
          BeanUtils.copyProperties(cusAgent, cusAgentQuery);
          cusAgentSet.addAll(cusAgentPersistent.queryCusAgent(cusAgentQuery));
        } else {
          CusAgent oldCusAgent = cusAgentPersistent.getCusAgentByPk(cusAgent.getCusAgentId());
          if (ToolUtil.isNullEntityAllFieldValue(oldCusAgent)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          cusAgentSet.add(oldCusAgent);
        }
      }
      if (ToolUtil.isNotEmpty(cusAgentSet)) {
        cusAgentPersistent.batchRemoveCusAgent(cusAgentSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusAgent(CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    try {
      return cusAgentPersistent.getCountCusAgent(cusAgentQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAgent getCusAgentByPk(String cusAgentId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgentId);
    }
    try {
      if (ToolUtil.isNullStr(cusAgentId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAgentPersistent.getCusAgentByPk(cusAgentId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAgent> getAllCusAgent() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusAgentPersistent.getAllCusAgent();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAgent> queryCusAgent(CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    try {
      return cusAgentPersistent.queryCusAgent(cusAgentQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAgent> pagingQueryCusAgent(Param param, CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAgentPersistent.pagingQueryCusAgent(param, cusAgentQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAgentVO getCusAgentVOByPk(String cusAgentId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgentId);
    }
    try {
      if (ToolUtil.isNullStr(cusAgentId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAgentPersistent.getCusAgentVOByPk(cusAgentId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAgentVO> getAllCusAgentVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusAgentPersistent.getAllCusAgentVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAgentVO> queryCusAgentVO(CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    try {
      return cusAgentPersistent.queryCusAgentVO(cusAgentQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAgentVO> pagingQueryCusAgentVO(Param param, CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusAgentPersistent.pagingQueryCusAgentVO(param, cusAgentQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

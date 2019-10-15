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
import com.drzyl.cus.entity.CusTag;
import com.drzyl.cus.persistent.ICusTagPersistent;
import com.drzyl.cus.query.CusTagQuery;
import com.drzyl.cus.service.ICusTagService;
import com.drzyl.cus.vo.CusTagVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户标签表 服务实现
 */
@Log4j2
@Service("com.drzyl.cus.CusTagService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusTagServiceImpl implements ICusTagService {

  public static final String LOG = "CusTagService";

  @Resource(name = "com.drzyl.cus.CusTagPersistent")
  private ICusTagPersistent cusTagPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusTag saveCusTag(CusTag cusTag) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTag);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusTag.setCusTagId(ToolUtil.getUUID());
      return cusTagPersistent.saveCusTag(cusTag);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusTag> batchSaveCusTag(Collection<CusTag> cusTags) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTags);
    }
    try {
      if (ToolUtil.isEmpty(cusTags)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusTag cusTag : cusTags) {
        if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusTag.setCusTagId(ToolUtil.getUUID());
      }
      return cusTagPersistent.batchSaveCusTag(cusTags);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public CusTag updateCusTag(CusTag cusTag) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTag);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusTag.getCusTagId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      CusTag oldCusTag = cusTagPersistent.getCusTagByPk(cusTag.getCusTagId());
      if (ToolUtil.isNullEntityAllFieldValue(oldCusTag)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagPersistent.updateCusTag(cusTag);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<CusTag> batchUpdateCusTag(Collection<CusTag> cusTags) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTags);
    }
    try {
      if (ToolUtil.isEmpty(cusTags)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (CusTag cusTag : cusTags) {
        if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusTag.getCusTagId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        CusTag oldCusTag = cusTagPersistent.getCusTagByPk(cusTag.getCusTagId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusTag)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return cusTagPersistent.batchUpdateCusTag(cusTags);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeCusTag(CusTag cusTag) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTag);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusTag> cusTagSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(cusTag.getCusTagId())) {
        CusTagQuery cusTagQuery = new CusTagQuery();
        BeanUtils.copyProperties(cusTag, cusTagQuery);
        cusTagSet.addAll(cusTagPersistent.queryCusTag(cusTagQuery));
      } else {
        CusTag oldCusTag = cusTagPersistent.getCusTagByPk(cusTag.getCusTagId());
        if (ToolUtil.isNullEntityAllFieldValue(oldCusTag)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        cusTagSet.add(oldCusTag);
      }
      if (ToolUtil.isNotEmpty(cusTagSet)) {
        cusTagPersistent.batchRemoveCusTag(cusTagSet);
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
  public void batchRemoveCusTag(Collection<CusTag> cusTags) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTags);
    }
    try {
      if (ToolUtil.isEmpty(cusTags)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<CusTag> cusTagSet = new LinkedHashSet<>();
      for (CusTag cusTag : cusTags) {
        if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(cusTag.getCusTagId())) {
          CusTagQuery cusTagQuery = new CusTagQuery();
          BeanUtils.copyProperties(cusTag, cusTagQuery);
          cusTagSet.addAll(cusTagPersistent.queryCusTag(cusTagQuery));
        } else {
          CusTag oldCusTag = cusTagPersistent.getCusTagByPk(cusTag.getCusTagId());
          if (ToolUtil.isNullEntityAllFieldValue(oldCusTag)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          cusTagSet.add(oldCusTag);
        }
      }
      if (ToolUtil.isNotEmpty(cusTagSet)) {
        cusTagPersistent.batchRemoveCusTag(cusTagSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusTag(CusTagQuery cusTagQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagQuery);
    }
    try {
      return cusTagPersistent.getCountCusTag(cusTagQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusTag getCusTagByPk(String cusTagId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagId);
    }
    try {
      if (ToolUtil.isNullStr(cusTagId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagPersistent.getCusTagByPk(cusTagId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTag> getAllCusTag() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusTagPersistent.getAllCusTag();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTag> queryCusTag(CusTagQuery cusTagQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagQuery);
    }
    try {
      return cusTagPersistent.queryCusTag(cusTagQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusTag> pagingQueryCusTag(Param param, CusTagQuery cusTagQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagPersistent.pagingQueryCusTag(param, cusTagQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusTagVO getCusTagVOByPk(String cusTagId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagId);
    }
    try {
      if (ToolUtil.isNullStr(cusTagId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagPersistent.getCusTagVOByPk(cusTagId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagVO> getAllCusTagVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return cusTagPersistent.getAllCusTagVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagVO> queryCusTagVO(CusTagQuery cusTagQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagQuery);
    }
    try {
      return cusTagPersistent.queryCusTagVO(cusTagQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusTagVO> pagingQueryCusTagVO(Param param, CusTagQuery cusTagQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return cusTagPersistent.pagingQueryCusTagVO(param, cusTagQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

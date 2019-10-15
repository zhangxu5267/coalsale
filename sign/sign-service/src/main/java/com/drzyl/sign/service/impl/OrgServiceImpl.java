package com.drzyl.sign.service.impl;

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
import com.drzyl.sign.entity.Org;
import com.drzyl.sign.persistent.IOrgPersistent;
import com.drzyl.sign.query.OrgQuery;
import com.drzyl.sign.service.IOrgService;
import com.drzyl.sign.vo.OrgVO;
import lombok.extern.log4j.Log4j2;

/**
 * 组织机构 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.OrgService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class OrgServiceImpl implements IOrgService {

  public static final String LOG = "OrgService";

  @Resource(name = "com.drzyl.sign.OrgPersistent")
  private IOrgPersistent orgPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Org saveOrg(Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + org);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      org.setOrgId(ToolUtil.getUUID());
      if (ToolUtil.isNotNullStr(org.getOrgPid())) {
        Org superOrg = orgPersistent.getOrgByPk(org.getOrgPid());
        org.setIdPath(superOrg.getIdPath() + "/" + org.getOrgId());
        org.setNamePath(superOrg.getNamePath() + "/" + org.getOrgName());
      } else {
        org.setIdPath(org.getOrgId());
        org.setNamePath(org.getOrgName());
      }
      return orgPersistent.saveOrg(org);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Org> batchSaveOrg(Collection<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgs);
    }
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Org org : orgs) {
        if (ToolUtil.isNullEntityAllFieldValue(org)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        org.setOrgId(ToolUtil.getUUID());
      }
      return orgPersistent.batchSaveOrg(orgs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Org updateOrg(Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + org);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(org.getOrgId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Org oldOrg = orgPersistent.getOrgByPk(org.getOrgId());
      if (ToolUtil.isNullEntityAllFieldValue(oldOrg)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return orgPersistent.updateOrg(org);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Org> batchUpdateOrg(Collection<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgs);
    }
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Org org : orgs) {
        if (ToolUtil.isNullEntityAllFieldValue(org)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(org.getOrgId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        Org oldOrg = orgPersistent.getOrgByPk(org.getOrgId());
        if (ToolUtil.isNullEntityAllFieldValue(oldOrg)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return orgPersistent.batchUpdateOrg(orgs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeOrg(Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + org);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Org> orgSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(org.getOrgId())) {
        OrgQuery orgQuery = new OrgQuery();
        BeanUtils.copyProperties(org, orgQuery);
        orgSet.addAll(orgPersistent.queryOrg(orgQuery));
      } else {
        Org oldOrg = orgPersistent.getOrgByPk(org.getOrgId());
        if (ToolUtil.isNullEntityAllFieldValue(oldOrg)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        orgSet.add(oldOrg);
      }
      if (ToolUtil.isNotEmpty(orgSet)) {
        orgPersistent.batchRemoveOrg(orgSet);
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
  public void batchRemoveOrg(Collection<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgs);
    }
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Org> orgSet = new LinkedHashSet<>();
      for (Org org : orgs) {
        if (ToolUtil.isNullEntityAllFieldValue(org)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(org.getOrgId())) {
          OrgQuery orgQuery = new OrgQuery();
          BeanUtils.copyProperties(org, orgQuery);
          orgSet.addAll(orgPersistent.queryOrg(orgQuery));
        } else {
          Org oldOrg = orgPersistent.getOrgByPk(org.getOrgId());
          if (ToolUtil.isNullEntityAllFieldValue(oldOrg)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          orgSet.add(oldOrg);
        }
      }
      if (ToolUtil.isNotEmpty(orgSet)) {
        orgPersistent.batchRemoveOrg(orgSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountOrg(OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      return orgPersistent.getCountOrg(orgQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Org getOrgByPk(String orgId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgId);
    }
    try {
      if (ToolUtil.isNullStr(orgId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return orgPersistent.getOrgByPk(orgId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Org> getAllOrg() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return orgPersistent.getAllOrg();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Org> queryOrg(OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      return orgPersistent.queryOrg(orgQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<Org> pagingQueryOrg(Param param, OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return orgPersistent.pagingQueryOrg(param, orgQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public OrgVO getOrgVOByPk(String orgId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgId);
    }
    try {
      if (ToolUtil.isNullStr(orgId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return orgPersistent.getOrgVOByPk(orgId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<OrgVO> getAllOrgVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return orgPersistent.getAllOrgVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<OrgVO> queryOrgVO(OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      return orgPersistent.queryOrgVO(orgQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<OrgVO> pagingQueryOrgVO(Param param, OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return orgPersistent.pagingQueryOrgVO(param, orgQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

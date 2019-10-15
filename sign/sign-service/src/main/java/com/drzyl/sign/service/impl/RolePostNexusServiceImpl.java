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
import com.drzyl.sign.entity.RolePostNexus;
import com.drzyl.sign.persistent.IRolePostNexusPersistent;
import com.drzyl.sign.query.RolePostNexusQuery;
import com.drzyl.sign.service.IRolePostNexusService;
import com.drzyl.sign.vo.RolePostNexusVO;
import lombok.extern.log4j.Log4j2;

/**
 * 角色岗位 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.RolePostNexusService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class RolePostNexusServiceImpl implements IRolePostNexusService {

  public static final String LOG = "RolePostNexusService";

  @Resource(name = "com.drzyl.sign.RolePostNexusPersistent")
  private IRolePostNexusPersistent rolePostNexusPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public RolePostNexus saveRolePostNexus(RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      rolePostNexus.setNexusId(ToolUtil.getUUID());
      return rolePostNexusPersistent.saveRolePostNexus(rolePostNexus);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<RolePostNexus> batchSaveRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (RolePostNexus rolePostNexus : rolePostNexuss) {
        if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        rolePostNexus.setNexusId(ToolUtil.getUUID());
      }
      return rolePostNexusPersistent.batchSaveRolePostNexus(rolePostNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public RolePostNexus updateRolePostNexus(RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      RolePostNexus oldRolePostNexus = rolePostNexusPersistent.getRolePostNexusByPk(rolePostNexus.getNexusId());
      if (ToolUtil.isNullEntityAllFieldValue(oldRolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePostNexusPersistent.updateRolePostNexus(rolePostNexus);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<RolePostNexus> batchUpdateRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (RolePostNexus rolePostNexus : rolePostNexuss) {
        if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        RolePostNexus oldRolePostNexus = rolePostNexusPersistent.getRolePostNexusByPk(rolePostNexus.getNexusId());
        if (ToolUtil.isNullEntityAllFieldValue(oldRolePostNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return rolePostNexusPersistent.batchUpdateRolePostNexus(rolePostNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeRolePostNexus(RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<RolePostNexus> rolePostNexusSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
        RolePostNexusQuery rolePostNexusQuery = new RolePostNexusQuery();
        BeanUtils.copyProperties(rolePostNexus, rolePostNexusQuery);
        rolePostNexusSet.addAll(rolePostNexusPersistent.queryRolePostNexus(rolePostNexusQuery));
      } else {
        RolePostNexus oldRolePostNexus = rolePostNexusPersistent.getRolePostNexusByPk(rolePostNexus.getNexusId());
        if (ToolUtil.isNullEntityAllFieldValue(oldRolePostNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        rolePostNexusSet.add(oldRolePostNexus);
      }
      if (ToolUtil.isNotEmpty(rolePostNexusSet)) {
        rolePostNexusPersistent.batchRemoveRolePostNexus(rolePostNexusSet);
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
  public void batchRemoveRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<RolePostNexus> rolePostNexusSet = new LinkedHashSet<>();
      for (RolePostNexus rolePostNexus : rolePostNexuss) {
        if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
          RolePostNexusQuery rolePostNexusQuery = new RolePostNexusQuery();
          BeanUtils.copyProperties(rolePostNexus, rolePostNexusQuery);
          rolePostNexusSet.addAll(rolePostNexusPersistent.queryRolePostNexus(rolePostNexusQuery));
        } else {
          RolePostNexus oldRolePostNexus = rolePostNexusPersistent.getRolePostNexusByPk(rolePostNexus.getNexusId());
          if (ToolUtil.isNullEntityAllFieldValue(oldRolePostNexus)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          rolePostNexusSet.add(oldRolePostNexus);
        }
      }
      if (ToolUtil.isNotEmpty(rolePostNexusSet)) {
        rolePostNexusPersistent.batchRemoveRolePostNexus(rolePostNexusSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountRolePostNexus(RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      return rolePostNexusPersistent.getCountRolePostNexus(rolePostNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public RolePostNexus getRolePostNexusByPk(String nexusId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePostNexusPersistent.getRolePostNexusByPk(nexusId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexus> getAllRolePostNexus() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return rolePostNexusPersistent.getAllRolePostNexus();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexus> queryRolePostNexus(RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      return rolePostNexusPersistent.queryRolePostNexus(rolePostNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<RolePostNexus> pagingQueryRolePostNexus(Param param, RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePostNexusPersistent.pagingQueryRolePostNexus(param, rolePostNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public RolePostNexusVO getRolePostNexusVOByPk(String nexusId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePostNexusPersistent.getRolePostNexusVOByPk(nexusId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexusVO> getAllRolePostNexusVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return rolePostNexusPersistent.getAllRolePostNexusVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexusVO> queryRolePostNexusVO(RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      return rolePostNexusPersistent.queryRolePostNexusVO(rolePostNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<RolePostNexusVO> pagingQueryRolePostNexusVO(Param param, RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePostNexusPersistent.pagingQueryRolePostNexusVO(param, rolePostNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

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
import com.drzyl.sign.entity.Role;
import com.drzyl.sign.persistent.IRolePersistent;
import com.drzyl.sign.query.RoleQuery;
import com.drzyl.sign.service.IRoleService;
import com.drzyl.sign.vo.RoleVO;
import lombok.extern.log4j.Log4j2;

/**
 * 角色 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.RoleService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl implements IRoleService {

  public static final String LOG = "RoleService";

  @Resource(name = "com.drzyl.sign.RolePersistent")
  private IRolePersistent rolePersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Role saveRole(Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + role);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      role.setRoleId(ToolUtil.getUUID());
      return rolePersistent.saveRole(role);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Role> batchSaveRole(Collection<Role> roles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roles);
    }
    try {
      if (ToolUtil.isEmpty(roles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Role role : roles) {
        if (ToolUtil.isNullEntityAllFieldValue(role)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        role.setRoleId(ToolUtil.getUUID());
      }
      return rolePersistent.batchSaveRole(roles);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Role updateRole(Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + role);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(role.getRoleId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Role oldRole = rolePersistent.getRoleByPk(role.getRoleId());
      if (ToolUtil.isNullEntityAllFieldValue(oldRole)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePersistent.updateRole(role);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Role> batchUpdateRole(Collection<Role> roles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roles);
    }
    try {
      if (ToolUtil.isEmpty(roles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Role role : roles) {
        if (ToolUtil.isNullEntityAllFieldValue(role)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(role.getRoleId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        Role oldRole = rolePersistent.getRoleByPk(role.getRoleId());
        if (ToolUtil.isNullEntityAllFieldValue(oldRole)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return rolePersistent.batchUpdateRole(roles);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeRole(Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + role);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Role> roleSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(role.getRoleId())) {
        RoleQuery roleQuery = new RoleQuery();
        BeanUtils.copyProperties(role, roleQuery);
        roleSet.addAll(rolePersistent.queryRole(roleQuery));
      } else {
        Role oldRole = rolePersistent.getRoleByPk(role.getRoleId());
        if (ToolUtil.isNullEntityAllFieldValue(oldRole)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        roleSet.add(oldRole);
      }
      if (ToolUtil.isNotEmpty(roleSet)) {
        rolePersistent.batchRemoveRole(roleSet);
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
  public void batchRemoveRole(Collection<Role> roles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roles);
    }
    try {
      if (ToolUtil.isEmpty(roles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Role> roleSet = new LinkedHashSet<>();
      for (Role role : roles) {
        if (ToolUtil.isNullEntityAllFieldValue(role)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(role.getRoleId())) {
          RoleQuery roleQuery = new RoleQuery();
          BeanUtils.copyProperties(role, roleQuery);
          roleSet.addAll(rolePersistent.queryRole(roleQuery));
        } else {
          Role oldRole = rolePersistent.getRoleByPk(role.getRoleId());
          if (ToolUtil.isNullEntityAllFieldValue(oldRole)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          roleSet.add(oldRole);
        }
      }
      if (ToolUtil.isNotEmpty(roleSet)) {
        rolePersistent.batchRemoveRole(roleSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountRole(RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roleQuery);
    }
    try {
      return rolePersistent.getCountRole(roleQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Role getRoleByPk(String roleId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roleId);
    }
    try {
      if (ToolUtil.isNullStr(roleId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePersistent.getRoleByPk(roleId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Role> getAllRole() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return rolePersistent.getAllRole();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Role> queryRole(RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roleQuery);
    }
    try {
      return rolePersistent.queryRole(roleQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<Role> pagingQueryRole(Param param, RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePersistent.pagingQueryRole(param, roleQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public RoleVO getRoleVOByPk(String roleId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roleId);
    }
    try {
      if (ToolUtil.isNullStr(roleId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePersistent.getRoleVOByPk(roleId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RoleVO> getAllRoleVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return rolePersistent.getAllRoleVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RoleVO> queryRoleVO(RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roleQuery);
    }
    try {
      return rolePersistent.queryRoleVO(roleQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<RoleVO> pagingQueryRoleVO(Param param, RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return rolePersistent.pagingQueryRoleVO(param, roleQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

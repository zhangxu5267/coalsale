package com.drzyl.sign.business.service.impl;

import com.drzyl.sign.business.param.RoleAccessParam;
import com.drzyl.sign.business.service.IRoleAccessService;
import com.drzyl.sign.business.vo.RoleAccessVO;
import com.drzyl.sign.entity.Role;
import com.drzyl.sign.persistent.IRolePersistent;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.util.ToolUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 角色权限 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.RoleAccessService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class RoleAccessServiceImpl implements IRoleAccessService {

  public static final String LOG = "RoleAccessService";

  @Resource(name = "com.drzyl.sign.RolePersistent")
  private IRolePersistent rolePersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public RoleAccessVO saveRoleAccess(RoleAccessParam roleAccessParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roleAccessParam);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleAccessParam)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      RoleAccessVO roleAccessVO = new RoleAccessVO();
      Role role = rolePersistent.getRoleByPk(roleAccessParam.getRoleId());
      if (ToolUtil.isNotEmpty(roleAccessParam.getAccessList())) {
        role.setAccessList(new Gson().toJson(roleAccessParam.getAccessList()));
      } else {
        role.setAccessList(null);
      }
      rolePersistent.updateRole(role);
      roleAccessVO.setRoleId(role.getRoleId());
      return roleAccessVO;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public RoleAccessVO getRoleAccess(RoleAccessParam roleAccessParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + roleAccessParam);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleAccessParam)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      RoleAccessVO roleAccessVO = new RoleAccessVO();
      Role role = rolePersistent.getRoleByPk(roleAccessParam.getRoleId());
      roleAccessVO.setRoleId(role.getRoleId());
      if (ToolUtil.isNotNullStr(role.getAccessList())) {
        roleAccessVO.setAccessList(new LinkedHashSet<String>(new Gson().fromJson(role.getAccessList(), new TypeToken<Collection<String>>(){}.getType())));
      } else {
        roleAccessVO.setAccessList(new LinkedHashSet<String>());
      }
      return roleAccessVO;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

package com.drzyl.sign.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.sign.entity.Role;
import com.drzyl.sign.query.RoleQuery;
import com.drzyl.sign.service.IRoleService;
import com.drzyl.sign.vo.RoleVO;
import lombok.extern.log4j.Log4j2;

/**
 * 角色 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sign/role" })
public class RoleController extends ToolController {

  public static final String LOG = "RoleController";

  @Resource(name = "com.drzyl.sign.RoleService")
  private IRoleService roleService;

  /**
   * 保存 角色 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<Role> save(Param param, @RequestBody Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + role);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleService.saveRole(role));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 角色 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<Role> batchSave(Param param, @RequestBody List<Role> roles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roles);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(roles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleService.batchSaveRole(roles));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 角色 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<Role> update(Param param, @RequestBody Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + role);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleService.updateRole(role));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 角色 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<Role> batchUpdate(Param param, @RequestBody List<Role> roles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roles);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(roles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleService.batchUpdateRole(roles));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 角色 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<Role> remove(Param param, @RequestBody Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + role);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      roleService.removeRole(role);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 角色 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<Role> batchRemove(Param param, @RequestBody List<Role> roles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roles);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(roles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      roleService.batchRemoveRole(roles);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 角色 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<Role> getByPk(Param param, @RequestBody Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + role);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(role.getRoleId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleService.getRoleByPk(role.getRoleId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 角色 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<Role> getAll(Param param, @RequestBody RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleQuery);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleQuery)) {
        responses.setData(roleService.getAllRole());
      } else {
        responses.setData(roleService.queryRole(roleQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 分页获取 角色 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<Role> paging(Param param, @RequestBody RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleQuery);
    }
    Responses<Role> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleQuery)) {
        responses.setData(roleService.pagingQueryRole(param, null));
      } else {
        responses.setData(roleService.pagingQueryRole(param, roleQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 角色 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<RoleVO> getVOByPk(Param param, @RequestBody Role role) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + role);
    }
    Responses<RoleVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(role)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(role.getRoleId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleService.getRoleVOByPk(role.getRoleId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 角色 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<RoleVO> getAllVO(Param param, @RequestBody RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleQuery);
    }
    Responses<RoleVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleQuery)) {
        responses.setData(roleService.getAllRoleVO());
      } else {
        responses.setData(roleService.queryRoleVO(roleQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 分页获取 角色 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<RoleVO> pagingVO(Param param, @RequestBody RoleQuery roleQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleQuery);
    }
    Responses<RoleVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleQuery)) {
        responses.setData(roleService.pagingQueryRoleVO(param, null));
      } else {
        responses.setData(roleService.pagingQueryRoleVO(param, roleQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

}

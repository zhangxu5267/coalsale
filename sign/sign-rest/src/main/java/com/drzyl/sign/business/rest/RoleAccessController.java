package com.drzyl.sign.business.rest;

import com.drzyl.sign.business.param.RoleAccessParam;
import com.drzyl.sign.business.service.IRoleAccessService;
import com.drzyl.sign.business.vo.LoginInfoVO;
import com.drzyl.sign.business.vo.RoleAccessVO;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 权限登录 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sign/role_access" })
public class RoleAccessController extends ToolController {

  public static final String LOG = "RoleAccessController";

  @Resource(name = "com.drzyl.sign.RoleAccessService")
  private IRoleAccessService roleAccessService;

  /**
   * 保存角色权限
   */
  @PostMapping(params = { ToolUtil.ACTION + "save_role_access" })
  public Responses<RoleAccessVO> saveRoleAccess(Param param, @RequestBody RoleAccessParam roleAccessParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleAccessParam);
    }
    Responses<RoleAccessVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleAccessParam)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleAccessService.saveRoleAccess(roleAccessParam));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取角色权限
   */
  @PostMapping(params = { ToolUtil.ACTION + "get_role_access" })
  public Responses<RoleAccessVO> getRoleAccess(Param param, @RequestBody RoleAccessParam roleAccessParam) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + roleAccessParam);
    }
    Responses<RoleAccessVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(roleAccessParam)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(roleAccessService.getRoleAccess(roleAccessParam));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

}

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
import com.drzyl.sign.entity.RolePostNexus;
import com.drzyl.sign.query.RolePostNexusQuery;
import com.drzyl.sign.service.IRolePostNexusService;
import com.drzyl.sign.vo.RolePostNexusVO;
import lombok.extern.log4j.Log4j2;

/**
 * 角色岗位 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sign/rolePostNexus" })
public class RolePostNexusController extends ToolController {

  public static final String LOG = "RolePostNexusController";

  @Resource(name = "com.drzyl.sign.RolePostNexusService")
  private IRolePostNexusService rolePostNexusService;

  /**
   * 保存 角色岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<RolePostNexus> save(Param param, @RequestBody RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(rolePostNexusService.saveRolePostNexus(rolePostNexus));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 角色岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<RolePostNexus> batchSave(Param param, @RequestBody List<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(rolePostNexusService.batchSaveRolePostNexus(rolePostNexuss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 角色岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<RolePostNexus> update(Param param, @RequestBody RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(rolePostNexusService.updateRolePostNexus(rolePostNexus));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 角色岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<RolePostNexus> batchUpdate(Param param, @RequestBody List<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(rolePostNexusService.batchUpdateRolePostNexus(rolePostNexuss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 角色岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<RolePostNexus> remove(Param param, @RequestBody RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      rolePostNexusService.removeRolePostNexus(rolePostNexus);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 角色岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<RolePostNexus> batchRemove(Param param, @RequestBody List<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      rolePostNexusService.batchRemoveRolePostNexus(rolePostNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 角色岗位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<RolePostNexus> getByPk(Param param, @RequestBody RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(rolePostNexusService.getRolePostNexusByPk(rolePostNexus.getNexusId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 角色岗位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<RolePostNexus> getAll(Param param, @RequestBody RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        responses.setData(rolePostNexusService.getAllRolePostNexus());
      } else {
        responses.setData(rolePostNexusService.queryRolePostNexus(rolePostNexusQuery));
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
   * 分页获取 角色岗位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<RolePostNexus> paging(Param param, @RequestBody RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    Responses<RolePostNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        responses.setData(rolePostNexusService.pagingQueryRolePostNexus(param, null));
      } else {
        responses.setData(rolePostNexusService.pagingQueryRolePostNexus(param, rolePostNexusQuery));
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
   * 通过主键获取 角色岗位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<RolePostNexusVO> getVOByPk(Param param, @RequestBody RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    Responses<RolePostNexusVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(rolePostNexusService.getRolePostNexusVOByPk(rolePostNexus.getNexusId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 角色岗位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<RolePostNexusVO> getAllVO(Param param, @RequestBody RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    Responses<RolePostNexusVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        responses.setData(rolePostNexusService.getAllRolePostNexusVO());
      } else {
        responses.setData(rolePostNexusService.queryRolePostNexusVO(rolePostNexusQuery));
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
   * 分页获取 角色岗位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<RolePostNexusVO> pagingVO(Param param, @RequestBody RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    Responses<RolePostNexusVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        responses.setData(rolePostNexusService.pagingQueryRolePostNexusVO(param, null));
      } else {
        responses.setData(rolePostNexusService.pagingQueryRolePostNexusVO(param, rolePostNexusQuery));
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

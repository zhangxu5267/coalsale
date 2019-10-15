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
import com.drzyl.sign.entity.Org;
import com.drzyl.sign.query.OrgQuery;
import com.drzyl.sign.service.IOrgService;
import com.drzyl.sign.vo.OrgVO;
import lombok.extern.log4j.Log4j2;

/**
 * 组织机构 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sign/org" })
public class OrgController extends ToolController {

  public static final String LOG = "OrgController";

  @Resource(name = "com.drzyl.sign.OrgService")
  private IOrgService orgService;

  /**
   * 保存 组织机构 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<Org> save(Param param, @RequestBody Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + org);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(orgService.saveOrg(org));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 组织机构 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<Org> batchSave(Param param, @RequestBody List<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgs);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(orgService.batchSaveOrg(orgs));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 组织机构 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<Org> update(Param param, @RequestBody Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + org);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(orgService.updateOrg(org));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 组织机构 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<Org> batchUpdate(Param param, @RequestBody List<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgs);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(orgService.batchUpdateOrg(orgs));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 组织机构 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<Org> remove(Param param, @RequestBody Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + org);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      orgService.removeOrg(org);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 组织机构 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<Org> batchRemove(Param param, @RequestBody List<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgs);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      orgService.batchRemoveOrg(orgs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 组织机构 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<Org> getByPk(Param param, @RequestBody Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + org);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(org.getOrgId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(orgService.getOrgByPk(org.getOrgId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 组织机构 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<Org> getAll(Param param, @RequestBody OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        responses.setData(orgService.getAllOrg());
      } else {
        responses.setData(orgService.queryOrg(orgQuery));
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
   * 分页获取 组织机构 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<Org> paging(Param param, @RequestBody OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
    }
    Responses<Org> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        responses.setData(orgService.pagingQueryOrg(param, null));
      } else {
        responses.setData(orgService.pagingQueryOrg(param, orgQuery));
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
   * 通过主键获取 组织机构 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<OrgVO> getVOByPk(Param param, @RequestBody Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + org);
    }
    Responses<OrgVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(org.getOrgId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(orgService.getOrgVOByPk(org.getOrgId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 组织机构 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<OrgVO> getAllVO(Param param, @RequestBody OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
    }
    Responses<OrgVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        responses.setData(orgService.getAllOrgVO());
      } else {
        responses.setData(orgService.queryOrgVO(orgQuery));
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
   * 分页获取 组织机构 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<OrgVO> pagingVO(Param param, @RequestBody OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
    }
    Responses<OrgVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        responses.setData(orgService.pagingQueryOrgVO(param, null));
      } else {
        responses.setData(orgService.pagingQueryOrgVO(param, orgQuery));
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

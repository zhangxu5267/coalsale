package com.drzyl.cus.rest;

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
import com.drzyl.cus.entity.CusAgent;
import com.drzyl.cus.query.CusAgentQuery;
import com.drzyl.cus.service.ICusAgentService;
import com.drzyl.cus.vo.CusAgentVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户委托信息 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "cus/cusAgent" })
public class CusAgentController extends ToolController {

  public static final String LOG = "CusAgentController";

  @Resource(name = "com.drzyl.cus.CusAgentService")
  private ICusAgentService cusAgentService;

  /**
   * 保存 客户委托信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<CusAgent> save(Param param, @RequestBody CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgent);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAgentService.saveCusAgent(cusAgent));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 客户委托信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<CusAgent> batchSave(Param param, @RequestBody List<CusAgent> cusAgents) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgents);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAgents)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAgentService.batchSaveCusAgent(cusAgents));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 客户委托信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<CusAgent> update(Param param, @RequestBody CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgent);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAgentService.updateCusAgent(cusAgent));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 客户委托信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<CusAgent> batchUpdate(Param param, @RequestBody List<CusAgent> cusAgents) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgents);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAgents)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAgentService.batchUpdateCusAgent(cusAgents));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 客户委托信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<CusAgent> remove(Param param, @RequestBody CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgent);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAgentService.removeCusAgent(cusAgent);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 客户委托信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<CusAgent> batchRemove(Param param, @RequestBody List<CusAgent> cusAgents) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgents);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAgents)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAgentService.batchRemoveCusAgent(cusAgents);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 客户委托信息 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<CusAgent> getByPk(Param param, @RequestBody CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgent);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAgent.getCusAgentId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAgentService.getCusAgentByPk(cusAgent.getCusAgentId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户委托信息 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<CusAgent> getAll(Param param, @RequestBody CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgentQuery)) {
        responses.setData(cusAgentService.getAllCusAgent());
      } else {
        responses.setData(cusAgentService.queryCusAgent(cusAgentQuery));
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
   * 分页获取 客户委托信息 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<CusAgent> paging(Param param, @RequestBody CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    Responses<CusAgent> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgentQuery)) {
        responses.setData(cusAgentService.pagingQueryCusAgent(param, null));
      } else {
        responses.setData(cusAgentService.pagingQueryCusAgent(param, cusAgentQuery));
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
   * 通过主键获取 客户委托信息 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<CusAgentVO> getVOByPk(Param param, @RequestBody CusAgent cusAgent) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgent);
    }
    Responses<CusAgentVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgent)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAgent.getCusAgentId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAgentService.getCusAgentVOByPk(cusAgent.getCusAgentId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户委托信息 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<CusAgentVO> getAllVO(Param param, @RequestBody CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    Responses<CusAgentVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgentQuery)) {
        responses.setData(cusAgentService.getAllCusAgentVO());
      } else {
        responses.setData(cusAgentService.queryCusAgentVO(cusAgentQuery));
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
   * 分页获取 客户委托信息 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<CusAgentVO> pagingVO(Param param, @RequestBody CusAgentQuery cusAgentQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAgentQuery);
    }
    Responses<CusAgentVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAgentQuery)) {
        responses.setData(cusAgentService.pagingQueryCusAgentVO(param, null));
      } else {
        responses.setData(cusAgentService.pagingQueryCusAgentVO(param, cusAgentQuery));
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

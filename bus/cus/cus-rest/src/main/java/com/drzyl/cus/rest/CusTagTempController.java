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
import com.drzyl.cus.entity.CusTagTemp;
import com.drzyl.cus.query.CusTagTempQuery;
import com.drzyl.cus.service.ICusTagTempService;
import com.drzyl.cus.vo.CusTagTempVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户标签中间表 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "cus/cusTagTemp" })
public class CusTagTempController extends ToolController {

  public static final String LOG = "CusTagTempController";

  @Resource(name = "com.drzyl.cus.CusTagTempService")
  private ICusTagTempService cusTagTempService;

  /**
   * 保存 客户标签中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<CusTagTemp> save(Param param, @RequestBody CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusTagTempService.saveCusTagTemp(cusTagTemp));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 客户标签中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<CusTagTemp> batchSave(Param param, @RequestBody List<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusTagTempService.batchSaveCusTagTemp(cusTagTemps));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 客户标签中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<CusTagTemp> update(Param param, @RequestBody CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusTagTempService.updateCusTagTemp(cusTagTemp));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 客户标签中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<CusTagTemp> batchUpdate(Param param, @RequestBody List<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusTagTempService.batchUpdateCusTagTemp(cusTagTemps));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 客户标签中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<CusTagTemp> remove(Param param, @RequestBody CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusTagTempService.removeCusTagTemp(cusTagTemp);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 客户标签中间表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<CusTagTemp> batchRemove(Param param, @RequestBody List<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusTagTempService.batchRemoveCusTagTemp(cusTagTemps);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 客户标签中间表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<CusTagTemp> getByPk(Param param, @RequestBody CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusTagTempService.getCusTagTempByPk(cusTagTemp.getCusTagTempId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户标签中间表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<CusTagTemp> getAll(Param param, @RequestBody CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        responses.setData(cusTagTempService.getAllCusTagTemp());
      } else {
        responses.setData(cusTagTempService.queryCusTagTemp(cusTagTempQuery));
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
   * 分页获取 客户标签中间表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<CusTagTemp> paging(Param param, @RequestBody CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    Responses<CusTagTemp> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        responses.setData(cusTagTempService.pagingQueryCusTagTemp(param, null));
      } else {
        responses.setData(cusTagTempService.pagingQueryCusTagTemp(param, cusTagTempQuery));
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
   * 通过主键获取 客户标签中间表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<CusTagTempVO> getVOByPk(Param param, @RequestBody CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    Responses<CusTagTempVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusTagTempService.getCusTagTempVOByPk(cusTagTemp.getCusTagTempId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户标签中间表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<CusTagTempVO> getAllVO(Param param, @RequestBody CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    Responses<CusTagTempVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        responses.setData(cusTagTempService.getAllCusTagTempVO());
      } else {
        responses.setData(cusTagTempService.queryCusTagTempVO(cusTagTempQuery));
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
   * 分页获取 客户标签中间表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<CusTagTempVO> pagingVO(Param param, @RequestBody CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    Responses<CusTagTempVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        responses.setData(cusTagTempService.pagingQueryCusTagTempVO(param, null));
      } else {
        responses.setData(cusTagTempService.pagingQueryCusTagTempVO(param, cusTagTempQuery));
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

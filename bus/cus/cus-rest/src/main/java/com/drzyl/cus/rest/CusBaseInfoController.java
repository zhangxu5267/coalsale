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
import com.drzyl.cus.entity.CusBaseInfo;
import com.drzyl.cus.query.CusBaseInfoQuery;
import com.drzyl.cus.service.ICusBaseInfoService;
import com.drzyl.cus.vo.CusBaseInfoVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户详细信息 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "cus/cusBaseInfo" })
public class CusBaseInfoController extends ToolController {

  public static final String LOG = "CusBaseInfoController";

  @Resource(name = "com.drzyl.cus.CusBaseInfoService")
  private ICusBaseInfoService cusBaseInfoService;

  /**
   * 保存 客户详细信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<CusBaseInfo> save(Param param, @RequestBody CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusBaseInfoService.saveCusBaseInfo(cusBaseInfo));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 客户详细信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<CusBaseInfo> batchSave(Param param, @RequestBody List<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusBaseInfoService.batchSaveCusBaseInfo(cusBaseInfos));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 客户详细信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<CusBaseInfo> update(Param param, @RequestBody CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusBaseInfoService.updateCusBaseInfo(cusBaseInfo));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 客户详细信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<CusBaseInfo> batchUpdate(Param param, @RequestBody List<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusBaseInfoService.batchUpdateCusBaseInfo(cusBaseInfos));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 客户详细信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<CusBaseInfo> remove(Param param, @RequestBody CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusBaseInfoService.removeCusBaseInfo(cusBaseInfo);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 客户详细信息 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<CusBaseInfo> batchRemove(Param param, @RequestBody List<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusBaseInfoService.batchRemoveCusBaseInfo(cusBaseInfos);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 客户详细信息 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<CusBaseInfo> getByPk(Param param, @RequestBody CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusBaseInfoService.getCusBaseInfoByPk(cusBaseInfo.getCusBaseInfoId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户详细信息 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<CusBaseInfo> getAll(Param param, @RequestBody CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        responses.setData(cusBaseInfoService.getAllCusBaseInfo());
      } else {
        responses.setData(cusBaseInfoService.queryCusBaseInfo(cusBaseInfoQuery));
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
   * 分页获取 客户详细信息 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<CusBaseInfo> paging(Param param, @RequestBody CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    Responses<CusBaseInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        responses.setData(cusBaseInfoService.pagingQueryCusBaseInfo(param, null));
      } else {
        responses.setData(cusBaseInfoService.pagingQueryCusBaseInfo(param, cusBaseInfoQuery));
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
   * 通过主键获取 客户详细信息 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<CusBaseInfoVO> getVOByPk(Param param, @RequestBody CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    Responses<CusBaseInfoVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusBaseInfoService.getCusBaseInfoVOByPk(cusBaseInfo.getCusBaseInfoId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户详细信息 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<CusBaseInfoVO> getAllVO(Param param, @RequestBody CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    Responses<CusBaseInfoVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        responses.setData(cusBaseInfoService.getAllCusBaseInfoVO());
      } else {
        responses.setData(cusBaseInfoService.queryCusBaseInfoVO(cusBaseInfoQuery));
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
   * 分页获取 客户详细信息 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<CusBaseInfoVO> pagingVO(Param param, @RequestBody CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    Responses<CusBaseInfoVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        responses.setData(cusBaseInfoService.pagingQueryCusBaseInfoVO(param, null));
      } else {
        responses.setData(cusBaseInfoService.pagingQueryCusBaseInfoVO(param, cusBaseInfoQuery));
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

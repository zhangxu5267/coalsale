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
import com.drzyl.cus.entity.CusAddrDis;
import com.drzyl.cus.query.CusAddrDisQuery;
import com.drzyl.cus.service.ICusAddrDisService;
import com.drzyl.cus.vo.CusAddrDisVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户收货地址表 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "cus/cusAddrDis" })
public class CusAddrDisController extends ToolController {

  public static final String LOG = "CusAddrDisController";

  @Resource(name = "com.drzyl.cus.CusAddrDisService")
  private ICusAddrDisService cusAddrDisService;

  /**
   * 保存 客户收货地址表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<CusAddrDis> save(Param param, @RequestBody CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddrDisService.saveCusAddrDis(cusAddrDis));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 客户收货地址表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<CusAddrDis> batchSave(Param param, @RequestBody List<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddrDisService.batchSaveCusAddrDis(cusAddrDiss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 客户收货地址表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<CusAddrDis> update(Param param, @RequestBody CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddrDisService.updateCusAddrDis(cusAddrDis));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 客户收货地址表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<CusAddrDis> batchUpdate(Param param, @RequestBody List<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddrDisService.batchUpdateCusAddrDis(cusAddrDiss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 客户收货地址表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<CusAddrDis> remove(Param param, @RequestBody CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAddrDisService.removeCusAddrDis(cusAddrDis);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 客户收货地址表 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<CusAddrDis> batchRemove(Param param, @RequestBody List<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAddrDisService.batchRemoveCusAddrDis(cusAddrDiss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 客户收货地址表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<CusAddrDis> getByPk(Param param, @RequestBody CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddrDisService.getCusAddrDisByPk(cusAddrDis.getCusAddrDisId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户收货地址表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<CusAddrDis> getAll(Param param, @RequestBody CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        responses.setData(cusAddrDisService.getAllCusAddrDis());
      } else {
        responses.setData(cusAddrDisService.queryCusAddrDis(cusAddrDisQuery));
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
   * 分页获取 客户收货地址表 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<CusAddrDis> paging(Param param, @RequestBody CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    Responses<CusAddrDis> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        responses.setData(cusAddrDisService.pagingQueryCusAddrDis(param, null));
      } else {
        responses.setData(cusAddrDisService.pagingQueryCusAddrDis(param, cusAddrDisQuery));
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
   * 通过主键获取 客户收货地址表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<CusAddrDisVO> getVOByPk(Param param, @RequestBody CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    Responses<CusAddrDisVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddrDisService.getCusAddrDisVOByPk(cusAddrDis.getCusAddrDisId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户收货地址表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<CusAddrDisVO> getAllVO(Param param, @RequestBody CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    Responses<CusAddrDisVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        responses.setData(cusAddrDisService.getAllCusAddrDisVO());
      } else {
        responses.setData(cusAddrDisService.queryCusAddrDisVO(cusAddrDisQuery));
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
   * 分页获取 客户收货地址表 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<CusAddrDisVO> pagingVO(Param param, @RequestBody CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    Responses<CusAddrDisVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        responses.setData(cusAddrDisService.pagingQueryCusAddrDisVO(param, null));
      } else {
        responses.setData(cusAddrDisService.pagingQueryCusAddrDisVO(param, cusAddrDisQuery));
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

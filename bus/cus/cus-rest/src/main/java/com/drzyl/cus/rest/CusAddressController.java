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
import com.drzyl.cus.entity.CusAddress;
import com.drzyl.cus.query.CusAddressQuery;
import com.drzyl.cus.service.ICusAddressService;
import com.drzyl.cus.vo.CusAddressVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户收货单位 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "cus/cusAddress" })
public class CusAddressController extends ToolController {

  public static final String LOG = "CusAddressController";

  @Resource(name = "com.drzyl.cus.CusAddressService")
  private ICusAddressService cusAddressService;

  /**
   * 保存 客户收货单位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<CusAddress> save(Param param, @RequestBody CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddress);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddressService.saveCusAddress(cusAddress));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 客户收货单位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<CusAddress> batchSave(Param param, @RequestBody List<CusAddress> cusAddresss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddresss);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAddresss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddressService.batchSaveCusAddress(cusAddresss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 客户收货单位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<CusAddress> update(Param param, @RequestBody CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddress);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddressService.updateCusAddress(cusAddress));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 客户收货单位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<CusAddress> batchUpdate(Param param, @RequestBody List<CusAddress> cusAddresss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddresss);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAddresss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddressService.batchUpdateCusAddress(cusAddresss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 客户收货单位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<CusAddress> remove(Param param, @RequestBody CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddress);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAddressService.removeCusAddress(cusAddress);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 客户收货单位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<CusAddress> batchRemove(Param param, @RequestBody List<CusAddress> cusAddresss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddresss);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(cusAddresss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      cusAddressService.batchRemoveCusAddress(cusAddresss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 客户收货单位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<CusAddress> getByPk(Param param, @RequestBody CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddress);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddress.getCusAddressId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddressService.getCusAddressByPk(cusAddress.getCusAddressId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户收货单位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<CusAddress> getAll(Param param, @RequestBody CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddressQuery)) {
        responses.setData(cusAddressService.getAllCusAddress());
      } else {
        responses.setData(cusAddressService.queryCusAddress(cusAddressQuery));
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
   * 分页获取 客户收货单位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<CusAddress> paging(Param param, @RequestBody CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    Responses<CusAddress> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddressQuery)) {
        responses.setData(cusAddressService.pagingQueryCusAddress(param, null));
      } else {
        responses.setData(cusAddressService.pagingQueryCusAddress(param, cusAddressQuery));
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
   * 通过主键获取 客户收货单位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<CusAddressVO> getVOByPk(Param param, @RequestBody CusAddress cusAddress) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddress);
    }
    Responses<CusAddressVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddress)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddress.getCusAddressId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(cusAddressService.getCusAddressVOByPk(cusAddress.getCusAddressId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 客户收货单位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<CusAddressVO> getAllVO(Param param, @RequestBody CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    Responses<CusAddressVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddressQuery)) {
        responses.setData(cusAddressService.getAllCusAddressVO());
      } else {
        responses.setData(cusAddressService.queryCusAddressVO(cusAddressQuery));
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
   * 分页获取 客户收货单位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<CusAddressVO> pagingVO(Param param, @RequestBody CusAddressQuery cusAddressQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddressQuery);
    }
    Responses<CusAddressVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddressQuery)) {
        responses.setData(cusAddressService.pagingQueryCusAddressVO(param, null));
      } else {
        responses.setData(cusAddressService.pagingQueryCusAddressVO(param, cusAddressQuery));
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

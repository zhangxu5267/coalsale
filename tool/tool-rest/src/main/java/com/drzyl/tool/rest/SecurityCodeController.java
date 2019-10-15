package com.drzyl.tool.rest;

import com.drzyl.tool.entity.SecurityCode;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.query.SecurityCodeQuery;
import com.drzyl.tool.service.ISecurityCodeService;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.tool.vo.SecurityCodeVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 短信验证码 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sms/securityCode" })
public class SecurityCodeController extends ToolController {

  public static final String LOG = "SecurityCodeController";

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Resource(name = "com.drzyl.sms.SecurityCodeService")
  private ISecurityCodeService securityCodeService;

  /**
   * 保存 短信验证码 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<SecurityCode> save(Param param, @RequestBody SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCode);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(securityCodeService.saveSecurityCode(securityCode));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 短信验证码 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<SecurityCode> batchSave(Param param, @RequestBody List<SecurityCode> securityCodes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodes);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(securityCodes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(securityCodeService.batchSaveSecurityCode(securityCodes));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 短信验证码 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<SecurityCode> update(Param param, @RequestBody SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCode);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(securityCodeService.updateSecurityCode(securityCode));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 短信验证码 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<SecurityCode> batchUpdate(Param param, @RequestBody List<SecurityCode> securityCodes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodes);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(securityCodes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(securityCodeService.batchUpdateSecurityCode(securityCodes));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 短信验证码 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<SecurityCode> remove(Param param, @RequestBody SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCode);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      securityCodeService.removeSecurityCode(securityCode);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 短信验证码 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<SecurityCode> batchRemove(Param param, @RequestBody List<SecurityCode> securityCodes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodes);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(securityCodes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      securityCodeService.batchRemoveSecurityCode(securityCodes);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 短信验证码 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<SecurityCode> getByPk(Param param, @RequestBody SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCode);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(securityCode.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(securityCodeService.getSecurityCodeByPk(securityCode.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 短信验证码 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<SecurityCode> getAll(Param param, @RequestBody SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodeQuery);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        responses.setData(securityCodeService.getAllSecurityCode());
      } else {
        responses.setData(securityCodeService.querySecurityCode(securityCodeQuery));
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
   * 分页获取 短信验证码 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<SecurityCode> paging(Param param, @RequestBody SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodeQuery);
    }
    Responses<SecurityCode> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        responses.setData(securityCodeService.pagingQuerySecurityCode(param, null));
      } else {
        responses.setData(securityCodeService.pagingQuerySecurityCode(param, securityCodeQuery));
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
   * 通过主键获取 短信验证码 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<SecurityCodeVO> getVOByPk(Param param, @RequestBody SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCode);
    }
    Responses<SecurityCodeVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(securityCode.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(securityCodeService.getSecurityCodeVOByPk(securityCode.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 短信验证码 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<SecurityCodeVO> getAllVO(Param param, @RequestBody SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodeQuery);
    }
    Responses<SecurityCodeVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        responses.setData(securityCodeService.getAllSecurityCodeVO());
      } else {
        responses.setData(securityCodeService.querySecurityCodeVO(securityCodeQuery));
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
   * 分页获取 短信验证码 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<SecurityCodeVO> pagingVO(Param param, @RequestBody SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodeQuery);
    }
    Responses<SecurityCodeVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        responses.setData(securityCodeService.pagingQuerySecurityCodeVO(param, null));
      } else {
        responses.setData(securityCodeService.pagingQuerySecurityCodeVO(param, securityCodeQuery));
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

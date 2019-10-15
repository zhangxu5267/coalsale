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
import com.drzyl.sign.entity.Staff;
import com.drzyl.sign.query.StaffQuery;
import com.drzyl.sign.service.IStaffService;
import com.drzyl.sign.vo.StaffVO;
import lombok.extern.log4j.Log4j2;

/**
 * 员工 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sign/staff" })
public class StaffController extends ToolController {

  public static final String LOG = "StaffController";

  @Resource(name = "com.drzyl.sign.StaffService")
  private IStaffService staffService;

  /**
   * 保存 员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<Staff> save(Param param, @RequestBody Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staff);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(staffService.saveStaff(staff));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<Staff> batchSave(Param param, @RequestBody List<Staff> staffs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffs);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(staffs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(staffService.batchSaveStaff(staffs));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<Staff> update(Param param, @RequestBody Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staff);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(staffService.updateStaff(staff));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<Staff> batchUpdate(Param param, @RequestBody List<Staff> staffs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffs);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(staffs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(staffService.batchUpdateStaff(staffs));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<Staff> remove(Param param, @RequestBody Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staff);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      staffService.removeStaff(staff);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<Staff> batchRemove(Param param, @RequestBody List<Staff> staffs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffs);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(staffs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      staffService.batchRemoveStaff(staffs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 员工 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<Staff> getByPk(Param param, @RequestBody Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staff);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(staff.getStaffId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(staffService.getStaffByPk(staff.getStaffId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 员工 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<Staff> getAll(Param param, @RequestBody StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffQuery);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staffQuery)) {
        responses.setData(staffService.getAllStaff());
      } else {
        responses.setData(staffService.queryStaff(staffQuery));
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
   * 分页获取 员工 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<Staff> paging(Param param, @RequestBody StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffQuery);
    }
    Responses<Staff> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staffQuery)) {
        responses.setData(staffService.pagingQueryStaff(param, null));
      } else {
        responses.setData(staffService.pagingQueryStaff(param, staffQuery));
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
   * 通过主键获取 员工 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<StaffVO> getVOByPk(Param param, @RequestBody Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staff);
    }
    Responses<StaffVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(staff.getStaffId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(staffService.getStaffVOByPk(staff.getStaffId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 员工 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<StaffVO> getAllVO(Param param, @RequestBody StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffQuery);
    }
    Responses<StaffVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staffQuery)) {
        responses.setData(staffService.getAllStaffVO());
      } else {
        responses.setData(staffService.queryStaffVO(staffQuery));
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
   * 分页获取 员工 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<StaffVO> pagingVO(Param param, @RequestBody StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffQuery);
    }
    Responses<StaffVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staffQuery)) {
        responses.setData(staffService.pagingQueryStaffVO(param, null));
      } else {
        responses.setData(staffService.pagingQueryStaffVO(param, staffQuery));
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

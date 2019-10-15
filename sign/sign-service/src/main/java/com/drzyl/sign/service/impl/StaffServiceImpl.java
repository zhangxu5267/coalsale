package com.drzyl.sign.service.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.sign.entity.Staff;
import com.drzyl.sign.persistent.IStaffPersistent;
import com.drzyl.sign.query.StaffQuery;
import com.drzyl.sign.service.IStaffService;
import com.drzyl.sign.vo.StaffVO;
import lombok.extern.log4j.Log4j2;

/**
 * 员工 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.StaffService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class StaffServiceImpl implements IStaffService {

  public static final String LOG = "StaffService";

  @Resource(name = "com.drzyl.sign.StaffPersistent")
  private IStaffPersistent staffPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Staff saveStaff(Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staff);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      staff.setStaffId(ToolUtil.getUUID());
      return staffPersistent.saveStaff(staff);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Staff> batchSaveStaff(Collection<Staff> staffs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffs);
    }
    try {
      if (ToolUtil.isEmpty(staffs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Staff staff : staffs) {
        if (ToolUtil.isNullEntityAllFieldValue(staff)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        staff.setStaffId(ToolUtil.getUUID());
      }
      return staffPersistent.batchSaveStaff(staffs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Staff updateStaff(Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staff);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(staff.getStaffId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Staff oldStaff = staffPersistent.getStaffByPk(staff.getStaffId());
      if (ToolUtil.isNullEntityAllFieldValue(oldStaff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return staffPersistent.updateStaff(staff);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Staff> batchUpdateStaff(Collection<Staff> staffs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffs);
    }
    try {
      if (ToolUtil.isEmpty(staffs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Staff staff : staffs) {
        if (ToolUtil.isNullEntityAllFieldValue(staff)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(staff.getStaffId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        Staff oldStaff = staffPersistent.getStaffByPk(staff.getStaffId());
        if (ToolUtil.isNullEntityAllFieldValue(oldStaff)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return staffPersistent.batchUpdateStaff(staffs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeStaff(Staff staff) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staff);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(staff)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Staff> staffSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(staff.getStaffId())) {
        StaffQuery staffQuery = new StaffQuery();
        BeanUtils.copyProperties(staff, staffQuery);
        staffSet.addAll(staffPersistent.queryStaff(staffQuery));
      } else {
        Staff oldStaff = staffPersistent.getStaffByPk(staff.getStaffId());
        if (ToolUtil.isNullEntityAllFieldValue(oldStaff)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        staffSet.add(oldStaff);
      }
      if (ToolUtil.isNotEmpty(staffSet)) {
        staffPersistent.batchRemoveStaff(staffSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void batchRemoveStaff(Collection<Staff> staffs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffs);
    }
    try {
      if (ToolUtil.isEmpty(staffs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Staff> staffSet = new LinkedHashSet<>();
      for (Staff staff : staffs) {
        if (ToolUtil.isNullEntityAllFieldValue(staff)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(staff.getStaffId())) {
          StaffQuery staffQuery = new StaffQuery();
          BeanUtils.copyProperties(staff, staffQuery);
          staffSet.addAll(staffPersistent.queryStaff(staffQuery));
        } else {
          Staff oldStaff = staffPersistent.getStaffByPk(staff.getStaffId());
          if (ToolUtil.isNullEntityAllFieldValue(oldStaff)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          staffSet.add(oldStaff);
        }
      }
      if (ToolUtil.isNotEmpty(staffSet)) {
        staffPersistent.batchRemoveStaff(staffSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountStaff(StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffQuery);
    }
    try {
      return staffPersistent.getCountStaff(staffQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Staff getStaffByPk(String staffId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffId);
    }
    try {
      if (ToolUtil.isNullStr(staffId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return staffPersistent.getStaffByPk(staffId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Staff> getAllStaff() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return staffPersistent.getAllStaff();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Staff> queryStaff(StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffQuery);
    }
    try {
      return staffPersistent.queryStaff(staffQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<Staff> pagingQueryStaff(Param param, StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return staffPersistent.pagingQueryStaff(param, staffQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public StaffVO getStaffVOByPk(String staffId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffId);
    }
    try {
      if (ToolUtil.isNullStr(staffId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return staffPersistent.getStaffVOByPk(staffId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<StaffVO> getAllStaffVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return staffPersistent.getAllStaffVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<StaffVO> queryStaffVO(StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + staffQuery);
    }
    try {
      return staffPersistent.queryStaffVO(staffQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<StaffVO> pagingQueryStaffVO(Param param, StaffQuery staffQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + staffQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return staffPersistent.pagingQueryStaffVO(param, staffQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

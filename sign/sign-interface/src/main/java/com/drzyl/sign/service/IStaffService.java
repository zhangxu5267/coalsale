package com.drzyl.sign.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.sign.entity.Staff;
import com.drzyl.sign.query.StaffQuery;
import com.drzyl.sign.vo.StaffVO;

/**
 * 员工 服务接口
 */
public interface IStaffService {

  /**
   * 保存 员工 信息
   */
  public Staff saveStaff(Staff staff) throws Exception;

  /**
   * 批量保存 员工 信息
   */
  public Collection<Staff> batchSaveStaff(Collection<Staff> staffs) throws Exception;

  /**
   * 修改 员工 信息
   */
  public Staff updateStaff(Staff staff) throws Exception;

  /**
   * 批量修改 员工 信息
   */
  public Collection<Staff> batchUpdateStaff(Collection<Staff> staffs) throws Exception;

  /**
   * 删除 员工 信息
   */
  public void removeStaff(Staff staff) throws Exception;

  /**
   * 批量删除 员工 信息
   */
  public void batchRemoveStaff(Collection<Staff> staffs) throws Exception;

  /**
   * 获取 员工 数据量
   */
  public Long getCountStaff(StaffQuery staffQuery) throws Exception;

  /**
   * 通过主键获取 员工 数据
   */
  public Staff getStaffByPk(String staffId) throws Exception;

  /**
   * 获取 员工 所有数据
   */
  public Collection<Staff> getAllStaff() throws Exception;

  /**
   * 查询 员工 数据
   */
  public Collection<Staff> queryStaff(StaffQuery staffQuery) throws Exception;

  /**
   * 分页查询 员工 数据
   */
  public Paging<Staff> pagingQueryStaff(Param param, StaffQuery staffQuery) throws Exception;

  /**
   * 通过主键获取 员工 展示数据
   */
  public StaffVO getStaffVOByPk(String staffId) throws Exception;

  /**
   * 获取 员工 所有展示数据
   */
  public Collection<StaffVO> getAllStaffVO() throws Exception;

  /**
   * 查询 员工 展示数据
   */
  public Collection<StaffVO> queryStaffVO(StaffQuery staffQuery) throws Exception;

  /**
   * 分页查询 员工 展示数据
   */
  public Paging<StaffVO> pagingQueryStaffVO(Param param, StaffQuery staffQuery) throws Exception;

}

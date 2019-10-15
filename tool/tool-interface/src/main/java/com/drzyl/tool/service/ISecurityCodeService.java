package com.drzyl.tool.service;

import com.drzyl.tool.entity.SecurityCode;
import com.drzyl.tool.query.SecurityCodeQuery;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.vo.SecurityCodeVO;

import java.util.Collection;

/**
 * 短信验证码 服务接口
 */
public interface ISecurityCodeService {

  /**
   * 生产验证码
   */
  public SecurityCode sendSmsSecurityCode(String phoneNumber, String action) throws Exception;
  /**
   * 验证码校验
   */
  public int verifySecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception;
  /**
   * 保存 短信验证码 信息
   */
  public SecurityCode saveSecurityCode(SecurityCode securityCode) throws Exception;

  /**
   * 批量保存 短信验证码 信息
   */
  public Collection<SecurityCode> batchSaveSecurityCode(Collection<SecurityCode> securityCodes) throws Exception;

  /**
   * 修改 短信验证码 信息
   */
  public SecurityCode updateSecurityCode(SecurityCode securityCode) throws Exception;

  /**
   * 批量修改 短信验证码 信息
   */
  public Collection<SecurityCode> batchUpdateSecurityCode(Collection<SecurityCode> securityCodes) throws Exception;

  /**
   * 删除 短信验证码 信息
   */
  public void removeSecurityCode(SecurityCode securityCode) throws Exception;

  /**
   * 批量删除 短信验证码 信息
   */
  public void batchRemoveSecurityCode(Collection<SecurityCode> securityCodes) throws Exception;

  /**
   * 获取 短信验证码 数据量
   */
  public Long getCountSecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception;

  /**
   * 通过主键获取 短信验证码 数据
   */
  public SecurityCode getSecurityCodeByPk(String id) throws Exception;

  /**
   * 获取 短信验证码 所有数据
   */
  public Collection<SecurityCode> getAllSecurityCode() throws Exception;

  /**
   * 查询 短信验证码 数据
   */
  public Collection<SecurityCode> querySecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception;

  /**
   * 分页查询 短信验证码 数据
   */
  public Paging<SecurityCode> pagingQuerySecurityCode(Param param, SecurityCodeQuery securityCodeQuery) throws Exception;

  /**
   * 通过主键获取 短信验证码 展示数据
   */
  public SecurityCodeVO getSecurityCodeVOByPk(String id) throws Exception;

  /**
   * 获取 短信验证码 所有展示数据
   */
  public Collection<SecurityCodeVO> getAllSecurityCodeVO() throws Exception;

  /**
   * 查询 短信验证码 展示数据
   */
  public Collection<SecurityCodeVO> querySecurityCodeVO(SecurityCodeQuery securityCodeQuery) throws Exception;

  /**
   * 分页查询 短信验证码 展示数据
   */
  public Paging<SecurityCodeVO> pagingQuerySecurityCodeVO(Param param, SecurityCodeQuery securityCodeQuery) throws Exception;

}

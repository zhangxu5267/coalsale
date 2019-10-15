package com.drzyl.sign.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.sign.entity.Org;
import com.drzyl.sign.query.OrgQuery;
import com.drzyl.sign.vo.OrgVO;

/**
 * 组织机构 持久化接口
 */
public interface IOrgPersistent {

  public static final String TABLE_NAME = "SYS_ORG";

  /**
   * 保存 组织机构 信息
   */
  public Org saveOrg(Org org) throws Exception;

  /**
   * 批量保存 组织机构 信息
   */
  public Collection<Org> batchSaveOrg(Collection<Org> orgs) throws Exception;

  /**
   * 修改 组织机构 信息
   */
  public Org updateOrg(Org org) throws Exception;

  /**
   * 批量修改 组织机构 信息
   */
  public Collection<Org> batchUpdateOrg(Collection<Org> orgs) throws Exception;

  /**
   * 删除 组织机构 信息
   */
  public void removeOrg(Org org) throws Exception;

  /**
   * 批量删除 组织机构 信息
   */
  public void batchRemoveOrg(Collection<Org> orgs) throws Exception;

  /**
   * 获取 组织机构 数据量
   */
  public Long getCountOrg(OrgQuery orgQuery) throws Exception;

  /**
   * 通过主键获取 组织机构 数据
   */
  public Org getOrgByPk(String orgId) throws Exception;

  /**
   * 获取 组织机构 所有数据
   */
  public Collection<Org> getAllOrg() throws Exception;

  /**
   * 查询 组织机构 数据
   */
  public Collection<Org> queryOrg(OrgQuery orgQuery) throws Exception;

  /**
   * 分页查询 组织机构 数据
   */
  public Paging<Org> pagingQueryOrg(Param param, OrgQuery orgQuery) throws Exception;

  /**
   * 通过主键获取 组织机构 展示数据
   */
  public OrgVO getOrgVOByPk(String orgId) throws Exception;

  /**
   * 获取 组织机构 所有展示数据
   */
  public Collection<OrgVO> getAllOrgVO() throws Exception;

  /**
   * 查询 组织机构 展示数据
   */
  public Collection<OrgVO> queryOrgVO(OrgQuery orgQuery) throws Exception;

  /**
   * 分页查询 组织机构 展示数据
   */
  public Paging<OrgVO> pagingQueryOrgVO(Param param, OrgQuery orgQuery) throws Exception;

}

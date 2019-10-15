package com.drzyl.cus.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.cus.entity.CusTag;
import com.drzyl.cus.query.CusTagQuery;
import com.drzyl.cus.vo.CusTagVO;

/**
 * 客户标签表 服务接口
 */
public interface ICusTagService {

  /**
   * 保存 客户标签表 信息
   */
  public CusTag saveCusTag(CusTag cusTag) throws Exception;

  /**
   * 批量保存 客户标签表 信息
   */
  public Collection<CusTag> batchSaveCusTag(Collection<CusTag> cusTags) throws Exception;

  /**
   * 修改 客户标签表 信息
   */
  public CusTag updateCusTag(CusTag cusTag) throws Exception;

  /**
   * 批量修改 客户标签表 信息
   */
  public Collection<CusTag> batchUpdateCusTag(Collection<CusTag> cusTags) throws Exception;

  /**
   * 删除 客户标签表 信息
   */
  public void removeCusTag(CusTag cusTag) throws Exception;

  /**
   * 批量删除 客户标签表 信息
   */
  public void batchRemoveCusTag(Collection<CusTag> cusTags) throws Exception;

  /**
   * 获取 客户标签表 数据量
   */
  public Long getCountCusTag(CusTagQuery cusTagQuery) throws Exception;

  /**
   * 通过主键获取 客户标签表 数据
   */
  public CusTag getCusTagByPk(String cusTagId) throws Exception;

  /**
   * 获取 客户标签表 所有数据
   */
  public Collection<CusTag> getAllCusTag() throws Exception;

  /**
   * 查询 客户标签表 数据
   */
  public Collection<CusTag> queryCusTag(CusTagQuery cusTagQuery) throws Exception;

  /**
   * 分页查询 客户标签表 数据
   */
  public Paging<CusTag> pagingQueryCusTag(Param param, CusTagQuery cusTagQuery) throws Exception;

  /**
   * 通过主键获取 客户标签表 展示数据
   */
  public CusTagVO getCusTagVOByPk(String cusTagId) throws Exception;

  /**
   * 获取 客户标签表 所有展示数据
   */
  public Collection<CusTagVO> getAllCusTagVO() throws Exception;

  /**
   * 查询 客户标签表 展示数据
   */
  public Collection<CusTagVO> queryCusTagVO(CusTagQuery cusTagQuery) throws Exception;

  /**
   * 分页查询 客户标签表 展示数据
   */
  public Paging<CusTagVO> pagingQueryCusTagVO(Param param, CusTagQuery cusTagQuery) throws Exception;

}

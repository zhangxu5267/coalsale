package com.drzyl.sign.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.sign.entity.PostStaffNexus;
import com.drzyl.sign.query.PostStaffNexusQuery;
import com.drzyl.sign.vo.PostStaffNexusVO;

/**
 * 岗位员工 持久化接口
 */
public interface IPostStaffNexusPersistent {

  public static final String TABLE_NAME = "SYS_POST_STAFF_NEXUS";

  /**
   * 保存 岗位员工 信息
   */
  public PostStaffNexus savePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception;

  /**
   * 批量保存 岗位员工 信息
   */
  public Collection<PostStaffNexus> batchSavePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception;

  /**
   * 修改 岗位员工 信息
   */
  public PostStaffNexus updatePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception;

  /**
   * 批量修改 岗位员工 信息
   */
  public Collection<PostStaffNexus> batchUpdatePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception;

  /**
   * 删除 岗位员工 信息
   */
  public void removePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception;

  /**
   * 批量删除 岗位员工 信息
   */
  public void batchRemovePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception;

  /**
   * 获取 岗位员工 数据量
   */
  public Long getCountPostStaffNexus(PostStaffNexusQuery postStaffNexusQuery) throws Exception;

  /**
   * 通过主键获取 岗位员工 数据
   */
  public PostStaffNexus getPostStaffNexusByPk(String nexusId) throws Exception;

  /**
   * 获取 岗位员工 所有数据
   */
  public Collection<PostStaffNexus> getAllPostStaffNexus() throws Exception;

  /**
   * 查询 岗位员工 数据
   */
  public Collection<PostStaffNexus> queryPostStaffNexus(PostStaffNexusQuery postStaffNexusQuery) throws Exception;

  /**
   * 分页查询 岗位员工 数据
   */
  public Paging<PostStaffNexus> pagingQueryPostStaffNexus(Param param, PostStaffNexusQuery postStaffNexusQuery) throws Exception;

  /**
   * 通过主键获取 岗位员工 展示数据
   */
  public PostStaffNexusVO getPostStaffNexusVOByPk(String nexusId) throws Exception;

  /**
   * 获取 岗位员工 所有展示数据
   */
  public Collection<PostStaffNexusVO> getAllPostStaffNexusVO() throws Exception;

  /**
   * 查询 岗位员工 展示数据
   */
  public Collection<PostStaffNexusVO> queryPostStaffNexusVO(PostStaffNexusQuery postStaffNexusQuery) throws Exception;

  /**
   * 分页查询 岗位员工 展示数据
   */
  public Paging<PostStaffNexusVO> pagingQueryPostStaffNexusVO(Param param, PostStaffNexusQuery postStaffNexusQuery) throws Exception;

}

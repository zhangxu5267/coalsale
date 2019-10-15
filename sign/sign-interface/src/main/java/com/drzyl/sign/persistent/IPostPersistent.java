package com.drzyl.sign.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.sign.entity.Post;
import com.drzyl.sign.query.PostQuery;
import com.drzyl.sign.vo.PostVO;

/**
 * 岗位 持久化接口
 */
public interface IPostPersistent {

  public static final String TABLE_NAME = "SYS_POST";

  /**
   * 保存 岗位 信息
   */
  public Post savePost(Post post) throws Exception;

  /**
   * 批量保存 岗位 信息
   */
  public Collection<Post> batchSavePost(Collection<Post> posts) throws Exception;

  /**
   * 修改 岗位 信息
   */
  public Post updatePost(Post post) throws Exception;

  /**
   * 批量修改 岗位 信息
   */
  public Collection<Post> batchUpdatePost(Collection<Post> posts) throws Exception;

  /**
   * 删除 岗位 信息
   */
  public void removePost(Post post) throws Exception;

  /**
   * 批量删除 岗位 信息
   */
  public void batchRemovePost(Collection<Post> posts) throws Exception;

  /**
   * 获取 岗位 数据量
   */
  public Long getCountPost(PostQuery postQuery) throws Exception;

  /**
   * 通过主键获取 岗位 数据
   */
  public Post getPostByPk(String postId) throws Exception;

  /**
   * 获取 岗位 所有数据
   */
  public Collection<Post> getAllPost() throws Exception;

  /**
   * 查询 岗位 数据
   */
  public Collection<Post> queryPost(PostQuery postQuery) throws Exception;

  /**
   * 分页查询 岗位 数据
   */
  public Paging<Post> pagingQueryPost(Param param, PostQuery postQuery) throws Exception;

  /**
   * 通过主键获取 岗位 展示数据
   */
  public PostVO getPostVOByPk(String postId) throws Exception;

  /**
   * 获取 岗位 所有展示数据
   */
  public Collection<PostVO> getAllPostVO() throws Exception;

  /**
   * 查询 岗位 展示数据
   */
  public Collection<PostVO> queryPostVO(PostQuery postQuery) throws Exception;

  /**
   * 分页查询 岗位 展示数据
   */
  public Paging<PostVO> pagingQueryPostVO(Param param, PostQuery postQuery) throws Exception;

}

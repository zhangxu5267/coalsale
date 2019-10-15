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
import com.drzyl.sign.entity.Post;
import com.drzyl.sign.persistent.IPostPersistent;
import com.drzyl.sign.query.PostQuery;
import com.drzyl.sign.service.IPostService;
import com.drzyl.sign.vo.PostVO;
import lombok.extern.log4j.Log4j2;

/**
 * 岗位 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.PostService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class PostServiceImpl implements IPostService {

  public static final String LOG = "PostService";

  @Resource(name = "com.drzyl.sign.PostPersistent")
  private IPostPersistent postPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Post savePost(Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + post);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      post.setPostId(ToolUtil.getUUID());
      return postPersistent.savePost(post);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Post> batchSavePost(Collection<Post> posts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + posts);
    }
    try {
      if (ToolUtil.isEmpty(posts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Post post : posts) {
        if (ToolUtil.isNullEntityAllFieldValue(post)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        post.setPostId(ToolUtil.getUUID());
      }
      return postPersistent.batchSavePost(posts);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Post updatePost(Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + post);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(post.getPostId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Post oldPost = postPersistent.getPostByPk(post.getPostId());
      if (ToolUtil.isNullEntityAllFieldValue(oldPost)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postPersistent.updatePost(post);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Post> batchUpdatePost(Collection<Post> posts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + posts);
    }
    try {
      if (ToolUtil.isEmpty(posts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Post post : posts) {
        if (ToolUtil.isNullEntityAllFieldValue(post)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(post.getPostId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        Post oldPost = postPersistent.getPostByPk(post.getPostId());
        if (ToolUtil.isNullEntityAllFieldValue(oldPost)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return postPersistent.batchUpdatePost(posts);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removePost(Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + post);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Post> postSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(post.getPostId())) {
        PostQuery postQuery = new PostQuery();
        BeanUtils.copyProperties(post, postQuery);
        postSet.addAll(postPersistent.queryPost(postQuery));
      } else {
        Post oldPost = postPersistent.getPostByPk(post.getPostId());
        if (ToolUtil.isNullEntityAllFieldValue(oldPost)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        postSet.add(oldPost);
      }
      if (ToolUtil.isNotEmpty(postSet)) {
        postPersistent.batchRemovePost(postSet);
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
  public void batchRemovePost(Collection<Post> posts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + posts);
    }
    try {
      if (ToolUtil.isEmpty(posts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Post> postSet = new LinkedHashSet<>();
      for (Post post : posts) {
        if (ToolUtil.isNullEntityAllFieldValue(post)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(post.getPostId())) {
          PostQuery postQuery = new PostQuery();
          BeanUtils.copyProperties(post, postQuery);
          postSet.addAll(postPersistent.queryPost(postQuery));
        } else {
          Post oldPost = postPersistent.getPostByPk(post.getPostId());
          if (ToolUtil.isNullEntityAllFieldValue(oldPost)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          postSet.add(oldPost);
        }
      }
      if (ToolUtil.isNotEmpty(postSet)) {
        postPersistent.batchRemovePost(postSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountPost(PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postQuery);
    }
    try {
      return postPersistent.getCountPost(postQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Post getPostByPk(String postId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postId);
    }
    try {
      if (ToolUtil.isNullStr(postId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postPersistent.getPostByPk(postId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Post> getAllPost() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return postPersistent.getAllPost();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Post> queryPost(PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postQuery);
    }
    try {
      return postPersistent.queryPost(postQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<Post> pagingQueryPost(Param param, PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postPersistent.pagingQueryPost(param, postQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public PostVO getPostVOByPk(String postId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postId);
    }
    try {
      if (ToolUtil.isNullStr(postId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postPersistent.getPostVOByPk(postId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostVO> getAllPostVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return postPersistent.getAllPostVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostVO> queryPostVO(PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postQuery);
    }
    try {
      return postPersistent.queryPostVO(postQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<PostVO> pagingQueryPostVO(Param param, PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postPersistent.pagingQueryPostVO(param, postQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

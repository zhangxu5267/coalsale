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
import com.drzyl.sign.entity.Post;
import com.drzyl.sign.query.PostQuery;
import com.drzyl.sign.service.IPostService;
import com.drzyl.sign.vo.PostVO;
import lombok.extern.log4j.Log4j2;

/**
 * 岗位 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sign/post" })
public class PostController extends ToolController {

  public static final String LOG = "PostController";

  @Resource(name = "com.drzyl.sign.PostService")
  private IPostService postService;

  /**
   * 保存 岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<Post> save(Param param, @RequestBody Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + post);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postService.savePost(post));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<Post> batchSave(Param param, @RequestBody List<Post> posts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + posts);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(posts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postService.batchSavePost(posts));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<Post> update(Param param, @RequestBody Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + post);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postService.updatePost(post));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<Post> batchUpdate(Param param, @RequestBody List<Post> posts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + posts);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(posts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postService.batchUpdatePost(posts));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<Post> remove(Param param, @RequestBody Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + post);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      postService.removePost(post);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 岗位 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<Post> batchRemove(Param param, @RequestBody List<Post> posts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + posts);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(posts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      postService.batchRemovePost(posts);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 岗位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<Post> getByPk(Param param, @RequestBody Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + post);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(post.getPostId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postService.getPostByPk(post.getPostId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 岗位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<Post> getAll(Param param, @RequestBody PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postQuery);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postQuery)) {
        responses.setData(postService.getAllPost());
      } else {
        responses.setData(postService.queryPost(postQuery));
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
   * 分页获取 岗位 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<Post> paging(Param param, @RequestBody PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postQuery);
    }
    Responses<Post> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postQuery)) {
        responses.setData(postService.pagingQueryPost(param, null));
      } else {
        responses.setData(postService.pagingQueryPost(param, postQuery));
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
   * 通过主键获取 岗位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<PostVO> getVOByPk(Param param, @RequestBody Post post) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + post);
    }
    Responses<PostVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(post)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(post.getPostId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postService.getPostVOByPk(post.getPostId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 岗位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<PostVO> getAllVO(Param param, @RequestBody PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postQuery);
    }
    Responses<PostVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postQuery)) {
        responses.setData(postService.getAllPostVO());
      } else {
        responses.setData(postService.queryPostVO(postQuery));
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
   * 分页获取 岗位 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<PostVO> pagingVO(Param param, @RequestBody PostQuery postQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postQuery);
    }
    Responses<PostVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postQuery)) {
        responses.setData(postService.pagingQueryPostVO(param, null));
      } else {
        responses.setData(postService.pagingQueryPostVO(param, postQuery));
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

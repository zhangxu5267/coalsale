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
import com.drzyl.sign.entity.PostStaffNexus;
import com.drzyl.sign.query.PostStaffNexusQuery;
import com.drzyl.sign.service.IPostStaffNexusService;
import com.drzyl.sign.vo.PostStaffNexusVO;
import lombok.extern.log4j.Log4j2;

/**
 * 岗位员工 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "sign/postStaffNexus" })
public class PostStaffNexusController extends ToolController {

  public static final String LOG = "PostStaffNexusController";

  @Resource(name = "com.drzyl.sign.PostStaffNexusService")
  private IPostStaffNexusService postStaffNexusService;

  /**
   * 保存 岗位员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<PostStaffNexus> save(Param param, @RequestBody PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postStaffNexusService.savePostStaffNexus(postStaffNexus));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 岗位员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<PostStaffNexus> batchSave(Param param, @RequestBody List<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postStaffNexusService.batchSavePostStaffNexus(postStaffNexuss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 岗位员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<PostStaffNexus> update(Param param, @RequestBody PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postStaffNexusService.updatePostStaffNexus(postStaffNexus));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 岗位员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<PostStaffNexus> batchUpdate(Param param, @RequestBody List<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postStaffNexusService.batchUpdatePostStaffNexus(postStaffNexuss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 岗位员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<PostStaffNexus> remove(Param param, @RequestBody PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      postStaffNexusService.removePostStaffNexus(postStaffNexus);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 岗位员工 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<PostStaffNexus> batchRemove(Param param, @RequestBody List<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      postStaffNexusService.batchRemovePostStaffNexus(postStaffNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 岗位员工 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<PostStaffNexus> getByPk(Param param, @RequestBody PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postStaffNexusService.getPostStaffNexusByPk(postStaffNexus.getNexusId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 岗位员工 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<PostStaffNexus> getAll(Param param, @RequestBody PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        responses.setData(postStaffNexusService.getAllPostStaffNexus());
      } else {
        responses.setData(postStaffNexusService.queryPostStaffNexus(postStaffNexusQuery));
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
   * 分页获取 岗位员工 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<PostStaffNexus> paging(Param param, @RequestBody PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    Responses<PostStaffNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        responses.setData(postStaffNexusService.pagingQueryPostStaffNexus(param, null));
      } else {
        responses.setData(postStaffNexusService.pagingQueryPostStaffNexus(param, postStaffNexusQuery));
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
   * 通过主键获取 岗位员工 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<PostStaffNexusVO> getVOByPk(Param param, @RequestBody PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    Responses<PostStaffNexusVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(postStaffNexusService.getPostStaffNexusVOByPk(postStaffNexus.getNexusId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 岗位员工 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<PostStaffNexusVO> getAllVO(Param param, @RequestBody PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    Responses<PostStaffNexusVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        responses.setData(postStaffNexusService.getAllPostStaffNexusVO());
      } else {
        responses.setData(postStaffNexusService.queryPostStaffNexusVO(postStaffNexusQuery));
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
   * 分页获取 岗位员工 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<PostStaffNexusVO> pagingVO(Param param, @RequestBody PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    Responses<PostStaffNexusVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        responses.setData(postStaffNexusService.pagingQueryPostStaffNexusVO(param, null));
      } else {
        responses.setData(postStaffNexusService.pagingQueryPostStaffNexusVO(param, postStaffNexusQuery));
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

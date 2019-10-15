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
import com.drzyl.sign.entity.PostStaffNexus;
import com.drzyl.sign.persistent.IPostStaffNexusPersistent;
import com.drzyl.sign.query.PostStaffNexusQuery;
import com.drzyl.sign.service.IPostStaffNexusService;
import com.drzyl.sign.vo.PostStaffNexusVO;
import lombok.extern.log4j.Log4j2;

/**
 * 岗位员工 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.PostStaffNexusService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class PostStaffNexusServiceImpl implements IPostStaffNexusService {

  public static final String LOG = "PostStaffNexusService";

  @Resource(name = "com.drzyl.sign.PostStaffNexusPersistent")
  private IPostStaffNexusPersistent postStaffNexusPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public PostStaffNexus savePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      postStaffNexus.setNexusId(ToolUtil.getUUID());
      return postStaffNexusPersistent.savePostStaffNexus(postStaffNexus);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<PostStaffNexus> batchSavePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (PostStaffNexus postStaffNexus : postStaffNexuss) {
        if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        postStaffNexus.setNexusId(ToolUtil.getUUID());
      }
      return postStaffNexusPersistent.batchSavePostStaffNexus(postStaffNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public PostStaffNexus updatePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      PostStaffNexus oldPostStaffNexus = postStaffNexusPersistent.getPostStaffNexusByPk(postStaffNexus.getNexusId());
      if (ToolUtil.isNullEntityAllFieldValue(oldPostStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postStaffNexusPersistent.updatePostStaffNexus(postStaffNexus);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<PostStaffNexus> batchUpdatePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (PostStaffNexus postStaffNexus : postStaffNexuss) {
        if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        PostStaffNexus oldPostStaffNexus = postStaffNexusPersistent.getPostStaffNexusByPk(postStaffNexus.getNexusId());
        if (ToolUtil.isNullEntityAllFieldValue(oldPostStaffNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return postStaffNexusPersistent.batchUpdatePostStaffNexus(postStaffNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<PostStaffNexus> postStaffNexusSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
        PostStaffNexusQuery postStaffNexusQuery = new PostStaffNexusQuery();
        BeanUtils.copyProperties(postStaffNexus, postStaffNexusQuery);
        postStaffNexusSet.addAll(postStaffNexusPersistent.queryPostStaffNexus(postStaffNexusQuery));
      } else {
        PostStaffNexus oldPostStaffNexus = postStaffNexusPersistent.getPostStaffNexusByPk(postStaffNexus.getNexusId());
        if (ToolUtil.isNullEntityAllFieldValue(oldPostStaffNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        postStaffNexusSet.add(oldPostStaffNexus);
      }
      if (ToolUtil.isNotEmpty(postStaffNexusSet)) {
        postStaffNexusPersistent.batchRemovePostStaffNexus(postStaffNexusSet);
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
  public void batchRemovePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<PostStaffNexus> postStaffNexusSet = new LinkedHashSet<>();
      for (PostStaffNexus postStaffNexus : postStaffNexuss) {
        if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
          PostStaffNexusQuery postStaffNexusQuery = new PostStaffNexusQuery();
          BeanUtils.copyProperties(postStaffNexus, postStaffNexusQuery);
          postStaffNexusSet.addAll(postStaffNexusPersistent.queryPostStaffNexus(postStaffNexusQuery));
        } else {
          PostStaffNexus oldPostStaffNexus = postStaffNexusPersistent.getPostStaffNexusByPk(postStaffNexus.getNexusId());
          if (ToolUtil.isNullEntityAllFieldValue(oldPostStaffNexus)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          postStaffNexusSet.add(oldPostStaffNexus);
        }
      }
      if (ToolUtil.isNotEmpty(postStaffNexusSet)) {
        postStaffNexusPersistent.batchRemovePostStaffNexus(postStaffNexusSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountPostStaffNexus(PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      return postStaffNexusPersistent.getCountPostStaffNexus(postStaffNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public PostStaffNexus getPostStaffNexusByPk(String nexusId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postStaffNexusPersistent.getPostStaffNexusByPk(nexusId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexus> getAllPostStaffNexus() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return postStaffNexusPersistent.getAllPostStaffNexus();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexus> queryPostStaffNexus(PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      return postStaffNexusPersistent.queryPostStaffNexus(postStaffNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<PostStaffNexus> pagingQueryPostStaffNexus(Param param, PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postStaffNexusPersistent.pagingQueryPostStaffNexus(param, postStaffNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public PostStaffNexusVO getPostStaffNexusVOByPk(String nexusId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postStaffNexusPersistent.getPostStaffNexusVOByPk(nexusId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexusVO> getAllPostStaffNexusVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return postStaffNexusPersistent.getAllPostStaffNexusVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexusVO> queryPostStaffNexusVO(PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      return postStaffNexusPersistent.queryPostStaffNexusVO(postStaffNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<PostStaffNexusVO> pagingQueryPostStaffNexusVO(Param param, PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return postStaffNexusPersistent.pagingQueryPostStaffNexusVO(param, postStaffNexusQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

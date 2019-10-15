package com.drzyl.upload.file.service.impl;

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
import com.drzyl.upload.file.entity.UploadFile;
import com.drzyl.upload.file.persistent.IUploadFilePersistent;
import com.drzyl.upload.file.query.UploadFileQuery;
import com.drzyl.upload.file.service.IUploadFileService;
import com.drzyl.upload.file.vo.UploadFileVO;
import lombok.extern.log4j.Log4j2;

/**
 * 上传文件 服务实现
 */
@Log4j2
@Service("com.drzyl.upload.file.UploadFileService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class UploadFileServiceImpl implements IUploadFileService {

  public static final String LOG = "UploadFileService";

  @Resource(name = "com.drzyl.upload.file.UploadFilePersistent")
  private IUploadFilePersistent uploadFilePersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public UploadFile saveUploadFile(UploadFile uploadFile) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFile);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      uploadFile.setFileId(ToolUtil.getUUID());
      return uploadFilePersistent.saveUploadFile(uploadFile);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<UploadFile> batchSaveUploadFile(Collection<UploadFile> uploadFiles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFiles);
    }
    try {
      if (ToolUtil.isEmpty(uploadFiles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (UploadFile uploadFile : uploadFiles) {
        if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        uploadFile.setFileId(ToolUtil.getUUID());
      }
      return uploadFilePersistent.batchSaveUploadFile(uploadFiles);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public UploadFile updateUploadFile(UploadFile uploadFile) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFile);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(uploadFile.getFileId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      UploadFile oldUploadFile = uploadFilePersistent.getUploadFileByPk(uploadFile.getFileId());
      if (ToolUtil.isNullEntityAllFieldValue(oldUploadFile)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return uploadFilePersistent.updateUploadFile(uploadFile);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<UploadFile> batchUpdateUploadFile(Collection<UploadFile> uploadFiles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFiles);
    }
    try {
      if (ToolUtil.isEmpty(uploadFiles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (UploadFile uploadFile : uploadFiles) {
        if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(uploadFile.getFileId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        UploadFile oldUploadFile = uploadFilePersistent.getUploadFileByPk(uploadFile.getFileId());
        if (ToolUtil.isNullEntityAllFieldValue(oldUploadFile)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return uploadFilePersistent.batchUpdateUploadFile(uploadFiles);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeUploadFile(UploadFile uploadFile) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFile);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<UploadFile> uploadFileSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(uploadFile.getFileId())) {
        UploadFileQuery uploadFileQuery = new UploadFileQuery();
        BeanUtils.copyProperties(uploadFile, uploadFileQuery);
        uploadFileSet.addAll(uploadFilePersistent.queryUploadFile(uploadFileQuery));
      } else {
        UploadFile oldUploadFile = uploadFilePersistent.getUploadFileByPk(uploadFile.getFileId());
        if (ToolUtil.isNullEntityAllFieldValue(oldUploadFile)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        uploadFileSet.add(oldUploadFile);
      }
      if (ToolUtil.isNotEmpty(uploadFileSet)) {
        uploadFilePersistent.batchRemoveUploadFile(uploadFileSet);
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
  public void batchRemoveUploadFile(Collection<UploadFile> uploadFiles) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFiles);
    }
    try {
      if (ToolUtil.isEmpty(uploadFiles)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<UploadFile> uploadFileSet = new LinkedHashSet<>();
      for (UploadFile uploadFile : uploadFiles) {
        if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(uploadFile.getFileId())) {
          UploadFileQuery uploadFileQuery = new UploadFileQuery();
          BeanUtils.copyProperties(uploadFile, uploadFileQuery);
          uploadFileSet.addAll(uploadFilePersistent.queryUploadFile(uploadFileQuery));
        } else {
          UploadFile oldUploadFile = uploadFilePersistent.getUploadFileByPk(uploadFile.getFileId());
          if (ToolUtil.isNullEntityAllFieldValue(oldUploadFile)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          uploadFileSet.add(oldUploadFile);
        }
      }
      if (ToolUtil.isNotEmpty(uploadFileSet)) {
        uploadFilePersistent.batchRemoveUploadFile(uploadFileSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountUploadFile(UploadFileQuery uploadFileQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFileQuery);
    }
    try {
      return uploadFilePersistent.getCountUploadFile(uploadFileQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public UploadFile getUploadFileByPk(String fileId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + fileId);
    }
    try {
      if (ToolUtil.isNullStr(fileId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return uploadFilePersistent.getUploadFileByPk(fileId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<UploadFile> getAllUploadFile() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return uploadFilePersistent.getAllUploadFile();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<UploadFile> queryUploadFile(UploadFileQuery uploadFileQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFileQuery);
    }
    try {
      return uploadFilePersistent.queryUploadFile(uploadFileQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<UploadFile> pagingQueryUploadFile(Param param, UploadFileQuery uploadFileQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + uploadFileQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return uploadFilePersistent.pagingQueryUploadFile(param, uploadFileQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public UploadFileVO getUploadFileVOByPk(String fileId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + fileId);
    }
    try {
      if (ToolUtil.isNullStr(fileId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return uploadFilePersistent.getUploadFileVOByPk(fileId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<UploadFileVO> getAllUploadFileVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return uploadFilePersistent.getAllUploadFileVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<UploadFileVO> queryUploadFileVO(UploadFileQuery uploadFileQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + uploadFileQuery);
    }
    try {
      return uploadFilePersistent.queryUploadFileVO(uploadFileQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<UploadFileVO> pagingQueryUploadFileVO(Param param, UploadFileQuery uploadFileQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + uploadFileQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return uploadFilePersistent.pagingQueryUploadFileVO(param, uploadFileQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}

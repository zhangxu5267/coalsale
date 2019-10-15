package com.drzyl.upload.file.persistent;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.upload.file.entity.UploadFile;
import com.drzyl.upload.file.query.UploadFileQuery;
import com.drzyl.upload.file.vo.UploadFileVO;

/**
 * 上传文件 持久化接口
 */
public interface IUploadFilePersistent {

  public static final String TABLE_NAME = "PAR_UPLOAD_FILE";

  /**
   * 保存 上传文件 信息
   */
  public UploadFile saveUploadFile(UploadFile uploadFile) throws Exception;

  /**
   * 批量保存 上传文件 信息
   */
  public Collection<UploadFile> batchSaveUploadFile(Collection<UploadFile> uploadFiles) throws Exception;

  /**
   * 修改 上传文件 信息
   */
  public UploadFile updateUploadFile(UploadFile uploadFile) throws Exception;

  /**
   * 批量修改 上传文件 信息
   */
  public Collection<UploadFile> batchUpdateUploadFile(Collection<UploadFile> uploadFiles) throws Exception;

  /**
   * 删除 上传文件 信息
   */
  public void removeUploadFile(UploadFile uploadFile) throws Exception;

  /**
   * 批量删除 上传文件 信息
   */
  public void batchRemoveUploadFile(Collection<UploadFile> uploadFiles) throws Exception;

  /**
   * 获取 上传文件 数据量
   */
  public Long getCountUploadFile(UploadFileQuery uploadFileQuery) throws Exception;

  /**
   * 通过主键获取 上传文件 数据
   */
  public UploadFile getUploadFileByPk(String fileId) throws Exception;

  /**
   * 获取 上传文件 所有数据
   */
  public Collection<UploadFile> getAllUploadFile() throws Exception;

  /**
   * 查询 上传文件 数据
   */
  public Collection<UploadFile> queryUploadFile(UploadFileQuery uploadFileQuery) throws Exception;

  /**
   * 分页查询 上传文件 数据
   */
  public Paging<UploadFile> pagingQueryUploadFile(Param param, UploadFileQuery uploadFileQuery) throws Exception;

  /**
   * 通过主键获取 上传文件 展示数据
   */
  public UploadFileVO getUploadFileVOByPk(String fileId) throws Exception;

  /**
   * 获取 上传文件 所有展示数据
   */
  public Collection<UploadFileVO> getAllUploadFileVO() throws Exception;

  /**
   * 查询 上传文件 展示数据
   */
  public Collection<UploadFileVO> queryUploadFileVO(UploadFileQuery uploadFileQuery) throws Exception;

  /**
   * 分页查询 上传文件 展示数据
   */
  public Paging<UploadFileVO> pagingQueryUploadFileVO(Param param, UploadFileQuery uploadFileQuery) throws Exception;

}

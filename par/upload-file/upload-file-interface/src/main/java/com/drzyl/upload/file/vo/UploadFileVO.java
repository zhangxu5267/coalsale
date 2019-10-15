package com.drzyl.upload.file.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 上传文件 PAR_UPLOAD_FILE 展示类
 */
@Data
public class UploadFileVO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String fileId; // ID

  protected String fileName; // 文件名称

  protected String fileUrl; // 文件路径

  protected String fileType; // 文件类型

  protected String fileSize; // 文件大小(单位B)

  protected String fileSuffix; // 文件后缀

  protected String module; // 文件来源模块

  protected String moduleHash; // 来源HASH

  protected String remark; // 备注

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected String createOrg; // 创建机构

  protected Long createTimes; // 创建时间

  protected String delFlag; // 逻辑删除0=删除,1=显示

  protected boolean deleteSuccess; // 删除成功 = true

  protected String msg; // 操作信息



}

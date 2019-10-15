package com.drzyl.upload.file.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 上传文件 PAR_UPLOAD_FILE 查询类
 */
@Data
public class UploadFileQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

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

  protected List<String> fileIdAndin; // IDAndin查询

  protected String fileNameAndKeyLike; // 文件名称AndKeyLike查询

  protected String fileUrlOrKeyLike; // 文件路径OrKeyLike查询

  protected String fileTypeOrKeyLike; // 文件类型OrKeyLike查询

  protected String fileSizeOrKeyLike; // 文件大小(单位B)OrKeyLike查询

  protected String fileSuffixOrKeyLike; // 文件后缀OrKeyLike查询

  protected String moduleOrKeyLike; // 文件来源模块OrKeyLike查询

  protected String moduleHashOrKeyLike; // 来源HASHOrKeyLike查询

  protected String remarkOrKeyLike; // 备注OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String createOrgOrKeyLike; // 创建机构OrKeyLike查询

  protected String delFlagOrKeyLike; // 逻辑删除0=删除,1=显示OrKeyLike查询

}

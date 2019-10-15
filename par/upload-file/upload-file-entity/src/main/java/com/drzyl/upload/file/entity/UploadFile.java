package com.drzyl.upload.file.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 上传文件 PAR_UPLOAD_FILE 实体类
 */
@Data
@TableName(value = "PAR_UPLOAD_FILE")
public class UploadFile implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId
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

	@Override
	public UploadFile clone() throws CloneNotSupportedException {
		UploadFile uploadFile = new UploadFile();
		uploadFile.fileId = this.fileId;
		uploadFile.fileName = this.fileName;
		uploadFile.fileSize = this.fileSize;
		uploadFile.fileSuffix = this.fileSuffix;
		uploadFile.fileType = this.fileType;
		uploadFile.fileUrl = this.fileUrl;
		uploadFile.module = this.module;
		uploadFile.moduleHash = this.module;
		uploadFile.remark = this.module;
		uploadFile.versions = this.versions;
		uploadFile.createId = this.createId;
		uploadFile.createName = this.createName;
		uploadFile.createOrg = this.createOrg;
		uploadFile.createName = this.createName;
		uploadFile.createTimes = this.createTimes;
		uploadFile.delFlag = this.delFlag;
		return uploadFile;
	}
}

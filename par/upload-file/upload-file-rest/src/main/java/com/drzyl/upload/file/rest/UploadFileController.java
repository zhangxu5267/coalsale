package com.drzyl.upload.file.rest;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ResponsesItem;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.FileUtils;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.StringUtils;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.upload.file.entity.UploadFile;
import com.drzyl.upload.file.query.UploadFileQuery;
import com.drzyl.upload.file.service.IUploadFileService;
import com.drzyl.upload.file.vo.UploadFileVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 上传文件 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = {"upload/file"})
public class UploadFileController extends ToolController {

	public static final String LOG = "UploadFileController";

	@Resource(name = "com.drzyl.upload.file.UploadFileService")
	private IUploadFileService uploadFileService;

	String paramurl;

	/**
	 * 附件上传(批量)
	 */
	@PostMapping(params = {ToolUtil.ACTION + "upload"})
	public Responses<UploadFile> upLoad(@RequestParam(value = "moduleName", required = false) String moduleName,/* 上传模块*/@RequestParam("file") MultipartFile[] files,/* 上传的文件信息*/HttpServletRequest request
	) {
		Responses<UploadFile> responses = new Responses<>();
		// 判断文件是否为空，空则返回失败页面
		if (files.length < 1) {
			responses.isDefeated("没有上传文件");
			return responses;
		}
		if (moduleName == null || "".equals(moduleName.trim())) {
			responses.isDefeated("缺少模块名称");
			return responses;
		}
		List<UploadFile> uploadFiles = new ArrayList<>();
		try {
			for (MultipartFile file : files
			) {
				UploadFile uploadFile = new UploadFile();
				// 获取原文件名
				String fileName = file.getOriginalFilename();
				// 获取文件后缀
				String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
				// 解析文件类型
				String type = FileUtils.analyFileType(fileSuffix);
				// 获取文件存储路径（绝对路径）根路径 + 模块名称 + 用户名 + 日期 + 文件类型 + 文件名
				String path = FileUtils.UPLOAD_SAVE_ROOT_PATH + File.separator //根路径
								+ moduleName + File.separator //模块名称
								+ "用户名" + File.separator //当前登录用户名
								+ LocalDateTime.now().toLocalDate() + File.separator //日期
								+ type + File.separator//文件类型
								+ Long.toHexString(System.currentTimeMillis()) + fileSuffix;//文件名
				byte[] bytes = file.getBytes();
				uploadFile.setFileName(fileName);
				uploadFile.setFileSize(String.valueOf(bytes.length));
				uploadFile.setFileSuffix(fileSuffix);
				uploadFile.setModule(moduleName);
				uploadFile.setFileType(type);
				uploadFile.setFileUrl(path);
				/*****************保存文件*******************/
				// 创建目录 , 保存文件
				if (FileUtils.createDirectory(path) || FileUtils.createFile(path)) {
					/*****************保存数据*******************/
					UploadFile saveUploadFile = uploadFileService.saveUploadFile(uploadFile);
					uploadFiles.add(saveUploadFile.clone());
				}
			}
		} catch (Exception e) {
			log.error("文件保存失败");
			e.printStackTrace();
			return responses.isDefeated("文件保存失败");
		}
		responses.setMsg("文件上传成功");
		responses.setData(uploadFiles);
		return responses;
	}

	/**
	 * 附件删除(批量)
	 */
	@PostMapping(params = {ToolUtil.ACTION + "delFile"})
	public Responses<ResponsesItem> upLoad(Param param, @RequestBody List<UploadFile> uploadFiles) throws Exception {
		Responses<ResponsesItem> responses = new Responses<>();
		List<ResponsesItem> items = new ArrayList<>();
		// 删除文件
		Iterator<UploadFile> iterator = uploadFiles.iterator();
		int totalSuccess = 0;
		int totalDefeated = 0;
		while (iterator.hasNext()) {
			ResponsesItem<?> responsesItem = new ResponsesItem();
			UploadFile uploadFile = iterator.next();
			// 根据ID查找
			UploadFileVO uploadFileVOByPk = new UploadFileVO();
			if (uploadFile.getFileId() != null && !"".equals(uploadFile.getFileId().trim())) {
				// 获取信息
				uploadFileVOByPk = uploadFileService.getUploadFileVOByPk(uploadFile.getFileId());
				if (uploadFileVOByPk != null && StringUtils.isEmpty(uploadFile.getFileUrl()) ) {
					// 删除文件
					if (FileUtils.deleteFile(uploadFileVOByPk.getFileUrl())) {
						responsesItem.isSuccess(uploadFileVOByPk.getFileName() + ":删除成功");
						totalSuccess++;
					} else {
						responsesItem.isSuccess(uploadFileVOByPk.getFileName() + ":删除失败");
					}
					items.add(responsesItem);
				} else {
					responsesItem.isDefeated(uploadFile.getFileName() + ":文件不存在");
					items.add(responsesItem);
				}
			} else {
				responsesItem.isDefeated(uploadFile.getFileName() + ":ID错误");
				items.add(responsesItem);
			}
		}
		responses.setMsg("删除成功" + totalSuccess + "个文件;");
		responses.setData(items);
		return responses;
	}

	/**
	 * 保存 上传文件 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_SAVE})
	public Responses<UploadFile> save(Param param, @RequestBody UploadFile uploadFile) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFile);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(uploadFileService.saveUploadFile(uploadFile));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量保存 上传文件 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE})
	public Responses<UploadFile> batchSave(Param param, @RequestBody List<UploadFile> uploadFiles) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFiles);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(uploadFiles)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(uploadFileService.batchSaveUploadFile(uploadFiles));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 修改 上传文件 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_UPDATE})
	public Responses<UploadFile> update(Param param, @RequestBody UploadFile uploadFile) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFile);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(uploadFileService.updateUploadFile(uploadFile));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量修改 上传文件 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE})
	public Responses<UploadFile> batchUpdate(Param param, @RequestBody List<UploadFile> uploadFiles) throws
					Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFiles);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(uploadFiles)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(uploadFileService.batchUpdateUploadFile(uploadFiles));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 删除 上传文件 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_REMOVE})
	public Responses<UploadFile> remove(Param param, @RequestBody UploadFile uploadFile) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFile);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			uploadFileService.removeUploadFile(uploadFile);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量删除 上传文件 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE})
	public Responses<UploadFile> batchRemove(Param param, @RequestBody List<UploadFile> uploadFiles) throws
					Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFiles);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(uploadFiles)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			uploadFileService.batchRemoveUploadFile(uploadFiles);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 通过主键获取 上传文件 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK})
	public Responses<UploadFile> getByPk(Param param, @RequestBody UploadFile uploadFile) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFile);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(uploadFile.getFileId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(uploadFileService.getUploadFileByPk(uploadFile.getFileId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 上传文件 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL})
	public Responses<UploadFile> getAll(Param param, @RequestBody UploadFileQuery uploadFileQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFileQuery);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFileQuery)) {
				responses.setData(uploadFileService.getAllUploadFile());
			} else {
				responses.setData(uploadFileService.queryUploadFile(uploadFileQuery));
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
	 * 分页获取 上传文件 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING})
	public Responses<UploadFile> paging(Param param, @RequestBody UploadFileQuery uploadFileQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFileQuery);
		}
		Responses<UploadFile> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFileQuery)) {
				responses.setData(uploadFileService.pagingQueryUploadFile(param, null));
			} else {
				responses.setData(uploadFileService.pagingQueryUploadFile(param, uploadFileQuery));
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
	 * 通过主键获取 上传文件 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK})
	public Responses<UploadFileVO> getVOByPk(Param param, @RequestBody UploadFile uploadFile) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFile);
		}
		Responses<UploadFileVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFile)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(uploadFile.getFileId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(uploadFileService.getUploadFileVOByPk(uploadFile.getFileId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 上传文件 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO})
	public Responses<UploadFileVO> getAllVO(Param param, @RequestBody UploadFileQuery uploadFileQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFileQuery);
		}
		Responses<UploadFileVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFileQuery)) {
				responses.setData(uploadFileService.getAllUploadFileVO());
			} else {
				responses.setData(uploadFileService.queryUploadFileVO(uploadFileQuery));
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
	 * 分页获取 上传文件 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO})
	public Responses<UploadFileVO> pagingVO(Param param, @RequestBody UploadFileQuery uploadFileQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + uploadFileQuery);
		}
		Responses<UploadFileVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(uploadFileQuery)) {
				responses.setData(uploadFileService.pagingQueryUploadFileVO(param, null));
			} else {
				responses.setData(uploadFileService.pagingQueryUploadFileVO(param, uploadFileQuery));
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

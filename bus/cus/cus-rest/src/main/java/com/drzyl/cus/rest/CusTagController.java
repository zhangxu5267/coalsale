package com.drzyl.cus.rest;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.html.HTML;

import com.drzyl.cus.business.service.impl.TagService;
import com.drzyl.cus.entity.CusBase;
import com.drzyl.cus.mapper.TagMapper;
import com.drzyl.cus.vo.CusBaseVO;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.drzyl.cus.entity.CusTag;
import com.drzyl.cus.query.CusTagQuery;
import com.drzyl.cus.service.ICusTagService;
import com.drzyl.cus.vo.CusTagVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户标签表 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = {"cus/cusTag"})
public class CusTagController extends ToolController {

	public static final String LOG = "CusTagController";

	@Resource(name = "com.drzyl.cus.CusTagService")
	private ICusTagService cusTagService;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private TagService tagService;

	/**
	 * 保存 客户标签表 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_SAVE})
	public Responses<CusTag> save(Param param, @RequestBody CusTag cusTag) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTag);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusTagService.saveCusTag(cusTag));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量保存 客户标签表 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE})
	public Responses<CusTag> batchSave(Param param, @RequestBody List<CusTag> cusTags) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTags);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(cusTags)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusTagService.batchSaveCusTag(cusTags));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 修改 客户标签表 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_UPDATE})
	public Responses<CusTag> update(Param param, @RequestBody CusTag cusTag) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTag);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusTagService.updateCusTag(cusTag));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量修改 客户标签表 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE})
	public Responses<CusTag> batchUpdate(Param param, @RequestBody List<CusTag> cusTags) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTags);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(cusTags)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusTagService.batchUpdateCusTag(cusTags));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 删除 客户标签表 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_REMOVE})
	public Responses<CusTag> remove(Param param, @RequestBody CusTag cusTag) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTag);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			cusTagService.removeCusTag(cusTag);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量删除 客户标签表 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE})
	public Responses<CusTag> batchRemove(Param param, @RequestBody List<CusTag> cusTags) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTags);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(cusTags)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			cusTagService.batchRemoveCusTag(cusTags);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 通过主键获取 客户标签表 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK})
	public Responses<CusTag> getByPk(Param param, @RequestBody CusTag cusTag) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTag);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(cusTag.getCusTagId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusTagService.getCusTagByPk(cusTag.getCusTagId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 客户标签表 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL})
	public Responses<CusTag> getAll(Param param, @RequestBody CusTagQuery cusTagQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTagQuery);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTagQuery)) {
				responses.setData(cusTagService.getAllCusTag());
			} else {
				responses.setData(cusTagService.queryCusTag(cusTagQuery));
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
	 * 分页获取 客户标签表 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING})
	public Responses<CusTag> paging(Param param, @RequestBody CusTagQuery cusTagQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTagQuery);
		}
		Responses<CusTag> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTagQuery)) {
				responses.setData(cusTagService.pagingQueryCusTag(param, null));
			} else {
				responses.setData(cusTagService.pagingQueryCusTag(param, cusTagQuery));
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
	 * 通过主键获取 客户标签表 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK})
	public Responses<CusTagVO> getVOByPk(Param param, @RequestBody CusTag cusTag) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTag);
		}
		Responses<CusTagVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(cusTag.getCusTagId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusTagService.getCusTagVOByPk(cusTag.getCusTagId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 客户标签表 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO})
	public Responses<CusTagVO> getAllVO(Param param, @RequestBody CusTagQuery cusTagQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTagQuery);
		}
		Responses<CusTagVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTagQuery)) {
				responses.setData(cusTagService.getAllCusTagVO());
			} else {
				responses.setData(cusTagService.queryCusTagVO(cusTagQuery));
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
	 * 分页获取 客户标签表 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO})
	public Responses<CusTagVO> pagingVO(Param param, @RequestBody CusTagQuery cusTagQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTagQuery);
		}
		Responses<CusTagVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTagQuery)) {
				responses.setData(cusTagService.pagingQueryCusTagVO(param, null));
			} else {
				responses.setData(cusTagService.pagingQueryCusTagVO(param, cusTagQuery));
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
	 * 通过主键获取 客户标签表以及多个客户数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + "get_by_pk_detail"})
	public Responses<CusTagVO> getByPkOfDetail(Param param, @RequestBody CusTag cusTag) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusTag);
		}
		Responses<CusTagVO> responses = new Responses<CusTagVO>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusTag)) {
				responses.isDefeated("没有传递参数");
			}
			if (ToolUtil.isNullStr(cusTag.getCusTagId())) {
				responses.isDefeated("没有传递ID");
			}
			CusTagVO cusTagVO = cusTagService.getCusTagVOByPk(cusTag.getCusTagId());
			if (cusTagVO!=null) {
				LinkedList<CusBaseVO> bases = tagService.getByPkOfDetail(cusTag);
				cusTagVO.setCusBaseVOs(bases);
				responses.setData(cusTagVO);
			}else {
				return responses.isDefeated("该标签不存在");
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

package com.drzyl.cus.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.drzyl.cus.service.ICusService;
import com.drzyl.cus.vo.CusVO;
import com.drzyl.tool.util.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.cus.entity.CusBase;
import com.drzyl.cus.query.CusBaseQuery;
import com.drzyl.cus.service.ICusBaseService;
import com.drzyl.cus.vo.CusBaseVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户基础信息 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = {"cus/cus"})
public class CusBaseController extends ToolController {

	public static final String LOG = "CusBaseController";

	@Resource(name = "com.drzyl.cus.CusBaseService")
	private ICusBaseService cusBaseService;

	@Autowired
	private ICusService cusService;// 客户所有信息保存
	/*@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	RedisUtils redisUtils;
	@PostMapping("get")
	public Object get(Param param) {
		Object action = redisUtils.get("aaa");
		return action;
	}

	@PostMapping("set")
	public String set(Param param) {
		boolean b = redisUtils.set("aaa", param.getAction());
		return "good";
	}*/
	/**
	 * 保存 客户基础信息 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_SAVE + "_1"})
	public Responses<CusBase> save(Param param, @RequestBody CusBase cusBase) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBase);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusBaseService.saveCusBase(cusBase));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量保存 客户基础信息 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE})
	public Responses<CusBase> batchSave(Param param, @RequestBody List<CusBase> cusBases) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBases);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(cusBases)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusBaseService.batchSaveCusBase(cusBases));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 修改 客户基础信息 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_UPDATE + "_1"})
	public Responses<CusBase> update(Param param, @RequestBody CusBase cusBase) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBase);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusBaseService.updateCusBase(cusBase));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量修改 客户基础信息 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE})
	public Responses<CusBase> batchUpdate(Param param, @RequestBody List<CusBase> cusBases) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBases);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(cusBases)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusBaseService.batchUpdateCusBase(cusBases));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 删除 客户基础信息 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_REMOVE})
	public Responses<CusBase> remove(Param param, @RequestBody CusBase cusBase) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBase);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			cusBaseService.removeCusBase(cusBase);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量删除 客户基础信息 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE})
	public Responses<CusBase> batchRemove(Param param, @RequestBody List<CusBase> cusBases) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBases);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(cusBases)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			cusBaseService.batchRemoveCusBase(cusBases);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 通过主键获取 客户基础信息 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK + "_1"})
	public Responses<CusBase> getByPk(Param param, @RequestBody CusBase cusBase) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBase);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(cusBase.getCusBaseId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusBaseService.getCusBaseByPk(cusBase.getCusBaseId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 客户基础信息 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL})
	public Responses<CusBase> getAll(Param param, @RequestBody CusBaseQuery cusBaseQuery) throws Exception {
		cusBaseQuery.setDelFlagAndne("0");
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBaseQuery);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBaseQuery)) {
				responses.setData(cusBaseService.getAllCusBase());
			} else {
				responses.setData(cusBaseService.queryCusBase(cusBaseQuery));
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
	 * 分页获取 客户基础信息 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING})
	public Responses<CusBase> paging(Param param, @RequestBody CusBaseQuery cusBaseQuery) throws Exception {
		cusBaseQuery.setDelFlagAndne("0");
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBaseQuery);
		}
		Responses<CusBase> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBaseQuery)) {
				responses.setData(cusBaseService.pagingQueryCusBase(param, null));
			} else {
				responses.setData(cusBaseService.pagingQueryCusBase(param, cusBaseQuery));
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
	 * 通过主键获取 客户基础信息 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK})
	public Responses<CusBaseVO> getVOByPk(Param param, @RequestBody CusBase cusBase) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBase);
		}
		Responses<CusBaseVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBase)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(cusBase.getCusBaseId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(cusBaseService.getCusBaseVOByPk(cusBase.getCusBaseId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 客户基础信息 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO})
	public Responses<CusBaseVO> getAllVO(Param param, @RequestBody CusBaseQuery cusBaseQuery) throws Exception {
		cusBaseQuery.setDelFlagAndne("0");
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBaseQuery);
		}
		Responses<CusBaseVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBaseQuery)) {
				responses.setData(cusBaseService.getAllCusBaseVO());
			} else {
				responses.setData(cusBaseService.queryCusBaseVO(cusBaseQuery));
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
	 * 分页获取 客户基础信息 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO})
	public Responses<CusBaseVO> pagingVO(Param param, @RequestBody CusBaseQuery cusBaseQuery) throws Exception {
		cusBaseQuery.setDelFlagAndne("0");
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBaseQuery);
		}
		Responses<CusBaseVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(cusBaseQuery)) {
				responses.setData(cusBaseService.pagingQueryCusBaseVO(param, null));
			} else {
				responses.setData(cusBaseService.pagingQueryCusBaseVO(param, cusBaseQuery));
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/***********************************************************************************/
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_SAVE})
	public Responses<CusVO> save(Param param, @Valid @RequestBody CusVO cus) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cus);
		}
		Responses<CusVO> responses = new Responses<>();
		if (ToolUtil.isNullEntityAllFieldValue(cus)) {
			return responses.isDefeated("您没有发送数据");
		}
		CusVO cusVO = cusService.saveOrUpdateCus(cus);
		responses.setData(cusVO);
		if (cusVO == null) {
			responses.isDefeated("保存失败");
		} else {
			responses.setMsg("保存成功");
		}
		return responses;
	}

	@SuppressWarnings("Duplicates")
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_UPDATE})
	public Responses<CusVO> update(Param param, @Valid @RequestBody CusVO cus) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cus);
		}
		Responses<CusVO> responses = new Responses<>();
		if (ToolUtil.isNullEntityAllFieldValue(cus)) {
			log.info("您没有发送数据");
			return responses.isDefeated("您没有发送数据");
		}
		// 校验id
		CusVO cusVO = cusService.saveOrUpdateCus(cus);
		responses.setData(cusVO);
		if (cusVO == null) {
			responses.isDefeated("保存失败");
		} else {
			responses.setMsg("保存成功");
		}
		return responses;
	}

	@SuppressWarnings("Duplicates")
	@PostMapping(params = {ToolUtil.ACTION + "delFlag"})
	public Responses<CusVO> delFlag(Param param, @RequestBody ArrayList<CusBase> cusBases) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBases);
		}
		Responses<CusVO> responses = new Responses<>();
		if (cusBases.size() < 1) {
			log.info("您没有发送数据");
			return responses.isDefeated("您没有发送数据");
		}
		Boolean flag = cusService.delFlagCus(cusBases, "0");// 0代表隐藏
		if (!flag) {
			responses.isDefeated("删除失败");
		} else {
			responses.setMsg("删除成功");
		}
		return responses;
	}

	/**
	 * 启用
	 *
	 * @param param
	 * @param cusBases
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("Duplicates")
	@PostMapping(params = {ToolUtil.ACTION + "start"})
	public Responses<CusVO> start(Param param, @RequestBody ArrayList<CusBase> cusBases) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBases);
		}
		Responses<CusVO> responses = new Responses<>();
		if (cusBases.size() < 1) {
			log.info("您没有发送数据");
			return responses.isDefeated("您没有发送数据");
		}
		// 校验id
		Boolean flag = cusService.delFlagCus(cusBases, "START");// start 启用状态
		if (!flag) {
			responses.isDefeated("启用失败");
		} else {
			responses.setMsg("启用成功");
		}
		return responses;
	}

	/**
	 * 停用
	 *
	 * @param param
	 * @param cusBases
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("Duplicates")
	@PostMapping(params = {ToolUtil.ACTION + "stop"})
	public Responses<CusVO> stop(Param param, @RequestBody ArrayList<CusBase> cusBases) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBases);
		}
		Responses<CusVO> responses = new Responses<>();
		if (cusBases.size() < 1) {
			log.info("您没有发送数据");
			return responses.isDefeated("您没有发送数据");
		}
		// 校验id
		Boolean flag = cusService.delFlagCus(cusBases, "STOP");// STOP 代表停止状态
		if (!flag) {
			responses.isDefeated("停用失败");
		} else {
			responses.setMsg("停用成功");
		}
		return responses;
	}

	/**
	 * 根据客户ID获取相关所有数据进行展示
	 *
	 * @param param
	 * @param cusBase
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("Duplicates")
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK})
	public Responses<CusVO> getCusByPk(Param param, @RequestBody CusBase cusBase) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + cusBase);
		}
		Responses<CusVO> responses = new Responses<>();
		if (cusBase != null && cusBase.getCusBaseId() != null && !"".equals(cusBase.getCusBaseId().trim())) {
			CusVO cusVO = cusService.getCusByPk(cusBase);
			if (cusVO.getCusBase().getCusBaseId() == null) {
				responses.isDefeated("没有找到ID为" + cusBase.getCusBaseId() + "的信息");
			} else {
				responses.setData(cusVO);
			}
		} else {
			responses.isDefeated("没有获取到客户ID,无法查找信息");
		}
		return responses;
	}

}

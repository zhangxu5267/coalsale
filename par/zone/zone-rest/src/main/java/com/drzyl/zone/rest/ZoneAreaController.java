package com.drzyl.zone.rest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import com.drzyl.zone.entity.ZoneRegion;
import com.drzyl.zone.service.IZoneService;
import com.drzyl.zone.vo.Zone;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.query.ZoneAreaQuery;
import com.drzyl.zone.service.IZoneAreaService;
import com.drzyl.zone.vo.ZoneAreaVO;
import lombok.extern.log4j.Log4j2;

/**
 * 区域 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = {"zone/zoneArea"})
public class ZoneAreaController extends ToolController {

	public static final String LOG = "ZoneAreaController";

	@Resource(name = "com.drzyl.zone.ZoneAreaService")
	private IZoneAreaService zoneAreaService;
	@Resource(name = "com.drzyl.zone.business.service.impl.ZoneService")
	private IZoneService zoneService;

	/**
	 * 批量保存或更新 区域与地区的关联关系
	 */
	@PostMapping(params = {ToolUtil.ACTION + "saveAreaRegion"})
	public Responses<ZoneRegion> batchSaveUpdate(Param param, @RequestBody Zone zone) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zone);
		}
		Responses<ZoneRegion> responses = new Responses<ZoneRegion>();
		if (zone.getZoneArea() == null || zone.getZoneArea().getAreaId() == null) return responses.isDefeated("区域ID不能为空");
		Boolean flag = zoneService.batchSaveUpdate(zone);
		if (flag) {
			return responses.isSuccess("操作成功");
		}
		return responses.isDefeated("关联的区域不存在");
	}

	/**
	 * 根据传送的AreaID 和 OrgId 返回 Region(地区-省市区) (如果OrgId为空,则查找当前登录用户的OrgId[机构Id])
	 * <br/>
	 * 返回与其相关的地区
	 */
	@PostMapping(params = {ToolUtil.ACTION + "getRegionByAreaId"})
	public Responses<ZoneRegion> getRegionByAreaId(Param param, @RequestBody Zone zone ) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + zone);
		}
		Responses<ZoneRegion> responses = new Responses<ZoneRegion>();
		if (zone.getZoneArea() == null || zone.getZoneArea().getAreaId() == null) return responses.isDefeated("区域ID不能为空");
		try {
			LinkedList<ZoneRegion> zoneRegions = zoneService.getRegionByAreaId(zone.getZoneArea().getAreaId(), zone.getOrgId());
			responses.setData(zoneRegions);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 根据传送的AreaID 和 OrgId 删除 区域 与 省市区的对应关系
	 */
	@PostMapping(params = {ToolUtil.ACTION + "delRegionRele"})
	public Responses<ZoneRegion> delRegionRele(Param param, @RequestBody Zone zone) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zone);
		}
		Responses<ZoneRegion> responses = new Responses<ZoneRegion>();
		try {
			if (zone.getZoneArea() == null || zone.getZoneArea().getAreaId() == null) return responses.isDefeated("区域ID不能为空");
			zoneService.delRegionRele(zone.getZoneArea().getAreaId(), zone.getOrgId());
			responses.setMsg("操作成功");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			responses.isDefeated("获取失败");
			throw e;
		}
		return responses;
	}

	/**
	 * 标记删除 区域
	 */
	@PostMapping(params = {ToolUtil.ACTION + "delFlag"})
	public Responses<ZoneArea> delFlag(Param param, @RequestBody LinkedList<ZoneArea> zoneArea) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneArea);
		}
		Responses<ZoneArea> responses = new Responses<ZoneArea>();
		try {
			zoneService.delFlagZoneArea(zoneArea);
			responses.setMsg("操作成功");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			responses.isDefeated("获取失败");
			throw e;
		}
		return responses;
	}

	/**
	 * 保存 区域 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_SAVE})
	public Responses<ZoneArea> save(Param param, @RequestBody ZoneArea zoneArea) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneArea);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(zoneAreaService.saveZoneArea(zoneArea));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量保存 区域 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE})
	public Responses<ZoneArea> batchSave(Param param, @RequestBody List<ZoneArea> zoneAreas) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneAreas);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(zoneAreas)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(zoneAreaService.batchSaveZoneArea(zoneAreas));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 修改 区域 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_UPDATE})
	public Responses<ZoneArea> update(Param param, @RequestBody ZoneArea zoneArea) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneArea);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(zoneAreaService.updateZoneArea(zoneArea));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量修改 区域 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE})
	public Responses<ZoneArea> batchUpdate(Param param, @RequestBody List<ZoneArea> zoneAreas) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneAreas);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(zoneAreas)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(zoneAreaService.batchUpdateZoneArea(zoneAreas));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 删除 区域 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_REMOVE})
	public Responses<ZoneArea> remove(Param param, @RequestBody ZoneArea zoneArea) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneArea);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			zoneAreaService.removeZoneArea(zoneArea);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 批量删除 区域 信息
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE})
	public Responses<ZoneArea> batchRemove(Param param, @RequestBody List<ZoneArea> zoneAreas) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneAreas);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isEmpty(zoneAreas)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			zoneAreaService.batchRemoveZoneArea(zoneAreas);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 通过主键获取 区域 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK})
	public Responses<ZoneArea> getByPk(Param param, @RequestBody ZoneArea zoneArea) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneArea);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(zoneAreaService.getZoneAreaByPk(zoneArea.getAreaId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 区域 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL})
	public Responses<ZoneArea> getAll(Param param, @RequestBody ZoneAreaQuery zoneAreaQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneAreaQuery);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
				responses.setData(zoneAreaService.getAllZoneArea());
			} else {
				responses.setData(zoneAreaService.queryZoneArea(zoneAreaQuery));
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
	 * 分页获取 区域 数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING})
	public Responses<ZoneArea> paging(Param param, @RequestBody ZoneAreaQuery zoneAreaQuery) throws Exception {
		zoneAreaQuery.setDelFlag("1"); // 不查找标记删除的数据
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneAreaQuery);
		}
		Responses<ZoneArea> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
				responses.setData(zoneAreaService.pagingQueryZoneArea(param, null));
			} else {
				responses.setData(zoneAreaService.pagingQueryZoneArea(param, zoneAreaQuery));
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
	 * 通过主键获取 区域 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK})
	public Responses<ZoneAreaVO> getVOByPk(Param param, @RequestBody ZoneArea zoneArea) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneArea);
		}
		Responses<ZoneAreaVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			responses.setData(zoneAreaService.getZoneAreaVOByPk(zoneArea.getAreaId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
		return responses;
	}

	/**
	 * 获取 区域 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO})
	public Responses<ZoneAreaVO> getAllVO(Param param, @RequestBody ZoneAreaQuery zoneAreaQuery) throws Exception {
		zoneAreaQuery.setDelFlag("1"); // 不查找标记删除的数据
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneAreaQuery);
		}
		Responses<ZoneAreaVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
				responses.setData(zoneAreaService.getAllZoneAreaVO());
			} else {
				responses.setData(zoneAreaService.queryZoneAreaVO(zoneAreaQuery));
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
	 * 分页获取 区域 展示数据
	 */
	@PostMapping(params = {ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO})
	public Responses<ZoneAreaVO> pagingVO(Param param, @RequestBody ZoneAreaQuery zoneAreaQuery) throws Exception {
		zoneAreaQuery.setDelFlag("1"); // 不查找标记删除的数据
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + zoneAreaQuery);
		}
		Responses<ZoneAreaVO> responses = new Responses<>();
		try {
			if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
				responses.setData(zoneAreaService.pagingQueryZoneAreaVO(param, null));
			} else {
				responses.setData(zoneAreaService.pagingQueryZoneAreaVO(param, zoneAreaQuery));
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

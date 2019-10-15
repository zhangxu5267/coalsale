package com.drzyl.zone.business.service.impl;

import com.drzyl.tool.util.StringUtils;
import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.entity.ZoneAreaRegionTepe;
import com.drzyl.zone.entity.ZoneRegion;
import com.drzyl.zone.mapper.ZoneMapper;
import com.drzyl.zone.service.IZoneService;
import com.drzyl.zone.service.impl.ZoneAreaRegionTepeServiceImpl;
import com.drzyl.zone.service.impl.ZoneAreaServiceImpl;
import com.drzyl.zone.service.impl.ZoneRegionServiceImpl;
import com.drzyl.zone.vo.Zone;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.LinkedList;

@Log4j2
@Repository("com.drzyl.zone.business.service.impl.ZoneService")
public class ZoneService implements IZoneService {

	@Autowired
	ZoneAreaServiceImpl zoneAreaService;
	@Autowired
	ZoneAreaRegionTepeServiceImpl zoneAreaRegionTepeService;
	@Autowired
	ZoneRegionServiceImpl zoneRegionService;
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	ZoneMapper zoneMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public ZoneArea saveUpdateZone(Zone zone) throws Exception {
		// 区域信息保存
		ZoneArea zoneArea = null;
		if (zone.getZoneArea() != null) {
			if (StringUtils.isEmpty(zone.getZoneArea().getAreaId())) {
				zoneArea = zoneAreaService.saveZoneArea(zone.getZoneArea());
			} else {
				zoneArea = zoneAreaService.updateZoneArea(zone.getZoneArea());
				// 删除旧数据
				zoneMapper.delByAreaId(zoneArea);
			}
			// 关联地区(省市区)保存,注意机构Id的处理
			LinkedList<ZoneRegion> zoneRegions = zone.getZoneRegions();
			if (zoneRegions != null && zoneRegions.size() > 0) {
				Iterator<ZoneRegion> iterator = zoneRegions.iterator();
				while (iterator.hasNext()) {
					ZoneRegion region = iterator.next();
					ZoneAreaRegionTepe areaRegion = new ZoneAreaRegionTepe();
					areaRegion.setCrmAreaId(region.getRegionId());
					if (StringUtils.isEmpty(zone.getOrgId())) {
						areaRegion.setOrgId("当前登录用户的机构ID");
					} else {
						areaRegion.setOrgId(zone.getOrgId());//配置用户指定的OrgId
					}
					if (zoneRegionService.getZoneRegionByPk(region.getRegionId()) == null) {
						return null;
					}
					areaRegion.setCrmRegionId(region.getRegionId());// 关联省市区
					areaRegion.setCrmAreaId(zoneArea.getAreaId()); // 关联区域
					zoneAreaRegionTepeService.saveZoneAreaRegionTepe(areaRegion);
				}
			}
		}
		return zoneArea;
	}

	/**
	 * 根据 areaId 区域ID orgId 机构Id 获取 对应的省市区列表
	 *
	 * @param areaId 不能为空
	 * @param orgId  为空时,使用的当前登录人的机构ID
	 */
	@Override
	public LinkedList<ZoneRegion> getRegionByAreaId(String areaId, String orgId) {
		ZoneAreaRegionTepe zoneAreaRegionTepe = new ZoneAreaRegionTepe();
		if (StringUtils.isEmpty(orgId)) orgId = "当前登录用户";
		zoneAreaRegionTepe.setOrgId(orgId);
		zoneAreaRegionTepe.setCrmAreaId(areaId);
		LinkedList<ZoneRegion> zoneRegions = zoneMapper.getRegionByAreaId(zoneAreaRegionTepe);
		return zoneRegions;
	}

	/**
	 * 根据以下参数删除 区域 和 省市区的关联
	 *
	 * @param areaId 不能为空
	 * @param orgId  为空时,使用的当前登录人的机构ID
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void delRegionRele(String areaId, String orgId) {
		ZoneAreaRegionTepe zoneAreaRegionTepe = new ZoneAreaRegionTepe();
		if (StringUtils.isEmpty(orgId)) orgId = "当前登录用户";
		zoneAreaRegionTepe.setOrgId(orgId);
		zoneAreaRegionTepe.setCrmAreaId(areaId);
		zoneMapper.delRegionRele(zoneAreaRegionTepe);
	}

	/**
	 * 标记删除区域
	 *
	 * @param zoneArea
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void delFlagZoneArea(LinkedList<ZoneArea> zoneArea) {
		Iterator<ZoneArea> areaIterator = zoneArea.iterator();
		while (areaIterator.hasNext()) {
			ZoneArea area = areaIterator.next();
			if (area.getAreaId() != null) zoneMapper.delFlagZoneArea(area);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean batchSaveUpdate(Zone zone) throws Exception {
		String orgId = zone.getOrgId();
		if (orgId == null) {
			orgId = "当前登录用户";
		}
		ZoneArea zoneArea = zone.getZoneArea();
		LinkedList<ZoneRegion> zoneRegions = zone.getZoneRegions();
		Iterator<ZoneRegion> iterator = zoneRegions.iterator();
		// 删除旧关联
		ZoneAreaRegionTepe zoneAreaRegionTepe = new ZoneAreaRegionTepe();
		zoneAreaRegionTepe.setCrmAreaId(zoneArea.getAreaId());
		zoneAreaRegionTepe.setOrgId(orgId);
		zoneMapper.delRegionRele(zoneAreaRegionTepe);
		// 新建
		while (iterator.hasNext()) {
			ZoneRegion next = iterator.next();
			ZoneRegion zoneRegionByPk = zoneRegionService.getZoneRegionByPk(next.getRegionId());
			if (zoneRegionByPk != null) {
				ZoneAreaRegionTepe tepe = new ZoneAreaRegionTepe(orgId, next.getRegionId(), zoneArea.getAreaId());
				zoneAreaRegionTepeService.saveZoneAreaRegionTepe(tepe);
			} else {
				return false;
			}
		}
		return true;
	}
}

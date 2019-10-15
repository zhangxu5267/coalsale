package com.drzyl.zone.service;

import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.entity.ZoneRegion;
import com.drzyl.zone.vo.Zone;

import java.util.LinkedList;

public interface IZoneService {
	/**
	 * 保存或更新区域信息
	 *   其中还会为区域添加对应的省市区和关联的机构,从而使得每个机构都有自身独有的区域与省市区对应的关系
	 *   如果前端选择了机构,后端则不会获取当前登录机构
	 *   如果前端没有选择机构,后端默认使用当前登录人的机构Id
	 * @param zone
	 * @return
	 */
	ZoneArea saveUpdateZone(Zone zone) throws Exception;

	/**
	 * 根据 areaId 区域ID orgId 机构Id 获取 对应的省市区列表
	 * @param areaId
	 * @param orgId
	 */
	public LinkedList<ZoneRegion> getRegionByAreaId(String areaId, String orgId);

	/**
	 * 根据以下参数删除 区域 和 省市区的关联
	 * @param areaId 不能为空
	 * @param orgId 为空时,使用的当前登录人的机构ID
	 */
	void delRegionRele(String areaId, String orgId);

	/**
	 * 区域标记删除
	 * @param zoneArea
	 */
	void delFlagZoneArea(LinkedList<ZoneArea> zoneArea);

	Boolean batchSaveUpdate(Zone zone) throws Exception;
}

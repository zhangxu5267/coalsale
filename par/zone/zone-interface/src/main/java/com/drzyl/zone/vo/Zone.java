package com.drzyl.zone.vo;

import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.entity.ZoneRegion;
import lombok.Data;

import java.util.LinkedList;
/**
 * 区域 PAR_ZONE_AREA 实体类
 */
@Data
public class Zone {
	private ZoneArea zoneArea;
	private String orgId;
	private LinkedList<ZoneRegion> zoneRegions;
}

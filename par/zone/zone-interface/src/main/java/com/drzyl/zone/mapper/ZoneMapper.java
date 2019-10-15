package com.drzyl.zone.mapper;

import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.entity.ZoneAreaRegionTepe;
import com.drzyl.zone.entity.ZoneRegion;

import java.util.LinkedList;

public interface ZoneMapper {
	void delByAreaId(ZoneArea zoneArea);

	LinkedList<ZoneRegion> getRegionByAreaId(ZoneAreaRegionTepe zoneAreaRegionTepe);

	void delRegionRele(ZoneAreaRegionTepe zoneAreaRegionTepe);

	void delFlagZoneArea(ZoneArea area);
}

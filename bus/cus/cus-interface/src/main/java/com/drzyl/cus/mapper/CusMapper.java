package com.drzyl.cus.mapper;

import com.drzyl.cus.entity.*;
import com.drzyl.cus.vo.CusVO;

import java.util.LinkedList;
import java.util.List;

public interface CusMapper {
	/**
	 * 删除客户和客户标签的多对多关系
	 *
	 * @param cusBaseId 客户ID
	 * @throws Exception
	 */
	void delCusTagCorrelation(String cusBaseId) throws Exception;

	Integer flagDelCusBase(CusBase cusBase);

	Integer flagDelCusBaseInfo(CusBaseInfo cusBaseInfo);

	Integer flagDelCusAgent(CusAgent next);

	Integer flagDelCusAddrDis(CusAddrDis next);

	Integer flagDelCusAddress(CusAddress next);

	LinkedList<CusAgent> getAgents(CusBase cusBase);

	LinkedList<CusAddrDis> getAddDiss(CusBase cusBase);

	LinkedList<CusAddress> getAddrs(CusBase cusBase);

	LinkedList<CusTag> getTags(CusBase cusBase);

	CusBaseInfo getCusBaseInfo(CusBaseInfo cusBaseInfo);
}

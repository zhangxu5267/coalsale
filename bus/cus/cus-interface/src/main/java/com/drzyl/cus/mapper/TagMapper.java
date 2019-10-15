package com.drzyl.cus.mapper;

import com.drzyl.cus.entity.CusBase;
import com.drzyl.cus.entity.CusTag;
import com.drzyl.cus.vo.CusBaseVO;

import java.util.LinkedList;

public interface TagMapper {
	/**
	 * 根据客户标签获取 相关的客户
	 * @param cusTag
	 * @return
	 */
	LinkedList<CusBaseVO> getByPkOfDetail(CusTag cusTag);
}

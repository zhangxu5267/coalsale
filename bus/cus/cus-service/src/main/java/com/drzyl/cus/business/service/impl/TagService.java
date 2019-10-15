package com.drzyl.cus.business.service.impl;

import com.drzyl.cus.entity.*;
import com.drzyl.cus.mapper.TagMapper;
import com.drzyl.cus.vo.CusBaseVO;
import com.drzyl.cus.vo.CusTagVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;

@Log4j2
@Service("com.drzyl.cus.business.service.impl.TagService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class TagService{
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private TagMapper tagMapper;// 操作所有客户信息的mapper


	public LinkedList<CusBaseVO> getByPkOfDetail(CusTag cusTag) throws Exception {
		LinkedList<CusBaseVO> cusBases = tagMapper.getByPkOfDetail(cusTag);
		return cusBases;
	}
}

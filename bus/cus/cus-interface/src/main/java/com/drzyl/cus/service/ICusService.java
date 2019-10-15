package com.drzyl.cus.service;

import com.drzyl.cus.entity.CusBase;
import com.drzyl.cus.vo.CusVO;
import com.drzyl.tool.util.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.ws.soap.AddressingFeature;
import java.util.List;

public interface ICusService {
	/**
	 * 保存或更新
	 *
	 * @param cus
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("Duplicates")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	CusVO saveOrUpdateCus(CusVO cus) throws Exception;

	/**
	 * 根据客户ID删除客户
	 *
	 * @param cusBases
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	Boolean delFlagCus(List<CusBase> cusBases, String flag) throws Exception;

	/**
	 * 根据客户id获取所有的数据
	 *
	 * @param cusBase 里面只有一个客户ID
	 * @return
	 * @throws Exception
	 */
	CusVO getCusByPk(CusBase cusBase) throws Exception;

}

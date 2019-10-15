package com.drzyl.cus.business.service.impl;

import com.drzyl.cus.entity.*;
import com.drzyl.cus.mapper.CusMapper;
import com.drzyl.cus.service.*;
import com.drzyl.cus.vo.CusVO;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.util.StringUtils;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Log4j2
@Service("com.drzyl.cus.business.service.impl.CusService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class CusService implements ICusService {
	public static final String LOG = "CusController";
	@Resource(name = "com.drzyl.cus.CusBaseService")
	private ICusBaseService cusBaseService;// 客户信息服务
	@Resource(name = "com.drzyl.cus.CusBaseInfoService")
	private ICusBaseInfoService cusBaseInfoService;// 客户信息详情服务
	@Resource(name = "com.drzyl.cus.CusAgentService")
	private ICusAgentService cusAgentService;// 委托信息服务
	@Resource(name = "com.drzyl.cus.CusAddrDisService")
	private ICusAddrDisService cusAddrDisService;// 收货地址服务
	@Resource(name = "com.drzyl.cus.CusAddressService")
	private ICusAddressService cusAddressService;// 收货单位服务
	@Resource(name = "com.drzyl.cus.CusTagTempService")
	private ICusTagTempService cusTagTempService;// 用户标签中间表服务
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")// 报错很烦
	@Autowired
	private CusMapper cusMapper;// 操作所有客户信息的mapper

	/**
	 * 自动生成客户编码
	 *
	 * @param cusBase
	 */
	public void automaticGeneration(CusBase cusBase) {
		int i = cusBase.getCreditCode().hashCode();
		cusBase.setCustomNo(Long.toHexString(i));
	}


	/**
	 * 保存和更新数据
	 *
	 * @param cus
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("Duplicates")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public CusVO saveOrUpdateCus(CusVO cus) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + cus);
		}
		String cusBaseId = null;
		String customNo = null;
		CusBase cusBase = cus.getCusBase();

		try {
			// 客户基础信息
			boolean isUpdate = true;// 如果基础信息是保存,之后所有的信息都是保存
			if (!ToolUtil.isNullEntityAllFieldValue(cusBase)) {
				cusBaseId = cusBase.getCusBaseId();
				if (cusBaseId != null && !"".equals(cusBaseId.trim())) {
					if (cusBaseService.getCusBaseByPk(cusBaseId) == null) {
						throw new ToolException("更新的cusBaseId不正确,在数据库中找不到相关数据");
					}
					cusBase = cusBaseService.updateCusBase(cusBase);
				} else {
					automaticGeneration(cusBase);
					cusBase = cusBaseService.saveCusBase(cusBase);
					isUpdate = false;
				}
				// 关联客户ID和客户编码
				cusBaseId = cusBase.getCusBaseId();// 客户ID
				customNo = cusBase.getCustomNo();// 客户编码
			}
			// 客户详细信息
			CusBaseInfo cusBaseInfo = cus.getCusBaseInfo();
			if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
				cusBaseInfo.setCusBaseId(cusBaseId);
				cusBaseInfo.setCusNo(customNo);
				if (isUpdate && StringUtils.isNotEmpty(cusBaseInfo.getCusBaseInfoId().trim())) {// 是更新有ID则为更新
					cusBaseInfoService.updateCusBaseInfo(cusBaseInfo);
				} else {// 否则新建
					cusBaseInfo.setOrgId("获取当前登录用户的机构ID");
					// 保存当前用户所属机构的信息
					cusBaseInfoService.saveCusBaseInfo(cusBaseInfo);
					if (!"root".equals("root")) {//后期添加时,总公司添加记录时,只添加一条数据(root 为集团公司)
						cusBaseInfo.setOrgId("root");
						cusBaseInfo.setCreateOrg("root");
						// 保存一条集团初始的一条信息
						cusBaseInfoService.saveCusBaseInfo(cusBaseInfo);
					}
				}
			}
			// 客户委托信息
			LinkedList<CusAgent> cusAgents = cus.getCusAgents();
			if (cusAgents != null && cusAgents.size() > 0) {
				Iterator<CusAgent> cusAgentIterator = cusAgents.iterator();
				while (cusAgentIterator.hasNext()) {
					CusAgent next = cusAgentIterator.next();
					if (!ToolUtil.isNullEntityAllFieldValue(next)) {
						next.setCusBaseId(cusBaseId);
						if (isUpdate && StringUtils.isNotEmpty(next.getCusAgentId().trim())) {
							cusAgentService.updateCusAgent(next);
						} else {
							cusAgentService.saveCusAgent(next);
						}
					}
				}
			}
			// 客户收货地址
			LinkedList<CusAddrDis> cusAddrDis = cus.getCusAddrDis();
			if (cusAddrDis != null && cusAddrDis.size() > 0) {
				Iterator<CusAddrDis> addrDisIterator = cusAddrDis.iterator();
				while (addrDisIterator.hasNext()) {
					CusAddrDis next = addrDisIterator.next();
					if (!ToolUtil.isNullEntityAllFieldValue(next)) {
						next.setCusBaseId(cusBaseId);
						if (isUpdate && StringUtils.isNotEmpty(next.getCusAddrDisId().trim())) {
							cusAddrDisService.updateCusAddrDis(next);
						} else {
							cusAddrDisService.saveCusAddrDis(next);
						}
					}
				}
			}
			// 客户收货单位
			LinkedList<CusAddress> cusAddress = cus.getCusAddress();
			if (cusAddress != null && cusAddress.size() > 0) {
				Iterator<CusAddress> cusAddressIterator = cusAddress.iterator();
				while (cusAddressIterator.hasNext()) {
					CusAddress next = cusAddressIterator.next();
					if (!ToolUtil.isNullEntityAllFieldValue(next)) {
						next.setCusBaseId(cusBaseId);
						next.setCusNo(customNo);
						if (isUpdate && StringUtils.isNotEmpty(next.getCusAddressId().trim())) {
							cusAddressService.updateCusAddress(next);
						} else {
							cusAddressService.saveCusAddress(next);
						}
					}
				}
			}
			// 客户标签
			// 删除旧的关联
			cusMapper.delCusTagCorrelation(cusBaseId);
			LinkedList<CusTagTemp> cusTagTemps = cus.getCusTagTemps();
			// 建立新的关联
			if (cusTagTemps != null && cusTagTemps.size() > 0) {
				Iterator<CusTagTemp> tagTempIterator = cusTagTemps.iterator();
				while (tagTempIterator.hasNext()) {
					CusTagTemp next = tagTempIterator.next();
					if (!ToolUtil.isNullEntityAllFieldValue(next)) {
						next.setCusBaseId(cusBaseId);
						cusTagTempService.saveCusTagTemp(next);
					}
				}
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			return null;
		}
		return cus;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean delFlagCus(List<CusBase> cusBases, String flag) throws Exception {
		Integer count = 0;
		try {
			Iterator<CusBase> iterator = cusBases.iterator();
			while (iterator.hasNext()) {
				CusBase next = iterator.next();
				next.setDelFlag(flag);
				count = cusMapper.flagDelCusBase(next);
			}
		} catch (Exception e) {
			return false;
		}
		if (count == 0) return false;
		return true;
	}

	@Override
	public CusVO getCusByPk(CusBase cusBase) throws Exception {
		CusVO cus = new CusVO();
		try {
			CusBase base = cusBaseService.getCusBaseByPk(cusBase.getCusBaseId());
			cus.setCusBase(base);

			CusBaseInfo cusBaseInfo = new CusBaseInfo();
			cusBaseInfo.setOrgId("获取当前登录用户的机构ID");
			cusBaseInfo.setCusBaseId(cusBase.getCusBaseId());

			CusBaseInfo info = cusMapper.getCusBaseInfo(cusBaseInfo);
			cus.setCusBaseInfo(info);

			LinkedList<CusAgent> agents = cusMapper.getAgents(cusBase);
			cus.setCusAgents(agents);

			LinkedList<CusAddrDis> addDiss = cusMapper.getAddDiss(cusBase);
			cus.setCusAddrDis(addDiss);

			LinkedList<CusAddress> addrs = cusMapper.getAddrs(cusBase);
			cus.setCusAddress(addrs);

			LinkedList<CusTag> tags = cusMapper.getTags(cusBase);
			cus.setCusTags(tags);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return cus;
	}

}

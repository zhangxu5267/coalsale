package com.drzyl.sms;

import com.drzyl.tool.entity.SecurityCode;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.persistent.ISecurityCodePersistent;
import com.drzyl.tool.query.SecurityCodeQuery;
import com.drzyl.tool.service.ISecurityCodeService;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.tool.util.number.RandomUtil;
import com.drzyl.tool.vo.SecurityCodeVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 短信验证码 服务实现
 */
@Log4j2
@Service("com.drzyl.sms.SecurityCodeService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class SecurityCodeServiceImpl implements ISecurityCodeService {
	@Autowired
	private SmsService smsService;
	public static final String LOG = "SecurityCodeService";

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Resource(name = "com.drzyl.sms.SecurityCodePersistent")
	private ISecurityCodePersistent securityCodePersistent;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SecurityCode sendSmsSecurityCode(String phoneNumber, String action) throws Exception {
		String code = String.valueOf(RandomUtil.nextInt(100000, 999999));
		// 持久化存储
		SecurityCode securityCode = new SecurityCode();
		securityCode.setPhoneNumber(phoneNumber);
		securityCode.setSecurityCode(code);
		securityCode.setAction(action);
		// 查找数据此号码此用途是否为一条数据
		SecurityCodeQuery securityCodeQuery = new SecurityCodeQuery();
		securityCodeQuery.setPhoneNumber(phoneNumber);
		securityCodeQuery.setAction(action);
		// 删除数据
		for (SecurityCode sc : securityCodePersistent.querySecurityCode(securityCodeQuery)) {
			securityCodePersistent.removeSecurityCode(sc);
		}
		// 保存数据
		securityCode.setId(ToolUtil.getUUID());
		SecurityCode sCode = securityCodePersistent.saveSecurityCode(securityCode);
		// 发送短信
		smsService.sendSmsLoginSecurityCode(phoneNumber, code);
		return sCode;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public int verifySecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception {
		List<SecurityCode> securityCodes = (List<SecurityCode>) securityCodePersistent.querySecurityCode(securityCodeQuery);
		if (securityCodes != null && securityCodes.size() == 1) {
			long maxS = 10 * 60000;// 十分钟
			long l = System.currentTimeMillis() - securityCodes.get(0).getCreateTimes();
			if (l > maxS) {
				// 失效删除
				securityCodePersistent.removeSecurityCode(securityCodes.get(0));
				log.debug("验证码过期失效");
				return -2;
			} else {
				securityCodePersistent.removeSecurityCode(securityCodes.get(0));
				log.debug("验证成功");
				return 1;
			}
		} else {
			log.debug("验证码不正确");
			return -1;
		}

	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SecurityCode saveSecurityCode(SecurityCode securityCode) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCode);
		}
		try {
			if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			securityCode.setId(ToolUtil.getUUID());
			return securityCodePersistent.saveSecurityCode(securityCode);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Collection<SecurityCode> batchSaveSecurityCode(Collection<SecurityCode> securityCodes) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCodes);
		}
		try {
			if (ToolUtil.isEmpty(securityCodes)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			for (SecurityCode securityCode : securityCodes) {
				if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
					throw new ToolException(ToolException.E_PARAM_ERR);
				}
				securityCode.setId(ToolUtil.getUUID());
			}
			return securityCodePersistent.batchSaveSecurityCode(securityCodes);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SecurityCode updateSecurityCode(SecurityCode securityCode) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCode);
		}
		try {
			if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			if (ToolUtil.isNullStr(securityCode.getId())) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			SecurityCode oldSecurityCode = securityCodePersistent.getSecurityCodeByPk(securityCode.getId());
			if (ToolUtil.isNullEntityAllFieldValue(oldSecurityCode)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			return securityCodePersistent.updateSecurityCode(securityCode);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Collection<SecurityCode> batchUpdateSecurityCode(Collection<SecurityCode> securityCodes) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCodes);
		}
		try {
			if (ToolUtil.isEmpty(securityCodes)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			for (SecurityCode securityCode : securityCodes) {
				if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
					throw new ToolException(ToolException.E_PARAM_ERR);
				}
				if (ToolUtil.isNullStr(securityCode.getId())) {
					throw new ToolException(ToolException.E_PARAM_ERR);
				}
				SecurityCode oldSecurityCode = securityCodePersistent.getSecurityCodeByPk(securityCode.getId());
				if (ToolUtil.isNullEntityAllFieldValue(oldSecurityCode)) {
					throw new ToolException(ToolException.E_PARAM_ERR);
				}
			}
			return securityCodePersistent.batchUpdateSecurityCode(securityCodes);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void removeSecurityCode(SecurityCode securityCode) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCode);
		}
		try {
			if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			Set<SecurityCode> securityCodeSet = new LinkedHashSet<>();
			if (ToolUtil.isNullStr(securityCode.getId())) {
				SecurityCodeQuery securityCodeQuery = new SecurityCodeQuery();
				BeanUtils.copyProperties(securityCode, securityCodeQuery);
				securityCodeSet.addAll(securityCodePersistent.querySecurityCode(securityCodeQuery));
			} else {
				SecurityCode oldSecurityCode = securityCodePersistent.getSecurityCodeByPk(securityCode.getId());
				if (ToolUtil.isNullEntityAllFieldValue(oldSecurityCode)) {
					throw new ToolException(ToolException.E_PARAM_ERR);
				}
				securityCodeSet.add(oldSecurityCode);
			}
			if (ToolUtil.isNotEmpty(securityCodeSet)) {
				securityCodePersistent.batchRemoveSecurityCode(securityCodeSet);
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void batchRemoveSecurityCode(Collection<SecurityCode> securityCodes) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCodes);
		}
		try {
			if (ToolUtil.isEmpty(securityCodes)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			Set<SecurityCode> securityCodeSet = new LinkedHashSet<>();
			for (SecurityCode securityCode : securityCodes) {
				if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
					throw new ToolException(ToolException.E_PARAM_ERR);
				}
				if (ToolUtil.isNullStr(securityCode.getId())) {
					SecurityCodeQuery securityCodeQuery = new SecurityCodeQuery();
					BeanUtils.copyProperties(securityCode, securityCodeQuery);
					securityCodeSet.addAll(securityCodePersistent.querySecurityCode(securityCodeQuery));
				} else {
					SecurityCode oldSecurityCode = securityCodePersistent.getSecurityCodeByPk(securityCode.getId());
					if (ToolUtil.isNullEntityAllFieldValue(oldSecurityCode)) {
						throw new ToolException(ToolException.E_PARAM_ERR);
					}
					securityCodeSet.add(oldSecurityCode);
				}
			}
			if (ToolUtil.isNotEmpty(securityCodeSet)) {
				securityCodePersistent.batchRemoveSecurityCode(securityCodeSet);
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public Long getCountSecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCodeQuery);
		}
		try {
			return securityCodePersistent.getCountSecurityCode(securityCodeQuery);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public SecurityCode getSecurityCodeByPk(String id) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + id);
		}
		try {
			if (ToolUtil.isNullStr(id)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			return securityCodePersistent.getSecurityCodeByPk(id);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public Collection<SecurityCode> getAllSecurityCode() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
		}
		try {
			return securityCodePersistent.getAllSecurityCode();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public Collection<SecurityCode> querySecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCodeQuery);
		}
		try {
			return securityCodePersistent.querySecurityCode(securityCodeQuery);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public Paging<SecurityCode> pagingQuerySecurityCode(Param param, SecurityCodeQuery securityCodeQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + securityCodeQuery);
		}
		try {
			if (ToolUtil.isNullEntityAllFieldValue(param)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			return securityCodePersistent.pagingQuerySecurityCode(param, securityCodeQuery);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public SecurityCodeVO getSecurityCodeVOByPk(String id) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + id);
		}
		try {
			if (ToolUtil.isNullStr(id)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			return securityCodePersistent.getSecurityCodeVOByPk(id);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public Collection<SecurityCodeVO> getAllSecurityCodeVO() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
		}
		try {
			return securityCodePersistent.getAllSecurityCodeVO();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public Collection<SecurityCodeVO> querySecurityCodeVO(SecurityCodeQuery securityCodeQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + securityCodeQuery);
		}
		try {
			return securityCodePersistent.querySecurityCodeVO(securityCodeQuery);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

	@Override
	public Paging<SecurityCodeVO> pagingQuerySecurityCodeVO(Param param, SecurityCodeQuery securityCodeQuery) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(ToolUtil.getLog(LOG));
			log.debug(ToolUtil.LOG + param);
			log.debug(ToolUtil.LOG + securityCodeQuery);
		}
		try {
			if (ToolUtil.isNullEntityAllFieldValue(param)) {
				throw new ToolException(ToolException.E_PARAM_ERR);
			}
			return securityCodePersistent.pagingQuerySecurityCodeVO(param, securityCodeQuery);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			throw e;
		}
	}

}

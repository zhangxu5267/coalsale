package com.drzyl.rest;

import com.drzyl.tool.entity.SecurityCode;
import com.drzyl.tool.query.SecurityCodeQuery;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.service.ISecurityCodeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = {"sms"})
public class TestSmsController {
	public static final String LOG = "SecurityCodeController";

	@Resource(name = "com.drzyl.sms.SecurityCodeService")
	private ISecurityCodeService securityCodeService;

	/**
	 * 获取登录验证码
	 */
	@PostMapping("sendSmsLoginSecurityCode")
	public Responses<SecurityCode> sendSmsLoginSecurityCode() throws Exception {
		Responses<SecurityCode> responses = new Responses<>();
		SecurityCode loginSecurityCode = securityCodeService.sendSmsSecurityCode("17691203218", "LoginSecurityCode");
		return responses.isSuccess("发送成功,注意查收");
	}

	/**
	 * 验证登录验证码
	 */
	@PostMapping("verifyLoginSecurityCode")
	public Responses<SecurityCode> verifyLoginSecurityCode(@RequestBody SecurityCodeQuery securityCodeQuery) throws Exception {
		Responses<SecurityCode> responses = new Responses<>();
		securityCodeQuery.setAction("LoginSecurityCode");
		int i = securityCodeService.verifySecurityCode(securityCodeQuery);
		if (i == 1) {
			return responses.isSuccess("验证成功");
		} else if (i == -1) {
			return responses.isDefeated("验证码不正确");
		} else {
			return responses.isDefeated("验证码过期");
		}
	}

	/**
	 * 获取修改密码验证码
	 */
	@PostMapping("sendSmsChangePasswordSecurityCode")
	public  Responses<SecurityCode> sendSmsChangePasswordSecurityCode() throws Exception {
		Responses<SecurityCode> responses = new Responses<>();
		SecurityCode loginSecurityCode = securityCodeService.sendSmsSecurityCode("17691203218", "ChangePassword");
		return responses.isSuccess("发送成功,注意查收");
	}

	/**
	 * 验证修改密码的验证码
	 */
	@PostMapping("verifyChangePasswordSecurityCode")
	public Responses<SecurityCode> verifyChangePasswordSecurityCode(@RequestBody SecurityCodeQuery securityCodeQuery) throws Exception {
		Responses<SecurityCode> responses = new Responses<>();
		securityCodeQuery.setAction("ChangePassword");
		int i = securityCodeService.verifySecurityCode(securityCodeQuery);
		if (i == 1) {
			return responses.isSuccess("验证成功");
		} else if (i == -1) {
			return responses.isDefeated("验证码不正确");
		} else {
			return responses.isDefeated("验证码过期");
		}
	}

}

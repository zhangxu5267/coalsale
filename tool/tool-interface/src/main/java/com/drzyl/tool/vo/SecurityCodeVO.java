package com.drzyl.tool.vo;
import lombok.Data;

import java.io.Serializable;

/**
 * 短信验证码 SYS_SMS_SECURITY_CODE 展示类
 */
@Data
public class SecurityCodeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id; // ID

	protected String securityCode; // 验证码

	protected String phoneNumber; // 手机号

	protected String action; // 行为

	protected Long createTimes; // 创建时间

}

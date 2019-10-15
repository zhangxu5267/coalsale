package com.drzyl.tool.query;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 短信验证码 SYS_SMS_SECURITY_CODE 查询类
 */
@Data
public class SecurityCodeQuery implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String toolExists; // 解决多对多关系预留字段之存在

	protected String toolNotExists; // 解决多对多关系预留字段之不存在

	protected String id; // ID

	protected String securityCode; // 验证码

	protected String phoneNumber; // 手机号

	protected String action; // 行为

	protected Long createTimes; // 创建时间

	protected List<String> idAndin; // IDAndin查询

	protected String securityCodeAndeq; // 验证码Andeq查询

	protected String securityCodeAndKeyLike; // 验证码AndKeyLike查询

	protected String phoneNumberOrKeyLike; // 手机号OrKeyLike查询

	protected String actionOrKeyLike; // 行为OrKeyLike查询

}

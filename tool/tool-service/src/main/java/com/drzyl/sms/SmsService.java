package com.drzyl.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.drzyl.tool.context.ToolContextData;
import com.drzyl.tool.entity.SmsLog;
import com.drzyl.tool.service.ISmsLogService;
import com.drzyl.tool.util.Date.ClockUtil;
import com.drzyl.tool.util.Date.DateFormatUtil;
import com.drzyl.tool.util.GsonUtil;
import com.drzyl.tool.util.ToolUtil;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 阿里云短信工具类
 */
@Log4j2
@Service
public class SmsService {

	@Resource(name = "com.drzyl.tool.SmsLogService")
	private ISmsLogService smsLogService;

	private SmsService() {
	}

	/**
	 * 短信静态常量
	 */
	public enum SmsParam {
		REGION_ID("cn-hangzhou"), ACCESS_KEY_ID("LTAI51GlsZ2BuYeX"), SECRET("0MwYfXKqapnYdp3QtnZk9Hvbgg81kA");
		private String value;

		SmsParam(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 返回结果
	 */
	@Data
	public class SmsResult {
		/**
		 * 返回信息
		 */
		@SerializedName("Message")
		private String message;
		/**
		 * 返回结果 = ok 表示成功<br/>
		 * 错误码<a href="https://help.aliyun.com/document_detail/101346.html?spm=a2c4g.11186623.6.613.7a62202az2zmCx"></a>
		 */
		@SerializedName("Code")
		private String code;
		/**
		 * 请求ID
		 */
		@SerializedName("RequestId")
		private String requestId;
		/**
		 * 回执ID
		 */
		@SerializedName("BizId")
		private String bizId;
	}

	/**
	 * 发送历史
	 */
	public class SendDetails {
		/**
		 * 请求状态码。
		 */
		@SerializedName("Code")
		String code;
		/**
		 * 状态码的描述。
		 */
		@SerializedName("Message")
		String message;
		/**
		 * 请求ID。
		 */
		@SerializedName("RequestId")
		String requestId;
		/**
		 * 短信发送明细。
		 */
		@SerializedName("SmsSendDetailDTOs")
		List<SendDetailDTO> smsSendDetailDTOs;
		/**
		 * 短信发送总条数。
		 */
		@SerializedName("TotalCount")
		String totalCount;
	}

	/**
	 * 发送历史详情
	 */
	public class SendDetailDTO {
		/**
		 * 短信内容。
		 */
		@SerializedName("Content")
		String content;
		/**
		 * 运营商短信状态码
		 * 短信发送成功：DELIVRD。
		 * 短信发送失败：失败错误码请参考<a href="/document_detail/101347.html?spm=a2c4g.11186623.2.14.6137bc45w3mI1G" >错误码文档</a>。
		 */
		@SerializedName("ErrCode")
		String errCode;
		/**
		 * 外部流水扩展字段
		 */
		@SerializedName("OutId")
		String outId;
		/**
		 * 接收短信的手机号码。
		 */
		@SerializedName("PhoneNum")
		String phoneNum;
		/**
		 * 短信接收日期和时间。
		 */
		@SerializedName("ReceiveDate")
		String receiveDate;
		/**
		 * 短信发送日期和时间。
		 */
		@SerializedName("SendDate")
		String sendDate;
		/**
		 * 短信发送状态，包括：<br/>
		 * <p>
		 * 1：等待回执。<br/>
		 * 2：发送失败。<br/>
		 * 3：发送成功。
		 */
		@SerializedName("SendStatus")
		String sendStatus;
		/**
		 * 短信模板ID。
		 */
		@SerializedName("TemplateCode")
		String templateCode;
	}

	public static final String OK = "ok";

	/**
	 * 收发站 短信发送方法
	 *
	 * @param phone   接收人电话
	 * @param context 发送内容
	 * @return
	 */
	public SmsResult sendSmsDispatcherStation(String phone, Map<String, String> context) {
		return sendSms(phone, "SMS_169642596", context);
	}

	/**
	 * 模版类型:<br/>
	 * 验证码<br/>
	 * 模版名称:<br/>
	 * 登录确认验证码<br/>
	 * 模版CODE:<br/>
	 * SMS_167000364<br/>
	 * 模版内容:<br/>
	 * 验证码${code}，您正在登录，若非本人操作，请勿泄露。<br/>
	 *
	 * @param phone        接受短信的手机号
	 * @param code 登录验证码
	 * @return
	 */
	public SmsResult sendSmsLoginSecurityCode(String phone, String code) {
		Map<String, String> context = new HashMap<>();
		if (code.length() == 6) context.put("code", code);
		return sendSms(phone, "SMS_167000364", context);
	}

	/**
	 * 模版类型:<br/>
	 * 验证码<br/>
	 * 模版名称:<br/>
	 * 修改密码验证码<br/>
	 * 模版CODE:	 SMS_167000361<br/>
	 * 模版内容:<br/>
	 * 验证码${code}，您正在尝试修改登录密码，请妥善保管账户信息。<br/>
	 *
	 * @param phone        接受短信的手机号
	 * @param code 登录验证码
	 * @return
	 */
	public SmsResult sendSmsChangePasswordSecurityCode(String phone, String code) {
		Map<String, String> context = new HashMap<>();
		if (code.length() == 6) context.put("code", code);
		return sendSms(phone, "SMS_167000361", context);
	}

	/**
	 * 此方法是对短信发送进行了封装<br/>
	 * <a href="https://help.aliyun.com/document_detail/101414.html?spm=a2c4g.11186623.6.616.46762246Syi728">官方文档</a><br/>
	 * <a href="https://help.aliyun.com/document_detail/101346.html?spm=a2c4g.11186623.6.613.7a62202az2zmCx">返回错误码</a><br/>
	 * @param phone        接受短信的电话
	 * @param templateCode 短信模板
	 * @param context      Map<String, String> 内容需要和短信模板一一对应
	 * @return 异常返回null , 错误返回阿里云短信的标准信息
	 */
	public SmsResult sendSms(String phone, String templateCode, Map<String, String> context) {
		if (context!=null){
		DefaultProfile profile = DefaultProfile.getProfile(
						SmsParam.REGION_ID.getValue(),
						SmsParam.ACCESS_KEY_ID.getValue(),
						SmsParam.SECRET.getValue()
		);
		IAcsClient client = new DefaultAcsClient(profile);
		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("RegionId", "cn-hangzhou");
		request.putQueryParameter("PhoneNumbers", phone);
		request.putQueryParameter("SignName", "煤炭运销管理平台");
		request.putQueryParameter("TemplateCode", templateCode);
		Gson gson = new Gson();
		String s = gson.toJson(context);
		request.putQueryParameter("TemplateParam", s);
		CommonResponse response = null;
			SmsResult smsResult = null;

			try {
				response = client.getCommonResponse(request);
				smsResult = GsonUtil.GsonToBean(response.getData(), SmsResult.class);
				log.info(response.getData());
				// 发送成功,保存日志
				SmsLog smsLog = new SmsLog();
				smsLog.setId(ToolUtil.getUUID());
				smsLog.setPhone(phone);
				smsLog.setTemplatecode(templateCode);
				smsLog.setMessage(smsResult.message);
				smsLog.setContext(s);
				smsLog.setCode(smsResult.code);
				smsLog.setRequestid(smsResult.requestId);
				smsLog.setBizid(smsResult.bizId);
				smsLogService.saveSmsLog(smsLog);
			} catch (ClientException e) {
				e.printStackTrace();
				if (log.isErrorEnabled()) {
					log.error(LocalDateTime.now().toString() + response.getData());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return smsResult;
		} else {
			return null;
		}
	}

	/**
	 * 获取短信历史发送信息
	 *
	 * @param phone       电话号码
	 * @param yyyyMMdd    日期
	 * @param pageSize    页面大小
	 * @param currentPage 第几页
	 * @return
	 */
	public CommonRequest querySendDetails(String phone, String yyyyMMdd, String pageSize, String currentPage) {
		DefaultProfile profile = DefaultProfile.getProfile(
						SmsParam.REGION_ID.getValue(),
						SmsParam.ACCESS_KEY_ID.getValue(),
						SmsParam.SECRET.getValue()
		);
		IAcsClient client = new DefaultAcsClient(profile);
		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("QuerySendDetails");
		request.putQueryParameter("RegionId", "cn-hangzhou");
		request.putQueryParameter("PhoneNumber", phone);
		String date = DateFormatUtil.formatDate("yyyyMMdd",
						ClockUtil.currentDate());
		request.putQueryParameter("SendDate", date);
		request.putQueryParameter("PageSize", pageSize);
		request.putQueryParameter("CurrentPage", currentPage);
		request.putQueryParameter("RegionId", "cn-hangzhou");
		CommonResponse response = null;
		try {
			response = client.getCommonResponse(request);
			System.out.println(response.getData());
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return request;
	}

}




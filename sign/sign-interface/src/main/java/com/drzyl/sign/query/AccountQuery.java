package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 账号 SYS_ACCOUNT 查询类
 */
@Data
public class AccountQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String accountId; // 账号编号

  protected String account; // 账号

  protected String password; // 密码

  protected String mobilePhoneNumber; // 手机号

  protected Long cookiesExpireTimesBrowser; // 浏览器会话过期时间

  protected Long cookiesExpireTimesAndroid; // 安卓APP会话过期时间

  protected Long cookiesExpireTimesIos; // 苹果APP会话过期时间

  protected Long cookiesExpireTimesWechatapp; // 微信小程序会话过期时间

  protected String nexusType; // 关联类型

  protected String nexusObjectId; // 对象编号

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected Long modifyTimes; // 修改时间

  protected List<String> accountIdAndin; // 账号编号Andin查询

  protected String accountAndeq; // 账号Andeq查询

  protected String accountAndKeyLike; // 账号AndKeyLike查询

  protected String passwordOrKeyLike; // 密码OrKeyLike查询

  protected String mobilePhoneNumberOrKeyLike; // 手机号OrKeyLike查询

  protected String nexusTypeOrKeyLike; // 关联类型OrKeyLike查询

  protected String nexusObjectIdOrKeyLike; // 对象编号OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

}

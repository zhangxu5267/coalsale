package com.drzyl.sign.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 账号 SYS_ACCOUNT 实体类
 */
@Data
@TableName(value = "SYS_ACCOUNT")
public class Account implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
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

}

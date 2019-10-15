export default class AccountVO {
  constructor () {
    this.accountId = null // 账号编号
    this.account = null // 账号
    this.password = null // 密码
    this.mobilePhoneNumber = null // 手机号
    this.cookiesExpireTimesBrowser = null // 浏览器会话过期时间
    this.cookiesExpireTimesAndroid = null // 安卓APP会话过期时间
    this.cookiesExpireTimesIos = null // 苹果APP会话过期时间
    this.cookiesExpireTimesWechatapp = null // 微信小程序会话过期时间
    this.nexusType = null // 关联类型
    this.nexusObjectId = null // 对象编号
    this.versions = null // 版本号
    this.createId = null // 创建人账号
    this.createName = null // 创建人名称
    this.createTimes = null // 创建时间
    this.modifyId = null // 修改人账号
    this.modifyName = null // 修改人名称
    this.modifyTimes = null // 修改时间
  }
}

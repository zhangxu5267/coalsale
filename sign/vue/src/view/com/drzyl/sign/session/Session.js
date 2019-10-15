export default class Session {
  constructor () {
    this.sessionId = null // 会话编号
    this.accountId = null // 账号编号
    this.loginKey = null // 登录标识
    this.currentTimes = null // 当前时间
    this.aesKey = null // AES密钥
    this.cookiesExpireTimesBrowser = null // 浏览器会话过期时间
    this.cookiesExpireTimesAndroid = null // 安卓APP会话过期时间
    this.cookiesExpireTimesIos = null // 苹果APP会话过期时间
    this.cookiesExpireTimesWechatapp = null // 微信小程序会话过期时间
  }
}

export default class SessionQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.sessionId = null // 会话编号
    this.accountId = null // 账号编号
    this.loginKey = null // 登录标识
    this.currentTimes = null // 当前时间
    this.aesKey = null // AES密钥
    this.cookiesExpireTimesBrowser = null // 浏览器会话过期时间
    this.cookiesExpireTimesAndroid = null // 安卓APP会话过期时间
    this.cookiesExpireTimesIos = null // 苹果APP会话过期时间
    this.cookiesExpireTimesWechatapp = null // 微信小程序会话过期时间
    this.sessionIdAndin = null // 会话编号Andin查询
    this.accountIdAndeq = null // 账号编号Andeq查询
    this.loginKeyAndeq = null // 登录标识Andeq查询
    this.accountIdAndKeyLike = null // 账号编号AndKeyLike查询
    this.loginKeyOrKeyLike = null // 登录标识OrKeyLike查询
    this.aesKeyOrKeyLike = null // AES密钥OrKeyLike查询
  }
}

export default class CusTagTempQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.cusTagTempId = null // ID
    this.cusTagId = null // 客户ID
    this.cusBaseId = null // 标签ID
    this.cusTagTempIdAndin = null // IDAndin查询
    this.cusTagIdAndKeyLike = null // 客户IDAndKeyLike查询
    this.cusBaseIdOrKeyLike = null // 标签IDOrKeyLike查询
  }
}

export default class TableCssQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.id = null // ID
    this.createId = null // 创建账号
    this.tableKey = null // 表格标识
    this.context = null // json样式
    this.idAndin = null // IDAndin查询
    this.createIdAndKeyLike = null // 创建账号AndKeyLike查询
    this.tableKeyOrKeyLike = null // 表格标识OrKeyLike查询
    this.contextOrKeyLike = null // json样式OrKeyLike查询
  }
}

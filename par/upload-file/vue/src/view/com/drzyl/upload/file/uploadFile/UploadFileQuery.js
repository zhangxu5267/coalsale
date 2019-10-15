export default class UploadFileQuery {
  constructor () {
    this.toolExists = null // 解决多对多关系预留字段之存在
    this.toolNotExists = null // 解决多对多关系预留字段之不存在
    this.fileId = null // ID
    this.fileName = null // 文件名称
    this.fileUrl = null // 文件路径
    this.fileType = null // 文件类型
    this.fileSize = null // 文件大小(单位B)
    this.fileSuffix = null // 文件后缀
    this.module = null // 文件来源模块
    this.moduleHash = null // 来源HASH
    this.remark = null // 备注
    this.versions = null // 版本号
    this.createId = null // 创建人账号
    this.createName = null // 创建人名称
    this.createOrg = null // 创建机构
    this.createTimes = null // 创建时间
    this.delFlag = null // 逻辑删除0=删除,1=显示
    this.fileIdAndin = null // IDAndin查询
    this.fileNameAndKeyLike = null // 文件名称AndKeyLike查询
    this.fileUrlOrKeyLike = null // 文件路径OrKeyLike查询
    this.fileTypeOrKeyLike = null // 文件类型OrKeyLike查询
    this.fileSizeOrKeyLike = null // 文件大小(单位B)OrKeyLike查询
    this.fileSuffixOrKeyLike = null // 文件后缀OrKeyLike查询
    this.moduleOrKeyLike = null // 文件来源模块OrKeyLike查询
    this.moduleHashOrKeyLike = null // 来源HASHOrKeyLike查询
    this.remarkOrKeyLike = null // 备注OrKeyLike查询
    this.createIdOrKeyLike = null // 创建人账号OrKeyLike查询
    this.createNameOrKeyLike = null // 创建人名称OrKeyLike查询
    this.createOrgOrKeyLike = null // 创建机构OrKeyLike查询
    this.delFlagOrKeyLike = null // 逻辑删除0=删除,1=显示OrKeyLike查询
  }
}

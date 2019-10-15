export default class UploadFileVO {
  constructor () {
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
  }
}

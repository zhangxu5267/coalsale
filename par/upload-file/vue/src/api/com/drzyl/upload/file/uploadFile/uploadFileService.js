import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'upload/file/uploadFile'

export default {
  save: (uploadFile) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), uploadFile)
  },
  batchSave: (uploadFiles) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), uploadFiles)
  },
  update: (uploadFile) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), uploadFile)
  },
  batchUpdate: (uploadFiles) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), uploadFiles)
  },
  remove: (uploadFile) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), uploadFile)
  },
  batchRemove: (uploadFiles) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), uploadFiles)
  },
  getByPk: (uploadFile) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), uploadFile)
  },
  getAll: (uploadFileQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), uploadFileQuery)
  },
  paging: (uploadFileQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), uploadFileQuery)
  },
  getVOByPk: (uploadFile) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), uploadFile)
  },
  getAllVO: (uploadFileQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), uploadFileQuery)
  },
  pagingVO: (uploadFileQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), uploadFileQuery)
  }
}

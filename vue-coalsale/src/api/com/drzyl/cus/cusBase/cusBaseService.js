import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'
import axios from 'axios'

const url = 'cus/cus'
const uploadUrl = 'upload/file'

export default {
  save: (cusBase) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), cusBase)
  },
  batchSave: (cusBases) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), cusBases)
  },
  update: (cusBase) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), cusBase)
  },
  batchUpdate: (cusBases) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), cusBases)
  },
  remove: (cusBase) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), cusBase)
  },
  batchRemove: (cusBases) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), cusBases)
  },
  getByPk: (cusBase) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), cusBase)
  },
  getAll: (cusBaseQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), cusBaseQuery)
  },
  paging: (cusBaseQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), cusBaseQuery)
  },
  getVOByPk: (cusBase) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), cusBase)
  },
  getAllVO: (cusBaseQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), cusBaseQuery)
  },
  pagingVO: (cusBaseQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), cusBaseQuery)
  },
  uploadAttach: (cusBaseQuery, muduleName) => {
    return axios.post(ToolUtil.getUploadUrl(uploadUrl, ToolUtil.upload, muduleName), cusBaseQuery)
  }
}

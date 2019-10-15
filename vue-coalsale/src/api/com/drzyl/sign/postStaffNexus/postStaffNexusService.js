import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'sign/postStaffNexus'

export default {
  save: (postStaffNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), postStaffNexus)
  },
  batchSave: (postStaffNexuss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), postStaffNexuss)
  },
  update: (postStaffNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), postStaffNexus)
  },
  batchUpdate: (postStaffNexuss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), postStaffNexuss)
  },
  remove: (postStaffNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), postStaffNexus)
  },
  batchRemove: (postStaffNexuss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), postStaffNexuss)
  },
  getByPk: (postStaffNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), postStaffNexus)
  },
  getAll: (postStaffNexusQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), postStaffNexusQuery)
  },
  paging: (postStaffNexusQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), postStaffNexusQuery)
  },
  getVOByPk: (postStaffNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), postStaffNexus)
  },
  getAllVO: (postStaffNexusQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), postStaffNexusQuery)
  },
  pagingVO: (postStaffNexusQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), postStaffNexusQuery)
  }
}

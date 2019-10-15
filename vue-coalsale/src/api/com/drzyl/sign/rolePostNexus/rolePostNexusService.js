import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'sign/rolePostNexus'

export default {
  save: (rolePostNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), rolePostNexus)
  },
  batchSave: (rolePostNexuss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), rolePostNexuss)
  },
  update: (rolePostNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), rolePostNexus)
  },
  batchUpdate: (rolePostNexuss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), rolePostNexuss)
  },
  remove: (rolePostNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), rolePostNexus)
  },
  batchRemove: (rolePostNexuss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), rolePostNexuss)
  },
  getByPk: (rolePostNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), rolePostNexus)
  },
  getAll: (rolePostNexusQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), rolePostNexusQuery)
  },
  paging: (rolePostNexusQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), rolePostNexusQuery)
  },
  getVOByPk: (rolePostNexus) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), rolePostNexus)
  },
  getAllVO: (rolePostNexusQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), rolePostNexusQuery)
  },
  pagingVO: (rolePostNexusQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), rolePostNexusQuery)
  }
}

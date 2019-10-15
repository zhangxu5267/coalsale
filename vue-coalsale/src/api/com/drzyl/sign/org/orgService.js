import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'sign/org'

export default {
  save: (org) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), org)
  },
  batchSave: (orgs) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), orgs)
  },
  update: (org) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), org)
  },
  batchUpdate: (orgs) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), orgs)
  },
  remove: (org) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), org)
  },
  batchRemove: (orgs) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), orgs)
  },
  getByPk: (org) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), org)
  },
  getAll: (orgQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), orgQuery)
  },
  paging: (orgQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), orgQuery)
  },
  getVOByPk: (org) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), org)
  },
  getAllVO: (orgQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), orgQuery)
  },
  pagingVO: (orgQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), orgQuery)
  }
}

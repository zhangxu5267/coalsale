import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'sign/role'

export default {
  save: (role) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), role)
  },
  batchSave: (roles) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), roles)
  },
  update: (role) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), role)
  },
  batchUpdate: (roles) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), roles)
  },
  remove: (role) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), role)
  },
  batchRemove: (roles) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), roles)
  },
  getByPk: (role) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), role)
  },
  getAll: (roleQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), roleQuery)
  },
  paging: (roleQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), roleQuery)
  },
  getVOByPk: (role) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), role)
  },
  getAllVO: (roleQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), roleQuery)
  },
  pagingVO: (roleQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), roleQuery)
  }
}

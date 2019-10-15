import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'sign/staff'

export default {
  save: (staff) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), staff)
  },
  batchSave: (staffs) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), staffs)
  },
  update: (staff) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), staff)
  },
  batchUpdate: (staffs) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), staffs)
  },
  remove: (staff) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), staff)
  },
  batchRemove: (staffs) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), staffs)
  },
  getByPk: (staff) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), staff)
  },
  getAll: (staffQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), staffQuery)
  },
  paging: (staffQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), staffQuery)
  },
  getVOByPk: (staff) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), staff)
  },
  getAllVO: (staffQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), staffQuery)
  },
  pagingVO: (staffQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), staffQuery)
  }
}

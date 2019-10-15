import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'sign/post'

export default {
  save: (post) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), post)
  },
  batchSave: (posts) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), posts)
  },
  update: (post) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), post)
  },
  batchUpdate: (posts) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), posts)
  },
  remove: (post) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), post)
  },
  batchRemove: (posts) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), posts)
  },
  getByPk: (post) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), post)
  },
  getAll: (postQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), postQuery)
  },
  paging: (postQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), postQuery)
  },
  getVOByPk: (post) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), post)
  },
  getAllVO: (postQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), postQuery)
  },
  pagingVO: (postQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), postQuery)
  }
}

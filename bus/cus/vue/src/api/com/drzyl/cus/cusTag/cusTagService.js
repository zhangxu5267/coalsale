import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'cus/cusTag'

export default {
  save: (cusTag) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), cusTag)
  },
  batchSave: (cusTags) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), cusTags)
  },
  update: (cusTag) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), cusTag)
  },
  batchUpdate: (cusTags) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), cusTags)
  },
  remove: (cusTag) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), cusTag)
  },
  batchRemove: (cusTags) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), cusTags)
  },
  getByPk: (cusTag) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), cusTag)
  },
  getAll: (cusTagQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), cusTagQuery)
  },
  paging: (cusTagQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), cusTagQuery)
  },
  getVOByPk: (cusTag) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), cusTag)
  },
  getAllVO: (cusTagQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), cusTagQuery)
  },
  pagingVO: (cusTagQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), cusTagQuery)
  }
}

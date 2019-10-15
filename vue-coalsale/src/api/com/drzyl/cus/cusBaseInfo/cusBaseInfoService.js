import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'cus/cusBaseInfo'

export default {
  save: (cusBaseInfo) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), cusBaseInfo)
  },
  batchSave: (cusBaseInfos) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), cusBaseInfos)
  },
  update: (cusBaseInfo) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), cusBaseInfo)
  },
  batchUpdate: (cusBaseInfos) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), cusBaseInfos)
  },
  remove: (cusBaseInfo) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), cusBaseInfo)
  },
  batchRemove: (cusBaseInfos) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), cusBaseInfos)
  },
  getByPk: (cusBaseInfo) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), cusBaseInfo)
  },
  getAll: (cusBaseInfoQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), cusBaseInfoQuery)
  },
  paging: (cusBaseInfoQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), cusBaseInfoQuery)
  },
  getVOByPk: (cusBaseInfo) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), cusBaseInfo)
  },
  getAllVO: (cusBaseInfoQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), cusBaseInfoQuery)
  },
  pagingVO: (cusBaseInfoQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), cusBaseInfoQuery)
  }
}

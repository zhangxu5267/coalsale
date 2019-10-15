import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'cus/cusTagTemp'

export default {
  save: (cusTagTemp) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), cusTagTemp)
  },
  batchSave: (cusTagTemps) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), cusTagTemps)
  },
  update: (cusTagTemp) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), cusTagTemp)
  },
  batchUpdate: (cusTagTemps) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), cusTagTemps)
  },
  remove: (cusTagTemp) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), cusTagTemp)
  },
  batchRemove: (cusTagTemps) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), cusTagTemps)
  },
  getByPk: (cusTagTemp) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), cusTagTemp)
  },
  getAll: (cusTagTempQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), cusTagTempQuery)
  },
  paging: (cusTagTempQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), cusTagTempQuery)
  },
  getVOByPk: (cusTagTemp) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), cusTagTemp)
  },
  getAllVO: (cusTagTempQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), cusTagTempQuery)
  },
  pagingVO: (cusTagTempQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), cusTagTempQuery)
  }
}

import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'cus/cusAddrDis'

export default {
  save: (cusAddrDis) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), cusAddrDis)
  },
  batchSave: (cusAddrDiss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), cusAddrDiss)
  },
  update: (cusAddrDis) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), cusAddrDis)
  },
  batchUpdate: (cusAddrDiss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), cusAddrDiss)
  },
  remove: (cusAddrDis) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), cusAddrDis)
  },
  batchRemove: (cusAddrDiss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), cusAddrDiss)
  },
  getByPk: (cusAddrDis) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), cusAddrDis)
  },
  getAll: (cusAddrDisQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), cusAddrDisQuery)
  },
  paging: (cusAddrDisQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), cusAddrDisQuery)
  },
  getVOByPk: (cusAddrDis) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), cusAddrDis)
  },
  getAllVO: (cusAddrDisQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), cusAddrDisQuery)
  },
  pagingVO: (cusAddrDisQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), cusAddrDisQuery)
  }
}

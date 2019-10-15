import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'cus/cusAddress'

export default {
  save: (cusAddress) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), cusAddress)
  },
  batchSave: (cusAddresss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), cusAddresss)
  },
  update: (cusAddress) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), cusAddress)
  },
  batchUpdate: (cusAddresss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), cusAddresss)
  },
  remove: (cusAddress) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), cusAddress)
  },
  batchRemove: (cusAddresss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), cusAddresss)
  },
  getByPk: (cusAddress) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), cusAddress)
  },
  getAll: (cusAddressQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), cusAddressQuery)
  },
  paging: (cusAddressQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), cusAddressQuery)
  },
  getVOByPk: (cusAddress) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), cusAddress)
  },
  getAllVO: (cusAddressQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), cusAddressQuery)
  },
  pagingVO: (cusAddressQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), cusAddressQuery)
  }
}

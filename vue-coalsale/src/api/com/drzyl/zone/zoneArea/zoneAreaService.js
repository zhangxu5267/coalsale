import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'zone/zoneArea'

export default {
  save: (zoneArea) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), zoneArea)
  },
  batchSave: (zoneAreas) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), zoneAreas)
  },
  update: (zoneArea) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), zoneArea)
  },
  batchUpdate: (zoneAreas) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), zoneAreas)
  },
  remove: (zoneArea) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), zoneArea)
  },
  batchRemove: (zoneAreas) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), zoneAreas)
  },
  getByPk: (zoneArea) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), zoneArea)
  },
  getAll: (zoneAreaQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), zoneAreaQuery)
  },
  paging: (zoneAreaQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), zoneAreaQuery)
  },
  getVOByPk: (zoneArea) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), zoneArea)
  },
  getAllVO: (zoneAreaQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), zoneAreaQuery)
  },
  pagingVO: (zoneAreaQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), zoneAreaQuery)
  }
}

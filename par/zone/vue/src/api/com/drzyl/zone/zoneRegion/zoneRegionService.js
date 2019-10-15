import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'zone/zoneRegion'

export default {
  save: (zoneRegion) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), zoneRegion)
  },
  batchSave: (zoneRegions) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), zoneRegions)
  },
  update: (zoneRegion) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), zoneRegion)
  },
  batchUpdate: (zoneRegions) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), zoneRegions)
  },
  remove: (zoneRegion) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), zoneRegion)
  },
  batchRemove: (zoneRegions) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), zoneRegions)
  },
  getByPk: (zoneRegion) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), zoneRegion)
  },
  getAll: (zoneRegionQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), zoneRegionQuery)
  },
  paging: (zoneRegionQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), zoneRegionQuery)
  },
  getVOByPk: (zoneRegion) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), zoneRegion)
  },
  getAllVO: (zoneRegionQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), zoneRegionQuery)
  },
  pagingVO: (zoneRegionQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), zoneRegionQuery)
  }
}

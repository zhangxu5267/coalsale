import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'zone/zoneAreaRegionTepe'

export default {
  save: (zoneAreaRegionTepe) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), zoneAreaRegionTepe)
  },
  batchSave: (zoneAreaRegionTepes) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), zoneAreaRegionTepes)
  },
  update: (zoneAreaRegionTepe) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), zoneAreaRegionTepe)
  },
  batchUpdate: (zoneAreaRegionTepes) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), zoneAreaRegionTepes)
  },
  remove: (zoneAreaRegionTepe) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), zoneAreaRegionTepe)
  },
  batchRemove: (zoneAreaRegionTepes) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), zoneAreaRegionTepes)
  },
  getByPk: (zoneAreaRegionTepe) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), zoneAreaRegionTepe)
  },
  getAll: (zoneAreaRegionTepeQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), zoneAreaRegionTepeQuery)
  },
  paging: (zoneAreaRegionTepeQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), zoneAreaRegionTepeQuery)
  },
  getVOByPk: (zoneAreaRegionTepe) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), zoneAreaRegionTepe)
  },
  getAllVO: (zoneAreaRegionTepeQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), zoneAreaRegionTepeQuery)
  },
  pagingVO: (zoneAreaRegionTepeQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), zoneAreaRegionTepeQuery)
  }
}

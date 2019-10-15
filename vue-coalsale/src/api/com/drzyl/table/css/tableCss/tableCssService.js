import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'table/css/tableCss'

export default {
  save: (tableCss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), tableCss)
  },
  batchSave: (tableCsss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), tableCsss)
  },
  update: (tableCss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), tableCss)
  },
  batchUpdate: (tableCsss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), tableCsss)
  },
  remove: (tableCss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), tableCss)
  },
  batchRemove: (tableCsss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), tableCsss)
  },
  getByPk: (tableCss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), tableCss)
  },
  getAll: (tableCssQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), tableCssQuery)
  },
  paging: (tableCssQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), tableCssQuery)
  },
  getVOByPk: (tableCss) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), tableCss)
  },
  getAllVO: (tableCssQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), tableCssQuery)
  },
  pagingVO: (tableCssQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), tableCssQuery)
  }
}

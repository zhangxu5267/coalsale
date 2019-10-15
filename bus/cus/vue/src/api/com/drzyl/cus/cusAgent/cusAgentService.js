import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'cus/cusAgent'

export default {
  save: (cusAgent) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.save), cusAgent)
  },
  batchSave: (cusAgents) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchSave), cusAgents)
  },
  update: (cusAgent) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.update), cusAgent)
  },
  batchUpdate: (cusAgents) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchUpdate), cusAgents)
  },
  remove: (cusAgent) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.remove), cusAgent)
  },
  batchRemove: (cusAgents) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.batchRemove), cusAgents)
  },
  getByPk: (cusAgent) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getByPk), cusAgent)
  },
  getAll: (cusAgentQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAll), cusAgentQuery)
  },
  paging: (cusAgentQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.paging, rows, page), cusAgentQuery)
  },
  getVOByPk: (cusAgent) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getVOByPk), cusAgent)
  },
  getAllVO: (cusAgentQuery) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.getAllVO), cusAgentQuery)
  },
  pagingVO: (cusAgentQuery, rows, page) => {
    return ToolAxios.post(ToolUtil.getUrl(url, ToolUtil.pagingVO, rows, page), cusAgentQuery)
  }
}

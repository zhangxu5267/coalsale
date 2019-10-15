import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'code/databasetable'

export default {
  getAllTable: () => {
    return ToolAxios.post(ToolUtil.getUrl(url, 'get_all_table'))
  },
  getDataBaseType: () => {
    return ToolAxios.post(ToolUtil.getUrl(url, 'get_data_base_type'))
  }
}

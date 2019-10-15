import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'sign/role_access'

export default {
  saveRoleAccess: (roleAccessParam) => {
    return ToolAxios.post(ToolUtil.getUrl(url, 'save_role_access'), roleAccessParam)
  },
  getRoleAccess: (roleAccessParam) => {
    return ToolAxios.post(ToolUtil.getUrl(url, 'get_role_access'), roleAccessParam)
  }
}

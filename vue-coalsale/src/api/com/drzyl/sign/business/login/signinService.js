import ToolUtil from '@/tool/ToolUtil'
import ToolAxios from '@/tool/ToolAxios'

const url = 'login'

export default {
  login: (loginInfoParam) => {
    return ToolAxios.post(ToolUtil.getUrl(url, 'account_login'), loginInfoParam)
  },
  sendVerificationCode: (loginInfoParam) => {
    return ToolAxios.post(ToolUtil.getUrl(url, 'login_sms_code'), loginInfoParam)
  }
}

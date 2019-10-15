import signinService from '@/api/com/drzyl/sign/business/login/signinService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    login ({ commit, state }, loginInfoParam) {
      return new Promise((resolve, reject) => {
        signinService.login(loginInfoParam).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    sendVerificationCode ({ commit, state }, loginSmsCode) {
      return new Promise((resolve, reject) => {
        signinService.sendVerificationCode(loginSmsCode).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    }
  },
  getters: {
  }
}

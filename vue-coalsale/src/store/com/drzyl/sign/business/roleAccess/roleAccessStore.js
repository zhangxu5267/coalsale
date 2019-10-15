import roleAccessService from '@/api/com/drzyl/sign/business/roleAccess/roleAccessService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveRoleAccess ({ commit, state }, roleAccessParam) {
      return new Promise((resolve, reject) => {
        roleAccessService.saveRoleAccess(roleAccessParam).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getRoleAccess ({ commit, state }, roleAccessParam) {
      return new Promise((resolve, reject) => {
        roleAccessService.getRoleAccess(roleAccessParam).then(res => {
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

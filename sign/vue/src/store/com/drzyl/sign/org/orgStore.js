import orgService from '@/api/com/drzyl/sign/org/orgService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveOrg ({ commit, state }, org) {
      return new Promise((resolve, reject) => {
        orgService.save(org).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveOrg ({ commit, state }, orgs) {
      return new Promise((resolve, reject) => {
        orgService.batchSave(orgs).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateOrg ({ commit, state }, org) {
      return new Promise((resolve, reject) => {
        orgService.update(org).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateOrg ({ commit, state }, orgs) {
      return new Promise((resolve, reject) => {
        orgService.batchUpdate(orgs).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeOrg ({ commit, state }, org) {
      return new Promise((resolve, reject) => {
        orgService.remove(org).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveOrg ({ commit, state }, orgs) {
      return new Promise((resolve, reject) => {
        orgService.batchRemove(orgs).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getOrgByPk ({ commit, state }, org) {
      return new Promise((resolve, reject) => {
        orgService.getByPk(org).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllOrg ({ commit, state }) {
      return new Promise((resolve, reject) => {
        orgService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryOrg ({ commit, state }, orgQuery) {
      return new Promise((resolve, reject) => {
        orgService.getAll(orgQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryOrg ({ commit, state }, { orgQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        orgService.paging(orgQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getOrgVOByPk ({ commit, state }, org) {
      return new Promise((resolve, reject) => {
        orgService.getVOByPk(org).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllOrgVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        orgService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryOrgVO ({ commit, state }, orgQuery) {
      return new Promise((resolve, reject) => {
        orgService.getAllVO(orgQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryOrgVO ({ commit, state }, { orgQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        orgService.pagingVO(orgQuery, rows, page).then(res => {
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

import cusAgentService from '@/api/com/drzyl/cus/cusAgent/cusAgentService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveCusAgent ({ commit, state }, cusAgent) {
      return new Promise((resolve, reject) => {
        cusAgentService.save(cusAgent).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveCusAgent ({ commit, state }, cusAgents) {
      return new Promise((resolve, reject) => {
        cusAgentService.batchSave(cusAgents).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateCusAgent ({ commit, state }, cusAgent) {
      return new Promise((resolve, reject) => {
        cusAgentService.update(cusAgent).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateCusAgent ({ commit, state }, cusAgents) {
      return new Promise((resolve, reject) => {
        cusAgentService.batchUpdate(cusAgents).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeCusAgent ({ commit, state }, cusAgent) {
      return new Promise((resolve, reject) => {
        cusAgentService.remove(cusAgent).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveCusAgent ({ commit, state }, cusAgents) {
      return new Promise((resolve, reject) => {
        cusAgentService.batchRemove(cusAgents).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusAgentByPk ({ commit, state }, cusAgent) {
      return new Promise((resolve, reject) => {
        cusAgentService.getByPk(cusAgent).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusAgent ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusAgentService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusAgent ({ commit, state }, cusAgentQuery) {
      return new Promise((resolve, reject) => {
        cusAgentService.getAll(cusAgentQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusAgent ({ commit, state }, { cusAgentQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusAgentService.paging(cusAgentQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusAgentVOByPk ({ commit, state }, cusAgent) {
      return new Promise((resolve, reject) => {
        cusAgentService.getVOByPk(cusAgent).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusAgentVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusAgentService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusAgentVO ({ commit, state }, cusAgentQuery) {
      return new Promise((resolve, reject) => {
        cusAgentService.getAllVO(cusAgentQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusAgentVO ({ commit, state }, { cusAgentQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusAgentService.pagingVO(cusAgentQuery, rows, page).then(res => {
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

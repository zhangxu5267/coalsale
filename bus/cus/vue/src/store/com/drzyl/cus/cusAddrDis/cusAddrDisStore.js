import cusAddrDisService from '@/api/com/drzyl/cus/cusAddrDis/cusAddrDisService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveCusAddrDis ({ commit, state }, cusAddrDis) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.save(cusAddrDis).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveCusAddrDis ({ commit, state }, cusAddrDiss) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.batchSave(cusAddrDiss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateCusAddrDis ({ commit, state }, cusAddrDis) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.update(cusAddrDis).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateCusAddrDis ({ commit, state }, cusAddrDiss) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.batchUpdate(cusAddrDiss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeCusAddrDis ({ commit, state }, cusAddrDis) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.remove(cusAddrDis).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveCusAddrDis ({ commit, state }, cusAddrDiss) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.batchRemove(cusAddrDiss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusAddrDisByPk ({ commit, state }, cusAddrDis) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.getByPk(cusAddrDis).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusAddrDis ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusAddrDis ({ commit, state }, cusAddrDisQuery) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.getAll(cusAddrDisQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusAddrDis ({ commit, state }, { cusAddrDisQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.paging(cusAddrDisQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusAddrDisVOByPk ({ commit, state }, cusAddrDis) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.getVOByPk(cusAddrDis).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusAddrDisVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusAddrDisVO ({ commit, state }, cusAddrDisQuery) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.getAllVO(cusAddrDisQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusAddrDisVO ({ commit, state }, { cusAddrDisQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusAddrDisService.pagingVO(cusAddrDisQuery, rows, page).then(res => {
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

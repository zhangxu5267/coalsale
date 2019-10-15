import cusTagTempService from '@/api/com/drzyl/cus/cusTagTemp/cusTagTempService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveCusTagTemp ({ commit, state }, cusTagTemp) {
      return new Promise((resolve, reject) => {
        cusTagTempService.save(cusTagTemp).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveCusTagTemp ({ commit, state }, cusTagTemps) {
      return new Promise((resolve, reject) => {
        cusTagTempService.batchSave(cusTagTemps).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateCusTagTemp ({ commit, state }, cusTagTemp) {
      return new Promise((resolve, reject) => {
        cusTagTempService.update(cusTagTemp).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateCusTagTemp ({ commit, state }, cusTagTemps) {
      return new Promise((resolve, reject) => {
        cusTagTempService.batchUpdate(cusTagTemps).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeCusTagTemp ({ commit, state }, cusTagTemp) {
      return new Promise((resolve, reject) => {
        cusTagTempService.remove(cusTagTemp).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveCusTagTemp ({ commit, state }, cusTagTemps) {
      return new Promise((resolve, reject) => {
        cusTagTempService.batchRemove(cusTagTemps).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusTagTempByPk ({ commit, state }, cusTagTemp) {
      return new Promise((resolve, reject) => {
        cusTagTempService.getByPk(cusTagTemp).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusTagTemp ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusTagTempService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusTagTemp ({ commit, state }, cusTagTempQuery) {
      return new Promise((resolve, reject) => {
        cusTagTempService.getAll(cusTagTempQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusTagTemp ({ commit, state }, { cusTagTempQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusTagTempService.paging(cusTagTempQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusTagTempVOByPk ({ commit, state }, cusTagTemp) {
      return new Promise((resolve, reject) => {
        cusTagTempService.getVOByPk(cusTagTemp).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusTagTempVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusTagTempService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusTagTempVO ({ commit, state }, cusTagTempQuery) {
      return new Promise((resolve, reject) => {
        cusTagTempService.getAllVO(cusTagTempQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusTagTempVO ({ commit, state }, { cusTagTempQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusTagTempService.pagingVO(cusTagTempQuery, rows, page).then(res => {
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

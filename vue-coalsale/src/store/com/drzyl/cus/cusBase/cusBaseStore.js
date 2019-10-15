import cusBaseService from '@/api/com/drzyl/cus/cusBase/cusBaseService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveCusBase ({ commit, state }, cusBase) {
      return new Promise((resolve, reject) => {
        cusBaseService.save(cusBase).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveCusBase ({ commit, state }, cusBases) {
      return new Promise((resolve, reject) => {
        cusBaseService.batchSave(cusBases).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateCusBase ({ commit, state }, cusBase) {
      return new Promise((resolve, reject) => {
        cusBaseService.update(cusBase).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateCusBase ({ commit, state }, cusBases) {
      return new Promise((resolve, reject) => {
        cusBaseService.batchUpdate(cusBases).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeCusBase ({ commit, state }, cusBase) {
      return new Promise((resolve, reject) => {
        cusBaseService.remove(cusBase).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveCusBase ({ commit, state }, cusBases) {
      return new Promise((resolve, reject) => {
        cusBaseService.batchRemove(cusBases).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusBaseByPk ({ commit, state }, cusBase) {
      return new Promise((resolve, reject) => {
        cusBaseService.getByPk(cusBase).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusBase ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusBaseService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusBase ({ commit, state }, cusBaseQuery) {
      return new Promise((resolve, reject) => {
        cusBaseService.getAll(cusBaseQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusBase ({ commit, state }, { cusBaseQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusBaseService.paging(cusBaseQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusBaseVOByPk ({ commit, state }, cusBase) {
      return new Promise((resolve, reject) => {
        cusBaseService.getVOByPk(cusBase).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusBaseVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusBaseService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusBaseVO ({ commit, state }, cusBaseQuery) {
      return new Promise((resolve, reject) => {
        cusBaseService.getAllVO(cusBaseQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusBaseVO ({ commit, state }, { cusBaseQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusBaseService.pagingVO(cusBaseQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    uploadAttach ({ commit, state }, { cusBaseQuery, muduleName }) {
      return new Promise((resolve, reject) => {
        cusBaseService.uploadAttach(cusBaseQuery, muduleName).then(res => {
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

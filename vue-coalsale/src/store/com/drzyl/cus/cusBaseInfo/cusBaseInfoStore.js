import cusBaseInfoService from '@/api/com/drzyl/cus/cusBaseInfo/cusBaseInfoService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveCusBaseInfo ({ commit, state }, cusBaseInfo) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.save(cusBaseInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveCusBaseInfo ({ commit, state }, cusBaseInfos) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.batchSave(cusBaseInfos).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateCusBaseInfo ({ commit, state }, cusBaseInfo) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.update(cusBaseInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateCusBaseInfo ({ commit, state }, cusBaseInfos) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.batchUpdate(cusBaseInfos).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeCusBaseInfo ({ commit, state }, cusBaseInfo) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.remove(cusBaseInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveCusBaseInfo ({ commit, state }, cusBaseInfos) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.batchRemove(cusBaseInfos).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusBaseInfoByPk ({ commit, state }, cusBaseInfo) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.getByPk(cusBaseInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusBaseInfo ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusBaseInfo ({ commit, state }, cusBaseInfoQuery) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.getAll(cusBaseInfoQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusBaseInfo ({ commit, state }, { cusBaseInfoQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.paging(cusBaseInfoQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusBaseInfoVOByPk ({ commit, state }, cusBaseInfo) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.getVOByPk(cusBaseInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusBaseInfoVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusBaseInfoVO ({ commit, state }, cusBaseInfoQuery) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.getAllVO(cusBaseInfoQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusBaseInfoVO ({ commit, state }, { cusBaseInfoQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusBaseInfoService.pagingVO(cusBaseInfoQuery, rows, page).then(res => {
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

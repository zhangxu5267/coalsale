import cusAddressService from '@/api/com/drzyl/cus/cusAddress/cusAddressService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveCusAddress ({ commit, state }, cusAddress) {
      return new Promise((resolve, reject) => {
        cusAddressService.save(cusAddress).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveCusAddress ({ commit, state }, cusAddresss) {
      return new Promise((resolve, reject) => {
        cusAddressService.batchSave(cusAddresss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateCusAddress ({ commit, state }, cusAddress) {
      return new Promise((resolve, reject) => {
        cusAddressService.update(cusAddress).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateCusAddress ({ commit, state }, cusAddresss) {
      return new Promise((resolve, reject) => {
        cusAddressService.batchUpdate(cusAddresss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeCusAddress ({ commit, state }, cusAddress) {
      return new Promise((resolve, reject) => {
        cusAddressService.remove(cusAddress).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveCusAddress ({ commit, state }, cusAddresss) {
      return new Promise((resolve, reject) => {
        cusAddressService.batchRemove(cusAddresss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusAddressByPk ({ commit, state }, cusAddress) {
      return new Promise((resolve, reject) => {
        cusAddressService.getByPk(cusAddress).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusAddress ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusAddressService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusAddress ({ commit, state }, cusAddressQuery) {
      return new Promise((resolve, reject) => {
        cusAddressService.getAll(cusAddressQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusAddress ({ commit, state }, { cusAddressQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusAddressService.paging(cusAddressQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusAddressVOByPk ({ commit, state }, cusAddress) {
      return new Promise((resolve, reject) => {
        cusAddressService.getVOByPk(cusAddress).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusAddressVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusAddressService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusAddressVO ({ commit, state }, cusAddressQuery) {
      return new Promise((resolve, reject) => {
        cusAddressService.getAllVO(cusAddressQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusAddressVO ({ commit, state }, { cusAddressQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusAddressService.pagingVO(cusAddressQuery, rows, page).then(res => {
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

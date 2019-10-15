import cusTagService from '@/api/com/drzyl/cus/cusTag/cusTagService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveCusTag ({ commit, state }, cusTag) {
      return new Promise((resolve, reject) => {
        cusTagService.save(cusTag).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveCusTag ({ commit, state }, cusTags) {
      return new Promise((resolve, reject) => {
        cusTagService.batchSave(cusTags).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateCusTag ({ commit, state }, cusTag) {
      return new Promise((resolve, reject) => {
        cusTagService.update(cusTag).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateCusTag ({ commit, state }, cusTags) {
      return new Promise((resolve, reject) => {
        cusTagService.batchUpdate(cusTags).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeCusTag ({ commit, state }, cusTag) {
      return new Promise((resolve, reject) => {
        cusTagService.remove(cusTag).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveCusTag ({ commit, state }, cusTags) {
      return new Promise((resolve, reject) => {
        cusTagService.batchRemove(cusTags).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusTagByPk ({ commit, state }, cusTag) {
      return new Promise((resolve, reject) => {
        cusTagService.getByPk(cusTag).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusTag ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusTagService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusTag ({ commit, state }, cusTagQuery) {
      return new Promise((resolve, reject) => {
        cusTagService.getAll(cusTagQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusTag ({ commit, state }, { cusTagQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusTagService.paging(cusTagQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getCusTagVOByPk ({ commit, state }, cusTag) {
      return new Promise((resolve, reject) => {
        cusTagService.getVOByPk(cusTag).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllCusTagVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        cusTagService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryCusTagVO ({ commit, state }, cusTagQuery) {
      return new Promise((resolve, reject) => {
        cusTagService.getAllVO(cusTagQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryCusTagVO ({ commit, state }, { cusTagQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        cusTagService.pagingVO(cusTagQuery, rows, page).then(res => {
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

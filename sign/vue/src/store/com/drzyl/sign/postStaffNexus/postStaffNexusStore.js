import postStaffNexusService from '@/api/com/drzyl/sign/postStaffNexus/postStaffNexusService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    savePostStaffNexus ({ commit, state }, postStaffNexus) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.save(postStaffNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSavePostStaffNexus ({ commit, state }, postStaffNexuss) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.batchSave(postStaffNexuss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updatePostStaffNexus ({ commit, state }, postStaffNexus) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.update(postStaffNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdatePostStaffNexus ({ commit, state }, postStaffNexuss) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.batchUpdate(postStaffNexuss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removePostStaffNexus ({ commit, state }, postStaffNexus) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.remove(postStaffNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemovePostStaffNexus ({ commit, state }, postStaffNexuss) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.batchRemove(postStaffNexuss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getPostStaffNexusByPk ({ commit, state }, postStaffNexus) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.getByPk(postStaffNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllPostStaffNexus ({ commit, state }) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryPostStaffNexus ({ commit, state }, postStaffNexusQuery) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.getAll(postStaffNexusQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryPostStaffNexus ({ commit, state }, { postStaffNexusQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.paging(postStaffNexusQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getPostStaffNexusVOByPk ({ commit, state }, postStaffNexus) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.getVOByPk(postStaffNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllPostStaffNexusVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryPostStaffNexusVO ({ commit, state }, postStaffNexusQuery) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.getAllVO(postStaffNexusQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryPostStaffNexusVO ({ commit, state }, { postStaffNexusQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        postStaffNexusService.pagingVO(postStaffNexusQuery, rows, page).then(res => {
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

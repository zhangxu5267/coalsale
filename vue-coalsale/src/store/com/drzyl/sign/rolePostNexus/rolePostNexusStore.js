import rolePostNexusService from '@/api/com/drzyl/sign/rolePostNexus/rolePostNexusService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveRolePostNexus ({ commit, state }, rolePostNexus) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.save(rolePostNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveRolePostNexus ({ commit, state }, rolePostNexuss) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.batchSave(rolePostNexuss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateRolePostNexus ({ commit, state }, rolePostNexus) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.update(rolePostNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateRolePostNexus ({ commit, state }, rolePostNexuss) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.batchUpdate(rolePostNexuss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeRolePostNexus ({ commit, state }, rolePostNexus) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.remove(rolePostNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveRolePostNexus ({ commit, state }, rolePostNexuss) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.batchRemove(rolePostNexuss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getRolePostNexusByPk ({ commit, state }, rolePostNexus) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.getByPk(rolePostNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllRolePostNexus ({ commit, state }) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryRolePostNexus ({ commit, state }, rolePostNexusQuery) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.getAll(rolePostNexusQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryRolePostNexus ({ commit, state }, { rolePostNexusQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.paging(rolePostNexusQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getRolePostNexusVOByPk ({ commit, state }, rolePostNexus) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.getVOByPk(rolePostNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllRolePostNexusVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryRolePostNexusVO ({ commit, state }, rolePostNexusQuery) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.getAllVO(rolePostNexusQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryRolePostNexusVO ({ commit, state }, { rolePostNexusQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        rolePostNexusService.pagingVO(rolePostNexusQuery, rows, page).then(res => {
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

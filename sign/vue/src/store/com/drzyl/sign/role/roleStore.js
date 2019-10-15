import roleService from '@/api/com/drzyl/sign/role/roleService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveRole ({ commit, state }, role) {
      return new Promise((resolve, reject) => {
        roleService.save(role).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveRole ({ commit, state }, roles) {
      return new Promise((resolve, reject) => {
        roleService.batchSave(roles).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateRole ({ commit, state }, role) {
      return new Promise((resolve, reject) => {
        roleService.update(role).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateRole ({ commit, state }, roles) {
      return new Promise((resolve, reject) => {
        roleService.batchUpdate(roles).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeRole ({ commit, state }, role) {
      return new Promise((resolve, reject) => {
        roleService.remove(role).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveRole ({ commit, state }, roles) {
      return new Promise((resolve, reject) => {
        roleService.batchRemove(roles).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getRoleByPk ({ commit, state }, role) {
      return new Promise((resolve, reject) => {
        roleService.getByPk(role).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllRole ({ commit, state }) {
      return new Promise((resolve, reject) => {
        roleService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryRole ({ commit, state }, roleQuery) {
      return new Promise((resolve, reject) => {
        roleService.getAll(roleQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryRole ({ commit, state }, { roleQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        roleService.paging(roleQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getRoleVOByPk ({ commit, state }, role) {
      return new Promise((resolve, reject) => {
        roleService.getVOByPk(role).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllRoleVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        roleService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryRoleVO ({ commit, state }, roleQuery) {
      return new Promise((resolve, reject) => {
        roleService.getAllVO(roleQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryRoleVO ({ commit, state }, { roleQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        roleService.pagingVO(roleQuery, rows, page).then(res => {
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

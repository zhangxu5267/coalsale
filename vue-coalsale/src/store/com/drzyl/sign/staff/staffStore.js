import staffService from '@/api/com/drzyl/sign/staff/staffService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveStaff ({ commit, state }, staff) {
      return new Promise((resolve, reject) => {
        staffService.save(staff).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveStaff ({ commit, state }, staffs) {
      return new Promise((resolve, reject) => {
        staffService.batchSave(staffs).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateStaff ({ commit, state }, staff) {
      return new Promise((resolve, reject) => {
        staffService.update(staff).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateStaff ({ commit, state }, staffs) {
      return new Promise((resolve, reject) => {
        staffService.batchUpdate(staffs).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeStaff ({ commit, state }, staff) {
      return new Promise((resolve, reject) => {
        staffService.remove(staff).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveStaff ({ commit, state }, staffs) {
      return new Promise((resolve, reject) => {
        staffService.batchRemove(staffs).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getStaffByPk ({ commit, state }, staff) {
      return new Promise((resolve, reject) => {
        staffService.getByPk(staff).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllStaff ({ commit, state }) {
      return new Promise((resolve, reject) => {
        staffService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryStaff ({ commit, state }, staffQuery) {
      return new Promise((resolve, reject) => {
        staffService.getAll(staffQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryStaff ({ commit, state }, { staffQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        staffService.paging(staffQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getStaffVOByPk ({ commit, state }, staff) {
      return new Promise((resolve, reject) => {
        staffService.getVOByPk(staff).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllStaffVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        staffService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryStaffVO ({ commit, state }, staffQuery) {
      return new Promise((resolve, reject) => {
        staffService.getAllVO(staffQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryStaffVO ({ commit, state }, { staffQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        staffService.pagingVO(staffQuery, rows, page).then(res => {
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

import tableCssService from '@/api/com/drzyl/table/css/tableCss/tableCssService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveTableCss ({ commit, state }, tableCss) {
      return new Promise((resolve, reject) => {
        tableCssService.save(tableCss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveTableCss ({ commit, state }, tableCsss) {
      return new Promise((resolve, reject) => {
        tableCssService.batchSave(tableCsss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateTableCss ({ commit, state }, tableCss) {
      return new Promise((resolve, reject) => {
        tableCssService.update(tableCss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateTableCss ({ commit, state }, tableCsss) {
      return new Promise((resolve, reject) => {
        tableCssService.batchUpdate(tableCsss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeTableCss ({ commit, state }, tableCss) {
      return new Promise((resolve, reject) => {
        tableCssService.remove(tableCss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveTableCss ({ commit, state }, tableCsss) {
      return new Promise((resolve, reject) => {
        tableCssService.batchRemove(tableCsss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getTableCssByPk ({ commit, state }, tableCss) {
      return new Promise((resolve, reject) => {
        tableCssService.getByPk(tableCss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllTableCss ({ commit, state }) {
      return new Promise((resolve, reject) => {
        tableCssService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryTableCss ({ commit, state }, tableCssQuery) {
      return new Promise((resolve, reject) => {
        tableCssService.getAll(tableCssQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryTableCss ({ commit, state }, { tableCssQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        tableCssService.paging(tableCssQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getTableCssVOByPk ({ commit, state }, tableCss) {
      return new Promise((resolve, reject) => {
        tableCssService.getVOByPk(tableCss).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllTableCssVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        tableCssService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryTableCssVO ({ commit, state }, tableCssQuery) {
      return new Promise((resolve, reject) => {
        tableCssService.getAllVO(tableCssQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryTableCssVO ({ commit, state }, { tableCssQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        tableCssService.pagingVO(tableCssQuery, rows, page).then(res => {
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

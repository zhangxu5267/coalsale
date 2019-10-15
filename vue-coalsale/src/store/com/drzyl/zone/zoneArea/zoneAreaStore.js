import zoneAreaService from '@/api/com/drzyl/zone/zoneArea/zoneAreaService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveZoneArea ({ commit, state }, zoneArea) {
      return new Promise((resolve, reject) => {
        zoneAreaService.save(zoneArea).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveZoneArea ({ commit, state }, zoneAreas) {
      return new Promise((resolve, reject) => {
        zoneAreaService.batchSave(zoneAreas).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateZoneArea ({ commit, state }, zoneArea) {
      return new Promise((resolve, reject) => {
        zoneAreaService.update(zoneArea).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateZoneArea ({ commit, state }, zoneAreas) {
      return new Promise((resolve, reject) => {
        zoneAreaService.batchUpdate(zoneAreas).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeZoneArea ({ commit, state }, zoneArea) {
      return new Promise((resolve, reject) => {
        zoneAreaService.remove(zoneArea).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveZoneArea ({ commit, state }, zoneAreas) {
      return new Promise((resolve, reject) => {
        zoneAreaService.batchRemove(zoneAreas).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getZoneAreaByPk ({ commit, state }, zoneArea) {
      return new Promise((resolve, reject) => {
        zoneAreaService.getByPk(zoneArea).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllZoneArea ({ commit, state }) {
      return new Promise((resolve, reject) => {
        zoneAreaService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryZoneArea ({ commit, state }, zoneAreaQuery) {
      return new Promise((resolve, reject) => {
        zoneAreaService.getAll(zoneAreaQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryZoneArea ({ commit, state }, { zoneAreaQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        zoneAreaService.paging(zoneAreaQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getZoneAreaVOByPk ({ commit, state }, zoneArea) {
      return new Promise((resolve, reject) => {
        zoneAreaService.getVOByPk(zoneArea).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllZoneAreaVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        zoneAreaService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryZoneAreaVO ({ commit, state }, zoneAreaQuery) {
      return new Promise((resolve, reject) => {
        zoneAreaService.getAllVO(zoneAreaQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryZoneAreaVO ({ commit, state }, { zoneAreaQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        zoneAreaService.pagingVO(zoneAreaQuery, rows, page).then(res => {
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

import zoneRegionService from '@/api/com/drzyl/zone/zoneRegion/zoneRegionService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveZoneRegion ({ commit, state }, zoneRegion) {
      return new Promise((resolve, reject) => {
        zoneRegionService.save(zoneRegion).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveZoneRegion ({ commit, state }, zoneRegions) {
      return new Promise((resolve, reject) => {
        zoneRegionService.batchSave(zoneRegions).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateZoneRegion ({ commit, state }, zoneRegion) {
      return new Promise((resolve, reject) => {
        zoneRegionService.update(zoneRegion).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateZoneRegion ({ commit, state }, zoneRegions) {
      return new Promise((resolve, reject) => {
        zoneRegionService.batchUpdate(zoneRegions).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeZoneRegion ({ commit, state }, zoneRegion) {
      return new Promise((resolve, reject) => {
        zoneRegionService.remove(zoneRegion).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveZoneRegion ({ commit, state }, zoneRegions) {
      return new Promise((resolve, reject) => {
        zoneRegionService.batchRemove(zoneRegions).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getZoneRegionByPk ({ commit, state }, zoneRegion) {
      return new Promise((resolve, reject) => {
        zoneRegionService.getByPk(zoneRegion).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllZoneRegion ({ commit, state }) {
      return new Promise((resolve, reject) => {
        zoneRegionService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryZoneRegion ({ commit, state }, zoneRegionQuery) {
      return new Promise((resolve, reject) => {
        zoneRegionService.getAll(zoneRegionQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryZoneRegion ({ commit, state }, { zoneRegionQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        zoneRegionService.paging(zoneRegionQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getZoneRegionVOByPk ({ commit, state }, zoneRegion) {
      return new Promise((resolve, reject) => {
        zoneRegionService.getVOByPk(zoneRegion).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllZoneRegionVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        zoneRegionService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryZoneRegionVO ({ commit, state }, zoneRegionQuery) {
      return new Promise((resolve, reject) => {
        zoneRegionService.getAllVO(zoneRegionQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryZoneRegionVO ({ commit, state }, { zoneRegionQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        zoneRegionService.pagingVO(zoneRegionQuery, rows, page).then(res => {
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

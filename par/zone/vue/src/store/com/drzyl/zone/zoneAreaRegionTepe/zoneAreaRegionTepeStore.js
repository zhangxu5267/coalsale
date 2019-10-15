import zoneAreaRegionTepeService from '@/api/com/drzyl/zone/zoneAreaRegionTepe/zoneAreaRegionTepeService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveZoneAreaRegionTepe ({ commit, state }, zoneAreaRegionTepe) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.save(zoneAreaRegionTepe).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveZoneAreaRegionTepe ({ commit, state }, zoneAreaRegionTepes) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.batchSave(zoneAreaRegionTepes).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateZoneAreaRegionTepe ({ commit, state }, zoneAreaRegionTepe) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.update(zoneAreaRegionTepe).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateZoneAreaRegionTepe ({ commit, state }, zoneAreaRegionTepes) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.batchUpdate(zoneAreaRegionTepes).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeZoneAreaRegionTepe ({ commit, state }, zoneAreaRegionTepe) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.remove(zoneAreaRegionTepe).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveZoneAreaRegionTepe ({ commit, state }, zoneAreaRegionTepes) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.batchRemove(zoneAreaRegionTepes).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getZoneAreaRegionTepeByPk ({ commit, state }, zoneAreaRegionTepe) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.getByPk(zoneAreaRegionTepe).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllZoneAreaRegionTepe ({ commit, state }) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryZoneAreaRegionTepe ({ commit, state }, zoneAreaRegionTepeQuery) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.getAll(zoneAreaRegionTepeQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryZoneAreaRegionTepe ({ commit, state }, { zoneAreaRegionTepeQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.paging(zoneAreaRegionTepeQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getZoneAreaRegionTepeVOByPk ({ commit, state }, zoneAreaRegionTepe) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.getVOByPk(zoneAreaRegionTepe).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllZoneAreaRegionTepeVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryZoneAreaRegionTepeVO ({ commit, state }, zoneAreaRegionTepeQuery) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.getAllVO(zoneAreaRegionTepeQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryZoneAreaRegionTepeVO ({ commit, state }, { zoneAreaRegionTepeQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        zoneAreaRegionTepeService.pagingVO(zoneAreaRegionTepeQuery, rows, page).then(res => {
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

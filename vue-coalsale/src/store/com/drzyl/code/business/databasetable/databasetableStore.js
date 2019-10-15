import databasetableService from '@/api/com/drzyl/code/business/databasetable/databasetableService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    getAllTable ({ commit, state }) {
      return new Promise((resolve, reject) => {
        databasetableService.getAllTable().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getDataBaseType ({ commit, state }) {
      return new Promise((resolve, reject) => {
        databasetableService.getDataBaseType().then(res => {
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

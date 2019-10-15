import uploadFileService from '@/api/com/drzyl/upload/file/uploadFile/uploadFileService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveUploadFile ({ commit, state }, uploadFile) {
      return new Promise((resolve, reject) => {
        uploadFileService.save(uploadFile).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveUploadFile ({ commit, state }, uploadFiles) {
      return new Promise((resolve, reject) => {
        uploadFileService.batchSave(uploadFiles).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateUploadFile ({ commit, state }, uploadFile) {
      return new Promise((resolve, reject) => {
        uploadFileService.update(uploadFile).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateUploadFile ({ commit, state }, uploadFiles) {
      return new Promise((resolve, reject) => {
        uploadFileService.batchUpdate(uploadFiles).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeUploadFile ({ commit, state }, uploadFile) {
      return new Promise((resolve, reject) => {
        uploadFileService.remove(uploadFile).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveUploadFile ({ commit, state }, uploadFiles) {
      return new Promise((resolve, reject) => {
        uploadFileService.batchRemove(uploadFiles).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUploadFileByPk ({ commit, state }, uploadFile) {
      return new Promise((resolve, reject) => {
        uploadFileService.getByPk(uploadFile).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUploadFile ({ commit, state }) {
      return new Promise((resolve, reject) => {
        uploadFileService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUploadFile ({ commit, state }, uploadFileQuery) {
      return new Promise((resolve, reject) => {
        uploadFileService.getAll(uploadFileQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUploadFile ({ commit, state }, { uploadFileQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        uploadFileService.paging(uploadFileQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUploadFileVOByPk ({ commit, state }, uploadFile) {
      return new Promise((resolve, reject) => {
        uploadFileService.getVOByPk(uploadFile).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUploadFileVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        uploadFileService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUploadFileVO ({ commit, state }, uploadFileQuery) {
      return new Promise((resolve, reject) => {
        uploadFileService.getAllVO(uploadFileQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUploadFileVO ({ commit, state }, { uploadFileQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        uploadFileService.pagingVO(uploadFileQuery, rows, page).then(res => {
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

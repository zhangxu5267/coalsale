import postService from '@/api/com/drzyl/sign/post/postService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    savePost ({ commit, state }, post) {
      return new Promise((resolve, reject) => {
        postService.save(post).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSavePost ({ commit, state }, posts) {
      return new Promise((resolve, reject) => {
        postService.batchSave(posts).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updatePost ({ commit, state }, post) {
      return new Promise((resolve, reject) => {
        postService.update(post).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdatePost ({ commit, state }, posts) {
      return new Promise((resolve, reject) => {
        postService.batchUpdate(posts).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removePost ({ commit, state }, post) {
      return new Promise((resolve, reject) => {
        postService.remove(post).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemovePost ({ commit, state }, posts) {
      return new Promise((resolve, reject) => {
        postService.batchRemove(posts).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getPostByPk ({ commit, state }, post) {
      return new Promise((resolve, reject) => {
        postService.getByPk(post).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllPost ({ commit, state }) {
      return new Promise((resolve, reject) => {
        postService.getAll({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryPost ({ commit, state }, postQuery) {
      return new Promise((resolve, reject) => {
        postService.getAll(postQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryPost ({ commit, state }, { postQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        postService.paging(postQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getPostVOByPk ({ commit, state }, post) {
      return new Promise((resolve, reject) => {
        postService.getVOByPk(post).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllPostVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        postService.getAllVO({}).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryPostVO ({ commit, state }, postQuery) {
      return new Promise((resolve, reject) => {
        postService.getAllVO(postQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryPostVO ({ commit, state }, { postQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        postService.pagingVO(postQuery, rows, page).then(res => {
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

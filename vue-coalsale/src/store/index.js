import Vue from 'vue';
import Vuex from 'vuex';

import admin from './modules/admin'

// import dtStore from './com/drzyl/code/dt/dtStore'
// import columnsStore from './com/drzyl/code/columns/columnsStore'
// import pkStore from './com/drzyl/code/pk/pkStore'
// import queryStore from './com/drzyl/code/query/queryStore'
// import sortStore from './com/drzyl/code/sort/sortStore'
// import virtualColumnsStore from './com/drzyl/code/virtualColumns/virtualColumnsStore'
// import codingStore from './com/drzyl/code/business/coding/codingStore'
// import databasetableStore from './com/drzyl/code/business/databasetable/databasetableStore'

const files = require.context('./com/drzyl', true, /\.js$/);

const modules = { admin };

files.keys().forEach(key => {
  modules[key.replace(/(.*\/)*([^.]+).*/ig, '$2')] = files(key).default
});

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules
})

// store.registerModule('dtStore', dtStore)
// store.registerModule('columnsStore', columnsStore)
// store.registerModule('pkStore', pkStore)
// store.registerModule('queryStore', queryStore)
// store.registerModule('sortStore', sortStore)
// store.registerModule('virtualColumnsStore', virtualColumnsStore)
// store.registerModule('codingStore', codingStore)
// store.registerModule('databasetableStore', databasetableStore)

export default store

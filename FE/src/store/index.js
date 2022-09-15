import { createStore } from 'vuex'

import createdPersistedState from "vuex-persistedstate";

import chatStore from '@/store/modules/chatStore.js';
import navStore from '@/store/modules/navStore.js';
import menuStore from '@/store/modules/menuStore.js';
import memberStore from '@/store/modules/memberStore.js';
import mapStore from '@/store/modules/mapStore.js';

export default createStore({
  modules: {
    chatStore,
    navStore,
    menuStore,
    memberStore,
    mapStore,
  },
  plugins: [
    createdPersistedState({
      storage: sessionStorage,
    }),
  ],
})

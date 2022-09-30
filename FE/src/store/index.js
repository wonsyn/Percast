import { createStore } from "vuex";

import createdPersistedState from "vuex-persistedstate";

import aboutStore from "@/store/modules/aboutStore.js";
import chatStore from "@/store/modules/chatStore.js";
import navStore from "@/store/modules/navStore.js";
import menuStore from "@/store/modules/menuStore.js";
import memberStore from "@/store/modules/memberStore.js";
import mapStore from "@/store/modules/mapStore.js";
import noticeStore from "@/store/modules/noticeStore.js";
import qnaStore from "@/store/modules/qnaStore.js";
import twitStore from "@/store/modules/twitStore.js";
import adminStore from "@/store/modules/adminStore.js";

export default createStore({
  modules: {
    aboutStore,
    chatStore,
    navStore,
    menuStore,
    memberStore,
    mapStore,
    noticeStore,
    qnaStore,
    twitStore,
    adminStore,
  },
  plugins: [
    createdPersistedState({
      storage: sessionStorage,
    }),
  ],
});

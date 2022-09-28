import { get_notices } from "@/api/notice";

const noticeStore = {
  namespaced: true,
  state: { notices: [] },
  getters: {},
  mutations: {
    GET_NOTICES(state, payload) {
      state.notices = payload;
    },
  },
  actions: {
    async getNotices({ commit }) {
      await get_notices(
        (res) => {
          commit("GET_NOTICES", res.data.p.content);
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};

export default noticeStore;

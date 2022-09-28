import { get_notices, regist_notice } from "@/api/notice";

const noticeStore = {
  namespaced: true,
  state: { notices: [], notice: {} },
  getters: {},
  mutations: {
    GET_NOTICES(state, payload) {
      state.notices = payload;
    },
    WRITE_NOTICE(state, payload) {
      state.notices.push(payload);
    },
  },
  actions: {
    getNotices({ commit }) {
      get_notices(
        (res) => {
          commit("GET_NOTICES", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    registNotice({ commit }, newNotice) {
      regist_notice(
        newNotice,
        (res) => {
          commit("WRITE_NOTICE", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};

export default noticeStore;

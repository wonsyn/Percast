import {
  get_notices,
  get_notice,
  regist_notice,
  update_notice,
  delete_notice,
} from "@/api/notice";

const noticeStore = {
  namespaced: true,
  state: {
    notices: [],
    notice: {},
  },
  getters: {},
  mutations: {
    GET_NOTICE(state, payload) {
      state.notice = payload;
    },
    GET_NOTICES(state, payload) {
      state.notices = payload;
    },
    WRITE_NOTICE(state, payload) {
      state.notices.push(payload);
    },
  },
  actions: {
    async getNotices({ commit }) {
      await get_notices(
        (res) => {
          commit("GET_NOTICES", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async getNotice({ commit }, payload) {
      await get_notice(
        payload,
        (res) => {
          commit("GET_NOTICE", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async registNotice({ commit }, newNotice) {
      await regist_notice(
        newNotice,
        (res) => {
          commit("WRITE_NOTICE", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async deleteNotice({ commit }, id) {
      commit;
      await delete_notice(
        id,
        (res) => {
          console.log(res);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async updateNotice({ commit }, body) {
      commit;
      await update_notice(
        body,
        () => {
          console.log("store log");
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};

export default noticeStore;

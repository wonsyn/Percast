import {
  get_qnas,
  get_qna,
  regist_qna,
  update_qna,
  delete_qna,
} from "@/api/qna";

const qnaStore = {
  namespaced: true,
  state: {
    qnas: [],
    qna: {},
  },
  getters: {},
  mutations: {
    GET_QNA(state, payload) {
      state.qna = payload;
    },
    GET_QNAS(state, payload) {
      state.qnas = payload;
    },
    WRITE_QNA(state, payload) {
      state.qnas.push(payload);
    },
  },
  actions: {
    async getQnas({ commit }) {
      await get_qnas(
        (res) => {
          commit("GET_QNAS", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async getQna({ commit }, payload) {
      await get_qna(
        payload,
        (res) => {
          commit("GET_QNA", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async registQna({ commit }, newQna) {
      await regist_qna(
        newQna,
        (res) => {
          commit("WRITE_QNA", res.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async deleteQna({ commit }, id) {
      commit;
      await delete_qna(
        id,
        (res) => {
          console.log(res);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async updateQna({ commit }, body) {
      commit;
      await update_qna(
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

export default qnaStore;

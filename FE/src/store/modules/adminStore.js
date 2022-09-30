const adminStore = {
  namespaced: true,
  state: {
    admin: "",
  },
  getters: {},
  mutations: {
    SET_ADMIN(state, code) {
      state.admin = code;
    },
  },
};

export default adminStore;

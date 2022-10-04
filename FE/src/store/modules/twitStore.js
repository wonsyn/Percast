import { get_twit } from "@/api/menu";

const twitStore = {
  namespaced: true,
  state: {
    twit: null,
  },
  mutations: {
    SET_TWIT: (state, twit) => {
      state.twit = twit;
    },
  },
  actions: {
    async set_twit({ commit }, d_type) {
      console.log("set_twit " + d_type);
      await get_twit(
        d_type,
        (response) => {
          console.log(response);
          if (response.status === 200) {
            console.log("data : ");
            console.log(response.data);
            commit("SET_TWIT", response.data);
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};

export default twitStore;

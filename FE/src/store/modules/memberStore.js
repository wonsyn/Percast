const memberStore = {
  namespaced: true,
  state: () => ({
    isLogin: false, // 로그인 정보 표시
    isLoginError: false, // 로그인 에러 표시
    userInfo: null, // 유저 정보
  }),
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.userInfo = userInfo;
    },
  },
  actions: {},
};

export default memberStore;

const menuStore = {
  namespaced: true,
  state: {
    depth: 0,
    sido: [
      {
        name: "서울",
      },
      {
        name: "대전",
      },
      {
        name: "대구",
      },
      {
        name: "광주",
      },
      {
        name: "부산",
      },
    ],
    gugun: [
      {
        name: "서구",
      },
      {
        name: "동구",
      },
      {
        name: "대덕구",
      },
      {
        name: "유성구",
      },
      {
        name: "중구",
      },
    ],
    weather: [
      {
        // 기온
        value: 36.5,
      },
      {
        // 습도
        value: 53,
      },
      {
        // 강수량
        value: 13,
      },
    ],
    environment: [
      {
        // 미세먼지
        value: 33,
      },
      {
        // 초미세먼지
        value: 25,
      },
      {
        // 오존
        value: 23,
      },
    ],
    region: "서울",
    score: 86,
    danger: "안전",
    grade: 2,

    map_data: [
      {
        name: "서울",
        classname: "seoul",
        index: 1,
        x: 156,
        y: 214,
      },
      {
        name: "부산",
        classname: "busan",
        index: 2,
        x: 503,
        y: 695,
      },
      {
        name: "대구",
        classname: "daegoo",
        index: 3,
        x: 418,
        y: 567,
      },
      {
        name: "인천",
        classname: "incheon",
        index: 4,
        x: 67,
        y: 177,
      },
      {
        name: "광주",
        classname: "gwangjoo",
        index: 5,
        x: 127,
        y: 707,
      },
      {
        name: "대전",
        classname: "daejeon",
        index: 6,
        x: 221,
        y: 463,
      },
      {
        name: "울산",
        classname: "ulsan",
        index: 7,
        x: 531,
        y: 622,
      },
      {
        name: "세종",
        classname: "sejong",
        index: 8,
        x: 199,
        y: 418,
      },
      {
        name: "경기도",
        classname: "gyunggi",
        index: 9,
        x: 216,
        y: 245,
      },
      {
        name: "강원도",
        classname: "gangwon",
        index: 10,
        x: 370,
        y: 179,
      },
      {
        name: "충북",
        classname: "chungbook",
        index: 11,
        x: 294,
        y: 381,
      },
      {
        name: "충남",
        classname: "chungnam",
        index: 12,
        x: 105,
        y: 449,
      },
      {
        name: "전북",
        classname: "jeonbook",
        index: 13,
        x: 179,
        y: 592,
      },
      {
        name: "전남",
        classname: "jeonnam",
        index: 14,
        x: 138,
        y: 764,
      },
      {
        name: "경북",
        classname: "gyungbook",
        index: 15,
        x: 447,
        y: 460,
      },
      {
        name: "경남",
        classname: "gyungnam",
        index: 16,
        x: 367,
        y: 672,
      },
      {
        name: "제주",
        classname: "jeju",
        index: 17,
        x: 76,
        y: 1070,
      },
    ],
    scores: [87, 33, 25],
  },
  getters: {},
  mutations: {
    SET_DEPTH: (state, depth) => {
      state.depth = depth;
    },
    SET_SIDO: (state, sido) => {
      state.sido = sido;
    },
    SET_GUGUN: (state, gugun) => {
      state.gugun = gugun;
    },
    SET_WEATHER: (state, weather) => {
      state.weather = weather;
    },
    SET_ENVIRONMENT: (state, environment) => {
      state.environment = environment;
    },
  },
  actions: {
    set_depth({ commit }, depth) {
      commit("SET_DEPTH", depth);
    },
    set_sido({ commit }, sido) {
      commit("SET_SIDO", sido);
    },
    set_gugun({ commit }, gugun) {
      commit("SET_GUGUN", gugun);
    },
    set_weather({ commit }, weather) {
      commit("SET_WEATHER", weather);
    },
    set_environment({ commit }, environment) {
      commit("SET_ENVIRONMENT", environment);
    },
  },
};

export default menuStore;

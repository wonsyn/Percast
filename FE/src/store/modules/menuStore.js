import { get_env, get_data } from "@/api/menu";

const menuStore = {
  namespaced: true,
  state: {
    depth: 0,
    weather: {
      // 기온
      temp: 0,
      // 습도
      humid: 1,
      // 강수량
      rain: 2,
    },
    environment: {
      // 일산화탄소
      co: 0,
      // 미세먼지
      pm10: 1,
      // 오존
      o3: 2,
    },

    // 현재 선택한 지역 정보를 표시
    r_num: 0,
    region: "서울",
    score: 0,
    // 현재 등급을 표시
    grade: 2, // 단계
    danger: "안전", // 문자
    // 선택한 질병명을 표시
    disease: "감기",
    d_type: 0,
    // 지역별 svg좌표 및 클래스명, 지역명 등을 표시
    map_data: [
      {
        name: "서울",
        classname: "seoul",
        index: 0,
        x: 156,
        y: 214,
      },
      {
        name: "부산",
        classname: "busan",
        index: 1,
        x: 503,
        y: 695,
      },
      {
        name: "대구",
        classname: "daegoo",
        index: 2,
        x: 418,
        y: 567,
      },
      {
        name: "인천",
        classname: "incheon",
        index: 3,
        x: 67,
        y: 177,
      },
      {
        name: "광주",
        classname: "gwangjoo",
        index: 4,
        x: 127,
        y: 707,
      },
      {
        name: "대전",
        classname: "daejeon",
        index: 5,
        x: 221,
        y: 463,
      },
      {
        name: "울산",
        classname: "ulsan",
        index: 6,
        x: 531,
        y: 622,
      },
      {
        name: "경기도",
        classname: "gyunggi",
        index: 7,
        x: 216,
        y: 245,
      },
      {
        name: "강원도",
        classname: "gangwon",
        index: 8,
        x: 370,
        y: 179,
      },
      {
        name: "충북",
        classname: "chungbook",
        index: 9,
        x: 294,
        y: 381,
      },
      {
        name: "충남",
        classname: "chungnam",
        index: 10,
        x: 105,
        y: 449,
      },
      {
        name: "전북",
        classname: "jeonbook",
        index: 11,
        x: 179,
        y: 592,
      },
      {
        name: "전남",
        classname: "jeonnam",
        index: 12,
        x: 138,
        y: 764,
      },
      {
        name: "경북",
        classname: "gyungbook",
        index: 13,
        x: 447,
        y: 460,
      },
      {
        name: "경남",
        classname: "gyungnam",
        index: 14,
        x: 367,
        y: 672,
      },
      {
        name: "제주",
        classname: "jeju",
        index: 15,
        x: 76,
        y: 1020,
      },
      {
        name: "세종",
        classname: "sejong",
        index: 16,
        x: 199,
        y: 418,
      },
    ],
    // 값을 저장한다.
    city_score: [
      { cold: 99, asthma: 87, skin: 65, eye: 70, foodPoison: 44 },
      { cold: 87, asthma: 33, skin: 44, eye: 99, foodPoison: 70 },
      { cold: 33, asthma: 25, skin: 70, eye: 87, foodPoison: 99 },
      { cold: 25, asthma: 32, skin: 99, eye: 33, foodPoison: 87 },
      { cold: 32, asthma: 63, skin: 87, eye: 25, foodPoison: 33 },
      { cold: 63, asthma: 55, skin: 33, eye: 32, foodPoison: 25 },
      { cold: 55, asthma: 12, skin: 25, eye: 63, foodPoison: 32 },
      { cold: 12, asthma: 36, skin: 32, eye: 55, foodPoison: 63 },
      { cold: 36, asthma: 88, skin: 63, eye: 12, foodPoison: 55 },
      { cold: 88, asthma: 94, skin: 55, eye: 36, foodPoison: 12 },
      { cold: 94, asthma: 15, skin: 12, eye: 88, foodPoison: 36 },
      { cold: 15, asthma: 88, skin: 36, eye: 94, foodPoison: 88 },
      { cold: 88, asthma: 87, skin: 88, eye: 15, foodPoison: 94 },
      { cold: 87, asthma: 65, skin: 94, eye: 88, foodPoison: 15 },
      { cold: 65, asthma: 44, skin: 15, eye: 87, foodPoison: 88 },
      { cold: 44, asthma: 70, skin: 88, eye: 65, foodPoison: 87 },
      { cold: 70, asthma: 99, skin: 87, eye: 44, foodPoison: 65 },
    ],
    // 실제로 표시하는 곳
    scores: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    // 증상을 담는다.
    symptom: [
      [
        {
          name: "감기에 대한 초기증상",
          text: [],
          list: ["첫번째 줄", "두번째 줄", "세번째 줄"],
        },
        {
          name: "예방 방법",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "천식에 대한 초기증상",
          text: [],
          list: ["첫번째 줄", "두번째 줄", "세번째 줄"],
        },
      ],
      [
        {
          name: "피부병에 대한 초기증상",
          text: [],
          list: ["첫번째 줄", "두번째 줄", "세번째 줄"],
        },
      ],
      [
        {
          name: "눈병에 대한 초기증상",
          text: [],
          list: ["첫번째 줄", "두번째 줄", "세번째 줄"],
        },
      ],
      [
        {
          name: "식중독에 대한 초기증상",
          text: [],
          list: ["첫번째 줄", "두번째 줄", "세번째 줄"],
        },
      ],
    ],

    // 예방방법을 담는다.
    prevent: [
      [
        {
          name: "예방 방법1",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
        {
          name: "예방 방법2",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "예방 방법3",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "예방 방법4",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "예방 방법5",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "예방 방법6",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
    ],

    // 음식을 담는다 (폐기 예정)
    foods: [
      [
        {
          name: "음식 하나",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
        {
          name: "음식 둘",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "음식 셋",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "음식 넷",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "음식 다섯",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
      [
        {
          name: "예방 방법6",
          text: ["선택한 질병에 대한", "데이터가 없습니다."],
          list: [],
        },
      ],
    ],
  },
  getters: {},
  mutations: {
    SET_CITY_SCORE: (state, city_score) => {
      state.city_score = city_score;
    },
    SET_DANGER: (state, danger) => {
      state.danger = danger;
    },
    SET_DEPTH: (state, depth) => {
      state.depth = depth;
    },
    SET_DISEASE: (state, disease) => {
      state.disease = disease;
    },
    SET_D_TYPE: (state, d_type) => {
      state.d_type = d_type;
    },
    SET_REGION: (state, region) => {
      state.region = region;
    },
    SET_SCORE: (state, score) => {
      state.score = score;
    },
    SET_SCORES: (state, scores) => {
      state.scores = scores;
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
    SET_R_NUM: (state, r_num) => {
      state.r_num = r_num;
    },
  },
  actions: {
    set_danger({ commit }, danger) {
      commit("SET_DANGER", danger);
    },
    set_depth({ commit }, depth) {
      commit("SET_DEPTH", depth);
    },
    set_disease({ commit }, disease) {
      commit("SET_DISEASE", disease);
    },
    set_d_type({ commit }, d_type) {
      commit("SET_D_TYPE", d_type);
    },
    set_region({ commit }, region) {
      commit("SET_REGION", region);
    },
    set_r_num({ commit }, r_num) {
      commit("SET_R_NUM", r_num);
    },
    set_score({ commit }, score) {
      commit("SET_SCORE", score);
    },
    set_scores({ commit }, scores) {
      commit("SET_SCORES", scores);
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
    //일단 나중에 다시 수정
    async get_options_by_region({ commit }, sidoCode) {
      await get_env(
        sidoCode,
        (response) => {
          if (response.status === 200) {
            const weather = {};
            const environment = {};
            weather.rain = response.data.rain;
            weather.temp = response.data.temp;
            weather.humid = response.data.humid;

            environment.co = response.data.co;
            environment.pm10 = response.data.pm10;
            environment.o3 = response.data.o3;

            commit("SET_WEATHER", weather);
            commit("SET_ENVIRONMENT", environment);
          } else {
            console.log("connect fail");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async get_scores({ commit }) {
      await get_data(
        (response) => {
          if (response.status === 200) {
            commit("SET_CITY_SCORE", response.data);
          } else {
            console.log("connect fail");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};

export default menuStore;

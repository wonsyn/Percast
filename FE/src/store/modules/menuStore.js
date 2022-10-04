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
    disease_name: "감기",
    disease: "cold",
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
    min_score: [-1, -1, -1, -1, -1],
    max_score: [-1, -1, -1, -1, -1],
    // 증상을 담는다.
    symptom: [
      // 감기
      {
        text: [
          "재채기, 코막힘, 콧물, 인후통, 기침, 미열",
          "두통 및 근육통 등",
          // "재채기, 코막힘, 콧물, 인후통, 기침, 미열, 두통 및 근육통등의 증상이 있다.",
          // "콧물, 코막힘, 목 부위의 통증, 기침과 근육통이 흔하게 나타나는 증상이다.",
          // "소아에게서는 발열 증상이 흔하게 나타난다.",
          // "환자의 연령, 기존에 앓고 있었던 질환, 면역상태 등에 따라 증상의 정도가 달라질 수 있다.",
        ],
        copyright: [
          "서울대학교병원 의학정보 http://www.snuh.org/",
          "저자/제공처 서울대학교병원 서울대학교병원로고 https://tv.naver.com/snuh",
          "[네이버 지식백과] 감기 [common cold] (서울대학교병원 의학정보, 서울대학교병원)",
        ],
      },
      //천식
      {
        text: [
          "천병, 호흡곤란, 가슴답답함, 기침 등",
          // "대표적인 천식 증상은 천명, 호흡곤란, 가슴 답답함, 기침 등이다.",
          // "계절이나 알레르기 원인 물질에 노출된 이후 일시적으로 증상이 발생하기도 한다.",
          // "여러 가지 원인에 의해서 갑작스러운 증상 악화가 발생한다. 이것을 ‘천식 발작’ 또는 '천식의 급성 악화'라고 한다.",
          // "마른 기침만 반복적으로 나타나거나, 가슴이 답답하거나 흉부 압박감을 호소하는 등의 비전형적인 증상을 호소하기도 한다.",
        ],
        copyright: [
          "[네이버 지식백과] 천식 [asthma] (서울대학교병원 의학정보, 서울대학교병원)",
        ],
      },
      //피부병
      {
        text: [
          "피부발진, 발열, 근육통, 부종, 가려움 등",
          // "피부가 붉어지며 피부각질이 두꺼운 형태로 떨어진다.",
          // "박탈성의 경우 오한,발열,근육통, 부종, 가려움 등이 동반된다.",
        ],
        copyright: [
          "강북삼성병원 블로그, https://m.post.naver.com/viewer/postView.naver?volumeNo=33070304&memberNo=7131400&searchKeyword=%ED%94%BC%EB%B6%80%EB%B3%91",
        ],
      },
      // 눈병
      {
        text: [
          "통증, 이물감, 충혈, 결막부종, 결막하출혈",
          "여포, 눈꺼풀 종창 등",
          // "본인이 느낄 수 있는 자각 증상으로 통증, 이물감(눈에 무엇인가 들어있는 느낌), 눈물흘림이 있고,",
          // "겉으로 드러나는 증상으로는 충혈, 결막부종, 결막하출혈, 여포, 눈꺼풀 종창 등이 나타날 수 있다.",
        ],
        copyright: [
          "[네이버 지식백과] 아폴로눈병[acute hemorrhagic conjunctivitis](서울대학교병원 의학정보, 서울대학교병원)",
        ],
      },
      // 식중독
      {
        text: [
          "설사, 복통, 구토, 탈수증상 등",
          // "식중독은 음식을 먹은 후에 설사나 복통, 구토 등의 증상이 생기는 질환으로 전체 80%이상이 세균성 식중독이다.",
          // "발병 2~3일 후에 저절로 낫지만 설사나 구토를 계속해 탈수증세를 보이거나 대변에 피가 섞여 나오면 서둘러 병원에 가서 적절한 치료를 받아야 한다.",
        ],
        copyright: [
          "[네이버 지식백과] 식품안전 119 (가톨릭중앙의료원 건강칼럼, 대전성모병원)",
        ],
      },
    ],
    // 예방방법을 담는다.
    prevent: [
      {
        text: [
          "신선한 식품을 섭취하고 수분을 섭취하며 충분한 휴식을 하도록 한다.",
          "또한 단체생활을 하는 경우 감염환자에게 쉽게 전파될 수 있으므로 피하도록 한다.",
          "건조한 계절에는 가습기를 틀거나 젖은 빨래를 걸어두어 적절한 습도를 유지하도록 한다.",
          "또한 음주와 흡연은 지양한다.",
        ],
        copyright: [
          "[네이버 지식백과] 감기 [common cold]",
          "서울대학교병원 의학정보, 서울대학교병원",
        ],
      },
      {
        text: [
          "천식을 성공적으로 관리하고 천식의 악화를 예방하려면",
          "- 천식이 어떤 병인지 이해하고 있어야 한다.",
          "- 환경 관리를 통해 원인 물질과 악화 인자를 피해야 한다.",
          "- 의사로부터 처방 받은 약물을 규칙적으로 정확하게 사용해야 한다.",
          "- 치료 약제의 기구 사용법을 충분히 알고 사용해야 한다.",
          "- 증상이 조절되더라도 재발과 합병증을 막기 위해 꾸준히 치료를 해야 한다.",
        ],
        copyright: [
          " [네이버 지식백과] 천식 [asthma] (서울대학교병원 의학정보, 서울대학교병원)",
        ],
      },
      {
        text: [
          "- 실내 난방 및 낮은 습도를 조절한다.",
          "- 육체 과로 및 스트레스를 줄인다.",
          "- 적절한 햇빛쬐기와 운동을 지속한다.",
          "- 꽉 끼는 옷은 피부에 마찰하여 증상이 심해지므로 피한다.",
          "- 면역력이 약해지면 증상이 심해지므로 감염질환에 걸리지 않도록 조심한다.",
        ],
        copyright: [
          "강북삼성병원 블로그, https://m.post.naver.com/viewer/postView.naver?volumeNo=33070304&memberNo=7131400&searchKeyword=%ED%94%BC%EB%B6%80%EB%B3%91",
        ],
      },
      {
        text: [
          "- 평소 더러운 손으로 눈을 만지지 않는다.",
          "- 눈을 만진 후에 손을 깨끗이 씻는다.",
          "- 렌즈를 낀 채로 수영하지 않는다.",
          "- 눈병이 유행할 때는 수영장 등 사람 많은 곳에는 가지 않는다.",
          "- 일부러 전염을 유도하지 않는다.",
        ],
        copyright: [
          "[네이버 지식백과] 아폴로눈병[acute hemorrhagic conjunctivitis](서울대학교병원 의학정보, 서울대학교병원)",
        ],
      },
      {
        text: [
          "- 조리된 음식이나 반가공식품의 구입 시 주의한다.",
          "- 냉장고 안에서도 균이 번식할 수 있으므로 냉장고 관리를 철저히 한다.",
          "- 손 청결 뿐만 아니라 칼이나 도마등의 조리도구도 청결히 한다.",
        ],
        copyright: [
          "[네이버 지식백과] 식품안전 119 (가톨릭중앙의료원 건강칼럼, 대전성모병원)",
        ],
      },
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
    SET_DISEASE_NAME: (state, disease_name) => {
      state.disease_name = disease_name;
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
    SET_MAX_SCORE: (state, max_score) => {
      state.max_score = max_score;
    },
    SET_MIN_SCORE: (state, min_score) => {
      state.min_score = min_score;
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
    set_disease_name({ commit }, disease_name) {
      commit("SET_DISEASE_NAME", disease_name);
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
    set_max_score({ commit }, max_score) {
      commit("SET_MAX_SCORE", max_score);
    },
    set_min_score({ commit }, min_score) {
      commit("SET_MIN_SCORE", min_score);
    },
    //일단 나중에 다시 수정
    async get_options_by_region({ commit }, sidoCode) {
      await get_env(
        sidoCode,
        (response) => {
          if (response.status === 200) {
            console.log(response.data);
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
            const max = [-1, -1, -1, -1, -1];
            const min = [101, 101, 101, 101, 101];
            commit("SET_CITY_SCORE", response.data);
            for (let i = 0; i < response.data.length; i++) {
              //min
              if (response.data[i].cold < min[0]) {
                min[0] = response.data[i].cold;
              }
              if (response.data[i].asthma < min[1]) {
                min[1] = response.data[i].asthma;
              }
              if (response.data[i].skin < min[2]) {
                min[2] = response.data[i].skin;
              }
              if (response.data[i].eye < min[3]) {
                min[3] = response.data[i].eye;
              }
              if (response.data[i].foodPoison < min[4]) {
                min[4] = response.data[i].foodPoison;
              }
              // max
              if (response.data[i].cold > max[0]) {
                max[0] = response.data[i].cold;
              }
              if (response.data[i].asthma > max[1]) {
                max[1] = response.data[i].asthma;
              }
              if (response.data[i].skin > max[2]) {
                max[2] = response.data[i].skin;
              }
              if (response.data[i].eye > max[3]) {
                max[3] = response.data[i].eye;
              }
              if (response.data[i].foodPoison > max[4]) {
                max[4] = response.data[i].foodPoison;
              }
            }
            commit("SET_MAX_SCORE", max);
            commit("SET_MIN_SCORE", min);
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

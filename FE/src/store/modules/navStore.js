const navStore = {
  namespaced: true,
  state: {
    selected_num: 0,
    menuArray: [
      // 메뉴 옵션을 정의
      {
        title: "감기 걸리기 딱 좋은 날씨네",
        comments1: "질병 위험도",
        comments2: "의료 시설 정보",
        comments3: "계절별 질병 정보 서비스로 당신의 질병을 예방합니다.",
        menu: "Home",
        name: "/",
        imageUrl: "welcome1.png",
      },
      {
        title: "질병 위험도 서비스",
        comments1: "빅데이터를 활용하여",
        comments2: "현재 날씨, 대기 상태를 바탕으로",
        comments3: "지역별 질병 위험도를 알려줍니다.",
        menu: "계절 질병 정보",
        name: "/about",
        imageUrl: "welcome2.png",
      },
      {
        title: "병원/약국 위치 정보",
        comments1: "아플 때,",
        comments2: "주변 병원/약국 위치를 안내합니다.",
        comments3: "",
        menu: "전국 질병 지도",
        name: "/menu",
        imageUrl: "welcome3.png",
      },
      {
        title: "계절별 질병 안내",
        comments1: "계절별 질병 안내로",
        comments2: "1년 건강을 예방할 수 있습니다.",
        comments3: "",
        menu: "주변 의료 시설",
        name: "/maps",
        imageUrl: "welcome4.png",
      },
      {
        title: "Q&A / 공지사항",
        comments1: "서비스 이용 문의 및 불편사항을 접수해",
        comments2: "지속적으로 개선합니다.",
        comments3: "",
        menu: "QnA 및 공지사항",
        name: "/board",
        imageUrl: "welcome5.png",
      },
    ],
    maxsize: 5,
  },
  getters: {},
  mutations: {
    SET_SELECTED_NUM: (state, selected_num) => {
      state.selected_num = selected_num;
    },
  },
  actions: {
    set_selected_num({ commit }, selected_num) {
      console.log("checked number : " + selected_num);
      commit("SET_SELECTED_NUM", selected_num);
    },
  },
};

export default navStore;

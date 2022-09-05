const navStore = {
    namespaced: true,
    state: {
        selected_num:0,
        menuArray:[
            {
                title: '홈',
                comments:'홈 버튼입니다.',
                menu: "Home",
                name: '/',
            },
            {
                title: '계절별 통계',
                comments:'기상과 관련된 각종 통계정보를 확인할 수 있습니다.',
                menu:"About",
                name: '/about',
            },
            {
                title:'질병 지수 확인',
                comments:'지역별 전염병 등 다양한 정보를 한눈에 볼 수 있습니다.',
                menu:"Menu",
                name: '/menu',
            },
            {
                title: '병원 및 약국 위치',
                comments:'카카오 지도를 통해 메뉴를 확인 할 수 있습니다.',
                menu:"Map",
                name: '/maps',
            },
            {
                title: '챗봇',
                comments:'카카오 API로 구성된 챗봇을 호출합니다.',
                menu:"Chat",
                name: '/chat',
            },
          ],
        maxsize:5,
    },
    getters: {
    },
    mutations: {
        SET_SELECTED_NUM: (state,selected_num) => {
            state.selected_num = selected_num;
        }
    },
    actions: {
        set_selected_num({commit}, selected_num){
            console.log("checked number : "+selected_num);
            commit("SET_SELECTED_NUM",selected_num);
        }
    },
}

export default navStore;
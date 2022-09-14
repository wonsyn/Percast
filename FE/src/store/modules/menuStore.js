const menuStore = {
    namespaced: true,
    state:{
        depth:0,
        sido:[
            {
                name : '서울',
            },
            {
                name : '대전',
            },
            {
                name : '대구',
            },
            {
                name : '광주',
            },
            {
                name : '부산',
            },
        ],
        gugun:[
            {
                name : '서구',
            },
            {
                name : '동구',
            },
            {
                name : '대덕구',
            },
            {
                name : '유성구',
            },
            {
                name : '중구',
            },
        ],
        weather:[
            {
                // 기온
                value:36.5,
            },
            {
                // 습도
                value:53,
            },
            {
                // 강수량
                value:13,
            }
        ],
        environment:[
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
            }
        ],
        danger: '안전',
        grade: 2,
    },
    getters: {
    },
    mutations: {
        SET_DEPTH:(state, depth)=>{
            state.depth = depth;
        },
        SET_SIDO:(state,sido)=>{
            state.sido = sido;
        },
        SET_GUGUN:(state, gugun)=>{
            state.gugun = gugun;
        },
        SET_WEATHER :(state, weather)=>{
            state.weather = weather;
        },
        SET_ENVIRONMENT:(state, environment)=>{
            state.environment = environment;
        }
    },
    actions: {
        set_depth({commit},depth){
            commit("SET_DEPTH",depth);
        },
        set_sido({commit},sido){
            commit("SET_SIDO",sido);
        },
        set_gugun({commit},gugun){
            commit("SET_GUGUN",gugun);
        },
        set_weather({commit},weather){
            commit("SET_WEATHER",weather);
        },
        set_environment({commit},environment){
            commit("SET_ENVIRONMENT",environment);
        }
    },
}

export default menuStore;
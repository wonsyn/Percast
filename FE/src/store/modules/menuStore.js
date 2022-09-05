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
        }
    },
}

export default menuStore;
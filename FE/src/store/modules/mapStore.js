const mapStore = {
    namespaced: true,
    state:{
        hospital:   {
            category: '병원',
            list: [
                {
                    name:'A',
                },
                {
                    name:'B',
                },
            ],
        },
        pharmacy :   {
            category: '약국',
            list: [
                {
                    name:'A',
                },
                {
                    name:'B',
                },
            ],
        },
    },
    getters: {
    },
    mutations: {
        SET_HOSPITAL:(state, hospital)=>{
            state.hospital = hospital;
        },
        SET_PHARMACY:(state, pharmacy)=>{
            state.pharmacy = pharmacy;
        },
    },
    actions: {
        set_hospital({commit},hospital){
            commit("SET_HOSPITAL",hospital);
        },
        set_pharmacy({commit},pharmacy){
            commit("SET_PHARMACY",pharmacy);
        }
    },
}

export default mapStore;
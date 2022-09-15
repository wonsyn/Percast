<template>
    <b-row>
        <b-card id="maplist">
            <b-card-header> 병원 </b-card-header>
            <b-card-body>
                <div style="overflow:auto; height:220px">
                    <map-l-option-list-item v-for="(item,index) in hospital.list" :key="item.index = index" v-bind="item"></map-l-option-list-item>
                </div>
            </b-card-body>
        </b-card>
    </b-row>
    <b-row>
        <b-card id="maplist">
            <b-card-header> 약국 </b-card-header>
            <b-card-body>
                <div style="overflow:auto; height:220px">
                    <map-l-option-list-item v-for="(item,index) in pharmacy.list" :key="item.index = index" v-bind="item"></map-l-option-list-item>
                </div>
            </b-card-body>
        </b-card>
    </b-row>
</template>

<script>
    import {computed} from 'vue';
    import {useStore} from 'vuex';
    import MapLOptionListItem from './MapLOptionListItem.vue';
    export default {
        components:{
            MapLOptionListItem,
        },
        setup(){
            const store = useStore();
            const hospital = computed(()=>store.state.mapStore.hospital);
            const pharmacy = computed(()=>store.state.mapStore.pharmacy);

            return {store, hospital, pharmacy};
        },
        data(){
            return{
            }
        }
    }
</script>

<style>
#maplist{
  background-color:#0f1421;
}

.card-header{
  background-color:#0f1421;
  color:white;
  font-style: bold;
 }

 
</style>
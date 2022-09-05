<template>
  <home-body-item v-for="(items,index) in menuArray" :key="items.index = index" v-bind="items"></home-body-item>
</template>

<script>
    import {useStore} from 'vuex';
    import {computed} from 'vue';

    import HomeBodyItem from './items/HomeBodyItem.vue';
    
    export default {
        components: { HomeBodyItem },
        setup(){
            const store = useStore();
            
            const maxsize = computed(()=>store.state.navStore.maxsize);
            const menuArray = computed(()=>store.state.navStore.menuArray);
            const selected_num = computed(()=>store.state.navStore.selected_num);
            return {store, maxsize, menuArray,selected_num};
        },
        mounted(){
            console.log(this.menuArray.length);
        }    
    }
</script>

<style>

</style>
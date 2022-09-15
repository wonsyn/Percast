<template>
  <li @click="InnerRegion()">
    {{name}}
  </li>
</template>

<script>
    import {computed} from 'vue';
    import { useStore } from 'vuex';
export default {
    props:{
        name:String,
    },
    methods:{
        InnerRegion(){
            if(this.depth==0)
            {
                console.log("get gugun! - "+this.name);
                this.store.dispatch("menuStore/set_depth",1);
            }
            else{
                console.log("just gugun : "+this.name);
            }
        },
    },
    setup(){
        const store = useStore();
        const depth = computed(()=>store.state.menuStore.depth);

        return {store, depth};
    }
}
</script>

<style>

</style>
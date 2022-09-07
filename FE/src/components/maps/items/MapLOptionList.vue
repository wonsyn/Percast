<template>
    <b-row>
        <map-l-option-list-item v-for="(item,index) in lists" :key="item.index = index" v-bind="item"></map-l-option-list-item>
    </b-row>
</template>

<script>
    import MapLOptionListItem from './MapLOptionListItem.vue';
export default {
    components:{
        MapLOptionListItem,
    },
    data(){
        return{
            lists:[
                {
                    name:'A',
                },
                {
                    name:'B',
                },
            ],
        }
    }
}
</script>

<style>

</style>
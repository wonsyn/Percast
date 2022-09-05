<template>
  <div>
    <b-row>
        <b-col>
            <map-l-option></map-l-option>
        </b-col>
        <b-col>
          <maps-main></maps-main>
        </b-col>
        <b-col>
            <map-r-option></map-r-option>
        </b-col>
    </b-row>
</div>
</template>

<script>
  import MapsMain from '@/components/maps/MapsMain.vue';
  import MapLOption from '@/components/maps/MapLOption.vue' 
  import MapROption from '@/components/maps/MapROption.vue'
  
  export default {
  components:{
    MapsMain,
    MapLOption, 
    MapROption,
  }
}
</script>

<style>

</style>
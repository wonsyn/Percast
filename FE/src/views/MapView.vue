<template>
  <div id="view_body">
    <b-row>
      <b-col cols="4">
        <map-l-option></map-l-option>
      </b-col>
      <b-col cols="8">
        <maps-main></maps-main>
      </b-col>
      <!-- 
        <b-col>
            <map-r-option></map-r-option>
        </b-col> 
      -->
    </b-row>
  </div>
</template>

<script>
import MapsMain from '@/components/maps/MapsMain.vue';
import MapLOption from '@/components/maps/MapLOption.vue'
//import MapROption from '@/components/maps/MapROption.vue'

export default {
components: {
MapsMain,
MapLOption,
//MapROption,
}
}
</script>

<style>
</style>
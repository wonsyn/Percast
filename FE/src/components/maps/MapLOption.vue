<template>
  <b-card>
    <b-card-header> 병원 리스트 </b-card-header>
    <b-card-body>
      <map-l-option-list></map-l-option-list>
    </b-card-body>
  </b-card>
</template>

<script>
  import MapLOptionList from './items/MapLOptionList.vue';
export default {
  components:{
    MapLOptionList,
  }
}
</script>

<style>

</style>
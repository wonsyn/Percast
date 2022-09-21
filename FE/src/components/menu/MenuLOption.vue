<template>
  <div>
    <menu-l-option-type></menu-l-option-type>
    <menu-l-option-progress></menu-l-option-progress>
    <h4 style="color:white; margin-top:10px">현재 대기 정보</h4>
    <menu-l-option-weather></menu-l-option-weather>
    <menu-l-option-env></menu-l-option-env>
  </div>
</template>

<script>
  import MenuLOptionEnv from './items/MenuLOptionEnv.vue';
  import MenuLOptionProgress from './items/MenuLOptionProgress.vue';
  import MenuLOptionType from './items/MenuLOptionType.vue';
  import MenuLOptionWeather from './items/MenuLOptionWeather.vue'
export default {
  components: { 
    MenuLOptionEnv, 
    MenuLOptionProgress,
    MenuLOptionType,
    MenuLOptionWeather,
  },

}
</script>

<style>

</style>
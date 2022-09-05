<template>
  <home-main></home-main>
</template>

<script>
import HomeMain from "@/components/home/HomeMain.vue"

export default {
  name: 'HomeView',
  components: {
    HomeMain,
  }
}
</script>

<style>
  .menu{
    min-width: 20rem;
    max-width: 20rem;
    max-height: 20rem;
    min-height: 20rem;
  }
  .menu_col{

  }
</style>
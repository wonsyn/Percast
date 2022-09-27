<template>
  <div id="about_view">
    <about-head></about-head>
    <about-types></about-types>
  </div>
</template>

<script>
import AboutHead from "@/components/about/AboutHead.vue";
import AboutTypes from "@/components/about/AboutTypes.vue";
export default {
  name: "AboutView",
  components: { AboutHead, AboutTypes },
};
</script>

<style>
#about_view {
  width: 100vw;
  height: 100vh;
  background-color: #0f1421;
}
</style>

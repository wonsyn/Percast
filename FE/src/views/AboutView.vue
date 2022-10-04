<template>
  <div id="about_view">
    <about-head></about-head>
  </div>
</template>

<script>
import AboutHead from "@/components/about/AboutHead.vue";
export default {
  name: "AboutView",
  components: { AboutHead },
};
</script>

<style>
#about_view {
  width: 100vw;
  height: auto;
  background-color: #0f1421;
}
</style>

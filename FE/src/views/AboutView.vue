<template>
  <div id="view_body">
    <about-head></about-head>
    <about-types></about-types>
  </div>
</template>

<script>
import AboutHead from '@/components/about/AboutHead.vue'
import AboutTypes from '@/components/about/AboutTypes.vue'
export default {
name: 'AboutView',
components: { AboutHead, AboutTypes },
}
</script>


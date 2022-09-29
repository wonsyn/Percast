<template>
  <ul v-for="items in list" :key="items">
    <li v-for="item in items" :key="item"></li>
  </ul>
</template>

<script>
export default {
  props: {
    list: Array,
  },
  mounted() {},
};
</script>

<style></style>

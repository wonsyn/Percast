<template>
  <b-tr>
    <b-th>{{ keyword }}</b-th>
    <b-th>{{ count }} 회</b-th>
  </b-tr>
</template>

<script>
export default {
  props: {
    count: Number,
    keyword: String,
    disease: String,
    id: String,
  },
};
</script>

<style></style>

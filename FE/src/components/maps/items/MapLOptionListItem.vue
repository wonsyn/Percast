<template>
  <b-card>
    <b-row>
      <b-col cols="1" class="idx">{{ index + 1 }}</b-col>
      <b-col cols="7">{{ place_name }}</b-col>
      <b-col cols="4">{{ phone }} </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  props: {
    index: Number,
    place_name: String,
    phone: String,
  },
};
</script>

<style>
.idx {
  padding: 0;
}
</style>

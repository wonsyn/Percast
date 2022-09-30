<template>
  <b-table-simple> </b-table-simple>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const twit = computed(() => store.state.twitStore.twit);
    return { store, twit };
  },
  mounted() {
    console.log("twitter : ");
    console.log(this.twit);
  },
};
</script>

<style></style>

<template>
  <!-- <text v-for="item in list[this.d_type].text" :key="item">{{ item }}</text> -->
  <div></div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  props: {
    lists: Array,
  },
  setup() {
    const store = useStore();
    const d_type = computed(() => store.state.menuStore.d_type);

    return { store, d_type };
  },
  mounted() {
    console.log(this.lists);
    console.log("d : " + this.d_type);
    console.log(this.lists[this.d_type]);
  },
};
</script>

<style></style>

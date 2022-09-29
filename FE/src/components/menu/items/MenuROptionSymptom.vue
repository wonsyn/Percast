<template>
  <b-card id="menu_card" style="height: auto">
    <div
      style="color: white"
      v-for="item in lists[this.d_type].text"
      :key="item"
    >
      {{ item }}
    </div>
  </b-card>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
// import MenuROptionLists from "./lists/MenuROptionLists.vue";

export default {
  setup() {
    const store = useStore();
    const lists = computed(() => store.state.menuStore.symptom);
    const d_type = computed(() => store.state.menuStore.d_type);
    return { store, lists, d_type };
  },
  components: {
    // MenuROptionLists,
  },
};
</script>

<style></style>

<template>
  <b-card id="menu_card">
    <b-card-text>
      <menu-r-option-lists
        v-bind="(list = lists[d_type])"
      ></menu-r-option-lists>
      <div style="color: white">{{ lists[d_type][0].name }}</div>
    </b-card-text>
  </b-card>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import MenuROptionLists from "./lists/MenuROptionLists.vue";

export default {
  setup() {
    const store = useStore();
    const lists = computed(() => store.state.menuStore.foods);
    const d_type = computed(() => store.state.menuStore.d_type);
    return { store, lists, d_type };
  },
  components: {
    MenuROptionLists,
  },
};
</script>

<style></style>

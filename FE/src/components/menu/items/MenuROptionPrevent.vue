<template>
  <b-card id="menu_card">
    <b-card-body>
      <menu-r-option-lists :v-bind="lists"></menu-r-option-lists>
    </b-card-body>
  </b-card>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import MenuROptionLists from "./lists/MenuROptionLists.vue";

export default {
  setup() {
    const store = useStore();
    const lists = computed(() => store.state.menuStore.prevent);
    return { store, lists };
  },
  components: {
    MenuROptionLists,
  },
};
</script>

<style></style>

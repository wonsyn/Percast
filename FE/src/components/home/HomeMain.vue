<template>
  <container>
    <b-row>
      <home-header></home-header>
    </b-row>
    <b-row>
      <home-body></home-body>
    </b-row>
  </container>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import HomeHeader from "./HomeHeader.vue";
import HomeBody from "./HomeBody.vue";

export default {
  name: "HomeView",
  components: {
    HomeHeader,
    HomeBody,
  },
  methods: {
    movePage(link) {
      this.$router.push(link);
    },
  },
  setup() {
    const store = useStore();

    const maxsize = computed(() => store.state.navStore.maxsize);
    const menuArray = computed(() => store.state.navStore.menuArray);
    const selected_num = computed(() => store.state.navStore.selected_num);
    return { store, maxsize, menuArray, selected_num };
  },
};
</script>

<style>
.menu {
  min-width: 20rem;
  max-width: 20rem;
  max-height: 20rem;
  min-height: 20rem;
}

.menu_col {
}
</style>

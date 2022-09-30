<template>
  <home-body-item
    v-for="(items, index) in menuArray"
    :key="(items.index = index)"
    v-bind="items"
    style="margin: auto; background-color: transparent; overflow: hidden"
    id="sec2"
    data-aos="fade"
    class="p-0"
  >
  </home-body-item>
</template>

<script>
import { useStore } from "vuex";
import { computed } from "vue";
import AOS from "aos";
import "aos/dist/aos.css";

import HomeBodyItem from "./items/HomeBodyItemTest.vue";

export default {
  components: { HomeBodyItem },
  setup() {
    const store = useStore();

    const maxsize = computed(() => store.state.navStore.maxsize);
    const menuArray = computed(() => store.state.navStore.menuArray);
    const selected_num = computed(() => store.state.navStore.selected_num);
    return { store, maxsize, menuArray, selected_num };
  },
  mounted() {
    console.log(this.menuArray.length);
  },
  created() {
    AOS.init();
  },
};
</script>

<style>
#sec2 {
  overflow-x: hidden;
}
hr {
  background-color: white;
}
</style>

<template>
  <div>
    <ul v-if="depth==0">
      <menu-main-item v-for="(items,index) in sido" :key="items.index=index" v-bind="items"></menu-main-item>
    </ul>
    <ul v-else-if="depth==1">
      <menu-main-item v-for="(items,index) in gugun" :key="items.index=index" v-bind="items"></menu-main-item>

      <li @click="back()">
        뒤로가기
      </li>
    </ul>
  </div>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex';
import MenuMainItem from '@/components/menu/items/MenuMainItem.vue';

export default {
  components: { MenuMainItem },
  methods: {
    back() {
      this.store.dispatch("menuStore/set_depth", 0);
    }
  },
  setup() {
    const store = useStore();

    const depth = computed(() => store.state.menuStore.depth);
    const sido = computed(() => store.state.menuStore.sido);
    const gugun = computed(() => store.state.menuStore.gugun);

    return { store, depth, sido, gugun };
  }
}
</script>

<style>

</style>
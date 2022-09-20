<template>
  <div>
    <div id="album">
      지도 생성중
      <div id="bg_map">
        <div id="bubble" class="seoul">
          <div id="pic">

          </div>
        </div>
      </div>
    </div>
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
#bg_map {
  position: relative;
  width: 100px;
  height: 100px;
  z-index: 1;
  background-image: url("../../assets/map.png");
  background-size: cover;
}

#pic {
  position: relative;
  width: 50px;
  height: 50px;
  z-index: 2;
  color: red;
  background-size: cover;
  background-image: url("../../assets/bubble.png");
}
</style>
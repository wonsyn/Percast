<template>
  <div>
    <div id="album">
      <div id="bg_map">
        <menu-main-maps></menu-main-maps>
      </div>
    </div>
  </div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import MenuMainMaps from "./items/maps/MenuMainMaps.vue";

export default {
  components: {
    MenuMainMaps,
  },
  data() {
    return {
      circles: null,
    };
  },
  methods: {
    back() {
      this.store.dispatch("menuStore/set_depth", 0);
    },
  },
  mounted() {},
  setup() {
    const store = useStore();

    const depth = computed(() => store.state.menuStore.depth);
    const sido = computed(() => store.state.menuStore.sido);
    const gugun = computed(() => store.state.menuStore.gugun);
    return { store, depth, sido, gugun };
  },
};
</script>

<style>
#album {
  position: relative;
  width: auto;
  height: auto;
}

#bg_map {
  min-width: 100%;
  max-width: 100%;
  max-height: 100%;
  min-height: 100%;
  z-index: 1;
  background-size: cover;
}

#region {
  position: relative;
  margin: 0 auto;
}

.pic {
  width: 50px;
  height: 50px;
  background-color: rgb(255, 255, 255);
  border-radius: 50%;
}

#menu_card {
  background-color: #1a2844;
}
#menu_progress {
  background-color: #1a2844;
}
#menu_card {
  background-color: #1a2844;
  height: 140px;
}

#cards {
  color: white;
}

#tempt {
  width: 40px;
  height: 40px;
  background-image: url("../../assets/tempt.svg");
  background-size: cover;
}

#humidity {
  width: 40px;
  height: 40px;
  background-image: url("../../assets/humidity.svg");
  background-size: cover;
}

#rainy {
  width: 40px;
  height: 40px;
  background-image: url("../../assets/rainy.svg");
  background-size: cover;
}

#dust {
  width: 40px;
  height: 40px;
  background-image: url("../../assets/dust.svg");
  background-size: cover;
}

#super_dust {
  width: 40px;
  height: 40px;
  background-image: url("../../assets/super_dust.svg");
  background-size: cover;
}

#ozon {
  width: 40px;
  height: 40px;
  background-image: url("../../assets/ozon.svg");
  background-size: cover;
}
</style>

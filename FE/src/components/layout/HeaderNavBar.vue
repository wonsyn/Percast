<template>
  <div>
    <b-navbar id="head-nav">
      <b-navbar-nav>

        <router-link :to="{path: menuArray[(selected_num+maxsize-2)%maxsize].name}"
          @click="getSelnum((selected_num+maxsize-2)%maxsize)" class="nav-link">
          {{menuArray[(selected_num+maxsize-2)%maxsize].menu}}
        </router-link>

        <router-link :to="{path: menuArray[(selected_num+maxsize-1)%maxsize].name}"
          @click="getSelnum((selected_num+maxsize-1)%maxsize)" class="nav-link">
          {{menuArray[(selected_num+maxsize-1)%maxsize].menu}}
        </router-link>

        <router-link :to="{path: menuArray[selected_num].name}" class="nav-link">
          {{menuArray[(selected_num)].menu}}
        </router-link>

        <router-link :to="{path: menuArray[(selected_num+1)%maxsize].name}" @click="getSelnum((selected_num+1)%maxsize)"
          class="nav-link">
          {{menuArray[(selected_num+1)%maxsize].menu}}
        </router-link>

        <router-link :to="{path: menuArray[(selected_num+2)%maxsize].name}" @click="getSelnum((selected_num+2)%maxsize)"
          class="nav-link">
          {{menuArray[(selected_num+2)%maxsize].menu}}
        </router-link>

      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex';

export default {
  data() {
    return {

    }
  },
  mounted() {
  },
  methods: {
    getSelnum(nums) {
      console.log(nums);
      //this.store.dispatch('navStore/set_selected_num', nums);

    }
  },
  setup() {
    const store = useStore();

    const maxsize = computed(() => store.state.navStore.maxsize);
    const menuArray = computed(() => store.state.navStore.menuArray);
    const selected_num = computed(() => store.state.navStore.selected_num);
    return { store, maxsize, menuArray, selected_num };
  }
}
</script>

<style>
#head-nav {
  background-color: #1a2844;
  z-index: 2;
}

#head-nav .nav-link {
  color: white;
}
</style>
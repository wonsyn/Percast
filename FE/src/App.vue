<template>
  <div id="body">
    <header-nav-bar></header-nav-bar>
    <router-view />
  </div>
</template>

<script>
import { useStore } from "vuex";
import HeaderNavBar from "./components/layout/HeaderNavBar.vue";

export default {
  setup() {
    const store = useStore();
    return { store };
  },
  components: {
    HeaderNavBar,
  },
  mounted() {
    this.store.dispatch("menuStore/get_scores");
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#body {
  width: 100vw;
  height: 100vh;
  background-color: black;
}

#view_body {
  width: 100%;
  height: 100% auto;
  background-color: #0f1421;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: white;
}

nav a.router-link-exact-active {
  color: #bbbbbb;
}

.card {
  background-color: #1a2844;
}
</style>

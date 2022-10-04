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
}

#body {
  min-width: 100vw;
  width: auto;
  min-height: 100vh;
  height: auto;
  background-color: #0f1421;
}

#view_body {
  width: 100%;
  height: auto;
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
</style>

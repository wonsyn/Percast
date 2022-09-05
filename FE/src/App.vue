<template>
  <div>
    <header-nav-bar></header-nav-bar>
    <router-view />
    <footer-nav-bar></footer-nav-bar>
  </div>
</template>

<script>
import HeaderNavBar from "./components/layout/HeaderNavBar.vue";
import FooterNavBar from "./components/layout/FooterNavBar.vue";
export default {
  components: {
    HeaderNavBar,
    FooterNavBar,
  }
}
</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

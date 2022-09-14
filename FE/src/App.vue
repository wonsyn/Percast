<template>
  <div id='body'>
    <header-nav-bar></header-nav-bar>
    <router-view />
  </div>
</template>

<script>
import HeaderNavBar from "./components/layout/HeaderNavBar.vue";

export default {
components: {
HeaderNavBar,
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

#body{
  width: 100%;
  height:100%;
  background-color: #0f1421;
}

#view_body{
  width: 100%;
  height:100%;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: white;
}

nav a.router-link-exact-active {
  color: #BBBBBB;
}
.card {
  background-color:#1a2844;
}
</style>

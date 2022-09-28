import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstrapVue3 from "bootstrap-vue-3";
import Vue3Geolocation from "vue3-geolocation";

import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import "./assets/css/main.css";

const app = createApp(App);
app
  .use(store)
  .use(router)
  .use(BootstrapVue3)
  .use(Vue3Geolocation)
  .mount("#app");

<template>
  <b-card id="menu" style="height: 600px; background-color: transparent">
    <b-row v-if="index % 2 == 0" style="height: 500px; width: auto">
      <b-col class="menu" data-aos="fade-right" data-aos-offset="300">
        <b-card style="background-color: transparent">
          <h1 style="color: white">
            {{ title }}
          </h1>
          <b-card-text style="color: white">
            {{ comments }}
          </b-card-text>
        </b-card>
      </b-col>
      <b-col class="menu" data-aos="fade-left" data-aos-offset="300">
        <b-card style="background-color: transparent">
          <b-card-text>
            <img :src="require(`@/assets/${imageUrl}`)" />
          </b-card-text>
          <b-card-footer @click="movePage(name, index)" style="color: white">
            이동하기 ->
          </b-card-footer>
        </b-card>
      </b-col>
    </b-row>
    <b-row v-else style="height: 500px">
      <b-col class="menu" data-aos="fade-right" data-aos-offset="300">
        <b-card style="background-color: transparent">
          <b-card-text>
            <img :src="require(`@/assets/${imageUrl}`)" />
          </b-card-text>
          <b-card-footer @click="movePage(name, index)" style="color: white">
            이동하기 ->
          </b-card-footer>
        </b-card>
      </b-col>
      <b-col class="menu" data-aos="fade-left" data-aos-offset="300">
        <b-card style="background-color: transparent">
          <h1 style="color: white">
            {{ title }}
          </h1>
          <b-card-text style="color: white">
            {{ comments }}
          </b-card-text>
        </b-card>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
import { useStore } from "vuex";
import AOS from "aos";
import "aos/dist/aos.css";

export default {
  props: {
    index: Number,
    title: String,
    comments: String,
    menu: String,
    name: String,
    imageUrl: String,
  },
  methods: {
    movePage(link, num) {
      console.log(link);
      this.store.dispatch("navStore/set_selected_num", num);
      this.$router.push(link);
    },
  },
  setup() {
    const store = useStore();
    return { store };
  },
  created() {
    AOS.init();
    // console.log(this.comments);
  },
};
</script>

<style>
#menu {
  margin: 10px;
  width: 99%;
  /* background-color: gray; */
  background-color: transparent;
  align-items: center;
}
#card-body {
  background-color: transparent;
}

#menu .menu {
  width: 300px;
}

#col .aos-init .aos-animate {
  align-items: center;
}
</style>

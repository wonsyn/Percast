<template>
  <div class="mt-2">
    // card
    <div id="menu" style="height: 600px; background-color: transparent">
      <b-row v-if="index % 2 == 0" style="height: 500px" no-gutters>
        <b-col class="menu"></b-col>
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
        <!-- <b-col class="menu"></b-col> -->
        <b-col class="menu" data-aos="fade-left" data-aos-offset="300">
          <div class="d-flex align-items-center">
            <b-card style="background-color: transparent">
              <div>
                <img :src="require(`@/assets/${imageUrl}`)" />
              </div>
              <div v-if="index != 0" class="m-2">
                <b-button @click="movePage(name, index)" style="color: white">
                  이동하기
                </b-button>
              </div>
            </b-card>
          </div>
        </b-col>
      </b-row>
      <b-row v-else style="height: 500px" no-gutters>
        <!-- <b-col class="menu"></b-col> -->
        <b-col class="menu" data-aos="fade-right" data-aos-offset="300">
          <b-card style="background-color: transparent">
            <div>
              <img :src="require(`@/assets/${imageUrl}`)" />
            </div>
            <div class="m-2">
              <b-button @click="movePage(name, index)" style="color: white">
                이동하기
              </b-button>
            </div>
          </b-card>
        </b-col>
        <b-col class="menu"></b-col>
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
    </div>
  </div>
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

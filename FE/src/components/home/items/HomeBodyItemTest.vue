<template>
  <div>
    <b-row
      v-if="index % 2 == 0"
      class="justify-content-md-center my-5"
      style="color: #5673eb"
    >
      <b-col data-aos="fade-right" data-aos-offset="300">
        <div>
          <div>
            <h1>{{ title }}</h1>
          </div>
          <div>
            {{ comments }}
          </div>
        </div>
      </b-col>
      <b-col data-aos="fade-left" data-aos-offset="300" class="mx-3">
        <div>
          <img :src="require(`@/assets/${imageUrl}`)" />
        </div>
        <div v-if="index != 0" class="m-2">
          <b-button
            pill
            variant="success"
            @click="movePage(name, index)"
            style="color: white; background-color: #5673eb"
          >
            이동하기
          </b-button>
        </div>
      </b-col>
    </b-row>
    <b-row v-else class="justify-content-md-center my-5" style="color: white">
      <b-col data-aos="fade-right" data-aos-offset="300" class="mx-3">
        <div>
          <img :src="require(`@/assets/${imageUrl}`)" />
        </div>
        <div v-if="index != 0" class="m-2">
          <b-button
            pill
            variant="success"
            @click="movePage(name, index)"
            style="color: black; background-color: white"
          >
            이동하기
          </b-button>
        </div>
      </b-col>
      <b-col data-aos="fade-left" data-aos-offset="300">
        <div>
          <div>
            <h1>{{ title }}</h1>
          </div>
          <div>
            {{ comments }}
          </div>
        </div>
      </b-col>
    </b-row>
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
img {
  width: "auto";
  height: "auto";
  max-width: 600px;
  max-height: 600px;
}
</style>

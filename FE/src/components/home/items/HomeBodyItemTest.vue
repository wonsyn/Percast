<template>
  <div>
    <b-row
      v-if="index % 2 == 0"
      class="justify-content-md-center my-5"
      style="color: #5673eb"
    >
      <b-col data-aos="fade-right" data-aos-offset="100">
        <div>
          <div>
            <div id="welcome_title">{{ title }}</div>
          </div>
          <div id="welcom_comments_left" class="mt-5">
            {{ comments1 }}
          </div>
          <div id="welcom_comments_left">
            {{ comments2 }}
          </div>
          <div id="welcom_comments_left">
            {{ comments3 }}
          </div>
        </div>
      </b-col>
      <b-col data-aos="fade-left" data-aos-offset="100" class="mx-3">
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
      <b-col data-aos="fade-right" data-aos-offset="100" class="mx-3">
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
      <b-col data-aos="fade-left" data-aos-offset="100">
        <div>
          <div>
            <div id="welcome_title">{{ title }}</div>
          </div>
          <div id="welcom_comments_right" class="mt-5">
            {{ comments1 }}
          </div>
          <div id="welcom_comments_right">
            {{ comments2 }}
          </div>
          <div id="welcom_comments_right">
            {{ comments3 }}
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
    comments1: String,
    comments2: String,
    comments3: String,
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
@import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap");
#menu {
  margin: 10px;
  width: 99%;
  /* background-color: gray; */
  background-color: transparent;
  align-items: center;
}
#card-body {
}

#menu .menu {
  width: 300px;
}

#col .aos-init .aos-animate {
  align-items: center;
}
img {
  background-color: transparent;
  width: "auto";
  height: "auto";
  max-width: 600px;
  max-height: 600px;
}
#welcome_title {
  font-size: 50px;
  font-weight: 1000;
  font-family: "Nanum Gothic";
}
/* 위 우 아래 좌 */
#welcom_comments_right {
  font-size: 20px;
  font-weight: 600;
  font-family: "Nanum Gothic";
  text-align: center;
  /* margin: 10px 0px 10px 150px; */
}
#welcom_comments_left {
  font-size: 20px;
  font-weight: 600;
  font-family: "Nanum Gothic";
  text-align: center;
  /* margin: 10px 0px 10px 150px; */
}
</style>

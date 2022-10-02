<template>
  <div id="wrapper">
    <div id="header">
      <div class="logo">
        <span class="icon fa-gem"></span>
      </div>
      <div class="content">
        <div class="inner">
          <h1>{{ seasons[selNum] }}</h1>
          <p>{{ texts[selNum] }}</p>
        </div>
      </div>
      <div>
        <div v-if="selNum != 4" class="content">
          <div class="button" @click="showModal" style="cursor: pointer">
            확인하기
          </div>
        </div>
      </div>
      <nav>
        <ul>
          <li>
            <a
              @click="openSeason(0)"
              :class="selected[0]"
              style="cursor: pointer"
              >Spring</a
            >
          </li>
          <li>
            <a
              @click="openSeason(1)"
              :class="selected[1]"
              style="cursor: pointer"
              >Summer</a
            >
          </li>
          <li>
            <a
              @click="openSeason(2)"
              :class="selected[2]"
              style="cursor: pointer"
              >Autumn</a
            >
          </li>
          <li>
            <a
              @click="openSeason(3)"
              :class="selected[3]"
              style="cursor: pointer"
              >Winter</a
            >
          </li>
        </ul>
      </nav>
    </div>
  </div>
  <about-modals-show-item-header ref="modal" :content="data[selNum]" />
  <div id="bg" :class="season_class[selNum]"></div>
</template>

<script>
import { computed, ref } from "vue";
import { useStore } from "vuex";
import AboutModalsShowItemHeader from "./modal/item/AboutModalsShowItemHeader.vue";

export default {
  components: {
    AboutModalsShowItemHeader,
  },
  setup() {
    const store = useStore();
    const data = computed(() => store.state.aboutStore.data);

    const modal = ref(null);

    const showModal = async () => {
      const ok = await modal.value.show();
      if (ok) {
        console.log("모달 출력");
      } else {
        console.log("모달 종료");
      }
    };

    return {
      store,
      data,
      modal,
      showModal,
    };
  },
  data() {
    return {
      selected: ["", "", "", ""],
      season_class: ["Spring", "Summer", "Autumn", "Winter", "Select"],
      seasons: ["Spring", "Summer", "Autumn", "Winter", "Select a Season"],
      texts: [
        "봄은 미세먼지가 많아 기관지 관련 질병을 조심해야 합니다.",
        "여름은 날씨가 덥고 습하여 온열질병을 조심해야 합니다.",
        "가을은 온도변화로 인해 감기를 조심해주세요",
        "겨울은 춥고 건조한 날씨로 질병에 쉽게 걸립니다.",
        "원하는 날짜를 선택하세요. 해당 날짜에 맞는 질병에 대한 안내를 띄워드립니다.",
      ],
      pictures: ["Spring.png", "Summer.png", "Autumn.png", "Winter.png", ""],
      selNum: 4,
    };
  },
  methods: {
    openSeason(num) {
      this.selNum = num;
      this.changeCategorySeason(num);
    },
    changeCategorySeason(el) {
      for (let i = 0; i < this.selected.length; i++) {
        this.selected[i] = "";
      }
      if (el != null) {
        this.selected[el] = "on";
      }
    },
    ok() {
      console.log("ok");
    },
    cancel() {
      console.log("cancel");
    },
    hide(str) {
      console.log(str);
    },
  },
};
</script>

<style>
body {
  overflow-x: hidden;
}

#header {
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  -moz-flex-direction: column;
  -webkit-flex-direction: column;
  -ms-flex-direction: column;
  flex-direction: column;
  -moz-align-items: center;
  -webkit-align-items: center;
  -ms-align-items: center;
  align-items: center;
  -moz-transition: -moz-transform 0.325s ease-in-out,
    -moz-filter 0.325s ease-in-out, opacity 0.325s ease-in-out;
  -webkit-transition: -webkit-transform 0.325s ease-in-out,
    -webkit-filter 0.325s ease-in-out, opacity 0.325s ease-in-out;
  -ms-transition: -ms-transform 0.325s ease-in-out,
    -ms-filter 0.325s ease-in-out, opacity 0.325s ease-in-out;
  transition: transform 0.325s ease-in-out, filter 0.325s ease-in-out,
    opacity 0.325s ease-in-out;
  background-image: -moz-radial-gradient(
    rgba(0, 0, 0, 0.25) 25%,
    rgba(0, 0, 0, 0) 55%
  );
  background-image: -webkit-radial-gradient(
    rgba(0, 0, 0, 0.25) 25%,
    rgba(0, 0, 0, 0) 55%
  );
  background-image: -ms-radial-gradient(
    rgba(0, 0, 0, 0.25) 25%,
    rgba(0, 0, 0, 0) 55%
  );
  background-image: radial-gradient(
    rgba(0, 0, 0, 0.25) 25%,
    rgba(0, 0, 0, 0) 55%
  );
  max-width: 100%;
  text-align: center;
}

#header > * {
  -moz-transition: opacity 0.325s ease-in-out;
  -webkit-transition: opacity 0.325s ease-in-out;
  -ms-transition: opacity 0.325s ease-in-out;
  transition: opacity 0.325s ease-in-out;
  position: relative;
  margin-top: 3.5rem;
}

#header > *:before {
  content: "";
  display: block;
  position: absolute;
  top: calc(-3.5rem - 1px);
  left: calc(50% - 1px);
  width: 1px;
  height: calc(3.5rem + 1px);
  background: #ffffff;
}

#header > :first-child {
  margin-top: 0;
}

#header > :first-child:before {
  display: none;
}

#header .logo {
  width: 5.5rem;
  height: 5.5rem;
  line-height: 5.5rem;
  border: solid 1px #ffffff;
  border-radius: 100%;
}

#header .logo .icon:before {
  font-size: 2rem;
}

#header .content {
  border-style: solid;
  border-color: #ffffff;
  border-top-width: 1px;
  border-bottom-width: 1px;
  max-width: 100%;
  color: #ffffff;
}

#header .content .button {
  display: block;
  min-width: 7.5rem;
  height: 2.75rem;
  line-height: 2.75rem;
  padding: 0 1.25rem 0 1.45rem;
  font-weight: bold;
  letter-spacing: 0.2rem;
  font-size: 1rem;
  border-bottom: 0;
}

#header .content .inner {
  -moz-transition: max-height 0.75s ease, padding 0.75s ease,
    opacity 0.325s ease-in-out;
  -webkit-transition: max-height 0.75s ease, padding 0.75s ease,
    opacity 0.325s ease-in-out;
  -ms-transition: max-height 0.75s ease, padding 0.75s ease,
    opacity 0.325s ease-in-out;
  transition: max-height 0.75s ease, padding 0.75s ease,
    opacity 0.325s ease-in-out;
  -moz-transition-delay: 0.25s;
  -webkit-transition-delay: 0.25s;
  -ms-transition-delay: 0.25s;
  transition-delay: 0.25s;
  padding: 3rem 2rem;
  max-height: 40rem;
  overflow: hidden;
}

#header .content .inner > :last-child {
  margin-bottom: 0;
}

#header .content p {
  text-transform: uppercase;
  letter-spacing: 0.2rem;
  font-size: 0.8rem;
  line-height: 2;
}

#header .content .button:hover {
  background-color: rgba(255, 255, 255, 0.075);
  color: gray;
}

nav {
  padding: 0;
}

#header nav ul {
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  margin-bottom: 0;
  list-style: none;
  padding-left: 0;
  border: solid 1px white;
  border-radius: 4px;
}

#header nav ul li {
  padding-left: 0;
  border-left: solid 1px #ffffff;
}

#header nav ul li:first-child {
  border-left: 0;
}

#header nav ul li a {
  display: block;
  min-width: 7.5rem;
  height: 2.75rem;
  line-height: 2.75rem;
  padding: 0 1.25rem 0 1.45rem;
  text-transform: uppercase;
  letter-spacing: 0.2rem;
  font-size: 0.8rem;
  border-bottom: 0;
}

#header nav ul li a:hover {
  background-color: rgba(255, 255, 255, 0.075);
  color: gray;
}

#header nav ul li .on {
  background-color: rgba(255, 255, 255, 0.175);
  color: #cccccc;
}

#wrapper {
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  -moz-flex-direction: column;
  -webkit-flex-direction: column;
  -ms-flex-direction: column;
  flex-direction: column;
  -moz-align-items: center;
  -webkit-align-items: center;
  -ms-align-items: center;
  align-items: center;
  -moz-justify-content: space-between;
  -webkit-justify-content: space-between;
  -ms-justify-content: space-between;
  /* justify-content: space-between; */
  position: relative;
  /* min-height: 100vh; */
  width: 100%;
  padding: 4rem 2rem;
  z-index: 3;
}

#wrapper:before {
  content: "";
  display: block;
}

@media screen and (max-width: 1680px) {
  #wrapper {
    padding: 3rem 2rem 0rem;
  }
}

@media screen and (max-width: 736px) {
  #wrapper {
    padding: 2rem 1rem;
  }
}

@media screen and (max-width: 480px) {
  #wrapper {
    padding: 1rem;
  }
}

#bg {
  -moz-transform: scale(1);
  -webkit-transform: scale(1);
  -ms-transform: scale(1);
  transform: scale(1);
  -webkit-backface-visibility: hidden;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  z-index: 1;
}

#bg {
  -moz-transition: background-color 2.5s ease-in-out;
  -webkit-transition: background-color 2.5s ease-in-out;
  -ms-transition: background-color 2.5s ease-in-out;
  transition: background-color 2.5s ease-in-out;
  -moz-transition-delay: 0.75s;
  -webkit-transition-delay: 0.75s;
  -ms-transition-delay: 0.75s;
  transition-delay: 0.75s;
  background-size: 100% 100%;
  background-position: center, center;
  background-repeat: no-repeat, repeat;
  z-index: 0;
}

#bg.Spring {
  background-image: url("../../assets/Spring.png");
}

#bg.Summer {
  background-image: url("../../assets/Summer.png");
}

#bg.Autumn {
  background-image: url("../../assets/Autumn.png");
}

#bg.Winter {
  background-image: url("../../assets/Winter.png");
}

#bg .Select {
  background: url("../../assets/logo.svg");
}

body.is-article-visible #bg:after {
  -moz-transform: scale(1.0825);
  -webkit-transform: scale(1.0825);
  -ms-transform: scale(1.0825);
  transform: scale(1.0825);
  -moz-filter: blur(0.2rem);
  -webkit-filter: blur(0.2rem);
  -ms-filter: blur(0.2rem);
  filter: blur(0.2rem);
}

body.is-preload #bg:before {
  background-color: #000000;
}
</style>

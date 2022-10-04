<template>
  <div id="view_body">
    <b-row v-if="!resize" style="text-align: center; min-width: 600px">
      <menu-l-option-type></menu-l-option-type>
    </b-row>
    <b-row>
      <b-col v-if="undersize">
        <menu-l-option-progress></menu-l-option-progress>
      </b-col>
      <b-col v-if="undersize">
        <h4 style="color: white; margin-top: 20px">현재 날씨 정보</h4>
        <menu-l-option-weather></menu-l-option-weather>
        <h4 style="color: white; margin-top: 10px">현재 대기 정보</h4>
        <menu-l-option-env></menu-l-option-env>
      </b-col>
    </b-row>
    <b-row>
      <b-col v-if="resize" cols="3" style="padding-left: 20px">
        <menu-l-option></menu-l-option>
      </b-col>
      <b-col cols="6">
        <menu-main />
      </b-col>
      <b-col cols="3" style="padding-right: 35px">
        <menu-r-option v-if="resize"></menu-r-option>
        <div
          v-if="!resize && !undersize"
          style="min-width: 350px; margin-left: 100px"
        >
          <menu-l-option-progress></menu-l-option-progress>
          <h4 style="color: white; margin-top: 20px">현재 날씨 정보</h4>
          <menu-l-option-weather></menu-l-option-weather>
          <h4 style="color: white; margin-top: 10px">현재 대기 정보</h4>
          <menu-l-option-env></menu-l-option-env>
        </div>
      </b-col>
    </b-row>
    <b-row v-if="!resize">
      <menu-r-option></menu-r-option>
    </b-row>
  </div>
</template>

<script>
import MenuMain from "@/components/menu/MenuMain.vue";
import MenuROption from "@/components/menu/MenuROption.vue";
import MenuLOption from "@/components/menu/MenuLOption.vue";
import MenuLOptionType from "@/components/menu/items/MenuLOptionType.vue";
import MenuLOptionProgress from "@/components/menu/items/MenuLOptionProgress.vue";
import MenuLOptionWeather from "@/components/menu/items/MenuLOptionWeather.vue";
import MenuLOptionEnv from "@/components/menu/items/MenuLOptionEnv.vue";
export default {
  name: "MenuView",
  components: {
    MenuMain,
    MenuROption,
    MenuLOption,
    MenuLOptionType,
    MenuLOptionProgress,
    MenuLOptionWeather,
    MenuLOptionEnv,
  },
  data() {
    return {
      resize: true,
      undersize: false,
    };
  },
  mounted() {
    window.addEventListener("resize", this.handleResize);
    if (window.innerWidth > 1142) {
      this.resize = true;
      this.undersize = false;
    } else if (window.innerWidth < 900) {
      this.resize = false;
      this.undersize = true;
    } else {
      this.resize = false;
      this.undersize = false;
    }
  },
  beforeUnmount() {
    window.removeEventListener("resize", this.handleResize);
  },
  methods: {
    handleResize() {
      if (window.innerWidth > 1142) {
        this.resize = true;
        this.undersize = false;
      } else if (window.innerWidth < 900) {
        this.resize = false;
        this.undersize = true;
      } else {
        this.resize = false;
        this.undersize = false;
      }
    },
  },
};
</script>

<style></style>

<template>
  <div id="view_body">
    <b-row>
      <b-col cols="4" v-if="resize">
        <map-l-option></map-l-option>
      </b-col>
      <b-col cols="2" v-if="!resize && !undersize"></b-col>
      <b-col cols="8">
        <maps-main></maps-main>
      </b-col>
    </b-row>
    <b-row v-if="!resize">
      <map-l-option></map-l-option>
    </b-row>
  </div>
</template>

<script>
import MapsMain from "@/components/maps/MapsMain.vue";
import MapLOption from "@/components/maps/MapLOption.vue";
//import MapROption from '@/components/maps/MapROption.vue'

export default {
  components: {
    MapsMain,
    MapLOption,
    //MapROption,
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
      if (window.innerWidth > 1200) {
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

<template>
  <div id="menu_nav">
    <a id="menu_type" herf="#" type="link" @click="getInfo(0)">감기</a>
    |
    <a id="menu_type" herf="#" @click="getInfo(1)">천식</a>
    |
    <a id="menu_type" herf="#" @click="getInfo(2)">피부병</a>
    |
    <a id="menu_type" herf=# @click="getInfo(3)">눈병</a>
    |
    <a id="menu_type" herf="#" @click="getInfo(4)">식중독</a>
  </div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const scores = computed(() => store.state.menuStore.scores);
    return { store, scores };
  },
  data() {
    return {
      disease: ["감기", "천식", "피부병", "눈병", "식중독"],
    }
  },
  methods: {
    getInfo(num) {
      console.log(num);
      this.fillRegions();
      this.store.dispatch('menuStore/set_disease', this.disease[num]);
      this.store.dispatch('menuStore/set_d_type', num);
    },

    // scores에 따라 지역의 색이 변화하게 한다.
    fillRegions() {
      const regions = document.getElementsByClassName("OUTLINE");
      for (let i = 0; i < regions.length; i++) {
        const region = document.getElementById(regions[i].id);
        let color = "#";
        // 255 / 100 * scores[i]
        let red = Math.floor(255 / 100 * this.scores[i]);
        const code = ["", "", "", "", "", ""];
        code[0] = Math.floor(red / 16);
        code[1] = red - (code[0] * 16);
        code[2] = 3//46 -> 32 + 14 = 2E
        code[3] = 3
        let blue = Math.floor(255 / 100 * (100 - this.scores[i]));
        code[4] = Math.floor(blue / 16);
        code[5] = blue - (code[4] * 16);

        for (let j = 0; j < 6; j++) {
          switch (code[j]) {
            case 10:
              color += 'A';
              break;
            case 11:
              color += 'B';
              break;
            case 12:
              color += 'C';
              break;
            case 13:
              color += 'D';
              break;
            case 14:
              color += 'E';
              break;
            case 15:
              color += 'F';
              break;
            default:
              color += code[j];
          }
        }
        region.style.fill = color;
      }
    },
  }
}
</script>

<style>
#menu_nav {
  margin: 10px;
  width: 100%;
  height: 50px;
  background-color: #1a2844;
  color: #5673eb;
}

#menu_nav .on {
  color: #eb5374;
}

#menu_type {
  width: 20%;
}

#menu_between {}
</style>
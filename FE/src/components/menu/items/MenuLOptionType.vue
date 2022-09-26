<template>
  <div id="menu_nav">
    <ul>
      <li>
        <a id="menu_type" :class="selected[0]" @click="getInfo(0)">감기</a>
      </li>
      <li>
        <a id="menu_type" :class="selected[1]" @click="getInfo(1)">천식</a>
      </li>
      <li>
        <a id="menu_type" :class="selected[2]" @click="getInfo(2)">피부병</a>
      </li>
      <li>
        <a id="menu_type" :class="selected[3]" @click="getInfo(3)">눈병</a>
      </li>
      <li>
        <a id="menu_type" :class="selected[4]" @click="getInfo(4)">식중독</a>
      </li>
    </ul>
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
      selected: ["", "", "", "", ""],
      disease: ["감기", "천식", "피부병", "눈병", "식중독"],
    };
  },
  mounted() {
    console.log("mounted");
    this.fillRegions();
  },
  methods: {
    getInfo(num) {
      console.log(num);
      this.fillRegions();
      this.store.dispatch("menuStore/set_disease", this.disease[num]);
      this.store.dispatch("menuStore/set_d_type", num);
      this.selected_class(num);
    },
    selected_class(num) {
      for (let i = 0; i < this.selected.length; i++) {
        this.selected[i] = "";
      }
      if (num != null && num < this.selected.length) this.selected[num] = "on";
    },
    // scores에 따라 지역의 색이 변화하게 한다.
    fillRegions() {
      const regions = document.getElementsByClassName("OUTLINE");
      for (let i = 0; i < regions.length; i++) {
        const region = document.getElementById(regions[i].id);
        let color = "#";
        // 255 / 100 * scores[i]
        let red = Math.floor((255 / 100) * this.scores[i]);
        const code = ["", "", "", "", "", ""];
        code[0] = Math.floor(red / 16);
        code[1] = red - code[0] * 16;
        code[2] = 3; //46 -> 32 + 14 = 2E
        code[3] = 3;
        let blue = Math.floor((255 / 100) * (100 - this.scores[i]));
        code[4] = Math.floor(blue / 16);
        code[5] = blue - code[4] * 16;

        for (let j = 0; j < 6; j++) {
          switch (code[j]) {
            case 10:
              color += "A";
              break;
            case 11:
              color += "B";
              break;
            case 12:
              color += "C";
              break;
            case 13:
              color += "D";
              break;
            case 14:
              color += "E";
              break;
            case 15:
              color += "F";
              break;
            default:
              color += code[j];
          }
        }
        region.style.fill = color;
      }
    },
  },
};
</script>

<style>
#menu_nav {
  margin: 10px;
  width: 100%;
  height: 40px;
  background-color: #1a2844;
  color: #5673eb;
}
#menu_nav .on {
  color: #eb5374;
}
#menu_nav ul {
  display: flex;
  margin-bottom: 0;
  list-style: none;
  padding-left: 0;
  border: solid 1px #1a2844;
  border-radius: 4px;
  width: 20%;
}

#menu_nav ul li {
  padding-left: 0;
  border-left: solid 1px #000000;
}

#menu_nav ul li:first-child {
  border-left: 0;
}

#menu_nav ul li a {
  display: block;
  width: 4.5rem;
  height: 2.75rem;
  line-height: 1.5rem;
  padding: 0.5rem 0 0.5rem 0;
  text-transform: uppercase;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  border-bottom: 0;
}

#menu_type {
  color: #5673eb;
}
#menu_type:hover {
  background-color: rgba(255, 255, 255, 0.075);
  color: gray;
}
#menu_type.on {
  background-color: rgba(255, 255, 255, 0.075);
  color: #eb5374;
}
</style>

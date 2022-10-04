<template>
  <div id="menu_nav">
    <!-- <ul>
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
    </ul> -->
    <b-button
      id="menu_type"
      :class="selected[0]"
      @click="getInfo(0)"
      variant="outline-primary"
      >감기</b-button
    >
    <b-button
      id="menu_type"
      :class="selected[1]"
      @click="getInfo(1)"
      variant="outline-primary"
      >천식</b-button
    >
    <b-button
      id="menu_type"
      :class="selected[2]"
      @click="getInfo(2)"
      variant="outline-primary"
      >피부병</b-button
    >
    <b-button
      id="menu_type"
      :class="selected[3]"
      @click="getInfo(3)"
      variant="outline-primary"
      >눈병</b-button
    >
    <b-button
      id="menu_type"
      :class="selected[4]"
      @click="getInfo(4)"
      variant="outline-primary"
      >식중독</b-button
    >
  </div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const scores = computed(() => store.state.menuStore.scores);
    const d_type = computed(() => store.state.menuStore.d_type);
    const r_num = computed(() => store.state.menuStore.r_num);
    const map_data = computed(() => store.state.menuStore.map_data);
    const max_score = computed(() => store.state.menuStore.max_score);
    const min_score = computed(() => store.state.menuStore.min_score);
    const city_score = computed(() => store.state.menuStore.city_score);
    return {
      store,
      scores,
      d_type,
      city_score,
      r_num,
      map_data,
      max_score,
      min_score,
    };
  },
  data() {
    return {
      selected: ["", "", "", "", ""],
      disease_name: ["감기", "천식", "피부병", "눈병", "식중독"],
      disease: ["cold", "asthma", "skin", "eye", "foodPoison"],
      entities: null,
      regions: null,
    };
  },
  mounted() {
    this.regions = document.getElementsByClassName("OUTLINE");
    this.getscores();
    this.fillRegions();
    this.store.dispatch("menuStore/set_score", this.scores[this.r_num]);
    this.store.dispatch("twitStore/set_twit", this.disease[this.d_type]);
  },
  methods: {
    getInfo(num) {
      if (this.d_type == num) {
        return;
      }
      this.store.dispatch("menuStore/set_disease", this.disease[num]); // 질병명 설정
      this.store.dispatch("menuStore/set_d_type", num); // 질병코드 설정
      this.store.dispatch("menuStore/set_disease_name", this.disease_name[num]);
      this.store.dispatch("twitStore/set_twit", this.disease[num]);
      this.getscores();
      this.selected_class(num);
      this.store.dispatch("menuStore/set_score", this.scores[this.r_num]);
      this.fillRegions();
    },
    getscores() {
      const data = [];
      for (let i = 0; i < this.scores.length; i++) {
        switch (this.d_type) {
          case 0:
            data.push(this.city_score[i].cold);
            break;
          case 1:
            data.push(this.city_score[i].asthma);
            break;
          case 2:
            data.push(this.city_score[i].skin);
            break;
          case 3:
            data.push(this.city_score[i].eye);
            break;
          case 4:
            data.push(this.city_score[i].foodPoison);
            break;
          default:
            break;
        }
      }
      this.store.dispatch("menuStore/set_scores", data);
    },
    selected_class(num) {
      for (let i = 0; i < this.selected.length; i++) {
        this.selected[i] = "";
      }
      if (num != null && num < this.selected.length) this.selected[num] = "on";
    },
    // scores에 따라 지역의 색이 변화하게 한다.
    fillRegions() {
      for (let i = 0; i < this.regions.length; i++) {
        let color = "#";
        // 255 / 100 * scores[i]
        // let red = 0;
        let red = Math.floor((255 / 100) * this.scores[this.regions[i].id]);
        // if (this.scores[this.regions[i].id] > 50) red = 255;
        const code = ["", "", "", "", "", ""];
        //빨강
        code[0] = Math.floor(red / 16);
        code[1] = red - code[0] * 16;
        //녹색
        if (this.max_score[this.d_type] - this.min_score[this.d_type] < 50) {
          let green = Math.floor(
            (255 / 100) *
              Math.floor(
                ((this.max_score[this.d_type] - this.scores[i]) /
                  (this.max_score[this.d_type] - this.min_score[this.d_type])) *
                  100,
              ),
          );
          code[2] = Math.floor(green / 16);
          code[3] = green - code[2] * 16;
        }
        // 9.99999 ~ 0.00000 까지의 범위 -> x10
        else {
          code[2] = 3;
          code[3] = 3;
        }
        //파랑
        let blue = 0;
        // let blue = Math.floor(
        //   (255 / 100) * (100 - this.scores[this.regions[i].id]),
        // );
        if (this.scores[this.regions[i].id] < 50) blue = 255;
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
        this.regions[i].style.fill = color;
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
  color: white;
  border-color: white;
  margin: 0 3px;
}
#menu_type:hover {
  background-color: rgba(255, 255, 255, 0.075);
  color: gray;
}
#menu_type.on {
  background-color: rgba(255, 255, 255, 0.075);
  color: #5673eb;
}
</style>

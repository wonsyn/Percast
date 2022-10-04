<template>
  <h3 style="color: white; margin-top: 20px">{{ region }} 위험단계</h3>
  <b-card id="menu_progress">
    <b-card-header>
      <div id="menu_text" style="font-size: 20px; margin-top: 5px">
        현재 {{ region }} 의 위험지수는
      </div>
      <a id="score" style="font-size: 30px">{{ score }}</a>
      <a id="menu_text" style="font-size: 20px; margin-top: 20px"> 점</a>
      <div id="menu_text" style="font-size: 20px">입니다.</div>
      <b-progress
        max="100"
        height="30px"
        style="background: gray; margin-bottom: 10px"
      >
        <b-progress-bar
          id="progress"
          :value="score"
          style="background: linear-gradient(to left, red, blue)"
        ></b-progress-bar>
      </b-progress>
    </b-card-header>
    <b-card-body>
      <div id="menu_text" style="font-size: 20px">
        <div>현재</div>
        <div>{{ time }} 기준</div>
        <div>{{ region }}의 {{ disease_name }} 위험지수는</div>
        <div>
          <a id="danger_set">{{ danger }}</a> 입니다.
        </div>
      </div>
      <div style="font-size: 13px; color: white; margin-top: 5px">
        건강 조심하시고 행복한 하루 되시길 바랍니다.
      </div>
      <div id="button" @click="showModal">
        [{{ region }}지역 {{ disease_name }}알림 설정]
      </div>
    </b-card-body>
  </b-card>
  <menu-l-option-progress-modal ref="modal"></menu-l-option-progress-modal>
</template>

<script>
import { computed, ref } from "vue";
import { useStore } from "vuex";
import MenuLOptionProgressModal from "@/components/menu/items/modal/MenuLOptionProgressModal.vue";

export default {
  components: {
    MenuLOptionProgressModal,
  },
  setup() {
    const store = useStore();
    const region = computed(() => store.state.menuStore.region);
    const score = computed(() => store.state.menuStore.score);
    const danger = computed(() => store.state.menuStore.danger);
    const disease_name = computed(() => store.state.menuStore.disease_name);

    const modal = ref(null);

    const showModal = async () => {
      const ok = await modal.value.show();
      if (ok) {
        console.log("모달 출력");
      } else {
        console.log("모달 종료");
      }
    };

    return { store, region, score, danger, disease_name, modal, showModal };
  },
  created() {
    this.nowTimes();
    this.setDate();
    setInterval(this.nowTimes.bind(this), 1000);
  },
  mounted() {
    this.change_Score_Color(this.score);
  },
  watch: {
    score: function (value) {
      this.change_Score_Color(value);
      let setting = "좋음";
      let color = "#46EE46";
      if (value > 80) {
        setting = "심각";
        color = this.setColor(100);
      } else if (value > 60) {
        setting = "경계";
        color = this.setColor(80);
      } else if (value > 40) {
        setting = "관심";
        color = "#FF7746";
      } else if (value > 20) {
        setting = "주의";
        color = "#FFED46";
      }
      this.store.dispatch("menuStore/set_danger", setting);
      const d = document.getElementById("danger_set");
      d.style.color = color;
    },
  },
  data() {
    return {
      time: "none",
    };
  },
  methods: {
    setDate() {
      let year = new Date().getFullYear();
      let month =
        new Date().getMonth() + 1 < 10
          ? "0" + (new Date().getMonth() + 1)
          : new Date().getMonth() + 1;
      let date =
        new Date().getDate() < 10
          ? "0" + new Date().getDate()
          : new Date().getDate();
      let hh =
        new Date().getHours() < 10
          ? "0" + new Date().getHours()
          : new Date().getHours();
      let mm =
        new Date().getMinutes() < 10
          ? "0" + new Date().getMinutes()
          : new Date().getMinutes();
      let ss =
        new Date().getSeconds() < 10
          ? "0" + new Date().getSeconds()
          : new Date().getSeconds();
      return {
        year: year,
        month: month,
        date: date,
        hh: hh,
        mm: mm,
        ss: ss,
      };
    },

    nowTimes() {
      this.time =
        this.setDate().year +
        "년 " +
        this.setDate().month +
        "월 " +
        this.setDate().date +
        "일 " +
        this.setDate().hh +
        "시";
    },
    change_Score_Color(score) {
      const num = document.getElementById("score");
      let color = "#46EE46";
      if (score > 80) {
        color = this.setColor(100);
      } else if (score > 60) {
        color = this.setColor(80);
      } else if (score > 40) {
        color = "#FF7746";
      } else if (score > 20) {
        color = "#FFED46";
      }
      if (num != null) num.style.color = color;
    },

    setColor(score) {
      let red = Math.floor((255 / 100) * score);
      const code = ["", "", "", "", "", ""];
      code[0] = Math.floor(red / 16);
      code[1] = red - code[0] * 16;
      code[2] = 4;
      code[3] = 6;
      let blue = Math.floor((255 / 100) * (100 - score));
      code[4] = Math.floor(blue / 16);
      code[5] = blue - code[4] * 16;
      let color = "#";
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
      return color;
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
#menu_text {
  color: #bbbbbb;
}
#button {
  color: #5673eb;
  background-color: #2b3855;
  margin-top: 20px;
  height: 30px;
  border-radius: 8px;
  padding: 0.2rem 0;
  cursor: pointer;
}

#button:hover {
  background-color: rgba(200, 200, 200, 0.075);
  color: gray;
}
</style>

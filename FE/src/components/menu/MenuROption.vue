<template>
  <b-col>
    <b-row>
      <h4 style="color: white; margin-top: 10px">{{ disease_name }} 증상</h4>
      <menu-r-option-symptom></menu-r-option-symptom>
    </b-row>
    <b-row>
      <h4 style="color: white; margin-top: 10px">{{ disease_name }} 예방법</h4>
      <menu-r-option-prevent></menu-r-option-prevent>
    </b-row>
    <b-row>
      <a
        style="
          color: white;
          margin-top: 10px;
          font-size: 24px;
          text-align: right;
        "
      >
        {{ disease_name }} 연관 단어
        <a style="font-size: 10px; color: gray; text-align: end">
          ○ twitter 1일 검색량 기준, 매일 6 시 갱신
        </a>
      </a>
      <menu-r-option-twitter></menu-r-option-twitter>
    </b-row>
  </b-col>
</template>

<script>
import MenuROptionPrevent from "./items/MenuROptionPrevent.vue";
import MenuROptionSymptom from "./items/MenuROptionSymptom.vue";
import MenuROptionTwitter from "./items/r_option/MenuROptionTwitter.vue";
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  components: { MenuROptionSymptom, MenuROptionPrevent, MenuROptionTwitter },
  setup() {
    const store = useStore();
    const disease_name = computed(() => store.state.menuStore.disease_name);

    return { store, disease_name };
  },
};
</script>

<style></style>

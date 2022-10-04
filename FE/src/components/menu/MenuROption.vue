<template>
  <div style="min-width: 330px">
    <h4 style="color: white; margin-top: 10px">{{ disease_name }} 증상</h4>
    <menu-r-option-symptom></menu-r-option-symptom>
    <h4 style="color: white">{{ disease_name }} 예방법</h4>
    <menu-r-option-prevent></menu-r-option-prevent>
    <a
      style="
        color: white;
        font-size: 24px;
        text-align: right;
        padding: 0;
        text-align: center;
      "
    >
      {{ disease_name }} 연관 단어
    </a>
    <a
      style="font-size: 10px; color: gray; text-align: end; text-align: center"
    >
      ○ twitter 1일 검색량 기준, 06:00 갱신
    </a>
    <menu-r-option-twitter></menu-r-option-twitter>
  </div>
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

<template>
  <b-col>
    <b-row>
      <h4 style="color: white; margin-top: 10px">{{ disease }} 증상</h4>
      <menu-r-option-symptom></menu-r-option-symptom>
    </b-row>
    <b-row>
      <h4 style="color: white; margin-top: 10px">{{ disease }} 예방법</h4>
      <menu-r-option-prevent></menu-r-option-prevent>
    </b-row>
    <b-row style="margin-top: 10px">
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
    const disease = computed(() => store.state.menuStore.disease);

    return { store, disease };
  },
};
</script>

<style></style>

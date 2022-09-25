<template>
  <b-col>
    <b-row>
      <h4 style="color:white; margin-top:10px">{{disease}} 증상</h4>
      <menu-r-option-symptom></menu-r-option-symptom>
    </b-row>
    <b-row>
      <h4 style="color:white; margin-top:10px">{{disease}} 예방법</h4>
      <menu-r-option-prevent></menu-r-option-prevent>
    </b-row>
    <b-row>
      <h4 style="color:white; margin-top:10px">{{disease}} 예방 음식</h4>
      <menu-r-option-foods></menu-r-option-foods>
    </b-row>
  </b-col>
</template>

<script>
import MenuROptionFoods from './items/MenuROptionFoods.vue'
import MenuROptionPrevent from './items/MenuROptionPrevent.vue'
import MenuROptionSymptom from './items/MenuROptionSymptom.vue'
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  components: { MenuROptionSymptom, MenuROptionPrevent, MenuROptionFoods },
  setup() {
    const store = useStore();
    const disease = computed(() => store.state.menuStore.disease);

    return { store, disease };
  }
}
</script>

<style>

</style>
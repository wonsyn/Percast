<template>
  <b-col>
    <b-row>
      <menu-r-option-symptom></menu-r-option-symptom>
    </b-row>
    <b-row>
      <menu-r-option-prevent></menu-r-option-prevent>
    </b-row>
    <b-row>
      <menu-r-option-foods></menu-r-option-foods>
    </b-row>
  </b-col>
</template>

<script>
import MenuROptionFoods from './items/MenuROptionFoods.vue'
import MenuROptionPrevent from './items/MenuROptionPrevent.vue'
import MenuROptionSymptom from './items/MenuROptionSymptom.vue'
export default {
  components: { MenuROptionSymptom, MenuROptionPrevent, MenuROptionFoods },

}
</script>

<style>

</style>
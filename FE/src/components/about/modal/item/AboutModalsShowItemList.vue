<template>
  <ul>
    <li>
      <pre>{{title}}  <a v-for="item in text" :key="item"> {{item}} </a></pre>
    </li>
    <about-modals-show-item-list v-for="item in list" :key="item.isEmphasize = false" v-bind="item"></about-modals-show-item-list>
    <about-modals-show-item-list v-for="item in emphasize" :key="item.isEmphasize = true" v-bind="item"></about-modals-show-item-list>
  </ul>
</template>

<script>
export default {
  props: {
    title: Array,
    text: Array,
    list: Array,
    emphasize: Array,
  }
}
</script>

<style>

</style>
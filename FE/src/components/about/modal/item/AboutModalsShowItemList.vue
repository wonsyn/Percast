<template>
  <ul>
    <li>
      <pre>{{title}}  <a v-for="item in text" :key="item"> {{item}} </a></pre>
    </li>
    <ul>
      <li v-for="item in list" :key="item">
        <pre>{{item.title}}  <a v-for="item2 in item.text" :key="item2"> {{item2}} </a></pre>
      </li>
    </ul>
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
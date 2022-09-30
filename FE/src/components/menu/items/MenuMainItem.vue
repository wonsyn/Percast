<template>
  <g :class="name" filter="url(#dropshadow)">
    <text class="TEXT" :x="x" :y="y">{{ name }}</text>
    <text class="SCORE" :x="x" :y="y + 20"> {{ scores[index] }}</text>
  </g>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  props: {
    name: String, //
    classname: String, // 클래스 지정
    index: Number, //
    x: Number,
    y: Number,
  },
  methods: {},
  setup() {
    const store = useStore();
    const scores = computed(() => store.state.menuStore.scores);
    return { store, scores };
  },
  mounted() {
    console.log(this.scores[this.index]);
  },
};
</script>

<style></style>

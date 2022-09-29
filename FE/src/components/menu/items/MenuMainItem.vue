<template>
  <g :class="name" filter="url(#dropshadow)">
    <text class="TEXT" :x="x" :y="y">{{ name }}</text>
    <text class="SCORE" :x="x" :y="y + 20">
      {{ score }}
    </text>
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
    score: Number,
    x: Number,
    y: Number,
  },
  mounted() {},
  methods: {},
  setup() {
    const store = useStore();
    const depth = computed(() => store.state.menuStore.depth);
    return { store, depth };
  },
};
</script>

<style></style>

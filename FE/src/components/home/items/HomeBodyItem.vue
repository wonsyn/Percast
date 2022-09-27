<template>
  <b-card id="menu">
    <b-row v-if="index % 2 == 0">
      <b-col>
        <b-card class="menu">
          <h1>
            {{ title }}
          </h1>
        </b-card>
      </b-col>

      <b-col>
        <b-card class="menu">
          <b-card-text>
            {{ comments }}
          </b-card-text>
          <b-card-footer @click="movePage(name, index)">
            이동하기 ->
          </b-card-footer>
        </b-card>
      </b-col>
    </b-row>
    <b-row v-else>
      <b-col>
        <b-card class="menu">
          <b-card-text>
            {{ comments }}
          </b-card-text>
          <b-card-footer @click="movePage(name, index)">
            이동하기 ->
          </b-card-footer>
        </b-card>
      </b-col>
      <b-col>
        <b-card class="menu">
          <h1>
            {{ title }}
          </h1>
        </b-card>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
import { useStore } from "vuex";

export default {
  props: {
    index: Number,
    title: String,
    comments: String,
    menu: String,
    name: String,
  },
  methods: {
    movePage(link, num) {
      console.log(link);
      this.store.dispatch("navStore/set_selected_num", num);
      this.$router.push(link);
    },
  },
  setup() {
    const store = useStore();
    return { store };
  },
};
</script>

<style>
#menu {
  margin: 10px;
  width: 99%;
  background-color: gray;
  align-items: center;
}

#menu .menu {
  width: 300px;
}
</style>

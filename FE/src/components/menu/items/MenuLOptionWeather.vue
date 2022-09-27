<template>
  <b-card id="menu_card">
    <div>
      <b-row>
        <b-col id="cards" cols="4">
          <div id="tempt"></div>
          <div>기온</div>
          <div>{{ weather.temp }}℃</div>
        </b-col>
        <b-col id="cards" cols="4">
          <div id="humidity"></div>
          <div>습도</div>
          <div>{{ weather.humi }}</div>
        </b-col>
        <b-col id="cards" cols="4">
          <div id="rainy"></div>
          <div>강우량</div>
          <div>{{ weather.rain }}</div>
        </b-col>
      </b-row>
    </div>
  </b-card>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const weather = computed(() => store.state.menuStore.weather);

    return { store, weather };
  },
};
</script>

<style></style>

<template>
  <b-card id="menu_card">
    <div>
      <b-row>
        <b-col class="cards" cols="4">
          <div class="picto">
            <img :src="require(`@/assets/tempt.svg`)" />
          </div>
          <div>기온</div>
          <div>{{ weather.temp }}℃</div>
        </b-col>
        <b-col class="cards" cols="4">
          <div class="picto">
            <img :src="require(`@/assets/humidity.svg`)" />
          </div>
          <div>습도</div>
          <div>{{ weather.humid }}%</div>
        </b-col>
        <b-col class="cards" cols="4">
          <div class="picto">
            <img :src="require(`@/assets/rainy.svg`)" />
          </div>
          <div>강우량</div>
          <div>
            {{ weather.rain }}
            <a style="font-size: 13px; color: #c8c8c8">mm</a>
          </div>
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

<style>
.cards {
  justify-content: center;
  color: white;
}

.picto {
  margin: 10px 0px;
}

#menu_card {
  margin-bottom: 20px;
}
</style>

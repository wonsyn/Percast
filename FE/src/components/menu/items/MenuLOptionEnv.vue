<template>
  <b-card id="menu_card">
    <b-card-body>
      <b-row>
        <b-col cols="4">
          <b-card
            class="inner_card"
            style="background-color: #1a2844; color: white"
          >
            <div id="dust"></div>
            <div>미세먼지</div>
            <b-card-text>{{ environment.pm10 }}</b-card-text>
          </b-card>
        </b-col>
        <b-col cols="4">
          <b-card
            class="inner_card"
            style="background-color: #1a2844; color: white"
          >
            <div id="super_dust"></div>
            <div>일산화탄소</div>
            <b-card-text>{{ environment.co }}</b-card-text>
          </b-card>
        </b-col>
        <b-col cols="4">
          <b-card
            class="inner_card"
            style="background-color: #1a2844; color: white"
          >
            <div id="ozon"></div>
            <div>오존</div>
            <b-card-text>{{ environment.o3 }}</b-card-text>
          </b-card>
        </b-col>
      </b-row>
    </b-card-body>
  </b-card>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const environment = computed(() => store.state.menuStore.environment);

    return { store, environment };
  },
  methods: {
    OnClick() {},
  },
};
</script>

<style></style>

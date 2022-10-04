<template>
  <b-card id="menu_card">
    <b-row>
      <b-col class="cards" cols="4">
        <div class="picto">
          <img :src="require(`@/assets/dust.svg`)" />
        </div>
        <div>미세먼지</div>
        <b-card-text
          >{{ environment.pm10
          }}<a style="font-size: 10px; color: #c8c8c8; margin-left: 3px"
            >㎍/㎥</a
          ></b-card-text
        >
      </b-col>
      <b-col class="cards" cols="4">
        <div class="picto">
          <img :src="require(`@/assets/super_dust.svg`)" />
        </div>
        <div>일산화탄소</div>
        <b-card-text
          >{{ environment.co
          }}<a style="font-size: 10px; color: #c8c8c8; margin-left: 3px"
            >ppm/hr</a
          ></b-card-text
        >
      </b-col>
      <b-col class="cards" cols="4">
        <div class="picto">
          <img :src="require(`@/assets/ozon.svg`)" />
        </div>
        <div>오존</div>
        <b-card-text
          >{{ environment.o3
          }}<a style="font-size: 10px; color: #c8c8c8; margin-left: 3px"
            >ppm/hr</a
          ></b-card-text
        >
      </b-col>
    </b-row>
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

<style>
.cards {
  justify-content: center;
  color: white;
}

.picto {
  margin: 10px 0px;
}
</style>

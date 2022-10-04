<template>
  <b-table-simple responsive hover class="rounded" style="padding: 0">
    <b-thead style="background-color: #1a2844; color: #5673eb">
      <b-tr>
        <b-th>키워드</b-th>
        <b-th>언급량</b-th>
      </b-tr>
    </b-thead>
    <b-tbody style="background-color: #eeeeee; color: #1a2844">
      <menu-r-option-twitter-lists
        v-for="items in twit"
        :key="items"
        v-bind="items"
      ></menu-r-option-twitter-lists>
    </b-tbody>
  </b-table-simple>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import MenuROptionTwitterLists from "../lists/MenuROptionTwitterLists.vue";
export default {
  components: {
    MenuROptionTwitterLists,
  },
  setup() {
    const store = useStore();
    const twit = computed(() => store.state.twitStore.twit);
    const disease_name = computed(() => store.state.menuStore.disease_name);
    return { store, twit, disease_name };
  },
  mounted() {
    console.log("twitter : ");
    console.log(this.twit);
  },
};
</script>

<style></style>

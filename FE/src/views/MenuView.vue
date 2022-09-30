<template>
  <div id="view_body">
    <b-row>
      <b-col cols="3" style="padding-left: 20px">
        <menu-l-option></menu-l-option>
      </b-col>
      <b-col cols="6">
        <menu-main />
      </b-col>
      <b-col cols="3" style="padding-right: 35px">
        <menu-r-option></menu-r-option>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import MenuMain from "@/components/menu/MenuMain.vue";
import MenuROption from "@/components/menu/MenuROption.vue";
import MenuLOption from "@/components/menu/MenuLOption.vue";

export default {
  name: "MenuView",
  components: {
    MenuMain,
    MenuROption,
    MenuLOption,
  },
};
</script>

<style></style>

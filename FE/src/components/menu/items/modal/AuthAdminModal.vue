<template>
  <modal-base ref="baseModal">
    <b-row>
      <b-col cols="11">
        <div class="header">
          <span style="font-weight: bolder">Admin 인증</span>
        </div>
      </b-col>
      <b-col>
        <a @click="close_modal" style="cursor: pointer"> X </a>
      </b-col>
    </b-row>
    <b-row>
      <b-form-group id="fieldset-1" label="Password" label-for="input-1">
        <b-input-group>
          <b-form-input
            id="input-1"
            v-model="adminPassword"
            type="password"
            trim
          ></b-form-input>
          <button class="btn btn-success" @click="authAdmin">Login</button>
        </b-input-group>
      </b-form-group>
    </b-row>
  </modal-base>
</template>

<script>
import ModalBase from "@/components/menu/items/modal/ModalBase";
import { adminLogin } from "@/api/admin.js";

import { ref } from "vue";
import { useStore, mapMutations } from "vuex";

export default {
  components: { ModalBase },
  setup() {
    const store = useStore();

    const baseModal = ref(null);
    const resolvePromise = ref(null);

    const show = () => {
      baseModal.value.open();
      return new Promise((resolve) => {
        resolvePromise.value = resolve;
      });
    };

    const confirm = () => {
      baseModal.value.close();
      resolvePromise.value(true);
    };

    const cancel = () => {
      baseModal.value.close();
      resolvePromise.value(false);
    };
    return { store, baseModal, show, confirm, cancel };
  },
  data() {
    return {
      adminPassword: "",
    };
  },
  methods: {
    ...mapMutations("adminStore", ["SET_ADMIN"]),
    close_modal() {
      this.listnum = 0;
      this.selectNum = 0;
      this.adminPassword = "";
      this.cancel();
    },
    async authAdmin() {
      const data = {
        password: this.adminPassword,
      };
      await adminLogin(
        data,
        (response) => {
          if (response.status === 200) {
            alert("Admin 로그인 성공");
            sessionStorage.setItem("admin", response.data.auth);
            this.SET_ADMIN(response.data.auth);
            this.close_modal();
          } else {
            alert("비밀번호를 확인해 주세요");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};
</script>

<style scoped></style>

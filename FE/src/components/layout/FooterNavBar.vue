<template>
  <div style="background-color: #0f1421">
    <div class="pb-5 px-5 d-flex justify-content-end">
      <button
        v-if="this.admin == null || this.admin === ''"
        class="btn btn-success"
        @click="showModal"
        style="z-index: 4"
      >
        Admin 로그인
      </button>
      <button v-else class="btn btn-success" @click="logout">
        Admin 로그아웃
      </button>
    </div>
  </div>
  <auth-admin-modal ref="modal" style="border-radius: 5px"></auth-admin-modal>
</template>

<script>
import { ref } from "vue";
import { mapState, mapMutations } from "vuex";
import AuthAdminModal from "@/components/menu/items/modal/AuthAdminModal.vue";

export default {
  components: {
    AuthAdminModal,
  },
  computed: {
    ...mapState("adminStore", ["admin"]),
  },
  methods: {
    ...mapMutations("adminStore", ["SET_ADMIN"]),
    logout() {
      this.SET_ADMIN(null);
      sessionStorage.removeItem("admin");
      alert("로그아웃 되었습니다.");
    },
  },
  setup() {
    const modal = ref(null);

    const showModal = async () => {
      await modal.value.show();
    };

    return { modal, showModal };
  },
};
</script>

<style></style>

<template>
  <modal-base ref="baseModal"> </modal-base>
</template>

<script>
import ModalBase from "@/components/menu/modal/ModalBase.vue";

import { ref } from "vue";
export default {
  components: {
    ModalBase,
  },
  props: {
    content: Object,
  },
  setup() {
    const baseModal = ref(null);
    // Promise 객체를 핸들링하기 위한 ref
    const resolvePromise = ref(null);

    const show = () => {
      // baseModal을 직접 컨트롤합니다.
      baseModal.value.open();
      // Promise 객체를 사용하여, 현재 모달에서 확인 / 취소의
      // 응답이 돌아가기 전까지 작업을 기다리게 할 수 있습니다.
      return new Promise((resolve) => {
        // resolve 함수를 담아 외부에서 사용합니다.
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
    return { baseModal, show, confirm, cancel };
  },
  data() {
    return {
      listnum: 0,
      selectNum: 0,
    };
  },
  methods: {
    selItem(idx) {
      this.selectNum = idx;
      this.text = this.content.entity[idx].explain;
    },
    close_modal() {
      this.listnum = 0;
      this.selectNum = 0;
      this.cancel();
    },
  },
};
</script>

<style></style>

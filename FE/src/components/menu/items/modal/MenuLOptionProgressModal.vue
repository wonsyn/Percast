<template>
  <modal-base ref="baseModal">
    <b-row>
      <b-col cols="11">
        <div class="header">
          <span>알림 설정</span>
        </div>
      </b-col>
      <b-col>
        <a @click="close_modal()"> X </a>
      </b-col>
    </b-row>
    <b-row>
      <b-form-group
        id="fieldset-1"
        description="전화번호를 입력해주세요."
        label="Enter your PhoneNumber"
        label-for="input-1"
        valid-feedback="Thank you!"
        :invalid-feedback="invalidFeedback"
        :state="state"
      >
        <b-input-group>
          <b-form-input
            id="input-1"
            v-model="phoneNum"
            :state="state"
            trim
          ></b-form-input>

          <b-input-group-append>
            <b-button variant="primary" @click="send_message()">입력</b-button>
          </b-input-group-append>
        </b-input-group>
      </b-form-group>
    </b-row>
  </modal-base>
</template>

<script>
import ModalBase from "@/components/menu/items/modal/ModalBase.vue";

import { ref } from "vue";
export default {
  components: {
    ModalBase,
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
      phoneNum: "",
    };
  },
  methods: {
    state() {
      return this.phoneNum.length >= 4;
    },

    invalidFeedback() {
      if (this.phoneNum.length > 0) {
        return "Enter at least 4 characters.";
      }
      return "Please enter something.";
    },
    close_modal() {
      this.listnum = 0;
      this.selectNum = 0;
      this.phoneNum = "";
      this.cancel();
    },
    send_message() {
      let pn = "";
      for (let i = 0; i < this.phoneNum.length; i++) {
        if (this.phoneNum[i] >= "0" && this.phoneNum[i] <= "9") {
          pn += this.phoneNum[i];
        } else if (this.phoneNum[i] === "-") {
          console.log("- 는 제거합니다.");
        } else {
          console.log("error");
          alert(
            "잘못된 형식을 입력하였습니다. 숫자 또는 '-' 만 입력 가능합니다.",
          );
          return;
        }
      }
      if (pn.length < 11 || pn.length > 11) {
        alert(
          "전화번호 형식이 다릅니다. 010-xxxx-xxxx 또는 010xxxxxxxx의 형식으로 입력하세요",
        );
        return;
      }
      this.close_modal();
    },
  },
};
</script>

<style></style>

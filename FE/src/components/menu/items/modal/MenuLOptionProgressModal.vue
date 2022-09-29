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
        label="Enter your PhoneNumber"
        label-for="input-1"
        valid-feedback="전화번호 입력이 끝나면 입력을 눌러주세요"
        :invalid-feedback="feedback_text"
        :state="modal_state"
      >
        <b-input-group>
          <b-form-input
            id="input-1"
            v-model="phoneNum"
            :state="modal_state"
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
import { send_message } from "@/api/menu";

import { ref, computed } from "vue";
import { useStore } from "vuex";
export default {
  components: {
    ModalBase,
  },
  setup() {
    const store = useStore();
    const disease = computed(() => store.state.menuStore.disease);
    const r_num = computed(() => store.state.menuStore.r_num);

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
    return { store, disease, r_num, baseModal, show, confirm, cancel };
  },
  data() {
    return {
      phoneNum: "",
      feedback_text: "",
      modal_state: false,
    };
  },
  mount() {
    this.feedback_text = this.invalidFeedback();
    this.modal_state = this.state();
  },
  watch: {
    phoneNum: function () {
      this.feedback_text = this.invalidFeedback();
      this.modal_state = this.state();
    },
  },
  methods: {
    state() {
      return this.phoneNum.length >= 11;
    },

    invalidFeedback() {
      if (this.phoneNum.length > 0) {
        return "010-aaaa-bbbb 나 010aaaabbbb 형식의 전화번호를 입력해주세요";
      }
      return "전화번호를 입력해주세요.";
    },
    close_modal() {
      this.listnum = 0;
      this.selectNum = 0;
      this.phoneNum = "";
      this.cancel();
    },
    async send_message() {
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
      const data = {
        disease: this.disease,
        sidoCode: this.r_num,
        tel: pn,
      };
      console.log(data);
      console.log("-----");
      await send_message(
        data,
        (response) => {
          console.log(response);
          if (response.state === 200) {
            alert("등록이 완료되었습니다.");
            this.close_modal();
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

<style></style>

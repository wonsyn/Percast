<template>
  <modal-base ref="baseModal">
    <b-row>
      <b-col>
        <div class="header">
          <h1>{{ content.season }}</h1>
        </div>
      </b-col>
      <b-col style="text-align: end; vertical-align: middle">
        <a @click="close_modal()" style="cursor: pointer"
          ><svg
            width="35"
            height="35"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <g clip-path="url(#a)">
              <path
                d="m27.708 9.348-2.056-2.056-8.152 8.152-8.152-8.152-2.056 2.056 8.152 8.152-8.152 8.152 2.056 2.056 8.152-8.152 8.152 8.152 2.056-2.056-8.152-8.152 8.152-8.152Z"
                fill="#ffffff"
              />
            </g>
            <defs>
              <clipPath id="a"><path fill="#fff" d="M0 0h35v35H0z" /></clipPath>
            </defs>
          </svg>
        </a>
      </b-col>
    </b-row>
    <hr style="margin-top: 5px" />
    <b-row>
      <b-card
        class="body"
        style="
          background-color: #1a2844;
          margin: 10px, 10px, 10px, 10px;
          height: 58vh;
        "
      >
        <div>
          <b-button
            v-for="(item, index) in content.entity"
            :key="(item.index = index)"
            @click="selItem(index)"
            variant="outline-primary"
            style="border-color: white; color: white"
          >
            {{ item.name }}</b-button
          >
        </div>
        <b-card-body
          style="
            overflow: auto;
            height: 46vh;
            margin-top: 20px;
            border: solid 1px white;
            border-radius: 8px;
          "
        >
          <div id="introduction">
            <div v-for="item in content.entity[selectNum].explain" :key="item">
              {{ item }}
            </div>
          </div>
          <div id="main_subject">
            <about-modals-show-item-list
              v-for="item in content.entity[selectNum].elements"
              :key="item"
              v-bind="item"
            >
            </about-modals-show-item-list>
          </div>
        </b-card-body>
      </b-card>
    </b-row>
    <!-- <b-row>
      <b-card
        class="footer"
        style="background-color: #1a2844; margin-top: 20px"
      >
        <b-button @click="close_modal"> close </b-button>
      </b-card>
    </b-row> -->
  </modal-base>
</template>

<script>
import ModalBase from "@/components/about/modal/ModalBase.vue";
import AboutModalsShowItemList from "./AboutModalsShowItemList.vue";

import { ref } from "vue";
export default {
  components: {
    ModalBase,
    AboutModalsShowItemList,
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

<style>
.card-body::-webkit-scrollbar {
  width: 6px;
}
.card-body::-webkit-scrollbar-track {
  background-color: transparent;
}
.card-body::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: gray;
}
.card-body::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>

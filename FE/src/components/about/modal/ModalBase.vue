<template>
  <!-- teleport: 렌더링 시 위치를 지정합니다. -->
  <teleport to="body">
    <!-- Modal의 열리고 닫힘을 관리합니다. -->
    <div class="backdrop" v-if="isVisible" data-aos="zoom-in">
      <div class="modal-container">
        <!-- slot을 통해 BaseComponent를 확장시킵니다. -->
        <slot></slot>
      </div>
    </div>
  </teleport>
</template>

<script>
import { ref } from "vue";
import AOS from "aos";
import "aos/dist/aos.css";
export default {
  setup() {
    const isVisible = ref(false);

    // 부모 컴포넌트에서 접근하기 위한 함수를 선언합니다.
    const open = () => {
      isVisible.value = true;
    };

    const close = () => {
      isVisible.value = false;
    };

    // setup 함수에서 리턴해주어야, 부모 컴포넌트에서 접근이 가능합니다.
    return {
      isVisible,
      open,
      close,
    };
  },
  methods: {},
  created() {
    AOS.init();
  },
};
</script>

<style>
.backdrop {
  z-index: 999;
  display: flex;
  position: fixed;
  align-items: center;
  justify-content: center;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
}
.modal-container {
  background: #0f1421;
  min-width: 1000px;
  max-width: 1000px;
  min-height: 74vh;
  max-height: 74vh;
  width: 100%;
  padding: 1.5rem;
  border-radius: 8px;
  color: white;
}
.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 20px;
}
.black-bg {
  width: 100%;
  background: white;
  border-radius: 8px;
  padding: 20px;
}
</style>

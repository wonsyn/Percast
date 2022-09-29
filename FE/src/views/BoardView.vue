<template>
  <div class="d-flex justify-content-center mt-5">
    <router-link
      id="notice-menu"
      class="btn btn-success"
      to="/board/notice/list"
      @click="changeNotice"
      >공지사항</router-link
    >
    <div>&nbsp;|&nbsp;</div>
    <router-link
      id="qna-menu"
      class="btn btn-info"
      to="/board/qna/list"
      @click="changeQna"
      >QNA</router-link
    >
  </div>
  <div></div>
  <router-view></router-view>
</template>

<script>
export default {
  methods: {
    changeNotice() {
      const noticeBtn = document.getElementById("notice-menu");
      const qnaBtn = document.getElementById("qna-menu");
      noticeBtn.classList.remove("btn-info");
      qnaBtn.classList.remove("btn-success");
      noticeBtn.classList.add("btn-success");
      qnaBtn.classList.add("btn-info");
    },
    changeQna() {
      const noticeBtn = document.getElementById("notice-menu");
      const qnaBtn = document.getElementById("qna-menu");
      qnaBtn.classList.remove("btn-info");
      noticeBtn.classList.remove("btn-success");
      qnaBtn.classList.add("btn-success");
      noticeBtn.classList.add("btn-info");
    },
  },
};
</script>

<style scoped></style>

<template>
  <div>
    <div class="percast-font my-5" style="font-size: 50px; font-weight: bolder">
      공지사항
    </div>
    <div class="container">
      <div class="my-5 p-3 bg-secondary text-box">
        <strong>제목: {{ notice.title }}</strong>
        <div>작성일 {{ notice.date }}</div>
      </div>
      <div class="row p-3 bg-white text-box">
        <div class="col">
          <div height="300px">{{ notice.content }}</div>
        </div>
      </div>
      <div class="row">
        <div class="col d-flex my-3">
          <button class="btn btn-info" @click="moveToList">뒤로가기</button>
        </div>
        <div class="col d-flex justify-content-end my-3">
          <button class="btn btn-success me-2" depressed @click="moveToUpdate">
            수정
          </button>
          <button class="btn btn-danger" depressed @click="noticeDelete">
            삭제
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState("noticeStore", ["notice"]),
  },
  // props: {
  //   id: Number,
  // },
  created() {
    // actions로 noticeId값 보내기
    const pathName = new URL(document.location).pathname.split("/");
    const noticeId = pathName[pathName.length - 1];
    this.$store.dispatch("noticeStore/getNotice", noticeId);
  },
  methods: {
    async moveToList() {
      await this.$store.dispatch("noticeStore/getNotices");
      this.$router.push({
        name: "NoticeList",
      });
    },
    moveToUpdate() {
      this.$router.push({
        path: `/board/notice/update/${this.notice.id}`,
      });
    },
    async noticeDelete() {
      await this.$store.dispatch("noticeStore/deleteNotice", this.notice.id);
      await this.$store.dispatch("noticeStore/getNotices");
      this.$router.push({
        name: "NoticeList",
      });
    },
  },
};
</script>

<style scoped>
.text-box {
  border: white 1px solid;
  border-radius: 5px;
}
</style>

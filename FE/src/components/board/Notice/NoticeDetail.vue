<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="col d-flex mb-5">
          <button
            class="btn bg-yellow"
            depressed
            color="yellow"
            @click="moveToList"
          >
            뒤로가기
          </button>
        </div>
      </div>
      <div class="row mb-5">
        <div>
          {{ notice.title }}
          <div>작성일 {{ notice.date }}</div>
        </div>
      </div>
      <div class="row">
        <div class="col">
          <div height="300px">{{ notice.content }}</div>
        </div>
      </div>
      <div class="row">
        <div class="col d-flex justify-end mb-5">
          <button class="btn btn-success" depressed @click="moveToUpdate">
            수정
          </button>
          <button class="btn btn-danger" depressed @click="NoticeDelete">
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
  data() {
    return {
      idx: this.$route.params.id,
    };
  },
  props: {
    id: Number,
  },
  created() {
    // actions로 noticeId값 보내기
    // const pathName = new URL(document.location).pathname.split("/");
    // const noticeId = pathName[pathName.length - 1];
    this.$store.dispatch("/notice/detail", this.id);
  },
  methods: {
    moveToList() {
      this.$router.push({
        name: "NoticeList",
      });
    },
    moveToUpdate() {
      this.$router.push({
        path: `/notice/update/${this.notice.noticeId}`,
      });
    },
    NoticeDelete() {
      this.$store.dispatch("Notices/deleteNotice", this.notice.noticeId);
      this.$router.push("/notice");
    },
  },
};
</script>

<style scoped></style>

<template>
  <div class="container">
    <div class="percast-font my-5" style="font-size: 50px; font-weight: bolder">
      QNA
    </div>
    <div style="text-align: left">
      <div class="my-5 p-3 bg-secondary text-box percast-font">
        <strong>제목: {{ qna.title }}</strong>
        <div>작성일 {{ qna.date }}</div>
      </div>
      <div class="row p-3 bg-white text-box">
        <div class="col">
          <div height="300px">{{ qna.content }}</div>
        </div>
      </div>
    </div>
    <hr style="border: 0; height: 2px; background: white" />
    <div style="text-align: left">
      <div class="percast-font">
        <span style="font-weight: bolder; font-size: 20px">답변일시</span>
        {{ qna.answer.date }}
      </div>
      <div class="row mt-2 p-3 bg-white text-box">
        <div class="col">
          <div height="300px">{{ qna.answer.content }}</div>
        </div>
      </div>
      <hr style="border: 0; height: 2px; background: #f5f9ff" />
      <div class="row">
        <div class="col d-flex my-3">
          <button class="btn btn-info" @click="moveToList">뒤로가기</button>
        </div>
        <div class="col d-flex justify-content-end my-3">
          <button class="btn btn-success me-2" depressed @click="moveToUpdate">
            수정
          </button>
          <button class="btn btn-danger" depressed @click="qnaDelete">
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
    ...mapState("qnaStore", ["qna"]),
  },
  created() {
    // actions로 qnaId값 보내기
    const pathName = new URL(document.location).pathname.split("/");
    const qnaId = pathName[pathName.length - 1];
    this.$store.dispatch("qnaStore/getQna", qnaId);
  },
  methods: {
    async moveToList() {
      await this.$store.dispatch("qnaStore/getQnas");
      this.$router.push({
        name: "QnaList",
      });
    },
    moveToUpdate() {
      this.$router.push({
        path: `/board/qna/update/${this.qna.id}`,
      });
    },
    async qnaDelete() {
      await this.$store.dispatch("qnaStore/deleteQna", this.qna.id);
      await this.$store.dispatch("qnaStore/getQnas");
      this.$router.push("/qna/list");
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

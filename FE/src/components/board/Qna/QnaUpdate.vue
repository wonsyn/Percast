<template>
  <div>
    <div class="percast-font my-5" style="font-size: 50px; font-weight: bolder">
      QNA
    </div>
    <form ref="form">
      <div class="container">
        <div class="row"></div>
        <div class="my-3 d-flex">
          <label class="me-3 percast-font" for="title">제목</label>
          <input
            class="form-control"
            v-model="qna.title"
            name="title"
            placeholder="제목을 입력하세요."
            style="width: 95%"
            required
          />
        </div>
        <div class="my-3 d-flex">
          <label class="me-3 percast-font" for="content">내용</label>
          <b-form-textarea
            v-model="qna.content"
            name="content"
            rows="10"
            max-rows="20"
            placeholder="내용을 입력하세요."
            style="width: 95%"
            required
          >
          </b-form-textarea>
        </div>
        <div class="row">
          <div class="col d-flex my-3">
            <button type="button" class="btn btn-info" @click="moveToList">
              뒤로가기
            </button>
          </div>
          <div class="col d-flex justify-content-end my-3">
            <button type="button" class="btn btn-success" @click="updateQna">
              수정
            </button>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "QnaUpdate",

  computed: {
    ...mapState("qnaStore", ["qna"]),
  },
  data() {
    return {
      content: "",
    };
  },

  methods: {
    async moveToList() {
      await this.$store.dispatch("qnaStore/getQnas");
      this.$router.push({
        name: "QnaList",
      });
    },
    async updateQna() {
      await this.$store.dispatch("qnaStore/updateQna", this.qna);
      await this.$store.dispatch("qnaStore/getQna", this.qna.id);
      this.$router.push({
        path: `/board/qna/detail/${this.qna.id}`,
      });
    },
  },
};
</script>

<style scoped></style>

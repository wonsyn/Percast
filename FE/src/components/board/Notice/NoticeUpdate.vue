<template>
  <div>
    <div class="percast-font my-5" style="font-size: 50px; font-weight: bolder">
      공지사항
    </div>
    <form ref="form" lazy-validation>
      <div class="container">
        <div class="row"></div>
        <div class="my-3 d-flex">
          <label class="me-3 percast-font" for="title">제목</label>
          <input
            class="form-control"
            v-model="notice.title"
            name="title"
            placeholder="제목을 입력하세요."
            style="width: 95%"
            required
          />
        </div>
        <div class="my-3 d-flex">
          <label class="me-3 percast-font" for="content">내용</label>
          <b-form-textarea
            v-model="notice.content"
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
            <button type="button" class="btn btn-success" @click="updateNotice">
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
  name: "NoticeUpdate",

  computed: {
    ...mapState("noticeStore", ["notice"]),
  },
  data() {
    return {
      valid: true,
      content: "",
    };
  },

  methods: {
    moveToList() {
      this.$router.push({
        name: "NoticeList",
      });
    },
    validate() {
      this.$refs.form.validate();
    },
    async updateNotice() {
      console.log("updateNotice");
      await this.$store.dispatch("noticeStore/updateNotice", this.notice);
      await this.$store.dispatch("noticeStore/getNotice", this.notice.id);
      this.$router.push({
        path: `/board/notice/detail/${this.notice.id}`,
      });
    },
  },
};
</script>

<style scoped></style>

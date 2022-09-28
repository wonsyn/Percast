<template>
  <div class="container">
    <form v-on:submit="writeNotice" class="mt-5" ref="form">
      <div class="my-3 d-flex">
        <label class="me-3 percast-font" for="title">제목</label>
        <input
          class="form-control"
          placeholder="제목을 입력해 주세요"
          name="title"
          v-model="title"
          style="width: 90%"
        />
      </div>
      <div class="my-3 d-flex">
        <label class="me-3 percast-font" for="content">내용</label>
        <b-form-textarea
          name="content"
          placeholder="내용을 입력해 주세요"
          v-model="content"
          rows="3"
          max-rows="6"
          style="width: 90%"
        ></b-form-textarea>
      </div>
      <div class="d-flex justify-content-end pe-3 mb-6">
        <button type="submit" class="btn btn-success d-flex justify-end">
          등록
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "NoticeWrite.vue",
  data() {
    return {
      title: "",
      content: "",
    };
  },
  methods: {
    writeNotice() {
      const newNotice = {
        title: this.title,
        content: this.content,
      };
      this.$store.dispatch("noticeStore/registNotice", newNotice);
      this.$store.dispatch("noticeStore/getNotices");
      this.$router.push("/notice/list");
    },
  },
};
</script>

<style scoped></style>

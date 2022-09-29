<template>
  <div class="container">
    <div class="percast-font my-5" style="font-size: 50px; font-weight: bolder">
      공지사항
    </div>
    <form v-on:submit.prevent="writeNotice" class="mt-5" ref="form">
      <div class="my-3 d-flex">
        <label class="me-3 percast-font" for="title">제목</label>
        <input
          class="form-control"
          placeholder="제목을 입력해 주세요"
          name="title"
          v-model="title"
          style="width: 95%"
          required
        />
      </div>
      <div class="my-3 d-flex">
        <label class="me-3 percast-font" for="content">내용</label>
        <b-form-textarea
          name="content"
          placeholder="내용을 입력해 주세요"
          v-model="content"
          rows="10"
          max-rows="20"
          style="width: 95%"
          required
        ></b-form-textarea>
      </div>
      <div class="row">
        <div class="col d-flex my-3">
          <button class="btn btn-info" @click="moveToList">뒤로가기</button>
        </div>
        <div class="col d-flex justify-content-end my-3">
          <button type="submit" class="btn btn-success">등록</button>
        </div>
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
    moveToList() {
      this.$router.push({
        name: "NoticeList",
      });
    },
    writeNotice() {
      const newNotice = {
        title: this.title,
        content: this.content,
      };
      this.$store.dispatch("noticeStore/registNotice", newNotice);
      this.$store.dispatch("noticeStore/getNotices");
      this.$router.push({
        name: "NoticeList",
      });
    },
  },
};
</script>

<style scoped></style>

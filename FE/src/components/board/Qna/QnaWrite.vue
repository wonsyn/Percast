<template>
  <div class="container">
    <div class="percast-font my-5" style="font-size: 50px; font-weight: bolder">
      QNA
    </div>
    <form v-on:submit.prevent="writeQna" class="mt-5" ref="form">
      <div class="my-3 d-flex">
        <label class="me-3 percast-font" for="password">암호</label>
        <input
          class="form-control"
          placeholder="암호를 입력해 주세요"
          name="password"
          type="password"
          v-model="password"
          style="width: 20%"
          required
        />
      </div>
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
  name: "QnaWrite.vue",
  data() {
    return {
      title: "",
      content: "",
      password: "",
    };
  },
  methods: {
    moveToList() {
      this.$router.push({
        name: "QnaList",
      });
    },
    async writeQna() {
      const newQna = {
        title: this.title,
        content: this.content,
        password: this.password,
      };
      await this.$store.dispatch("qnaStore/registQna", newQna);
      await this.$store.dispatch("qnaStore/getQnas");
      this.$router.go(-1);
    },
  },
};
</script>

<style scoped></style>

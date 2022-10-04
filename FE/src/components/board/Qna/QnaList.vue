<template>
  <div class="container pt-5">
    <strong class="percast-font" style="font-size: 50px">QNA</strong>
    <div class="pt-5 pb-3">
      <div class="d-flex justify-content-end me-3 mb-3">
        <button class="btn btn-success" @click="moveToWrite">글작성</button>
      </div>
      <table class="table percast-font">
        <thead>
          <tr class="bg-info">
            <th class="col-3">글번호</th>
            <th class="col-6">제목</th>
            <th class="col-3">작성날짜</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="qna in qnas"
            :key="qna.id"
            @click="moveToDetail(qna.id)"
            style="cursor: pointer"
          >
            <td style="margin-top: 11px">{{ qna.id }}</td>
            <td>
              {{ qna.title }}
            </td>
            <td>
              {{ qna.date }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "QnaList",
  computed: {
    ...mapState("qnaStore", ["qnas"]),
  },
  async created() {
    await this.$store.dispatch("qnaStore/getQnas");
  },
  methods: {
    moveToDetail(id) {
      this.$router.push({
        path: `/board/qna/detail/${id}`,
      });
    },
    moveToWrite() {
      this.$router.push({
        path: "write",
      });
    },
  },
};
</script>

<style scoped>
#title {
  text-align: center;
  color: #2c3e50;
  justify-content: center;
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  line-height: 48px;
}
</style>

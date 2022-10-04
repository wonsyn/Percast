<template>
  <div class="container pt-5">
    <strong class="percast-font" style="font-size: 50px">공지사항</strong>
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
            v-for="notice in notices"
            :key="notice.id"
            @click="moveToDetail(notice.id)"
            style="cursor: pointer"
          >
            <td style="margin-top: 11px">{{ notice.id }}</td>
            <td>
              {{ notice.title }}
            </td>
            <td>
              {{ notice.date }}
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
  name: "NoticeList",
  computed: {
    ...mapState("noticeStore", ["notices"]),
  },
  async created() {
    await this.$store.dispatch("noticeStore/getNotices");
  },
  methods: {
    moveToDetail(id) {
      this.$router.push({
        path: `/board/notice/detail/${id}`,
      });
    },
    moveToWrite() {
      this.$router.push({
        name: "NoticeWrite",
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

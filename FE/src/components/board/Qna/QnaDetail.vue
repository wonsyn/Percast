<template>
  <div class="container">
    <div class="percast-font my-5" style="font-size: 50px; font-weight: bolder">
      QNA
    </div>

    <div style="text-align: left">
      <div class="my-5 p-3 bg-secondary text-box percast-font">
        <strong>제목: {{ qna.title }}</strong>
        <div>작성일(마지막 수정일) {{ qna.date }}</div>
      </div>
      <div class="row p-3 bg-white text-box">
        <div class="col">
          <div style="height: 200px">{{ qna.content }}</div>
        </div>
      </div>
      <div class="col d-flex justify-content-end my-3">
        <button class="btn btn-success me-2" @click="moveToUpdate">수정</button>
        <button class="btn btn-danger" @click="qnaDelete">삭제</button>
      </div>
    </div>

    <hr style="border: 0; height: 2px; background: white" />

    <div v-if="qna.answer != null" style="text-align: left">
      <div class="percast-font">
        <span style="font-weight: bolder; font-size: 20px">답변일시</span>
        (마지막 수정일) {{ qna.answer.date }}
      </div>
      <div class="row mt-2 mb-3 p-3 bg-white text-box">
        <div class="col">
          <div height="300px" v-if="!toggleAnswerForm">
            {{ qna.answer.content }}
          </div>
          <div v-else>
            <textarea
              id="edit-answer-input"
              class="me-5"
              :value="qna.answer.content"
              placeholder="답변을 입력하세요."
              style="width: 80%; min-height: 100px"
            />
            <button class="btn btn-success me-2" @click="updateAnswer">
              수정완료
            </button>
            <button class="btn btn-danger" @click="toggleAnswerUpdate">
              취소
            </button>
          </div>
        </div>
      </div>
      <div
        v-if="admin && !toggleAnswerForm"
        class="col d-flex justify-content-end mb-3"
      >
        <button class="btn btn-success me-2" @click="toggleAnswerUpdate">
          답변 수정
        </button>
        <button class="btn btn-danger" @click="answerDelete">답변 삭제</button>
      </div>
    </div>

    <div v-else class="percast-font" style="font-size: 20px">
      <div v-if="!toggleAnswerForm">
        <div>작성된 답변이 없습니다.</div>
      </div>
      <div v-else>
        <textarea
          v-model="answerContent"
          id="edit-answer-input"
          class="me-5"
          placeholder="답변을 입력하세요."
          style="width: 80%; min-height: 100px"
        ></textarea>
      </div>
      <hr style="border: 0; height: 2px; background: #f5f9ff" />
      <div class="d-flex justify-content-end">
        <button class="btn btn-success me-2" @click="toggleAnswerUpdate">
          답변 등록
        </button>
      </div>
    </div>
    <div class="row">
      <div class="col d-flex mt-3 mb-5">
        <button class="btn btn-info" @click="moveToList">뒤로가기</button>
      </div>
    </div>
  </div>
  <qna-password-modal
    ref="modal"
    :qna-id="qna.id"
    :type="type"
  ></qna-password-modal>
</template>

<script>
import { ref } from "vue";
import { mapState } from "vuex";
import QnaPasswordModal from "@/components/menu/items/modal/QnaPasswordModal";

export default {
  computed: {
    ...mapState("qnaStore", ["qna"]),
    ...mapState("adminStore"["admin"]),
  },
  components: {
    QnaPasswordModal,
  },
  data() {
    return {
      answerContent: "",
      toggleAnswerForm: false,
      admin: String,
      qnaId: String,
      type: "",
    };
  },
  setup() {
    const modal = ref(null);

    const showModal = async () => {
      await modal.value.show();
    };

    return { modal, showModal };
  },
  created() {
    // actions로 qnaId값 보내기
    this.qnaId = new URL(document.location).pathname.split("/")[
      new URL(document.location).pathname.split("/").length - 1
    ];
    this.$store.dispatch("qnaStore/getQna", this.qnaId);
    this.admin = sessionStorage.getItem("admin");
  },
  mounted() {
    if (this.qna.answer != null) {
      this.answerContent = this.qna.answer.content;
    } else {
      this.answerContent = "";
    }
  },
  methods: {
    async toggleAnswerUpdate() {
      if (!sessionStorage.getItem("admin")) {
        alert("권한이 없습니다.");
        return;
      }
      if (this.toggleAnswerForm) {
        console.log("answerContent====", this.answerContent);
        const answer = {
          content: this.answerContent,
          qnaId: this.qnaId,
        };
        await this.$store.dispatch("qnaStore/registAnswer", answer);
        await this.$store.dispatch("qnaStore/getQna", this.qnaId);
        this.answerContent = this.qna.answer.content;
      }
      this.toggleAnswerForm = !this.toggleAnswerForm;
      console.log(this.toggleAnswerForm);
    },
    async moveToList() {
      await this.$store.dispatch("qnaStore/getQnas");
      this.answerContent = "";
      this.$router.push({
        name: "QnaList",
      });
    },
    moveToUpdate() {
      this.type = "update";
      this.showModal();
    },
    async qnaDelete() {
      this.type = "delete";
      this.showModal();
    },
    async answerDelete() {
      if (!sessionStorage.getItem("admin")) {
        alert("권한이 없습니다.");
        return;
      }

      const params = {
        qnaId: this.qna.id,
        answerId: this.qna.answer.id,
      };
      await this.$store.dispatch("qnaStore/deleteAnswer", params);
      await this.$store.dispatch("qnaStore/getQna", this.qna.id);
      this.answerContent = "";
    },
    async updateAnswer() {
      this.qna.answer.content =
        document.getElementById("edit-answer-input").value;
      await this.$store.dispatch("qnaStore/updateAnswer", this.qna.answer);
      this.toggleAnswerForm = !this.toggleAnswerForm;
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

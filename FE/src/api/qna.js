import { api } from "./index.js";

async function get_qnas(success, fail) {
  await api.get(`/qna`).then(success).catch(fail);
}
async function get_qna(id, success, fail) {
  await api
    .get(`/qna/detail`, { params: { qnaId: id } })
    .then(success)
    .catch(fail);
}
async function regist_qna(body, success, fail) {
  await api.post(`/qna`, JSON.stringify(body)).then(success).catch(fail);
}
async function update_qna(body, success, fail) {
  await api.put(`/qna`, JSON.stringify(body)).then(success).catch(fail);
}
async function delete_qna(id, success, fail) {
  await api.delete(`/qna/${id}`).then(success).catch(fail);
}

async function regist_answer(body, success, fail) {
  // console.log(this.$store);
  // console.log(store.state.adminStore.admin);
  await api
    .post(`/qna/answer`, JSON.stringify(body), {
      headers: { Authorization: sessionStorage.getItem("admin") },
    })
    .then(success)
    .catch(fail);
}
async function update_answer(body, success, fail) {
  await api
    .put(`/qna/answer`, JSON.stringify(body), {
      headers: { Authorization: sessionStorage.getItem("admin") },
    })
    .then(success)
    .catch(fail);
}
async function delete_answer(qnaId, answerId, success, fail) {
  const params = {
    qnaid: qnaId,
    answerid: answerId,
  };
  await api
    .delete(`/qna/answer`, {
      params,
      headers: { Authorization: sessionStorage.getItem("admin") },
    })
    .then(success)
    .catch(fail);
}
async function auth_qna(body, success, fail) {
  await api
    .post(`/qna/password`, JSON.stringify(body))
    .then(success)
    .catch(fail);
}

export {
  get_qna,
  get_qnas,
  regist_qna,
  update_qna,
  delete_qna,
  regist_answer,
  update_answer,
  delete_answer,
  auth_qna,
};

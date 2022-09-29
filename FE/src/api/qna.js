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
  await api
    .post(`/qna`, JSON.stringify(body), {
      headers: { Authorization: "62eea8bcaa5128173f599239ad19a041" },
    })
    .then(success)
    .catch(fail);
}
async function update_qna(body, success, fail) {
  await api
    .put(`/qna`, body, {
      headers: { Authorization: "62eea8bcaa5128173f599239ad19a041" },
    })
    .then(success)
    .catch(fail);
}
async function delete_qna(id, success, fail) {
  await api
    .delete(`/qna/${id}`, {
      headers: { Authorization: "62eea8bcaa5128173f599239ad19a041" },
    })
    .then(success)
    .catch(fail);
}

export { get_qna, get_qnas, regist_qna, update_qna, delete_qna };

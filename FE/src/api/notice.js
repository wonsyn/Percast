import { api } from "./index.js";
async function get_notices(success, fail) {
  await api.get(`/notice`).then(success).catch(fail);
}
async function get_notice(id, success, fail) {
  await api.get(`/notice/${id}`).then(success).catch(fail);
}
async function regist_notice(body, success, fail) {
  await api
    .post(`/notice`, JSON.stringify(body), {
      headers: { Authorization: "62eea8bcaa5128173f599239ad19a041" },
    })
    .then(success)
    .catch(fail);
}
async function update_notice(body, success, fail) {
  await api
    .put(`/notice`, body, {
      headers: { Authorization: "62eea8bcaa5128173f599239ad19a041" },
    })
    .then(success)
    .catch(fail);
}
async function delete_notice(id, success, fail) {
  await api
    .delete(`/notice/${id}`, {
      headers: { Authorization: "62eea8bcaa5128173f599239ad19a041" },
    })
    .then(success)
    .catch(fail);
}

export { get_notice, get_notices, regist_notice, update_notice, delete_notice };

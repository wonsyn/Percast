//import { apiInstance } from "./index.js";
//const api = apiInstance();
import { api } from "./index.js";

// 로그인
async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

// 회원정보 받아오기
async function getUserInfo(userid, success, fail) {
  await api.get(`/user?email=${userid}`).then(success).catch(fail);
}

// 회원정보 수정(완)
async function modifyMember(user, success, fail) {
  // 수정할 유저 정보 전체를 보낸다.
  await api.put(`/user`, JSON.stringify(user)).then(success).catch(fail);
}

// 비밀번호 수정(완)
async function modifyPassword(password, success, fail) {
  // 수정할 유저 정보 전체를 보낸다.
  await api
    .put(`/user/password`, JSON.stringify(password))
    .then(success)
    .catch(fail);
}

// 회원가입
async function registMember(user, success, fail) {
  await api.post(`/user`, JSON.stringify(user)).then(success).catch(fail);
}
// 회원탈퇴
async function userDelete(userid, success, fail) {
  await api.delete(`/user/${userid}`).then(success).catch(fail);
}

export {
  login,
  getUserInfo,
  modifyMember,
  modifyPassword,
  registMember,
  userDelete,
};

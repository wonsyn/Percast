//import { apiInstance } from "./index.js";
//const api = apiInstance();
import { api } from "./index.js";

async function get_env(sidoCode, success, fail) {
  await api.get(`/input/env?sidoCode=${sidoCode}`).then(success).catch(fail);
}

async function get_data(success, fail) {
  await api.get(`/output`).then(success).catch(fail);
}

async function send_message(data, success, fail) {
  console.log(data);
  await api.post(`/message`, JSON.stringify(data)).then(success).catch(fail);
  // await api.get(`/message?requestDto=${data}`).then(success).catch(fail);
}

async function get_twit(disease, success, fail) {
  await api.get(`/twit?disease=${disease}`).then(success).catch(fail);
}
export { get_env, get_data, send_message, get_twit };

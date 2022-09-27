//import { apiInstance } from "./index.js";
//const api = apiInstance();
import { api } from "./index.js";

async function get_env(sidoCode, success, fail) {
  await api.get(`/input/env?sidoCode=${sidoCode}`).then(success).catch(fail);
}

async function get_data(success, fail) {
  await api.get(`/output`).then(success).catch(fail);
}

export { get_env, get_data };

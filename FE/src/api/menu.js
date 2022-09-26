//import { apiInstance } from "./index.js";
//const api = apiInstance();
import { api } from "./index.js";

// 로그인
async function get_weather(user, success, fail) {
  await api.get(``, JSON.stringify(user)).then(success).catch(fail);
}

async function get_environment(user, success, fail) {
  await api.get(``, JSON.stringify(user)).then(success).catch(fail);
}

export { get_weather, get_environment };

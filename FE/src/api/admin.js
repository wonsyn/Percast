import { api } from "./index.js";

async function adminLogin(password, success, fail) {
  await api.post(`/admin`, password).then(success).catch(fail);
}

export { adminLogin };

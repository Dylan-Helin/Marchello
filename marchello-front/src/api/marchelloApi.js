import Vue from 'vue';
const BASE_URL = 'http://localhost:5000/messages';

export default {
  getAllMessage() {
    return Vue.http.get(`${BASE_URL}`);
  },
  createMessage(message) {
    return Vue.http.post(`${BASE_URL}`, {
      ...message
    });
  }
};

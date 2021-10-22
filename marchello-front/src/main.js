import Vue from 'vue';
import App from './App.vue';
import VueResource from 'vue-resource';

import router from './router';
import upperCaseFilter from './utils/filter';
Vue.config.productionTip = false;
Vue.use(VueResource);
// Add filter to Vue instance
Vue.filter('upperCaseFilter', upperCaseFilter);

new Vue({
  router,
  render: h => h(App)
}).$mount('#app');

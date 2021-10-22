import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import MarchelloChat from '../components/MarchelloChat.vue';
import MarchelloMemory from '../components/MarchelloMemory.vue';
import VueResource from "vue-resource";

Vue.use(VueRouter);
Vue.use(VueResource);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: [
      {
        path: '/',
        name: 'MarchelloChat',
        component: MarchelloChat
      },
      {
        path: '/memory',
        name: 'MarchelloMemory',
        component: MarchelloMemory
      }
    ]
  },
  {
    path: '*',
    redirect: '/'
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;

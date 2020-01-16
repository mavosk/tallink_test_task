import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import RegisterConference from '../components/RegisterConference.vue'
import CancelConference from "../components/CancelConference";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/registerConference',
    name: 'registerConference',
    component: RegisterConference
  },
  {
    path: '/cancelConference',
    name: 'cancelConference',
    component: CancelConference
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

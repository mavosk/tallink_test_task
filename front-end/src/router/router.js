import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import RegisterConference from '../components/RegisterConference.vue'
import ManageConference from "../components/ManageConference";
import ViewConference from "../components/ViewConference";

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
    path: '/manageConference',
    name: 'manageConference',
    component: ManageConference
  },
    ,
    {
        path: '/viewConference/:id',
        name: 'viewConference',
        component: ViewConference
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

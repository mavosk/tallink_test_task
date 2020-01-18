import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import { Datetime } from 'vue-datetime'
// You need a specific loader for CSS files
import 'vue-datetime/dist/vue-datetime.css'


Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(Datetime);



Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');

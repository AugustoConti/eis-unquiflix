import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'bootstrap/scss/bootstrap.scss'
import 'mdbootstrap/scss/mdb.scss'
import 'mdbootstrap/scss/style.scss'
import 'open-iconic/font/css/open-iconic-bootstrap.min.css'
import VModal from 'vue-js-modal'

Vue.use(VModal)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')


import Vue from 'vue'
import Router from 'vue-router'
import component1 from '@/components/component1.vue'
import component2 from '@/components/component2.vue'
import Top from '@/components/Top.vue'
import login from '@/components/login.vue'
import Pelicula from '@/components/Pelicula.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/component1',
      name: 'component1',
      component: component1
    },
    {
      path: '/component2',
      name: 'component2',
      component: component2
    },
    {
      path: '/pelicula',
      name: 'pelicula',
      component: Pelicula
    },
    {
      path: '/top',
      name: 'top',
      component: Top
    },
    {
      path: '/',
      name: 'login',
      component: login
    }
  ]
})

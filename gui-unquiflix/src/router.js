import Vue from 'vue'
import Router from 'vue-router'
// import Home from './views/Home.vue'
import ingreso from '@/components/ingreso.vue'
import component1 from '@/components/component1.vue'
import component2 from '@/components/component2.vue'
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
      path: '/',
      name: 'ingreso',
      component: ingreso
    }
   // {
    //  path: '/about',
     // name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
     // component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    //}
  ]
})

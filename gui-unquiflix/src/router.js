import Vue from 'vue'
import Router from 'vue-router'
// import Home from './views/Home.vue'
import ingreso from '@/components/ingreso.vue'
import componente1 from '@/components/component1.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/component1',
      name: 'component1',
      component: componente1
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

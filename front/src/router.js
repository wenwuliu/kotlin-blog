import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import articleList from '@/views/article/articleList'
import articleDetails from '@/views/article/articleDetails'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/home',
      name: 'home',
      meta: {
        requireAuth: true
      },
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/register')
    },
    {
      path: '/articleList',
      name: 'articleList',
      meta: {
        requireAuth: true
      },
      component: articleList
    },
    {
      path: '/articleDetails',
      name: 'articleDetails',
      meta: {
        requireAuth: true
      },
      component: articleDetails
    },
    {
      path: '/games/word',
      name: 'gameword',
      meta: {
        requireAuth: true
      },
      component: () => import('@/views/games/word')
    },
    {
      path: '*',
      name: 'home',
      meta: {
        requireAuth: true
      },
      component: Home
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (sessionStorage.getItem('token')) {
      next()
    } else {
      next({
        path: '/login',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
})

export default router

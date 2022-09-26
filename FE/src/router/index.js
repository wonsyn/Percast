import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('@/views/AboutView.vue')
  },
  {
    path: '/menu',
    name: 'menu',
    component:() => import(`@/views/MenuView.vue`),
  },
  {
    path: '/chat',
    name:'chat',
    component:()=>import("@/views/ChatView.vue"),
    redirect:{name:'chatmain'},
    children:[
      {
        path:'/chat/main',
        name:'chatmain',
        component:()=>import("@/components/chatBot/ChatMain.vue"),
      },
    ],
  },
  {
    path:'/maps',
    name:'map',
    component:()=>import("@/views/MapView.vue"),
  },
  {
    path:'/board',
    name:'board',
    component:()=>import("@/views/BoardView.vue"),
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    component: () => import("@/views/AboutView.vue"),
  },
  {
    path: "/menu",
    name: "menu",
    component: () => import(`@/views/MenuView.vue`),
  },
  {
    path: "/maps",
    name: "map",
    component: () => import("@/views/MapView.vue"),
  },
  {
    path: "/board",
    name: "board",
    redirect: "/board/notice/list",
    component: () => import("@/views/BoardView.vue"),
    children: [
      {
        path: "notice/list",
        name: "NoticeList",
        component: () => import("@/components/board/Notice/NoticeList.vue"),
      },
      {
        path: "notice/update/:id",
        name: "NoticeUpdate",
        component: () => import("@/components/board/Notice/NoticeUpdate.vue"),
      },
      {
        path: "notice/write",
        name: "NoticeWrite",
        component: () => import("@/components/board/Notice/NoticeWrite.vue"),
      },
      {
        path: "notice/detail/:id",
        name: "NoticeDetail",
        component: () => import("@/components/board/Notice/NoticeDetail.vue"),
      },
      {
        path: "qna/list",
        name: "QnaList",
        component: () => import("@/components/board/Qna/QnaList.vue"),
      },
      {
        path: "qna/update/:id",
        name: "QnaUpdate",
        component: () => import("@/components/board/Qna/QnaUpdate.vue"),
      },
      {
        path: "qna/write",
        name: "QnaWrite",
        component: () => import("@/components/board/Qna/QnaWrite.vue"),
      },
      {
        path: "qna/detail/:id",
        name: "QnaDetail",
        component: () => import("@/components/board/Qna/QnaDetail.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;

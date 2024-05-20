import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import YoutubeView from '@/views/YoutubeView.vue'
import VideoView from '@/views/VideoView.vue'
import ReviewView from '@/views/ReviewView.vue'
import KakaoView from '@/views/KakaoView.vue'

import VideoDetail from '@/components/video/VideoDetail.vue'

import ReviewList from '@/components/review/ReviewList.vue'
import ReviewRegist from '@/components/review/ReviewRegist.vue'

import UserView from '@/views/UserView.vue'
import Login from '@/components/user/Login.vue'
import Signup from '@/components/user/Signup.vue'

import commentView from '@/views/CommentView.vue'

import MyPageView from '@/views/MyPageView.vue'
import MyPageMainView from '@/components/mypage/myPageMain.vue'
import MyPageCommentListView from '@/components/mypage/myPageCommentList.vue'
import MyPageJjimListView from '@/components/mypage/myPageJjimList.vue'
import MyPageInfoChangeView from '@/components/mypage/myPageInfoChange.vue'
import MyPageFriendsView from '@/components/mypage/myPageFriends.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/youtube',
      name: 'youtube',
      component: YoutubeView,
    },
    {
      path: '/map',
      name: 'map',
      component: KakaoView,
    },
    {
      path: '/video',
      name: 'video',
      component: VideoView,
      children:[
        {
          path: ':id',
          name: 'videoDetail',
          component: VideoDetail
        }
      ]
    },
    {
      path: '/user-api',
      name: 'user',
      component: UserView,
      children: [
        {
          path: "login",
          name: 'login',
          component: Login
        },
        {
          path: "signup",
          name: 'signup',
          component: Signup
        }
      ]
    },
    {
      path: '/review',
      name: 'review',
      component: ReviewView,
      children:[
        {
          path: '',
          name: 'reviewList',
          component: ReviewList
        },
        {
          path:'regist',
          name:'reviewRegist',
          component: ReviewRegist,
        },
      ]
    },
    {
      path: '/comment',
      name: 'comment',
      component: commentView,
      children:[
      ]
    },
    {
      path: '/myPage',
      name: 'myPage',
      component: MyPageView,
      children:[
        {
          path: ':id',
          name: 'myPageMain',
          component: MyPageMainView
        },
        {
          path: 'commentList',
          name: 'commentList',
          component: MyPageCommentListView
        },
        {
          path: 'jjimList',
          name: 'jjimList',
          component: MyPageJjimListView
        },
        {
          path: 'infoChange',
          name: 'infoChange',
          component: MyPageInfoChangeView
        },
        {
          path: 'friends/:id',
          name: 'friends',
          component: MyPageFriendsView
        },
      ]
    },
  ]
})

export default router

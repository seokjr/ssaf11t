import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';
import router from '@/router'

export const useUserStore = defineStore('user', () => {
  const REST_USER_API = 'http://localhost:8080/user-api/'
  const user = ref(null)

  // 세션 스토리지에서 사용자 정보 확인
  const checkSession = function() {
    const userData = sessionStorage.getItem('user')
    if (userData) {
      user.value = JSON.parse(userData)
    }
  }
  checkSession()
  const getUser = () => user.value;

  const login = function(userData) {
    axios({
      url: `${REST_USER_API}login`,
      method: 'POST',
      data: userData
    })
    .then((response) => {
      user.value = response.data
      // 세션 스토리지에 사용자 정보 저장
      // sessionStorage.setItem('user', JSON.stringify(response.data))
      const userNow = {
        id : response.data.id, nickname : response.data.nickname, name : response.data.name
      }
      sessionStorage.setItem('user', JSON.stringify(userNow))
      alert('로그인 성공')
      window.location.href = '/';
    })
    .catch((error) => {
      // console.error('에러 발생', error);
      alert('입력하신 정보를 다시 확인해주세요.')
    })
  };

  const logout = function() {
    const URL = 'http://localhost:8080/user-api/logout'
    axios.get(URL)
        .then(() => {
          // 세션 스토리지에서 사용자 정보 제거
          sessionStorage.removeItem('user')
          user.value = null
          alert('로그아웃 하셨습니다.')
          window.location.href = '/';
        })
        .catch((error) => {
          console.error('에러 발생', error);
        })
  };

  const signup = function(user) {
    const URL = 'http://localhost:8080/user-api/signup'
    axios({
      url: `${REST_USER_API}signup`,
      method: 'POST',
      data: user
    })
    .then((response) => {
      // user.value = response.data
      // sessionStorage.setItem('user', JSON.stringify(response.data))
      alert('회원가입 성공')
      router.push({name: 'login'})
    })
    .catch((error) => {
      // console.error('에러 발생', error);
      alert(error.response.data);
    })
  };

  const userInfo = ref(null);
  const getUserInfo = function(userId) {
    axios({
      url: `${REST_USER_API}userInfo/${userId}`,
      method: 'get',
    })
    .then((response) => {
      userInfo.value = response.data;
    })
    .catch((error) => {
      alert(error.response.data);
    })
  }

  return { user, login, logout, signup, getUser, getUserInfo, userInfo }
})

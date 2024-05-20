import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

export const useFriendStore = defineStore('friend', () => {
  const REST_Friend_API = 'http://localhost:8080/friendship-api/friend/'

  // id, nickname을 키로 가지는 user에 대한 배열{id:'ssafy', nickname:'ssafy'}
  const friendsList = ref([]);
  const waitingFriendsList = ref([]);

  // 초기에 친구 관련 정보 받아오기(onMount)
  const getAboutfriends = function(id) {
    axios({
      url: `${REST_Friend_API}accept/${id}`,
      method: 'GET',
    })
    .then((response) => {
      friendsList.value = response.data
      // console.log(response.data)
    })
    .catch((error) => {
      friendsList.value = [];
    })
    axios({
      url: `${REST_Friend_API}pending/${id}`,
      method: 'GET',
    })
    .then((response) => {
      waitingFriendsList.value = response.data
      // console.log(response.data)
    })
    .catch((error) => {
      waitingFriendsList.value = [];
    })
  }

  // 친구 요청 넣기
  const insertRequest = function(my_id, your_id) {
    axios({
      url: `${REST_Friend_API}insert`,
      method: 'POST',
      data: {user1Id: my_id, user2Id: your_id}
    })
    .then((response) => {
      console.log('요청 완료')
    })
    .catch((error) => {
      alert(error.response.data)
    })
  }

  // 친구 요청 수락
  const acceptRequest = function(my_id, your_id) {
    axios({
      url: `${REST_Friend_API}accept`,
      method: 'POST',
      data: {user1Id: your_id, user2Id: my_id}
    })
    .then((response) => {
      console.log('수락 완료')
    })
    .catch((error) => {
      alert(error.response.data)
    })
  }

  // 친구/친구 요청 삭제
  const deleteRequest = function(my_id, your_id) {
    axios({
      url: `${REST_Friend_API}delete`,
      method: 'POST',
      data: {user1Id: my_id, user2Id: your_id}
    })
    .then((response) => {
      alert('삭제 완료')
    })
    .catch((error) => {
      alert(error.response.data)
    })
  }

  return {
    friendsList,
    waitingFriendsList,
    getAboutfriends,
    insertRequest,
    acceptRequest,
    deleteRequest
  }
})

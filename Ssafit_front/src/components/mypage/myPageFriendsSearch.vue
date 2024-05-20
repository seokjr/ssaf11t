<template>
    <div class="container">
      <h4 class="text-center">친구 검색</h4>
      <br>
      <div class="row justify-content-center align-items-center">
        <div class="col-2">
          <select class="form-select" v-model="searchInfo.key">
            <option value="id">아이디</option>
            <option value="nickname">닉네임</option>
          </select>
        </div>
        <div class="col-6">
          <input type="text" class="form-control" v-model="searchInfo.word" @keyup.enter="searchUserList"/>
        </div>
        <div class="col-auto">
          <button class="btn btn-primary custom-btn" @click="searchUserList">검색</button>
        </div>
      </div>
      <br><br>
        <div v-for="someone of store.userSearchResultList" :key="someone.id">
            <myPageFriendsItem :someone="someone" :my_id="props.id" :type="'someone'"/>
        </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from "vue";
  import { useUserStore } from '@/stores/userStore';
  import myPageFriendsItem from './myPageFriendsItem.vue';
  
  const store = useUserStore();
  const searchInfo = ref({
    key: "id",
    word: ""
  });
  const props = defineProps({
    'id' : {
        type : String,
        required : true
    }
});

  const searchUserList = function () {
    store.getUserSearchList(searchInfo.value);
  };
  </script>
  
  <style scoped>
  .container {
    max-width: 800px;
    margin: 0 auto;
  }
  .custom-btn {
    width: 80px;
  }
  </style>  
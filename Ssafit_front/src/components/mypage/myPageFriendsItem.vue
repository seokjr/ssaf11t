<template>
    <div class="container">
      <div class="box" style="background: #BDBDBD;">
        <a href="http://www.naver.com"><img src="/images/jumping_cat.jpg" alt="Jumping Cat" class="profile" /></a>
      </div>
      <p class="text-center">{{ someone.nickname }}</p>
    </div>
    <button class="btn btn-outline-danger" v-if="props.type === 'friend'" @click="friendStore.deleteRequest(my_id, someone.id)">친구삭제</button>
    <button class="btn btn-outline-primary" v-if="props.type === 'someone'" @click="friendStore.insertRequest(my_id, someone.id)">친구요청</button>
    <button class="btn btn-outline-success" v-if="props.type === 'waiting'" @click="friendStore.acceptRequest(my_id, someone.id)">친구수락</button>
    <button class="btn btn-outline-danger" v-if="props.type === 'waiting'" @click="friendStore.deleteRequest(my_id, someone.id)">요청삭제</button>
</template>

<script setup>
import { useFriendStore } from '@/stores/friendStore';

const friendStore = useFriendStore();

const props = defineProps({
    'someone' :{ // id, nickname을 키로 가짐
        type : Object,
        required : true
    },
    'type' : {
        type : String,
        required : true
    },
    'my_id' : {
        type : String,
        required : true
    }
});

</script>
  
  <style scoped>
  .container {
    width: 160px;
    height: 180px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .box {
    width: 150px;
    height: 150px;
    border-radius: 70%;
    overflow: hidden;
  }
  .profile {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  .text-center {
    text-align: center;
  }
  </style>  
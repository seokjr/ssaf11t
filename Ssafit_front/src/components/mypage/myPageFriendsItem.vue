<template>
    <div class="container">
      <div class="box" style="background: #BDBDBD;">
        <a href="http://www.naver.com"><img src="/images/jumping_cat.jpg" alt="Jumping Cat" class="profile" /></a>
      </div>
      <p class="text-center">{{ someone.nickname }}</p>
      <div>
        <button class="btn btn-outline-danger" v-if="props.type === 'friend'" @click="handleDeleteRequest">친구삭제</button>
        <button class="btn btn-outline-primary" v-if="props.type === 'someone' && !requestSent" @click="handleInsertRequest">친구요청</button>
        <button class="btn btn-outline-primary" v-if="props.type === 'someone' && requestSent" @click="handleCancelRequest">요청취소</button>
        <button class="btn btn-outline-success" v-if="props.type === 'waiting'" @click="handleAcceptRequest">친구수락</button>
        <button class="btn btn-outline-danger" v-if="props.type === 'waiting'" @click="handleDeleteRequest">요청삭제</button>
      </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useFriendStore } from '@/stores/friendStore';

const friendStore = useFriendStore();

const requestSent = ref(false);

const handleInsertRequest = async function() {
  friendStore.insertRequest(props.my_id, props.someone.id);
  requestSent.value = true;
  await friendStore.getAboutfriends(props.my_id);
};

const handleCancelRequest = async function() {
  friendStore.deleteRequest(props.my_id, props.someone.id);
  requestSent.value = false;
  await friendStore.getAboutfriends(props.my_id);
};

const handleDeleteRequest = async function() {
  friendStore.deleteRequest(props.my_id, props.someone.id);
  await friendStore.getAboutfriends(props.my_id);
};

const handleAcceptRequest = async function() {
  friendStore.acceptRequest(props.my_id, props.someone.id);
  await friendStore.getAboutfriends(props.my_id);
};

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
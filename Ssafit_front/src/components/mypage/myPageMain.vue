<template>
    <div>
    <h2 class="text-center">마이페이지</h2>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header">
                <strong>사용자 정보</strong>
            </div>
            <div class="card-body">
                <p class="card-text"><strong>아이디:</strong> {{ userInfo.id }}</p>
                <p class="card-text"><strong>별명 :</strong> {{ userInfo.nickname }}</p>
                <p class="card-text"><strong>이름:</strong> {{ userInfo.name }}</p>
                <p class="card-text"><strong>이메일:</strong> {{ userInfo.email }}</p>
            </div>
        </div>

        <br>

        <div class="d-flex justify-content-between">
            <button class="btn btn-secondary flex-fill mx-1" @click="">회원정보 수정</button>
            <button class="btn btn-danger flex-fill mx-1" @click="">영상 찜 목록</button>
            <button class="btn btn-primary flex-fill mx-1" @click="goToCommentList">작성 댓글 목록</button>
            <button class="btn btn-success flex-fill mx-1" @click="">친구 추가/목록</button>
        </div>
    </div>
    </div>
</template>

<script setup>
import { ref, computed, onMounted, watch } from 'vue'
import { useUserStore } from '@/stores/userStore'
import { useRouter } from 'vue-router'
const userStore = useUserStore();
const router = useRouter()

const user = userStore.user;

const { getUserInfo } = useUserStore();
const userHasId = computed(() => user && user.hasOwnProperty('id'));
const userInfo = ref({
    id:"", password:"", nickname:"", email:"", name:""
});

onMounted(() => {
  if(userHasId.value) {
    getUserInfo(user.id);
  }
})

watch(() => userStore.userInfo, (newInfo) => {
  userInfo.value = newInfo;
});

const goToCommentList = () => {
  router.push({ name: 'commentList' });
};

</script>

<style scope>
</style>
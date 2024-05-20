<template>
    <div>
        <h2 class="text-center">회원 정보 수정/탈퇴</h2>
        <br>
        <form @submit.prevent="changeUserInfo">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="id" placeholder="id" v-model.trim="userInfo.id" disabled />
                <label for="id">ID</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="name" placeholder="name" v-model.trim="userInfo.name" disabled>
                <label for="name">이름</label>
            </div>
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" placeholder="email" v-model.trim="userInfo.email" disabled>
                <label for="email">이메일</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="nickname" placeholder="nickname" v-model.trim="userInfo.nickname">
                <label for="nickname">별명</label>
            </div>
            <br />
            <div class="input-group mb-3">
                <input type="password" class="form-control" id="password" placeholder="회원 정보 수정을 원하시면 비밀번호 입력 후 버튼을 눌러주세요." aria-label="password" aria-describedby="button-addon2" @keyup.enter="changeUserInfo" v-model.trim="password">
                <button type="submit" class="btn btn-outline-secondary" id="button-addon2">수정</button>
            </div>
        </form>
        <div class="text-center">
            <button class="btn btn-outline-danger text-center" @click="confirmDelete">회원탈퇴</button>
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

const newUserInfo = ref({
    id:"", nickname:"", name:"", email:""
});
const password = ref('');
const changeUserInfo = function() {
    if(password.value === userInfo.value.password) {
        newUserInfo.value.id = userInfo.value.id;
        newUserInfo.value.nickname = userInfo.value.nickname;
        newUserInfo.value.email = userInfo.value.email;
        newUserInfo.value.name = userInfo.value.name;
        userStore.changeUserInfo(newUserInfo.value)
    } else {
        alert('비밀번호가 올바르지 않습니다.')
    }
}

const confirmDelete = function(){
    if(confirm("정말로 회원탈퇴를 하시겠습니까?")) {
        userStore.deleteUserInfo(userInfo.value.id);
    }
}
</script>

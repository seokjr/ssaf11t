<template>
    <div class="container">
        <h1>회원가입</h1>
        <p class="text-danger">{{ msg }}</p>
        <form @submit.prevent="signup">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="id" placeholder="id" v-model.trim="user.id">
            <label for="id">ID</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="password" placeholder="password" v-model.trim="user.password">
            <label for="writer">PassWord</label>
        </div>
        <div class="form-floating mb-3">
            <input type="test" class="form-control" id="nickname" placeholder="nickname" v-model.trim="user.nickname">
            <label for="nickname">별명</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="name" placeholder="name" v-model.trim="user.name">
            <label for="name">이름</label>
        </div>
        <div class="form-floating mb-3">
            <input type="email" class="form-control" id="email" placeholder="email" v-model.trim="user.email" @keyup.enter="signup">
            <label for="email">이메일</label>
        </div>
        <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-outline-primary">회원가입</button>
            </div>
        </form>
    </div>
</template>
  
<script setup>
import { ref } from 'vue'
import { useUserStore } from '@/stores/userStore'
import { storeToRefs } from 'pinia';
const userStore = useUserStore();

const msg = ref('');

const user = ref({
    id: '',
    password: '',
    nickname: '',
    name: '',
    email:'',
})

const signup = function() {
    if(id.value!=='' && password.value!=='' && nickname.value!=='' && name.value!=='' && email.value!=='') {
        userStore.signup(user.value);
    } else {
        alert('모든 정보를 입력해주세요.');
    }
};
</script>
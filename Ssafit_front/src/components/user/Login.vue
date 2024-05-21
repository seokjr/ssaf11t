<template>
  <div class="container">
    <h1>로그인</h1>
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="id"
        placeholder="id"
        v-model.trim="user.id"
      />
      <label for="id">ID</label>
    </div>
    <div class="form-floating mb-3">
      <input
        type="password"
        class="form-control"
        id="password"
        placeholder="password"
        v-model.trim="user.password"
        @keyup.enter="login"
      />
      <label for="writer">PassWord</label>
    </div>
    <div class="d-flex justify-content-end">
      <button class="btn btn-outline-primary" @click="login">로그인</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/userStore";
const userStore = useUserStore();

const user = ref({
  id: "",
  password: "",
});

const login = function () {
  userStore.login(user.value);
};
</script>

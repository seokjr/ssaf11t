<template>
  <div id="container">
    <header>
      <img
        src="@/assets/ssaf11t_logo2.png"
        alt="Ssafit Logo"
        class="logo"
        @click="goHome"
      />
      <h2 @click="goHome" style="color: rgb(123, 169, 187)">SSAF11T</h2>
      <nav>
        <div class="menu">
          <RouterLink to="/">Home</RouterLink> |
          <RouterLink to="/comment">리뷰 목록</RouterLink> |
          <RouterLink to="/youtube">영상 검색</RouterLink> |
          <RouterLink :to="{ name: 'map' }">헬스장찾기</RouterLink>
          <span v-if="userHasId">
            |<RouterLink :to="{ name: 'myPageMain', params: { id: user.id } }"
              >마이페이지</RouterLink
            >
            |<RouterLink v-if="userHasId" :to="{ name: 'guildList' }">
              길드</RouterLink
            >
          </span>
        </div>
        <div class="user" v-if="isLoggedIn">
          <span style="color: black">{{ user.nickname }} 님 환영합니다.</span>
          <RouterLink @click="logout" to="/">로그아웃</RouterLink>
        </div>
        <div class="user" v-else>
          <RouterLink :to="{ name: 'login' }">로그인</RouterLink> |
          <RouterLink :to="{ name: 'signup' }">회원가입</RouterLink>
        </div>
      </nav>
    </header>
  </div>
</template>

<script setup>
import { RouterLink } from "vue-router";
import { useUserStore } from "@/stores/userStore";
import { computed } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
const goHome = function () {
  router.push({ name: "home" });
};

const { user, getUser, logout } = useUserStore();
const isLoggedIn = computed(() => !!getUser());
const userHasId = computed(() => user && user.hasOwnProperty("id"));
</script>

<style scoped>
#container {
  text-align: center;
}
header {
  display: flex;
  align-items: center;
  border-bottom: 1px solid #ddd; /* 구분선을 추가 */
  padding: 20px 0; /* 위아래 여백 추가 */
  box-shadow: 0px 2px 0px rgb(185, 182, 182);
  font-size: 1.3rem;
}
.logo {
  margin-right: 20px;
  width: 5%;
  height: 5%;
  margin: 10px;
}
nav {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center; /* 수직 가운데 정렬 */
  position: relative;
}
.menu {
  position: absolute;
  left: 44.5%;
  transform: translateX(-50%);
  text-align: center;
  color: black;
}
.user {
  margin-left: auto;
  color: rgb(123, 169, 187);
}
nav a {
  padding: 5px;
  font-weight: bold;
  text-decoration: none;
  color: rgb(123, 169, 187);
  transition: all 0.5s;
}
nav a:hover {
  color: rgb(6, 48, 65);
  box-shadow: 0px 1px 0px rgb(4, 88, 84);
  transform: translateY(-10px);
  transform: translateX(-10px);
}
nav a.router-link-exact-active {
  color: rgb(6, 48, 65);
}
</style>

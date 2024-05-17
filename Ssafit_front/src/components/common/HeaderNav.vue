<template>
  <div id="container">
    <header>
      <nav>
        <span class="menu">
          <RouterLink to="/">Home</RouterLink> | 
          <RouterLink to="/comment">리뷰 목록</RouterLink> | 
          <RouterLink to="/youtube">영상 검색</RouterLink> | 
          <RouterLink :to="{name : 'map'}">헬스장찾기</RouterLink>
          <RouterLink v-if="userHasId" :to="{ name: 'myPageMain', params: { id: user.id } }">| 마이페이지</RouterLink>
        </span>
        <span class="user" v-if="isLoggedIn">
          <!--여기에 user id를 누르면 mypage로 가게 하거나 my page 버튼을 따로 만들어야 할 듯-->
          <span>{{ user.nickname }} 님 환영합니다.</span>
          <RouterLink @click="logout" to="/">로그아웃</RouterLink>
        </span>
        <span class="user" v-else>
          <RouterLink :to="{name : 'login'}">로그인</RouterLink> | 
          <RouterLink :to="{name : 'signup'}">회원가입</RouterLink>
        </span>
      </nav>
    </header>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router';
import { useUserStore } from '@/stores/userStore';
import { computed} from 'vue'

const { user, getUser, logout } = useUserStore();
const isLoggedIn = computed(() => !!getUser());
const userHasId = computed(() => user && user.hasOwnProperty('id'));

</script>

<style scoped>
#container {
  text-align: center;
  height : 50px;
  align-content: center;
}
nav {
  display: flex;
  justify-content: center;
}
.menu {
  display: inline-block;
  text-align: center;
  margin-left: auto;
}
.user {
  display: inline-block; /* 사용자 링크를 수평으로 정렬하기 위해 */
  align-items: center; /* 수직으로 가운데 정렬 */
  margin-left: auto; /* 사용자 링크를 오른쪽으로 이동 */
}

nav a {
  padding: 5px;
  font-weight: bold;
  text-decoration: none;
  color: black;
  transition: all 0.5s;
}
nav a:hover {
  color: grey;
  box-shadow: 0px 1px 0px rgb(4, 88, 84);
  transform: translateY(-10px);
  transform: translateX(-10px);
}
nav a.router-link-exact-active {
  color: grey;
}

</style>

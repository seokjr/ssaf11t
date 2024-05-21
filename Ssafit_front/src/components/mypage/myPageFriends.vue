<template>
  <div>
    <h2 class="text-center">친구 추가/목록</h2>
    <br />
    <div class="container">
      <myPageFriendsList :id="route.params.id" />
      <br />
      <myPageFriendsSearch :id="route.params.id" />
    </div>
  </div>
</template>

<script setup>
import myPageFriendsList from "./myPageFriendsList.vue";
import myPageFriendsSearch from "./myPageFriendsSearch.vue";
import { useRoute } from "vue-router";

const route = useRoute();
</script>

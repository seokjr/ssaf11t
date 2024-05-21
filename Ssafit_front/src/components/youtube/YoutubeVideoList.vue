<template>
  <div class="container">
    <h4 class="text-center" v-if="store.videos == null">
      검색결과가 없습니다.
    </h4>
    <ul class="video-list" v-else>
      <YoutubeVideoListItem
        v-for="video in store.videos"
        :key="video.id.videoId"
        :video="video"
      />
    </ul>
    <div v-if="userHasId">
      <ChatGPT />
    </div>
    <h4 v-else class="text-center">
      운동 추천 서비스를 이용하시려면 로그인하세요.
    </h4>
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useYoutubeStore } from "@/stores/youtube";
import YoutubeVideoListItem from "@/components/youtube/YoutubeVideoListItem.vue";
import ChatGPT from "@/components/chatgpt/ChatGPT.vue";
import { useUserStore } from "@/stores/userStore";

const store = useYoutubeStore();
const { user } = useUserStore();
const userHasId = computed(() => user && user.hasOwnProperty("id"));
</script>

<style scoped>
.container {
  padding: 20px;
}

.video-list {
  list-style-type: none;
  padding: 0;
}

.video-list li {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  display: flex;
  align-items: center;
  background-color: #f9f9f9;
}

.video-list li:hover {
  background-color: #f1f1f1;
}

.text-center {
  margin-top: 20px;
}
</style>

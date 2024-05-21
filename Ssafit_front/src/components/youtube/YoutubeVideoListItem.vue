<template>
  <li @click="clickVideo" class="video-item">
    <img :src="video.snippet.thumbnails.default.url" class="video-thumbnail" />
    <div class="video-info">
      <span class="video-title" v-html="video.snippet.title"></span>
      <span class="channel-title">{{ video.snippet.channelTitle }}</span>
    </div>
  </li>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
import { defineProps } from "vue";
import { useRouter } from "vue-router";

const store = useYoutubeStore();
const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
});

const router = useRouter();
const clickVideo = function () {
  store.clickVideo(props.video);
  router.push({
    name: "videoDetail",
    params: { id: store.selectedVideo.id.videoId },
  });
};
</script>

<style scoped>
.video-item {
  display: flex;
  align-items: center;
  cursor: pointer;
  transition: background-color 0.3s;
}

.video-thumbnail {
  width: 120px;
  height: auto;
  margin-right: 20px;
  border-radius: 4px;
}

.video-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}

.video-title {
  font-weight: bold;
  font-size: 16px;
  color: #333;
}

.video-item:hover {
  background-color: #f1f1f1;
}

.channel-title {
  font-size: 16px;
  color: #777;
  margin-left: auto;
}
</style>

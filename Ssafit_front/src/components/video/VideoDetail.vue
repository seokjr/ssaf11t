<template>
  <div v-if="store.selectedVideo" class="container">
    <h3>
      {{ videoTitle }}
      <button v-if="user !== null" @click="toggleJjim(store.selectedVideo)">
        {{ isFavorite ? '🧡' : '🤍' }}
      </button>
    </h3>
    <iframe
      width="560"
      height="315"
      :src="videoURL"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      referrerpolicy="strict-origin-when-cross-origin"
      allowfullscreen
    ></iframe>
    <hr>
    <ReviewView />
  </div>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube"
import { useJjimStore } from "@/stores/jjimStore"
import { useUserStore } from '@/stores/userStore';
import ReviewView from "@/views/ReviewView.vue"
import { computed, watch } from "vue"
import _ from 'lodash'

const store = useYoutubeStore()
const jjimStore = useJjimStore()
const userStore = useUserStore();

const user = userStore.getUser()

const videoTitle = computed(() => {
  return _.unescape(store.selectedVideo.snippet.title)
})

const videoURL = computed(() => {
  let videoId = ""
  if (!store.selectedVideo.id.hasOwnProperty('videoId')) {
    videoId = store.selectedVideo.id
  } else {
    videoId = store.selectedVideo.id.videoId
  }
  return `https://www.youtube.com/embed/${videoId}`
})

const isFavorite = computed(() => {
  return jjimStore.jjimList.some(jjim => jjim.videoId === store.selectedVideo.id || jjim.videoId === store.selectedVideo.id.videoId)
})

const toggleJjim = async (video) => {
  await jjimStore.toggleJjim(video)
  await jjimStore.getJjimListAll();  // ensure the jjimList is up to date
}

watch(() => store.selectedVideo, async () => {
  await jjimStore.getJjimListAll()
})
</script>

<style scoped>
.container {
  text-align: center;
  align-items: center;
}
button {
  background-color: white;
  border: none;
}
</style>

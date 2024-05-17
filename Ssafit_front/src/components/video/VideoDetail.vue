<template>
  <div v-if="store.selectedVideo" class="container">
    <h3>{{ videoTitle }}</h3><!--<button @click="toggleFavorite(myProduct)" v-if="myProduct.isFavorite">🧡</button>-->
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
    <ReviewView/>
  </div>
</template>
  

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
import ReviewView from "@/views/ReviewView.vue";
import { computed, ref } from "vue";
import _ from 'lodash'

const store = useYoutubeStore();

const videoTitle = computed(()=>{
  return _.unescape(store.selectedVideo.snippet.title)
})

const videoURL = computed(() => {
  let videoId = "";
  if(!store.selectedVideo.id.hasOwnProperty('videoId')) {
    console.log(store.selectedVideo.id);
    videoId = store.selectedVideo.id;
  } else {
    console.log(store.selectedVideo.id.videoId);
    videoId = store.selectedVideo.id.videoId;
  }
  console.log(`https://www.youtube.com/embed/${videoId}`);
  return `https://www.youtube.com/embed/${videoId}` // 여기 부분이 url이다. id만 알고 있으면 넣을 수 있다.
 })

 const toggleFavorite = (myProduct) => {
    store.JjimClick(myProduct)
  }
</script>
<style scoped>
  .container{
    text-align: center;
    align-items: center;
  }
</style>
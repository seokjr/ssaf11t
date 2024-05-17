<template>
    <li @click="clickVideo">
        <img :src="video.snippet.thumbnails.default.url">
        <span v-html="video.snippet.title"></span>
    </li>
  </template>
  <script setup>
  import { useYoutubeStore } from '@/stores/youtube'
  import { defineProps } from 'vue';
  import { useRoute, useRouter } from 'vue-router'

  const store = useYoutubeStore()
  const props = defineProps({
    'video' : {
    type : Object,
    required : true
  }})
  
  const router = useRouter()
  const clickVideo = function(){
    store.clickVideo(props.video)
    router.push({ name: "videoDetail", params: { id: store.selectedVideo.id.videoId } })
  }

  </script>
  <style scoped>
  
  </style>
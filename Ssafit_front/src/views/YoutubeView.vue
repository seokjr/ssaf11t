<template>
  <div class="container">
    <h2 class="text-center">
      <i class="bi bi-youtube" style="color: red"></i> 영상 보며 운동하자!
    </h2>
    <YoutubeVideoSearch />
    <hr />
    <YoutubeVideoList />
  </div>
</template>
<script setup>
import YoutubeVideoSearch from "@/components/youtube/YoutubeVideoSearch.vue";
import YoutubeVideoList from "@/components/youtube/YoutubeVideoList.vue";
</script>
<style scoped></style>

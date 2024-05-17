<template>
    <div class="container">
      <h2 class="text-center"><i class="bi bi-card-list" style="color: mediumblue"></i> 리뷰 목록</h2>
      <commentSearch/>
      <hr>
      <commentList/>
    </div>
  </template>
  <script setup>
  import commentSearch from '@/components/comment/commentSearch.vue';
  import commentList from '@/components/comment/commentList.vue';
  </script>
  <style scoped>
  
  </style>
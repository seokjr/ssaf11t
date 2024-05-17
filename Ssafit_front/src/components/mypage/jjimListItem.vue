<template>
    <tr>
        <td>{{Jjim.jjimId}}</td>
        <td><img :src=Jjim.imgSource></td>
        <td>{{Jjim.channelName}}</td>
        <td>{{_.unescape(Jjim.videoTitle)}}</td>
        <td>{{Jjim.publishTime}}</td>
    </tr>
</template>

<script setup>
  import { ref } from 'vue'
  import { useReviewStore } from '@/stores/reviewStore';
  import _ from 'lodash'
  
  const store = useReviewStore();

  const props = defineProps({
    'Jjim' : {
    type : Object,
    required : true
  }})

  </script>

<style scoped>
.word {
  white-space: nowrap;
  display: block;
  width: 300px;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
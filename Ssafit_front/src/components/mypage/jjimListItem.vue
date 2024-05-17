<template>
  <tr>
    <td @click="clickReview(Jjim)">{{ Jjim.jjimId }}</td>
    <td @click="clickReview(Jjim)"><img :src="Jjim.imgSource"></td>
    <td @click="clickReview(Jjim)">{{ Jjim.channelName }}</td>
    <td @click="clickReview(Jjim)">{{ _.unescape(Jjim.videoTitle) }}</td>
    <td @click="clickReview(Jjim)">{{ Jjim.publishTime }}</td>
    <td>
      <button @click="deleteJjim(Jjim)">🗑️</button>
    </td>
  </tr>
</template>

<script setup>
import { ref } from 'vue'
import { useJjimStore } from '@/stores/jjimStore';
import _ from 'lodash'

const jjimStore = useJjimStore()

const props = defineProps({
  Jjim: {
    type: Object,
    required: true
  }
})

const deleteJjim = async (jjim) => {
  await jjimStore.deleteJjim(jjim.userId, jjim.videoId)
}
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
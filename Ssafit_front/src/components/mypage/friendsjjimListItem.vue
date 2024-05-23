<template>
  <tr>
    <th scope="row" @click="clickReview(Jjim)">{{ Jjim.jjimId }}</th>
    <td @click="clickReview(Jjim)"><img :src="Jjim.imgSource" /></td>
    <td @click="clickReview(Jjim)">{{ Jjim.channelName }}</td>
    <td class="word" @click="clickReview(Jjim)">
      {{ _.unescape(Jjim.videoTitle) }}
    </td>
    <td @click="clickReview(Jjim)">{{ Jjim.publishTime }}</td>
  </tr>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
import { useRouter } from "vue-router";
import _ from "lodash";

const router = useRouter();

const youtubeStore = useYoutubeStore();

const clickReview = function (review) {
  youtubeStore.clickReview(review.videoId);
  router.push({ name: "videoDetail", params: { id: review.videoId } });
};

const props = defineProps({
  Jjim: {
    type: Object,
    required: true,
  },
});
</script>

<style scoped>
.word {
  white-space: nowrap;
  max-width: 300px;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>

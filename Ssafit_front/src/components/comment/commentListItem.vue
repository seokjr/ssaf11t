<template>
  <tr>
    <th scope="row">{{ review.reviewId }}</th>
    <td>{{ review.commentContent }}</td>
    <td>{{ review.userId }}</td>
    <td class="word">{{ _.unescape(review.videoTitle) }}</td>
    <td>{{ review.channelName }}</td>
    <td>{{ review.regDate }}</td>
  </tr>
</template>

<script setup>
import { useReviewStore } from "@/stores/reviewStore";
import _ from "lodash";

const store = useReviewStore();

const props = defineProps({
  review: {
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

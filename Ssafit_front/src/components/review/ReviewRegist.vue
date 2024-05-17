<template>
  <div class="container">
    <h4>리뷰 등록</h4>
    <fieldset>
      <div class="form-floating mb-3">
          <input type="text" class="form-control" id="userId" placeholder="작성자" readonly>
          <label for="userId">{{ userStore.getUser().id }}</label>
      </div>
      <div class="form-floating mb-3">
          <input type="text" class="form-control" id="commentContent" placeholder="내용"
              v-model="review.commentContent" @keyup.enter="createReview">
          <label for="commentContent">Content</label>
      </div>
      <div class="d-flex justify-content-end">
          <button class="btn btn-outline-primary" @click="createReview">등록</button>
      </div>
      
      
    </fieldset>
  </div>
</template>
  
<script setup>
import { ref } from 'vue'
import { useReviewStore } from '@/stores/reviewStore';
import { useYoutubeStore } from "@/stores/youtube";
import { useRoute, useRouter } from 'vue-router'
import { useUserStore } from '@/stores/userStore';
const route = useRoute()
const router = useRouter()
const reviewstore = useReviewStore()
const youtubestore = useYoutubeStore();
const userStore = useUserStore();

const review = ref({
  userId: userStore.getUser().id,
  videoId: route.params.id,
  videoTitle: youtubestore.selectedVideo.snippet.title,
  channelName : youtubestore.selectedVideo.snippet.channelTitle,
  commentContent: '',
})

const createReview = async function(){
  await reviewstore.createReview(review.value)
  await reviewstore.getReviewList(route.params.id)
  review.value.commentContent = ''
  router.push({ name: "videoDetail", params: { id: route.params.id } })
}
</script>
  
<style scoped>
</style>
  
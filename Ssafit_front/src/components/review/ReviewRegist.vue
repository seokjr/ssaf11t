<template>
  <div class="container" v-if="user !== null">
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
  <h3 v-else class="text-center">로그인을 하면 찜 기능과 댓글 작성 기능을 사용하실 수 있습니다.</h3>
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

const user = userStore.getUser()

const review = ref({
  userId: user ? user.id : '',
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
  
<template>
    <div class="container">
      <h4 v-if="currentPageReviewList.length != 0"></h4>
      <h4 v-else class="text-center">리뷰가 없습니다. 영상 검색에서 영상을 보고 새로운 리뷰를 등록해주세요</h4>
      <table class="table table-hover text-center" v-if="currentPageReviewList.length != 0">
        <tr>
          <th>번호</th>
          <th>내용</th>
          <th>작성자</th>
          <th>영상제목</th>
          <th>채널명</th>
          <th>등록일</th>
        </tr>
        <commentListItem v-for="review in currentPageReviewList"
        :key="review.commentTitle" :review="review" @click="clickReview(review)"/>
      </table>
      <nav aria-label="Page navigation" v-if="currentPageReviewList.length != 0">
        <ul class="pagination d-flex justify-content-center">
          <li class="page-item">
            <a class="page-link" @click.prevent="currentPage--" :class="{disabled: currentPage <= 1}" href="#">&lt;</a>
          </li>
          <li class="page-item" :class="{active: currentPage === page}" v-for="page in pageCount" :key="page">
            <a class="page-link" href="#" @click.prevent="clickPage(page)">{{ page }}</a>
          </li>
          <li class="page-item">
            <a class="page-link" @click.prevent="currentPage++"  :class="{disabled: currentPage >= pageCount}" href="#">&gt;</a>
          </li>
        </ul>
      </nav>
    </div>
  </template>

  <script setup>
  import { ref, onMounted, computed } from 'vue'
  import { useReviewStore } from '@/stores/reviewStore';
  import { useYoutubeStore } from '@/stores/youtube';
  import commentListItem from '@/components/comment/commentListItem.vue';
  import { useRouter } from 'vue-router'
  const reviewStore = useReviewStore();
  const youtubeStore = useYoutubeStore();
  
  const searchInfo = ref({
  key: "none",
  word: "",
  orderBy: "none",
  orderByDir: "asc",
  });

  onMounted(() => {
      reviewStore.searchReviewList(searchInfo.value);
    }
  )

const perPage = 10;
const currentPage = ref(1)

const pageCount = computed(()=>{
    return Math.ceil(reviewStore.reviewList.length / perPage)
})

const clickPage = function(page){
    currentPage.value = page
}

const currentPageReviewList = computed(()=>{
  return reviewStore.reviewList.slice((currentPage.value-1) * perPage, currentPage.value * perPage)
})

  const router = useRouter()
  const clickReview = function(review){
    reviewStore.increaseViewCnt(review)
    youtubeStore.clickReview(review.videoId);
    router.push({ name: "videoDetail", params: { id: review.videoId } })
  }
</script>

<style scoped>
  
</style>
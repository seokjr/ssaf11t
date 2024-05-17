<template>
  <div class="container">
    <h4 v-if="currentPageReviewList.length != 0">리뷰 목록</h4>
    <h4 v-else>리뷰가 없습니다.</h4>
    <hr>
    <table class="table table-hover text-center">
      <tr>
        <th>순서</th>
        <th>작성자</th>
        <th>리뷰 내용</th>
        <th>리뷰 조회수</th>
        <th>등록일자</th>
      </tr>
      <tr v-for="(review, index) in currentPageReviewList" :key="index">
        <td>{{ index + 1 }}</td>
        <td>
            <!-- <RouterLink :to="`/review/${board.id}`">-->{{ review.userId }}<!--</RouterLink> -->
        </td>
        <td>{{ review.commentContent}}</td>
        <td>{{ review.viewCnt}}</td>
        <td>{{ review.regDate}}</td>
        <button @click="deleteReview(review.userId, review.regDate)">삭제</button>
        <!-- <button @click="updateReview(review.userId, review.regDate)">수정</button> -->
      </tr>
    </table>
        
    <nav aria-label="Page navigation ">
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
import { useRoute, useRouter } from 'vue-router'
import { ref, onMounted, watch, computed } from 'vue';
import { useReviewStore } from '@/stores/reviewStore';
import axios from 'axios'

const store = useReviewStore()
const route = useRoute()
const router = useRouter()
const reviewList = ref([])
onMounted(()=>{
  store.getReviewList(route.params.id)
})
const deleteReview = async function(userId, regDate){
  await axios.delete(`http://localhost:8080/review-api/board/${userId}&${regDate}`)
  .then(()=>{
    // console.log(route.params.id)
    // router.push(`/restaurant/${route.params.id}`)
    // router.push({name : 'youtube'})
    // router.push({ name: "videoDetail", params: { id: route.params.id } })
    // router.push({name : 'resList'})
  })
}

const perPage = 5;
const currentPage = ref(1)

const pageCount = computed(()=>{
    return Math.ceil(store.reviewList.length / perPage)
})

const clickPage = function(page){
    currentPage.value = page
}

const currentPageReviewList = computed(()=>{
  return store.reviewList.slice((currentPage.value-1) * perPage, currentPage.value * perPage)
})
</script>
<style scoped>
a {
  text-decoration: none;
  color : black;
}
</style>

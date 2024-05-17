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
        <th>작업</th>
      </tr>
      <tr v-for="(review, index) in currentPageReviewList" :key="index">
        <td>{{ index + 1 }}</td>
        <td>{{ review.userId }}</td>
        <td>{{ review.commentContent }}</td>
        <td>{{ review.viewCnt }}</td>
        <td>{{ review.regDate }}</td>
        <td>
          <button @click="deleteReview(review.userId, review.regDate)">삭제</button>
          <button @click="openEditModal(review)">수정</button>
        </td>
      </tr>
    </table>

    <nav aria-label="Page navigation">
      <ul class="pagination d-flex justify-content-center">
        <li class="page-item">
          <a class="page-link" @click.prevent="currentPage--" :class="{disabled: currentPage <= 1}" href="#">&lt;</a>
        </li>
        <li class="page-item" :class="{active: currentPage === page}" v-for="page in pageCount" :key="page">
          <a class="page-link" href="#" @click.prevent="clickPage(page)">{{ page }}</a>
        </li>
        <li class="page-item">
          <a class="page-link" @click.prevent="currentPage++" :class="{disabled: currentPage >= pageCount}" href="#">&gt;</a>
        </li>
      </ul>
    </nav>

    <!-- Edit Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="editModalLabel">리뷰 수정</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="editCommentContent" v-model="editReview.commentContent" placeholder="내용">
              <label for="editCommentContent">내용</label>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            <button type="button" class="btn btn-primary" @click="updateReview">저장</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router'
import { ref, onMounted, watch, computed } from 'vue';
import { useReviewStore } from '@/stores/reviewStore';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import { Modal } from 'bootstrap'

const store = useReviewStore()
const route = useRoute()
const router = useRouter()
const reviewList = ref([])

const editReview = ref({ userId: '', regDate: '', commentContent: '' })

onMounted(() => {
  store.getReviewList(route.params.id)
})

const deleteReview = async function(userId, regDate) {
  await store.deleteReview(userId, regDate)
  await store.getReviewList(route.params.id)
}

const openEditModal = function(review) {
  editReview.value = { ...review }
  const editModal = new Modal(document.getElementById('editModal'), {
    keyboard: false
  })
  editModal.show()
}

const updateReview = async function() {
  await store.updateReview(editReview.value)
  await store.getReviewList(route.params.id)
  const editModal = Modal.getInstance(document.getElementById('editModal'))
  editModal.hide()
}

const perPage = 5;
const currentPage = ref(1)

const pageCount = computed(() => {
  return Math.ceil(store.reviewList.length / perPage)
})

const clickPage = function(page) {
  currentPage.value = page
}

const currentPageReviewList = computed(() => {
  return store.reviewList.slice((currentPage.value - 1) * perPage, currentPage.value * perPage)
})
</script>

<style scoped>
a {
  text-decoration: none;
  color: black;
}
</style>

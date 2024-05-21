<template>
  <div class="text-center searchtotal">
      <div class="row align-items-center">
          <div class="col-2">
              <select class="form-select" v-model="searchInfo.key">
                  <option value="none">전체</option>
                  <option value="user_id">글쓴이</option>
                  <option value="video_title">영상제목</option>
                  <option value="comment_content">내용</option>
              </select>
          </div>
          <div class="col-6">
              <input type="text" class="form-control" v-model="searchInfo.word" @keyup.enter="searchReviewList"/>
          </div>
          <div class="col-2">
              <div class="form-check form-check-inline">
                  <input v-model="searchInfo.orderBy" class="form-check-input" type="radio" id="videoTitle" value="video_title" />
                  <label class="form-check-label" for="videoTitle"><i class="bi bi-fonts"></i></label>
              </div>
              <div class="form-check form-check-inline">
                  <input v-model="searchInfo.orderBy" class="form-check-input" type="radio" id="userId" value="user_id" />
                  <label class="form-check-label" for="userId"><i class="bi bi-person-fill"></i></label>
              </div>
              <div class="form-check form-check-inline">
                  <input v-model="searchInfo.orderBy" class="form-check-input" type="radio" id="viewCnt"
                      value="view_cnt" />
                  <label class="form-check-label" for="viewCnt"><i class="bi bi-eye-fill"></i></label>
              </div>
              <div class="form-check form-check-inline">
                  <input v-model="searchInfo.orderBy" class="form-check-input" type="radio" id="regDate"
                      value="reg_date" />
                  <label class="form-check-label" for="regDate"><i class="bi bi-calendar-date"></i></label>
              </div>
          </div>
          <div class="col-1">
              <div @click="sortChange">
                  <span v-if="searchInfo.orderByDir === 'asc'">
                      <i class="bi bi-arrow-up-right-square-fill"></i>
                  </span>
                  <span v-else><i class="bi bi-arrow-down-right-square-fill"></i></span>
              </div>
          </div>
          <div class="col-1">
              <button class="btn btn-outline-primary" @click="searchReviewList">검색</button>
          </div>
      </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useReviewStore } from '@/stores/reviewStore';

const store = useReviewStore();
const searchInfo = ref({
  key: "none",
  word: "",
  orderBy: "none",
  orderByDir: "asc",
});
const searchReviewList = function () {
  store.searchReviewList(searchInfo.value);
};

const sortChange = function () {
  if (searchInfo.value.orderByDir === "asc")
      searchInfo.value.orderByDir = "desc";
  else searchInfo.value.orderByDir = "asc";
};
</script>

<style scoped>
.searchtotal{
    margin-top: 1.3rem;
    margin-bottom: 1.3rem;
}
</style>

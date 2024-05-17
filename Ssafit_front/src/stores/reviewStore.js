import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'
const REST_REVIEW_API = `http://localhost:8080/review-api/board`

export const useReviewStore = defineStore("review", () => {
  const reviewList = ref([])

  const getReviewListAll = async function() {
    await axios.get(`${REST_REVIEW_API}`)
      .then((res) => {
        reviewList.value = res.data
      })
  }

  const getReviewList = async function(videoId) {
    await axios.get(`${REST_REVIEW_API}/${videoId}`)
      .then((res) => {
        reviewList.value = res.data
      })
  }

  const getUserReviewList = async function(userId) {
    await axios.get(`http://localhost:8080/review-api/comment/${userId}`)
      .then((res) => {
        reviewList.value = res.data
      })
  }

  const createReview = async function(review) {
    await axios({
      url: REST_REVIEW_API,
      method: 'POST',
      data: review
    })
  }

  const deleteReview = async function(userId, regDate) {
    await axios({
      url: `${REST_REVIEW_API}/${userId}&${regDate}`,
      method: 'DELETE',
    })
  }
  
  const updateReview = async function(review) {
    await axios({
      url: `${REST_REVIEW_API}/${review.userId}&${review.regDate}`,
      method: 'PUT',
      data: review
    })
  }

  const searchReviewList = function(searchCondition) {
    axios.get(REST_REVIEW_API, {
      params: searchCondition
    })
      .then((res) => {
        reviewList.value = res.data
      })
      .catch((err) => {
        alert(err)
      })
  }

  return {
    reviewList,
    getReviewListAll,
    getReviewList,
    getUserReviewList,
    createReview,
    searchReviewList,
    deleteReview,
    updateReview,
  };
});

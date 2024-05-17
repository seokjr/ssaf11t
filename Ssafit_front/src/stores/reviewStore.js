import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'
const REST_REVIEW_API = `http://localhost:8080/review-api/board`

export const useReviewStore = defineStore("review", () => {
  const reviewList = ref([])

  const getReviewListAll = async function(){
    await axios.get(`${REST_REVIEW_API}`)
    .then((res)=>{
        reviewList.value = res.data
    })
  }
  const getReviewList = async function(videoId){
    await axios.get(`${REST_REVIEW_API}/${videoId}`)
    .then((res)=>{
        reviewList.value = res.data
    })
  }
  const createReview = async function(review){
    await axios({
        url:REST_REVIEW_API,
        method: 'POST',
        data:review
    })
    .then(()=>{
        // router.go(0)
        // router.push({ name: "videoDetail", params: { id: selectedVideo.id.videoId } })
    })
  }

  const searchReviewList = function(searchCondition){
    axios.get(REST_REVIEW_API, {
      params : searchCondition
    })
    .then((res) => {
      reviewList.value = res.data
    })
    .catch((err)=>{
      alert(err)
    })
  }
  return {
    reviewList,
    getReviewListAll,
    getReviewList,
    createReview,
    searchReviewList,
  };
});

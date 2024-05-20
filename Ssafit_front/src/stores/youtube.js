import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useYoutubeStore = defineStore('youtube', () => {
  const videos = ref(null)
  const selectedVideo = ref(null)
  const youtubeSearch = function(keyword){
    const URL = 'https://www.googleapis.com/youtube/v3/search'
    const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY
    if (!keyword.includes('운동')) {
      keyword += ' 운동'; // 없다면 키워드에 '운동' 추가
    }
    axios({
      url:URL,
      method : 'GET',
      params : {
        key: API_KEY,
        part : 'snippet',
        maxResults : 10,
        q : keyword,
        type : 'video'
      }
    })
    .then((response) => {
      videos.value = response.data.items
    })
    .catch((error) => {
      console.log(error)
    })
  }
  
  const clickVideo = function(video){
    selectedVideo.value = video
  }

  const clickReview = async function(videoId) {
    const URL = 'https://www.googleapis.com/youtube/v3/videos';
    const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY;
    
    try {
      const response = await axios.get(URL, {
        params: {
          key: API_KEY,
          part: 'snippet',
          id: videoId
        }
      })
      console.log(response.data.items[0])
      selectedVideo.value = response.data.items[0]
    } catch (error) {
      console.error('Error fetching video info:', error)
      return null
    }
  };

  return { youtubeSearch, videos, clickVideo, selectedVideo, clickReview }
})

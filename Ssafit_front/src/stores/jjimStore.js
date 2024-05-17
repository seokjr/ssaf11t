import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

export const useJjimStore = defineStore('jjim', () => {
  const REST_JJIM_API = 'http://localhost:8080/jjim-api/jjim'
  const user = ref(null)
  const jjimList = ref([])

  const checkSession = function() {
    const userData = sessionStorage.getItem('user')
    if (userData) {
      user.value = JSON.parse(userData)
    }
  }
  
  checkSession()

  const getJjimListAll = async function() {
    if (!user.value) return;
    await axios.get(`${REST_JJIM_API}/${user.value.id}`)
      .then((res) => {
        jjimList.value = res.data
      })
  }

  const addJjim = async function(jjim) {
    await axios({
      url: REST_JJIM_API,
      method: 'POST',
      data: jjim
    })
    await getJjimListAll()
  }

  const deleteJjim = async function(userId, videoId) {
    await axios({
      url: REST_JJIM_API,
      method: 'DELETE',
      data: { userId, videoId },
      headers: { 'Content-Type': 'application/json' }
    })
    await getJjimListAll()
  }

  const toggleJjim = async function(video) {
    const existingJjim = jjimList.value.find(jjim => jjim.videoId === video.id || jjim.videoId === video.id.videoId);
    if (existingJjim) {
      await deleteJjim(existingJjim.userId, existingJjim.videoId)
    } else {
      const videoId = video.id.videoId || video.id;
      const newJjim = {
        userId: user.value.id,
        videoId: videoId,
        videoTitle: video.snippet.title,
        channelName: video.snippet.channelTitle,
        publishTime: video.snippet.publishedAt,
        imgSource: video.snippet.thumbnails.default.url,
      }
      await addJjim(newJjim)
    }
  }

  return { getJjimListAll, addJjim, deleteJjim, toggleJjim, jjimList }
})

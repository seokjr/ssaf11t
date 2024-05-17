import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';
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

  const getJjimListAll = async function(){
    await axios.get(`${REST_JJIM_API}/${user.value.id}`)
    .then((res)=>{
      jjimList.value = res.data
    })
  }
  



  return { getJjimListAll }
})

<template>
    <div>
    <h2 class="text-center">내가 한 찜 영상 목록</h2>
    <br>
    <div class="container">
      <h4 v-if="currentPageJjimList.length != 0"></h4>
      <h4 v-else class="text-center">찜 목록이 없습니다. 영상 검색에서 영상을 보고 좋아요를 눌러주세요</h4>
      <table class="table table-hover text-center" v-if="currentPageJjimList.length != 0">
        <tr>
          <th>번호</th>
          <th>썸네일</th>
          <th>채널명</th>
          <th>영상제목</th>
          <th>영상게시일</th>
        </tr>
        <jjimListItem v-for="Jjim in currentPageJjimList"
        :key="Jjim.jjimId" :Jjim="Jjim"/>
      </table>
      <nav aria-label="Page navigation" v-if="currentPageJjimList.length != 0">
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
    </div>
</template>

  <script setup>
  import { ref, onMounted, computed } from 'vue'
  import { useYoutubeStore } from '@/stores/youtube';
  import jjimListItem from '@/components/mypage/jjimListItem.vue';
  import { useRouter } from 'vue-router'
  import { useUserStore } from '@/stores/userStore'
import { useJjimStore } from '@/stores/jjimStore';
  const userStore = useUserStore();
  const jjimStore = useJjimStore();
  const youtubeStore = useYoutubeStore();
  const user = userStore.user;

  const userHasId = computed(() => user && user.hasOwnProperty('id'));

  onMounted(() => {
    if(userHasId.value) {
      jjimStore.getJjimListAll();
    }
    }
  )

const perPage = 10;
const currentPage = ref(1)

const pageCount = computed(()=>{
    return Math.ceil(jjimStore.jjimList.length / perPage)
})

const clickPage = function(page){
    currentPage.value = page
}

const currentPageJjimList = computed(()=>{
  return jjimStore.jjimList.slice((currentPage.value-1) * perPage, currentPage.value * perPage)
})

  const router = useRouter()
  const clickReview = function(Jjim){
    youtubeStore.clickReview(Jjim.videoId);
    router.push({ name: "videoDetail", params: { id: Jjim.videoId } })
  }
</script>

<style scoped>
  
</style>
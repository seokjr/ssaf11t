<template>
  <div>
    <h2 class="text-center d-flex justify-content-between align-items-center">
      {{ route.params.id }}가 찜한 영상 목록
      <button class="btn btn-outline-success ms-auto" @click="goToFriends">
        친구목록으로 가기
      </button>
    </h2>
    <br />
    <div class="container">
      <h4 v-if="currentPageJjimList.length != 0"></h4>
      <h4 v-else class="text-center">
        찜 목록이 없습니다. 친구한테 영상 좀 보라고 해주세요.
      </h4>
      <table
        class="table table-striped table-bordered table-hover text-center"
        v-if="currentPageJjimList.length != 0"
      >
        <thead class="thead-dark">
          <tr>
            <th scope="col">번호</th>
            <th scope="col">썸네일</th>
            <th scope="col">채널명</th>
            <th scope="col">영상제목</th>
            <th scope="col">영상게시일</th>
          </tr>
        </thead>
        <tbody class="text-center">
          <friendsjjimListItem
            v-for="Jjim in currentPageJjimList"
            :key="Jjim.jjimId"
            :Jjim="Jjim"
          />
        </tbody>
      </table>
      <nav aria-label="Page navigation" v-if="currentPageJjimList.length != 0">
        <ul class="pagination d-flex justify-content-center">
          <li class="page-item">
            <a
              class="page-link"
              @click.prevent="currentPage--"
              :class="{ disabled: currentPage <= 1 }"
              href="#"
              >&lt;</a
            >
          </li>
          <li
            class="page-item"
            :class="{ active: currentPage === page }"
            v-for="page in pageCount"
            :key="page"
          >
            <a class="page-link" href="#" @click.prevent="clickPage(page)">{{
              page
            }}</a>
          </li>
          <li class="page-item">
            <a
              class="page-link"
              @click.prevent="currentPage++"
              :class="{ disabled: currentPage >= pageCount }"
              href="#"
              >&gt;</a
            >
          </li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useYoutubeStore } from "@/stores/youtube";
import friendsjjimListItem from "@/components/mypage/friendsjjimListItem.vue";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore";
import { useJjimStore } from "@/stores/jjimStore";
const userStore = useUserStore();
const jjimStore = useJjimStore();
const youtubeStore = useYoutubeStore();
const user = userStore.user;
const route = useRoute();

const userHasId = computed(() => user && user.hasOwnProperty("id"));

onMounted(() => {
  if (userHasId.value) {
    jjimStore.getfriendsJjimListAll(route.params.id);
  }
});

const perPage = 10;
const currentPage = ref(1);

const pageCount = computed(() => {
  return Math.ceil(jjimStore.jjimList.length / perPage);
});

const clickPage = function (page) {
  currentPage.value = page;
};

const currentPageJjimList = computed(() => {
  return jjimStore.friendjjimList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});

const router = useRouter();
const clickReview = function (Jjim) {
  youtubeStore.clickReview(Jjim.videoId);
  router.push({ name: "videoDetail", params: { id: Jjim.videoId } });
};
const goToFriends = () => {
  router.push({ name: "friends", params: { id: user.id } });
};
</script>

<style scoped>
h2 {
  display: inline-block;
  justify-content: center;
  align-items: center;
}
</style>

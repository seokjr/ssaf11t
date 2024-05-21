<template>
  <div class="container">
    <div class="mainContainer">
      <h4 class="text-center">{{ props.id }}님의 친구 목록</h4>
      <br />
      <p class="text-center" v-if="friendStore.friendsList.length === 0">
        아직 추가한 친구가 없습니다.
      </p>
      <div class="row">
        <div
          class="col-md-3"
          v-for="someone of friendStore.friendsList"
          :key="someone.id"
        >
          <myPageFriendsItem
            :someone="someone"
            :my_id="props.id"
            :type="'friend'"
          />
        </div>
      </div>
      <br />
    </div>
    <br />
    <div class="mainContainer">
      <h4 class="text-center">친구 추가 대기 목록</h4>
      <br />
      <p class="text-center" v-if="friendStore.waitingFriendsList.length === 0">
        대기 목록이 비어있습니다.
      </p>
      <div class="row">
        <div
          class="col-md-3"
          v-for="someone of friendStore.waitingFriendsList"
          :key="someone.id"
        >
          <myPageFriendsItem
            :someone="someone"
            :my_id="props.id"
            :type="'waiting'"
          />
        </div>
      </div>
    </div>
    <br />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useUserStore } from "@/stores/userStore";
import { useFriendStore } from "@/stores/friendStore";
import myPageFriendsItem from "./myPageFriendsItem.vue";

const userStore = useUserStore();
const friendStore = useFriendStore();

const props = defineProps({
  id: {
    type: String,
    required: true,
  },
});

onMounted(() => {
  friendStore.getAboutfriends(props.id);
});
</script>

<style scoped>
.mainContainer {
  border: 1px solid gray;
  padding: 15px;
}
</style>

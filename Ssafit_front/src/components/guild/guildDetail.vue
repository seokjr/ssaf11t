<template>
  <div>
    <h2 class="text-center d-flex justify-content-between align-items-center">
      {{ route.params.id }} 길드 입니다. {{ guildTag }} 길드에요.
      <div class="button-group ms-auto">
        <button
          v-if="userStatus == 'member'"
          class="btn btn-outline-danger"
          @click="confirmLeaveGuild"
        >
          탈퇴하기
        </button>
        <button
          v-if="userStatus == 'master'"
          class="btn btn-outline-danger"
          @click="confirmCloseGuild"
        >
          길드해체
        </button>
        <button class="btn btn-outline-primary" @click="goToGuild">
          길드목록으로 가기
        </button>
      </div>
    </h2>
    <br />
    <div class="container">
      <h4 v-if="guildStore.guildMemberList.length != 0">길드원 목록</h4>
      <h4 v-else class="text-center">
        가입한 유저가 없습니다 열심히 홍보하세요.
      </h4>
      <table
        class="table table-striped table-bordered table-hover text-center"
        v-if="guildStore.guildMemberList.length != 0"
      >
        <thead class="thead-dark">
          <tr>
            <th scope="col">가입번호</th>
            <th scope="col">유저ID</th>
            <th scope="col">너와 나의 눈높이</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="(member, index) in guildStore.guildMemberList"
            :key="index"
          >
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ member.userId }}</td>
            <td>{{ member.status }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { onMounted, computed } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore";
import { useGuildStore } from "@/stores/guildStore";

const userStore = useUserStore();
const guildStore = useGuildStore();
const route = useRoute();
const router = useRouter();

const user = userStore.getUser();

onMounted(() => {
  guildStore.selectGuildMember(route.params.id);
});

const goToGuild = () => {
  router.push({ name: "guildList" });
};

const leaveGuild = () => {
  guildStore.deleteRequest(user.id, route.params.id);
  router.push({ name: "guildList" });
};

const confirmLeaveGuild = () => {
  if (window.confirm("정말로 탈퇴하시겠습니까?")) {
    leaveGuild();
  }
};

const closeGuild = () => {
  guildStore.deleteGuild(route.params.id);
  router.push({ name: "guildList" });
};

const confirmCloseGuild = () => {
  if (window.confirm("정말로 해체하시겠습니까?")) {
    closeGuild();
  }
};

const guildTag = computed(() => {
  return guildStore.myguild == null ? "" : guildStore.myguild.tag;
});

const userStatus = computed(() => {
  return guildStore.guildMemberList.length == 0
    ? ""
    : guildStore.guildMemberList.find((member) => member.userId === user.id)
        .status;
});
</script>

<style scoped>
h2 {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.button-group {
  display: flex;
  gap: 10px;
}
</style>

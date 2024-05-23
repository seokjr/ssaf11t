<template>
  <div class="container">
    <h4 class="text-center">길드 검색</h4>
    <br />
    <div class="row justify-content-center align-items-center">
      <div class="col-2">
        <select class="form-select" v-model="searchInfo.key">
          <option value="guild_name">길드명</option>
          <option value="tag">태그</option>
        </select>
      </div>
      <div class="col-6">
        <input
          type="text"
          class="form-control"
          v-model="searchInfo.word"
          @keyup.enter="searchGuildList"
        />
      </div>
      <div class="col-auto">
        <button class="btn btn-primary custom-btn" @click="searchGuildList">
          검색
        </button>
      </div>
    </div>
    <br />
    <div class="mainContainer row" v-if="guildStore.guildList.length != 0">
      <div
        class="col-md-3"
        v-for="guild in guildStore.guildList"
        :key="guild.guildName"
      >
        <div>
          <RouterLink
            :to="{ name: 'guildDetail', params: { id: guild.guildName } }"
            @click="selectOneGuild(guild)"
            >길드명 : {{ guild.guildName }}
            <br />
            길드 태그 :
            {{ guild.tag }}</RouterLink
          >
          <button
            v-if="!requestSent"
            class="btn btn-outline-primary"
            @click="handleInsertRequest(guild)"
          >
            길드가입
          </button>
          <button
            class="btn btn-outline-danger"
            v-if="requestSent"
            @click="handleCancelRequest(guild)"
          >
            요청취소
          </button>
        </div>
      </div>
    </div>
    <h2 class="text-center" v-else>검색 결과가 없습니다.</h2>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useGuildStore } from "@/stores/guildStore";
import { useUserStore } from "@/stores/userStore";

const userStore = useUserStore();
const user = userStore.getUser();
const guildStore = useGuildStore();
const searchInfo = ref({
  key: "guild_name",
  word: "",
});

const searchGuildList = function () {
  guildStore.searchGuildList(searchInfo.value);
};

const selectOneGuild = async function (guild) {
  await guildStore.selectOneGuild(guild);
};

const requestSent = ref(false);
const handleInsertRequest = async function (guild) {
  guildStore.insertRequest(user.id, guild.guildName);
  requestSent.value = true;
};
const handleCancelRequest = async function (guild) {
  guildStore.deleteRequest(user.id, guild.guildName);
  requestSent.value = false;
};
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
}
.custom-btn {
  width: 80px;
}
.mainContainer {
  border: 1px solid gray;
  padding: 15px;
}
a {
  text-decoration: none;
  color: black;
}
</style>

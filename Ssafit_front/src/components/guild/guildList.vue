<template>
  <div class="container">
    <h2 class="text-center"><i class="bi bi-shield-shaded"></i> 길드 목록</h2>
    <div class="mainContainer">
      <h4 class="text-center">{{ user.id }}님의 길드 목록</h4>
      <br />
      <p class="text-center" v-if="guildStore.myGuildList.length === 0">
        아직 추가한 길드가 없습니다.
      </p>
      <div class="row">
        <div
          class="col-md-2"
          v-for="guild in guildStore.myGuildList"
          :key="guild.guildName"
        >
          <RouterLink
            :to="{ name: 'guildDetail', params: { id: guild.guildName } }"
            @click="selectOneGuild(guild.guildName)"
            >길드명 : {{ guild.guildName }}
          </RouterLink>
        </div>
      </div>
    </div>
    <hr />
    <guildSearch />
    <hr />
    <guildCreate />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useUserStore } from "@/stores/userStore";
import { useGuildStore } from "@/stores/guildStore";
import guildSearch from "@/components/guild/guildSearch.vue";
import guildCreate from "@/components/guild/guildCreate.vue";

const guildStore = useGuildStore();
const userStore = useUserStore();

const user = userStore.getUser();

onMounted(() => {
  guildStore.getMyGuildListAll(user.id);
});

const selectOneGuild = async function (guild) {
  await guildStore.selectOneGuild(guild);
};
</script>

<style scoped>
.mainContainer {
  border: 1px solid gray;
  padding: 15px;
}
a {
  text-decoration: none;
  color: black;
}
</style>

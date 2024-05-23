<template>
  <div class="container">
    <h4>길드 생성</h4>
    <fieldset>
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="guild_name"
          placeholder="길드명"
          v-model="guild.guildName"
        />
        <label for="guild_name">길드명</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="tag"
          placeholder="내용"
          v-model="guild.tag"
          @keyup.enter="createGuild"
        />
        <label for="tag">태그</label>
      </div>
      <div class="d-flex justify-content-end">
        <button class="btn btn-outline-primary" @click="createGuild">
          혈맹등록
        </button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore";
import { useGuildStore } from "@/stores/guildStore";
const router = useRouter();
const userStore = useUserStore();
const guildStore = useGuildStore();

const user = userStore.getUser();

const guild = ref({
  guildName: "",
  tag: "",
});

const createGuild = async function () {
  guildStore.createGuild(guild.value, userStore.getUser().id);
  guild.value = "";
  router.push({ name: "guildList" });
};
</script>

<style scoped></style>

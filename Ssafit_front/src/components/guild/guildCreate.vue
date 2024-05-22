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
          v-model="guildName"
        />
        <label for="guild_name">guild Name</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="tag"
          placeholder="내용"
          v-model="guildTag"
          @keyup.enter="createGuild"
        />
        <label for="tag">guild Tag</label>
      </div>
      <div class="d-flex justify-content-end">
        <button class="btn btn-outline-primary" @click="createGuild">
          등록
        </button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { useReviewStore } from "@/stores/reviewStore";
import { useYoutubeStore } from "@/stores/youtube";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore";
import { useGuildStore } from "@/stores/guildStore";
const route = useRoute();
const router = useRouter();
const userStore = useUserStore();
const guildStore = useGuildStore();

const user = userStore.getUser();

const guild = ref({
  guildName: "",
  tag: "",
});

const createGuild = async function () {
  guildStore.createGuild(guild);
};
</script>

<style scoped></style>

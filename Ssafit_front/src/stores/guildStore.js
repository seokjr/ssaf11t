import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

export const useGuildStore = defineStore("guild", () => {
  const REST_Guild_API = "http://localhost:8080/guild-api/";

  const guildList = ref([]);

  return { guildList };
});

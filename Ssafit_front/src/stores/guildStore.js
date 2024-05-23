import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useGuildStore = defineStore("guild", () => {
  const REST_GUILD_API = "http://localhost:8080/guild-api";

  const guildList = ref([]);
  const myguild = ref(null);
  const oneguild = ref(null);

  const myGuildList = ref([]);
  const getMyGuildListAll = async function (userId) {
    await axios.get(`${REST_GUILD_API}/myguild/${userId}`).then((res) => {
      myGuildList.value = res.data;
    });
  };

  const selectOneGuild = async function (guild) {
    await axios.get(`${REST_GUILD_API}/guild/${guild}`).then((res) => {
      myguild.value = res.data;
    });
  };

  const guildMemberList = ref([]);
  const selectGuildMember = async function (guildName) {
    await axios
      .get(`${REST_GUILD_API}/guild/${guildName}/guildMember`)
      .then((res) => {
        guildMemberList.value = res.data;
      });
  };

  const insertRequest = function (userId, GuildName) {
    axios({
      url: `${REST_GUILD_API}/guild/${userId}/${GuildName}`,
      method: "POST",
    });
  };

  const deleteRequest = function (userId, GuildName) {
    axios({
      url: `${REST_GUILD_API}/guild/${userId}/${GuildName}`,
      method: "DELETE",
    });
  };

  const getGuildListAll = async function () {
    await axios.get(`${REST_GUILD_API}/guild`).then((res) => {
      guildList.value = res.data;
    });
  };

  const searchGuildList = function (searchCondition) {
    axios
      .get(`${REST_GUILD_API}/guild`, {
        params: searchCondition,
      })
      .then((res) => {
        guildList.value = res.data;
      });
  };

  const createGuild = async function (guild, userId) {
    await axios({
      url: `${REST_GUILD_API}/guild/${userId}`,
      method: "POST",
      data: guild,
    });
  };

  const deleteGuild = async function (guildName) {
    console.log(guildName);
    await axios({
      url: `${REST_GUILD_API}/guild/${guildName}`,
      method: "DELETE",
    });
  };

  const getOneGuild = async function (guildName) {
    await axios.get(`${REST_GUILD_API}/guild/${guildName}`).then((res) => {
      oneguild.value = res.data;
    });
  };

  return {
    guildMemberList,
    selectGuildMember,
    selectOneGuild,
    getMyGuildListAll,
    getOneGuild,
    createGuild,
    deleteGuild,
    getGuildListAll,
    searchGuildList,
    guildList,
    myGuildList,
    oneguild,
    myguild,
    insertRequest,
    deleteRequest,
  };
});

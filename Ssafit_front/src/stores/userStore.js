import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

export const useUserStore = defineStore("user", () => {
  const REST_USER_API = "http://localhost:8080/user-api/";
  const user = ref(null);

  const checkSession = function () {
    const userData = sessionStorage.getItem("user");
    if (userData) {
      user.value = JSON.parse(userData);
    }
  };
  checkSession();
  const getUser = () => user.value;

  const login = function (userData) {
    axios({
      url: `${REST_USER_API}login`,
      method: "POST",
      data: userData,
    })
      .then((response) => {
        user.value = response.data;
        const userNow = {
          id: response.data.id,
          nickname: response.data.nickname,
        };
        sessionStorage.setItem("user", JSON.stringify(userNow));
        alert("로그인 성공");
        window.location.href = "/";
      })
      .catch((error) => {
        alert("입력하신 정보를 다시 확인해주세요.");
      });
  };

  const logout = function () {
    const URL = "http://localhost:8080/user-api/logout";
    axios
      .get(URL)
      .then(() => {
        sessionStorage.removeItem("user");
        user.value = null;
        alert("로그아웃 하셨습니다.");
        window.location.href = "/";
      })
      .catch((error) => {
        console.error("에러 발생", error);
      });
  };

  const signup = function (user) {
    console.log(user);
    axios({
      url: `${REST_USER_API}signup`,
      method: "POST",
      data: user,
    })
      .then((response) => {
        alert("회원가입 성공");
        router.push({ name: "login" });
      })
      .catch((error) => {
        alert(error.response.data);
      });
  };

  const userInfo = ref(null);
  const getUserInfo = function (userId) {
    axios({
      url: `${REST_USER_API}userInfo/${userId}`,
      method: "GET",
    })
      .then((response) => {
        userInfo.value = response.data;
      })
      .catch((error) => {
        alert(error.response.data);
      });
  };

  const changeUserInfo = function (newUser) {
    axios({
      url: `${REST_USER_API}changeUserInfo`,
      method: "POST",
      data: newUser,
    })
      .then((response) => {
        sessionStorage.removeItem("user");
        const userNow = {
          id: response.data.id,
          nickname: response.data.nickname,
        };
        sessionStorage.setItem("user", JSON.stringify(userNow));
        alert("회원 정보 수정 완료");
        router.push({ name: "myPageMain", params: { id: response.data.id } });
      })
      .catch((error) => {
        alert(error.response.data);
      });
  };

  const deleteUserInfo = function (userId) {
    console.log("여기로 오는가요?");
    axios({
      url: `${REST_USER_API}${userId}`,
      method: "DELETE",
    })
      .then(() => {
        sessionStorage.removeItem("user");
        user.value = null;
        alert("회원 탈퇴가 완료되었습니다.");
        router.push({ name: "home" }); // 홈으로 리다이렉트
      })
      .catch((error) => {
        console.error("에러 발생", error);
        alert("회원 탈퇴에 실패했습니다.");
      });
  };

  // id, nickname, profileImage을 키로 가지는 user에 대한 배열{id:'ssafy', nickname:'ssafy', profileImage:'first.jpg'}
  const userSearchResultList = ref([]);
  const getUserSearchList = function (searchInfo) {
    axios({
      url: `${REST_USER_API}userSearch/${searchInfo.key}/${searchInfo.word}`,
      method: "GET",
    })
      .then((response) => {
        userSearchResultList.value = response.data;
      })
      .catch((error) => {
        userSearchResultList.value = [];
      })
      .finally();
  };

  return {
    user,
    login,
    logout,
    signup,
    getUser,
    getUserInfo,
    userInfo,
    changeUserInfo,
    deleteUserInfo,
    userSearchResultList,
    getUserSearchList,
  };
});

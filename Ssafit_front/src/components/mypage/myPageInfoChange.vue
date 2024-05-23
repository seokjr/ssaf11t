<template>
  <div>
    <h2 class="text-center">회원 정보 수정/탈퇴</h2>
    <br />
    <form @submit.prevent="changeUserInfo">
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="id"
          placeholder="id"
          v-model.trim="userInfo.id"
          disabled
        />
        <label for="id">ID</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="name"
          placeholder="name"
          v-model.trim="userInfo.name"
          disabled
        />
        <label for="name">이름</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="email"
          class="form-control"
          id="email"
          placeholder="email"
          v-model.trim="userInfo.email"
          disabled
        />
        <label for="email">이메일</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="nickname"
          placeholder="nickname"
          v-model.trim="userInfo.nickname"
        />
        <label for="nickname">별명</label>
      </div>

      <div class="form-floating mb-3">
        <p>&nbsp;프로필 사진</p>
        <div class="image-radio-container">
          <div class="profile-option">
            <div class="box">
              <img
                src="/images/profileImage/first.jpg"
                alt="Profile Image1"
                class="profile"
              />
            </div>
            <input
              class="form-check-input"
              type="radio"
              name="profileImage"
              id="profile1"
              value="first.jpg"
              v-model="userInfo.profileImage"
            />
          </div>

          <div class="profile-option">
            <div class="box">
              <img
                src="/images/profileImage/second.jpg"
                alt="Profile Image2"
                class="profile"
              />
            </div>
            <input
              class="form-check-input"
              type="radio"
              name="profileImage"
              id="profile2"
              value="second.jpg"
              v-model="userInfo.profileImage"
            />
          </div>

          <div class="profile-option">
            <div class="box">
              <img
                src="/images/profileImage/third.jpg"
                alt="Profile Image3"
                class="profile"
              />
            </div>
            <input
              class="form-check-input"
              type="radio"
              name="profileImage"
              id="profile3"
              value="third.jpg"
              v-model="userInfo.profileImage"
            />
          </div>

          <div class="profile-option">
            <div class="box">
              <img
                src="/images/profileImage/fourth.jpg"
                alt="Profile Image4"
                class="profile"
              />
            </div>
            <input
              class="form-check-input"
              type="radio"
              name="profileImage"
              id="profile4"
              value="fourth.jpg"
              v-model="userInfo.profileImage"
            />
          </div>

          <div class="profile-option">
            <div class="box">
              <img
                src="/images/profileImage/fifth.jpg"
                alt="Profile Image5"
                class="profile"
              />
            </div>
            <input
              class="form-check-input"
              type="radio"
              name="profileImage"
              id="profile5"
              value="fifth.jpg"
              v-model="userInfo.profileImage"
            />
          </div>
        </div>
      </div>

      <br />
      <div class="input-group mb-3">
        <input
          type="password"
          class="form-control"
          id="password"
          placeholder="회원 정보 수정을 원하시면 비밀번호 입력 후 버튼을 눌러주세요."
          aria-label="password"
          aria-describedby="button-addon2"
          @keyup.enter="changeUserInfo"
          v-model.trim="password"
        />
        <button
          type="submit"
          class="btn btn-outline-secondary"
          id="button-addon2"
        >
          수정
        </button>
      </div>
    </form>
    <div class="text-center">
      <button class="btn btn-outline-danger text-center" @click="confirmDelete">
        회원탈퇴
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted, watch } from "vue";
import { useUserStore } from "@/stores/userStore";
const userStore = useUserStore();

const user = userStore.user;

const { getUserInfo } = useUserStore();
const userHasId = computed(() => user && user.hasOwnProperty("id"));
const userInfo = ref({
  id: "",
  password: "",
  nickname: "",
  email: "",
  name: "",
  profileImage: "",
});

onMounted(() => {
  if (userHasId.value) {
    getUserInfo(user.id);
  }
});

watch(
  () => userStore.userInfo,
  (newInfo) => {
    userInfo.value = newInfo;
  }
);

const newUserInfo = ref({
  id: "",
  nickname: "",
  name: "",
  email: "",
  profileImage: "",
});
const password = ref("");
const changeUserInfo = function () {
  if (userInfo.value.nickname === "") {
    alert("별명은 비워둘 수 없습니다.");
  } else if (password.value === userInfo.value.password) {
    newUserInfo.value.id = userInfo.value.id;
    newUserInfo.value.nickname = userInfo.value.nickname;
    newUserInfo.value.email = userInfo.value.email;
    newUserInfo.value.name = userInfo.value.name;
    newUserInfo.value.profileImage = userInfo.value.profileImage;
    userStore.changeUserInfo(newUserInfo.value);
  } else {
    alert("비밀번호가 올바르지 않습니다.");
  }
};

const confirmDelete = function () {
  if (confirm("정말로 회원탈퇴를 하시겠습니까?")) {
    userStore.deleteUserInfo(userInfo.value.id);
  }
};
</script>

<style scoped>
.image-radio-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.profile-option {
  text-align: center; /* 이미지와 라벨을 가운데 정렬 */
  position: relative; /* 상대 위치 설정 */
}

.box {
  width: 150px;
  height: 150px;
  border-radius: 70%;
  overflow: hidden;
  background: #bdbdbd;
  margin: 0px 0px 50px 0px;
}

.profile {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.form-check-input {
  display: block; /* 블록 요소로 변환하여 위아래로 배치 */
  margin: 0 auto; /* 수평 가운데 정렬 */
  position: absolute; /* 절대 위치 설정 */
  bottom: 10px; /* 아래쪽 간격 조절 */
  left: 0; /* 왼쪽 위치를 0으로 설정하여 중앙 정렬 */
  right: 0; /* 오른쪽 위치를 0으로 설정하여 중앙 정렬 */
}
</style>

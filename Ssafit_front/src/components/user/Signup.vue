<template>
  <div class="container">
    <h1>회원가입</h1>
    <p class="text-danger">{{ msg }}</p>
    <form @submit.prevent="signup">
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="id"
          placeholder="id"
          v-model.trim="user.id"
        />
        <label for="id">ID</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="password"
          class="form-control"
          id="password"
          placeholder="password"
          v-model.trim="user.password"
        />
        <label for="writer">PassWord</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="test"
          class="form-control"
          id="nickname"
          placeholder="nickname"
          v-model.trim="user.nickname"
        />
        <label for="nickname">별명</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="text"
          class="form-control"
          id="name"
          placeholder="name"
          v-model.trim="user.name"
        />
        <label for="name">이름</label>
      </div>
      <div class="form-floating mb-3">
        <input
          type="email"
          class="form-control"
          id="email"
          placeholder="email"
          v-model.trim="user.email"
          @keyup.enter="signup"
        />
        <label for="email">이메일</label>
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
              v-model="user.profileImage"
              checked
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
              v-model="user.profileImage"
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
              v-model="user.profileImage"
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
              v-model="user.profileImage"
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
              v-model="user.profileImage"
            />
          </div>
        </div>
      </div>

      <br />

      <div class="d-flex justify-content-end">
        <button type="submit" class="btn btn-outline-primary">회원가입</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";
const userStore = useUserStore();

const msg = ref("");

const user = ref({
  id: "",
  password: "",
  nickname: "",
  name: "",
  email: "",
  profileImage: "",
});

const signup = function () {
  if (
    id.value !== "" &&
    password.value !== "" &&
    nickname.value !== "" &&
    name.value !== "" &&
    email.value !== ""
  ) {
    userStore.signup(user.value);
  } else {
    alert("모든 정보를 입력해주세요.");
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

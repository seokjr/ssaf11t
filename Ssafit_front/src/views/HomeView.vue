<template>
  <div class="container">
    <h2 style="color: rgb(123, 169, 187)">Ssaf11t</h2>
    <div
      id="carouselExampleAutoplaying"
      class="carousel slide"
      data-bs-ride="carousel"
    >
      <div class="carousel-inner">
        <!-- First carousel item -->
        <div class="carousel-item active">
          <div class="d-block w-100">
            <p>
              <strong>프로젝트 목적</strong><br />
              우리 프로젝트의 목적은 사용자들이 건강하고 활기찬 라이프스타일을
              즐길 수 있도록 지원하는 것입니다. 이를 통해 사용자들이 운동 및
              건강에 대한 지식을 습득하고, 몸과 마음의 건강을 증진시킬 수 있도록
              돕습니다.
            </p>
          </div>
        </div>
        <!-- Second carousel item -->
        <div class="carousel-item">
          <div class="d-block w-100">
            <p>
              <strong>우리 프로젝트를 사용하면 좋은 이유</strong><br />
              1. <strong>다양한 운동 및 건강 정보 제공:</strong> 우리 프로젝트는
              다양한 운동 및 건강 정보를 제공하여 사용자들이 자신에게 맞는 운동
              및 건강 관리 방법을 찾을 수 있습니다. 이를 통해 사용자들은 자신의
              목표에 맞게 운동을 계획하고 건강을 유지할 수 있습니다.<br />
              2. <strong>커뮤니티 및 지원:</strong> 우리 프로젝트는 사용자들
              간의 소통과 지원을 돕기 위한 커뮤니티를 제공합니다. 사용자들은
              서로의 경험을 공유하고 동기부여를 받아 자신의 목표를 달성할 수
              있습니다. 또한 전문가들이 제공하는 조언과 지원을 받을 수 있어 더욱
              효과적인 운동 및 건강 관리가 가능합니다.<br />
            </p>
          </div>
        </div>
        <!-- Third carousel item -->
        <div class="carousel-item">
          <div class="d-block w-100">
            <p>
              3. <strong>개인화된 서비스:</strong> 우리 프로젝트는 사용자들의
              개인적인 상황과 목표에 맞게 맞춤형 서비스를 제공합니다. 사용자들은
              자신의 목표와 선호하는 운동 방식에 맞게 개인화된 운동 계획을 받을
              수 있으며, 식이 요법 및 건강 정보 역시 개인의 상황에 맞게
              제공됩니다.<br />
              4. <strong>우리 프로젝트를 선택해야 하는 이유:</strong> 다른 운동
              관련 서비스와 비교했을 때, 우리 프로젝트는 사용자들에게 더 많은
              이점을 제공합니다. 우리의 특별한 기능과 서비스를 통해 사용자들은
              효율적이고 개인화된 운동 및 건강 관리를 경험할 수 있습니다.
            </p>
          </div>
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleAutoplaying"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleAutoplaying"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script setup>
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
</script>

<style scoped>
.container {
  padding: 20px;
}
.carousel-item {
  padding: 20px;
}
</style>

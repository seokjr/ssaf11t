<template>
  <div>
    <HeaderNav class="header"/>
    <div class="cen">
      <RouterView />
    </div>
    <Footer/>
  </div>
  
</template>
<script setup>
import { RouterLink, RouterView } from 'vue-router';
import HeaderNav from '@/components/common/HeaderNav.vue'
import Footer from '@/components/common/Footer.vue'
</script>
<style scoped>
.header {
  margin-bottom: 1.5rem; /* HeaderNav 아래 여백 추가 */
}
.cen{
  margin-bottom: 1rem;
  min-height: calc(100vh - 10rem); /* footer 높이를 빼준다. */
}
Footer{
	height: 10rem; /* footer 높이 */
}
</style>
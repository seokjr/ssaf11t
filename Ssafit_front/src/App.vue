<template>
  <div>
    <HeaderNav/>
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
.cen{
  margin-bottom: 1rem;
  min-height: calc(100vh - 10rem); /* footer 높이를 빼준다. */
}
Footer{
	height: 10rem; /* footer 높이 */
}
</style>
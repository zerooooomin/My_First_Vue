<!-- <template>
  <NavbarComponent/>

  <div class="card-container">
    <CardComponent
      v-for="board in boards"
      :key="board.id"
      :title="board.title"
      :content="board.content"
    />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue' // onMounted를 임포트합니다
import NavbarComponent from './components/NavbarComponent.vue'
import CardComponent from './components/CardComponent.vue'
import axios from 'axios'

const boards = ref([])

onMounted(async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/board')
        boards.value = response.data
    } catch (error) {
        console.error("There was an error fetching the boards!", error)
    }
})
</script>

<style scoped>
.card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem; /* 카드 간격 */
}
</style> -->


<template>
  <RouterView />
</template>

<script setup>
import { createApp } from 'vue'
import router from './router'
import './assets/main.css'
import 'bootstrap/dist/css/bootstrap.css'
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle'

const app = createApp()
app.use(router)
app.use(bootstrap)
app.mount('#app')
</script>

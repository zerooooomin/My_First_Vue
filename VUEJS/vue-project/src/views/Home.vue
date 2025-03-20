<template>
  <div class="navcontainer">
    <NavbarComponent/>
  </div>

  <div class="container">
    <div class="button-container">
      <router-link to="/create" class="btn btn-primary">새 게시물 작성</router-link>
    </div>
    
    <div class="card-container">
      <CardComponent
        v-for="board in boards"
        :key="board.id"
        :title="board.title"
        :content="board.content"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import NavbarComponent from '../components/NavbarComponent.vue'
import CardComponent from '../components/CardComponent.vue'
import axios from 'axios'

const boards = ref([])

onMounted(async () => {
    await fetchBoards()
})

const fetchBoards = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/board')
        boards.value = response.data
    } catch (error) {
        console.error("There was an error fetching the boards!", error)
    }
}
</script>

<style scoped>
.navcontainer {
  width: 100vw; /* 전체 너비 */
  height: 60px; /* NavbarComponent와 동일한 높이 */
  position: fixed; /* 고정 위치 설정 */
  top: 0; /* 상단에 고정 */
  left: 0; /* 왼쪽에 고정 */
  z-index: 1000; /* 다른 요소 위에 표시되도록 설정 */
}

.container {
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 60px; /* Navbar의 높이만큼 여백 추가 */
}

.button-container {
  margin-bottom: 20px; /* 버튼과 카드 간의 간격 */
  display: flex;
  justify-content: center; /* 버튼 중앙 정렬 */
}

.card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem; /* 카드 간격 */
  justify-content: center;
}
</style>

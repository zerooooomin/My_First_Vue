<template>
  <div>
    <div class="navcontainer"> <!-- NavbarComponent를 감싸는 div 추가 -->
      <NavbarComponent />
    </div>

    <div class="create-board">
      <h2>새 게시물 작성</h2>
      <form @submit.prevent="submitForm">
        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input type="text" id="title" v-model="title" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <textarea id="content" v-model="content" class="form-control" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">게시물 작성</button>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
import NavbarComponent from '../components/NavbarComponent.vue' // NavbarComponent 임포트

const title = ref('')
const content = ref('')
const router = useRouter()

const submitForm = async () => {
    try {
        const response = await axios.post('http://localhost:8080/api/board', {
            title: title.value,
            content: content.value
        })
        console.log("게시물이 성공적으로 작성되었습니다:", response.data)
        
        // 게시물 작성 후 홈페이지로 이동
        router.push('/') 

        // 입력 필드 초기화 (선택 사항)
        title.value = ''
        content.value = ''
    } catch (error) {
        console.error("게시물 작성 중 오류가 발생했습니다:", error)
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

.create-board {
  max-width: 600px;
  margin: auto;
  margin-top: 60px; /* Navbar의 높이만큼 여백 추가 */
}
</style>

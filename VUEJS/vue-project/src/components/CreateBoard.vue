<template>
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
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import axios from 'axios'
  
  const title = ref('')
  const content = ref('')
  
  const submitForm = async () => {
      try {
          const response = await axios.post('http://localhost:8080/api/board', {
              title: title.value,
              content: content.value
          })
          console.log("게시물이 성공적으로 작성되었습니다:", response.data)
          // 작성 후 입력 필드를 초기화
          title.value = ''
          content.value = ''
      } catch (error) {
          console.error("게시물 작성 중 오류가 발생했습니다:", error)
      }
  }
  </script>
  
  <style scoped>
  .create-board {
      max-width: 600px;
      margin: auto;
  }
  </style>
  
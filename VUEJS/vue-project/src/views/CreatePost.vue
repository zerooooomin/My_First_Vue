<template>
    <div>
      <h1>글 작성</h1>
      <input v-model="title" placeholder="제목" />
      <textarea v-model="content" placeholder="내용"></textarea>
      <button @click="submitPost">완료</button>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import { usePostStore } from '../store';
  
  const title = ref('');
  const content = ref('');
  const router = useRouter();
  const postStore = usePostStore();
  
  const submitPost = async () => {
    await postStore.addPost(title.value, content.value);
    router.push('/');
  };
  </script>
  
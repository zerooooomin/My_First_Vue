import { defineStore } from 'pinia';
import axios from 'axios';

export const usePostStore = defineStore('postStore', {
  state: () => ({ posts: [] }),
  actions: {
    async fetchPosts() {
      const response = await axios.get('http://localhost:3000/posts');
      this.posts = response.data;
    },
    async addPost(title, content) {
      await axios.post('http://localhost:3000/posts', { title, content });
      this.fetchPosts();
    }
  }
});

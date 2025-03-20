
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

// import './assets/main.css'

// import { createApp } from 'vue'
// import App from './App.vue'

// import 'bootstrap/dist/css/bootstrap.css'
// import bootstrap from 'bootstrap/dist/js/bootstrap.bundle'

// createApp(App).use(bootstrap).mount('#app')

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/main.css'

createApp(App)
  .use(router)
  .mount('#app')

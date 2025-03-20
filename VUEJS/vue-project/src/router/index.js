import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import CreateBoard from '../views/CreateBoard.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/create',
        name: 'CreateBoard',
        component: CreateBoard
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router

import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
	{
		path: '/',
		name: 'Home',
		component: () => import(/* webpackChunkName: "about" */ '@/views/Home.vue'),
	},

	/* test component */
	{
		path: '/test',
		name: 'TEST',
		component: () => import(/* webpackChunkName: "about" */ '../test/TestComponent.vue'),
	},
	{
		path: '/board/write',
		name: 'Write',
		component: () => import('@/views/BoardWrite.vue'),
	},

	// 404
	{
		path: '/404',
		name: 'Not Found',
		component: () => import('@/views/NotFound.vue'),
	},
	{
		path: '*',
		redirect: '/404',
	},
];

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
});

export default router;

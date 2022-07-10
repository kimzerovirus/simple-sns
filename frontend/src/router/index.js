import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes: [
		{
			path: '/',
			name: 'Home',
			component: () => import(/* webpackChunkName: "about" */ '@/views/HomePage.vue'),
		},
		{
			path: '/login',
			name: 'Login',
			component: () => import('@/views/LoginPage.vue'),
		},
		{
			path: '/board',
			name: 'Board',
			component: () => import('@/views/BoardListPage.vue'),
		},
		{
			path: '/board/write',
			name: 'Write',
			component: () => import('@/views/BoardWritePage.vue'),
			meta: { auth: true, query: true },
		},
		{
			path: '/board/qna/:id',
			name: 'ReadQna',
			component: () => import('@/views/BoardReadPage.vue'),
		},
		{
			path: '/board/free/:id',
			name: 'ReadFree',
			component: () => import('@/views/BoardReadPage.vue'),
		},

		/* test component */
		{
			path: '/test',
			name: 'TEST',
			component: () => import(/* webpackChunkName: "about" */ '../test/TestComponent.vue'),
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
	],
});

const queryGuard = (query, checkList) => {
	let isCheck = false;
	checkList.forEach(el => {
		if (el === query) isCheck = true;
	});
	return isCheck;
};

router.beforeEach((to, from, next) => {
	// if (to.meta.auth) {
	// 	// 토큰 유효성 검사
	// 	next('/login');
	// }

	if (to.meta.query) {
		const pass = queryGuard(to.query.mid, ['qna', 'free']);
		if (!pass) {
			next('/');
			return;
		}
	}
	next();
});

export default router;

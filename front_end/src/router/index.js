import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../components/login/index.vue'

Vue.use(VueRouter)

const routes = [{
		path: '/',
		name: 'index',
		component: login
	},
	{
		path: '/register',
		name: 'register',
		component: () => import('../views/register/shipper.vue'),
	},
	/*----------------------------------------------------------------*/
	{
		path: '/index',
		name: 'index',
		component: () => import('../components/main/index.vue'),
		children: [{
			path: '/',
			name: '',
			component: () => import('../components/index/index.vue'),
		}, {
			path: '/adminInfo',
			name: 'adminInfo',
			component: () => import('../views/positions/info.vue'),
		}, {
			path: '/khInfo',
			name: 'khInfo',
			component: () => import('../views/positions/info.vue'),
		}, {
			path: '/kdyInfo',
			name: 'kdyInfo',
			component: () => import('../views/positions/info.vue'),
		}, {
			path: '/myinfo',
			name: 'myinfo',
			component: () => import('../views/positions/myInfo.vue'),
		}, {
			path: '/waybillall',
			name: 'waybillall',
			component: () => import('../views/waybill/selectAll.vue'),
		}, {
			path: '/waybilladd',
			name: 'waybilladd',
			component: () => import('../views/waybill/add.vue'),
		}, {
			path: '/evaluateall',
			name: 'evaluateall',
			component: () => import('../views/evaluate/selectAll.vue'),
		}, {
			path: '/personnelInfoall',
			name: 'personnelInfoall',
			component: () => import('../views/personnel_info/selectAll.vue'),
		}, {
			path: '/personnelInfoadd',
			name: 'personnelInfoadd',
			component: () => import('../views/personnel_info/add.vue'),
		}, {
			path: '/bb',
			name: 'bb',
			component: () => import('../views/echarts/bb.vue'),
		}, {
			path: '/orders',
			name: 'orders',
			component: () => import('../views/echarts/orders.vue'),
		}, 
		]
	}, {
		path: '*',
		hidden: true,
		redirect: {
			path: '/'
		}
	}
]

const router = new VueRouter({
	mode: 'hash',
	base: process.env.BASE_URL,
	routes
})

export default router

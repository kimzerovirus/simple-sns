<template>
	<div class="container">
		<table class="table">
			<tr>
				<th>test</th>
			</tr>
			<tr v-for="item in data" :key="item.idx">
				{{
					item
				}}
			</tr>
		</table>
		<Pagination :pageable="pageable" @goPage="goPage" />
	</div>
</template>

<script>
import Pagination from '@/components/Pagination.vue';
export default {
	components: {
		Pagination,
	},
	data() {
		return {
			pageable: {},
			data: [],
		};
	},
	created() {
		this.getData();
	},
	methods: {
		goPage(pageNumber) {
			this.pageable.pageNumber = pageNumber;
			this.getData();
		},
		async getData() {
			// const { data } = await testApi({
			// 	pageNumber: this.pageable.pageNumber || 0,
			// 	pageSize: 10,
			// });

			const data = require('../__mock__/pageable.json');

			this.data = data.content;
			this.pageable = data.pageable;
			this.pageable.totalElements = data.totalElements;
			this.pageable.totalPages = data.totalPages;
			this.pageable.first = data.first;
			this.pageable.last = data.last;
			console.log(this.pageable);
		},
	},
};
</script>

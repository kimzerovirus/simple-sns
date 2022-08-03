<template>
	<div>
		<div class="container my-5">
			<!-- <table class="table align-middle mb-0 bg-white shadow-sm bg-white rounded"> -->
			<table class="table align-middle mb-0 bg-white bg-white rounded">
				<tbody>
					<ListItem v-for="item in data" :key="item.idx" />
				</tbody>
			</table>
		</div>
		<Pagination :pageable="pageable" @goPage="goPage" />
	</div>
</template>

<script>
import Pagination from '@/components/Pagination.vue';
import ListItem from '@/components/ListItem.vue';
export default {
	components: {
		Pagination,
		ListItem,
	},

	data() {
		return {
			pageable: {},
			value: '',
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

<template>
	<div>
		<TextViewer :content="content" />
	</div>
</template>

<script>
import TextViewer from '@/components/TextViewer.vue';

export default {
	components: {
		TextViewer,
	},
	mounted() {
		// vuex에서 데이터에 값이 없다면
		// api 호출해서
		// 데이터 가져오기
	},
	data() {
		return {
			title: '제목',
			content: '<h1>This is Viewer.</h1> \n Hello World.<br/>',
		};
	},
};
</script>

<style></style>

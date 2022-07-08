<template>
	<div>
		<Viewer :initialValue="content" />
		<div v-html="content"></div>
	</div>
</template>

<script>
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import { Viewer } from '@toast-ui/vue-editor';

export default {
	components: {
		Viewer,
	},
	data() {
		return {
			content: '# This is Viewer.\n Hello World.',
		};
	},
};
</script>

<style></style>

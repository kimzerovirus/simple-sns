<template>
	<div>
		<Viewer :initialValue="content" />
	</div>
</template>

<script>
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import { Viewer } from '@toast-ui/vue-editor';

export default {
	props: ['content'],
	components: {
		Viewer,
	},
};
</script>

<style></style>

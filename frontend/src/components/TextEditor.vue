<template>
	<div>
		<Editor ref="editor" initialEditType="wysiwyg" height="80vh" :options="options" previewStyle="tab" />
		<button @click="handleSubmit" class="btn btn-primary">저장하기</button>
	</div>
</template>

<script>
// api참고 https://nhn.github.io/tui.editor/latest/ToastUIEditorCore
// toast ui ver3.0
import { Editor } from '@toast-ui/vue-editor'; // https://github.com/nhn/tui.editor/tree/master/apps/vue-editor
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/i18n/ko-kr';
import '@toast-ui/editor/dist/theme/toastui-editor-dark.css'; // dark mode theme

export default {
	components: {
		Editor,
	},
	data() {
		return {
			options: {
				minHeight: '300px',
				language: 'ko-KR', // js언어팩 import 필요 https://github.com/nhn/tui.editor/blob/master/docs/en/i18n.md
				hideModeSwitch: true, // 마크다운 선택지 제거
				toolbarItems: [
					['heading', 'bold', 'italic', 'strike'],
					['hr', 'quote'],
					// ['ul', 'ol', 'task', 'indent', 'outdent'],
					[/*'table',*/ 'image', 'link'],
					['code', 'codeblock'],
					['scrollSync'],
				],
				/*
				hooks: {
					addImageBlobHook: (blob, callback) => {
						(async () => {
							let formDate = new FormData();
							formDate.append('file', blob);
							axios.defaults.withCredentials = true;
							const { data: url } = await axios.post(`${backUrl}image.do`, formData, {
								header: { 'content-type': 'multipart/formdata' },
							});
							callback(url, 'img'); // 콜백함수의 인자는 img태그의 src와 alt에 들어갈 값 2개를 받음
						})();
						return false;
					},
				},
				*/
			},
		};
	},
	methods: {
		handleSubmit() {
			console.log(this.getContent());
		},
		getContent() {
			return this.$refs.editor.invoke('getHTML');
		},
	},
};
</script>

<style></style>

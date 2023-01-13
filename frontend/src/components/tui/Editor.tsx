import '@toast-ui/editor/dist/toastui-editor.css';

import { HookCallback } from '@toast-ui/editor/types/editor';
// import '@toast-ui/editor/dist/theme/toastui-editor-dark.css';
import { Editor as TuiEditor } from '@toast-ui/react-editor';
import { useTheme } from 'next-themes';
import React from 'react';

// https://ui.toast.com/tui-editor
// https://github.com/remirror/remirror-examples/blob/main/with-nextjs/components/editor.tsx
// https://github.com/bprofiro/editor/blob/main/src/components/Editor/index.tsx

interface EditorProps {
	// setContent: (slug: string) => void;
	content: string;
	editorRef: React.Ref<any>;
}

type UploadImageHook = ((blob: Blob | File, callback: HookCallback) => void) | undefined;

const Editor: React.FC<EditorProps> = ({ content, editorRef }) => {
	const { theme } = useTheme();
	const toolbarItems = [
		['heading', 'bold', 'italic', 'strike'],
		['hr'],
		['ul', 'ol', 'task'],
		['table', 'link'],
		// ['image'],
		// ['code'],
		['scrollSync'],
	];

	const onUploadImage: UploadImageHook = async (blob, callback) => {
		console.log(blob);
		callback('https://www.naver.com', 'alt text');
		return false;
	};

	return (
		// tui는 theme props를 제공하지만 처음 만들어질 때 정해진 테마로 고정되므로 동적으로 테마를 설정하려면 직접 클래스를 주고서 분기를 작성한다.
		<div className={`${theme === 'dark' && 'toastui-editor-dark'}`}>
			{editorRef && (
				<TuiEditor
					placeholder="내용을 입력해주세요."
					ref={editorRef}
					initialValue={content || ' '} // 글 수정 시 사용
					initialEditType="wysiwyg" // wysiwyg & markdown
					previewStyle={'vertical'} // tab, vertical
					hideModeSwitch={true}
					minHeight={'300px'}
					// theme={'dark'} // '' & 'dark' // 동적으로 사용이 안된다 - wrapper 클래스에 클래스 부여하거나 직접 dom 조작할것
					usageStatistics={false}
					toolbarItems={toolbarItems}
					useCommandShortcut={true}
					hooks={{
						addImageBlobHook: onUploadImage,
					}}
				/>
			)}
		</div>
	);
};

export default Editor;

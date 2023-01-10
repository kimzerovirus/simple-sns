import { useHelpers, useRemirrorContext } from '@remirror/react';
import { OnChangeJSON } from '@remirror/react';
import { WysiwygEditor } from '@remirror/react-editors/wysiwyg';
import { useTheme } from 'next-themes';
import React, { useCallback } from 'react';
import type { RemirrorJSON } from 'remirror';
import Container from 'src/components/layout/Container';

// https://github.com/remirror/remirror-examples/blob/main/with-nextjs/components/editor.tsx
// https://github.com/bprofiro/editor/blob/main/src/components/Editor/index.tsx

interface EditorProps {
	setContent: (slug: string | RemirrorJSON) => void;
}

const SaveButton: React.FC<EditorProps> = ({ setContent }) => {
	const { getHTML, getJSON } = useHelpers();
	const handleClick = useCallback(() => {
		const html = getHTML();
		const json = getJSON();
		setContent(html);
		// alert(JSON.stringify(getJSON()));
		console.log(new DOMParser().parseFromString(html, 'text/xml'));
	}, [getHTML]);

	return (
		<button onMouseDown={event => event.preventDefault()} onClick={handleClick}>
			Save
		</button>
	);
};

const Editor: React.FC<EditorProps> = ({ setContent }) => {
	return (
		<Container>
			<WysiwygEditor placeholder="Start typing...">
				<SaveButton setContent={setContent} />
			</WysiwygEditor>
		</Container>
	);
};

export default Editor;

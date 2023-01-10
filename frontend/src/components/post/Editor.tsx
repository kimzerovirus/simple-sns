import { ThemeProvider, useHelpers, useRemirrorContext, useTheme } from '@remirror/react';
import { WysiwygEditor } from '@remirror/react-editors/wysiwyg';
import React, { useCallback } from 'react';
import Container from 'src/components/layout/Container';

const Editor: React.FC = () => {
	const theme = useTheme();
	console.log(theme);
	return (
		<Container>
			<WysiwygEditor placeholder="Start typing...">
				<LoadButton />
				<SaveButton />
			</WysiwygEditor>
		</Container>
	);
};

export default Editor;

const SAMPLE_DOC = {
	type: 'doc',
	content: [
		{
			type: 'paragraph',
			attrs: { dir: null, ignoreBidiAutoUpdate: null },
			content: [{ type: 'text', text: 'Loaded content' }],
		},
	],
};

function LoadButton() {
	const { setContent } = useRemirrorContext();
	const handleClick = useCallback(() => setContent(SAMPLE_DOC), [setContent]);

	return (
		<button onMouseDown={event => event.preventDefault()} onClick={handleClick}>
			Load
		</button>
	);
}

function SaveButton() {
	const { getJSON } = useHelpers();
	const handleClick = useCallback(() => alert(JSON.stringify(getJSON())), [getJSON]);

	return (
		<button onMouseDown={event => event.preventDefault()} onClick={handleClick}>
			Save
		</button>
	);
}

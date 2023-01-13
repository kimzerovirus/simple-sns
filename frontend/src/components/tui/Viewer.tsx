import '@toast-ui/editor/dist/toastui-editor.css';

import { Viewer } from '@toast-ui/react-editor';
import { useTheme } from 'next-themes';
import React from 'react';

interface ViewerProps {
	content: string;
}

const PostView: React.FC<ViewerProps> = ({ content }) => {
	const { theme } = useTheme();
	return (
		<div className={`${theme === 'dark' && 'toastui-editor-dark'} min-h-[300px]`}>
			{content && <Viewer initialValue={content} />}
		</div>
	);
};

export default PostView;

import dynamic from 'next/dynamic';
import React from 'react';
import { Suspense, useCallback, useState } from 'react';
import type { RemirrorJSON } from 'remirror';

const Editor = dynamic(() => import('src/components/post/Editor'), {
	loading: () => <p>Loading editor...</p>,
	ssr: false,
});

const PostWritePage = () => {
	const [content, setContent] = React.useState<string | RemirrorJSON>();
	return (
		<>
			<Editor setContent={(slug: string | RemirrorJSON) => setContent(slug)} />
		</>
	);
};

export default PostWritePage;

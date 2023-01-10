import dynamic from 'next/dynamic';
import React from 'react';
import { Suspense, useCallback, useState } from 'react';

const Editor = dynamic(() => import('src/components/post/Editor'), {
	loading: () => <p>Loading editor...</p>,
	ssr: false,
});

const PostWritePage = () => {
	return (
		<>
			<Editor />
		</>
	);
};

export default PostWritePage;

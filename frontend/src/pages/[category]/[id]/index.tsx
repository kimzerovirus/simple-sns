import React from 'react';
import PostView from 'src/components/post/PostView';

const PostViewPage = () => {
	return (
		<>
			<PostView
				content="Hello Wolrd!<br/> Hello World too"
				title="title"
				tags={['태그1', '태그2']}
				views={123}
				date={'2021-12-30'}
			/>
		</>
	);
};

export default PostViewPage;

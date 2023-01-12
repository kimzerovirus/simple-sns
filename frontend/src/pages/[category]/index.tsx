import React from 'react';
import Container from 'src/components/layout/Container';
import PostList from 'src/components/post/PostList';
import { categoryList } from 'src/static/data';

const PostListPage = () => {
	return (
		<Container>
			<PostList />
		</Container>
	);
};

export default PostListPage;

export async function getStaticPaths() {
	return {
		paths: categoryList.map(category => ({ params: { category: category.href } })),
		fallback: false,
	};
}

export async function getStaticProps() {
	return { props: {} };
}

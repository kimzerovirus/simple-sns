import React from 'react';
import { categoryList } from 'src/static/data';

const PostListPage = () => {
	return <></>;
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

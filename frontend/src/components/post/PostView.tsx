import dynamic from 'next/dynamic';
import Link from 'next/link';
import React from 'react';
import Border from 'src/components/common/Border';
import Container from 'src/components/common/Container';

import { TagList } from './Tags';

const Viewer = dynamic(() => import('src/components/tui/Viewer'), {
	ssr: false,
	loading: () => <p>Loading viewer...</p>,
});

interface PostViewProps {
	content: string;
	title: string;
	tags: string[];
	views: number;
	date: string;
}

const PostView: React.FC<PostViewProps> = ({ content, title, tags }) => {
	return (
		<Container>
			{/* TITLE */}
			<h1 className="block break-all text-xl font-semibold leading-7 sm:text-3xl sm:leading-10 mt-7">
				공부중인 학생인데 제가 너무 바보같아요....
			</h1>
			<div className="w-full flex justify-between text-base font-normal">
				<Link
					href="/users/151941"
					className="flex items-center gap-x-1 text-sm font-normal text-gray-700 dark:text-gray-300 "
				>
					<img
						className="inline-block h-5 w-5 rounded-full"
						src="https://avatars.githubusercontent.com/u/68390715?v=4"
						alt="프로필 사진"
					/>
					<span className="pl-0.5 text-gray-900 hover:text-blue-500 dark:text-gray-100 dark:hover:text-blue-200">
						ehddn****
					</span>
					<span>·</span>
					<span>21분 전</span>
				</Link>
				<div className="flex items-center gap-x-1 text-sm font-normal text-gray-700 dark:text-gray-300">
					<div className="flex items-center gap-x-0.5">
						<svg
							xmlns="http://www.w3.org/2000/svg"
							fill="none"
							viewBox="0 0 24 24"
							stroke-width="1.5"
							stroke="currentColor"
							aria-hidden="true"
							className="h-4 w-4"
						>
							<path
								stroke-linecap="round"
								stroke-linejoin="round"
								d="M2.036 12.322a1.012 1.012 0 010-.639C3.423 7.51 7.36 4.5 12 4.5c4.638 0 8.573 3.007 9.963 7.178.07.207.07.431 0 .639C20.577 16.49 16.64 19.5 12 19.5c-4.638 0-8.573-3.007-9.963-7.178z"
							></path>
							<path
								stroke-linecap="round"
								stroke-linejoin="round"
								d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
							></path>
						</svg>
						<span>120</span>
					</div>
					<div className="inline-flex items-center space-x-0.5 text-xs sm:text-sm">
						<i className="h-6 flex justify-center items-center bx bx-message-dots"></i>
						<span>9</span>
					</div>
					<div className="inline-flex items-center space-x-0.5 text-xs sm:text-sm">
						<i className="h-6 flex justify-center items-center bx bx-like"></i>
						<span>1</span>
					</div>
					<div className="inline-flex items-center space-x-0.5 text-xs sm:text-sm">
						<i className="h-6 flex justify-center items-center bx bx-dislike"></i>
						<span>1</span>
					</div>
				</div>
			</div>

			<div className="relative mt-2 mb-7">
				<div className="absolute inset-0 flex items-center">
					<div className="w-full border-t border-gray-500/30 dark:border-gray-500/70"></div>
				</div>
				<div className="relative ml-2 flex font-normal sm:ml-5">
					<div className="bg-white px-2 text-gray-500 dark:bg-gray-800 dark:text-gray-400">
						<Link
							className="text-sm text-gray-400 hover:text-primary-light dark:hover:text-primary-dark"
							href="/community"
						>
							커뮤니티
						</Link>
					</div>
				</div>
			</div>

			{/* CONTENT - VIEWER */}
			<Viewer content={content} />

			{/* LIKES */}
			<div className="flex justify-center">
				<div className="flex space-x-2">
					<button
						type="button"
						className="relative flex w-[100px] py-4 items-center justify-center rounded-md border border-gray-500/30 bg-white text-gray-700 hover:border-gray-500/70 focus:z-10 focus:outline-none focus:ring-0 dark:border-gray-500/70 dark:bg-gray-700 dark:text-gray-300 dark:hover:border-gray-500/30"
					>
						<i className="bx bx-like mr-1"></i>
						<span>추천 5</span>
					</button>
					<button
						type="button"
						className="relative flex py-4 w-[100px] items-center justify-center rounded-md border border-gray-500/30 bg-white text-gray-700 hover:border-gray-500/70 focus:z-10 focus:outline-none focus:ring-0 dark:border-gray-500/70 dark:bg-gray-700 dark:text-gray-300 dark:hover:border-gray-500/30"
					>
						<i className="bx bx-dislike mr-1"></i>
						<span>비추천 3</span>
					</button>
				</div>
			</div>

			<Border className="mt-8 mb-4" />

			{/* TAGS */}
			<TagList tagList={['태그1', '태그2', '태그3']} size="sm" />

			{/* REPLY */}
		</Container>
	);
};

export default PostView;

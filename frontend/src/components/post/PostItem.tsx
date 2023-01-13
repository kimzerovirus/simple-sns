import React from 'react';
import { TagList } from 'src/components/post/Tags';

const PostItem = () => {
	return (
		<div>
			<li className="py-4 border-b first:border-t border-gray-500/30 dark:border-gray-500/70">
				<div className="flex flex-col">
					<div className="flex shrink-0 items-center gap-x-1">
						<a href="/users/151453">
							<img
								className="h-5 w-5 rounded-full"
								src="//www.gravatar.com/avatar/b643b19fee19e04cab4620411d98d7c7?d=identicon&amp;s=96"
								alt="프로필 사진"
							/>
						</a>
						<a
							className="truncate pl-1 text-xs font-normal text-gray-700 hover:text-blue-500 dark:text-gray-300 dark:hover:text-blue-200 sm:text-sm"
							href="/users/151453"
						>
							감자냐옹
						</a>
						<div className="inline-flex items-center font-normal text-gray-700 dark:text-gray-300"></div>
						<span className="text-xs text-gray-700 dark:text-gray-300 sm:text-sm">·</span>
						<span className="text-xs text-gray-700 dark:text-gray-300 sm:text-sm">20분 전</span>
					</div>
					<div className="my-2">
						<a
							className="line-clamp-1 w-fit truncate whitespace-normal break-all text-sm font-semibold leading-6 text-gray-900 hover:text-primary-light dark:hover:text-primary-dark dark:text-gray-100 sm:text-base"
							href="/articles/1386490"
						>
							JSP개발자 취업
						</a>
					</div>
					<div className="flex">
						<TagList
							tagList={['태그1', '태그2', '태그3', '태그3', '태그3', '태그3', '태그3', '태그3']}
							size="xs"
						/>
						<div className="w-full flex justify-end items-center gap-x-2 text-gray-700 dark:text-gray-300">
							<div className="flex items-center space-x-0.5 text-xs sm:text-sm">
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
								<span className="font-medium">120</span>
								<span className="sr-only">views</span>
							</div>
							<div className="inline-flex items-center space-x-0.5 text-xs sm:text-sm">
								<i className="h-6 flex justify-center items-center bx bx-message-dots"></i>
								<span className="font-medium">9</span>
							</div>
							<div className="inline-flex items-center space-x-0.5 text-xs sm:text-sm">
								<i className="h-6 flex justify-center items-center bx bx-like"></i>
								<span className="font-medium">1</span>
							</div>
							<div className="inline-flex items-center space-x-0.5 text-xs sm:text-sm">
								<i className="h-6 flex justify-center items-center bx bx-dislike"></i>
								<span className="font-medium">1</span>
							</div>
						</div>
					</div>
				</div>
			</li>
		</div>
	);
};

export default PostItem;

import React from 'react';

interface TagListProps {
	tagList: string[];
	size: string;
}

export const TagList: React.FC<TagListProps> = ({ tagList, size }) => {
	return (
		<div className="flex flex-1 items-center gap-x-3">
			{tagList.map((tagName, i) => (
				<Tag name={tagName} key={i} size={size} />
			))}
		</div>
	);
};

interface TagProps {
	name: string;
	size: string;
}

export const Tag: React.FC<TagProps> = ({ name, size }) => (
	<a
		className={`shrink-0 flex rounded space-x-0.5 font-medium bg-gray-100 dark:bg-gray-700 dark:text-gray-300 py-0.5 px-2 text-${size}`}
		href="/community/life"
	>
		<i className="flex justify-center items-center bx bx-purchase-tag-alt"></i>
		<span>{name}</span>
	</a>
);

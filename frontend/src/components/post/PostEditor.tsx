import dynamic from 'next/dynamic';
import React, { FC, useCallback, useRef, useState } from 'react';
import Container from 'src/components/layout/Container';
import useInput from 'src/hooks/useInput';
import { categoryList } from 'src/static/data';

const Editor = dynamic(() => import('src/components/post/Editor'), {
	loading: () => <p>Loading editor...</p>,
	ssr: false,
});

interface PostEditorProps {
	title?: string;
	category?: string;
	tagList?: string[];
	content?: string;
	images?: string[];
}

const PostEditor: FC<PostEditorProps> = props => {
	const ref = useRef<any>(null);
	const [tagItem, setTagItem] = useState<string>('');
	const [tagList, setTagList] = useState<string[]>(props.tagList || []);
	const [selectedCategory, setSelectedCategory] = useState(props.category || '');
	const [title, setTitle] = useState(props.title || '');

	const keydownTagHandler = (e: React.KeyboardEvent<HTMLInputElement>) => {
		if (e.key === 'Enter' && !e.nativeEvent.isComposing) {
			const inputTag = tagItem.replace(/[^a-z|A-Z|0-9|ㄱ-ㅎ|가-힣]/g, '');
			if (inputTag === '') return;
			setTagList(() => [...Array.from(new Set([...tagList, `#${inputTag}`]))]);
			setTagItem('');
			return;
		}
		if (e.key === 'Backspace' && tagItem === '') {
			setTagList(() => [...tagList.slice(0, -1)]);
			return;
		}
	};

	const deleteTagHandler = (selectedTag: string) => {
		setTagList(() => tagList.filter(tag => tag !== selectedTag));
	};

	const changeSelectedCategoryHandler = (e: React.ChangeEvent<HTMLSelectElement>) => {
		setSelectedCategory(e.currentTarget.value);
	};

	const editorSubmitHandler = () => {
		console.log(tagList);
		console.log(selectedCategory);
		console.log(ref.current.getInstance().getHTML());
		console.log(ref.current.getInstance().getMarkdown());
		console.log(title);
	};

	return (
		<Container className="mt-4 md:mt-12">
			<h3 className="font-medium text-xl sm:text-3xl sm:leading-10 border-b border-b-gray-500/30 dark:border-b-gray-500/70">
				새 글쓰기
			</h3>
			<form className="my-6">
				<div className="grid grid-cols-1 gap-y-7">
					<InputWrapper title="카테고리" htmlFor="categoryCode">
						<select
							id="categoryCode"
							name="categoryCode"
							className="block w-full rounded-md border appearance-none border-gray-500/30 pl-3 pr-10 py-2 text-base placeholder-gray-500/80 shadow-sm focus:border-gray-500 focus:outline-none focus:ring-0 dark:bg-gray-500/20"
							value={selectedCategory}
							onChange={changeSelectedCategoryHandler}
						>
							<option className="dark:bg-gray-500">카테고리를 선택해주세요.</option>
							{categoryList.map((category, i) => (
								<option key={i} value={category.href} className="dark:bg-gray-500">
									{category.title}
								</option>
							))}
						</select>
						<i className="right-[12px] bottom-[8px] absolute text-lg text-gray-500/30 dark:text-gray-500/80 bx bxs-chevron-down"></i>
					</InputWrapper>
					<InputWrapper title="제목" htmlFor="title">
						<input
							type="text"
							id="title"
							placeholder="제목을 입력해주세요."
							className="block w-full appearance-none rounded-md border border-gray-500/30 px-3 py-2 text-base placeholder-gray-500/80 shadow-sm focus:border-gray-500 focus:outline-none focus:ring-0 dark:bg-gray-500/20"
							name="title"
							value={title}
							onChange={e => setTitle(e.currentTarget.value)}
						/>
					</InputWrapper>
					<InputWrapper title="태그" htmlFor="tags">
						<label
							htmlFor="tags"
							className="block min-h-[42px] hover:cursor-text w-full rounded-md border border-gray-500/30 px-3 text-base shadow-sm focus-within:border-gray-500 focus-within:outline-none focus-within:ring-0 dark:bg-gray-500/20"
						>
							{tagList.map((tag, i) => (
								<div key={i} className="inline-block border-box p-[2px] mr-1 py-1">
									<div className="flex items-center rounded-sm border-box px-2 bg-gray-500/30 dark:bg-gray-500/80">
										{tag}
										<i className="bx bx-x cursor-pointer" onClick={() => deleteTagHandler(tag)}></i>
									</div>
								</div>
							))}
							<input
								type="text"
								id="tags"
								placeholder="태그를 입력해주세요."
								value={tagItem}
								name="tags"
								className="w-auto h-auto focus:outline-none bg-transparent inline-block text-base placeholder-gray-500/80 py-2"
								onKeyDown={keydownTagHandler}
								onChange={e => setTagItem(e.currentTarget.value)}
							/>
						</label>
					</InputWrapper>
					<InputWrapper title="본문" htmlFor="content">
						<Editor editorRef={ref} content={props.content || ' '} />
					</InputWrapper>
				</div>
				<div className="mt-5 flex justify-center gap-x-3 sm:justify-end">
					<button
						type="button"
						className="w-20 rounded-md border border-gray-500/30 bg-white px-4 py-2 text-sm font-medium shadow-sm hover:bg-gray-100 focus:outline-none dark:border-gray-500/70 dark:bg-gray-700 dark:hover:bg-gray-600"
					>
						취소
					</button>
					<button
						type="button"
						onClick={editorSubmitHandler}
						className="inline-flex items-center space-x-2 rounded-md bg-primary-main hover:bg-primary-light dark:hover:bg-primary-dark px-8 py-2 text-sm font-semibold leading-6 text-white shadow-sm"
					>
						등록
					</button>
				</div>
			</form>
		</Container>
	);
};

export default PostEditor;

interface InputProps {
	title: string;
	htmlFor: string;
	children: React.ReactNode;
}

const InputWrapper: React.FC<InputProps> = ({ title, htmlFor, children }) => (
	<div className="space-y-1 relative">
		<label htmlFor={htmlFor} className="text-sm font-medium text-gray-700 dark:text-gray-300">
			{title}
		</label>
		{children}
	</div>
);

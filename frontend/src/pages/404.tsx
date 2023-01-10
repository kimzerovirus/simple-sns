import Link from 'next/link';
import lottieJson from 'public/cat.json';
import React from 'react';
import Lottie from 'react-lottie-player';

const PageNotFound = () => {
	return (
		<div className="w-full translate-y-[30%] flex flex-col items-center">
			<div className="max-w-lg w-[80%] md:w-full">
				<Lottie loop animationData={lottieJson} play style={{ width: `100%`, height: `100%` }} />
			</div>
			<h2 className="md:mt-4 text-2xl md:text-5xl text-center font-semibold">
				This page does not exist.
			</h2>
			<h3 className="md:mt-2 text-sm text-center text-gray-600 dark:text-gray-400">
				죄송합니다. 찾으시려는 페이지는 존재하지 않습니다.
			</h3>
			<Link href="/" className="mt-4 text-sm text-purple-600 dark:text-purple-400 underline">
				메인페이지로 이동
			</Link>
		</div>
	);
};

export default PageNotFound;

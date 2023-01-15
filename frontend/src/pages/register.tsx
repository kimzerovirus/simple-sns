import Link from 'next/link';
import React from 'react';

const register = () => {
	return (
		<div className="flex flex-col items-center justify-center px-6 py-8 my-6 md:my-10 w-full mx-auto max-w-md">
			<form className="space-y-4 md:space-y-6 w-full" action="#">
				<div>
					<label htmlFor="email" className="block mb-2 text-sm font-medium">
						이메일
					</label>
					<input
						type="email"
						name="email"
						id="email"
						className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-main focus:border-primary-main block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white "
						placeholder="name@eamil.com"
					/>
				</div>
				<div>
					<label htmlFor="nickname" className="block mb-2 text-sm font-medium">
						닉네임
					</label>
					<input
						type="text"
						name="nickname"
						id="nickname"
						className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-main focus:border-primary-main block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white "
						placeholder="name@eamil.com"
					/>
				</div>
				<div>
					<label htmlFor="password" className="block mb-2 text-sm font-medium ">
						비밀번호
					</label>
					<input
						type="password"
						name="password"
						id="password"
						placeholder="**********"
						className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:border-primary-main block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
					/>
				</div>
				<div>
					<label htmlFor="passwordConfirm" className="block mb-2 text-sm font-medium ">
						비밀번호 확인
					</label>
					<input
						type="password"
						name="passwordConfirm"
						id="passwordConfirm"
						placeholder="**********"
						className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:border-primary-main block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
					/>
				</div>

				<button
					type="submit"
					className="w-full text-white bg-primary-main hover:bg-primary-dark focus:ring-4 focus:outline-none font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-main"
				>
					회원가입
				</button>
			</form>
		</div>
	);
};

export default register;

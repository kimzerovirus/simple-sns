import Link from 'next/link';
import React from 'react';

const login = () => {
	return (
		<div className="flex flex-col items-center justify-center px-6 py-8 my-6 md:my-10 w-full mx-auto max-w-md">
			<span className="block w-full mb-2 text-sm font-medium">SNS로그인</span>
			<div className="flex w-full space-x-2">
				<SocialLoginBtn href="/">
					<GoogleLoginIcon />
				</SocialLoginBtn>
				<SocialLoginBtn href="/">
					<NaverLoginIcon />
				</SocialLoginBtn>
				<SocialLoginBtn href="/">
					<KakaoLoginIcon />
				</SocialLoginBtn>
			</div>

			<div className="relative my-7 w-full">
				<div className="absolute inset-0 flex items-center">
					<div className="w-full border-t border-gray-500/30 dark:border-gray-500/70"></div>
				</div>
				<div className="relative flex justify-center text-sm">
					<span className="bg-white px-2 text-gray-500 dark:bg-gray-800">or</span>
				</div>
			</div>

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
				{/* <div className="flex items-center justify-between"> */}
				<div className="flex items-center justify-end">
					{/* <div className="flex items-start">
						<div className="flex items-center h-5">
							<input
								id="remember"
								aria-describedby="remember"
								type="checkbox"
								className="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 dark:bg-gray-700 dark:border-gray-600 dark:ring-offset-gray-800"
							/>
						</div>
						<div className="ml-3 text-sm">
							<label htmlFor="remember" className="text-gray-500 dark:text-gray-300">
								로그인 상태 유지
							</label>
						</div>
					</div> */}
					<Link href="#" className="text-sm font-medium text-primary-main">
						계정찾기
					</Link>
				</div>
				<button
					type="submit"
					className="w-full text-white bg-primary-main hover:bg-primary-dark focus:ring-4 focus:outline-none font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-main"
				>
					로그인
				</button>
				<p className="text-sm text-center font-light">
					아직 회원이 아닌신가요?{' '}
					<Link href="#" className="font-medium text-primary-main underline">
						회원가입
					</Link>
				</p>
			</form>
		</div>
	);
};

export default login;

interface SocialLoginBtnProps {
	children: React.ReactNode;
	href: string;
}

const SocialLoginBtn: React.FC<SocialLoginBtnProps> = ({ children, href }) => (
	<a
		className="inline-flex w-full justify-center rounded-md border border-gray-500/30 px-4 py-2 text-gray-700 shadow-sm hover:border-gray-500/70 dark:bg-gray-700 dark:text-gray-300"
		href={href}
	>
		{children}
	</a>
);

const GoogleLoginIcon = () => (
	<>
		<svg
			className="h-5 w-5"
			viewBox="0 0 18 18"
			fill="currentColor"
			xmlns="http://www.w3.org/2000/svg"
		>
			<g clip-path="url(#clip0_1394_6209)">
				<path
					fill-rule="evenodd"
					clip-rule="evenodd"
					d="M17.4982 9.20447C17.4982 8.56603 17.4427 7.95303 17.3405 7.36377H9.17188V10.8451H13.84C13.639 11.9702 13.0278 12.9232 12.1094 13.5616V15.8194H14.9129C16.5528 14.2526 17.4991 11.9456 17.4991 9.20447H17.4982Z"
					fill="currentColor"
				></path>
				<path
					fill-rule="evenodd"
					clip-rule="evenodd"
					d="M9.17299 17.9998C11.5148 17.9998 13.4784 17.1935 14.9132 15.8191L12.1097 13.5613C11.3326 14.1014 10.3398 14.4202 9.17218 14.4202C6.91286 14.4202 5.00082 12.8372 4.31853 10.71H1.42188V13.0416C2.84937 15.9828 5.78198 17.9998 9.17299 17.9998Z"
					fill="currentColor"
				></path>
				<path
					fill-rule="evenodd"
					clip-rule="evenodd"
					d="M4.32 10.7101C4.14677 10.17 4.0479 9.59348 4.0479 8.99999C4.0479 8.40649 4.14677 7.82994 4.32 7.28986V4.95825H1.42252C0.835016 6.17323 0.5 7.54761 0.5 8.99999C0.5 10.4524 0.835016 11.8267 1.42252 13.0417L4.32 10.7101Z"
					fill="currentColor"
				></path>
				<path
					fill-rule="evenodd"
					clip-rule="evenodd"
					d="M9.17299 3.57965C10.4461 3.57965 11.59 4.0341 12.4888 4.9252L14.9769 2.34348C13.4743 0.891945 11.5107 0 9.17299 0C5.78198 0 2.84937 2.01705 1.42188 4.95827L4.31935 7.28987C5.00164 5.1626 6.91368 3.57965 9.17299 3.57965Z"
					fill="currentColor"
				></path>
			</g>
			<defs>
				<clipPath id="clip0_1394_6209">
					<rect width="17" height="18" fill="currentColor" transform="translate(0.5)"></rect>
				</clipPath>
			</defs>
		</svg>
	</>
);

const NaverLoginIcon = () => (
	<>
		<span className="sr-only">Sign in with Naver</span>
		<svg
			className="h-5 w-5"
			viewBox="-1 -1 17 16"
			fill="currentColor"
			xmlns="http://www.w3.org/2000/svg"
		>
			<path
				d="M9.88343 0V7.06382L5.13527 0H0V14H5.11657V6.93618L9.8666 14H15V0H9.88343Z"
				fill="currentColor"
			></path>
		</svg>
	</>
);

const KakaoLoginIcon = () => (
	<>
		<svg
			className="h-5 w-5"
			viewBox="0 0 22 21"
			fill="currentColor"
			xmlns="http://www.w3.org/2000/svg"
		>
			<g clip-path="url(#clip0_1394_6217)">
				<path
					d="M11 0C4.92473 0 0 4.04523 0 9.03544C0 12.2837 2.08683 15.1299 5.2182 16.7227C4.98798 17.6156 4.38507 19.9561 4.26426 20.457C4.11553 21.0787 4.48366 21.0705 4.72471 20.9029C4.9139 20.772 7.73926 18.7767 8.95819 17.9152C9.6198 18.017 10.3019 18.0709 11 18.0709C17.0753 18.0709 22 14.0251 22 9.03544C22 4.04582 17.0753 0 11 0Z"
					fill="currentColor"
				></path>
				<path
					d="M6.57195 6.37451H3.35566C3.05306 6.37451 2.80859 6.62911 2.80859 6.94293C2.80859 7.25674 3.05363 7.51134 3.35566 7.51134H4.40135V11.5151C4.40135 11.6608 4.45834 11.8041 4.55863 11.9077C4.65665 12.0107 4.79398 12.0699 4.93474 12.0699H5.05156C5.19175 12.0699 5.32851 12.0107 5.4271 11.9077C5.52739 11.8041 5.58438 11.6614 5.58438 11.5151V7.51134H6.57195C6.87454 7.51134 7.11958 7.25674 7.11958 6.94293C7.11958 6.62911 6.87454 6.37451 6.57195 6.37451Z"
					fill="white"
					className="block dark:hidden"
				></path>
				<path
					d="M14.3034 11.0004H12.8075V6.9114C12.8075 6.57035 12.542 6.29443 12.2143 6.29443C11.8866 6.29443 11.6211 6.57035 11.6211 6.9114V11.319C11.6211 11.3533 11.6251 11.3853 11.6302 11.4179C11.6245 11.4498 11.6211 11.483 11.6211 11.5162C11.6211 11.8016 11.8428 12.0325 12.1174 12.0325H14.3034C14.5787 12.0325 14.7998 11.8016 14.7998 11.5162C14.7998 11.2308 14.5781 11.0004 14.3034 11.0004Z"
					fill="white"
					className="block dark:hidden"
				></path>
				<path
					d="M19.0842 11.1881L17.4174 8.91329L18.9235 7.34778C19.1275 7.1364 19.1275 6.79239 18.9235 6.58042C18.7195 6.36845 18.389 6.36845 18.1844 6.58042L16.3198 8.51777V6.9114C16.3198 6.57035 16.0543 6.29443 15.7266 6.29443C15.3989 6.29443 15.1328 6.57035 15.1328 6.9114V11.4546C15.1328 11.7956 15.3984 12.0716 15.7266 12.0716C16.0548 12.0716 16.3198 11.7962 16.3198 11.4546V10.0531L16.6589 9.70138L18.2357 11.8513C18.4112 12.0946 18.7446 12.145 18.9788 11.9608C19.213 11.7779 19.2603 11.4321 19.0842 11.1881Z"
					fill="white"
					className="block dark:hidden"
				></path>
				<path
					d="M11.1745 11.3357L9.57146 6.77887C9.57146 6.77887 9.56747 6.77532 9.56633 6.77355C9.46375 6.49585 9.168 6.29395 8.81525 6.29395C8.42376 6.29395 8.10008 6.54263 8.03568 6.86769C8.02486 6.89197 8.01403 6.91624 8.00491 6.94229L6.42868 11.3357C6.33124 11.624 6.47712 11.939 6.7535 12.0403C7.03045 12.1415 7.33419 11.9899 7.43163 11.7022L7.7046 10.8934H9.89856L10.1709 11.7022C10.2684 11.9899 10.5721 12.1415 10.8491 12.0403C11.126 11.939 11.2719 11.624 11.1745 11.3357ZM8.05278 9.86016L8.79018 7.67413C8.79873 7.67413 8.80557 7.6765 8.81411 7.6765L9.55094 9.86016H8.05335H8.05278Z"
					fill="white"
					className="block dark:hidden"
				></path>
				<path
					d="M6.57195 6.37451H3.35566C3.05306 6.37451 2.80859 6.62911 2.80859 6.94293C2.80859 7.25674 3.05363 7.51134 3.35566 7.51134H4.40135V11.5151C4.40135 11.6608 4.45834 11.8041 4.55863 11.9077C4.65665 12.0107 4.79398 12.0699 4.93474 12.0699H5.05156C5.19175 12.0699 5.32851 12.0107 5.4271 11.9077C5.52739 11.8041 5.58438 11.6614 5.58438 11.5151V7.51134H6.57195C6.87454 7.51134 7.11958 7.25674 7.11958 6.94293C7.11958 6.62911 6.87454 6.37451 6.57195 6.37451Z"
					fill="rgb(17 24 39 / var(--tw-bg-opacity))"
					className="hidden dark:block"
				></path>
				<path
					d="M14.3034 11.0004H12.8075V6.9114C12.8075 6.57035 12.542 6.29443 12.2143 6.29443C11.8866 6.29443 11.6211 6.57035 11.6211 6.9114V11.319C11.6211 11.3533 11.6251 11.3853 11.6302 11.4179C11.6245 11.4498 11.6211 11.483 11.6211 11.5162C11.6211 11.8016 11.8428 12.0325 12.1174 12.0325H14.3034C14.5787 12.0325 14.7998 11.8016 14.7998 11.5162C14.7998 11.2308 14.5781 11.0004 14.3034 11.0004Z"
					fill="rgb(17 24 39 / var(--tw-bg-opacity))"
					className="hidden dark:block"
				></path>
				<path
					d="M19.0842 11.1881L17.4174 8.91329L18.9235 7.34778C19.1275 7.1364 19.1275 6.79239 18.9235 6.58042C18.7195 6.36845 18.389 6.36845 18.1844 6.58042L16.3198 8.51777V6.9114C16.3198 6.57035 16.0543 6.29443 15.7266 6.29443C15.3989 6.29443 15.1328 6.57035 15.1328 6.9114V11.4546C15.1328 11.7956 15.3984 12.0716 15.7266 12.0716C16.0548 12.0716 16.3198 11.7962 16.3198 11.4546V10.0531L16.6589 9.70138L18.2357 11.8513C18.4112 12.0946 18.7446 12.145 18.9788 11.9608C19.213 11.7779 19.2603 11.4321 19.0842 11.1881Z"
					fill="rgb(17 24 39 / var(--tw-bg-opacity))"
					className="hidden dark:block"
				></path>
				<path
					d="M11.1745 11.3357L9.57146 6.77887C9.57146 6.77887 9.56747 6.77532 9.56633 6.77355C9.46375 6.49585 9.168 6.29395 8.81525 6.29395C8.42376 6.29395 8.10008 6.54263 8.03568 6.86769C8.02486 6.89197 8.01403 6.91624 8.00491 6.94229L6.42868 11.3357C6.33124 11.624 6.47712 11.939 6.7535 12.0403C7.03045 12.1415 7.33419 11.9899 7.43163 11.7022L7.7046 10.8934H9.89856L10.1709 11.7022C10.2684 11.9899 10.5721 12.1415 10.8491 12.0403C11.126 11.939 11.2719 11.624 11.1745 11.3357ZM8.05278 9.86016L8.79018 7.67413C8.79873 7.67413 8.80557 7.6765 8.81411 7.6765L9.55094 9.86016H8.05335H8.05278Z"
					fill="rgb(17 24 39 / var(--tw-bg-opacity))"
					className="hidden dark:block"
				></path>
			</g>
			<defs>
				<clipPath id="clip0_1394_6217">
					<rect width="22" height="21" fill="white"></rect>
				</clipPath>
			</defs>
		</svg>
	</>
);

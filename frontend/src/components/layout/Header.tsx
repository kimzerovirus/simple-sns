import Link from 'next/link';
import { useRouter } from 'next/router';
import { useTheme } from 'next-themes';
import React, { FC, useEffect, useState } from 'react';
import { categoryList } from 'src/static/data';

const Header = () => {
	const [notificationToggle, setNotificationToggle] = useState(false);

	const notificationListHandler = () => {
		setNotificationToggle(() => !notificationToggle);
	};

	return (
		<header className="sticky top-0 z-20 flex h-16 items-center border-b border-b-gray-500/30 bg-white py-5 text-sm font-medium leading-6 dark:border-b-gray-500/70 dark:bg-gray-800">
			<div className="w-full max-w-[1280px] px-4 mx-auto flex">
				<nav className="w-full items-center justify-between">
					<div className="flex">
						<Link href="/" className="flex items-center">
							<h1 className="text-xl font-bold">KIMZEROVIRUS</h1>
						</Link>
						<div className="hidden md:flex ml-[80px] items-center space-x-7">
							{categoryList.map((category, i) => (
								<NavItem
									key={i}
									title={category.title}
									href={category.href}
									isBorder={i !== categoryList.length - 1}
								/>
							))}
						</div>
						<div className="relative ml-auto flex flex-wrap items-center text-base justify-center">
							<ThemeToggleBtn />
							{/* <Link href="/login">로그인</Link> */}{' '}
							{/* 소셜로그인만 지원할거라 회원가입은 필요없음 */}
							<button
								className="inline-flex items-center py-1 px-1 md:px-3 text-base dark:text-slate-400 focus-outline-none"
								type="button"
								onClick={notificationListHandler}
							>
								<i className="text-[20px] relative bx bx-bell">
									<span className="absolute rounded-full bg-orange-500 h-2 w-2 top-0 left-3 text-[10px] text-white font-semibold">
										{/* 10 -> h-3 w-3*/}
									</span>
								</i>
							</button>
							<button
								type="button"
								className="hidden md:flex rounded-full bg-white dark:bg-gray-800 focus-outline-none ml-2"
							>
								<img
									className="w-8 h-8 rounded-full shadow-lg"
									src="https://avatars.githubusercontent.com/u/68390715?v=4"
									alt="profile"
								/>
							</button>
							<button
								className="inline-flex md:hidden justify-end items-center md:px-3 text-base dark:text-slate-400 focus-outline-none"
								type="button"
							>
								<i className="text-[32px] bx bx-menu text-primary-main"></i>
							</button>
							{notificationToggle && (
								<NotificationBox handler={() => setNotificationToggle(false)} />
							)}
						</div>
					</div>
				</nav>
			</div>
		</header>
	);
};

export default Header;

interface NavItemProps {
	title: string;
	href: string;
	isBorder: boolean;
}

const NavItem: FC<NavItemProps> = ({ title, href, isBorder }) => {
	const { asPath } = useRouter();
	return (
		<>
			<div className="shrink-0">
				<Link
					className={
						(asPath.startsWith(`/${href}`) ? 'text-primary-main ' : '') +
						' hover:text-primary-light dark:hover:text-primary-dark text-sm font-semibold hover:no-underline'
					}
					href={`/${href}`}
				>
					{title}
				</Link>
			</div>
			{isBorder ? <div className="h-3 w-[1px] bg-gray-400 dark:bg-gray-400/70"></div> : <></>}
		</>
	);
};

const ThemeToggleBtn = () => {
	const { theme, setTheme } = useTheme();

	return (
		<button
			type="button"
			className="inline-flex items-center py-1 px-1 md:px-3 text-base focus:outline-none hover:text-orange-500  dark:text-slate-400 dark:hover:text-yellow-300"
			onClick={() => setTheme(theme === 'dark' ? 'light' : 'dark')}
		>
			<i className="visible dark:invisible dark:h-0 dark:w-0 h-5 w-5 text-[20px] bx bx-sun"></i>
			<i className="invisible dark:visible dark:h-5 dark:w-5 h-0 w-0 text-[20px] bx bx-moon"></i>
		</button>
	);
};

interface NotificationBoxHandler {
	handler: () => void;
	// notificationList: []
}

const NotificationBox: FC<NotificationBoxHandler> = ({ handler }) => {
	return (
		<div className="fixed md:absolute top-[64px] md:top-[48px] right-0 z-20 w-full md:w-96 bg-white dark:bg-gray-800 border border-gray-500/30 dark:border-gray-500/70">
			<div className="flex items-center justify-between border-b border-b-gray-500/30 bg-gray-50 py-3 px-6 text-sm font-medium leading-4 text-gray-900 dark:border-b-gray-500/70 dark:bg-gray-700 dark:text-gray-100">
				<span className="text-md">알림</span>
				<i
					className="text-[24px] hover:text-primary-light dark:hover:text-primary-dark bx bx-x"
					onClick={handler}
				></i>
			</div>
			<div className="max-h-[572px]">
				<Link
					href="/"
					className="flex items-center px-6 py-4 text-gray-900 hover:bg-gray-100 dark:hover:bg-gray-600 hover:no-underline dark:text-gray-100 "
				>
					<div className="flex w-full">
						<img
							className="w-8 h-8 rounded-full shadow-lg"
							src="https://avatars.githubusercontent.com/u/68390715?v=4"
							alt="profile"
						/>
						<div className="ml-3 text-sm font-normal w-full">
							<div className="mb-1 flex justify-between">
								<span className="text-sm font-semibold">KIMZEROVIRUS</span>
								<span className="text-sm">약 1시간 전</span>
							</div>
							<div className="mb-2 text-sm font-normal">
								Lorem ipsum dolor sit amet consectetur, adipisicing elit.
							</div>
						</div>
					</div>
				</Link>
				<div className="mx-6 border-b border-gray-500/30 last:hidden dark:border-gray-500/70"></div>
			</div>
		</div>
	);
};

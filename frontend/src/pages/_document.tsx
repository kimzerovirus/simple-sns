import { Head, Html, Main, NextScript } from 'next/document';

export default function Document() {
	return (
		<Html lang="en">
			<Head />
			<body className="flex h-full select-none flex-col font-sans text-gray-900 antialiased dark:bg-gray-800 dark:text-gray-100 sm:select-auto">
				<Main />
				<NextScript />
			</body>
		</Html>
	);
}

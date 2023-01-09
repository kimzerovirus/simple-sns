import { ThemeProvider } from 'next-themes';
import React, { FC, ReactNode } from 'react';
import Header from 'src/components/Header';

export interface DefaultLayoutProps {
	children: ReactNode;
}

const DefaultLayout: FC<DefaultLayoutProps> = ({ children }) => {
	return (
		<ThemeProvider attribute="class">
			<Header />
			<main className="mx-auto mt-4 md:mt-8 lg:mt-12 w-full max-w-4xl px-4 lg:px-0">
				{children}
			</main>
		</ThemeProvider>
	);
};

export default DefaultLayout;

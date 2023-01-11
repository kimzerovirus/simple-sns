import React, { FC, ReactNode } from 'react';
import Footer from 'src/components/layout/Footer';
import Header from 'src/components/layout/Header';

export interface DefaultLayoutProps {
	children: ReactNode;
}

const DefaultLayout: FC<DefaultLayoutProps> = ({ children }) => {
	return (
		<div className="flex flex-col min-h-[100vh]">
			<Header />
			<main className="flex-[1]">{children}</main>
			<Footer />
		</div>
	);
};

export default DefaultLayout;

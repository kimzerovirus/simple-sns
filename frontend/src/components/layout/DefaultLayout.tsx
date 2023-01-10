import React, { FC, ReactNode } from 'react';
import Footer from 'src/components/layout/Footer';
import Header from 'src/components/layout/Header';

export interface DefaultLayoutProps {
	children: ReactNode;
}

const DefaultLayout: FC<DefaultLayoutProps> = ({ children }) => {
	return (
		<div className="flex h-full flex-col">
			<Header />
			<div className="flex-[1]">
				<main>{children}</main>
			</div>
			{/* <Footer /> */}
		</div>
	);
};

export default DefaultLayout;

import React from 'react';

interface ContainerProps {
	children: React.ReactNode;
	className?: string;
}

const Container: React.FC<ContainerProps> = ({ children, className }) => {
	return (
		<div className={`${className} mx-auto w-full max-w-[1120px] px-4 lg:px-0`}>{children}</div>
	);
};

export default Container;

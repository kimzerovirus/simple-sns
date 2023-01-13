import React from 'react';

interface ContainerProps {
	children: React.ReactNode;
	className?: string;
}

const Container: React.FC<ContainerProps> = ({ children, className }) => {
	return <div className={`${className} mx-auto w-full max-w-[840px] px-4`}>{children}</div>;
};

export default Container;

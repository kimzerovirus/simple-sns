import lottieJson from 'public/cat.json';
import React, { Component } from 'react';
import Lottie from 'react-lottie-player';

const PageNotFound = () => {
	return (
		<>
			<Lottie loop animationData={lottieJson} play style={{ width: `100%`, height: `100%` }} />
		</>
	);
};

export default PageNotFound;

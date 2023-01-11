import React, { useCallback, useState } from 'react';

// eslint-disable-next-line import/no-anonymous-default-export
export default (initalValue = null as any) => {
	// state 정의
	const [data, setData] = useState(initalValue);

	// 함수 정의
	const handler = useCallback(
		(e: React.ChangeEvent<HTMLInputElement>) => {
			const { value, name } = e.target;
			setData({
				...data,
				[name]: value,
			});
		},
		[data],
	);
	return [data, handler] as const;
};

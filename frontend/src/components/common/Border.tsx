import React from 'react';

// eslint-disable-next-line import/no-anonymous-default-export
export default ({ className }: { className?: string }) => (
	<hr className={`order-t border-gray-500/30 dark:border-gray-500/70 ${className}`} />
);

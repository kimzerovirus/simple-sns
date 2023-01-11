/** @type {import('tailwindcss').Config} */
module.exports = {
	content: ['src/pages/**/*.{js,ts,jsx,tsx}', 'src/components/**/*.{js,ts,jsx,tsx}'],
	theme: {
		extend: {
			colors: {
				primary: {
					basic: '#a2a2ff',
					light: '#55558d',
					main: '#6868ac',
					dark: '#7d7dcb',
				},
			},
		},
	},
	darkMode: 'class',
	plugins: [],
};

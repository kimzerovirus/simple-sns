import '../styles/globals.css';

import type { AppProps } from 'next/app';
import { ThemeProvider } from 'next-themes';
import DefaultLayout from 'src/components/layout/DefaultLayout';

export default function App({ Component, pageProps }: AppProps) {
	return (
		<ThemeProvider attribute="class">
			<DefaultLayout>
				<Component {...pageProps} />
			</DefaultLayout>
		</ThemeProvider>
	);
}

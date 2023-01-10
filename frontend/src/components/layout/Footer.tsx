import Container from 'src/components/layout/Container';

export default function Footer() {
	const year = new Date().getFullYear();
	return (
		// <div className="mx-auto flex w-full max-w-7xl px-4 lg:px-0">
		<div className="w-full border-t border-t-gray-500/30 mt-7 py-7">
			<Container>
				<div className="w-full justify-center items-center text-sm">
					<footer className="w-full mx-auto text-center">
						<a href="https://github.com/kimzerovirus"> © {year} KIMZEROVIRUS</a>
					</footer>
				</div>
			</Container>
		</div>
	);
}

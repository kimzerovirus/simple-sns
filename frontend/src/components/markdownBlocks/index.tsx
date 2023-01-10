import 'remirror/styles/all.css';
import 'src/styles/markdown.css';

import {
	createIFrameHandler,
	createLinkHandler,
	Doc,
	Heading,
	MarkMap,
	RemirrorRenderer,
	TextHandler,
} from '@remirror/react';
import { useMemo } from 'react';

type Props = {
	content: string;
};

const typeMap: MarkMap = {
	blockquote: 'blockquote',
	bulletList: 'ul',
	doc: Doc,
	hardBreak: 'br',
	heading: Heading,
	horizontalRule: 'hr',
	iframe: createIFrameHandler(),
	image: 'img',
	listItem: 'li',
	paragraph: 'p',
	orderedList: 'ol',
	text: TextHandler,
	mentionAtom: MentionAtomComponent,
	link: LinkComponent,
	codeBlock: CodeBlockComponent,
	strike: 's',
	code: CodeComponent,
};

const markMap: MarkMap = {
	italic: 'em',
	bold: 'strong',
	code: CodeComponent,
	link: createLinkHandler({ target: '_blank' }),
	underline: 'u',
	strike: 's',
};

export const MarkdownContent = ({ content }: Props) => {
	const parsedContent = useMemo(() => JSON.parse(content), [content]);

	return (
		<Markdown>
			<RemirrorRenderer json={parsedContent.doc} typeMap={typeMap} markMap={markMap} />
		</Markdown>
	);
};

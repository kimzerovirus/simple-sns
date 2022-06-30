import { instance } from '@/api';

export function testApi() {
	return instance.get('https://jsonplaceholder.typicode.com/posts');
}

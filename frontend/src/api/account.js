import axios from 'axios';
import { BASE_API_URL } from './';

export function loginApi(payload) {
	return axios.post(`${BASE_API_URL}/`, payload);
}

export function signupApi(payload) {
	return axios.post(`${BASE_API_URL}/`, payload);
}

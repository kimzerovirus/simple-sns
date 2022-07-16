import axios from 'axios';

export const BASE_API_URL = 'http://localhost:8080/api/v1';
export const instance = axios.create({});

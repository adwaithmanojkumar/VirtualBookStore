import axios from "axios" ;

export const ApiClient = axios.create(
{
        baseURL: 'http://localhost:8080'
});
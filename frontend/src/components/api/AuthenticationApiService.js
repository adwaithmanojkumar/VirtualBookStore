import { ApiClient } from "./ApiClient";

export const executeBasicAuthenticationService = (token) => ApiClient.get(``,{
    headers:{
        Authorization: token
    }   
});
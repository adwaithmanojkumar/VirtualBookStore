import { useContext, useState ,createContext } from "react";
import { ApiClient } from "../api/ApiClient";
import axios from "axios";

export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

export default function AuthProvider ({children}) {
    const [isAuthenticated,setAuthenticated] = useState(false)
    const [username,setUserName] = useState(null)
    const [token,setToken] = useState(null)

    function logout() {
        setAuthenticated(false)
        setUserName(null)
        setToken(null)
    }

    async function login(username,password) {
        try {
            console.log('Entered')
            const response = await axios.get('http://localhost:8080/login', {
                headers: {
                    'Authorization': 'Basic ' + btoa(username + ':' + password)
                }
            });
            console.log(response)

            if(response.status===200) {
                const token = 'Basic '+response.data.token
                setAuthenticated(true)
                setUserName(username)
                setToken(token)

                ApiClient.interceptors.request.use(
                    (config) => {
                        console.log('intercepting and adding a token')
                        config.headers.Authorization=token
                        return config
                    }
                )

                return true
            } else {
                logout()
                return false
            }
        } catch(error) {
            logout()
            return false
        }
    }

    return (
        <AuthContext.Provider value={{isAuthenticated,setAuthenticated,login,logout,username,token}}>
            {children}
        </AuthContext.Provider>
    )
}
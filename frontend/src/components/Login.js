import { useState } from "react"
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthProvider";

export default function Login() {
    const [username, setUserName] = useState('')
    const [password, setPassWord] = useState('')
    const [showErrorMessage,setShowErrorMessage] = useState(false)
    const navigate = useNavigate() 
    const authContext = useAuth()

    async function handleSubmit(event) {
        console.log('Submitted Username:', username);
        console.log('Submitted Password:', password);
        if(await authContext.login(username,password)) {
            navigate(`/welcome/${username}`)
        } else {
            setShowErrorMessage(true)
        }
    }

    function handleUserNameChange(event) {
        setUserName(event.target.value)
        console.log('Username:', event.target.value);
    }
    
    function handlePassWordChange(event) {
        setPassWord(event.target.value)
        console.log('Password:', event.target.value);
    }

    return (
        <>
            <h1>Login Details are here.</h1>
            <div className="LoginComponent">
                <div className="LoginForm">
                {showErrorMessage && <div>Authentication failed. Please try again</div>}
                    <div>
                        <label>Username:</label>
                        <input type="text" name="username" value={username} onChange={handleUserNameChange} />
                    </div>
                    <div>
                        <label>Password:</label>
                        <input type="password" name="password" value={password} onChange={handlePassWordChange} />
                    </div>
                    <div> 
                        <button type="submit" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        </>
    )
}
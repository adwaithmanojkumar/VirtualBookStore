import { Link } from "react-router-dom"
import { useAuth } from "./security/AuthProvider"

export default function Home() {
    const authContext = useAuth()
    
    return (
        <>
            <div class="container">
                <h1>Welcome 2 Our bookStore</h1>
                <h2><Link to="/book-list">Manage your books</Link></h2>
                <h2><Link to="/add-book">Add new book</Link></h2>
            </div>
        </>
    )
}
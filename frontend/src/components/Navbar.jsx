import "./Navbar.css"
import { Link } from "react-router-dom"
import { useResolvedPath, useMatch } from "react-router-dom"

export default function Navbar() {
    return (
        <nav className='nav'>
            <ul>
                <CustomLink to="/">Home</CustomLink>
                <CustomLink to="/book-list">Books</CustomLink>
                <CustomLink to="/add-book">Add</CustomLink>
            </ul>
            <ul>
                <CustomLink to="/cart-list">My Cart</CustomLink>
                <CustomLink to="/logout">Logout</CustomLink>
            </ul>
        </nav>
    )
}

function CustomLink({ to, children, ...props }) {
    const resolvedpath = useResolvedPath(to)
    const isActive = useMatch({ path: resolvedpath.pathname, end: true })

    return (
        <li className={isActive ? isActive : ""}>
            <Link to={to} {...props}>
                {children}
            </Link>
        </li>
    )
}
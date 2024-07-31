import { useEffect, useState } from "react"
import { Link } from "react-router-dom"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { useNavigate } from "react-router-dom"
import { addBookApi, deleteBookFromCartApi, retreiveBooksApi, updateBookApi } from "../api/BookApi"
import { useAuth } from "../security/AuthProvider"

export default function BookList() {
    useEffect(
        () => refreshBooks(),[]
    )

    const [books, setBooks] = useState([])
    const [message,setMessage] = useState(null)
    const authContext = useAuth()
    const username = authContext.username
    const navigate = useNavigate()

    function refreshBooks() {
        retreiveBooksApi()
        .then((response)=>{
            console.log(response.data)
            setBooks(response.data)
        })
        .catch((error) => console.log(error))
        .finally(() => console.log("clean-up"))
    }

    function deleteBook(id) {
        deleteBookFromCartApi(id)
        .then(()=> {
            console.log(`Deleted book with ${id} is successful`)
            setMessage(`Deleted book with ${id} is successful`)
            refreshBooks()
        })
        .error((error)=>console.log('error'))
        .finally(()=>console.log('clean up'))
    }

    function addBook() {
        addBookApi()
        .then(()=>{
            console.log(`Added new book`)
            setMessage(`Added new book`)
            refreshBooks()
        })
        .error((error)=>console.log('error'))
        .finally(()=>console.log('clean up'))
    }

    function updateBook(id) {
        updateBookApi(id)
        .then(()=> {
            console.log(`Updated existing book`)
            setMessage(`Updated existing book`)
            refreshBooks()
        })
        .error((error)=>console.log('error'))
        .finally(()=>console.log('clean up'))
    }

    return (
        <>
            <div>
                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Book Name</th>
                                <th>Author Name</th>
                                <th>Published Date</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                (books.map
                                    (book =>
                                        <tr key={book.id}>
                                            <td>${book.bookName}</td>
                                            <td>${book.authorName}</td>
                                            <td>${book.publishedDate.toString()}</td>
                                            <td><Link to="/add-to-cart/${book.id}"
                                                className="btn btn-success"><FontAwesomeIcon icon="fa-sharp fa-regular fa-cart-shopping" /></Link></td>
                                            <td><button className="btn btn-primary" onClick={() => updateBook(book.id)}><FontAwesomeIcon icon="fa-solid fa-laptop-code" /></button></td>
                                        </tr>
                                    )
                                )
                            }
                        </tbody>
                    </table>
                </div>
                <div className="btn btn-success m-4" onClick={addBook}>Add New Book</div>
            </div>
        </>
    )
}
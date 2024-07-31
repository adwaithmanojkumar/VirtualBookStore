import { useState } from "react"
import { Link } from "react-router-dom"
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome"

export default function MyCart() {
    const [cartList, setCartList] = useState([])

    return (
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
                            cartList.map(
                                mycart => (
                                    <tr key={mycart.id}>
                                        <td>${mycart.bookName}</td>
                                        <td>${mycart.authorName}</td>
                                        <td>${mycart.publishedDate}</td>
                                        <td><button><Link to="remove-from-cart/${mycart.id}"
                                            class="btn btn-danger"><FontAwesomeIcon icon="fa-solid fa-trash-can" /></Link></button></td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}
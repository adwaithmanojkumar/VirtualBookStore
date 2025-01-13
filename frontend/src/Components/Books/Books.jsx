import React from 'react'
import AllBooksDetails from './AllBooksDetails'
import { useSelector } from 'react-redux'

const Books = () => {
    const books = useSelector(store => store.book.books)
    console.log(books)

    return (
        <div className='lg:grid grid-cols-5 m-5'>
            {books.length > 0 ? (
                books.map((item) => <AllBooksDetails key={item.bookName} book={item} />)
            ) : (
                <p>No books available</p>
            )}
        </div>
    )
}

export default Books
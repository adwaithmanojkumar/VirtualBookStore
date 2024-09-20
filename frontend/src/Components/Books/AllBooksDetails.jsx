import { Rating } from '@mui/material'
import React from 'react'
import { useNavigate } from 'react-router-dom'

const AllBooksDetails = ({ book }) => {
    const navigate = useNavigate()

    const handleBookDetails = () => {
        navigate(`/books-details/${book.id}`, { state: { product:book } })
    }

    return (
        <div onClick={handleBookDetails} className='m-4 border-solid border-gray-700 cursor-pointer'>
            <div>
                <img src={book.imageUrl} />
            </div>
            <div>
                <p className='font-semibold text-green-500'>{book.title}</p>
                <p className='text-cyan-600'>{book.authorName}</p>
            </div>
            <div className='flex flex-row space-x-1'>
                <p className='text-lg'>{book.rating}</p>
                <Rating name='rating' value={book.rating} precision={0.1} />
                <p className='px-4'>|<span className='px-2'>{book.reviews}</span>Reviews</p>
            </div>
            <div className='text-red-800'>
                ₹{book.discountedPrice}
            </div>
            <div className=' text-gray-600'>
                <span className='line-through'>M.R.P:₹{book.price}</span> ({book.discountPercent}%)
            </div>
        </div>
    )
}

export default AllBooksDetails
import { Rating } from '@mui/material'
import React from 'react'
import { useNavigate } from 'react-router-dom'

const HomeSectionPage = ({ product }) => {
    const navigate = useNavigate()

    const handleBookDetails = () => {
        navigate(`/books-details/${product.id}`,{state:{product}})
    }

    return (
        <div onClick={handleBookDetails} className='relative cursor-pointer flex flex-col items-center bg-white rounded-lg shadow-lg overflow-hidden 
    w-[15rem] mx-3 border py-2 h-[28rem]'>
            <div className='w-[12rem] h-[13rem]'>
                <img className='object-cover object-top w-full h-full' src={product.imageUrl} alt='' />
            </div>
            <div className='p-4'>
                <h3 className='text-lg font-medium text-gray-900'>{product.title}</h3>
                <p className='mt-2 text-sm text-gray-500'>{product.authorName}</p>
            </div>
            <div>
                <Rating name='read-only' value={product.rating} readOnly precision={0.5} />
            </div>
            <div className='p-1 flex items-center'>
                <span className='flex items-center bg-green-500 text-white text-lg font-semibold rounded-md p-1'>
                    {product.rating}
                    <img className='ml-2 w-4 h-4' src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMyIgaGVpZ2h0PSIxMiI+PHBhdGggZmlsbD0iI0ZGRiIgZD0iTTYuNSA5LjQzOWwtMy42NzQgMi4yMy45NC00LjI2LTMuMjEtMi44ODMgNC4yNTQtLjQwNEw2LjUuMTEybDEuNjkgNC4wMSA0LjI1NC40MDQtMy4yMSAyLjg4Mi45NCA0LjI2eiIvPjwvc3ZnPg==" />
                </span>
                <span className='font-semibold px-2'>{product.reviews}</span>
            </div>
            <div className='flex flex-row space-x-2 mt-2'>
                <span className='text-red-600 font-semibold mr-2'>₹{product.discountedPrice}</span>
                <span className='line-through'>₹{product.price}</span>
            </div>
        </div>
    )
}

export default HomeSectionPage
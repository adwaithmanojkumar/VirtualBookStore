import { Button, TextField } from '@mui/material'
import React, { useState } from 'react'
import { addBook } from '../../State/Book/Action';
import { useDispatch } from 'react-redux';

const AddForm = () => {
    const dispatch = useDispatch()

    const [formData, setFormData] = useState({
        title: "",
        authorName: "",
        price: "",
        discountedPrice: "",
        description: "",
        rating: 0,
        reviews: 0,
        discountPercent: 0,
        imageUrl: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        console.log(formData)
        e.preventDefault();
        // Dispatch the action to add the new book to Redux store
        dispatch(addBook(formData));
        // Clear form
        setFormData({
            title: "",
            authorName: "",
            price: "",
            discountedPrice: "",
            description: "",
            rating: 0,
            reviews: 0,
            discountPercent: 0,
            imageUrl: "",
        });
    }

    return (
        <form onSubmit={handleSubmit} className='space-x-2'>
            <h2 className='flex justify-center m-5 font-bold text-5xl text-blue-500'>Add Books</h2>
            <div className='flex flex-col space-y-4'>
                <div className='flex flex-row items-center space-x-8'>
                    <p className='font-bold text-gray-600'>Enter Book Title: </p>
                    <TextField
                        required
                        id='title'
                        label='Book Title'
                        name='title'
                        autoComplete='given'
                        value={formData.title}
                        onChange={handleChange}
                        fullWidth
                    />
                </div>
                <div className='flex flex-row items-center space-x-2'>
                    <p className='font-bold text-gray-600'>Enter Author Name: </p>
                    <TextField
                        required
                        id='authorName'
                        label='Author Name'
                        name='authorName'
                        autoComplete='given'
                        value={formData.authorName}
                        onChange={handleChange}
                        fullWidth
                    />
                </div><div className='flex flex-row items-center space-x-4'>
                    <p className='font-bold text-gray-600'>Enter Book Price: </p>
                    <TextField
                        required
                        id='price'
                        label='Book Price'
                        name='price'
                        autoComplete='given'
                        value={formData.price}
                        onChange={handleChange}
                        type='number'
                    />
                    <p className='font-bold text-gray-600'>Enter Book DiscountedPrice: </p>
                    <TextField
                        required
                        id='discountedPrice'
                        label='Discounted Price'
                        name='discountedPrice'
                        autoComplete='given'
                        value={formData.discountedPrice}
                        onChange={handleChange}
                        type='number'
                    />
                    <p className='font-bold text-gray-600'>Enter DiscountPercent: </p>
                    <TextField
                        required
                        id='discountPercent'
                        label='Discount Percent (%)'
                        name='discountPercent'
                        type='number'
                        value={formData.discountPercent}
                        onChange={handleChange}
                    />
                    <p>%</p>
                </div>
                <div className='flex flex-row items-center space-x-6'>
                    <p className='font-bold text-gray-600'>Enter Description: </p>
                    <TextField
                        required
                        type='text'
                        id='description'
                        label='Description'
                        name='description'
                        value={formData.description}
                        onChange={handleChange}
                        fullWidth
                    />
                </div>
                <div className='flex flex-row items-center space-x-4'>
                    <p className='font-bold text-gray-600 mr-10 pr-8'>Enter Rating: </p>
                    <TextField
                        required
                        type='number'
                        id='rating'
                        label='Rating'
                        name='rating'
                        value={formData.rating}
                        onChange={handleChange}
                    />
                    <p className='font-bold text-gray-600'>Enter Reviews: </p>
                    <TextField
                        required
                        type='number'
                        id='reviews'
                        label='Reviews'
                        name='reviews'
                        value={formData.reviews}
                        onChange={handleChange}
                    />
                    <p className='font-bold text-gray-600'>Enter ImageURL: </p>
                    <TextField
                        required
                        type='text'
                        id='imageUrl'
                        label='Image Url'
                        name='imageUrl'
                        autoComplete='given'
                        value={formData.imageUrl}
                        onChange={handleChange}
                        fullWidth
                    />
                </div>
            <div className='flex justify-center align-middle h-10'>
                <Button variant='contained' type='submit' sx={{
                    width: '3rem', bgcolor: "#bc26de", "&:hover": {
                        bgcolor: "#bc26de"
                    }
                }}>
                    SUBMIT
                </Button>
            </div>
        </div>
        </form >
    )
}

export default AddForm
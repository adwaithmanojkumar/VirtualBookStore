import { Button, TextField } from '@mui/material'
import React, { useState } from 'react'
import { addBook } from '../../State/Book/Action';
import { useDispatch } from 'react-redux';

const AddForm = () => {
    const dispatch = useDispatch()

    const [formData, setFormData] = useState({
        bookTitle: '',
        authorName: '',
        price: '',
        discountedPrice: '',
        discountedPercent: ''
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }

    const handleSubmit = (e) => {
        console.log(formData)
        e.preventDefault();
        // Dispatch the action to add the new book to Redux store
        dispatch(addBook(formData));
        // Clear form
        setFormData({
            bookTitle: '',
            authorName: '',
            price: '',
            discountedPrice: '',
            discountedPercent: ''
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
                        id='bookTitle'
                        label='Book Title'
                        name='bookTitle'
                        autoComplete='given'
                        value={formData.bookTitle}
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
                    <p className='font-bold text-gray-600'>Enter DiscountedPercent: </p>
                    <TextField
                        required
                        id='discountedPercent'
                        label='Discounted Percent (%)'
                        name='discountedPercent'
                        type='number'
                        value={formData.discountedPercent}
                        onChange={handleChange}
                    />
                    <p>%</p>
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
        </form>
    )
}

export default AddForm
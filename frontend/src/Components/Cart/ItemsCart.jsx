import React from 'react'
import { Button, IconButton } from '@mui/material'
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';

const ItemsCart = () => {
    return (
        <div className='flex flex-col mb-6'>
            <img src='https://www.bookswagon.com/productimages/images200/544/9781421520544.jpg' alt='Vagabond (VIZBIG Edition), Vol. 1' className='w-[7rem] h-[7rem] mt-3' />
            <div className='flex flex-row mt-3'>
                <h2 className='font-semibold text-red-500'>Vagabond (VIZBIG Edition), Vol. 1</h2>
            </div>
            <div className='mt-2'>
                <p className='text-orange-400'>Takehiko Inoue</p>
            </div>
            <div className='flex flex-row space-x-2'>
                <p className='mt-2 text-green-400 font-bold'>M.R.P:₹1509</p>
                <p className='mt-2 line-through text-gray-500'>₹2219</p>
                <p className='mt-2 font-semibold opacity-85'>Exclusive only @ 32(%) off</p>
            </div>
            <div className='flex items-center mt-1'>
                <IconButton sx={{color:"#7303fc"}}>
                    <RemoveCircleOutlineIcon />
                </IconButton>
                <span className='py-1 px-7'>
                    <IconButton sx={{color:"#7303fc"}}>
                        <AddCircleOutlineIcon />
                    </IconButton>
                </span>
                <Button sx={{color:"#750af7"}}>REMOVE</Button>
            </div>
        </div>
    )
}

export default ItemsCart
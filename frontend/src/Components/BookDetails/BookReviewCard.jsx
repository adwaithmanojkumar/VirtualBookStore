import { Avatar, Grid, Rating } from '@mui/material'
import React from 'react'

const BookReviewCard = () => {
  return (
    <Grid container sx={{py:"1rem"}}>
        <Grid item xs={1}>
        <Avatar sx={{color:"#ffffff",bgcolor:"#9806d1"}}>R</Avatar>
        </Grid>
        <Grid item xs={4}>
            <div className='space-y-1'>
            <h3 className='font-semibold'>Rakesh</h3>
            <p className='opacity-80 font-semibold'>August 4,2024</p>
            <Rating name='half-rating' value={3.8} precision={0.1}/>
            <p>Nice book, Read two times in one stretch</p>
            </div>
        </Grid>
    </Grid>
  )
}

export default BookReviewCard
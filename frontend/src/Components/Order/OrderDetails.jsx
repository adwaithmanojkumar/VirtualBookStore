import React from 'react'
import AddressCard from '../Address/AddressCard'
import OrderTracker from './OrderTracker'
import { Grid } from '@mui/material'
import StarIcon from '@mui/icons-material/Star';

const OrderDetails = () => {
  return (
    <div className='px-5 lg:px-20 space-y-4 mt-5'>
      <div className='border h-auto p-2 shadow-lg shadow-gray-400'>
        <h1 className='font-bold mb-3'>Delivery Address</h1>
        <AddressCard />
      </div>
      <div className='border py-8 shadow-lg shadow-gray-400'>
        <OrderTracker activeStep={1} />
      </div>
      <Grid className='space-y-5' container>
      {[1,1,1].map((item)=><Grid item container className='shadow-lg rounded-md p-5 border' sx={{ alignItems: "center", justifyContent: "space-between" }}>
          <Grid item xs={10}>
            <div className='flex'>
              <div className='cursor-pointer py-4'>
                <img src="https://rukminim1.flixcart.com/image/612/612/kb1470w0/jean/x/r/a/30-11274626-roadster-original-imafsgsthk6gdpjg.jpeg?q=70" alt='' className='h-[5rem] w-[5rem] object-cover object-top' />
              </div>
              <div className='ml-5 space-y-2'>
                <p className='font-semibold'>Men Regular Mid Rise Blue Jeans</p>
                <div className='space-x-4'>
                  <span className='opacity-50 text-xs font-semibold'>Color:Black</span>
                  <span className='opacity-50 text-xs font-semibold'>Size:M</span>
                </div>
                <div className='font-semibold space-y-2'>
                  <p>Seller: Lineraia</p>
                  <p>₹1099</p>
                </div>
              </div>
            </div>
          </Grid>
          <Grid item xs={2}>
            <div className='flex'>
              <StarIcon sx={{ color: "#875F9A" }} />
              <p className='px-2 text-purple-600 font-semibold'>Rate & Review Product</p>
            </div>
          </Grid>
        </Grid>)}
      </Grid>
    </div>
  )
}

export default OrderDetails
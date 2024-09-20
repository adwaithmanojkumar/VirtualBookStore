import React from 'react'
import AddressCard from '../Address/AddressCard'
import ItemsCart from '../Cart/ItemsCart'
import { Button } from '@mui/material'

const OrderSummary = () => {
  return (
    <div>
      <AddressCard/>
      <div className='lg:grid grid-cols-3'>
            <div className='col-span-2 mr-4'>
                {[1,1,1,1].map((item)=><ItemsCart />)}
            </div>

            <div className='lg:grid h-[18rem] w-[30rem]'>
                <div className='border ml-3 mr-4'>
                    <p className='px-5 mt-4 font-semibold opacity-60 text-base'>PRICE DETAILS</p>
                    <div className='mt-6 px-5'>
                        <div className='lg:flex justify-between items-center py-1 font-semibold text-base'>
                            <p className=''>Price</p>
                            <span className='text-lg'>₹4000</span>
                        </div>
                        <div className='lg:flex justify-between items-center py-1 font-semibold text-base'>
                            <p className=''>Discount</p>
                            <span className='text-lg text-green-500'>-₹3000</span>
                        </div>
                        <div className='lg:flex justify-between items-center py-1 font-semibold text-base'>
                            <p className=''>Delivery Charges</p>
                            <span className='text-lg text-green-500'>Free</span>
                        </div>
                        <div className='lg:flex justify-between items-center py-1 font-semibold text-base'>
                            <p className='pt-3 font-bold text-base'>Total Amount</p>
                            <span className='text-lg text-green-700'>₹1000</span>
                        </div>
                        
                    </div>
                    <div className='px-5 py-4 rounded-lg'>
                        <Button variant='contained' sx={{
                            bgcolor: "#5f0580", '&:hover': {
                                bgcolor: "#a437cc"
                            }
                        }} fullWidth>
                            <p className='text-white py-1'>CHECK OUT</p>
                        </Button>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default OrderSummary
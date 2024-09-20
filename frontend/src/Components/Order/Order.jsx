import { Grid } from '@mui/material'
import React from 'react'
import OrderCard from './OrderCard'

const orderStatus = [
    { label: "On The Way", value: "on_the_way" },
    { label: "Delivered", value: "delivered" },
    { label: "Cancelled", value: "cancelled" },
    { label: "Returned", value: "returned" }
]

const Order = () => {
    return (
        <div className='px-5 lg:px-20 mt-5'>
            <Grid container sx={{ justifyContent: 'space-between' }}>
                <Grid item xs={2.5}>
                    <div className='h-auto shadow-lg p-4 sticky border top-3 bg-white'>
                        <h1 className='font-bold mb-8'>Filters</h1>
                        <div className='space-y-4 mt-10'>
                            <p className='uppercase font-medium opacity-90 text-sm'>order status</p>
                            {orderStatus.map((option) => <div className='flex items-center'>
                                <input defaultValue={option.value} type='checkbox' />
                                <label className='ml-3 text-md text-gray-800'>
                                    {option.label}
                                </label>
                            </div>)}
                        </div>
                    </div>
                </Grid>

                <Grid item xs={9}>
                    <div className='space-y-5'>
                    {[1,1,1,1,1,1,1].map((item)=><OrderCard/>)}
                    </div>
                </Grid>
            </Grid>
        </div>
    )
}

export default Order
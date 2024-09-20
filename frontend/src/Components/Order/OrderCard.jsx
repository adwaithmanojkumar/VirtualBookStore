import { Grid } from '@mui/material'
import AdjustIcon from '@mui/icons-material/Adjust';
import React from 'react'
import { useNavigate } from 'react-router-dom';

const OrderCard = () => {
    const navigate = useNavigate()
    return (
        <div onClick={()=>navigate(`/account/order/${4}`)} className='p-5 shadow-lg shadow-gray-500 hover:shadow-2xl border'>
            <Grid container spacing={2} sx={{ justifyContent: "space-between" }}>
                <Grid item xs={6}>
                    <div className='flex cursor-pointer'>
                        <img src="https://rukminim1.flixcart.com/image/612/612/kb1470w0/jean/x/r/a/30-11274626-roadster-original-imafsgsthk6gdpjg.jpeg?q=70" alt='' className='h-[5rem] w-[5rem] object-cover object-top' />
                        <div className='ml-5 space-y-2'>
                            <p className='font-semibold'>Men Regular Mid Rise Blue Jeans</p>
                            <p className='opacity-50 text-xs font-semibold'>Size:M</p>
                            <p className='opacity-50 text-xs font-semibold'>Color:Black</p>
                        </div>
                    </div>
                </Grid>

                <Grid item xs={3}>
                    <p className='font-semibold opacity-85'>₹1099</p>
                </Grid>

                <Grid item xs={3}>
                    {true && <div>
                        <p>
                            <AdjustIcon sx={{ width: "15px", height: "15px" }} className='text-green-400 text-sm' />
                            <span className='font-semibold'>Delivered on 1st March</span>
                        </p>
                        <p className='text-xs'>
                            Your Item has been delivered.
                        </p>
                    </div>
                    }
                    {false && <p>
                        <span className='font-semibold'>Expected Delivery On 7th March</span>
                    </p>}
                </Grid>
            </Grid>
        </div>
    )
}

export default OrderCard
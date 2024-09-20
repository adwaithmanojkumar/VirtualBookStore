import { Step, StepLabel, Stepper } from '@mui/material'
import React from 'react'

const steps = [
    "Placed",
    "Order Confirmed",
    "Shipped",
    "Out For Delivery",
    "Delivered"
]

const OrderTracker = ({activeStep}) => {
  return (
    <div className='w-full'>
        <Stepper activeStep={activeStep} alternativeLabel>
            {steps.map((label)=> <Step>
                <StepLabel sx={{fontSize:"34px"}} StepIconProps={{ sx: { color: "#eb1cd6" } }}>{label}</StepLabel>
            </Step>)}
            <span className='font-semibold uppercase opacity-70 py-4 cursor-pointer mr-4'>Cancel Order</span>
        </Stepper>
    </div>
  )
}

export default OrderTracker
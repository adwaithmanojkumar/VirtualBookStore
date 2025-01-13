import { Button, Grid } from '@mui/material'
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import React from 'react'
import { useNavigate } from 'react-router-dom';
import ItemsCart from './ItemsCart';
import { useDispatch, useSelector } from 'react-redux';
import { removeCartItem, updateCartItem } from '../../State/Cart/Action';

const Cart = () => {
    const navigate = useNavigate()
    const dispatch = useDispatch()
    const cartItems = useSelector(state => state.cart.cartItems)

    const handleCheckOut = () => {
        navigate(`/checkout?step=2`)
    }

    const handleRemoveCartItem = (bookId) => {
        dispatch(removeCartItem(bookId));
    };

    const handleUpdateCartItem = (bookId, quantity) => {
        dispatch(updateCartItem(bookId, quantity));
    };

    return (
        <div className='flex flex-col m-5 mt-6'>
            <Grid container xs={12}>
                <Grid item xs={3}>
                    <div className='mt-3 ml-2 scroll-smooth'>
                        <FormGroup>
                            <FormControlLabel control={<Checkbox />} label="Delivered" />
                            <FormControlLabel control={<Checkbox />} label="Ordered" />
                        </FormGroup>
                    </div>
                </Grid>
                <Grid item xs={4}>
                    {cartItems.map(item => (
                        <ItemsCart
                            key={item.bookId}
                            item={item}
                            onRemove={handleRemoveCartItem}
                            onUpdateQuantity={handleUpdateCartItem}
                        />
                    ))}
                </Grid>
                <Grid item xs={5}>
                    <div className='lg:grid h-[18rem] w-[30rem]'>
                        <div className='border ml-6 mr-4'>
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
                                <Button onClick={handleCheckOut} variant='contained' sx={{
                                    bgcolor: "#5f0580", '&:hover': {
                                        bgcolor: "#a437cc"
                                    }
                                }} fullWidth>
                                    <p className='text-white py-1'>CHECK OUT</p>
                                </Button>
                            </div>
                        </div>
                    </div>
                </Grid>
            </Grid>
        </div>
    )
}

export default Cart
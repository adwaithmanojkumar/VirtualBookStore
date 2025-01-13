import { Button, Grid, LinearProgress, Rating } from '@mui/material'
import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import BookReviewCard from './BookReviewCard';
import { findBooksById } from '../../State/Book/Action';
import { addItemsToCart } from '../../State/Cart/Action';

const BookDetails = () => {
    const location = useLocation()
    const { product } = location.state || {};
    const params = useParams()
    const dispatch = useDispatch()
    const {books} = useSelector(store=>store.book)
    const navigate = useNavigate()
    const [quantity, setQuantity] = useState(1)

    console.log("books--- ", books)
    console.log("params--- ", params.bookId)

    const handleQuantityChange = (event) => {
        setQuantity(event.target.value); // Update the quantity state
    };

    const handleAddToCart = () => {
        const data = { bookId: Number(params.bookId), quantity: parseInt(quantity) }; // Convert quantity to number
        console.log('Adding to cart:', data);
        dispatch(addItemsToCart(data)); // Dispatch action with bookId and quantity
        navigate("/cart"); // Navigate to cart after adding item
    };

    useEffect(() => {
        if (books[params.bookId].id) {
            dispatch(findBooksById(params.bookId));
        }
    }, [params.bookId]);

    if (!product) {
        return <p>No product data available.</p>;
    }

    return (
        <div>
            <Grid container>
                <Grid items xs={2.5}>
                    <div className='w-30 h-30 overflow-hidden p-10 ml-10'>
                        <img src={product.imageUrl} alt={product.title} className='w-full h-full object-cover object-top' />
                    </div>
                </Grid>
                <Grid items xs={6.5}>
                    <div className='h-auto m-10 space-y-1 text-lg p-2'>
                        <h2 className='text-red-600 font-bold text-lg opacity-90 space-y-2'>{product.title}</h2>
                        <p>(Paperback)</p>
                        <div className='space-y-1'>
                            <p>By: <span className='text-blue-500'>{product.authorName}</span> (Author)</p>
                            <div className='flex flex-row space-x-1'>
                                <p className='text-lg'>{product.rating}</p>
                                <Rating name='rating' value={product.rating} precision={0.1} />
                                <p className='px-4'>|<span className='px-2'>{product.reviews}</span>Reviews</p>
                            </div>
                            <div className='text-red-800'>
                                ₹{product.discountedPrice}
                            </div>
                            <div className=' text-gray-600'>
                                <span className='line-through'>M.R.P:₹{product.price}</span> ({product.discountPercent}%)
                            </div>
                            <div className='text-sm space-y-1'>
                                <p className='text-green-700 '>International Edition</p>
                                <p>{product.description}</p>
                            </div>
                        </div>
                    </div>
                </Grid>
                <Grid items xs={3}>
                    <div className='border-2 border-gray-300 h-auto m-14 space-y-1 text-lg shadow-xl shadow-slate-300 rounded-md'>
                        <div className='flex flex-row space-x-2 p-3'>
                            <h5>Quantity:</h5>
                            {/* <select name="quantity" className='border border-gray-700'>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                            </select> */}
                            <select
                                name="quantity"
                                value={quantity}
                                onChange={handleQuantityChange} // Handle quantity change
                                className='border border-gray-700'>
                                {[...Array(10).keys()].map(i => (
                                    <option key={i + 1} value={i + 1}>{i + 1}</option>
                                ))}
                            </select>
                        </div>
                        <div className='pb-2 m-2'>
                            <Button onClick={handleAddToCart} variant='contained' sx={{
                                borderRadius: '2rem', bgcolor: "#15ad4a", '&:hover': {
                                    bgcolor: "#15ad4a"
                                }
                            }} fullWidth>Add to Cart</Button>
                            <Button variant='contained' sx={{
                                borderRadius: '2rem', bgcolor: "#e05c24", mt: '1rem', '&:hover': {
                                    bgcolor: "#e05c24"
                                }
                            }} fullWidth>Buy Now</Button>
                        </div>
                    </div>
                </Grid>
            </Grid>

            {/* Reviews and Ratings */}
            <section className='mt-7'>
                <Grid container>
                    <Grid item xs={7} spacing={3} gap={2} sx={{ px: "2rem" }}>
                        <h1 className='font-bold'>Reviews and Ratings</h1>
                        {[1, 1, 1, 1].map((item) => <BookReviewCard />)}
                    </Grid>
                    <Grid item xs={5} sx={{ marginTop: "2rem" }}>
                        <h1 className='font-bold mb-1'>Book Ratings</h1>
                        <div className='flex flex-wrap space-x-1'>
                            <Rating name='half-rating' value={4.2} precision={0.1} />
                            <h3 className='font-semibold opacity-70 mb-2'>76757 Ratings</h3>
                        </div>
                        <Grid container gap={1}>
                            <Grid container alignItems={'center'} gap={2}>
                                <Grid item xs={2}>
                                    <p>Excellent</p>
                                </Grid>
                                <Grid item xs={7}>
                                    <LinearProgress value={40} color='success' variant='determinate' sx={{ bgcolor: "#d0d0d0", borderRadius: 4, height: 7 }} />
                                </Grid>
                            </Grid>
                            <Grid container alignItems={'center'} gap={2}>
                                <Grid item xs={2}>
                                    <p>Very Good</p>
                                </Grid>
                                <Grid item xs={7}>
                                    <LinearProgress value={60} color='warning' variant='determinate' sx={{ bgcolor: "#d0d0d0", borderRadius: 4, height: 7 }} />
                                </Grid>
                            </Grid>
                            <Grid container alignItems={'center'} gap={2}>
                                <Grid item xs={2}>
                                    <p>Good</p>
                                </Grid>
                                <Grid item xs={7}>
                                    <LinearProgress value={45} color='secondary' variant='determinate' sx={{ bgcolor: "#d0d0d0", borderRadius: 4, height: 7 }} />
                                </Grid>
                            </Grid>
                            <Grid container alignItems={'center'} gap={2}>
                                <Grid item xs={2}>
                                    <p>Average</p>
                                </Grid>
                                <Grid item xs={7}>
                                    <LinearProgress value={35} color='primary' variant='determinate' sx={{ bgcolor: "#d0d0d0", borderRadius: 4, height: 7 }} />
                                </Grid>
                            </Grid>
                            <Grid container alignItems={'center'} gap={2}>
                                <Grid item xs={2}>
                                    <p>Poor</p>
                                </Grid>
                                <Grid item xs={7}>
                                    <LinearProgress value={25} color='error' variant='determinate' sx={{ bgcolor: "#d0d0d0", borderRadius: 4, height: 7 }} />
                                </Grid>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </section>
        </div>
    )
}

export default BookDetails
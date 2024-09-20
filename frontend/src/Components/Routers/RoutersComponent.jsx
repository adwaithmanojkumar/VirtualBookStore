import React from 'react'
import Navigation from '../Navigation/Navigation'
import { Route,Routes } from 'react-router-dom'
import HomeCarousel from '../HomeCarousel/HomeCarousel'
import Footer from '../Footer/Footer'
import Books from '../Books/Books'
import BookDetails from '../BookDetails/BookDetails'
import AddForm from '../AddBooks/AddForm'
import Cart from '../Cart/Cart'
import Checkout from '../Checkout/Checkout'
import Order from '../Order/Order'
import OrderDetails from '../Order/OrderDetails'

const RoutersComponent = () => {
  return (
    <div>
        <div>
            <Navigation/>
        </div>
        <Routes>
            <Route path='/' element={<HomeCarousel/>}/>
            <Route path='/login' element={<HomeCarousel/>}/>
            <Route path='/register' element={<HomeCarousel/>}/>
            <Route path='/books-details/:bookId' element={<BookDetails/>}/>
            <Route path='/books' element={<Books/>}/>
            <Route path='/books/add-book' element={<AddForm/>}/>
            <Route path='/cart' element={<Cart/>}/>
            <Route path='/checkout' element={<Checkout/>}/>
            <Route path='/account/order' element={<Order/>}/>
            <Route path='/account/order/:orderId' element={<OrderDetails/>}/>
        </Routes>
        <div>
            <Footer/>
        </div>
    </div>
  )
}

export default RoutersComponent
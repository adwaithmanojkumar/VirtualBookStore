import { configureStore } from '@reduxjs/toolkit';
import { authReducer } from './Auth/Reducer';
import { bookReducer } from './Book/Reducer';
import { cartReducer } from './Cart/Reducer';
import { orderReducer } from './Order/Reducer';

const store = configureStore({
  reducer: {
    auth: authReducer,
    book: bookReducer,
    cart: cartReducer,
    order: orderReducer,
  },
});

export default store;


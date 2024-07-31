import { ApiClient } from "./ApiClient";

export const retreiveBooksApi = () => ApiClient.get(`/book-list`)

export const addBookApi = () => ApiClient.get(`/add-book`)

export const addExistingBookApi = (id) => ApiClient.post(`/add-book/${id}`)

export const updateBookApi =(id) => ApiClient.get(`/update-book/${id}`)

export const retreiveCartListApi = () => ApiClient.get(`/cart-list`)

export const addToCartApi = (id) => ApiClient.get(`/add-to-cart/${id}`)

export const deleteBookFromCartApi = (id) => ApiClient.delete(`/remove-from-cart/${id}`)
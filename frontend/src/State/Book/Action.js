import { api } from "../../Config/apiConfig"
import { ADD_BOOK_FAILURE, ADD_BOOK_REQUEST, ADD_BOOK_SUCCESS, FIND_BOOKS_BY_ID_FAILURE, FIND_BOOKS_BY_ID_REQUEST, FIND_BOOKS_BY_ID_SUCCESS, FIND_BOOKS_FAILURE, FIND_BOOKS_REQUEST, FIND_BOOKS_SUCCESS } from "./ActionType"

export const findBooks = () => async (dispatch) => {
    dispatch({ type: FIND_BOOKS_REQUEST })
    try {
        const {data} = await api.get(`/books`)
        dispatch({type:FIND_BOOKS_SUCCESS,payload:data})
    } catch (error) {
        dispatch({type:FIND_BOOKS_FAILURE,payload:error.message})
    }
}

export const findBooksById = (bookId) => async (dispatch) => {
    dispatch({ type: FIND_BOOKS_BY_ID_REQUEST })
    try {
        const {data} = await api.get(`/books-details/${bookId}`)
        dispatch({type:FIND_BOOKS_BY_ID_SUCCESS,payload:data})
    } catch (error) {
        dispatch({type:FIND_BOOKS_BY_ID_FAILURE,payload:error.message})
    }
}

export const addBook = (bookData) => async (dispatch) => {
    dispatch({ type: ADD_BOOK_REQUEST })
    console.log("bookData ",bookData)
    try {
        const {data} = await api.post(`/books/add-book`,bookData)
        console.log("data ",data)
        dispatch({type:ADD_BOOK_SUCCESS,payload:data})
    } catch (error) {
        dispatch({type:ADD_BOOK_FAILURE,payload:error.message})
    }
}
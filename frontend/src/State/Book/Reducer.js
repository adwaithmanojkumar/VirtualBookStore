import { book_details } from "../../Data/book_details"
import { ADD_BOOK_FAILURE, ADD_BOOK_REQUEST, ADD_BOOK_SUCCESS, FIND_BOOKS_BY_ID_FAILURE, FIND_BOOKS_BY_ID_REQUEST, FIND_BOOKS_BY_ID_SUCCESS, FIND_BOOKS_FAILURE, FIND_BOOKS_REQUEST, FIND_BOOKS_SUCCESS } from "./ActionType"

const books = book_details;

const initialState = {
    books:books,
    book:null,
    loading:false,
    error:null
}

export const bookReducer = (state=initialState,action) => {
    switch(action.type) {
        case FIND_BOOKS_BY_ID_REQUEST:
            case FIND_BOOKS_REQUEST:
                case ADD_BOOK_REQUEST:
                    return {...state,loading:true,error:null}

        case FIND_BOOKS_SUCCESS:
            case ADD_BOOK_SUCCESS:
                return {...state,loading:false,books:[...state.books, action.payload],error:null}

        case FIND_BOOKS_BY_ID_SUCCESS:
            return {...state,loading:false,book:action.payload,error:null}

        case FIND_BOOKS_BY_ID_FAILURE:
            case FIND_BOOKS_FAILURE:
                case ADD_BOOK_FAILURE:
                    return {...state,loading:false,error:action.payload}

        default:
            return state
    }
}
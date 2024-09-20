import { useNavigate } from "react-router-dom"
import { api } from "../../Config/apiConfig"
import { CREATE_ORDER_FAILURE, CREATE_ORDER_REQUEST, CREATE_ORDER_SUCCESS, GET_ORDER_BY_ID_REQUEST, GET_ORDER_HISTORY_FAILURE, GET_ORDER_HISTORY_REQUEST, GET_ORDER_HISTORY_SUCCESS } from "./ActionType"
import { GET_CART_FAILURE, GET_CART_SUCCESS } from "../Cart/ActionType"

export const createOrder = (reqData) => async (dispatch) => {
    const navigate = useNavigate()
    dispatch({ type: CREATE_ORDER_REQUEST })

    try {
        const { data } = await api.post(
            `/orders/`,
            reqData.address
        )

        if (data.id) {
            reqData.navigate({ search: `step=3&order_id=${data.id}` })
        }
        dispatch({
            type: CREATE_ORDER_SUCCESS,
            payload: data,
        })

    } catch (error) {
        dispatch({
            type: CREATE_ORDER_FAILURE,
            payload: error.message,
        })
    }
}

export const getOrderById = (orderId) => async (dispatch) => {
    dispatch({ type: GET_ORDER_BY_ID_REQUEST })

    try {
        const {data} = await api.get(
            `/orders/${orderId}`,
        )

        dispatch({
            type:GET_CART_SUCCESS,
            payload:data,
        })
    } catch (error) {
        dispatch({
            type: GET_CART_FAILURE,
            payload: error.message,
        })
    }
}

export const getOrderByHistory = () => async (dispatch) => {
    dispatch({type:GET_ORDER_HISTORY_REQUEST})

    try {
        const {data} = await api.get(
            `/orders/user`,
        )

        dispatch({
            type:GET_ORDER_HISTORY_SUCCESS,
            payload:data
        })
    } catch (error) {
        dispatch({
            type: GET_ORDER_HISTORY_FAILURE,
            payload: error.message,
        })
    }
}
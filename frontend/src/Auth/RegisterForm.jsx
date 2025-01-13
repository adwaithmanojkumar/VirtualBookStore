import { Button, Grid, TextField } from '@mui/material'
import { React, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { getUser, register } from '../State/Auth/Action'
import {useDispatch, useSelector} from 'react-redux'

const RegisterForm = () => {
    const navigate = useNavigate()
    const dispatch = useDispatch()
    const jwt = localStorage.getItem("jwt")
    const {auth} = useSelector(store=>store)

    useEffect(()=>{
        if(jwt) {
            dispatch(getUser(jwt))
        }
    },[jwt,auth.jwt])

    const handleSubmit = (event) => {
        event.preventDefault()

        const data = new FormData(event.currentTarget)

        const userData = {
            firstName: data.get("firstName"),
            lastName: data.get("lastName"),
            email: data.get("email"),
            password: data.get("password"),
        }
        dispatch(register(userData))
        console.log("userData ", userData)
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <Grid container spacing={3}>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            id='firstName'
                            label='First Name'
                            name='firstName'
                            required
                            autoComplete='given'
                            fullWidth
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            id='lastName'
                            label='Last Name'
                            name='lastName'
                            required
                            autoComplete='given'
                            fullWidth
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField
                            id='email'
                            label='Email'
                            name='email'
                            required
                            autoComplete='email'
                            fullWidth
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField
                            id='password'
                            label='Password'
                            name='password'
                            required
                            autoComplete='password'
                            type='password'
                            fullWidth
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <Button type='submit' variant='contained' sx={{ bgcolor: "#933cd6", height: '3rem' }} fullWidth>REGISTER</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <p className='font-semibold text-center'>
                            if you already have account <Button onClick={() => { navigate("/login") }}>LOGIN</Button>
                        </p>
                    </Grid>
                </Grid>
            </form>
        </div>
    )
}

export default RegisterForm
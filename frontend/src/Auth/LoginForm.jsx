import { Button, Grid, TextField } from '@mui/material'
import React from 'react'
import { useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { login } from '../State/Auth/Action'

const LoginForm = () => {
    const navigate = useNavigate()
    const dispatch = useDispatch()

    const handleSubmit = (event) => {
        event.preventDefault()

        const data = new FormData(event.currentTarget)

        const userData = {
            email: data.get("email"),
            password: data.get("password"),
        }
        dispatch(login(userData))
        console.log("userData ", userData)
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <Grid container spacing={3}>
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
                        <Button type='submit' variant='contained' sx={{ bgcolor: "#933cd6", height: '3rem' }} fullWidth>LOGIN</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <p className='font-semibold text-center'>
                            if you don't have account <Button onClick={() => { navigate("/register") }}>REGISTER</Button>
                        </p>
                    </Grid>
                </Grid>
            </form>
        </div>
    )
}

export default LoginForm
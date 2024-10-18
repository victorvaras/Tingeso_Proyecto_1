import React, { useState } from 'react';
import client from '../services/client';

const Login = () => {
    const [rut, setRut] = useState('');
    const [password, setPassword] = useState('');
    const [loginStatus, setLoginStatus] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        

        const rut_client = parseInt(rut) ;

        const dataClient = {
            rut: rut_client,
            contrasenia: password
        };

        console.log(dataClient);

        try{
            const response = await client.loginClient(dataClient);
            console.log(response);

            if (response.data === 1) {
                setLoginStatus('Success');
                alert('Usuario logeado con éxito');
            } else {
                setLoginStatus('Failure');
                alert('Usuario no logeado');
            }
        }
        catch (error) {
            alert('Error al logear el usuario: ' + (error.response ? error.response.data : error.message));
            console.error('Error:', error);
                }
    };

    const fakeDatabaseCall = (rut, password) => {
        // This is a mock function to simulate database validation
        return new Promise((resolve) => {
            setTimeout(() => {
                if (rut === 'validRUT' && password === 'validPassword') {
                    resolve(1);
                } else {
                    resolve(0);
                }
            }, 1000);
        });
    };

    return (
        <div className="login-container">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="rut">RUT:</label>
                    <input
                        type="text"
                        id="rut"
                        value={rut}
                        onChange={(e) => setRut(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Login</button>
            </form>

            {loginStatus && <p>{loginStatus}</p>}
        </div>
    );
};

export default Login;
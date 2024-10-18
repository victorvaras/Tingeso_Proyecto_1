import React from 'react';
import { useNavigate } from 'react-router-dom';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

const Inicio = () => {
    const navigate = useNavigate();

    const handleSimularCredito = () => {
        navigate('/simulacion'); // Cambiado a navigate()
    };

    const handleSolicitarCredito = () => {
        navigate('/solicitar-credito'); // Cambiado a navigate()
    };

    const handleRegisterClient = () => {
        navigate('/registerClient');
    };

    const handleLoginClient = () => {
        navigate('/login');
    };

    return (
        <Stack spacing={2} direction="row">
            
            <Button variant="contained" onClick={handleSimularCredito}> Simulacion de credito</Button>
            <Button variant="contained" onClick={handleRegisterClient}>Registrar nuevo cliente</Button>
            <Button variant="contained" onClick={handleLoginClient}>Login Cliente</Button>
            
            
        </Stack>
    );
};

export default Inicio;

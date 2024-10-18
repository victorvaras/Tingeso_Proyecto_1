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

    return (
        <Stack spacing={2} direction="row">
            
            <Button variant="contained" onClick={handleSimularCredito}> Simulacion de credito</Button>
            
        </Stack>
    );
};

export default Inicio;

import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import businessLogic from '../services/businessLogic';

const RequirementsEvaluation = () => {
    const { id } = useParams();
    const [requerimientoActual, setRequerimientoActual] = useState(null);
    const [ingresoCliente, setIngresoCliente] = useState('');
    const [deudaCliente, setDeudaCliente] = useState('');
    const [valorPropiedad, setValorPropiedad] = useState('');
    const [edadCliente, setEdadCliente] = useState('');

    useEffect(() => {
        
        setRequerimientoActual(1);
        
    }, [id]);

    
    const evaluarR1 = async () => {
        const R1 = await businessLogic.validate_R1(ingresoCliente, id);       

        if (R1.data === true) {
            alert('Requerimiento 1 aprobado');
            setRequerimientoActual(2);
        }
        else {
            alert('Requerimiento 1 rechazado');
        }
    }


    const evaluarR2 = async (aprobado) => {
        const R2 = await businessLogic.validate_R2(id, aprobado);
        if (R2.data === true) {
            alert('Requerimiento 2 aprobado');
            setRequerimientoActual(3); // Assuming there's a next step after Requerimiento 2
        } else {
            alert('Requerimiento 2 rechazado');
        }
    }

    const evaluarR3 = async (aprobado) => {
        const R3 = await businessLogic.validate_R3(id, aprobado);
        if (R3.data === true) {
            alert('Requerimiento 3 aprobado');
            setRequerimientoActual(4); // Assuming there's a next step after Requerimiento 2
        } else {
            alert('Requerimiento 3 rechazado');
        }
    }

    const evaluarR4 = async () => {
        const R4 = await businessLogic.validate_R4(id,ingresoCliente ,deudaCliente);       
        console.log(R4);
        if (R4.data === true) {
            alert('Requerimiento 4 aprobado');
            setRequerimientoActual(5);
        }
        else {
            alert('Requerimiento 4 rechazado');
        }
    }

    const evaluarR5 = async () => {
        const R5 = await businessLogic.validate_R5(id,valorPropiedad);       
        console.log(R5);
        if (R5.data === true) {
            alert('Requerimiento 5 aprobado');
            setRequerimientoActual(6);
        }
        else {
            alert('Requerimiento 5 rechazado');
        }
    }

    const evaluarR6 = async () => {
        const R6 = await businessLogic.validate_R6(id,edadCliente);       
        console.log(R6);
        if (R6.data === true) {
            alert('Requerimiento 6 aprobado');
            setRequerimientoActual(7);
        }
        else {
            alert('Requerimiento 6 rechazado');
        }
    }

    return (
        <div>
            <h1 style={{ fontSize: '2em' }}>Evaluación de Requerimientos</h1>

            {requerimientoActual === 1 && (
                <div>
                    <p style={{ fontSize: '1.5em' }}>Requerimiento 1</p>
                    <p style={{ fontSize: '1em' }}>Relación Cuota/Ingreso</p>
                    <label style={{ fontSize: '1.2em' }}>
                        Ingreso Cliente:
                        <input 
                            type="integer" 
                            value={ingresoCliente} 
                            onChange={(e) => setIngresoCliente(e.target.value)} 
                            style={{ fontSize: '1em' }}
                        />
                    </label>
                    <div style={{ marginTop: '10px' }}>
                        <button onClick={() => evaluarR1()} style={{ fontSize: '1em' }}>Evaluar Requerimiento 1</button>
                    </div>
                </div>
            )}

            {requerimientoActual === 2 && (
                <div>
                    <p style={{ fontSize: '1.5em' }}>Requerimiento 2</p>
                    <p style={{ fontSize: '1em' }}>Historial Crediticio del Cliente</p>
                    
                    <div style={{ marginTop: '10px' }}>
                        <button 
                            onClick={() => evaluarR2(false)} 
                            style={{ fontSize: '1em', backgroundColor: 'red', color: 'white' }}
                        >
                            Rechazar
                        </button>
                        
                        <button 
                            onClick={() => evaluarR2(true)} 
                            style={{ fontSize: '1em', backgroundColor: 'green', color: 'white', marginRight: '10px' }}
                        >
                            Aprobar
                        </button>
                        
                    </div>
                </div>
            )}

            {requerimientoActual === 3 && (
                <div>
                    <p style={{ fontSize: '1.5em' }}>Requerimiento 3</p>
                    <p style={{ fontSize: '1em' }}>Antigüedad Laboral y Estabilidad</p>
                    
                    <div style={{ marginTop: '10px' }}>
                        <button 
                            onClick={() => evaluarR3(false)} 
                            style={{ fontSize: '1em', backgroundColor: 'red', color: 'white' }}
                        >
                            Rechazar
                        </button>
                        
                        <button 
                            onClick={() => evaluarR3(true)} 
                            style={{ fontSize: '1em', backgroundColor: 'green', color: 'white', marginRight: '10px' }}
                        >
                            Aprobar
                        </button>
                        
                    </div>
                </div>
            )}  

            {requerimientoActual === 4 && (
                <div>
                    <p style={{ fontSize: '1.5em' }}>Requerimiento 4</p>
                    <p style={{ fontSize: '1em' }}>Relación Deuda/Ingreso</p>
                    <label style={{ fontSize: '1.2em' }}>
                        Deudas CLiente:
                        <input 
                            type="integer" 
                            value={deudaCliente} 
                            onChange={(e) => setDeudaCliente(e.target.value)} 
                            style={{ fontSize: '1em' }}
                        />
                    </label>
                    <div style={{ marginTop: '10px' }}>
                        <button onClick={() => evaluarR4()} style={{ fontSize: '1em' }}>Evaluar Requerimiento 4</button>
                    </div>
                </div>
            )}

            {requerimientoActual === 5 && (
                <div>
                    <p style={{ fontSize: '1.5em' }}>Requerimiento 5</p>
                    <p style={{ fontSize: '1em' }}>Monto Máximo de Financiamiento</p>
                    <label style={{ fontSize: '1.2em' }}>
                        Valor Propiedad:
                        <input 
                            type="integer" 
                            value={valorPropiedad} 
                            onChange={(e) => setValorPropiedad(e.target.value)} 
                            style={{ fontSize: '1em' }}
                        />
                    </label>
                    <div style={{ marginTop: '10px' }}>
                        <button onClick={() => evaluarR5()} style={{ fontSize: '1em' }}>Evaluar Requerimiento 5</button>
                    </div>
                </div>
            )}

            {requerimientoActual === 6 && (
                <div>
                    <p style={{ fontSize: '1.5em' }}>Requerimiento 6</p>
                    <p style={{ fontSize: '1em' }}>Edad del Solicitante</p>
                    <label style={{ fontSize: '1.2em' }}>
                        Edad Cliente:
                        <input 
                            type="integer" 
                            value={edadCliente} 
                            onChange={(e) => setEdadCliente(e.target.value)} 
                            style={{ fontSize: '1em' }}
                        />
                    </label>
                    <div style={{ marginTop: '10px' }}>
                        <button onClick={() => evaluarR6()} style={{ fontSize: '1em' }}>Evaluar Requerimiento 6</button>
                    </div>
                </div>
            )}

        </div>
    );
};

export default RequirementsEvaluation;
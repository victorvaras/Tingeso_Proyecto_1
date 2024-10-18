import React from 'react';

const BarraSuperior = () => {
    return (
        <div style={{ 
            margin: "0", 
            padding: "4px 0", 
            backgroundColor: "lightgreen", 
            position: "fixed", 
            top: 0, 
            left: 0, 
            width: "100%", 
            textAlign: "center",
            fontSize: "10px"
        }}>
            <h1>PrestaBanco</h1>
        </div>
    );
};

export default BarraSuperior;
import httpClient from "../http-common";

const validate_R1 = (ingresos, id) => {
    return httpClient.get(`/business_logic/validate_r1/${ingresos}/${id}`);
}

const validate_R2 = (id, requisito) => {
    return httpClient.get(`/business_logic/validate_r2/${id}/${requisito}`);
}

const validate_R3 = (id, requisito) => {
    return httpClient.get(`/business_logic/validate_r3/${id}/${requisito}`);
}

const validate_R4 = (id, ingreso, deuda) => {
    return httpClient.get(`/business_logic/validate_r4/${id}/${ingreso}/${deuda}`);
}

const validate_R5 = (id, valorPropiedad) => {
    return httpClient.get(`/business_logic/validate_r5/${id}/${valorPropiedad}`);
}

const validate_R6 = (id, edadCliente) => {
    return httpClient.get(`/business_logic/validate_r6/${id}/${edadCliente}`);
}



export default { validate_R1, validate_R2, validate_R3, validate_R4,validate_R5, validate_R6 };

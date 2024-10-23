import httpClient from "../http-common";

const createApllyCredit = (data) => {
    return httpClient.post("/solicitud_credito/nuevo", data, {
        headers: {
            "Content-Type": "multipart/form-data"
        }
    });
}

const getApplyCredit = () => {
    return httpClient.get("/solicitud_credito/");
}

export default { createApllyCredit, getApplyCredit };
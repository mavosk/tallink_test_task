import axios from 'axios';
const apiUrl = 'http://localhost:8080';


async function getRequest(url) {
    let response = await axios.get(apiUrl + url);

    return response
}
async function postRequest(url, data) {
    let response = await axios.post(apiUrl + url, data);

    return response
}
async function getByIdRequest(url, id) {
    let response =  axios.get(`${apiUrl}/${url}/${id}`);
    return response
}

async function deleteByIdRequest(url, id) {
    return axios.delete(`${apiUrl}/${url}/${id}`);

}

export default {
    apiUrl,
    getRequestToApi(url) {
        return getRequest(url);
    },
    postRequestToApi(url, data) {
        return postRequest(url, data);
    },
    deleteRequestToApi(url, id) {
        return deleteByIdRequest(url, id);
    },
    getByIdRequestToApi(url, id) {
        return getByIdRequest(url, id);
    },



}

import axios from 'axios'

const API_URL = `${process.env.NODE_ENV === 'development' ? 'http://localhost:8080' : `http://${window.location.host}`}/api`
const defaultFailure = response => console.error(response.error || response)

export const RequestMethod = {
    POST: 'POST',
    GET: 'GET',
    PUT: 'PUT',
    DELETE: 'DELETE'
}

export default function invokeApi({ path, method = RequestMethod.GET, payload, onSuccess, onFailure = defaultFailure }) {
    const apiPath = `${API_URL}/${path}`
    let requestObject = {
        method,
        url: apiPath,
        headers: { 'Content-Type': 'application/json' }
    }
    if (method !== RequestMethod.GET && method !== RequestMethod.DELETE) {
        requestObject = { ...requestObject, data: JSON.stringify(payload) }
    }
    return axios(requestObject)
        .then(response => response.data)
        .then(onSuccess)
        .catch(onFailure)
}

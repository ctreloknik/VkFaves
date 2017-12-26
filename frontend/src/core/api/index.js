import axios from 'axios'
import store from '../../store'

const API_URL = `${process.env.NODE_ENV === 'development' ? 'http://localhost:8080' : `http://${window.location.host}`}/api`
const VK_API_URL = 'https://api.vk.com/method'
const defaultFailure = response => console.error(response.error || response)

export const RequestMethod = {
    POST: 'POST',
    GET: 'GET',
    PUT: 'PUT',
    DELETE: 'DELETE'
}

function api({ path, params, method = RequestMethod.GET, payload, onSuccess, onFailure = defaultFailure }) {
    let requestObject = {
        method,
        params,
        url: path,
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

export function invokeApi({ path, params, method, payload, onSuccess, onFailure }) {
  const servApiPath = `${API_URL}/${path}`
  return api({ path: servApiPath, params, method, payload, onSuccess, onFailure })
}

export function invokeVkApi({ path, params, method, payload, onSuccess, onFailure }) {
  const token = store.getState().vkUserData.startUserData.vkToken
  const vkApiPath = `${VK_API_URL}/${path}?access_token=${token}`
  return api({ path: vkApiPath, params, method, payload, onSuccess, onFailure })
}
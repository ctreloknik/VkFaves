import store from "../../store";
import { RequestMethod , invokeVkApi } from './'
import * as VkAuthActions from '../../reducers/vk-auth/actions'
import * as FavesActions from '../../reducers/faves/actions'

const { VK } = window
const FETCH_FAVES_METHOD = 'fave.getPosts'

export function handleVkLogin() {
  store.dispatch({ type: VkAuthActions.VK_AUTH_REQUEST })
  try {
    VK.Auth.login(response => {
      if (response.session) {
        store.dispatch({type: VkAuthActions.VK_AUTH_SUCCESS, payload: response.session.user})
      } else {
        store.dispatch({type: VkAuthActions.VK_AUTH_FAILURE, payload: new Error('Ошибка авторизации')})
      }
    }, 2 | 4 | 2048)
  } catch (err) {
    store.dispatch({ type: VkAuthActions.VK_AUTH_FAILURE, payload: err })
  }
}

export function fetchFaves(offset = 0) {
  store.dispatch({ type: FavesActions.FAVES_FETCH_REQUEST })
  const params = { offset }
  const onSuccess = response => store.dispatch({ payload: response, type: FavesActions.FAVES_FETCH_SUCCESS })
  const onFailure = response => store.dispatch({ payload: response, type: FavesActions.FAVES_FETCH_FAILURE })
  invokeVkApi({ path: FETCH_FAVES_METHOD, params, method: RequestMethod.GET, payload: null, onSuccess, onFailure })
}
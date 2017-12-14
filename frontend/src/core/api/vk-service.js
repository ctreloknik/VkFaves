import store from "../../store";
import * as VkAuthActions from '../../reducers/vk-auth/actions'

const VK = window.vk

export function handleVkLogin() {
  store.dispatch({ type: VkAuthActions.VK_AUTH_REQUEST })
  VK.Auth.login(response => {
    if (response.session) {
      store.dispatch({ type: VkAuthActions.VK_AUTH_SUCCESS, payload: response.session.user })
    } else {
      store.dispatch({ type: VkAuthActions.VK_AUTH_FAILURE, payload: new Error('Ошибка авторизации') })
    }
  }, 4)
}
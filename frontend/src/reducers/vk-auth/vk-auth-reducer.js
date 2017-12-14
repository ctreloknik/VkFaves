import * as VkAuthActions from './actions'

const initialState = {
  userData: null,
  fetchInProgress: false,
  fetchError: null
}

export default function vkAuthReducer(state = initialState, action) {
  switch (action.type) {
    case VkAuthActions.VK_AUTH_REQUEST:
      return {
        ...state,
        fetchInProgress: true,
        fetchError: false
      }
    case VkAuthActions.VK_AUTH_SUCCESS:
      return {
        ...state,
        userData: action.payload,
        fetchInProgress: false,
        fetchError: false
      }
    case VkAuthActions.VK_AUTH_FAILURE:
      return {
        ...state,
        fetchInProgress: false,
        fetchError: action.payload
      }
    default:
      return state
  }
}
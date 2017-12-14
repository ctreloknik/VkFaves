import { combineReducers } from 'redux'
import vkAuthReducer from './vk-auth/vk-auth-reducer'

export default combineReducers({
    vkUserData: vkAuthReducer
})
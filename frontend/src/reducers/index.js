import { combineReducers } from 'redux'
import vkAuthReducer from './vk-auth/vk-auth-reducer'
import favesReducer from "./faves/faves-reducer";

export default combineReducers({
  vkUserData: vkAuthReducer,
  faves: favesReducer
})
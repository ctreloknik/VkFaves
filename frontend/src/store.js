import { applyMiddleware, createStore } from "redux"
import { createLogger } from "redux-logger"
import reducer from './reducers'

const middleware = applyMiddleware(createLogger())
const store = createStore(reducer, middleware)

export default store
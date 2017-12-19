import * as FavesActions from './actions'

const initialState = {
  faves: [],
  totalCount: 0,
  fetchInProgress: false,
  fetchError: null
}

export default function favesReducer(state = initialState, action) {
  switch (action.type) {
    case FavesActions.FAVES_FETCH_REQUEST:
      return {
        ...state,
        fetchInProgress: true,
        fetchError: false
      }
    case FavesActions.FAVES_FETCH_SUCCESS:
      return {
        ...state,
        totalCount: action.payload.count || 0,
        userData: [ ...state.faves, ...action.payload.items ],
        fetchInProgress: false,
        fetchError: false
      }
    case FavesActions.FAVES_FETCH_FAILURE:
      return {
        ...state,
        fetchInProgress: false,
        fetchError: action.payload
      }
    default:
      return state
  }
}
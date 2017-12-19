import React, { Component } from 'react';
import { connect } from 'react-redux'
import store from '../../../store'
import { VK_TOKEN_RECEIVE } from "../../../reducers/vk-auth/actions";

class Auth extends Component {
  componentDidMount() {
    const parts = window.location.hash.split("&")
    const token = (parts.find(part => /access_token/.test(part)) || '').split("=")[0]
    const userId = (parts.find(part => /user_id/.test(part)) || '').split("=")[0]
    store.dispatch({ type: VK_TOKEN_RECEIVE, payload: { token, userId } })
  }


  render() {
    return (
      <div className="dashboard">
        Пожалуйста, подождите...
        Ваш токен: {this.props.userData.token}
      </div>
    )
  }
}

export default connect(state => ({
  userData: state.vkUserData.userData,
}))(Auth)
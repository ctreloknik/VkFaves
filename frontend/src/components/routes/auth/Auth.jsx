import React, { Component } from 'react';
import { connect } from 'react-redux'
import store from '../../../store'
import { VK_TOKEN_RECEIVE } from "../../../reducers/vk-auth/actions";

class Auth extends Component {
  constructor(props) {
    super(props)
    this.state = {
      token: null
    }
  }

  componentDidMount() {
    const parts = window.location.hash.split("&")
    const token = (parts.find(part => /access_token/.test(part)) || '').split("=")[1]
    const userId = (parts.find(part => /user_id/.test(part)) || '').split("=")[1]
    store.dispatch({ type: VK_TOKEN_RECEIVE, payload: { token, userId } })
  }

  componentWillReceiveProps = nextProps => {
    console.log(nextProps)
    this.setState({ token: nextProps.userData.token })
  }

  render() {
    return (
      <div className="dashboard">
        <p>Пожалуйста, подождите...</p>
        <p>Токен пользователя: { this.state.token }</p>
      </div>
    )
  }
}

export default connect(state => ({
  userData: state.vkUserData,
}))(Auth)
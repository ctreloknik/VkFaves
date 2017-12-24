import React, { Component } from 'react';
import { connect } from 'react-redux'

import './Library.css.css';

class Library extends Component {
  constructor(props) {
    super(props)
    this.state = this.initState()
  }

  initState() {
    return {
      authorized: false
    }
  }

  componentWillReceiveProps(nextProps) {
    if (!isEqual(this.props, nextProps) && !isEmpty(nextProps.userData)) {
      this.setState({ authorized: true })
    }
  }

  componentWillMount() {
  }

  handleAuth() {
    handleVkLogin()
  }

  renderAuthorizedContent() {
    console.log(this.props)
    let username = this.props.userData.first_name
    return (
      <div className="dashboard-authorized">
        <h3>Добро пожаловать, {username}</h3>
      </div>
    )
  }

  render() {
    return (
      <div className="dashboard">
        { !this.state.authorized && <NonAuthorizedContent handleAuthCallback={this.handleAuth}/> }
        { this.state.authorized && this.renderAuthorizedContent() }
      </div>
    )
  }
}

export default connect(state => ({
  userData: state.vkUserData.userData,
}))(Dashboard)
import React, { Component } from 'react';
import { connect } from 'react-redux'
import { isEqual, isEmpty } from 'lodash'
import NonAuthorizedContent from "./NonAuthorizedContent";

import './Dashboard.css';

class Dashboard extends Component {
  constructor(props) {
    super(props)
    this.state = this.initState()
  }

  initState() {
    return {
      authorized: !isEmpty(this.props.userData)
    }
  }

  componentWillReceiveProps(nextProps) {
    if (!isEqual(this.props, nextProps) && !isEmpty(nextProps.userData)) {
      this.setState({ authorized: true })
    }
  }

  renderAuthorizedContent() {
    let username = this.props.userData.name
    return (
      <div className="dashboard-authorized">
        <h3>Добро пожаловать, {username}</h3>
      </div>
    )
  }

  render() {
    return (
      <div className="dashboard">
        { !this.state.authorized && <NonAuthorizedContent/> }
        { this.state.authorized && this.renderAuthorizedContent() }
      </div>
    )
  }
}

export default connect(state => ({
  userData: state.vkUserData.startUserData,
}))(Dashboard)
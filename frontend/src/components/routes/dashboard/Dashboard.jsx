import React, { Component } from 'react';
import { Button, Jumbotron } from 'react-bootstrap'
import { handleVkLogin } from "../../../core/api/vk-service";
import { connect } from 'react-redux'

import './Dashboard.css';

class Dashboard extends Component {
  constructor(props) {
    super(props)
    this.state = this.initState()
  }

  initState() {
    return {
      authorized: false
    }
  }

  componentWillMount() {
  }

  handleAuth() {
    handleVkLogin()
  }

  renderNonAuthorizedContent() {
    return (
      <div className="dashboard-non-authorized">
        <Jumbotron className="dashboard-non-authorized-jumbotron">
          <h2>Добро пожаловать в приложение VK Favorites</h2>
          <p><Button bsStyle="success" onClick={() => this.handleAuth()}>Начать работу</Button></p>
        </Jumbotron>
      </div>
    )
  }

  renderAuthorizedContent() {
    let username = this.props.vkUserData.first_name
    return (
      <div className="dashboard-authorized">
        {/* Прямо здесь и можно выводить основные вещи */}

      </div>
    )
  }

  render() {
    return (
      <div className="dashboard">
        { !this.state.authorized && this.renderNonAuthorizedContent() }
        { this.state.authorized && this.renderAuthorizedContent() }
      </div>
    )
  }
}

export default connect(state => ({
  vkUserData: state.vkUserData,
}))(Dashboard)
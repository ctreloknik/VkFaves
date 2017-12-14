import React, { Component } from 'react';
import { Button, Jumbotron } from 'react-bootstrap'
//import { connect } from 'react-redux'

import './Dashboard.css';

export default class Dashboard extends Component {
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

  renderNonAuthorizedContent() {
    return (
      <div className="dashboard-non-authorized">
        <Jumbotron className="dashboard-jumbotron">
          <h2>Добро пожаловать в приложение VK Favorites</h2>
          <p><Button bsStyle="success">Начать работу</Button></p>
        </Jumbotron>
      </div>
    )
  }

  renderAuthorizedContent() {
    return (
      <div className="dashboard-authorized">
        {/* Прямо здесь и можно выводить основные веши */}
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
import React from 'react'
import { Button, Jumbotron } from 'react-bootstrap'

const NonAuthorizedContent = ({ handleAuthCallback }) => (
  <div className="dashboard-non-authorized">
    <Jumbotron className="dashboard-non-authorized-jumbotron">
      <h2>Добро пожаловать в приложение VK Favorites</h2>
      <p><Button bsStyle="success" onClick={ handleAuthCallback }>Начать работу</Button></p>
    </Jumbotron>
  </div>
)

export default NonAuthorizedContent
import React from 'react'
import { Button, Jumbotron } from 'react-bootstrap'

const tokenVkAddr = `https://oauth.vk.com/authorize?
client_id=6226858&
display=page&
redirect_uri=https://vk-faves.herokuapp.com/auth&
scope=friends,offline&
response_type=token&
v=5.69`

const NonAuthorizedContent = () => (
  <div className="dashboard-non-authorized">
    <Jumbotron className="dashboard-non-authorized-jumbotron">
      <h2>Добро пожаловать в приложение VK Favorites</h2>
      <p><Button bsStyle="success" href={ tokenVkAddr }>Начать работу</Button></p>
    </Jumbotron>
  </div>
)

export default NonAuthorizedContent
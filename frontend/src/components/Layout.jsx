import React, { Component } from 'react';
import { Navbar, Nav, NavItem } from 'react-bootstrap'
import { Provider } from 'react-redux'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import routes from './routes'
import store from "../store";

import './Layout.css';

class Layout extends Component {
  static codeVkAddr = 'https://oauth.vk.com/authorize?client_id=6226858&display=page&redirect_uri=https://vk-faves.herokuapp.com/auth&scope=friends,offline&response_type=code&v=5.69'
  static tokenVkAddr = 'https://oauth.vk.com/authorize?client_id=6226858&display=page&redirect_uri=https://vk-faves.herokuapp.com/auth&scope=friends,offline&response_type=token&v=5.69'

  static routeMapper = (route, i) => (
    <Route
      key={i}
      path={route.path}
      exact={route.exact}
      component={route.component}
    >
      { (route.childRoutes || []).map(Layout.routeMapper) }
    </Route>
  )

  render() {
    return (
      <Router>
        <Provider store={store}>
          <div className="layout">
            <Navbar inverse className="layout-navbar">
              <Navbar.Header>
                <Navbar.Brand>
                  <a href="#">FK Favorites</a>
                </Navbar.Brand>
              </Navbar.Header>
              <Navbar.Collapse>
                <Nav>
                  <NavItem className="tmp-important" href={Layout.codeVkAddr}>Code</NavItem>
                  <NavItem className="tmp-important" href={Layout.tokenVkAddr}>Token</NavItem>
                </Nav>
              </Navbar.Collapse>
            </Navbar>
            <div className="container body">
              { routes.map(Layout.routeMapper) }
            </div>
          </div>
        </Provider>
      </Router>
    );
  }
}

export default Layout;

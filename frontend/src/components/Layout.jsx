import React, { Component } from 'react';
import { Navbar } from 'react-bootstrap'
import { BrowserRouter as Router, Route, NavLink } from 'react-router-dom'
import routes from './routes'

import './Layout.css';

class Layout extends Component {
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
        <div className="layout">
          <Navbar inverse>
            <Navbar.Header>
              <Navbar.Brand>
                <a href="#">FK Favorites</a>
              </Navbar.Brand>
            </Navbar.Header>
          </Navbar>
          <div className="container body">
            { routes.map(Layout.routeMapper) }
          </div>
        </div>
      </Router>
    );
  }
}

export default Layout;

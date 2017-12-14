import React, { Component } from 'react';
import { Navbar } from 'react-bootstrap'
import { Provider } from 'react-redux'
import { BrowserRouter as Router, Route, NavLink } from 'react-router-dom'
import routes from './routes'
import store from "../store";

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
        <Provider store={store}>
          <div className="layout">
            <Navbar inverse className="layout-navbar">
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
        </Provider>
      </Router>
    );
  }
}

export default Layout;

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

  componentWillMount() {
  }

  render() {
    return (
      <div className="library">
      </div>
    )
  }
}

export default connect(state => ({
  userData: state.vkUserData.userData,
}))(Library)
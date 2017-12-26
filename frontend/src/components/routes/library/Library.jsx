import React, { Component } from 'react';
import { connect } from 'react-redux'
//import { Col, Row } from 'react-bootstrap'

import './Library.css';

class Library extends Component {
  constructor(props) {
    super(props)
    this.state = this.initState()
    this.mapFave = this.mapFave.bind(this)
  }

  initState() {
    return {
      authorized: false
    }
  }

  componentWillMount() {
  }

  getImage(fave) {
    if (fave.attachment && fave.attachment.type === 'photo') {
      return fave.attachment.photo.src_big
    }
  }

  processFaveText(text) {
    let paragraphs = text.split('<br>')
    return paragraphs.map((par, i) => (
      <p className="fave-paragraph" key={i}>
        { par }
      </p>
    ))
  }

  mapFave(fave, index) {
    let image = this.getImage(fave)
    return (
      <div key={index} className="fave-item">
        { fave.text && (
            <div className="fave-text-value" style={ image && { marginBottom: '1.5em' } }>
              { this.processFaveText(fave.text) }
            </div>
          )
        }
        { image && (
          <div className="fave-image">
            <img src={ image } alt={ fave.text }/>
          </div>
          )
        }
      </div>
    )
  }

  render() {
    return (
      <div className="library container">
        <div className="library-faves">
          { this.props.data.faves.map(this.mapFave) }
        </div>
      </div>
    )
  }
}

export default connect(state => ({
  data: state.faves,
}))(Library)
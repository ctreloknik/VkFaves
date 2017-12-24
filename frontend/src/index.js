import React from 'react';
import ReactDOM from 'react-dom';
import Layout from './components/Layout';
import registerServiceWorker from './registerServiceWorker';
import { initUserData } from "./core/api/vk-service";

import 'bootstrap/dist/css/bootstrap.min.css'
import './index.css';

initUserData()
ReactDOM.render(<Layout />, document.getElementById('root'))

try {
  registerServiceWorker();
} catch (err) {
  // do nothing
}
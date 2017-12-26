import Dashboard from './dashboard/Dashboard'
import Library from './library/Library'

const routes = [
  {
    path: '/',
    exact: true,
    component: Dashboard
  },
  {
    path: '/library',
    component: Library
  }
]

export default routes
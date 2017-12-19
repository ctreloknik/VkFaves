import Dashboard from './dashboard/Dashboard'
import Auth from "./auth/Auth";

const routes = [
  {
    path: '/',
    exact: true,
    component: Dashboard
  },
  {
    path: '/auth',
    component: Auth
  }
]

export default routes
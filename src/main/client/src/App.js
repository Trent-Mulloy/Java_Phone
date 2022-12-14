import 'bootstrap/dist/css/bootstrap.min.css';
import { Switch, Route } from 'react-router-dom';
import './App.css';
import NavBar from './components/NavBar';
import Cart from './views/Cart';
import Devices from './views/Devices';
import Home from './views/Home';
import OneDevice from './views/OneDevice';
import Plans from './views/Plans';
import AddUser from './views/AddUser';

function App()
{
  return (
    <div className="App">
      <NavBar/>
      <Switch>
        <Route exact path="/">
          <Home/>
        </Route>
        <Route exact path="/devices">
          <Devices/>
        </Route>
        <Route exact path="/plans">
          <Plans/>
        </Route>
        <Route exact path="/view/cart">
          <Cart/>
        </Route>
        <Route path="/device/:id">
          <OneDevice/>
        </Route>
        <Route exact path="/new/user">
          <AddUser/>
        </Route>
      </Switch>
    </div>
  );
}

export default App;

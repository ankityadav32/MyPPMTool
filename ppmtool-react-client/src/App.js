import React from 'react';
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/layout/Header';
import {BrowserRouter as Router,Route} from 'react-router-dom'
import AddProject from './components/Project/AddProject';
import {Provider} from 'react-redux'
import store from './store'

function App() {
  return (
    <Provider store={store}>
    <Router>
    <div className="App">
      <Header/>
      <Route exact path="/Dashboard" component={Dashboard}/>
      <Route exact path="/AddProject" component ={AddProject} />
    </div>
    </Router>
    </Provider>
  );
}

export default App;

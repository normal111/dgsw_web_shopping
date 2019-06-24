import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import {Provider} from "mobx-react";

import Menu from './Menu';
import Home from './Home';
import './App.scss';
import Join from "./Join";
import Products from "./Products";
import Login from "./Login";

import Stores from './Stores';

function App() {
    return (
        <Provider stores={Stores}>
            <BrowserRouter>
                <header className='app-header'>
                    <Menu/>
                </header>

                <section className='app-body'>
                    <Route path='/' exact component={Home}/>
                    <Route path='/login' component={Login}/>
                    <Route path='/join' component={Join}/>
                    <Route path='/category/:id' component={Products}/>
                </section>
            </BrowserRouter>
        </Provider>
    );
}

export default App;

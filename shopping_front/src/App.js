import React from 'react';
import {BrowserRouter, Route, Link} from 'react-router-dom';
import {Provider} from "mobx-react";

import Home from './Home';
import './App.scss';
import Join from "./Join";

function App() {
    return (
        <Provider>
            <BrowserRouter>
                <header className='app-header'>
                    <ul className='menubar'>
                        <li><Link className='menuitem' to="/">Home</Link></li>
                    </ul>
                </header>

                <section className='app-body'>
                    <Route path='/' exact component={Home}/>
                    <Route path='/join' component={Join}/>
                </section>
            </BrowserRouter>
        </Provider>
    );
}

export default App;

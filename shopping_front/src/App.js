import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import {Provider} from "mobx-react";

import Menu from './Menu';
import Home from './Home';
import './App.scss';
import Join from "./Join";
import Cart from "./Cart";
import Product from "./Product";
import Category from "./Category";
import CategoryBar from "./Category/CategoryBar";
import Login from "./Login";

import Stores from './Stores';

function App() {
    return (
        <Provider stores={Stores}>
            <BrowserRouter>
                <header className='app-header'>
                    <Menu className='menu'/>
                    <div className='site-name'>DGSW Fashion</div>
                    <CategoryBar/>
                </header>

                <section className='app-body'>
                    <Route path='/' exact component={Home}/>
                    <Route path='/login' component={Login}/>
                    <Route path='/join' component={Join}/>
                    <Route path='/cart' component={Cart}/>
                    <Route path='/category/:category_id?' component={Category}/>
                    <Route path='/product/:product_id?' component={Product}/>
                </section>
            </BrowserRouter>
        </Provider>
    );
}

export default App;

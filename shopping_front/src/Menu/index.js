import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {inject, observer} from "mobx-react";

import './Menu.scss';

import Login from '../Login';

@inject('stores')
@observer
class Menu extends Component {
    render() {
        if (this.props.stores.UserStore.current_user == null) {
            return (
                <div className='menu-bar'>
                    <Link className='menu-item' to="/">Home</Link>
                    <div className='menu-item cursor-pointer' onClick={this.login_on}>Login</div>
                    <Link className='menu-item' to="/join">Join</Link>
                    <div id='login-container' className='login-container'>
                        <Login />
                    </div>
                </div>
            );
        } else {
            return (
                <div className='menu-bar'>
                    <Link className='menu-item' to="/">Home</Link>
                    <Link className='menu-item' to="/cart">Cart</Link>
                    <div className='menu-item cursor-pointer' onClick={this.logout}>Logout</div>
                </div>
            );
        }
    }

    login_on = ()=> {
        let login = document.getElementById('login-container');
        login.style.display = 'flex';
    };

    logout = () => {
        this.props.stores.UserStore.logout();
        alert("로그아웃");
    };
}

// <div>
//     <div>{this.props.stores.UserStore.current_user.name}님 환영합니다</div>
//     <button onClick={this.logout}>로그아웃</button>
// </div>

export default Menu;
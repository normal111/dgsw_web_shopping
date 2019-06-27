import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {inject, observer} from "mobx-react";

import './Menu.scss';

@inject('stores')
@observer
class Menu extends Component {
    render() {
        if (this.props.stores.UserStore.current_user == null) {
            return (
                <ul className='menu-bar'>
                    <li className='menu-item' ><Link to="/">Home</Link></li>
                    <li className='menu-item' ><Link to="/login">로그인</Link></li>
                    <li className='menu-item' ><Link to="/join">회원가입</Link></li>
                </ul>
            );
        } else {
            return (
                <ul className='menu-bar'>
                    <li className='menu-item' ><Link to="/">Home</Link></li>
                    <li className='menu-item' ><Link to="/cart">장바구니</Link></li>
                    <li className='menu-item' ><span onClick={this.logout}>로그아웃</span></li>
                </ul>
            );
        }
    }

    logout = () => {
        this.props.stores.UserStore.logout();
        alert("로그아웃");
    }
}

// <div>
//     <div>{this.props.stores.UserStore.current_user.name}님 환영합니다</div>
//     <button onClick={this.logout}>로그아웃</button>
// </div>

export default Menu;
import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {inject, observer} from "mobx-react";

@inject('stores')
@observer
class Home extends Component {

    render() {

        if (this.props.stores.UserStore.current_user == null) {
            return (
                <div>
                    <button><Link to='/login'>로그인</Link></button>
                    <button><Link to='/join'>회원가입</Link></button>
                </div>
            );
        } else {
            return (
                <div>
                    <div>{this.props.stores.UserStore.current_user.name}님 환영합니다</div>
                    <button onClick={this.logout}>로그아웃</button>
                </div>
            );
        }
    }

    logout = () => {
        this.props.stores.UserStore.logout();
    }

}

export default Home;
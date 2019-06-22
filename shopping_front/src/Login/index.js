import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Redirect} from 'react-router-dom';

@inject('stores')
@observer
class Login extends Component {

    state = {
        id: '',
        password: '',
        goToMain: false
    };

    render() {
        if (this.state.goToMain)
            return <Redirect to='/'/>;

        return (
            <div>
                <input id="id" type="text" placeholder="id" onChange={this.updateId}/><br/>
                <input id="password" type="password" placeholder="password" onChange={this.updatePassword}/><br/>
                <button onClick={this.login}>로그인</button>
            </div>
        );
    }

    login = async () => {
        let result = await this.props.stores.UserStore.loginUser(this.state);
        if(result === true){
            alert("로그인 성공");
            this.setState({goToMain: true});
        }else{
            alert("로그인 실패");
        }
    };

    updateId = event => {
        this.setState({
            ...this.state,
            id: event.target.value
        });
    };

    updatePassword = event => {
        this.setState({
            ...this.state,
            password: event.target.value
        });
    };
}

export default Login;
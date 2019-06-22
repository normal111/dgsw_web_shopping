import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Redirect} from 'react-router-dom';

@inject('stores')
@observer
class Join extends Component {

    state = {
        id: '',
        password: '',
        name: '',
        phone: '',
        mobile: '',
        postal_code: '',
        address: '',
        email: '',
        goToMain: false
    };

    render() {
        if (this.state.goToMain)
            return <Redirect to='/'/>;

        return (
            <div>
                <input id="id" type="text" placeholder="id" onChange={this.updateId}/><br/>
                <input id="password" type="password" placeholder="password" onChange={this.updatePassword}/><br/>
                <input id="name" type="text" placeholder="name" onChange={this.updateName}/><br/>
                <input id="phone" type="text" placeholder="phone" onChange={this.updatePhone}/><br/>
                <input id="mobile" type="text" placeholder="mobile" onChange={this.updateMobile}/><br/>
                <input id="postal_code" type="text" placeholder="postal_code" onChange={this.updatePostal_code}/><br/>
                <input id="address" type="text" placeholder="address" onChange={this.updateAddress}/><br/>
                <input id="email" type="text" placeholder="email" onChange={this.updateEmail}/><br/>
                <button onClick={this.join}>회원가입</button>
            </div>
        );
    }

    join = async () => {
        let result = await this.props.stores.UserStore.addNewUser(this.state);
        if(result === true){
            alert("가입 성공");
            this.setState({goToMain: true});
        }else{
            alert("가입 실패");
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

    updateName = event => {
        this.setState({
            ...this.state,
            name: event.target.value
        });
    };

    updatePhone= event => {
        this.setState({
            ...this.state,
            phone: event.target.value
        });
    };

    updateMobile= event => {
        this.setState({
            ...this.state,
            mobile: event.target.value
        });
    };

    updatePostal_code= event => {
        this.setState({
            ...this.state,
            postal_code: event.target.value
        });
    };

    updateAddress= event => {
        this.setState({
            ...this.state,
            address: event.target.value
        });
    };

    updateEmail= event => {
        this.setState({
            ...this.state,
            email: event.target.value
        });
    };

}

export default Join;
import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Redirect} from 'react-router-dom';

@inject('Stores')
@observer
class Join extends Component {

    state = {
        id: '',
        password: '',
        name: '',
        goToMain: false
    };

    render() {
        if (this.state.goToMain)
            return <Redirect to='/'/>;

        return (
            <div>
                <input id="id" type="text" placeholder="id" onChange={this.updateId}/><br/>
                <input id="password" type="password" placeholder="password" onChange={this.updatePassword}/><br/>
                <input id="name" type="name" placeholder="name" onChange={this.updateName}/><br/>
                <button onClick={this.join}>회원가입</button>
            </div>
        );
    }

    addNewPost = async () => {
        await this.props.stores.UserStore.addNewPost(this.state)
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

}

export default Join;